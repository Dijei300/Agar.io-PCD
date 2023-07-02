package game;

/**
 * Class to demonstrate a player being added to the game.
 * @author luismota
 *
 */
public class HumanPlayer extends Player {
	public HumanPlayer(int id, Game game, byte strength) {
		super(id, game, strength);
	}

	@Override
	public void run(){

	}
	public boolean isHumanPlayer() {
		return true;
	}
}
