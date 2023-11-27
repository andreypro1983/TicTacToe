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
        for (Developer dev : devs) {
            if (dev instanceof Backender) {
                ((Backender) dev).developBack();
            } else if (dev instanceof Frontender) {
                ((Frontender) dev).developGUI();
            } else if (dev instanceof FullStackDeveloper) {
                ((FullStackDeveloper) dev).developGUI();
                ((FullStackDeveloper) dev).developBack();
            } else {
                System.out.println("Специализация сотрудника неизвестна");
            }
        }
    }
}
