package com.narxoz.rpg.composite;

public class HeroUnit extends UnitLeaf {
    public HeroUnit(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public CombatNode clone() {
        return new HeroUnit(getName(), getHealth(), getAttackPower());
    }
}
