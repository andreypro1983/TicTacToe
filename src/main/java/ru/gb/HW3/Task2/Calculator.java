package ru.gb.HW3.Task2;

public class Calculator {
    public static <T extends Number, U extends Number> Double sum(T value1, U value2) {
        return value1.doubleValue() + value2.doubleValue();
    }

    public static <T extends Number, U extends Number> Double subtract(T value1, U value2) {
        return value1.doubleValue() - value2.doubleValue();
    }

    public static <T extends Number, U extends Number> Double multiply(T value1, U value2) {
        return value1.doubleValue() * value2.doubleValue();
    }
    public static <T extends Number, U extends Number> Double divide(T value1, U value2) {
        return value1.doubleValue() / value2.doubleValue();
    }
}
