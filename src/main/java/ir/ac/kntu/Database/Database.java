package ir.ac.kntu.Database;

import ir.ac.kntu.Currency.Currency;
import ir.ac.kntu.solider.Ai;
import ir.ac.kntu.solider.Mercenaies;
import ir.ac.kntu.solider.Player;

import java.util.LinkedList;

public class Database {
    public static LinkedList<Mercenaies> hiredMercenaries = new LinkedList<>(); //unlocked mercenaries
    public static LinkedList<Mercenaies> availableMercenaries = new LinkedList<>(); //locked mercenaries
    public static LinkedList<Player> army = new LinkedList<>();//our army for the game
    public static LinkedList<Ai>  enemyArmy = new LinkedList<>();//enemy army for the game
    public static Currency wallet = new Currency(0);






    public static void set500ToWallet(){
        wallet.setMoney(500);
    }

    public static void updateHired(){

        for (int i = 1; i < 15; i++) {
            if (Mercenaies.byIndex(i).isHired()==true){
                hiredMercenaries.add(Mercenaies.byIndex(i));
            }
        }
    }


    public static void updateAvailable(){
        for (int i = 0; i < availableMercenaries.size(); i++) {
            availableMercenaries.remove(i);
        }

        for (int i = 0; i < 15; i++) {
            if (Mercenaies.byIndex(i).isHired()==false){
                availableMercenaries.add(Mercenaies.byIndex(i));
            }
        }
    }

    public static void addTOHiredMercenaries(Mercenaies mercenary){
        Database.hiredMercenaries.add(mercenary);

    }


    public static void addTOArmy(Player player){
        Database.army.add(player);

    }


    public static void addToEnemyArmy(Ai ai){
        Database.enemyArmy.add(ai);
    }

    public static void addTheFreeMercenary(){
        hiredMercenaries.add(Mercenaies.byIndex(0));
    }



}
