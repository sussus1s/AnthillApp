public class FoodCollectorAnt extends Ant {

    public FoodCollectorAnt(int x, int y, Anthill anthill) {
        super(x, y, anthill);
    }

    @Override
    public void performAction() {
        // Поиск пищи
        Food nearestFood = anthill.findNearestFood(x, y);
        if (nearestFood != null) {
            // Сбор пищи
            System.out.println("I'm a food collector ant, and I'm collecting food at (" + nearestFood.getX() + ", " + nearestFood.getY() + ").");

            anthill.collectFood(nearestFood);

            // Возврат в муравейник
            x = anthill.getX();
            y = anthill.getY();
        }
    }
}