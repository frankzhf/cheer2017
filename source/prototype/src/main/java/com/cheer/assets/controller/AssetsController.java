package com.cheer.assets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheer.assets.domain.AssetsEntity;
import com.cheer.assets.model.AssetsDetails;
import com.cheer.assets.model.AssetsForm;
import com.cheer.assets.pagination.PagingOutput;
import com.cheer.assets.service.AssetsService;

import net.frank.yangtes.commons.web.AsyncResponseData;
import net.frank.yangtes.commons.web.BaseController;
import net.frank.yangtes.modules.sys.utils.UserUtils;



@Controller
@RequestMapping(value = "${adminPath}/assets")
public class AssetsController extends BaseController {
	
	@Autowired
	private AssetsService assetsService;
	
	@RequestMapping(value = {"list",""})
	public String list(@ModelAttribute AssetsForm form,Model model){
		logger.debug("Input Param [form] -> " + form );
		if(form == null){
			form = new AssetsForm();
		}
		PagingOutput<AssetsEntity> output = assetsService.list(form);
		form.setPageInfo(output.getPageInfo());
		form.setList(output.getList());
		model.addAttribute("form", form);
		return "modules/assets/list";
	}
	
	@RequestMapping(value = "form")
	public String form(@ModelAttribute AssetsForm form,Model model){
		logger.debug("Input Param [form] -> " + form );
		form.setEditor(new AssetsEntity());
		form.getEditor().setStatus("P");
		model.addAttribute("form",form);
		return "modules/assets/form";
	}
	
	@RequestMapping(value = "save")
	public String save(@ModelAttribute AssetsForm form,Model model){
		logger.debug("Input Param [form] -> " + form );
		String operator = UserUtils.getUser().getId();
		assetsService.save(form.getEditor(), operator);
		return list(form,model);
	}
	
	@RequestMapping(value = "details")
	public String details(@RequestParam String assetsId,Model model){
		logger.debug("Input Param [assetsId] -> " + assetsId );
		AssetsDetails details = assetsService.fillAssetsDetails(assetsId);
		model.addAttribute("details",details);
		return "modules/assets/dialog/details";
	}
	
	@RequestMapping(value="status/normal",method=RequestMethod.POST)
	public @ResponseBody AsyncResponseData.ResultData statusNormal(
			@RequestParam String assetsId){
		logger.debug("Input Param [assetsId] -> " + assetsId );
		AsyncResponseData.ResultData data = AsyncResponseData.get200Response();
		String operator = UserUtils.getUser().getId();
		String status = "N";
		assetsService.status(assetsId, status, operator);
		return data;
	}
	
	@RequestMapping(value="dialog/derating",method=RequestMethod.GET)
	public String dialog(){
		return "modules/assets/dialog/derating";
	}
	
	@RequestMapping(value="finance/derating",method=RequestMethod.POST)
	public @ResponseBody AsyncResponseData.ResultData derating(
			@RequestParam String assetsId,
			@RequestParam String deratingValue
			){
		logger.debug("Input Param [assetsId] -> " + assetsId );
		logger.debug("Input Param [deratingValue] -> " + deratingValue );
		AsyncResponseData.ResultData data = AsyncResponseData.get200Response();
		String operator = UserUtils.getUser().getId();
		assetsService.derating(assetsId, deratingValue, operator);
		return data;
	}
	
	@RequestMapping(value="status/disabled",method=RequestMethod.POST)
	public @ResponseBody AsyncResponseData.ResultData statusDisabled(
			@RequestParam String assetsId){
		logger.debug("Input Param [assetsId] -> " + assetsId );
		AsyncResponseData.ResultData data = AsyncResponseData.get200Response();
		String operator = UserUtils.getUser().getId();
		String status = "D";
		assetsService.status(assetsId, status, operator);
		return data;
	}
	
	@RequestMapping(value="borrow",method=RequestMethod.POST)
	public @ResponseBody AsyncResponseData.ResultData borrow(
			@RequestParam String assetsId,
			@RequestParam String dutyId){
		logger.debug("Input Param [assetsId] -> " + assetsId );
		logger.debug("Input Param [dutyId] -> " + dutyId );
		AsyncResponseData.ResultData data = AsyncResponseData.get200Response();
		String operator = UserUtils.getUser().getId();
		//String status = "D";
		assetsService.borrow(assetsId, dutyId, operator);
		return data;
	}
	@RequestMapping(value = "mine")
	public String mine(@ModelAttribute AssetsForm form,Model model){
		if(form == null){
			form = new AssetsForm();
		}
		String operator = UserUtils.getUser().getId();
		PagingOutput<AssetsEntity> output = assetsService.mine(form,operator);
		form.setPageInfo(output.getPageInfo());
		form.setList(output.getList());
		model.addAttribute("form", form);	
		return "modules/assets/mine";
	}
	
	
	
	@RequestMapping(value="return",method=RequestMethod.POST)
	public @ResponseBody AsyncResponseData.ResultData _return(
			@RequestParam String assetsId){
		logger.debug("Input Param [assetsId] -> " + assetsId );
		AsyncResponseData.ResultData data = AsyncResponseData.get200Response();
		String operator = UserUtils.getUser().getId();
		assetsService.assetReturn(assetsId,operator);
		return data;
	}
}
