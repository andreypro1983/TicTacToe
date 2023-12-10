package ru.gb.HW3.Task2;
//Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
// sum(), multiply(), divide(), subtract(). Параметры этих методов – два
// числа разного типа, над которыми должна быть произведена операция.


import static ru.gb.HW3.Task2.Calculator.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.sum(5, 2.6));
        System.out.println(Calculator.divide(15, 3.0));
        System.out.println(Calculator.divide(5, 0.0));
        System.out.println(Calculator.multiply(8L, 4.5));
        System.out.println(Calculator.subtract(2.5, 2f));
    }


}

