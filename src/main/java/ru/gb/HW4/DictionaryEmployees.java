package ru.gb.HW4;

import java.util.ArrayList;
import java.util.List;


public class DictionaryEmployees<T extends Employee> {
    List<T> employees;

    public DictionaryEmployees(List<T> employees) {
        this.employees = employees;
    }

    public DictionaryEmployees() {
        this(new ArrayList<>());
    }

    public void add(T employee) {
        employees.add(employee);
    }


    public List<T> findEmployeeByExperience(int value) {
        List<T> newList = new ArrayList<>();
        if (employees.isEmpty()) return newList;
        for (T employee : employees) {
            if (employee.getExperience() == value) {
                newList.add(employee);
            }
        }
        return newList;
    }

    public List<String> findPhoneByName(String employeeName) {
        List<String> newList = new ArrayList<>();
        if (employees.isEmpty()) return newList;
        for (T element : employees) {
            if (element.getName().equals(employeeName)) {
                newList.add(element.getPhone());
            }
        }
        return newList;
    }

    public T findEmployeeById(int id) {
        if (employees.isEmpty()) {
            return null;
        }
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }


    public void showInfo() {
        for (T employee : employees) {
            System.out.println(employee);
        }
    }
}
