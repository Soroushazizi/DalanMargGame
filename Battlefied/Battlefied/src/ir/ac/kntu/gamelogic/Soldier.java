package ir.ac.kntu.gamelogic;

public class Soldier {
    private int number,health;
    private boolean alive;
    private Gun gun;

    public Soldier(int number, Gun gun) {
        this.number = number;
        this.health = 100;
        this.alive = true;
        this.gun = gun;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "Soldier " + number + " /"+
                " Health = " + health + " /"+
                " Gun = " + gun ;
    }
}
