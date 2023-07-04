package game;



import environment.Cell;
import environment.Direction;

/**
 * Represents a player.
 * @author luismota
 *
 */
public abstract class Player extends Thread  {


	protected  Game game;

	private int id;

	public volatile Boolean isRunning;

	private byte currentStrength;
	protected byte originalStrength;

	public Cell getCurrentCell() {
		for(Cell[] c: game.board)
			for(Cell cell: c) {
				Player cellPlayer = cell.getPlayer();
				if(cellPlayer != null)
					if (cellPlayer.equals(this))
						return cell;
			}

		return null;
	}

	public Player(int id, Game game, byte strength) {
		super();
		this.id = id;
		this.game=game;
		currentStrength=strength;
		originalStrength=strength;
	}

	public abstract boolean isHumanPlayer();

	public Direction getRandomDirection() {
		Direction [] directions=Direction.values();
		double randomDir= (Math.random()*directions.length);
		return directions[(int) randomDir];
	}


	@Override
	public String toString() {
		return "Player [id=" + id + ", currentStrength=" + currentStrength + ", getCurrentCell()=" + getCurrentCell() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public byte getCurrentStrength() {
		return currentStrength;
	}

	public byte setStrength(byte strength){
		return  this.currentStrength = strength;
	}

	public void stopRunning(){
		this.isRunning = false;
	}


	public int getIdentification() {
		return id;
	}
}
