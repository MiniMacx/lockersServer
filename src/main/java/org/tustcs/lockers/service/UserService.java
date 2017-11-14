package org.tustcs.lockers.service;

import org.tustcs.lockers.entity.Users;

import java.io.IOException;

/**
 * Created by Airmacx on 2017/11/13.
 */
public interface UserService {

    String addUser(String openId,String sessionKey) throws IOException;

}
