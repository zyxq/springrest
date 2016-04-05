package com.chenqiang.springrest.domain;

import java.util.Date;

/**
 * Created by chenqiang on 16-3-31.
 */
public class Greeting {

    private final long id;
    private final String content;

    private Date date;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
        date = new Date();
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }
}

