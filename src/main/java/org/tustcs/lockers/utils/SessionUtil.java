package org.tustcs.lockers.utils;

import org.tustcs.lockers.dao.RedisDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Airmacx on 2017/11/13.
 */
public class SessionUtil {

    public void checkSession(HttpServletRequest, HttpServletResponse){
        RedisDao redisDao=SpringContextUtil.getBean()
    }
}
