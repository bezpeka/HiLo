package com.servitant.level4;
//Task 3 Помогите коту обрести имя с помощью метода setName.
public class Cat {
    private String name = "безымянный кот";

    public void setName (String name) {
        this.name=name;//напишите тут ваш код
/*
Имя.из.класса = переданное имя
переданное имя, это то которое приходит в сетНейм в скобочках,
т.е. (String name) Этот нейм нужно присвоить переменной нейм класса.

У нас есть класс Cat, в нем есть статическая переменная name.
Теперь нам нужно написать реализацию (внутренности) метода,
который принимает какое-то имя, и должен установить это имя в эту нашу статическую переменную класса Cat.
Вся сложность тут в том, что переменная в методе имеет такое же имя и тип,
как и статическая переменная класса. То-есть, переменная name в методе как-бы перекрыла собой статическую переменную класса.
Если бы она перекрыла не статическую переменную - то думаю мы бы поступили как в любом конструкторе или сеттере.

Но this - это когда у нас объекты есть. И внутри этого объекта - да, существует переменная this,
которая указывает на сам этот объект.
А в этой задаче - у нас все немного не так. Тут мы работаем со статическими методами и переменными,
и в статических методах у нас не существует this (почему - отдельный интересный вопрос).
Но мы уже должны знать как правильно обращаться к статическим переменным класса.
 */
    }

    public static void main (String[] args) {
        Cat cat = new Cat ();
        cat.setName ("Жужик");
        System.out.println (cat.name);
    }
}
