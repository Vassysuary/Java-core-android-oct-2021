package ru.geekbrains.jca.lessons.l1_intro;

public class Homework5 {
    public static void main (String[] args) {
// 4. Создать массив из 5 сотрудников. Пример: Person[] persArray = new Person[5];
//    Вначале объявляем массив объектов persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
//    потом для каждой ячейки массива задаем объект persArray[1] = new Person(...); ... persArray[4] = new Person(...);
    Employee[] persArray = new Employee[5];
    persArray[0] = new Employee("Ivanov", "Ivan", "Ivanovich", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
    persArray[1] = new Employee("Petrov", "Petr", "Petrovich", "Manager", "petrpetr@hotbox.com", "892102312", 30000, 23);
    persArray[2] = new Employee("Sidorov", "Sidor", "Sidorovich", "Moderator", "sidsid@mail.ru", "890212952", 30000, 43);
    persArray[3] = new Employee("Vasiliev", "Vasilii", "Vasilievich", "Writer", "vasvasil@hotmail.com", "892588312", 25000, 45);
    persArray[4] = new Employee("Vektorov", "Viktor", "Viktorovich", "Cleaner", "vikviktr@pisem.net", "892912802", 15000, 50);
// 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        int checkAge = 40; // возраст
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].age > checkAge) persArray[i].printEmployee();
        }
    }
}
