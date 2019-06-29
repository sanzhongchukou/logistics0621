package com.zpl.service;

import java.util.List;

import org.springframework.ui.Model;

import com.github.pagehelper.PageInfo;
import com.zpl.dto.BasicDto;
import com.zpl.pojo.BasicData;

public interface IBasicService {

	public List<BasicData> query(BasicData bd);
	
	public PageInfo<BasicData> queryPage(BasicDto dto);
	
	public void addBasicData(BasicData bd) throws Exception;
	
	public void deleteBasicData(Integer id) throws Exception;
	
	public void updateBasicData(BasicData bd) throws Exception;

	public void getUpdateBasicInfo(Integer id,Model m);
	/**
	* 根据大类名称查询对应的小类
	 * @param parentName
	 * @return
	 */
	public List<BasicData> getBasicDataByParentName(String basicCommonInterval);

}
