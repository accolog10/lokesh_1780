package com.accolite.game;

public class Player {
	
	public String name;
	public String color;
	private Pieces myPieces;
	private Board board;
	
	public Player(String name, String color) {
		this.name=name;
		this.color=color;
		myPieces=new Pieces(color);
	}

	public boolean isInCheckmate() {
		
		return false;
	}

	public void haveTheBoard(Board board) {
		this.board=board;
		if(color.equals("White"))
			board.setWhitePieces(myPieces);
		else board.setBlackPieces(myPieces);
	}

	public void move() {
		
	}

	public boolean isInStalemate() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isDraw() {
		// TODO Auto-generated method stub
		return false;
	}

}
