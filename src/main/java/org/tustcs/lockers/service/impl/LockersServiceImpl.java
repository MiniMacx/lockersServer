package org.tustcs.lockers.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tustcs.lockers.dao.LockersMapper;
import org.tustcs.lockers.entity.Lockers;
import org.tustcs.lockers.service.LockersService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Airmacx on 2017/11/5.
 */
@Service
@Transactional
public class LockersServiceImpl implements LockersService {

    @Resource
    LockersMapper lockersMapper;

    @Override
    public List<Lockers> getAll() {
        return lockersMapper.selectAll();
    }

    @Override
    public Lockers getByLockersId(String lockersId) {
        return lockersMapper.selectByLockersId(lockersId);
    }

    @Override
    public List<Lockers> getByAddr(String addr) {
        return lockersMapper.selectByAddr(addr);
    }

    @Override
    public boolean updateBoxUsed(String sign, String lockersId) {

        if (sign.equals("1")){
            return lockersMapper.addUsedNum(lockersId)>0;
        }else if(sign.equals("0")){
            return lockersMapper.minusUsedNum(lockersId)>0;
        }
        return false;
    }
}
