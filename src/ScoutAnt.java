public class ScoutAnt extends Ant {

    public ScoutAnt(int x, int y, Anthill anthill) {
        super(x, y, anthill);
    }
    @Override
    public void performAction() {
        // Поиск пищи и угроз
        Food nearestFood = anthill.findNearestFood(x, y);
        Threat nearestThreat = anthill.findNearestThreat(x, y);
        System.out.println("I'm a scout ant, and I'm searching for food and threats.");

        // Если нашел пищу, становится добытчиком еды
        if (nearestFood != null) {
            System.out.println("I found some food at (" + nearestFood.getX() + ", " + nearestFood.getY() + ").");

            anthill.replaceAnt(this, new FoodCollectorAnt(x, y, anthill));
        }

        // Если нашел угрозу, сообщает воинам
        if (nearestThreat != null) {
            System.out.println("I found a threat at (" + nearestThreat.getX() + ", " + nearestThreat.getY() + "). Alerting the warriors.");

            anthill.alertWarriors(nearestThreat);
        }
    }
}