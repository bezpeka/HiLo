package com.javarush.task.task06.task0616;

/*
Минимальное число статиков

Расставь минимальное количество static-ов, чтобы код начал работать, и программа успешно завершилась.
Выполнение программы начинается с метода main( ), поэтому начнём с него.

1. В методе main( ) производится вызов метода method1( ).
Поскольку method1( ) вызывается из статического контекста без создания объекта
(как известно, метод main( ) всегда статический), то и method1( ) также должен быть статическим.
2. Из-за того, что method1( ) теперь статический, method2( ) тоже должен быть статическим,
чтобы его можно было вызвать в теле метода method1( ) (по аналогии с п.1).
3. Теперь метод method3( ) также вызывается из статического контекста
(из метода method2( ) ), но он вызывается не напрямую,
а посредством создаваемого объекта new Solution( ).
Поэтому делать method3( ) статическим нет необходимости
4. В методе method4( ) в консоль выводится стек-трейс – перечень методов,
которые были вызваны к текущему моменту. После этого проверяется значение переменной step,
и если оно не превышает 1, опять вызывается метод main( ) и цепочка вызовов
main( ) – method1( ) – method2( ) – method3( ) – method4( ) повторяется.
В итоге получается замкнутая петля: в теле method4( ) снова проверяется значение переменной step,
но оно снова равно 1, потому что переменная step существует только в пределах объекта Solution,
а этот объект каждый раз создаётся заново в методе method2( ).
Иными словами, оператор инкремента step++ увеличивает на 1 значение новой переменной step
во вновь созданном объекте (напомню, изначально при создании объекта step = 0);
предыдущий объект Solution  пропадает после выхода из method4( ), ведь ссылка на него нигде не сохраняется.
Чтобы разорвать бесконечный «замкнутый круг» необходимо сделать статической переменную step.
Тогда эта переменная будет существовать в пределах класса Solution, а это значит,
что она будет доступна без создания объекта типа Solution.
Теперь её значение будет сохраняться после инкрементирования step++, увеличиваясь на 1 при каждом вызове method4( ).
В конце «второго круга» значение step станет равным 2, и метод method4( ) завершится командой return,
завершая в итоге всю программу.
*/

public class Solution {
    // 3. Поле step должно быть статическим, чтобы его значение сохранялось
    //    вне зависимости от создания объектов типа Solution:
    public static int step;

    public static void main (String[] args) {
        method1 ();
    }

    // 1. Поскольку method1() вызывается из статического метода main() без создания объекта,
    //    method1() также должен быть статическим:
    public static void method1 () {
        method2 ();
    }

    // 2. Из-за того, что method1() теперь статический, method2() также должен быть статическим,
    //    чтобы его можно было вызвать в теле метода method1() (по аналогии с п.1):
    public static void method2 () {
        new Solution ().method3 ();
    }

    //Теперь метод method3( ) также вызывается из статического контекста
    //(из метода method2( ) ), но он вызывается не напрямую,
    //а посредством создаваемого объекта new Solution( ).
    public void method3 () {
        method4 ();
    }

    public void method4 () {
        step++;
        for (StackTraceElement element : Thread.currentThread ().getStackTrace ())
            System.out.println (element);
        if (step > 1)
            return;
        main (null);
    }
}
//TODO Вроде описано подробно, но не понял, разобрать