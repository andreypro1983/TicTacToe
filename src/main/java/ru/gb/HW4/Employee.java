package ru.gb.HW4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Employee {

    private static int index = 0;
    private int id;
    private String name;
    private LocalDate dateStart;
    private String phone;

    public Employee(String name, LocalDate dateStart, String phone) {
        this.id = index;
        this.name = name;
        this.dateStart = dateStart;
        this.phone = phone;
        index++;
    }

    public Employee(String name, String phone) {
        this(name,LocalDate.now(),phone);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getExperience(){
        return (int)ChronoUnit.YEARS.between(dateStart,LocalDate.now());
    }

    @Override
    public String toString() {
        return "[Сотрудник: "+name+", табельный номер: "+id+", номер телефона: "+phone+", стаж: "+getExperience()+" лет]";
    }
}
