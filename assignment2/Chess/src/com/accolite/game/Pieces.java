package com.accolite.game;

public class Pieces {
	private String color;
	piece[] pawn;
	piece king;
	piece queen;
	piece rightBishop,leftBishop;
	piece rightKnight,leftKnight;
	piece rightRook,leftRook;
	public Pieces(String color){
		this.color=color;
		pawn=new Pawn[8];
		for(int i=0;i<8;i++)
			pawn[i]=new Pawn(color);
		king=new King(color);
		queen=new Queen(color);
		rightBishop=new Bishop(color,"right");
		leftBishop=new Bishop(color,"left");
		rightKnight=new Knight(color,"right");
		leftKnight=new Knight(color,"left");
		rightRook=new Rook(color,"right");
		leftRook=new Rook(color,"left");
	}
	public piece getPieceAt(Position position){
		return null;
	}
}
