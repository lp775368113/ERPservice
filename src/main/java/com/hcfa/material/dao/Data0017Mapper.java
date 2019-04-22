package com.hcfa.material.dao;

import com.hcfa.material.vo.Data0017;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface Data0017Mapper {

    List<Data0017> getPage(Map map);
    
    Integer getPageCount(Map map);
}