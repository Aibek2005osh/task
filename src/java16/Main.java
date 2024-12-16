package java16;

import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LinkedList<String> students = new LinkedList<>();
        students.add("Aibek");
        students.add("Amir");
        students.add("Baiel");
        students.add("Muhammedaly");

        System.out.println("birinchi : " + students.getFirst());

        System.out.println("Akyrkysy : " + students.getLast());

        System.out.println("Amir : " + students.contains("Amir"));

        LinkedList<String> strings = students;

        System.out.println(strings);

        System.out.println(strings.equals(students));

        System.out.println(students.isEmpty());

        System.out.println(students.set(3, "ernis"));
        System.out.println(students);

    }
}

