package ru.gb.HW6;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.Well19937c;

public class MontyHall {
    static RandomDataGenerator rand = new RandomDataGenerator(new Well19937c());
    private static final int MIN_DOORS = 3;
    private static final int MIN_CYCLE = 100;
    public static String startTest(int countDoors, int countCycle, boolean isChange) {
        StringBuilder sb = new StringBuilder("Тестирование парадокса Монти Холла\n");
        sb.append(isChange ? "Вариант с заменой выбора\n" : "Вариант без замены выбора\n");

        if (countCycle == 0) {
            countCycle = MIN_CYCLE;
            sb.append("Используется параметр количества циклов по умолчанию равный " + MIN_CYCLE + "\n");
        }

        if (countDoors == 0) {
            countDoors = MIN_DOORS;
            sb.append("Используется параметр количества дверей по умолчанию равный " + MIN_DOORS + "\n");
        }

        int result = 0;
        for (int i = 0; i < countCycle; i++) {
            List<Door> doors = generateDoors(countDoors);
            if (start(doors, isChange)) {
                result++;
            }
        }
        sb.append("Статистика по результату:\n").
                append("Из " + countCycle + " попыток было угадано " + result + " раз \n").
                append("Процент успеха составил " + 1d * result / countCycle + " %");
        return sb.toString();
    }

    private static List<Door> generateDoors(int countDoors) {

        List<Door> doors = new ArrayList<>();

        for (int i = 0; i < countDoors; i++) {
            doors.add(new Door());
        }
        int carIndex = rand.nextInt(0,countDoors-1);
        doors.get(carIndex).setIsCar(true);
        return doors;
    }

    private static boolean start(List<Door> doors, boolean isChange) {
        int choicedDoorIndex = rand.nextInt(0,doors.size()-1);
        Door choicedDoor = doors.get(choicedDoorIndex);
        doors.remove(choicedDoorIndex);

        if (isChange) {
            doors.remove(doors.stream().filter(x -> !x.getIsCar()).findAny().get());
            return doors.stream().findAny().map(Door::getIsCar).get();
        } else {
            return choicedDoor.getIsCar();
        }
    }
}
