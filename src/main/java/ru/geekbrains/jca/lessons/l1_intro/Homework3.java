package ru.geekbrains.jca.lessons.l1_intro;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework3 {
    public static void main (String[] args){

// 1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это
// число. При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или
// меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить,
// 0 – нет).
        Random random = new Random();
        int userVal, secretVal;
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
/*        while (true) {
            secretVal = random.nextInt(10);
//            System.out.println(secretVal); // Подсказка для отладки ))
            for (int i = 0; i < 3; i++) {
                while (true){
                    System.out.print("Input number (0...9): ");
                    userVal = scanner.nextInt();
                    if (userVal >= 0 && userVal <= 9) { // Проверка диапазона 0...9
                        break;
                    }
                    System.out.println("Error! Try again.");
                }
                if (userVal > secretVal) {
                    System.out.println("Your number is greater.");
                } else if (userVal < secretVal) {
                    System.out.println("Your number is less.");
                } else {
                    System.out.println("Congratulation! You win!");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("You lose...");
            }
            System.out.print("Try again ? Input number (1 - yes, 0 - no): ");
            userVal = scanner.nextInt();
            if (userVal == 0) break;
        }
 */
// 2.  Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
// "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
// "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}. При запуске программы компьютер
// загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли
// ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах. apple –
// загаданное apricot - ответ игрока ap############# (15 символов, чтобы пользователь не мог узнать длину слова) Для
// сравнения двух слов посимвольно можно пользоваться: String str = "apple"; char a = str.charAt(0); - метод, вернет
// char, который стоит в слове str на первой позиции Играем до тех пор, пока игрок не отгадает слово. Используем
// только маленькие буквы.
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String userStr, workStr;
        int numbGuessLetters, lengthArr, randVal = random.nextInt(words.length - 1);
        for (int i = 0; i < words.length; i++) { // Это - подсказка: выводит все слова в массиве, из которого
            System.out.print(words[i] + " ");    // случайно выбирается одно. Для усложнения можно убрать
        }                                        // эти строки программы.
        System.out.println();
        System.out.println(words[randVal]);      // Здесь выводится выбранное компом слово (для упрощения) )))
        while (true) {
            numbGuessLetters = 0;
            workStr = "";
            System.out.print("Choose word (type only lower case): ");
            userStr = scanner.next();
            if (words[randVal].length() >= userStr.length()) lengthArr = userStr.length();
            else lengthArr = words[randVal].length();
            for (int i = 0; i < lengthArr; i++) {
                if (words[randVal].charAt(i) == userStr.charAt(i)) {
                    workStr += userStr.charAt(i);
                    numbGuessLetters++;
                } else {
                    workStr += "#";
                }
            }
            if (words[randVal].equals(workStr)){
                System.out.println("Congratulations! You guessed the word '" + workStr + "'.");
                break;
            }
            if (workStr.length() < 15) {
                for (int i = workStr.length(); i < 15; i++) {
                    workStr += "#";
                }
            }
            System.out.println("Failure. You guessed " + numbGuessLetters + " letters: " + workStr + ".");
            System.out.print("For continue input any symbol. ");
            scanner.next();
        }
    }
}
