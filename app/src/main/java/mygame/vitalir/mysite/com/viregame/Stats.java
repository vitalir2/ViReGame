package mygame.vitalir.mysite.com.viregame;

public class Stats { // store our data in percents
    public int stat1;
    public int stat2;
    public int stat3;
    Stats() {
        stat1 = 50;
        stat2 = 50;
        stat3 = 50;
    }
    Stats(int[] arr) {
        stat1 = arr[0];
        stat2 = arr[1];
        stat3 = arr[2];
    }

    public Stats(int val1, int val2, int val3) {
        stat1 = val1;
        stat2 = val2;
        stat3 = val3;
    }

    public void changeValue(Stats stats) {
        stat1 += stats.stat1;
        stat2 += stats.stat2;
        stat3 += stats.stat3;
    }
}
