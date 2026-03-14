public class Pet {
    private final String name;
    private int hunger;
    private int happiness;

    public Pet(String name) {
        this.name = name;
        this.hunger = 5;
        this.happiness = 5;
    }
    public String getName() {
        return this.name;
    }

    public int getHunger() {
        return this.hunger;
    }

    public int getHappiness() {
        return this.happiness;
    }
    
    public void setHunger(int hunger) {

        if (hunger < 0) {
            this.hunger = 0;
        } else if (hunger > 10) {
            this.hunger = 10;
        } else {
            this.hunger = hunger;
        }
    }

    public void setHappiness(int happiness) {
        if (happiness < 0) {
            this.happiness = 0;
        } else if (happiness > 10) {
            this.happiness = 10;
        } else {
            this.happiness = happiness;
        }
    }
    public void feed() {
        setHunger(this.hunger - 2);
        System.out.println(getName() + " enjoyed the food");        
    }

    public void play() {
        if (hunger >= 9) {
            System.out.println(getName() + " is too hungry to play");
            return;
        }

        setHappiness(this.happiness + 2);
        setHunger(this.hunger + 2);

        System.out.println(getName() + " had fun playing!");
    }

    public void checkstatus() {
        System.out.println("Name: " + name);
        System.out.println("Hunger: " + hunger + "/10");
        System.out.println("Happiness: " + happiness + "/10");
    }
}
