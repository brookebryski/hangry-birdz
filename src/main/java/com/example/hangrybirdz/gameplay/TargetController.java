package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.interfaces.ITarget;

import java.util.ArrayList;
import java.util.List;

public class TargetController {

    public ArrayList<Target> targetFactory(int level) {
        ArrayList<Target> targets = new ArrayList<>();
        Target target;


        for(int i = 0; i < level; i++) {


            target = new Target();
            target.Set();
            targets.add(target);

        }

        return targets;
        // {Target object, Target object}

    }
}
