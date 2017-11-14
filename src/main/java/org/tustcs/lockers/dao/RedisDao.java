package org.tustcs.lockers.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Airmacx on 2017/11/13.
 */

@Component
public class RedisDao {

    @Autowired
    private JedisPool jedisPool;


    public String add3rdSession(String openId,String sessionKey) throws IOException {
        Process process = Runtime.getRuntime().exec("head -n 80 /dev/urandom | tr -dc A-Za-z0-9 | head -c 168");
        BufferedReader br=new BufferedReader(new InputStreamReader(process.getInputStream()));
        String sessionVal=br.readLine();
        String text=openId+":"+sessionKey;
        Jedis jedis=jedisPool.getResource();
        jedis.set(sessionVal,text);
        jedis.close();
        return sessionVal;
    }


    public boolean check3rdSession(String sessionId){
        Jedis jedis=jedisPool.getResource();
        boolean flag=false;
        if(jedis.get(sessionId)!=null){
            flag=true;
        }
        jedis.close();
        return flag;
    }

    public void setKey(String lockersId,String id){
        Jedis jedis=jedisPool.getResource();
        String key=lockersId+":"+id;
        String val=String.valueOf(Math.random()*(9999-1000-1)+1000);
        jedis.set(key,val);
        jedis.close();
    }

    public String getKey(String lockersId,String id){
        Jedis jedis=jedisPool.getResource();
        String val=jedis.get(lockersId+":"+id);
        jedis.close();
        return val;
    }
}
