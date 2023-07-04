package environment;

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
	public synchronized void move(Player player, Direction dir){
		Cell oldCell = player.getCurrentCell();
		Coordinate newCor = player.getCurrentCell().getPosition().translate(dir.getVector());
		if(!game.isCoordinateOutOfBoard(newCor)) {
			Cell newCell = game.getCell(newCor);
			if (!newCell.isOcupied()) {
				oldCell.removePlayer();
				newCell.setPlayer(player);
			}else{
				fight(oldCell, newCell);
			}
		}
		game.notifyChange();

	}

	public void fight(Cell oldCell, Cell newCell){
		Player p1 = oldCell.getPlayer();
		Player p2 = newCell.getPlayer();

		if(p1.getCurrentStrength() == p2.getCurrentStrength()){
			int chooser = (int) ((Math.random() * (2 - 1)) + 1);
			if(chooser == 1){
				winner(p1, p2);
			}else{
				winner(p2, p1);
			}
		}else if(p1.getCurrentStrength() > p2.getCurrentStrength()){
			winner(p1, p2);
		}else{
			winner(p2, p1);
		}
	}

	public void winner(Player p1, Player p2){
		byte plusStrength = (byte) (p1.getCurrentStrength() + p2.getCurrentStrength());
		byte lostStrength = 0;
		p1.setStrength(plusStrength);
		p2.setStrength(lostStrength);
		p2.stopRunning();
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

	public void removePlayer() {
		this.player = null;
	}

}
