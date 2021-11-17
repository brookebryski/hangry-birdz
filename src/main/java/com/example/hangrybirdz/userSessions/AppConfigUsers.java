package com.example.hangrybirdz.userSessions;


import com.example.hangrybirdz.gameplay.AppConfig;
import com.example.hangrybirdz.gameplay.interfaces.IGameFlowControl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class AppConfigUsers {
    @Bean(name = "iUserController")
    public UserController createUserController() {
        return new UserController();
    }

    @Bean(name ="iUser")
    public User createUser() {
        return new User(createUserController());
    }

    @Bean(name = "iStats")
    public Stats createStats() {
        return new Stats(createUserController(), createUser());
    }

    @Bean(name = "iContinuePlaying")
    public ContinuePlaying createContinuePlaying() {
        return new ContinuePlaying();
    }

    @Bean(name = "iSessionFlowControl")
    public SessionFlowControl createSessionFlowControl() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IGameFlowControl flow = (IGameFlowControl) context.getBean("iGameFlowControl");
        return new SessionFlowControl(createUser(),createStats(),flow,createContinuePlaying());
    }





}
