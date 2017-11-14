package org.tustcs.lockers.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tustcs.lockers.dto.BoxDetail;
import org.tustcs.lockers.entity.Box;
import org.tustcs.lockers.entity.LockersBox;
import org.tustcs.lockers.entity.Log;
import org.tustcs.lockers.service.BoxService;
import org.tustcs.lockers.service.LockersService;
import org.tustcs.lockers.service.LogService;
import org.tustcs.lockers.utils.Res;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Airmacx on 2017/11/5.
 */
@Controller
@RequestMapping(value = "/use",produces = {"application/json;charset=UTF-8"})
public class UseController {

    @Resource
    LogService logService;

    @Resource
    LockersService lockersService;

    @Resource
    BoxService boxService;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/beginUse",method = RequestMethod.POST)
    @ResponseBody
    public Res genLog(int boxId,int userId){
        Res res=new Res();



        BoxDetail boxDetail=boxService.getBoxDetail(boxId);
        if(boxDetail==null){
            return res.setMsg("箱体不存在").setStatus(0);
        }

        Log log=new Log();
        log.setId(boxDetail.getId());
        log.setCreateTime(String.valueOf(new Date().getTime()));
        log.setLockerId(boxDetail.getLockersId());
        log.setMoney(0);
        log.setEndTime("使用中");
        log.setUserId(userId);

        if(logService.addLog(log)){
            return res.setStatus(1).setMsg("success");
        }
        return res.setStatus(0).setMsg("failed");

    }


}
