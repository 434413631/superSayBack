package com.superSay.contextListener;

import com.superSay.Thread.ServerThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * Author:wang jian
 * Date: 13-7-11
 * Time: 下午8:08
 */
public class contextListener implements ServletContextListener {
    ServerThread st = null;//声明服务器线程的引用
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().log("[ytl] Context Initialized...");
        System.out.println("[ytl] Context Initialized...");
        st = new ServerThread();//创建服务线程
        st.start();//启动服务线程.
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().log("[ytl] Context Destroyed...");
        System.out.println("[ytl] Context Destroyed...");
        st.setFlag(false);//停止服务线程
    }
}
