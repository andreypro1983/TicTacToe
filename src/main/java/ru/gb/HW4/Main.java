package ru.gb.HW4;

//Необходимо:
//        ● Создать класс справочник сотрудников, который
//        содержит внутри коллекцию сотрудников - каждый
//        сотрудник должен иметь следующие атрибуты:
//        ○ Табельный номер
//        ○ Номер телефона
//        ○ Имя
//        ○ Стаж
//        ● Добавить метод, который ищет сотрудника по стажу
//        (может быть список)
//        ● Добавить метод, который выводит номер телефона
//        сотрудника по имени (может быть список)
//        ● Добавить метод, который ищет сотрудника по
//        табельному номеру
//        ● Добавить метод добавление нового сотрудника в
//        справочник

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees1 = new ArrayList<>(Arrays.asList(new Employee("Brian", "89010354032"),
                new Employee("Mia", LocalDate.now().minusMonths(19),"89220357132"),
                new Employee("Chuck",LocalDate.now().minusYears(3), "89211111111")));

        DictionaryEmployees<Employee> dictionary = new DictionaryEmployees<>(employees1);

        Employee emp1 = new Employee("Sophie",LocalDate.now().minusYears(3), "82213454567");
        Employee emp2 = new Employee("Sophie",LocalDate.now().minusYears(4), "83353454567");
        dictionary.add(emp1);
        dictionary.add(emp2);
        System.out.println("------------------");
        System.out.println("Вывод списка сотрудников:");
        dictionary.showInfo();
        System.out.println("------------------");
        System.out.println("Поиск сотрудников по стажу:");
        System.out.println(dictionary.findEmployeeByExperience(4));
        System.out.println(dictionary.findEmployeeByExperience(3));
        System.out.println("------------------");
        System.out.println("Поиск номеров телефонов по имени:");
        System.out.println(dictionary.findPhoneByName("Sophie"));
        System.out.println("------------------");
        System.out.println("Поиск сотрудника по табельному номеру:");
        System.out.println(dictionary.findEmployeeById(8));
        System.out.println(dictionary.findEmployeeById(3));

    }
}
