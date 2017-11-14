package org.tustcs.lockers.dao;

import org.tustcs.lockers.entity.Box;

import java.util.List;

public interface BoxMapper {
    int deleteByPrimaryKey(Integer boxId);

    int insert(Box record);

    int insertSelective(Box record);

    Box selectByPrimaryKey(Integer boxId);

    int updateByPrimaryKeySelective(Box record);

    int updateByPrimaryKey(Box record);

    List<Box> selectByLockersId(String lockersId);
}