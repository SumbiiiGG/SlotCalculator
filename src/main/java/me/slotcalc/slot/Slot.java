package me.slotcalc.slot;

import me.slotcalc.maths.MathUtil;

import java.util.ArrayList;
import java.util.List;

public class Slot {
    public List<Dropper> droppers;
    public Slot(List<Dropper> droppers){
        this.droppers=droppers;
    }
    public List<String> getAllCombinations(){
        List<String> combinations = new ArrayList<>();
        int highest = (int) (Math.pow(2,droppers.size()));
        for(int i=0;i<highest;i++){
           combinations.add(Integer.toBinaryString(i));
        }
        return combinations;
    }
    public double getChanceForCombination(String combination){
        double chance = 1;
        String[] numbers = combination.split("");
        for(int i = 0;i<droppers.size();i++){
           if(i<numbers.length){
               if(numbers[numbers.length-i-1].equals("1")){
                   chance*=droppers.get(i).getChance();
                   continue;
               }
                   chance *= droppers.get(i).getChanceReversed();
                   continue;
           }
           chance*=droppers.get(i).getChanceReversed();
        }
        return chance;
    }
    public List<DroppersChance> getChances(){
        List<DroppersChance> chances = new ArrayList<>();
        for(int i=0;i<=droppers.size();i++){
            chances.add(new DroppersChance(i,0));
        }
        for(String combination : getAllCombinations()){
           double chance = getChanceForCombination(combination);
           chances.get(MathUtil.getOnes(combination)).addChance(chance);
        }
        return chances;
    }
}
