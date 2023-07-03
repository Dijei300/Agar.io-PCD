package game;

public class AutomaticPlayer extends Player{
    public AutomaticPlayer(int id, Game game, byte strength) {
        super(id, game, strength);
    }

    @Override
    public void run(){
        while (true) {
            if (this.getCurrentCell() != null)
                this.getCurrentCell().move(this, getRandomDirection());
        }
    }
    @Override
    public boolean isHumanPlayer() {
        return false;
    }
}
