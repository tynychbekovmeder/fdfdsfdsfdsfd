package com.company;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        LocalDate todayData = LocalDate.now();

            try {
                System.out.println("Введите имя:");
                String name = scanner.nextLine();
                if (!name.matches("[a-zA-Zа-яА-Я]*")) {
                    throw new MyException("Имя пишется с буквами");
                }

                System.out.println("Введите фамилию:");
                String lastName = scanner.nextLine();
                if (!lastName.matches("[a-zA-Zа-яА-Я]*")) {
                    throw new MyException("Фамилия пишется с буквами");
                }

                System.out.println("введите год рождения:");
                int birthday = scanner.nextInt();
                if (birthday>todayData.getYear()){
                    throw new Exception("Год рождения не может быть из будущего!");
                }

                System.out.println("Введите год начало работы:");
                int yearStarted = scanner.nextInt();
                if (yearStarted>todayData.getYear()){
                    throw new Exception("Год начало работы не может быть из будущего!");
                }

                nameAndLastName(name, lastName);
                birthdayAndYearStarted(birthday, yearStarted);

                if ((yearStarted - birthday) >= 18) {
                    System.out.println("Рабочий стаж: " + (todayData.getYear() - yearStarted));
                } else {
                    throw new MyException("Работник еще не достиг 18ти");
                }

            } catch (MyException exception) {
                System.err.println(exception.getMessage());
            } catch (InputMismatchException e) {
                System.err.println("Год рождения и Год начало работы пишется в числах!");
            }
        }
    //}

    public static void nameAndLastName(String name, String lastName) {
        System.out.println("Имя: " + name);
        System.out.println("Фамилия: " + lastName);
    }

    public static void birthdayAndYearStarted(int birthday, int yearStarted) {
        System.out.println("День рождения: " + birthday);
        System.out.println("Год начало работы: " + yearStarted);

    }

}
