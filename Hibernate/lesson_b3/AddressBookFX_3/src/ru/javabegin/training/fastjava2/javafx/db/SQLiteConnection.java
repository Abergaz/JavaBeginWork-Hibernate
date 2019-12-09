package ru.javabegin.training.fastjava2.javafx.db;

import java.io.File;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SQLiteConnection {
    
    private static Connection con;
    
    public static Connection getConnection(){
        try {
              Driver driver = (Driver) Class.forName("org.sqlite.JDBC").newInstance();

             // путь к БД желательно выносить в отдельный файл настроек
              String url = "jdbc:sqlite:db"+ File.separator+"addressbook.db";
              
              if (con==null) {
                  con = DriverManager.getConnection(url);
              }
              
              return con;
              
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

}
