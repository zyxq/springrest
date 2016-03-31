package com.chenqiang.springrest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Copyright:   Copyright(C) 2010-2015  LTD.
 * Project:
 * Module:      service
 * Description: system init execute
 * Author:
 * Createdate:  2014/11/04 9:08 PM
 * Version:     V0.1
 * History:
 * #       Modified By  on 2014/11/04 Comment: created.
 */

@Service
public class SystemInitService implements ApplicationListener<ApplicationContextEvent> {
    private static Logger logger = LoggerFactory.getLogger(SystemInitService.class);

    private static boolean isStart = false;

    @Override
    public void onApplicationEvent(ApplicationContextEvent applicationContextEvent) {
        if (applicationContextEvent.getApplicationContext().getParent() == null) {  //只有applicationContext为根root时触发
            if (applicationContextEvent instanceof ContextRefreshedEvent) { //spring刷新时
                if (isStart) {
                    return;
                }

                isStart = true;
                logger.debug("SystemInitService start");
            } else if (applicationContextEvent instanceof ContextClosedEvent) { //spring关闭时
            }
        }
    }
}
