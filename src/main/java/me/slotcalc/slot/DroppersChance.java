package me.slotcalc.slot;

public class DroppersChance {
    int dropper;
    double chance;
    public DroppersChance(int dropper,double chance){
        this.dropper=dropper;
        this.chance=chance;
    }
    public void addChance(double amount){
        chance+=amount;
    }

    public double getChance() {
        return chance;
    }

    public int getDropper() {
        return dropper;
    }
}
