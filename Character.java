import java.io.Serializable;

public class Character implements Serializable {
    private String name;
    private int price;
    private double attack, defence, health, speed;

    public Character(String name, int price, double attack, double defence, double health, double speed) {
        // a common constructor
        this.name = name;
        this.price = price;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.speed = speed;
    }

    public void printInfo() {
        System.out.printf("Name: %s\nPrice: %d Gold coins\nAttack: %.1f\nDefence: %.1f\nHealth: %.1f\nSpeed: %.1f\n",
                name, price, attack, defence, health, speed);
        // "Name: " + name + "\nPrice: " + price + " gc\nAttack: " + attack
        // + "\nDefence: " + defence + "\nHealth: " + defence + "\nSpeed: " + speed
    }

    public void attackOpponent(Character op) { // attacking procedure is same for most of the characters
        op.setHealth(op.getHealth() - (0.5 * this.getAttack() - op.getDefence()));
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getAttack() {
        return this.attack;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDefence() {
        return defence;
    }

    public void setDefence(double defence) {
        this.defence = defence;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void assignEquipment(Equipment eq) {
        this.setPrice(this.getPrice() + (int) (0.2 * eq.getPrice()));
        this.setAttack(this.getAttack() + eq.getAttack());
        this.setDefence(this.getDefence() + eq.getDefence());
        this.setHealth(this.getHealth() + eq.getHealth());
        this.setSpeed(this.getSpeed() + eq.getSpeed());
    }

    public void removeEquipment(Equipment eq) {
        this.setPrice(this.getPrice() - (int) (0.2 * eq.getPrice()));
        this.setAttack(this.getAttack() - eq.getAttack());
        this.setDefence(this.getDefence() - eq.getDefence());
        this.setHealth(this.getHealth() - eq.getHealth());
        this.setSpeed(this.getSpeed() - eq.getSpeed());
    }

    public void changeEquipment(Equipment oldEq, Equipment newEq) {
        this.removeEquipment(oldEq);
        this.assignEquipment(newEq);
    }

    // differentiating characters accordingto the homegrounds
    // public static Character[] highLanders = { Character.shooter,
    // Character.ranger, Character.cavalier,
    // Character.enchanter, Character.zoro, Character.conjurer, Character.medic };
    // public static Character[] marshlanders = { Character.squire,
    // Character.swiftblade, Character.warlock,
    // Character.alchemist, Character.basilisk, Character.hydra };
    // public static Character[] sunchildren = { Character.sunfire, Character.zing,
    // Character.templar, Character.soother,
    // Character.lightbringer, Character.dragon, Character.phoenix };
    // public static Character[] mystics = { Character.saggitarius,
    // Character.illusionist, Character.eldritch,
    // Character.saint, Character.pegasus };

}

class Archer extends Character {
    public Archer(String name, int price, double attack, double defence, double health, double speed) {
        super(name, price, attack, defence, health, speed);
    }
}

class Knight extends Character {
    public Knight(String name, int price, float attack, float defence, float health, float speed) {
        super(name, price, attack, defence, health, speed);
    }
}

class Mage extends Character {
    public Mage(String name, int price, float attack, float defence, float health, float speed) {
        super(name, price, attack, defence, health, speed);
    }

}

class MythicalCreature extends Character {
    public MythicalCreature(String name, int price, float attack, float defence, float health, float speed) {
        super(name, price, attack, defence, health, speed);
    }

}

class Healer extends Character {
    public Healer(String name, int price, float attack, float defence, float health, float speed) {
        super(name, price, attack, defence, health, speed);
    }

    @Override
    public void attackOpponent(Character ally) {
        ally.setHealth(0.1 * this.getAttack());
    }

}
