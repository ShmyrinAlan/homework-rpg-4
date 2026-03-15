package com.narxoz.rpg.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartyComposite implements CombatNode {
    private final String name;
    private final List<CombatNode> children = new ArrayList<>();

    public PartyComposite(String name) {
        this.name = name;
    }

    public void add(CombatNode node) {
        children.add(node);
    }

    public void remove(CombatNode node) {
        children.remove(node);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        // TODO: Composite aggregation
        // Return total health of all children (and nested children).
        return children.stream().mapToInt(CombatNode::getHealth).sum();
    }

    @Override
    public int getAttackPower() {
        // TODO: Composite aggregation
        // Return total attack of alive children only.
        return children.stream().mapToInt(CombatNode::getAttackPower).sum();
    }

    @Override
    public void takeDamage(int amount) {
        // TODO: Composite distribution
        // Distribute incoming damage across alive children.
        // Suggested baseline:
        // 1) Collect alive children
        // 2) Split amount evenly (or using your own documented rule)
        // 3) Apply damage to each child
        List<CombatNode> aliveNodes = getAliveChildren();
        for (CombatNode node:aliveNodes){
            if(aliveNodes.size() == 1){
                node.takeDamage(amount);
                break;
            }
            node.takeDamage(amount/aliveNodes.size());
            amount -= amount/aliveNodes.size();
            aliveNodes.remove(node);
        }
    }

    @Override
    public boolean isAlive() {
        // TODO: Composite liveness
        // Return true when at least one child is alive.
        return children.stream().anyMatch(CombatNode::isAlive);
    }

    @Override
    public List<CombatNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public void printTree(String indent) {
        // TODO: Tree visualization
        // Print this node and recurse into children with increased indent.
        System.out.println(String.format("%s+ %s %d/%d", indent, name, getHealth(), getAttackPower()));
    }

    @Override
    public CombatNode clone() {
        PartyComposite clone = new PartyComposite(name);
        children.forEach(item -> clone.add(item.clone()));
        return clone;
    }

    private List<CombatNode> getAliveChildren() {
        // TODO: helper for takeDamage()
        return new ArrayList<>(children.stream().filter(CombatNode::isAlive).toList());
    }
}
