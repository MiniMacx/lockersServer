package org.tustcs.lockers.config;

import redis.clients.jedis.Jedis;

/**
 * Created by Airmacx on 2017/11/8.
 */
public class Test {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("120.25.164.112",6379);
        jedis.auth("12345");

        System.out.println(jedis.ping());
        jedis.close();
    }
}
