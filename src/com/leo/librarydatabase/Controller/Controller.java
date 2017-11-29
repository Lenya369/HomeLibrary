package com.leo.librarydatabase.Controller;
import com.leo.librarydatabase.Main;
import java.sql.*;

public class Controller {
    private static final String url = "jdbc:mysql://localhost:3306/library";
    private static final String login = "root";
    private static final String pass = "root";
    private static int indexRow = 0;
    private static InsertData insertData = new InsertData();


    public static void handlerMainMenu(int numberOption){

        switch (numberOption){
            case 1:
                ListBookOfLibrary();
                break;
            case 2:
                ListGenreOfLibrary();
                break;
            case 3:
                ListAuthorOfLibrary();
                break;
            case 4:
                System.out.println("Добавление/Удаление книги");
                break;
            default:
                System.out.println("Введите корректную цифру");
                break;
        }

    }


    private static void ListBookOfLibrary(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,login,pass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from book, author where book.author_id = author.id;");

            while (rs.next()){
                indexRow++;
                System.out.println(indexRow +": " + rs.getString("name") + " | "+ checkDataOfDb(rs.getString("fio")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        returnMenu();
    }

    private static void ListAuthorOfLibrary(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,login,pass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from author;");

            while (rs.next()){
                indexRow++;
                System.out.println(indexRow +": " + rs.getString("fio") + " | "+ checkDataOfDb(rs.getString("birthday")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        returnMenu();
    }

    private static void ListGenreOfLibrary() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,login,pass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from genre");

            while (rs.next()){
                indexRow++;
                System.out.println(indexRow +": " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        returnMenu();
    }





    private static String checkDataOfDb(String data) {
        if (data!=null){
            return data;
        }
        else return "нет данных";

    }
    private static void returnMenu() {
        System.out.println("Нажмите 0 чтобы выйти в главное меню");
        int option = insertData.InsertData();
        if (option==0){
            indexRow=0;
            Main.Hello();
        }
        else System.out.println("Попробуйте еще раз");
    }

}
