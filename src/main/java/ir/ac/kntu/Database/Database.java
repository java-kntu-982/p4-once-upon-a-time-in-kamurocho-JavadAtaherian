package ir.ac.kntu.Database;

import ir.ac.kntu.solider.Ai;
import ir.ac.kntu.solider.Mercenaies;
import ir.ac.kntu.solider.Player;

import java.util.LinkedList;

public class Database {
    public static LinkedList<Mercenaies> hiredMercenaries = new LinkedList<>(); //unlocked mercenaries
    public static LinkedList<Player> army = new LinkedList<>();//our army for the game
    public static LinkedList<Ai>  enemyArmy = new LinkedList<>();//enemy army for the game

    public void addTOHiredMercenaries(Mercenaies mercenary){
        Database.hiredMercenaries.add(mercenary);

    }


    public void addTOArmy(Player player){
        Database.army.add(player);

    }


    public void addToEnemyArmy(Ai ai){
        Database.enemyArmy.add(ai);
    }

    public void addTheFreeMercenary(){
        hiredMercenaries.add(Mercenaies.byIndex(0));
    }



}
