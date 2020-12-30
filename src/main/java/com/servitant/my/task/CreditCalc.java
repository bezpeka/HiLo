/**
 * Вы занимаете деньги у друга и вам необходимо рассчитать, сколько вы будете должны ему через 6 месяцев.
 * Каждый месяц вы будете возвращать ему по 10% от суммы долга.
 * Создайте программу, которая использует сумму долга в качестве вводных данных,
 * рассчитает и выведет в результат остаток суммы через 6 месяцев.
 * <p>
 * Пример вводных данных:
 * 20000
 * <p>
 * Пример результата:
 * 10628
 * <p>
 * График платежей:
 * Месяц 1
 * Платеж: 10% от 20000 = 2000
 * Остаток долга: 18000
 * Месяц 2
 * Платеж: 10% от 18000 = 1800
 * Остаток долга: 16200
 * Месяц 3:
 * Платеж: 10% от 16200 = 1620
 * Остаток долга: 14580
 * Месяц 4:
 * Платеж: 10% of 14580 = 1458
 * Остаток долга: 13122
 * Месяц 5:
 * Платеж: 10% of 13122 = 1313
 * Остаток долга: 11809
 * Месяц 6:
 * Платеж: 10% of 11809 = 1181
 * Остаток долга: 10628
 */

package com.servitant.my.task;

import java.util.Scanner;

public class CreditCalc{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму которую собираетесь одолжить");
        double dolg = scanner.nextInt();
        System.out.println("Введите срок, для расчета остатка долга");
        int srok = scanner.nextInt();
        System.out.println("Введите значение в процентах от суммы долга, которое собираетесь возвращать ежемесячно");
        double vernul = scanner.nextInt();
        for (double i = 0; i < srok; i++){
            dolg = dolg - (dolg * vernul / 100);
            System.out.println(dolg);
        }
        double DoubleValue = dolg;
        int IntValue = ( int ) DoubleValue;
        System.out.println("Через " + srok + " месяцев, останется вернуть " + IntValue + " денег");
        scanner.close();
    }
}