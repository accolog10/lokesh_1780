package com.accolite.game;

public class Game implements Runnable{
	private Thread gameThread;
	private Player player1,player2;
	private Board board;
	private String status;
	
	public Game(){
		gameThread=new Thread(this);
		board=new Board();
	}
	public void start() {
		player1.haveTheBoard(board);
		player2.haveTheBoard(board);
		gameThread.start();
	}

	public String getStatus() {
		if(status.equals(null))
			return "Game in progress";
		else{
			if(status.equals("Won")){
				if(player1.isInCheckmate())
					return player2.name+" "+status;
				else return player1.name+" "+status;
			}
			else return status;
		}
	}

	public void addPlayers(Player player1, Player player2) {
		this.player1=player1;
		this.player2=player2;
	}

	@Override
	public void run() {
		boolean gameOver=false;
		boolean whiteTurn=true;
		while(!gameOver ){
			if(whiteTurn){
				whiteTurn=!whiteTurn;
				if(player1.color.equals("White"))
					player1.move();
				else
					player2.move();
			}else{
				whiteTurn=!whiteTurn;
				if(player1.color.equals("Black"))
					player1.move();
				else
					player2.move();
			}
			gameOver=true;
			if(player1.isInCheckmate()||player2.isInCheckmate())
				status="Won";
			else if(player1.isInStalemate()||player2.isInStalemate())
				status="Stalemate";
			else if(player1.isDraw()||player2.isDraw())
				status="Draw";
			else gameOver=false;
		}
	}
}
