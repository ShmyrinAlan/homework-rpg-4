package com.narxoz.rpg.battle;

import com.narxoz.rpg.bridge.Skill;
import com.narxoz.rpg.composite.CombatNode;

import java.util.Objects;
import java.util.Random;

public class RaidEngine {
    private Random random = new Random(1L);

    public RaidEngine setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public RaidResult runRaid(CombatNode teamA, CombatNode teamB, Skill teamASkill, Skill teamBSkill) {
        // TODO: Validate inputs (null checks, alive checks, required skills).
        // TODO: Implement round-based simulation:
        // 1) Team A casts on Team B
        // 2) Team B casts on Team A (if still alive)
        // 3) Track rounds and log each step
        // 4) Stop when one team is defeated (or max rounds reached)
        //
        // Optional extension:
        // Use random for critical strikes or other deterministic events.
        // Example: boolean critA = random.nextInt(100) < 10;

        if(Objects.isNull(teamA)|| Objects.isNull(teamB) || Objects.isNull(teamASkill) || Objects.isNull(teamBSkill)) throw new IllegalArgumentException("arguments can not be null");
        RaidResult result = new RaidResult();
        if(!teamA.isAlive() || !teamB.isAlive()){
            result.setRounds(0);
            result.setWinner(!teamA.isAlive() && !teamB.isAlive() ? "No winner": teamA.isAlive() ? teamA.getName() : teamB.getName());
            result.addLine("at least one of the teams dead or empty");
            return result;
        }
        
        return result;
    }
}
