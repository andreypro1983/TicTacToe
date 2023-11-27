package ru.gb.HW2.developers;

import ru.gb.HW2.developers.interfaces.BackAction;

public class Backender implements BackAction {

    private String name;

    public Backender(String name) {
        this.name = name;
    }


    @Override
    public void developBack() {
        System.out.println("Сотрудник " + name + " пишет бизнес-логику");
    }
}
