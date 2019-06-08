package system_thinking.server;

import com.google.gson.JsonObject;

import java.sql.*;

public class Database {
    private Connection connection = null;

    private void init() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "1234");
            JsonObject person = new JsonObject();
            person.addProperty("firstName", "Sergey");
            person.addProperty("lastName", "Kargopolov");
            System.out.println(person.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
