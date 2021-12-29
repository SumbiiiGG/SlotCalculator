package me.slotcalc;

import me.slotcalc.screen.Screen;
import me.slotcalc.screen.Window;
import me.slotcalc.screen.screens.MainScreen;
import me.slotcalc.slot.Dropper;
import me.slotcalc.slot.DroppersChance;
import me.slotcalc.slot.Slot;

import java.util.ArrayList;
import java.util.List;

public class SlotCalc {
    public static List<Dropper> droppers = new ArrayList<>();
    public static Screen currentScreen;
    public static Window window;
    public static void main(String[] args) {
        window= new Window();
        currentScreen = new MainScreen();
    }
}
