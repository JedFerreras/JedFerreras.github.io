package VerdeValleyVolleyBall;

import java.util.ArrayList;

public class Player{
    //private instance variables
    private String name = "";
    private double attackScore = 0.0;
    private double blockScore = 0.0;

    //default constructor

    //overloaded constructor
    public Player(String name, double attackScore, double blockScore){
        this.name = name;
        this.attackScore = attackScore;
        this.blockScore = blockScore;
    }

    //getter & setter methods
    public String getName(){
        return this.name;
    }

    public double getAttackScore(){
        return this.attackScore;
    }

    public double getBlockScore(){
        return this.blockScore;
    }

    public void setAttackScore(double attackScore){
        this.attackScore = attackScore;
        return;
    }

    public void setBlockScore(double blockScore){
        this.blockScore = blockScore;
        return;
    }

    public void printInfo(){
        System.out.printf("%s (attack = %.2f, block = %.2f)\n", this.name, this.attackScore, this.blockScore);
        return;
    }
}