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
 * Created by Airmacx on 2017/11/6.
 */
public class ServerThread extends Thread{

    ServerSocket serverSocket;

    public ServerThread(){
        try {
             serverSocket=new ServerSocket(Config.PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void destroyThread(){
        if(null != this.serverSocket && this.isInterrupted()){
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                Socket socket=serverSocket.accept();
                System.out.println("有连接");

                new ReaderThread(socket).start();
                //new WriterThread(socket).start();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
