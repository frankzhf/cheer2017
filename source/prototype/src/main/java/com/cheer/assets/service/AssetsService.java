package com.cheer.assets.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cheer.assets.domain.AssetsEntity;
import com.cheer.assets.domain.AssetsEntityExample;
import com.cheer.assets.domain.AssetsFinanceRecordEntity;
import com.cheer.assets.domain.AssetsFinanceRecordEntityExample;
import com.cheer.assets.domain.AssetsTransferRecordEntity;
import com.cheer.assets.domain.UserAssetsEntity;
import com.cheer.assets.mapper.AssetsCategroyEntityMapper;
import com.cheer.assets.mapper.AssetsEntityMapper;
import com.cheer.assets.mapper.AssetsFinanceRecordEntityMapper;
import com.cheer.assets.mapper.AssetsTransferRecordEntityMapper;
import com.cheer.assets.mapper.UserAssetsEntityMapper;
import com.cheer.assets.model.AssetsDetails;
import com.cheer.assets.model.AssetsForm;
import com.cheer.assets.model.AssetsTransferExt;
import com.cheer.assets.model.CategroyCnt;
import com.cheer.assets.pagination.PaginationCallback;
import com.cheer.assets.pagination.PaginationUtil;
import com.cheer.assets.pagination.PagingOutput;

import net.frank.commons.util.ObjectUtil;
import net.frank.yangtes.commons.service.BaseService;
import net.frank.yangtes.modules.sys.dao.UserDao;
import net.frank.yangtes.modules.sys.entity.User;


@Service
public class AssetsService extends BaseService {
	
	@Autowired
	private AssetsEntityMapper assetsMapper;
	@Autowired
	private AssetsCategroyEntityMapper assetsCategroyMapper;
	@Autowired
	private AssetsFinanceRecordEntityMapper financeMapper;
	@Autowired
	private AssetsTransferRecordEntityMapper transferMapper;
	@Autowired
	private UserAssetsEntityMapper userAssetMapper;
	@Autowired
	private UserDao userDao;
	
	public void viewMaintain(){
		
	}
	
	public void userHistory(){
		logger.info("AssetsService.userHistory() triggered!");
	}
	
	public void deprecition(){
		
	}

	public PagingOutput<AssetsEntity> list(AssetsForm form) {
		return PaginationUtil.processPaging(form, new PaginationCallback<AssetsEntity>() {
			@Override
			public List<AssetsEntity> doProcess() {
				AssetsEntityExample example = new AssetsEntityExample();
				example.createCriteria().andDelFlagEqualTo("0");
				return assetsMapper.selectByExample(example);
			}
		});
	}
	
	@Transactional
	public void save(AssetsEntity entity,String operator){
		Date current = new Date();
		CategroyCnt cntInfo = assetsCategroyMapper.preparePreCnt(entity.getCategoryId());
		logger.debug("Varible [cntInfo] -> " + cntInfo);
		//K-PC-0000001
		String bnsId = "K-" + cntInfo.getBnsPre() + "-" +   StringUtils.leftPad(( (cntInfo.getCnt()+1) + ""), 7, "0");
		logger.debug("Varible [bnsId] -> " + bnsId);
		entity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		entity.setBnsId(bnsId);
		entity.setCreateBy(operator);
		entity.setCreateDate(current);
		entity.setDelFlag("0");
		assetsMapper.insert(entity);
	}
	
	@Transactional
	public void status(String assetsId, String status, String operator){
		Date current = new Date();
		AssetsEntity entity =  assetsMapper.selectByPrimaryKey(assetsId);
		entity.setStatus(status);
		entity.setUpdateDate(current);
		entity.setUpdateBy(operator);
		assetsMapper.updateByPrimaryKey(entity);
		if("N".equals(status)){
			AssetsFinanceRecordEntity fe = new AssetsFinanceRecordEntity();
			fe.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			fe.setAssetsId(assetsId);
			fe.setDesc("资产购置");
			fe.setType("I");
			fe.setBeforeVal(BigDecimal.ZERO);
			fe.setTurnover(entity.getSellPrice());
			fe.setAfterVal(fe.getBeforeVal().add(fe.getTurnover()));
			fe.setCreateDate(current);
			fe.setCreateBy(operator);
			financeMapper.insert(fe);
		}else if("D".equals(status)){
			AssetsFinanceRecordEntityExample example = new AssetsFinanceRecordEntityExample();
			example.createCriteria().andAssetsIdEqualTo(assetsId);
			example.setOrderByClause("create_date desc");
			List<AssetsFinanceRecordEntity> financeList = financeMapper.selectByExample(example);
			if(financeList!=null && !financeList.isEmpty()){
				AssetsFinanceRecordEntity lastFinance = financeList.get(0);
				AssetsFinanceRecordEntity fe = new AssetsFinanceRecordEntity();
				fe.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				fe.setAssetsId(assetsId);
				fe.setDesc("资产报废");
				fe.setType("O");
				fe.setBeforeVal(lastFinance.getAfterVal());
				fe.setTurnover(lastFinance.getAfterVal());
				fe.setAfterVal(BigDecimal.ZERO);
				fe.setCreateDate(current);
				fe.setCreateBy(operator);
				financeMapper.insert(fe);
			}
		}
	}
	
