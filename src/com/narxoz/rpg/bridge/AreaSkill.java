package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

public class AreaSkill extends Skill {
    public AreaSkill(String skillName, int basePower, EffectImplementor effect) {
        super(skillName, basePower, effect);
    }

    @Override
    public void cast(CombatNode target) {
        // TODO: Area Bridge action
        // Apply resolved damage to a composite target.
        // Tip: Let Composite classes decide how to distribute AOE damage.

        switch (getEffectName().toLowerCase()){
            case "fire" -> {
                if(target.getHealth() < 50) target.takeDamage(getBasePower() + 30);
                else target.takeDamage(getBasePower() + 23);
            }
            case "ice" -> {
                if(target.getHealth() > 50) target.takeDamage(getBasePower() + 28);
                else target.takeDamage(getBasePower() + 25);
            }
            case "physical" -> {
                if(target.getHealth() < 70) target.takeDamage(getBasePower() + 32);
                else target.takeDamage(getBasePower() + 22);
            }
            case "shadow" -> {
                if(target.getHealth() < 35) target.takeDamage(getBasePower() + 35);
                else target.takeDamage(getBasePower() + 25);
            }
        }
    }
}
