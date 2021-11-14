package ru.geekbrains.jca.lessons.l1_intro;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Homework4 {
    private static final char cell_X = 'X';
    private static final char cell_0 = '0';
    private static final char cell_EMPTY = '.';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int scoreHuman;
    private static int scoreComp;
    private static int roundCounter;
    private static int symbolsForWin;
    private static char turn;
    private static char symbolHuman;
    private static char symbolComp;
    private static boolean compTurn;
    private static int whoWin; //0 - draw, 1 - human, 2 - comp

    public static void main (String[] args){
// 1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку.
        initGame();
        playGame();
    }
    private static void playGame() {
        int currRound = roundCounter;
        do {
            if(checkDraw()){
                printField();
                System.out.println("The game ended in a draw.");
                whoWin = 0;
                if (endGame(whoWin)){
                    break;
                }
            }
            if (currRound != roundCounter) {
                System.out.printf("Round number %d. Score:    You    Computer\n", roundCounter + 1);
                System.out.printf("                           %d.      %d\n", scoreHuman, scoreComp);
                currRound = roundCounter;
            }
            if (turn == 'C') {
                turnComp();
                if (checkWin(symbolComp)) {
                    whoWin = 2;
                    System.out.println("Computer win!");
                    printField();
                    if (endGame(whoWin)){
                        break;
                    }
                } else {
                    System.out.println("You turn.");
                    turn = 'H';
                }
            } else {
                printField();
                turnHuman();
                if (checkWin(symbolHuman)) {
                    whoWin = 1;
                    System.out.println("Congratulation! You win!");
                    printField();
                    if (endGame(whoWin)){
                        break;
                    }
                } else {
                    turn = 'C';
                }
            }
        } while(true);
    }
    private static boolean checkDraw() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[j][i] == cell_EMPTY) return false;
            }
        }
        return true;
    }
    private static boolean endGame(int whoW) {
        System.out.print("Would you like to continue the game? (y/n) ");
        String choice = scanner.next();
        if (choice.toLowerCase().equals("y")) {
            roundCounter++;
            if (whoW == 2) {
                scoreComp++;
                turn = 'C';
            } else if (whoW == 1){
                scoreHuman++;
                turn = 'H';
            }
        } else {
                System.out.println("It was interesting to play with you. See you again...");
                return true;
            }
            System.out.println("A good choice! Let's continue.");
            initFields(fieldSizeX, fieldSizeY);
        return false;
    }

    private static void turnComp() {
        boolean compTurn = false;
        int cellX, cellY;
        int method = 0;
        int methodhum = 0;
        int maxcount = 0;
        int maxcounthum = 0;
        int posX = 0;
        int posY = 0;
        int posXhum = 0;
        int posYhum = 0;
        int posXlastHum;
        int posYlastHum;
// Ищем "своих" на поле ))
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                int count0 = (checkSymbolsComp(j, i, 1, 0, symbolsForWin, symbolComp));
                if (count0 > maxcount) {
                    method = 1;
                    maxcount = count0;
                    posX = j;
                    posY = i;
                }
                int count1 = (checkSymbolsComp(j, i, 1, 1, symbolsForWin, symbolComp));
                if (count1 > maxcount) {
                    method = 2;
                    maxcount = count1;
                    posX = j;
                    posY = i;
                }
                int count2 = (checkSymbolsComp(j, i, 0, 1, symbolsForWin, symbolComp));
                if (count2 > maxcount) {
                    method = 3;
                    maxcount = count2;
                    posX = j;
                    posY = i;
                }
                int count3 = (checkSymbolsComp(j, i, -1, 1, symbolsForWin, symbolComp));
                if (count3 > maxcount) {
                    method = 4;
                    maxcount = count3;
                    posX = j;
                    posY = i;
                }
            }
        }
