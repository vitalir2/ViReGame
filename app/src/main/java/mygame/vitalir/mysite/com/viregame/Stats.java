package mygame.vitalir.mysite.com.viregame;

public class Stats { // store our data in percents
    public int health; // life
    public int mood;
    public int money;
    Stats() {
        health = 50;
        mood = 50;
        money = 50;
    }
    Stats(int[] arr) {
        health = arr[0];
        mood = arr[1];
        money = arr[2];
    }

    public Stats(int val1, int val2, int val3) {
        health = val1;
        mood = val2;
        money = val3;
    }

    public void changeValue(Stats stats) {
        health += stats.health;
        mood += stats.mood;
        money += stats.money;
    }

    // all stats < 100 because if we have them >= 100 => we transform
    // into a monster of this dungeon
    public boolean isAlive() {
        return health > 0  && mood > 0 && money > 0;
    }

    public boolean isNotMonster() {
        return health < 100 && mood < 100 && money < 100;
    }
}
