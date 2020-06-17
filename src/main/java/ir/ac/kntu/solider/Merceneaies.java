package ir.ac.kntu.solider;

public enum Merceneaies {
    Goro_Majima("Goro Majima" , 4000 , 4500 , 3 , 4, 40),
    Daigo_Dojima ("Daigo Dojima" , 4000 , 4000 ,1,2, 30),
    Kaoru_Sayama( "Kaoru Sayama" , 4500 ,4500 ,2, 4,50 ),
    Taiga_Saejima("Taiga Saejima" , 7000 ,5000 ,1,1, 60),
    Ryuji_Goda("Ryuji Goda" ,5000, 5000 ,1 ,2 , 50),
    Osamu_Kashiwagi("Osamu Kashiwagi" ,4000 ,3000 ,2 ,1 , 30),
    Makoto_Date ("Makoto Date",4500 ,1800,2,3,40),
    Futoshi_Shimano ( "",4200 ,4000 ,2, 1, 50),
    Sohei_Dojima("Sohei Dojima" , 3000 ,3000, 1, 2,20),
    Ryo_Takashima ("Ryo Takashima" ,3600 ,3800 ,1 ,1, 30),
    Koji_Shindo("Koji Shindo", 3800 ,3600, 1 ,1, 35),
    Yukio_Terada  ("Yukio Terada" ,4000 ,3000, 1 ,1, 35),
    Sotaro_Komaki ("Sotaro Komaki", 2800, 5000 ,3, 1, 40),
    Jiro_Kawara ("Jiro Kawara", 5500 ,3200, 3 ,3,50 ) ,
    Shintaro_Kazama ("Shintaro Kazama", 4500, 4500, 2 ,1, 40) ,
    Tetsu_Tachibana ("Tetsu Tachibana" ,5600 ,4000 ,2 ,1,50) ,

           ;


    private String name ;
    private int health ;
    private int attack ;
    private int fieldOfView ;
    private int range ;
    private int price ;



    private Merceneaies(String name, int health, int attack, int fieldOfView, int range, int price) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.fieldOfView = fieldOfView;
        this.range = range;
        this.price = price;
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

    public int getFieldOfView() {
        return fieldOfView;
    }

    public int getRange() {
        return range;
    }
}

