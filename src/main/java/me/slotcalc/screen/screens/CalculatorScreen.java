package me.slotcalc.screen.screens;

import me.slotcalc.SlotCalc;
import me.slotcalc.screen.Screen;
import me.slotcalc.screen.Window;
import me.slotcalc.slot.Dropper;
import me.slotcalc.slot.DroppersChance;
import me.slotcalc.slot.Slot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorScreen extends Screen {
    public CalculatorScreen(){
        JLabel droppers = new JLabel();
        Dimension dimension = SlotCalc.window.getSize();
        String itemDistrubuiton = "";
        JButton calculate = new JButton("Brechne Chancen!");
        JButton newSlot = new JButton("Erschffe eine Neue Slot!");
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Slot slot = new Slot(SlotCalc.droppers);
                int i=1;
                for(DroppersChance chance : slot.getChances()){
                    JLabel label = new JLabel("Die Chance das genau "+chance.getDropper()+" angehen ist "+chance.getChance()*100+"%");
                    label.setBounds(dimension.width/2-250,20*i+20,500,20);
                    SlotCalc.window.getContentPane().add(label);
                    SlotCalc.window.repaint();
                    SlotCalc.window.revalidate();
                    i++;
                }
            }
        });
        newSlot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
                SlotCalc.currentScreen = new ChooseDroppersScreen();
            }
        });
        int i=1;
        for(Dropper dropper : SlotCalc.droppers){
            itemDistrubuiton+="D"+i+" "+dropper.getStackable() +"/"+dropper.getUnstackable()+",";
            i++;
        }
        droppers.setText("Format! DropperNumber Stackbar/Unstackbar Deine Dropper = "+itemDistrubuiton);
        droppers.setBounds(5,5,dimension.width,40);
        calculate.setBounds(5,40,200,40);
        newSlot.setBounds(5,90,200,40);
        SlotCalc.window.getContentPane().add(droppers);
        SlotCalc.window.getContentPane().add(newSlot);
        SlotCalc.window.getContentPane().add(calculate);
    }
}
