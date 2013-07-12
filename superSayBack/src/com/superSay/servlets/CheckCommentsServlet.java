/*
 * CheckCommentsServlet
 *
 * Version 1.0.0
 *
 * 2013-07-12
 *
 * Copyright (c) 2012, T-Systems.
 * All rights reserved.
 */
package com.superSay.servlets;

import com.superSay.Dbutils.Dbutil;
import com.superSay.entities.Comments;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Declaration.
 *
 * @author jian.wang@t-systems.com
 */
public class CheckCommentsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<Comments> list=Dbutil.selectAllFrom();
        req.setAttribute("list",list);
        req.getRequestDispatcher("jsp/checkComments.jsp").forward(req,resp);

    }
}
