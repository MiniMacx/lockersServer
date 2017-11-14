package org.tustcs.lockers.controller;

import org.tustcs.lockers.socket.SocketManager;

/**
 * Created by Airmacx on 2017/11/7.
 */
public class Test1 {
    public static void main(String[] args) {
        String s="asd受到啊";
        System.out.println(s.substring(0,s.indexOf("d")));
        System.out.println(SocketManager.socketMap.get("1"));
    }
}
