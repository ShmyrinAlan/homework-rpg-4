package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

import java.util.Collections;

public class SingleTargetSkill extends Skill {
    public SingleTargetSkill(String skillName, int basePower, EffectImplementor effect) {
        super(skillName, basePower, effect);
    }

    @Override
    public void cast(CombatNode target) {
        // TODO: Single-target Bridge action
        // 1) Resolve final damage through effect implementor
        // 2) Apply to target node
        if(target.getChildren().isEmpty()){
            System.out.println(String.format("%s casts on %s",getSkillName(),target.getName()));
            switch (getEffectName().toLowerCase()){
                case "fire" -> {
                    if(target.getHealth() < 30) target.takeDamage(getBasePower() + 10);
                    else target.takeDamage(getBasePower() + 3);
                }
                case "ice" -> {
                    if(target.getHealth() > 30) target.takeDamage(getBasePower() + 8);
                    else target.takeDamage(getBasePower() + 5);
                }
                case "physical" -> {
                    if(target.getHealth() < 50) target.takeDamage(getBasePower() + 12);
                    else target.takeDamage(getBasePower() + 2);
                }
                case "shadow" -> {
                    if(target.getHealth() < 15) target.takeDamage(getBasePower() + 15);
                    else target.takeDamage(getBasePower() + 5);
                }
            }
        }else cast(target.getChildren().getFirst());
    }
}
