package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.IGameFlowControl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IGameFlowControl flow = (IGameFlowControl) context.getBean("iGameFlowControl");
        flow.run();
    }

}
