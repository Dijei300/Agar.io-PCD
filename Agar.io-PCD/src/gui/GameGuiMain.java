package gui;

import java.util.Observable;
import java.util.Observer;

import game.AutomaticPlayer;
import game.Game;
import game.HumanPlayer;
import game.Player;

import javax.swing.JFrame;

public class GameGuiMain implements Observer {
	private JFrame frame = new JFrame("pcd.io");
	private BoardJComponent boardGui;
	private Game game;

	public GameGuiMain() {
		super();
		game = new Game();
		game.addObserver(this);

		buildGui();

	}

	private void buildGui() {
		boardGui = new BoardJComponent(game);
		frame.add(boardGui);


		frame.setSize(800,800);
		frame.setLocation(0, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void init()  {
		frame.setVisible(true);

		// Demo players, should be deleted
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//game.addPlayerToGame(new HumanPlayer(1, game, (byte)3));
		Player[] players = new Player[30];
		addAutoToGame(players);
		for(Thread gamer: players)
			gamer.start();

	}

	public void addAutoToGame(Player[] player){
		for(int i = 0; i < player.length; i++){
			player[i] = new AutomaticPlayer(i, game, (byte)((Math.random() * Game.MAX_INITIAL_STRENGTH) + 1));
			game.addPlayerToGame(player[i]);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		boardGui.repaint();
	}

	public static void main(String[] args) {
		GameGuiMain game = new GameGuiMain();
		game.init();
	}

}
