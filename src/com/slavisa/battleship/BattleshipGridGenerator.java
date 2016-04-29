package com.slavisa.battleship;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class BattleshipGridGenerator {

	private int[][] board;
	
		
	public BattleshipGridGenerator() {
		createEmptyGrid();
		placeAllShips();
	}

	public Map<String, Integer> getBattleshipBoard(){
		
		Map<String, Integer> battleshipMap = new TreeMap<>();
		
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				battleshipMap.put((String.valueOf(i)+","+String.valueOf(j)), board[i][j]);
			}
		}
		return battleshipMap;
	}
	
	//Create a grid of size 10x10 and fills it with zeros
	private void createEmptyGrid(){
		
		board = new int[10][10];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = 0;
			}
		}
	}
	//Calls the method placeShip() and sets all ships on grid
	private void placeAllShips(){
		
		int z = 0;
		
		for(int i = 4; i > 0; i--){
			z++;
			for(int j = i; j > 0; j--){
				placeShip(z);
			}
		}		
	}
	//Puts the appropriate ship at a random location
	private void placeShip(int size){
		
		boolean status = false;
		boolean orientation;
		Random randomNumbers = new Random();
		
		while(!status){
				orientation = randomNumbers.nextBoolean();
				int row = randomNumbers.nextInt(9);
				int col = randomNumbers.nextInt(9);
				
				if(orientation){
					//horizontal
					if((col + (size-1) >= 9) ||(!isFreeCells(row, col, size, orientation))){
						status = false;
					}else{
						for(int i = 0; i < size; i++){
							board[row][col+i] = size;
						}
						break;
					}
				}else{
					//vertical
					if((row + (size-1) >= 9) || (!isFreeCells(row, col, size, orientation))){
						status = false;
					}else{
						for(int i = 0; i < size; i++){
							board[row+i][col] = size;
						}
						break;
					}
				}		
		}
	}
	/*
	 * Checks whether an appropriate ship proper orientation 
	 * can be accommodated at a given location
	 */
	private boolean isFreeCells(int row, int col, int size, boolean orientation){
		if(orientation){
			//check horizontal
			for(int i = 0; i < size; i++){
				if(board[row][col+i] != 0){
					return false;
				}
			}
		}else{
			//check vertical
			for(int i = 0; i < size; i++){
				if(board[row+i][col] != 0){
					return false;
				}
			}
		}
		
		return true;
	}
}
