package main.artifact;

import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatebaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {

        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("процесс иницилизации");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        System.out.println("завершено");
        return dbConnection;
    }

    public void add_name(String name, String fename, String second_name)
    {
        System.out.println("процесс записи данных в бд");
        String insert ="INSERT INTO " +Const.STUDENT_TABLE_NAME + "(" +
        Const.STUDENT_NAME + "," + Const.STUDENT_SURNAME + "," + Const.STUDENT_PATRONYMIC + ")" +
        " VALUES(?,?,?)";
        System.out.println("завершено");


        PreparedStatement prSt  = null;
        try {
            prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, name);
            prSt.setString(2, fename);
            prSt.setString(3, second_name);
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void add_score(String score) {
        System.out.println("процесс записи данных в бд");
        String insert = "INSERT INTO " + Const.STUDENT_TABLE_SCORE + "(" +
                Const.STUDENT_TABLE_SCORE + ")" +
                " VALUES(?)";
        System.out.println("завершено");
        PreparedStatement prSt  = null;
        try {
            prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, score);
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void add_grope(String groop) {
        System.out.println("процесс записи данных в бд");
        String insert = "INSERT INTO " + Const.STUDENT_TABLE_GROOP + "(" +
                Const.STUDENT_TABLE_GROOP + ")" +
                " VALUES(?)";
        System.out.println("завершено");
        PreparedStatement prSt  = null;
        try {
            prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, groop);
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void add_data(int i) {
        System.out.println("процесс записи данных в бд");
        String insert = "INSERT INTO " + Const.STUDENT_TABLE + "(" +
                Const.STUDENT_IDNAME + "," + Const.STUDENT_IDGROOP + "," + Const.STUDENT_IDSCORE + ")" +
                " VALUES("+i+","+i+","+i+")";
        System.out.println("завершено");


    }
}
