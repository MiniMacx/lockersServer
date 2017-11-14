package org.tustcs.lockers.utils;

import com.alibaba.fastjson.JSON;
import org.tustcs.lockers.entity.Users;

import java.io.*;
import java.net.Socket;

/**
 * Created by Airmacx on 2017/11/7.
 */
public class Thread1 extends Thread {
    private Socket socket;

    public Thread1(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedWriter bw = null;
        BufferedReader br=null;
        try {

            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String content;
            while((content=br.readLine())!=null){
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
