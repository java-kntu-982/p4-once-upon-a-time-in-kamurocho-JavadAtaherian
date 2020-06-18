package ir.ac.kntu.solider;

public enum Enemies {
    Red_Soldier(0, "RED" , 1000 ,500 , 1 ),
    Gray_Soldier(1, "GRAY" ,1000, 800, 1),
    Yellow_Soldier(2, "YELLOW" , 800  , 1800 ,2),
    Green_Soldier(3, "GREEN",1500 ,700 ,1),
    Boss_Level1 (4, "Boss_Level1" ,8000, 5000 ,1),
    Boss_Level2(5, "Boss_Level2", 20000 ,12000 ,1)

     ;




    private int index ;
    private String name ;
    private int health ;
    private int attack ;
    private int range ;

    private Enemies(int index, String name, int health, int attack, int range) {
        this.index = index;
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.range = range;
    }

    public static Enemies byIndex(int ord) {
        for (Enemies m : Enemies.values()) {
            if (m.index == ord) {
                return m;
            }
        }
        return null;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getRange() {
        return range;
    }
}
