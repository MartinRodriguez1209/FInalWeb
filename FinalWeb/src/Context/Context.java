/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Context {

    public static com.mysql.jdbc.Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root", "root");
    }
}
