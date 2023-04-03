public class WarriorAnt extends Ant {
    private Threat target;
    public WarriorAnt(int x, int y, Anthill anthill) {
        super(x, y, anthill);
    }


    @Override
    public void performAction() {
        // Поиск угрозы
        Threat nearestThreat = anthill.findNearestThreat(x, y);
        if (nearestThreat != null) {
            // Уничтожение угрозы
            System.out.println("I'm a warrior ant, and I'm attacking a threat at (" + target.getX() + ", " + target.getY() + ").");
            anthill.removeThreat(nearestThreat);

            // Создание новой еды на месте угрозы
            anthill.addFood(new Food(nearestThreat.getX(), nearestThreat.getY()));
        }
    }
    public void setTarget(Threat target) {
        this.target = target;
    }
}