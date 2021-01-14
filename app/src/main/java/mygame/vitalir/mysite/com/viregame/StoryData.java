package mygame.vitalir.mysite.com.viregame;

public class StoryData {  // TODO: last 2 text for quest and It will be OK
    public final int storyTime = 11;
    public final String[] cardNames = {"Это начало пути. Вашему персонажу предстоит выбраться " +
            "из темного подземелья, где каждый ваш шаг решает вашу судьбу.",
            "Вы находитесь в самой нижней части подземелья. Вы находите лестницу к" +
                    " следующему этажу, но путь преграждает огромная крыса",
            "Поднявшись на следующий этаж, вы находите спящего стража и заключенного старика в камере," +
                    " который обещает вам помочь с вашими ранами за его спасение.",
            "Вам встречается торговец, продающий различные зелья" ,
            "Пройдя немного дальше, вы поднимаетесь на следующий этаж. Рядом с вами" +
                    "оказывается склад различных ресурсов, который, по видимому, охраняют" +
                    " несколько полуящеров",
            "Неподалеку от склада вам попадается в обозрение сундук без замка",
            "Перед вами оказывается развилка",
            "Вы обнаруживаете проход на первый этаж подземелья, но охрана вряд ли позволит вам без" +
                    "боя пройти мимо них",
            "Поднявшись на верхний этаж, вы замечаете несколько разбитых игрушек и маленькую девочку",
            "Девятый выбор",
            "Вы доходите до выхода из подземелья, но вдруг вы понимаете, что его владелец," +
                    " жестокий император Вопрак, наблюдал все это время за вами и ждал этой встречи"};

    public final String[][] cardChoiceTexts = {{"Хорошо", "Хорошо", "Хорошо"},
            {"Попробовать победить эту крысу", "Подкупить крысу", "Подождать, может быть она уйдет"},
            {"Выкрасть ключ у стража, пока он спит", "Сразить стража и старика вместе с ним",
                    "Проигнорировать старика"},
            {"Купить зелье", "Проигнорировать", "Убить торговца"},
            {"Попробовать найти что-то, что может помочь убить их",
                    "Попытаться втихую украсть что-то интересное",
                    "Проигнорировать возможность ограбить и пойти дальше"},
            {"Подойти и открыть", "Кинуть камнем в сундук", "Ну к черту, это же мимик"},
            {"Пойти по первому проходу", "Пойти по второму проходу", "Пойти по третьему проходу"},
            {"Попробовать найти возможность убить их", "Броситься в атаку",
                    "Подойти и попробовать подкупить их"},
            {"", "1", "2"},
            {"0", "1", "2"},
            {"Пойти в бой со словами: \"Наша схватка будет легендарной!\"", "Помолиться богу",
                    "Поболтать о жизни"}};

    // for each card we have 3 choices -> 3 sub_arrays which converts into Stats in the future
    public final int[][] cardChoiceInfluences = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0},
            {-10, 10, 25}, {0, 0, -25}, {-15, -10, 0},
            {15, 15, 0}, {-15, 15, 25}, {-20, -10, 15},
            {25, 0, -25}, {0, 0, 0}, {-15, -15, -15},
            {-5, 20, 0}, {0, -10, 10}, {-15, 15, 15},
            {20, 0, 0}, {0, 0, 5}, {0, 0, 0},
            {-15, 0, 15}, {0, -20, 0}, {0, 0, -15},
            {-25, -15, 15}, {-15, 10, 15}, {0, 0, -20},
            {0, 0, 0}, {0, 0, 0}, {0, 0, 0},
            {0, 0, 0}, {0, 0, 0}, {0, 0, 0},
            {-40, 0, 0}, {0, -20, -20}, {0, 0, -40}};

    public final String[][] cardChoiceResults = {{"", "", ""},
            {"Вам удалось победить её, что воодушевило вас, хоть вы и были немного повреждены.",
                    "Крыса взяла ваша деньги и сбежала.", "Во время ухода крыса повредила вас, что," +
                    "безусловно, было видно по вашему состоянию."},
            {"Вам удалось незаметно выкрасть ключ и освободить старика, который, в благодарность," +
                    "усилил ваши физические способности.",
                    "Страж оказался не так уж и слабым, но ваша попытка окончилась успехом.",
                    "Проходя мимо страж, он проснулся и напал на вас из под тишка, нанеся вам " +
                            "тяжелые увечия, но в конце концов вы с ним смогли справиться."},
            {"Выпив зелье, вы почувствовали заметное улучшение вашего самочувствия.",
                    "",
                    "Торговец оказался могущественным волшебником, который" +
                            " с легкостью чуть не уничтожил вас."},
            {"Вы находите взрывоопасные бочки и устраиваете грандиозное шоу. Ничего не осталось" +
                    " от этого склада, но это того стоило.",
                    "Вам удалось выкрасть немного ресурсов, хоть и вас чуть не заметили пару раз",
                    "Полуящеры заметили вас и, недооценив вашей силы, решили, что смогут" +
                            " справиться по одиночке. Вам же это сыграло на руку и вы расправились" +
                            " со всеми."},
            {"Открыв сундук, вы обнаруживаете парочку целебных зелий.",
                    "Кинув в сундук камнем, он сломался и в нем оказались лишь старые безделушки.", ""},
            {"Вам встречается группа гоблинов-разбойников, которые оказываются не такими уж" +
                    "и слабыми противниками." +
                    "Оборачиваясь, вы замечаете, что, возможно, все три прохода вели в одно и то же место",
                    "Вы попадаете в комнату с трупами. Попав в новую комнату и " +
                            "обернувшись, вы замечаете, что, возможно, все три прохода вели в одно и то же место.",
                    "Пройдя в новую комнату, вы замечаете потерю нескольких золотых из кармана. " +
                            "Обернувшись, вы предполагаете, что все три прохода" +
                            "могли вести в одно и то же место."},
            {"Ваши поиски не увеначались успехами, зато стража ваз заметила и чуть не убила.",
                    "Вы делаете успешный маневр и у вас получается убить стражников, не понеся больших потерей.",
                    "Стража принимает вашу взятку и пропускает дальше."},
            {"1", "2", "3"},
            {"1", "2", "3"},
            {"Вы держались достойно, но император Вопрак вам не по плечу. Вы проигрываете бой, " +
                    "но в итоге за вашу силу и храбрость он делает вас генералом его армии. " +
                    "Предадите ли вы его в будущем или нет, это уже другая история...",
                    "Вы, плача, молите богов помочь вам, пока император насмехается над вами. " +
                            "В итоге, к вашему удивлению, на ваши мольбы отзывается одно из" +
                            "азиатских божеств Вокушкеш, которое, за вашу небольшую плату, " +
                            "наносит поражение Вопраку.",
                    "Ваш разговор был длительным, вы обсудили различные проблемы в обществе, " +
                            "но это не могло продолжаться бесконечно, поэтому вам была предложена " +
                            "сделка: в обмен на ваши деньги, найденные в походе, пройти дальше." +
                            " Сумма казалась довольно крупной, но вы смогли выплатить нее и вышли на свободу."}};


}
