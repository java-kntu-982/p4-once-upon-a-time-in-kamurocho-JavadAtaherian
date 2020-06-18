package ir.ac.kntu.solider;

public enum Mercenaies {
    Sohei_Dojima(0, "Sohei Dojima" , 3000 ,3000, 1, 2,0),
    Koji_Shindo(1, "Koji Shindo", 3800 ,3600, 1 ,1, 100),
    Ryo_Takashima (2, "Ryo Takashima" ,3600 ,3800 ,1 ,1, 110),
    Yukio_Terada  (3, "Yukio Terada" ,4000 ,3000, 1 ,1, 130),
    Daigo_Dojima (4, "Daigo Dojima" , 4000 , 4000 ,1,2, 140),
    Osamu_Kashiwagi(5, "Osamu Kashiwagi" ,4000 ,3000 ,2 ,1 , 120),
    Shintaro_Kazama (6, "Shintaro Kazama", 4500, 4500, 2 ,1, 150) ,
    Makoto_Date (7, "Makoto Date",4500 ,1800,2,3,120),
    Goro_Majima(8, "Goro Majima" , 4000 , 4500 , 3 , 4, 160),
    Sotaro_Komaki (9, "Sotaro Komaki", 2800, 5000 ,3, 1, 150),
    Kaoru_Sayama(10, "Kaoru Sayama" , 4500 ,4500 ,2, 4,180 ),
    Ryuji_Goda(11, "Ryuji Goda" ,5000, 5000 ,1 ,2 , 170),
    Futoshi_Shimano (12, "",4200 ,4000 ,2, 1, 150),
    Jiro_Kawara (13, "Jiro Kawara", 5500 ,3200, 3 ,3,200 ) ,
    Tetsu_Tachibana (14, "Tetsu Tachibana" ,5600 ,4000 ,2 ,1,190) ,
    Taiga_Saejima(15, "Taiga Saejima" , 7000 ,5000 ,1,1, 250),

           ;


    private int index ;
    private String name ;
    private int health ;
    private int attack ;
    private int fieldOfView ;
    private int range ;
    private int price ;



    private Mercenaies(int index, String name, int health, int attack, int fieldOfView, int range, int price) {
        this.index = index;
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.fieldOfView = fieldOfView;
        this.range = range;
        this.price = price;
    }

    public static Mercenaies byIndex(int ord) {
        for (Mercenaies m : Mercenaies.values()) {
            if (m.index == ord) {
                return m;
            }
        }
        return null;
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
    public int getIndex() {
        return index;
    }

    public int getPrice() {
        return price;
    }
}

