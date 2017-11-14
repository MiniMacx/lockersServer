package org.tustcs.lockers.service;

import org.tustcs.lockers.dto.BoxDetail;
import org.tustcs.lockers.entity.Box;

import java.util.List;

/**
 * Created by Airmacx on 2017/11/4.
 */
public interface BoxService {
    List<Box> getBoxList(String lockersId);

    boolean updateBoxStatus(String sign,int boxId);

    BoxDetail getBoxDetail(int boxId);


}
