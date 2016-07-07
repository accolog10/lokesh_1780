package com.accolite.game;

public class Board {
	private Pieces whitePieces;
	private Pieces blackPieces;
	private boolean [][]board;
	
	public Board(){
		board=new boolean[8][8];
	}
	public void setWhitePieces(Pieces whitePieces) {
		this.whitePieces = whitePieces;
		placeWhitePieces();
	}
	private void placeWhitePieces() {
				
	}
	public void setBlackPieces(Pieces blackPieces) {
		this.blackPieces = blackPieces;
		placeBlackPieces();
	}
	private void placeBlackPieces() {
		
	}
	public piece getSquareInfo(Position position){
		return null;
	}
}
