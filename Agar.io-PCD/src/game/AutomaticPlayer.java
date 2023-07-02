package game;

public class AutomaticPlayer extends Player{
    public AutomaticPlayer(int id, Game game, byte strength) {
        super(id, game, strength);
    }

    @Override
    public void run(){

    }
    @Override
    public boolean isHumanPlayer() {
        return false;
    }
}
