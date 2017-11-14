package org.tustcs.lockers.socket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.tustcs.lockers.config.Config;
import org.tustcs.lockers.entity.Users;
import org.tustcs.lockers.utils.ReaderThread;
import org.tustcs.lockers.utils.Thread1;
import org.tustcs.lockers.utils.WriterThread;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Airmacx on 2017/11/3.
 */
public class ConLocker  {
    public static void main(String[] args) throws IOException {
        new ConLocker().init();
    }

    private void init() throws IOException {
        Socket socket=new Socket("120.25.164.112", Config.PORT);
        System.out.println(socket.getInetAddress().getHostAddress()+"@"+socket.getLocalPort()+"已连接上服务器");

        new WriterThread(socket).start();
        //new ReaderThread(socket).start();
        new Thread1(socket).start();

    }
}
