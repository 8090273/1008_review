package com.teen.review.Bean;

/**
 * @author teen
 * @create 2021/10/10 23:26
 */
public class player {
    private String username;
    private Integer attack;
    private Integer HP;

    @Override
    public String toString() {
        return "player{" +
                "username='" + username + '\'' +
                ", attack=" + attack +
                ", HP=" + HP +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getHP() {
        return HP;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public player() {
    }

    public player(String username, Integer attack, Integer HP) {
        this.username = username;
        this.attack = attack;
        this.HP = HP;
    }
}
