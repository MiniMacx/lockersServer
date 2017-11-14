package org.tustcs.lockers.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tustcs.lockers.dao.BoxMapper;
import org.tustcs.lockers.dao.LockersBoxMapper;
import org.tustcs.lockers.dao.LockersMapper;
import org.tustcs.lockers.dto.BoxDetail;
import org.tustcs.lockers.entity.Box;
import org.tustcs.lockers.service.BoxService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Airmacx on 2017/11/5.
 */
@Service
@Transactional
public class BoxServiceImpl implements BoxService {

    @Resource
    private BoxMapper boxMapper;

    @Resource
    private LockersBoxMapper lockersBoxMapper;

    @Override
    public List<Box> getBoxList(String lockersId) {
        return boxMapper.selectByLockersId(lockersId);
    }

    @Override
    public boolean updateBoxStatus(String sign, int boxId) {
        if(sign.equals("1")){
            return lockersBoxMapper.updateUsed(1,boxId)>0;
        }else if (sign.equals("0")){
            return lockersBoxMapper.updateUsed(0,boxId)>0;
        }
        return false;
    }

    @Override
    public BoxDetail getBoxDetail(int boxId) {
        return lockersBoxMapper.selectBoxDetail(boxId);
    }
}
