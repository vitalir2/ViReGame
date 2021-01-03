package mygame.vitalir.mysite.com.viregame;

public class Stats { // store our data in percents
    public int mood;
    public int money;
    public int education;
    Stats() {
        mood = 50;
        money = 50;
        education = 50;
    }
    Stats(int[] arr) {
        mood = arr[0];
        money = arr[1];
        education = arr[2];
    }
    public void changeValue(Stats stats) {
        mood += stats.mood;
        money += stats.money;
        education += stats.education;
    }
}
