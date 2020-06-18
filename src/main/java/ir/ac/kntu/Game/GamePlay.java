package ir.ac.kntu.Game;

import ir.ac.kntu.Database.Database;
import ir.ac.kntu.solider.Ai;
import ir.ac.kntu.solider.Player;
import javafx.application.Platform;

public class GamePlay {

    public static void moveEnemy(){
        for (int i = 0; i < Database.enemyArmy.size(); i++) {
            int x =Database.enemyArmy.get(i).getCurrentX() ;
            int y = Database.enemyArmy.get(i).getCurrentY() ;
            int speed = Database.enemyArmy.get(i).getSpeed() ;
            Database.enemyArmy.get(i).relocate(x+speed , y);
            checkIfEnemySeen();
        }
    }

    public static void stopEnemy(Ai ai){
        int speed = ai.getSpeed() ;
        ai.setSpeed(speed);
    }

    public static void checkIfEnemySeen(){
        try{
            if (!Database.army.isEmpty() && !Database.enemyArmy.isEmpty()){
                for (int i = 1; i <= Database.army.size(); i++) {
                    for (int j = 1; j <= Database.enemyArmy.size(); j++) {
                        if(calcDistance((float) Database.army.get(i-1).getShape().getCenterX() ,(float) Database.army.get(i-1).getShape().getCenterY(),
                                (float) Database.enemyArmy.get(j-1).getShape().getCenterX(),(float) Database.enemyArmy.get(j-1).getShape().getCenterY())< Database.army.get(i-1).getPlayer().getFieldOfView()*100){
                            attack(Database.enemyArmy.get(j-1) , Database.army.get(i-1));
                        }
                    }
                }

            }else{
                checkWinner();
            }
        }catch (Exception e){
            checkWinner();

        }


    }


    public static float calcDistance(float xstart ,float ystart,float xfinish,float yfinish ){
        float result  = (float) Math.sqrt((Math.pow(xstart - xfinish,2))+(Math.pow(yfinish-ystart , 2)));
        return result;
    }

    public static void attack (Ai ai , Player player){

        stopEnemy(ai);
        int hp = ai.getCurrentHP();
        ai.setCurrentHP(hp - player.getPlayer().getAttack());
        int hpp = player.getCurrentHP();
        player.setCurrentHP(hpp - player.getPlayer().getAttack());

        if (ai.getCurrentHP()<=0){
            ai.setAlive(false);
            Database.enemyArmy.remove(ai);
        }
        if (player.getCurrentHP()<=0){
            player.setAlive(false);
            Database.army.remove(player);
        }



    }

    public static void checkWinner(){
        if (Database.army.isEmpty()){
            System.out.println("gameover");
        }
        if (Database.enemyArmy.isEmpty()){
            System.out.println("you won");
        }
    }
}
