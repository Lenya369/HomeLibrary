package com.leo.librarydatabase;
import com.leo.librarydatabase.Controller.Controller;
import com.leo.librarydatabase.Controller.InsertData;


public class Main{


    public static void main(String[] args) {

        System.out.println("Добро пожаловать в домашнюю библиотеку! v1.0");
        Hello();


    }

    public static void Hello(){
        System.out.println("Функции домашней библиотеки");
        System.out.println("1. Просмотр списка книг");
        System.out.println("2. Просмотр списка жанров");
        System.out.println("3. Просмотр списка авторов");
        System.out.println("4. Добавление/Удаление книги");
        System.out.print("Введие номер нужной цифры для продолжения: ");
        InsertData insertData = new InsertData();
        Controller.handlerMainMenu(insertData.InsertData());
    }
}
