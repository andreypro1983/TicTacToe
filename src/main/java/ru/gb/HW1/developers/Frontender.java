package ru.gb.HW1.developers;

import ru.gb.HW1.developers.interfaces.FrontAction;

public class Frontender implements FrontAction {

    private String name;

    public Frontender(String name) {
        this.name = name;
    }


    @Override
    public void developGUI() {
        System.out.println("Сотрудник " + name + " создает графический интерфейс");
    }
}
