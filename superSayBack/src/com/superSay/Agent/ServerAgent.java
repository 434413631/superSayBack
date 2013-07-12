package com.superSay.Agent;

import com.superSay.Dbutils.Dbutil;
import com.superSay.Thread.ServerThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.*;

/**
 * Author:wang jian
 * Date: 13-7-11
 * Time: 下午8:16
 */
public class ServerAgent extends Thread{
    Socket sc;//声明Socket的引用
    ServerThread father;//声明ServerThread的引用
    DataInputStream din = null;//输入流
    DataOutputStream dout = null;//输出流
    private boolean flag=true;//循环变量
    public ServerAgent(Socket sc,ServerThread father){//构造器
        this.sc=sc;//得到Socket
        this.father=father;//得到ServerThread的引用
        try{
            din=new DataInputStream(sc.getInputStream());//输入流
            dout=new DataOutputStream(sc.getOutputStream());//输入出流
        }
        catch(Exception e){//捕获异常
            e.printStackTrace();//打印异常
        }
    }
    public void run(){
        while(flag){//循环
            try {
                String msg=din.readUTF();//收消息
                System.out.println("Client msg = " + msg);
                if(msg.startsWith("<#SUMMIT#>")){
                    msg=msg.substring(10);//截取子串
                    String[] str = msg.split("\\|");//分割字符串
                    System.out.println(str[0]);
                    System.out.println(str[1]);
                    Dbutil.insert(str[0], str[1]);
                        flag= false;
                }
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

    }





}
