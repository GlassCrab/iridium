package net.glasscrab.iridium;

public class RNGManager {
    private static RNGManager manager;
    public RNGManager(){
        manager = this;
    }

    public boolean jackpot(int chance){
        int rand = (int) (Math.random() * chance) + 1;
        int jackpot = 1;
        return rand == jackpot;
    }

    public int random(int chance){
        return (int) (Math.random() * chance) + 1;
    }


    public static RNGManager getRNGManager(){
        return manager;
    }
}
