package com.hcfa.material.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import com.hcfa.material.vo.Units;

@Mapper
public interface UnitsMapper {

    int deleteByPrimaryKey(Long rkey);

    int insert(Units record);

    int insertSelective(Units record);

    Units selectByPrimaryKey(Long rkey);

    int updateByPrimaryKeySelective(Units record);

    int updateByPrimaryKey(Units record);
    
    List<Units> getUnits();
}