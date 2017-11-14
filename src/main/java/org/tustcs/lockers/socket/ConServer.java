package org.tustcs.lockers.socket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.tustcs.lockers.config.Config;
import org.tustcs.lockers.utils.ReaderThread;

import org.tustcs.lockers.utils.WriterThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Airmacx on 2017/11/4.
 */
public class ConServer  {
    ServerSocket serverSocket;

    public ConServer(){
        try {
            serverSocket=new ServerSocket(Config.PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ConServer().init();
    }


    public void init() {
        while (true){
            try {
                Socket socket=serverSocket.accept();
                System.out.println("有链接");

               new ReaderThread(socket).start();
                //new WriterThread(socket).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
