package system_thinking;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Locations {
    private static volatile Locations instance;

    private Connection connection = null;
    private List<Location> locationsList = new ArrayList<>();
    private List<Route> routesList = new ArrayList<>();

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
            ResultSet rs = statement.executeQuery( "select * from sights" );

            Location tempLocation;

            while (rs.next()) {
                tempLocation = new Location(
                        rs.getInt( "id_place" ),
                        rs.getString( "title" ),
                        rs.getFloat( "coords" ),
                        rs.getFloat( "coordd" ),
                        rs.getString( "description" ),
                        rs.getString( "imgurl"),
                        rs.getFloat( "rating" ),
                        rs.getInt( "route" ),
                        rs.getFloat( "money" )
                );
                locationsList.add( tempLocation );
            }

            Statement statement2 = connection.createStatement();
            ResultSet rs2 = statement2.executeQuery( "select * from routes" );

            Route tempRoute;

            while (rs2.next()) {
                tempRoute = new Route(
                        rs2.getInt( "id_route" ),
                        rs2.getString( "title" ),
                        rs2.getInt( "placesnumber" ),
                        rs2.getString( "description" ),
                        rs2.getInt( "time" ),
                        rs2.getFloat( "rating" )
                );
                routesList.add( tempRoute );
            }
            System.out.println( routesList );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public String fetchLocationByID(int id_place) {
        JsonObject location = new JsonObject();
        //StringBuilder locationJson = new StringBuilder( );
        for (Location tempLoc : this.locationsList) {
            if (tempLoc.getId_place() == id_place) {
                location.addProperty("id_place", tempLoc.getId_place());
                location.addProperty("title", tempLoc.getGeoname());
                location.addProperty("coords", tempLoc.getLon());
                location.addProperty("coordd", tempLoc.getLat());
                location.addProperty("description", tempLoc.getDescription());
                location.addProperty("imgurl", tempLoc.getImg());
                location.addProperty("rating", tempLoc.getRating());
                location.addProperty("route", tempLoc.getRoute());
                location.addProperty("money", tempLoc.getMoney());
                System.out.println(location.toString());

            }
        }
        String result = location.toString();
        return result;
    }

    public String fetchRoutes(int userTimeLimit, int userMoney, String type, float myCoordD, float myCoordS, String sortby) {
        JSONObject arrayObject = new JSONObject();

        JsonObject newTest = new JsonObject();
        String result;
        try {
            JsonArray aTest = new JsonArray( );

            JSONArray arrayRes = new JSONArray();
            for (Route tempRoute : this.routesList) {
                //if (tempRoute.getTime() < userTimeLimit) {
                    JSONObject routeResult = new JSONObject();

                    JsonObject rTest = new JsonObject();
                    rTest.addProperty( "id_route", tempRoute.getId_route() );
                    rTest.addProperty( "id_route",  tempRoute.getTitle()  );

                    routeResult.put("id_route", tempRoute.getId_route());
                    routeResult.put("title", tempRoute.getTitle() );
                    routeResult.put("placesNumber", tempRoute.getPlacesnumber());
                    routeResult.put("time", tempRoute.getTime() );
                    routeResult.put("rating", tempRoute.getRating());
                    arrayRes.put(routeResult);
                    aTest.add( rTest );
                //}
            }
            arrayObject.put("RoutesList", arrayRes);

            newTest.add( "Test Route", aTest );
        } catch (JSONException jse) {
            jse.printStackTrace();
        }
        result = newTest.toString();
        return result;
    }
}
