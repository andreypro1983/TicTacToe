package ru.gb.HW1.chat.developers;

import ru.gb.HW1.chat.developers.interfaces.BackAction;
import ru.gb.HW1.chat.developers.interfaces.FrontAction;

public class FullStackDeveloper implements BackAction, FrontAction {

    private String name;

    public FullStackDeveloper(String name) {
        this.name = name;
    }

    @Override
    public void developBack() {
        System.out.println("Сотрудник " + name + " пишет бизнес-логику");
    }

    @Override
    public void developGUI() {
        System.out.println("Сотрудник " + name + " создает графический интерфейс");
    }
}
