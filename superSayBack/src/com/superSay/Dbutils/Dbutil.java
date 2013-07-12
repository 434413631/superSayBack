/*
 * Dbutil
 *
 * Version 1.0.0
 *
 * 2013-07-12
 *
 * Copyright (c) 2012, T-Systems.
 * All rights reserved.
 */
package com.superSay.Dbutils;

import com.superSay.entities.Comments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Declaration.
 *
 * @author jian.wang@t-systems.com
 */
public class Dbutil {
    public static Connection getConnection() {//得到数据库连接
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/supersay", "root", "123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void insert(String title, String litterSay) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        // ResultSet rs = null;

        try {
            pstmt = con.prepareStatement("insert into littersay(title,littersay) values(?,?)");
            pstmt.setString(1, title);
            pstmt.setString(2, litterSay);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static List<Comments> selectAllFrom() {
        List<Comments> list=new ArrayList<Comments>();

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement("select * from littersay");
            rs = pstmt.executeQuery();//查询
            while(rs.next()){
                Comments comments=new Comments();
                comments.setId(rs.getInt(3));
                comments.setName(rs.getString(1));
                comments.setComment(rs.getString(2));
                list.add(comments);
            			}
        } catch (SQLException e) {
            e.printStackTrace();
        }

       return list;
    }
}
