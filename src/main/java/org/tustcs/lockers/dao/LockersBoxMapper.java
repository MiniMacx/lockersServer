package org.tustcs.lockers.dao;

import org.apache.ibatis.annotations.Param;
import org.tustcs.lockers.dto.BoxDetail;
import org.tustcs.lockers.entity.Box;
import org.tustcs.lockers.entity.LockersBox;

import java.util.List;

public interface LockersBoxMapper {
    int insert(LockersBox record);

    int insertSelective(LockersBox record);

    int updateUsed(@Param("status") int status,@Param("boxId") int boxId);

    BoxDetail selectBoxDetail(@Param("boxId") int boxId);

    List<LockersBox> selectByLockersId(String lockersId);

    int selectBoxId(@Param("lockersId") String lockersId,@Param("id") int id);
}