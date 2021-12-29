package me.slotcalc.screen;

import me.slotcalc.SlotCalc;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(){
        this.setLayout(null);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(dimension.width/2-512,dimension.height/2-350,1024,700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        SlotCalc.currentScreen.paint(g);
    }
}
