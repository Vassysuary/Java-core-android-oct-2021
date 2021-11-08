package ru.geekbrains.jca.lessons.l1_intro;

public class Employee {
//
// 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
// 2. Конструктор класса должен заполнять эти поля при создании объекта.
// 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.

    String firstName;
    String secondName;
    String thirdName;
    String position;
    String e_mail;
    String phoneNumber;
    int salary;
    int age;

    public Employee(String firstName, String secondName, String thirdName, String position, String e_mail, String phoneNumber, int salary, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.position = position;
        this.e_mail = e_mail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    void printEmployee() {
        System.out.printf("Name: %s %s %s. Position: %s. E-mail: %s. Phone: %s. Salary: %d. Age: %d\n", firstName, secondName, thirdName, position, e_mail, phoneNumber, salary, age);
    }
}
