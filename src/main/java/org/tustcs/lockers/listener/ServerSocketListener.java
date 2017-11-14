package org.tustcs.lockers.listener;

import org.springframework.web.context.support.WebApplicationContextUtils;
import org.tustcs.lockers.service.impl.SocketService;
import org.tustcs.lockers.socket.ServerThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Airmacx on 2017/11/4.
 */
public class ServerSocketListener implements ServletContextListener{

    private ServerThread serverThread;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        SocketService socketService= WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.
                getServletContext()).getBean(SocketService.class);
       serverThread=new ServerThread();
        serverThread.start();

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if(null != serverThread && serverThread.isInterrupted()){
            serverThread.destroyThread();
            serverThread.interrupt();
        }

    }
}
