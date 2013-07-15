package com.superSay.Thread;

import com.superSay.Agent.ServerAgent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:wang jian
 * Date: 13-7-11
 * Time: 下午8:14
 */
public class ServerThread extends Thread{
    private boolean flag = true;//循环标志位
    ServerSocket ss;//ServerSocket的引用
    public void run(){//重写的run方法
        try {
            ss=new ServerSocket(8081);//监听到8083端口
        } catch (IOException e1) {//捕获异常
            e1.printStackTrace();//打印异常信息
        }
        while(flag){//进入主循环
            try{
                System.out.println("==========ServerThread============");
                Socket sc=ss.accept();//阻塞式方法，等待用户连接
                System.out.println("==========a Click Connection============");
                ServerAgent sa = new ServerAgent(sc,this);//创建代理线程
                sa.start();//启动代理线程
            }
            catch(Exception e){//捕获异常
                e.printStackTrace();//打印异常
            }
        }
    }
    public void setFlag(boolean flag){//设置循环变量
        this.flag = flag;
    }
}
