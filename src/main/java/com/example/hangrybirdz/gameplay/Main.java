package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.IGameFlowControl;
import com.example.hangrybirdz.userSessions.AppConfigUsers;
import com.example.hangrybirdz.userSessions.ISessionFlowControl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigUsers.class);
        ISessionFlowControl flow = (ISessionFlowControl) context.getBean("iSessionFlowControl");
        flow.run();
    }

}
