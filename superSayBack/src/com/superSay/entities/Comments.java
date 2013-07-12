/*
 * Comments
 *
 * Version 1.0.0
 *
 * 2013-07-12
 *
 * Copyright (c) 2012, T-Systems.
 * All rights reserved.
 */
package com.superSay.entities;

/**
 * Declaration.
 *
 * @author jian.wang@t-systems.com
 */
public class Comments {
    private int id;
    private String name;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
