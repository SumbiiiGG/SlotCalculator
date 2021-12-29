package me.slotcalc.screen.screens;

import me.slotcalc.SlotCalc;
import me.slotcalc.screen.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChooseDroppersScreen extends Screen {
    public static int totalDroppers=0;
    public ChooseDroppersScreen(){
        SlotCalc.droppers = new ArrayList<>();
        JLabel question = new JLabel("Wie viele dropper hast du?");
        JTextArea answer = new JTextArea();
        JButton weiter = new JButton("Weiter");
        weiter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalDroppers = Integer.parseInt(answer.getText());
                ChooseStackableScreen.currentDropper=1;
                refresh();
                SlotCalc.currentScreen = new ChooseStackableScreen();
            }
        });
        Dimension dimension = SlotCalc.window.getSize();
        question.setBounds(dimension.width/2-100,dimension.height/2-50,200,100);
        answer.setBounds(dimension.width/2-100+155,dimension.height/2-50+40,20,20);
        weiter.setBounds(dimension.width/2-100+185,dimension.height/2-50+40,80,20);
        SlotCalc.window.getContentPane().add(question);
        SlotCalc.window.getContentPane().add(answer);
        SlotCalc.window.getContentPane().add(weiter);
    }
}
