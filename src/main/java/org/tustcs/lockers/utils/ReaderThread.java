package org.tustcs.lockers.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.tustcs.lockers.service.impl.SocketService;
import org.tustcs.lockers.socket.SocketManager;

import java.io.*;
import java.net.Socket;

/**
 * Created by Airmacx on 2017/11/3.
 */
public class ReaderThread extends Thread{
    private Socket socket;

    public ReaderThread(Socket socket){
        this.socket=socket;
    }


    private ApplicationContext applicationContext=new FileSystemXmlApplicationContext("classpath:spring/spring.xml");
    SocketService socketService= (SocketService) applicationContext.getBean("socketService");

    @Override
    public void run() {
        BufferedReader br;
        BufferedWriter bw;
        try {
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String content;
            while((content=br.readLine())!=null){
                System.out.println("客户端发来的消息是："+content);
                JSONObject jsonObject= JSON.parseObject(content);
                switch (jsonObject.getString("name")){
                    case "lid":
                        System.out.println("放入socket池");
                        SocketManager.socketMap.put(jsonObject.getString("val"),socket);
                        System.out.println(SocketManager.socketMap.toString());
                        JSONObject resp=new JSONObject();
                        resp.fluentPut("name","msg").
                                fluentPut("lid",jsonObject.getString("val")).
                                fluentPut("stat","1");
                        bw.write(resp.toJSONString());
                        bw.newLine();
                        bw.flush();
                        break;
                    case "msg":

                        String lockersId=jsonObject.getString("lid");
                        Integer id=Integer.valueOf(jsonObject.getString("bid"));
                        String sign=jsonObject.getString("stat");

                        if(SocketManager.socketMap.get(lockersId)!=null){
                            socketService.updateStatus(lockersId,id,sign);
                        }
                        break;
                    default:
                        bw.write("消息格式错误");
                        bw.newLine();
                        bw.flush();
                }



            }
        } catch (IOException e) {
            e.printStackTrace();
        }/* finally {
            System.out.println("??");
            IOUtils.closeCloseable(br,socket);
        }*/

    }
}
