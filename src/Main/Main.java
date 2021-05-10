package Main;

import Model.MyArraylist;

public class Main {

    public static void main(String[] args) {
        MyArraylist<String> phone = new MyArraylist<>();

        phone.add("1");
        phone.add("2");
        phone.add("3");
        phone.add("4");
        phone.add("5");
        phone.add("6");
        phone.add("7");
        phone.add("8");
        phone.add("9");
        phone.add("10");
        phone.add("11");
        phone.add(6,"Me lene mike");

        phone.forEach(System.out::println);

    }
}
