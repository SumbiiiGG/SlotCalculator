package me.slotcalc.screen;

import me.slotcalc.SlotCalc;

import java.awt.*;

//Sorry I am new to JFrames :C
public class Screen {
    public void paint(Graphics g){

    }
    public void refresh(){
        SlotCalc.window.getContentPane().removeAll();
        SlotCalc.window.revalidate();
        SlotCalc.window.repaint();
    }
}
