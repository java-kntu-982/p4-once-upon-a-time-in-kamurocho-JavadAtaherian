package ir.ac.kntu.Game;

import ir.ac.kntu.Database.Database;
import ir.ac.kntu.solider.Ai;

public class InitializingEnemies {
    public static void createEnemies (){
        for (int i = 0; i < 30; i++) {
            Database.enemyArmy.add(new Ai());
            System.out.println(Database.enemyArmy.get(i).toString());
        }

    }
}
