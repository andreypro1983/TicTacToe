package ru.gb.HW3.Task3;

public class Pair <T,U>{
    T first;
    U second;

    public Pair() {
        this.first = null;
        this.second = null;
    }

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }

    public U getSecond(){
        return second;
    }

    @Override
    public String toString() {
        return "first element: "+first +", second element: "+second;
    }
}
