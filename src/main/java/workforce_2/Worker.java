package workforce_2;

public class Worker extends Thread implements Runnable {
    IronMine ironMine;
    SteelPlant steelPlant;

    public Worker(IronMine ironMine, SteelPlant steelPlant) {
        this.ironMine = ironMine;
        this.steelPlant = steelPlant;
    }

    @Override
    public void run() {

    }
}
