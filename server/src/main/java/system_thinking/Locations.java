package system_thinking;

import com.google.gson.JsonObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Locations {
    private static volatile Locations instance;

    private Connection connection = null;
    private List<Location> locationsList = new ArrayList<>();

    public static Locations getInstance() {
        Locations localInstance = instance;
        if (localInstance == null) {
            synchronized (Locations.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Locations();
                    instance.init();
                }
            }
        }
        return localInstance;
    }

    public void init() {
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "1234");

            // Statement - for queries
            Statement statement = connection.createStatement();
            statement.setQueryTimeout( 30 );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.getFromDB();
    }

    private void getFromDB() {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery( "select * from user" );

            Location tempLocation;

            while (rs.next()) {
                tempLocation = new Location(
                        rs.getInt( "geo_id" ),
                        rs.getString( "geoname" ),
                        rs.getFloat( "lon" ),
                        rs.getFloat( "lat" ),
                        rs.getString( "description" ),
                        rs.getString( "img"),
                        rs.getFloat( "rating" )
                );
                locationsList.add( tempLocation );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String fetchJson(int geo_id) {
        JsonObject location = new JsonObject();
        //StringBuilder locationJson = new StringBuilder( );
        for (Location tempLoc : this.locationsList) {
            if (tempLoc.getGeo_id() == geo_id) {
                location.addProperty("geo_id", tempLoc.getGeo_id());
                location.addProperty("geoname", tempLoc.getGeoname());
                location.addProperty("lon", tempLoc.getLon());
                location.addProperty("lat", tempLoc.getLat());
                location.addProperty("description", tempLoc.getDescription());
                location.addProperty("img", tempLoc.getImg());
                location.addProperty("rating", tempLoc.getRating());
                System.out.println(location.toString());
            }
        }
        String result = location.toString();
        return result;
    }
}
