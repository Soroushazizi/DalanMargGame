package ir.ac.kntu.gamelogic;

import java.util.Objects;

public class Gun {
    private String gunName;
    private int damage, accuracy,bullet;

    public Gun(String gunName, int damage, int accuracy, int bullet) {
        this.gunName = gunName;
        this.damage = damage;
        this.accuracy = accuracy;
        this.bullet = bullet;
    }

    public int getBullet() {
        return bullet;
    }

    public void setBullet(int bullet) {
        this.bullet = bullet;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getGunName() {
        return gunName;
    }

    public void setGunName(String gunName) {
        this.gunName = gunName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gun)) return false;
        Gun gun = (Gun) o;
        return getDamage() == gun.getDamage() &&
                getAccuracy() == gun.getAccuracy() &&
                getBullet() == gun.getBullet() &&
                getGunName().equals(gun.getGunName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGunName(), getDamage(), getAccuracy(), getBullet());
    }

    @Override
    public String toString() {
        return  gunName + '/' +
                " Damage = " + damage + " /" +
                " Accuracy = " + accuracy + "% /" +
                " Bullet = Caliber " + bullet
                ;
    }
}

