package com.cheer.assets.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheer.assets.domain.AssetsCategroyEntity;
import com.cheer.assets.service.AssetsCategroyService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.frank.yangtes.commons.web.BaseController;
import net.frank.yangtes.modules.sys.utils.UserUtils;

@Controller
@RequestMapping(value = "${adminPath}/assets/category")
public class AssetsCategroyController extends BaseController {
	
	@Autowired
	private AssetsCategroyService service;
	
	@RequestMapping(value = {"","list"})
	public String list(Model model){
		List<AssetsCategroyEntity> list = service.all();
		model.addAttribute("list", list);
		return "modules/assets/category/list";
	}
	
	@RequestMapping(value = "form")
	public String form(@RequestParam(required = false) String id,
			@RequestParam(required = false) String parentId ,Model model){
		logger.debug("InputParam [id] -> " + id);
		logger.debug("InputParam [parentId] -> " + parentId);
		AssetsCategroyEntity entity = null;
		
		if(StringUtils.isNotEmpty(id)){
			logger.debug("This request is modify");
			entity = service.get(id);
		}else if(StringUtils.isNotEmpty(parentId)){
			logger.debug("This request is create by specify parent");
			entity = new AssetsCategroyEntity();
			entity.setParentId(parentId);
		}else{
			logger.debug("This request is create");
			entity = new AssetsCategroyEntity();
			entity.setParentId(service.getDefaultParent().getId());
		}
		AssetsCategroyEntity parent = service.get(entity.getParentId());
		model.addAttribute("entity", entity);
		model.addAttribute("parent", parent);
		return "modules/assets/category/form";
	}
	
	@RequestMapping(value = "save")
	public String save(AssetsCategroyEntity entity,Model model){
		logger.debug("InputParam [entity] -> " + entity);
		AssetsCategroyEntity parent = service.get(entity.getParentId());
		service.save(entity, parent, UserUtils.getUser().getId());
		model.addAttribute("message", "操作成功");
		return list(model);
	}
	
	@RequestMapping(value = "delete")
	public String delete(String id,Model model){
		logger.debug("InputParam [id] -> " + id);
		
		
		
		
		model.addAttribute("message", "操作成功");
		return list(model);
	}
	
	
	
	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<AssetsCategroyEntity> list = service.all();
		for (int i=0; i<list.size(); i++){
			AssetsCategroyEntity e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
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
