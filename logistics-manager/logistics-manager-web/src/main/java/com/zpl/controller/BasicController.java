package com.zpl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.zpl.dto.BasicDto;
import com.zpl.pojo.BasicData;
import com.zpl.service.IBasicService;

@Controller
@RequestMapping("/basic")
public class BasicController {

	@Autowired
	private IBasicService basicService;

	@RequestMapping("/query")
	public String queryPage(BasicDto dto, Model m) {
		PageInfo<BasicData> pageInfo = basicService.queryPage(dto);
		m.addAttribute("pageModel", pageInfo);
		return "basic/basic";
	}
	@RequestMapping("/basicUpdate")
	public String basicUpdatePage(Integer id, Model m){
		basicService.getUpdateBasicInfo(id,m);
		return "basic/basicUpdate";
	}
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(BasicData bd) throws Exception{
		if(bd.getParentId()==0){
			bd.setParentId(null);
		}
		if(bd.getBaseId()!=null && bd.getBaseId() > 0){
			// 表示更新数据
			basicService.updateBasicData(bd);
		}else{
			// 表示添加数据
			basicService.addBasicData(bd);
		}
		return "redirect:/basic/query";
	}
	@RequestMapping("/delete")
	public String delete(Integer id)throws Exception{
		basicService.deleteBasicData(id);
		return "redirect:/basic/query";
	}
}
