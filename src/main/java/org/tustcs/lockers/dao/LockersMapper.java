package org.tustcs.lockers.dao;

import org.tustcs.lockers.entity.Lockers;

import java.util.List;

public interface LockersMapper {
    int deleteByPrimaryKey(String lockersId);

    int insert(Lockers record);

    int insertSelective(Lockers record);

    Lockers selectByPrimaryKey(String lockersId);

    int updateByPrimaryKeySelective(Lockers record);

    int updateByPrimaryKey(Lockers record);

    List<Lockers> selectAll();

    Lockers selectByLockersId(String lockersId);

    List<Lockers> selectByAddr(String addr);

    int addUsedNum(String lockersId);

    int minusUsedNum(String lockersId);
}