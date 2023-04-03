public abstract class Ant {
    protected int x, y;
    protected Anthill anthill;

    public Ant(int x, int y, Anthill anthill) {
        this.x = x;
        this.y = y;
        this.anthill = anthill;
    }


    public abstract void performAction();
}

