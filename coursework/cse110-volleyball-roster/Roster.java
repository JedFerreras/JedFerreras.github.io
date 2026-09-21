package VerdeValleyVolleyBall;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Roster {
	//private instance variables
	private ArrayList<Player> playerList = null;
	
	//default constructor
	public Roster(){
		playerList = new ArrayList<Player>();
	}
	
	//overloaded constructor
	public Roster(String myFileName)throws IOException{
		playerList = new ArrayList<Player>();
		//open file
		Scanner myFileReader = new Scanner(new FileInputStream(myFileName));
		// while there are lines in file to read
		while(myFileReader.hasNext()) {
			// read name, attack, block
			String name = myFileReader.next(); // gets first name
			name = name + " " + myFileReader.next(); // gets last name
			double attackScore = myFileReader.nextDouble();
			double blockScore = myFileReader.nextDouble();
			
			// create and add new player to roster
			this.addPlayer(name, attackScore, blockScore);
				
		}

		// close file
		myFileReader.close();
	}
	
	//getter & setter & modifier methods
	public void addPlayer(String myName, double myAttackScore, double myBlockScore){
		//xx
		Player newPlayer = new Player(myName, myAttackScore, myBlockScore);
		playerList.add(newPlayer);
	}
	
	public int getPlayerCount(){
		return playerList.size();
	}
	
	public Player getPlayerByName(String name){
        for(Player currentPlayer: playerList){
            // String currentPlayerName = currentPlayer.getName();
            if(currentPlayer.getName().equals(name)){
                return currentPlayer;
            }
		}
		return null;
	}
	
	public void printTopAttackers(){
		Player firstBest = null;
		Player nextBest = null;
		double bestAttack = 0;
		//find the first best attacker
		for(Player currentPlayer: playerList){
            // String currentPlayerName = currentPlayer.getName();
            if(currentPlayer.getAttackScore() > bestAttack){
            	firstBest = currentPlayer;
            	bestAttack = currentPlayer.getAttackScore();
            }
		}
		
		bestAttack = 0;
		//find the next best attacker that is not the first best
		for(Player currentPlayer: playerList){
            // String currentPlayerName = currentPlayer.getName();
            if((currentPlayer.getAttackScore() > bestAttack) && (currentPlayer != firstBest)){
            	nextBest = currentPlayer;
            	bestAttack = currentPlayer.getAttackScore();
            }
		}
		firstBest.printInfo();
		nextBest.printInfo();
	}
	
	public void printTopBlockers(){
		Player firstBest = null;
		Player nextBest = null;
		double bestBlocker = 0;
		//find the first best blocker
		for(Player currentPlayer: playerList){
            if(currentPlayer.getBlockScore() > bestBlocker){
            	firstBest = currentPlayer;
            	bestBlocker = currentPlayer.getBlockScore();
            }
		}
		
		bestBlocker = 0;
		//find the next best blocker that is not the first best
		for(Player currentPlayer: playerList){
            if((currentPlayer.getBlockScore() > bestBlocker) && (currentPlayer != firstBest)){
            	nextBest = currentPlayer;
            	bestBlocker = currentPlayer.getBlockScore();
            }
		}
		firstBest.printInfo();
		nextBest.printInfo();
	}
	
	public void printAllPlayers(){
		for(Player currentPlayer: playerList){
			currentPlayer.printInfo();
		}
	}
}
