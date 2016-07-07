package com.accolite.game;

public class chess {

	public static void main(String[] args) {
		Game game=new Game();
		Player player1=new Player("log10","White");
		Player player2=new Player("cpu","Black");
		game.addPlayers(player1,player2);
		game.start();
		try {
			game.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(game.getStatus());
	}

}
