/**
 * <p>Title: DialogController.java</p>
 * <p>Description: 公共对话框控制器</p>
 */
package net.frank.yangtes.prototype.dialog;

import java.util.List;
import java.util.Map;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.frank.yangtes.commons.web.BaseController;
import net.frank.yangtes.modules.sys.entity.Area;
import net.frank.yangtes.modules.sys.service.AreaService;
import net.frank.yangtes.prototype.Constant;




/**
 * @author zhao
 * @date 2017-02-23 16:49:08
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified				
 *				
 * -------------------------------------------------------------------------
 */
@Controller
public class AreaDialogController extends BaseController {
	@Autowired
	private AreaService areaService;
	/**
     * <p>Title: getArea</p>
     * <p>Description:获取地区详情</p>
     * @param areaId String
     * @return Area
     */
	@RequestMapping(value = "${adminPath}/dialog/area/get",method=RequestMethod.GET)
	public @ResponseBody Area getArea(@RequestParam("areaId")String areaId){
		logger.debug("Input Param [areaId] -> " + areaId);
		Area area = null;
		if(StringUtils.isNotBlank(areaId)){
			area = areaService.get(areaId);	
		}
		if(area==null){
			logger.error("Not find any area info.");
			area = new Area();
			area.setName(Constant.UNDEFINE_AREA);
			return area;
		}
		return area;
	}
	
	@RequestMapping(value = "${adminPath}/dialog/areaselect")
	public String dialogArea(
			@RequestParam(value="selectId",required=false)String selectId,
			@RequestParam(value="scope",required=false)String scope,
			
			Model model) {
		logger.debug("Input Param [selectId] -> " + selectId);
		logger.debug("Input Param [scope] -> " + scope);
		if(StringUtils.isNotBlank(selectId)){
			Area selectArea = areaService.get(selectId);
			model.addAttribute("selectArea", selectArea);
		}
		if(StringUtils.isBlank(scope)){
			scope = Constant.AREA.CITY;
		}
		model.addAttribute("scope", scope);
		return "dialog/areaTreeSelector";
	}
	
	@RequestMapping(value = "${adminPath}/dialog/area/tree")
	public @ResponseBody List<Map<String, Object>> topAreaChildren() {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Area> list = areaService.findAll();
		for (int i=0; i<list.size(); i++){
			Area e = list.get(i);
			if(Constant.AREA.COUNTRY.equals(e.getType()) || 
					Constant.AREA.STATE.equals(e.getType())){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
	
	@RequestMapping(value = "${adminPath}/dialog/area/tree/children/{areaId}")
	public @ResponseBody List<Map<String, Object>> areaChilddren(@PathVariable("areaId") String areaId) {
		logger.debug("Input Param [areaId] -> " + areaId);
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Area> list = areaService.findAll();
		for (int i=0; i<list.size(); i++){
			Area e = list.get(i);
			if(areaId.equals(e.getParent().getId())){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
	
	
	
}