// 4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
        for (int i = 0; i < fieldSizeY; i++) { //ищем последовательность у хумана
            for (int j = 0; j < fieldSizeX; j++) {
                int count0 = (checkSymbolsComp(j, i, 1, 0, symbolsForWin, symbolHuman));
                if (count0 > maxcounthum) {
                    methodhum = 1;
                    maxcounthum = count0;
                    posXhum = j;
                    posYhum = i;
                }
                int count1 = (checkSymbolsComp(j, i, 1, 1, symbolsForWin, symbolHuman));
                if (count1 > maxcounthum) {
                    methodhum = 2;
                    maxcounthum = count1;
                    posXhum = j;
                    posYhum = i;
                }
                int count2 = (checkSymbolsComp(j, i, 0, 1, symbolsForWin, symbolHuman));
                if (count2 > maxcounthum) {
                    methodhum = 3;
                    maxcounthum = count2;
                    posXhum = j;
                    posYhum = i;
                }
                int count3 = (checkSymbolsComp(j, i, -1, 1, symbolsForWin, symbolHuman));
                if (count3 > maxcounthum) {
                    methodhum = 4;
                    maxcounthum = count3;
                    posXhum = j;
                    posYhum = i;
                }
            }
        }
        if (maxcounthum >= symbolsForWin - 2) { //до победы осталось два хода, надо принимать меры
            switch (methodhum) {
                case 1:
                    posXlastHum = posXhum + maxcounthum - 1;
//                    posYlast = posY;
                    if (posXlastHum + 1 < fieldSizeX && field[posXlastHum + 1][posYhum] == cell_EMPTY){
                        if (posXhum - 1 >= 0 && field[posXhum - 1][posYhum] == cell_EMPTY) {
                            if (random.nextBoolean()) {
                                posXhum = posXlastHum + 1;
                                field[posXhum][posYhum] = symbolComp;
                                return;
                            }
                            else {
                                posXhum = posXhum - 1;
                                field[posXhum][posYhum] = symbolComp;
                                return;
                            }
                        } else {
                            posXhum = posXlastHum + 1;
                            field[posXhum][posYhum] = symbolComp;
                            return;
                        }
                    } else if (posXhum - 1 >= 0 && field[posXhum - 1][posYhum] == cell_EMPTY) {
                        posXhum = posXhum - 1;
                        field[posXhum][posYhum] = symbolComp;
                        return;
                    }
//                    if(maxProfitTurnComp(posX, posY, 1, 0, symbolsForWin, symbolComp, maxcount))return;
                    break;
                case 2:
                    posXlastHum = posXhum + maxcounthum - 1;
                    posYlastHum = posYhum + maxcounthum - 1;
                    if (posXlastHum + 1 < fieldSizeX && posYlastHum + 1 < fieldSizeY && field[posXlastHum + 1][posYlastHum + 1] == cell_EMPTY){
                        if (posXhum - 1 >= 0 && posYhum - 1 >=0 && field[posXhum - 1][posYhum - 1] == cell_EMPTY) {
                            if (random.nextBoolean()) {
                                posXhum = posXlastHum + 1;
                                posYhum = posYlastHum + 1;
                                field[posXhum][posYhum] = symbolComp;
                                return;
                            }
                            else {
                                posXhum = posXhum - 1;
                                posYhum = posYhum - 1;
                                field[posXhum][posYhum] = symbolComp;
                                return;
                            }
                        } else {
                            posXhum = posXlastHum + 1;
                            posYhum = posYlastHum + 1;
                            field[posXhum][posYhum] = symbolComp;
                            return;
                        }
                    } else if (posXhum - 1 >= 0 && posYhum - 1 >=0 && field[posXhum - 1][posYhum - 1] == cell_EMPTY) {
                        posXhum = posXhum - 1;
                        posYhum = posYhum - 1;
                        field[posXhum][posYhum] = symbolComp;
                        return;
                    }
//                    if (maxProfitTurnComp(posX, posY, 1, 1, symbolsForWin, symbolComp, maxcount))return;
                    break;
                case 3:
                    posYlastHum = posYhum + maxcounthum - 1;
                    if (posYlastHum + 1 < fieldSizeY && field[posXhum][posYlastHum + 1] == cell_EMPTY){
                        if (posYhum - 1 >= 0  && field[posXhum][posYhum - 1] == cell_EMPTY) {
                            if (random.nextBoolean()) {
                                posYhum = posYlastHum + 1;
                                field[posXhum][posYhum] = symbolComp;
                                return;
                            }
                            else {
                                posYhum = posYhum - 1;
                                field[posXhum][posYhum] = symbolComp;
                                return;
                            }
                        } else {
                            posYhum = posYlastHum + 1;
                            field[posXhum][posYhum] = symbolComp;
                            return;
                        }
                    } else if (posYhum - 1 >=0 && field[posXhum][posYhum - 1] == cell_EMPTY) {
                        posYhum = posYhum - 1;
                        field[posXhum][posYhum] = symbolComp;
                        return;
                    }
//                    if (maxProfitTurnComp(posX, posY, 0, 1, symbolsForWin, symbolComp, maxcount))return;
                    break;
                case 4:
                    posXlastHum = posXhum - maxcounthum + 1;
                    posYlastHum = posYhum + maxcounthum - 1;
                    if (posXlastHum - 1 >= 0 && posYlastHum + 1 < fieldSizeY && field[posXlastHum - 1][posYlastHum + 1] == cell_EMPTY){
                        if (posXhum + 1 < fieldSizeY && posYhum - 1 >= 0 && field[posXhum + 1][posYhum - 1] == cell_EMPTY) {
                            if (random.nextBoolean()) {
                                posXhum = posXlastHum + 1;
                                posYhum = posYlastHum - 1;
                                field[posXhum][posYhum] = symbolComp;
                                return;
                            }
                            else {
                                posXhum = posXhum - 1;
                                posYhum = posYhum + 1;
                                field[posXhum][posYhum] = symbolComp;
                                return;
                            }
                        } else {
                            posXhum = posXlastHum + 1;
                            posYhum = posYlastHum - 1;
                            field[posXhum][posYhum] = symbolComp;
                            return;
                        }
                    } else if (posXhum + 1 < fieldSizeX && posYhum - 1 >= 0 && field[posXhum + 1][posYhum - 1] == cell_EMPTY) {
                        posXhum = posXhum + 1;
                        posYhum = posYhum - 1;
                        field[posXhum][posYhum] = symbolComp;
                        return;
                    }
//                    if (maxProfitTurnComp(posX, posY, -1, 1, symbolsForWin, symbolComp, maxcount))return;
                    break;
            }
        }
        if (maxcount == 0) {
// Ставим в центре! ))
            if (fieldSizeX % 2 == 0) cellX = fieldSizeX / 2 - 1;
            else cellX = fieldSizeX / 2;
            if (fieldSizeY % 2 == 0) cellY = fieldSizeY / 2 - 1;
            else cellY = fieldSizeY / 2;
            if (field[cellY][cellX] == cell_EMPTY) field[cellY][cellX] = symbolComp;
            else {
                randomTurn(cellY, cellX);
            }
        } else {
            switch (method) {
                case 1:
                    if(maxProfitTurnComp(posX, posY, 1, 0, symbolsForWin, symbolComp, maxcount))return;
                    else randomTurn(posX,posY);
                    break;
                case 2:
                    if (maxProfitTurnComp(posX, posY, 1, 1, symbolsForWin, symbolComp, maxcount))return;
                    else randomTurn(posX,posY);
                    break;
                case 3:
                    if (maxProfitTurnComp(posX, posY, 0, 1, symbolsForWin, symbolComp, maxcount))return;
                    else randomTurn(posX,posY);
                    break;
                case 4:
                    if (maxProfitTurnComp(posX, posY, -1, 1, symbolsForWin, symbolComp, maxcount))return;
                    else randomTurn(posX,posY);
                    break;
            }
        }
    }

    private static void randomTurn(int x, int y) {
        int rnd;
        int count = 0;
        while (true) {
            count++;
            rnd = random.nextInt(8);
            switch (rnd) {
                case 0:
                    if (x + 1 < fieldSizeX && field[x + 1][y] == cell_EMPTY){
                        field[x + 1][y] = symbolComp;
                        return;
                    }
                    break;
                case 1:
                    if (x + 1 < fieldSizeX && y + 1 < fieldSizeY && field[x + 1][y + 1] == cell_EMPTY) {
                        field[x + 1][y + 1] = symbolComp;
                        return;
                    }
                    break;
                case 2:
                    if (y + 1 < fieldSizeY && field[x][y + 1] == cell_EMPTY) {
                        field[x][y + 1] = symbolComp;
                        return;
                    }
                    break;
                case 3:
                    if (x - 1 >= 0 && y + 1 < fieldSizeY && field[x - 1][y + 1] == cell_EMPTY) {
                        field[x - 1][y + 1] = symbolComp;
                        return;
                    }
                    break;
                case 4:
                    if (x - 1 >= 0 && field[x - 1][y] == cell_EMPTY) {
                        field[x - 1][y] = symbolComp;
                        return;
                    }
                    break;
                case 5:
                    if (x - 1 >= 0 && y - 1 >= 0 && field[x - 1][y - 1] == cell_EMPTY) {
                        field[x - 1][y - 1] = symbolComp;
                        return;
                    }
                    break;
                case 6:
                    if (y - 1 >= 0 && field[x][y - 1] == cell_EMPTY) {
                        field[x][y - 1] = symbolComp;
                        return;
                    }
                    break;
                case 7:
                    if (x + 1 < fieldSizeX && y - 1 >= 0 && field[x + 1][y - 1] == cell_EMPTY) {
                        field[x + 1][y - 1] = symbolComp;
                        return;
                    }
                    break;
            }
            if (count > 1000) break;
        }
        randomTurnFull();
    }
    private static void randomTurnFull() {
        int x;
        int y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
            if (field[x][y] == cell_EMPTY) {
                field[x][y] = symbolComp;
                return;
            }
        } while (true);

    }
    private static boolean maxProfitTurnComp(int x, int y, int incX, int incY, int length, char symbol, int cnt){
        int count = 0;
        int endX = x + (length - 1) * incX;
        int endY = y + (length - 1) * incY;
        if (endX >= 0 && endX < fieldSizeX && endY >= 0 && endY < fieldSizeY);
        else {
            incX = -incX;
            incY = -incY;
            endX = x + (length - 1) * incX;
            endY = y + (length - 1) * incY;
            if (endX >= 0 && endX < fieldSizeX && endY >= 0 && endY < fieldSizeY);
            else {
                randomTurn(x, y);
                return true;
            }
        }
            for (int i = 0; i < length; i++) {
                if (field[x + i * incX][y + i * incY] == symbolComp) {
                    count++;
                    if (count == cnt) {
                        if (incX == 1) {
                            switch (incY) {
                                case 0:
                                    if (x + i * incX + 1  < fieldSizeX && field[x + i * incX + 1][y + i * incY] == cell_EMPTY) {
                                        field[x + i * incX + 1][y + i * incY] = symbolComp;
                                        return true;
                                    } else if (x + i * incX - 1 >= 0 && field[x + i * incX][y + i * incY] == cell_EMPTY) {
                                        field[x + i * incX][y + i * incY] = symbolComp;
                                        return true;
                                    } else {
                                        return false;
                                    }
                                case 1:
                                    if (y + i * incY + 1 < fieldSizeX && x + i * incX + 1 < fieldSizeY && field[x + i * incX + 1][y + i * incY + 1] == cell_EMPTY) {
                                        field[x + i * incX + 1][y + i * incY + 1] = symbolComp;
                                        return true;
                                    } else if (y + i * incY - 1  >= 0 && x + i * incX - 1 >= 0 &&
                                            field[x + i * incX - 1][y + i * incY - 1] == cell_EMPTY) {
                                        field[x + i * incX - 1][y + i * incY - 1] = symbolComp;
                                        return true;
                                    } else {
                                        randomTurn(x, y);
                                        return true;
                                    }
                            }
                        } else if (incX == 0){
                            if (y + i * incY + 1 < fieldSizeY && field[x + i * incX][y + i * incY + 1] == cell_EMPTY) {
                                field[x + i * incX][y + i * incY + 1] = symbolComp;
                                return true;
                            } else if (y + i * incY - 1 >= 0 &&
                                    field[x + i * incX][y + i * incY - 1] == cell_EMPTY) {
                                field[x + i * incX][y + i * incY - 1] = symbolComp;
                                return true;
                            } else {
                                randomTurn(x, y);
                                return true;
                            }
                        } else if (incX == -1) {
                            if (y + i * incY + 1 >= 0 && x + i * incX - 1 >= 0 && field[x + i * incX - 1][y + i * incY + 1] == cell_EMPTY) {
                                field[x + i * incX - 1][y + i * incY + 1] = symbolComp;
                                return true;
                            } else if (y + i * incY + 1 < fieldSizeX && x + i * incX - 1 >= 0 &&
                                    field[x + i * incX - 1][y + i * incY +  1] == cell_EMPTY) {
                                field[x + i * incX - 1][y + i * incY + 1] = symbolComp;
                                return true;
                            } else {
                                randomTurn(x, y);
                                return true;
                            }
                        }
                    }
                }
            }
        randomTurn(x, y);
        return true;
    }
    private static int checkSymbolsComp(int x, int y, int incX, int incY, int length, char symbol){
        int count = 0;
//        int endX = x + (length - 1) * incX;
//        int endY = y + (length - 1) * incY;
//        if (endX >= 0 && endX < fieldSizeX && endY >= 0 && endY < fieldSizeY) {
        while (true){
            for (int i = 0; i < length; i++) {
                if (y + i * incY >= 0 && x + i * incX >= 0 && y + i * incY < fieldSizeY && x + i * incX < fieldSizeX) {
                    if (field[x + i * incX][y + i * incY] == symbol) count++;
                    else return count;
                }
                else return count;
            }
        }
    }
    private static boolean checkWin(char symbol){
// 2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
// 3. Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
//    Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (checkLine(j, i, 1, 0, symbolsForWin, symbol)) return true;
                if (checkLine(j, i, 1, 1, symbolsForWin, symbol)) return true;
                if (checkLine(j, i, 0, 1, symbolsForWin, symbol)) return true;
                if (checkLine(j, i, -1, 1, symbolsForWin, symbol)) return true;
            }
        }
        return false;
    }
    private static boolean checkLine(int x, int y, int incX, int incY, int length, char symbol){
        int count = 0;
        int endX = x + (length - 1) * incX;
        int endY = y + (length - 1) * incY;
        if (endX >= 0 && endX < fieldSizeX && endY >= 0 && endY < fieldSizeY){
            for (int i = 0; i < length; i++) {
                if (field[x + i * incX][y + i * incY] != symbol) return false;
                count++;
            }
            if (count == length) return true;
        }
        return false;
    }
    private static void turnHuman() {
        int x, y;
        do {
            System.out.print("Enter X & Y separated by a space. ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
            if (fieldSizeX > x && fieldSizeY > y) {
                if (checkEmptyCell(x, y)) {
                    field[x][y] = symbolHuman;
                    turn = 'C';
//                    printField();
                    break;
                } else System.out.println("Invalid input. Try again.");
            }
            else {
                System.out.println("Invalid input. Try again. ");
            }
        } while (true);
    }
    private static boolean checkEmptyCell(int x, int y){
        if (field[x][y] == '.') return true;
        return false;
    }
    private static void printField() {
        for (int i = 0; i < fieldSizeY+2; i++) {
            for (int j = 0; j < fieldSizeX + 1; j++) {
                if (i==0) {
                    System.out.print(" " + j + " |");
                } else if (i == 1){
                    System.out.print("++++");
                } else {
                    if (j==0) {
                        int k = i - 1;
                        System.out.print(" " + k + " |");
                    }
                    else System.out.print(" " + field[j-1][i-2] + " |");
                }
            }
            System.out.println();
        }
    }
    private static void initGame() {
        System.out.println("Hello! Welcome to the game 'Tic Tac Toe'!");
        System.out.print("Please enter 'x' for play with 'X', and other for 'O': ");
        String x = scanner.next();
        if (x.toLowerCase().equals("x")) {
            symbolHuman = cell_X;
            symbolComp = cell_0;
        } else {
            symbolHuman = cell_0;
            symbolComp = cell_X;
        }
        System.out.print("Please enter field size X: ");
        fieldSizeX = scanner.nextInt();
        System.out.print("Please enter field size Y: ");
        fieldSizeY = scanner.nextInt();
        scoreComp = 0;
        scoreHuman = 0;
        roundCounter = 0;
        System.out.print("How many symbols in a row do you need to win? Enter number: ");
        symbolsForWin = scanner.nextInt();
        System.out.print("Who will turn first? Guess the number: 0 or 1. ");
        int choiceHuman = scanner.nextInt();
        int choiceComp;
        if (random.nextBoolean()) choiceComp = 0;
        else choiceComp = 1;
        if (choiceHuman == choiceComp) {
            turn = 'H';
            System.out.println("You guessed. Your first move.");
        }
        else {
            turn = 'C';
            System.out.println("You haven't guessed right. The computer goes first. ");
        }
        initFields(fieldSizeX, fieldSizeY);
   }
   private static void initFields(int x, int y) {
        field = new char[x][y];
        for (int i = 0; i < y; i++) {
           for (int j = 0; j < x; j++) {
               field[j][i] = cell_EMPTY;
           }
       }
   }
}
