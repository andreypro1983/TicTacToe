package ru.gb.HW3.Task1;

public class Main {
    public static void main(String[] args) {
        Number[] numArray = new Number[3];
        numArray[0] = 1;
        numArray[1] = 2.0f;
        numArray[2] = 29384759823476L;
//        MyList<Number> myList = new MyList<>();
       MyList<Number> myList = new MyList<>(numArray);
        myList.printList();

//        Integer num = 5;
//        myList.addElement(num);

//        myList.printList();
//        System.out.println("size:"+myList.getSize());
//        System.out.println("array length:"+myList.getArrayLength());
//
//        myList.removeElement(2);
//        myList.printList();
//        System.out.println("size:"+myList.getSize());
//        System.out.println("array length:"+myList.getArrayLength());

        for (Number number :
                myList) {
            System.out.println(number);
        }
    }
}
