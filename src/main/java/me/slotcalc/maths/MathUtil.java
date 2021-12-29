package me.slotcalc.maths;

public class MathUtil {
    public static int getOnes(String numbers){
        int ones=0;
        for(String s : numbers.split("")){
            if(s.equals("1")){
                ones++;
            }
        }
        return ones;
    }
}
