package mygame.vitalir.mysite.com.viregame;

public class Card {
    public static final int numberOfChoices = 3;
    public String[] choice_text;
    public Stats[] choice_influence;
    public String[] choice_result;
    public String name;
    Card() {
        choice_text = new String[numberOfChoices];
        choice_influence = new Stats[numberOfChoices];
        choice_result = new String[numberOfChoices];
    }
}

