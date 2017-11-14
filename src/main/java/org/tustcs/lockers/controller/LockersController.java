package org.tustcs.lockers.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tustcs.lockers.dto.BoxDetail;
import org.tustcs.lockers.entity.Box;
import org.tustcs.lockers.entity.Lockers;
import org.tustcs.lockers.entity.Log;
import org.tustcs.lockers.service.BoxService;
import org.tustcs.lockers.service.LockersService;
import org.tustcs.lockers.service.LogService;
import org.tustcs.lockers.utils.Res;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Airmacx on 2017/11/4.
 */
@Controller
@RequestMapping(value = "/lockers",produces = {"application/json;charset=UTF-8"})
public class LockersController {
    @Resource
    BoxService boxService;

    @Resource
    LockersService lockersService;

    @Resource
    LogService logService;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/queryLockers",method = RequestMethod.POST)
    @ResponseBody
    public Res queryLockers(){
        Res res=new Res();

        List<Lockers> lockersList=lockersService.getAll();

        if(lockersList.size()>0){
            return res.setData(lockersList).setMsg("lockersList").setStatus(1);
        }

        return res.setMsg("null lockers").setStatus(0);
    }


    @RequestMapping(value = "/queryByLockersId",method = RequestMethod.POST)
    @ResponseBody
    public Res queryByLockersId(String lockersId){
        Res res=new Res();

        Lockers lockers=lockersService.getByLockersId(lockersId);

        if(!lockersId.equals("")){
            return res.setStatus(1).setMsg("lockers").setData(lockers);
        }

        return res.setMsg("null lockers").setStatus(0);
    }

    @RequestMapping(value = "/queryByAddr",method = RequestMethod.POST)
    @ResponseBody
    public Res queryByAddr(String addr){
        Res res=new Res();

        List<Lockers> lockersList=lockersService.getByAddr(addr);
        if(lockersList.size()>0){
            return res.setStatus(1).setMsg("lockers list").setData(lockersList);
        }

        return res.setMsg("null lockers").setStatus(0);
    }

    @RequestMapping(value = "/queryBoxByLockersId",method = RequestMethod.POST)
    @ResponseBody
    public Res queryBoxByLockersId(String lockersId){
        Res res=new Res();

        List<Box> boxList=boxService.getBoxList(lockersId);

        if(boxList.size()>0){
            return res.setStatus(1).setMsg("box list").setData(boxList);
        }

        return res.setMsg("null box").setStatus(0);
    }

    @RequestMapping(value = "/queryBoxDetail",method = RequestMethod.POST)
    @ResponseBody
    public Res queryBoxDetail(int boxId){
        Res res=new Res();

        BoxDetail box=boxService.getBoxDetail(boxId);

        if(box!=null){
            return res.setStatus(1).setMsg("boxDetail").setData(box);
        }

        return res.setMsg("null box").setStatus(0);
    }

    @RequestMapping(value = "/updateBoxStatus",method = RequestMethod.POST)
    @ResponseBody
    public Res updateBoxStatus(String sign,String lockersId,int boxId){
        Res res=new Res();

        Lockers lockers=lockersService.getByLockersId(lockersId);

        if(lockers==null){
            return res.setStatus(0).setMsg("储物柜不存在");
        }

        if(lockers.getBoxTotal() == lockers.getBoxUsed()){
            return res.setStatus(0).setMsg("已满");
        }

        if(lockers.getBoxUsed()==0){
            return res.setStatus(0).setMsg("已为0");
        }

        if(lockersService.updateBoxUsed(sign,lockersId) && boxService.updateBoxStatus(sign,boxId)){

            return res.setStatus(1).setMsg("success!");
        }
        return res.setMsg("failed").setStatus(0);
    }



}
