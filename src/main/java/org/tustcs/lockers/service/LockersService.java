package org.tustcs.lockers.service;

import org.tustcs.lockers.entity.Lockers;

import java.util.List;

/**
 * Created by Airmacx on 2017/11/4.
 */
public interface LockersService {
    List<Lockers> getAll();

    Lockers getByLockersId(String lockersId);

    List<Lockers> getByAddr(String addr);

    boolean updateBoxUsed(String sign,String lockersId);


}
