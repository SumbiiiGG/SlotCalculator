package me.slotcalc.screen.screens;

import me.slotcalc.SlotCalc;
import me.slotcalc.screen.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainScreen extends Screen {
    public MainScreen(){
        SlotCalc.window.getContentPane().removeAll();
        JButton button = new JButton("Create New Slot");
        Dimension dimension = SlotCalc.window.getSize();
        button.setBounds(dimension.width/2-200,dimension.height/2-150,400,300);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
                SlotCalc.currentScreen = new ChooseDroppersScreen();
            }
        });
        SlotCalc.window.getContentPane().add(button);
    }
}
