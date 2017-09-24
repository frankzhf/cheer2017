package com.cheer.assets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheer.assets.service.AssetsService;

import net.frank.yangtes.commons.web.BaseController;


@Controller
@RequestMapping(value = "${adminPath}/assets")
public class AssetsController extends BaseController {
	
	@Autowired
	private AssetsService assetsService;
	
	@RequestMapping(value = "list")
	public String list(){
		logger.info("list method triggered !");
		assetsService.userHistory();
		
		return "modules/assets/list";
	}
	
	@RequestMapping(value = "mine")
	public String mine(){
		return "modules/assets/mine";
	}
	
	
	
}
