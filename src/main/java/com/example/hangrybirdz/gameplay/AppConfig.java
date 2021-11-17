package com.example.hangrybirdz.gameplay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean(name = "iAngleGetter")
    public AngleGetter createAngleGetter(){
        return new AngleGetter();
    }

    @Bean(name = "iAngleIntegerValidator")
    public AngleIntegerValidator createAngleIntegerValidator(){
        return new AngleIntegerValidator();
    }

    @Bean(name = "iAngleRangeValidator")
    public AngleRangeValidator createAngleRangeValidator(){
        return new AngleRangeValidator();
    }

    @Bean(name = "iAngleHandler")
    public AngleHandler createAngleHandler(){
        return new AngleHandler(createAngleGetter(),createAngleIntegerValidator(),createAngleRangeValidator());
    }

    @Bean(name = "iVelocityGetter")
    public VelocityGetter createVelocityGetter(){
        return new VelocityGetter();
    }

    @Bean(name = "iVelocityIntegerValidator")
    public VelocityIntegerValidator createVelocityIntegerValidator(){
        return new VelocityIntegerValidator();
    }

    @Bean(name = "iVelocityRangeValidator")
    public VelocityRangeValidator createVelocityRangeValidator(){
        return new VelocityRangeValidator();
    }

    @Bean(name = "iVelocityHandler")
    public VelocityHandler createVelocityHandler(){
        return new VelocityHandler(createVelocityGetter(),createVelocityIntegerValidator(),createVelocityRangeValidator());
    }

    @Bean(name = "iAngleConverter")
    public AngleConverter createAngleConverter(){
        return new AngleConverter();
    }

    @Bean(name = "iXLandingPosition")
    public XLandingPosition createXLandingPosition(){
        return new XLandingPosition();
    }

    @Bean(name = "iYLandingPosition")
    public YLandingPosition createYLandingPosition(){
        return new YLandingPosition();
    }

    @Bean(name = "iLandingPosition")
    public LandingPosition createLandingPosition(){
        return new LandingPosition(createAngleConverter(), createXLandingPosition(), createYLandingPosition());
    }

    @Bean(name = "iTarget")
    public Target createTarget(){
        return new Target();
    }

    @Bean(name = "iHitOrMissShot")
    public HitOrMissShot createHitOrMissShot(){
        return new HitOrMissShot();
    }

    @Bean(name = "iHitOrMissMortar")
    public HitOrMissMortar createHitOrMissMortar(){
        return new HitOrMissMortar();
    }

    @Bean(name = "iHitOrMissBomb")
    public HitOrMissBomb createHitOrMissBomb(){
        return new HitOrMissBomb();
    }

    @Bean(name = "iShotFlowControl2")
    public ShotFlowControl2 createShotFlowControl2(){
        return new ShotFlowControl2(createAngleHandler(),createVelocityHandler(),createLandingPosition(),createTarget());
    }

    @Bean(name = "iMortar")
    public Mortar createMortar(){
        return new Mortar();
    }

    @Bean(name = "iBomb")
    public Bomb createBomb(){
        return new Bomb();
    }

    @Bean(name = "iGameFlowControl")
    public GameFlowControl createGameFlowControl(){
        return new GameFlowControl(createTarget(),createShotFlowControl2(), createMortar(), createBomb(), createHitOrMissShot(), createHitOrMissMortar(), createHitOrMissBomb());
    }




}
