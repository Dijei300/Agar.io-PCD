package game;

public class AutomaticPlayer extends Player{
    private int cycles;
    public AutomaticPlayer(int id, Game game, byte strength) {
        super(id, game, strength);
        cycles = originalStrength;
    }

    @Override
    public void run(){
        isRunning = true;
        while (isRunning) {
            try {
                sleep(Game.REFRESH_INTERVAL);
                if(cycles == 0) {
                    if (this.getCurrentCell() != null) {
                        this.getCurrentCell().move(this, getRandomDirection());
                        cycles = originalStrength;
                    }
                }
                cycles--;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Jogador: " + this.getId() + " parou");
    }
    @Override
    public boolean isHumanPlayer() {
        return false;
    }


}
