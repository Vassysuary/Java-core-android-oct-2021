package ru.geekbrains.jca.lessons.l10;

import java.util.*;

public class Homework10 {

// 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных
//    слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
// 2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров. В этот
//    телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер
//    телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае
//    однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять лишний
//    функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д).
//    Консоль использовать только для вывода результатов проверки телефонного справочника.


    public static void main(String[] args) {

//  Part # 1.
        String[] arr = new String[]{"My","mistress","eyes","are","nothing","like","the","sun","Coral","is","far","more","red","than","her","lips'","red","If","snow","be","white","why","then","her","breasts","are","dun","If","hairs","be","wires","black","wires","grow","on","her","head"};
        Set<String> setList = new TreeSet<>(Arrays.asList(arr));
        System.out.println("Unique words:");
        System.out.println(setList);
        List <String> listList = new ArrayList<>(Arrays.asList(arr));
        listList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("Sorted list:");
        System.out.println(listList);
        int count = 0;
        Iterator<String> iterList = listList.iterator();
        String str1;
        String str0 = iterList.next();
        System.out.println("Number of word inclusions:");
        while (iterList.hasNext()){
            str1 = iterList.next();
//            System.out.println("str0 " + str0 + " iterList.next(): " + str1);
            if (str0.equals(str1)){
                count += 1;
            }
            else {
                System.out.println("'" + str0 + "' has " + (count+1) + " items.");
                count = 0;
                str0 = str1;
            }
        }

//  Part # 2.
        System.out.println("Task # 2.");
        Set<Phonebook> phBook = new HashSet<>();
        phBook.add(new Phonebook("Ivanov", "9525054568"));
        phBook.add(new Phonebook("Petrov", "+7250005852"));
        phBook.add(new Phonebook("Sidorov", "XXXYYYYZZZ"));
        phBook.add(new Phonebook("Ivanov", "I-V-A-N-O-V"));
        String findFamily = "Ivanov";                                           // Ищем строку Ivanov
        System.out.println("Find family: " + findFamily + "...");
        for (Phonebook p : phBook) {
            if (findFamily.equals(p.getFamily())) {
                System.out.println("Find! Family : " + p.getFamily() +", phone number: " + p.getPhoneNumber() + ".");
            }
        }
    }
}
