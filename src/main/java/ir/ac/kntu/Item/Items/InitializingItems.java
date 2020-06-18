package ir.ac.kntu.Item.Items;

import ir.ac.kntu.Database.Database;
import ir.ac.kntu.Database.RandomHelper;

public class InitializingItems {
    public static void createItems (){
        Database.items.add(new Container());
        Database.items.add(new Truck());
    }
}
