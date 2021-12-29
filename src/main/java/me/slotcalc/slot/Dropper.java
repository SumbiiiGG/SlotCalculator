package me.slotcalc.slot;

public class Dropper {
    int stackable;
    int unstackable;
    public Dropper(int stackable,int unstackable){
        this.stackable=stackable;
        this.unstackable=unstackable;
    }
    public double getChance(){
        double stack = stackable;
        double unstack = unstackable;
        return stack/(stack+unstack);
    }
    public double getChanceReversed(){
        return  1-getChance();
    }

    public int getStackable() {
        return stackable;
    }

    public int getUnstackable() {
        return unstackable;
    }
}
