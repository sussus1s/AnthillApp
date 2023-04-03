import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Anthill {
    private int x, y;
    private int capacity;
    private List<Ant> ants;
    private List<Food> foodList;
    private List<Threat> threatList;
    private List<Food> foodSources;
    private List<Threat> threats;
    private Random random;

    public Anthill(int capacity) {
        this.x = x;
        this.y = y;
        this.capacity = capacity;
        this.ants = new ArrayList<>();
        this.foodSources = new ArrayList<>();
        this.threats = new ArrayList<>();
        this.random = new Random();
        this.foodList = new ArrayList<>();
        this.threatList = new ArrayList<>();

        generateAnts();
        generateFoodSources();
        generateThreats();
    }

    private void generateAnts() {
        int numberOfAnts = Math.min(random.nextInt(capacity) + 1, capacity - ants.size());
        for (int i = 0; i < numberOfAnts; i++) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);

            int type = random.nextInt(4);
            switch (type) {
                case 0:
                    ants.add(new BuilderAnt(x, y,this));
                    break;
                case 1:
                    ants.add(new WarriorAnt(x, y,this));
                    break;
                case 2:
                    ants.add(new ScoutAnt(x, y,this));
                    break;
                case 3:
                    ants.add(new FoodCollectorAnt(x, y,this));
                    break;
            }
        }
    }
    public void performAction() {
        System.out.println("Anthill is performing actions...");

        for (Ant ant : ants) {
            ant.performAction();
        }
    }
    private void generateFoodSources() {
        int numberOfFoodSources = random.nextInt(10) + 1;
        for (int i = 0; i < numberOfFoodSources; i++) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            foodSources.add(new Food(x, y));
        }
    }

    private void generateThreats() {
        int numberOfThreats = random.nextInt(5) + 1;
        for (int i = 0; i < numberOfThreats; i++) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            threats.add(new Threat(x, y));
        }
    }
    public void replaceAnt(Ant oldAnt, Ant newAnt) {
        int index = ants.indexOf(oldAnt);
        if (index != -1) {
            ants.set(index, newAnt);
        }
    }

    public Food findNearestFood(int x, int y) {
        Food nearestFood = null;
        double minDistance = Double.MAX_VALUE;
        for (Food food : foodList) {
            double distance = Math.sqrt(Math.pow(x - food.getX(), 2) + Math.pow(y - food.getY(), 2));
            if (distance < minDistance) {
                minDistance = distance;
                nearestFood = food;
            }
        }
        return nearestFood;
    }
    public Threat findNearestThreat(int x, int y) {
        Threat nearestThreat = null;
        double minDistance = Double.MAX_VALUE;
        for (Threat threat : threatList) {
            double distance = Math.sqrt(Math.pow(x - threat.getX(), 2) + Math.pow(y - threat.getY(), 2));
            if (distance < minDistance) {
                minDistance = distance;
                nearestThreat = threat;
            }
        }
        return nearestThreat;
    }

    public void removeThreat(Threat threat) {
        threatList.remove(threat);
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public void collectFood(Food food) {
        foodList.remove(food);
    }

    public void alertWarriors(Threat threat) {
        for (Ant ant : ants) {
            if (ant instanceof WarriorAnt) {
                ((WarriorAnt) ant).setTarget(threat);
            }
        }
    }

    public void addAnt(Ant ant) {
        if (ants.size() < capacity) {
            ants.add(ant);
        } else {
            System.out.println("Anthill is full!");
        }
    }

    public List<Ant> getAnts() {
        return ants;
    }

    public List<Food> getFoodSources() {
        return foodSources;
    }

    public List<Threat> getThreats() {
        return threats;
    }

    public int getX() {
        return x;
    }
    public void increaseCapacity(int amount) {
        capacity += amount;
    }


    public int getY() {
        return y;
    }


}
