package ru.gb.HW1.chat.developers;

import ru.gb.HW1.chat.developers.interfaces.Developer;

public class Main {
    public static void main(String[] args) {
        Developer developer1 = new Backender("Сокол Орлов");
        Developer developer2 = new Frontender("Орел Соколов");
        Developer developer3 = new FullStackDeveloper("Финист - Ясный сокол");
        Developer[] developers = {developer1, developer2, developer3};
        execute(developers);




    }

    private static void execute(Developer[] devs){
        for (int i = 0; i < devs.length; i++) {
            if (devs[i] instanceof Backender){
                ((Backender) devs[i]).developBack();
            } else if (devs[i] instanceof Frontender) {
                ((Frontender) devs[i]).developGUI();
            } else if (devs[i] instanceof FullStackDeveloper){
                ((FullStackDeveloper) devs[i]).developGUI(); ((FullStackDeveloper) devs[i]).developBack();
            } else {
                System.out.println("Специализация сотрудника неизвестна");
            }
        }
    }
}
