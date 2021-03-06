package com.HeadFirstJava.Game.DotComBust;

import java.util.ArrayList;

public class DotCom {
    private ArrayList < String > locationCells; //массив для хранения координатов кораблей
    int numofHits = 0; // количество попаданий

    public void setLocationCells (ArrayList < String > loc) { //метод для установки координат корабля в массив (сеттер)
        locationCells = loc;
    }

    public String checkYourself (String userinput) { //метод проверки попадания
        String result = "Мимо"; // сразу присваиваем результату значение мимо
        int index = locationCells.indexOf (userinput);
        if (index >= 0){
            locationCells.remove (index);
            if (locationCells.isEmpty ()){
                result = "Потопил";
            }
            else {
                result = "Попал";
            }
        }
        System.out.println (result);
        return result; // возвращаем результат в вызывающий метода
    }
}
