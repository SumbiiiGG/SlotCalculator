package me.slotcalc.screen.screens;

import me.slotcalc.SlotCalc;
import me.slotcalc.screen.Screen;
import me.slotcalc.slot.Dropper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseStackableScreen extends Screen {
    public static int currentDropper=1;
    public ChooseStackableScreen(){
        JLabel current = new JLabel("Dies ist der "+currentDropper+". von "+ChooseDroppersScreen.totalDroppers+" Droppern");
        JLabel stackable = new JLabel("Wie viele stackbare Items sind im Dropper?");
        JLabel unstackable = new JLabel("Wie viele unstackbare Items sind im Dropper?");
        JTextArea stackableAnswer = new JTextArea();
        JTextArea unstackableAnswer = new JTextArea();
        JButton next = new JButton("Weiter");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentDropper==ChooseDroppersScreen.totalDroppers){
                    System.out.println("Finished!");
                    Dropper dropper = new Dropper(Integer.parseInt(unstackableAnswer.getText()),Integer.parseInt(stackableAnswer.getText()));
                    SlotCalc.droppers.add(dropper);
                    for(Dropper d : SlotCalc.droppers){
                        System.out.println("s:"+d.getStackable() + " us:"+d.getUnstackable());
                    }
                    refresh();
                    SlotCalc.currentScreen = new CalculatorScreen();
                }else{
                    Dropper dropper = new Dropper(Integer.parseInt(unstackableAnswer.getText()),Integer.parseInt(stackableAnswer.getText()));
                    SlotCalc.droppers.add(dropper);
                    refresh();
                    currentDropper++;
                    SlotCalc.currentScreen = new ChooseStackableScreen();
                }
            }
        });
        Dimension dimension = SlotCalc.window.getSize();

        stackable.setBounds(dimension.width/2-150,dimension.height/2,300,40);
        unstackable.setBounds(dimension.width/2-150,dimension.height/2-40,300,40);
        stackableAnswer.setBounds(dimension.width/2-150+260,dimension.height/2+10,20,20);
        unstackableAnswer.setBounds(dimension.width/2-150+270,dimension.height/2-30,20,20);
        current.setBounds(dimension.width/2-100,60,200,100);
        next.setBounds(dimension.width/2-100,dimension.height/2+100,200,100);

        SlotCalc.window.getContentPane().add(current);
        SlotCalc.window.getContentPane().add(stackable);
        SlotCalc.window.getContentPane().add(stackableAnswer);
        SlotCalc.window.getContentPane().add(unstackable);
        SlotCalc.window.getContentPane().add(unstackableAnswer);
        SlotCalc.window.getContentPane().add(next);
    }
}
