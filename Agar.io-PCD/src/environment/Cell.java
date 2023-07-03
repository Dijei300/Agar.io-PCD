package environment;

import game.AutomaticPlayer;
import game.Game;
import game.Player;

public class Cell {
	private Coordinate position;
	private Game game;
	private Player player=null;

	public Cell(Coordinate position,Game g) {
		super();
		this.position = position;
		this.game=g;
	}

	//permite com q o jogador se mova de cell
	public void move(Player player, Direction dir){
		Cell oldCell = player.getCurrentCell();
		Coordinate newCor = player.getCurrentCell().getPosition().translate(dir.getVector());
		Cell newCell = game.getCell(newCor);
		if(!newCell.isOcupied()){
			newCell.setPlayer(player);
			oldCell.removePlayer(player);
			game.notifyChange();
		}



	}

	public Coordinate getPosition() {
		return position;
	}

	public boolean isOcupied() {
		return player!=null;
	}


	public Player getPlayer() {
		return player;
	}

	// Should not be used like this in the initial state: cell might be occupied, must coordinate this operation
	public void setPlayer(Player player) {
		this.player = player;
	}

	public void removePlayer(Player player) {
		this.player = null;
	}

}
