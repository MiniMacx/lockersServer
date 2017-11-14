package org.tustcs.lockers.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tustcs.lockers.dao.LockersBoxMapper;
import org.tustcs.lockers.dao.LockersMapper;
import org.tustcs.lockers.entity.Lockers;
import org.tustcs.lockers.entity.LockersBox;
import org.tustcs.lockers.socket.SocketManager;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by Airmacx on 2017/11/5.
 */
@Service
@Transactional
public class SocketService {

    @Resource
    private LockersBoxMapper lockersBoxMapper;

    @Resource
    private LockersMapper lockersMapper;


    public boolean lock(String lockersId,int id,String sign) throws IOException {
        Socket socket=SocketManager.socketMap.get(lockersId);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","bid");
        jsonObject.put("val",String.valueOf(id));
        if(sign.equals("1")){
            jsonObject.put("stat","1");
        }
        else if (sign.equals("0")){
            jsonObject.put("stat","0");
        }else {
            return false;
        }
        bw.write(jsonObject.toJSONString());
        bw.newLine();
        bw.flush();
        bw.close();
        return true;
    }

    public boolean checkLockersId(String lockersId){
        return lockersMapper.selectByLockersId(lockersId) == null;
    }

    public boolean updateStatus(String lockersId,int id,String sign){
        int boxId=lockersBoxMapper.selectBoxId(lockersId,id);
        if(sign.equals("1")){
            return lockersBoxMapper.updateUsed(1,boxId)>0 && lockersMapper.addUsedNum(lockersId)>0;
        }else if (sign.equals("0")){
            return lockersBoxMapper.updateUsed(0,boxId)>0 && lockersMapper.minusUsedNum(lockersId)>0;
        }

        return false;

    }
}
