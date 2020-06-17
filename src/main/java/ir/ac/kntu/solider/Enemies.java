package ir.ac.kntu.solider;

public enum Enemies {
    Red_Soldier("Red_Soldier" , 1000 ,500 , 1 ),
    Gray_Soldier( "Gray_Soldier" ,1000, 800, 1),
    Yellow_Soldier("Yellow_Soldier" , 800  , 1800 ,2),
    Green_Soldier("Green_Soldier",1500 ,700 ,1),
    Boss_Level1 ("Boss_Level1" ,8000, 5000 ,1),
    Boss_Level2( "Boss_Level2", 20000 ,12000 ,1)

     ;


    private String name ;
    private int health ;
    private int attack ;
    private int range ;

    private Enemies(String name, int health, int attack, int range) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.range = range;
    }
}
