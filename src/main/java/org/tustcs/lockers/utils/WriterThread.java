package org.tustcs.lockers.utils;

import com.alibaba.fastjson.JSONObject;
import org.tustcs.lockers.socket.SocketManager;

import java.io.*;
import java.net.Socket;

/**
 * Created by Airmacx on 2017/11/3.
 */
public class WriterThread  extends Thread {
    private Socket socket;

    public WriterThread(Socket socket){
        this.socket=socket;
    }


    @Override
    public void run() {

        BufferedWriter writer ;
        BufferedReader reader ;
        try {

            //String name = socket.getInetAddress().getHostAddress() + "@" + socket.getLocalPort();
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            JSONObject jsonObject=new JSONObject();

//         jsonObject.fluentPut("name","lid").fluentPut("val","lzy001").fluentPut("stat","1");
            jsonObject.put("name","msg");
            jsonObject.put("lid","lzy001");
            jsonObject.put("bid","1");
            jsonObject.put("stat","1");

            writer.write(jsonObject.toJSONString());
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }/*finally {
            IOUtils.closeCloseable(reader,writer,socket);


        }*/
    }
}