	@Transactional
	public void derating(String assetsId, String deratingValue, String operator) {
		Date current = new Date();
		AssetsFinanceRecordEntityExample example = new AssetsFinanceRecordEntityExample();
		example.createCriteria().andAssetsIdEqualTo(assetsId);
		example.setOrderByClause("create_date desc");
		List<AssetsFinanceRecordEntity> financeList = financeMapper.selectByExample(example);
		if(financeList!=null && !financeList.isEmpty()){
			AssetsFinanceRecordEntity lastFinance = financeList.get(0);
			AssetsFinanceRecordEntity fe = new AssetsFinanceRecordEntity();
			fe.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			fe.setAssetsId(assetsId);
			fe.setDesc("资产折旧");
			fe.setType("O");
			fe.setBeforeVal(lastFinance.getAfterVal());
			fe.setTurnover(new BigDecimal(deratingValue));
			fe.setAfterVal(lastFinance.getAfterVal().subtract(fe.getTurnover()));
			fe.setCreateDate(current);
			fe.setCreateBy(operator);
			financeMapper.insert(fe);
		}
	}
	
	@Transactional
	public void borrow(String assetsId, String dutyId, String operator) {
		User dutyUser = userDao.get(dutyId);
		if(dutyUser!=null){
			Date current = new Date();
			AssetsEntity entity =  assetsMapper.selectByPrimaryKey(assetsId);
			if(entity!=null){
				AssetsTransferRecordEntity transfer = new AssetsTransferRecordEntity();
				transfer.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				transfer.setAssetsId(entity.getId());
				transfer.setUserId(dutyUser.getId());
				transfer.setDesc("资产出借");
				transfer.setCreateBy(operator);
				transfer.setCreateDate(current);
				transferMapper.insert(transfer);
				
				entity.setDutyBy(dutyId);
				entity.setUpdateBy(operator);
				entity.setUpdateDate(current);
				assetsMapper.updateByPrimaryKey(entity);
				
				UserAssetsEntity userAssets = new UserAssetsEntity();
				userAssets.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				userAssets.setUserId(dutyId);
				userAssets.setAssetsId(assetsId);
				userAssets.setStartDate(current);
				userAssets.setCreateDate(current);
				userAssets.setCreateBy(operator);
				userAssets.setDelFlag("0");
				
				userAssetMapper.insert(userAssets);
			}
		}
	}
	
	public AssetsDetails fillAssetsDetails(String assetsId){
		AssetsEntity entity = assetsMapper.selectByPrimaryKey(assetsId);
		AssetsDetails assetsDetails = new AssetsDetails();
		ObjectUtil.preparePreperties(assetsDetails, entity);
		AssetsFinanceRecordEntityExample example = new AssetsFinanceRecordEntityExample();
		example.createCriteria().andAssetsIdEqualTo(assetsId);
		example.setOrderByClause("create_date asc");
		List<AssetsFinanceRecordEntity> financeList = financeMapper.selectByExample(example);
		assetsDetails.setFinanceRecordList(financeList);
		List<AssetsTransferExt> transferExtList = transferMapper.findForAssetsId(assetsId);
		assetsDetails.setTransferRecordList(transferExtList);
		logger.debug("Return -> " + assetsDetails);
		return assetsDetails;
	}

	public PagingOutput<AssetsEntity> mine(AssetsForm form, final String operator) {
		return PaginationUtil.processPaging(form, new PaginationCallback<AssetsEntity>() {
			@Override
			public List<AssetsEntity> doProcess() {
				AssetsEntityExample example = new AssetsEntityExample();
				example.createCriteria().andDelFlagEqualTo("0")
					.andStatusEqualTo("N").andDutyByEqualTo(operator);
				return assetsMapper.selectByExample(example);
			}
		});
	}
}