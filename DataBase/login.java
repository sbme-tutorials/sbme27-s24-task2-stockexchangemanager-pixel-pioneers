package DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login extends superDB{
    public static boolean  signIn(String username, String password) throws SQLException {

        statement = superDB.connect().createStatement();
        String select = "select * from users where username='" + username + "' AND password='" + password + "'";
        try {
            ResultSet resultSet = statement.executeQuery(select);
            if(resultSet.next()) {
                return true;
            }
            else {
                System.out.println("You are not signed in");
                return false;
            }

        }catch( Exception e ) {
            e.printStackTrace();

        }


        return false;
    }

}
