public class BuilderAnt extends Ant {

    public BuilderAnt(int x, int y, Anthill anthill) {
        super(x, y, anthill);
    }

    @Override
    public void performAction() {
        // Увеличение емкости муравейника
        System.out.println("I'm a builder ant, and I'm building the anthill.");

        anthill.increaseCapacity(1);
    }
}
