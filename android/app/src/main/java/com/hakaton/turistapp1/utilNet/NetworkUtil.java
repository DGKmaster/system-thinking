package com.hakaton.turistapp1.utilNet;

import android.net.Uri;
import android.os.AsyncTask;

import com.hakaton.turistapp1.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class NetworkUtil {
    private static final String BASE_URL = "http://192.168.43.132:9090/server";


    private static final String PARAMS_TIME = "time";
    private static final String PARAMS_MONEY = "money";

    private static final String PARAMS_TYPE = "type";
    private static final String PARAMS_COORD1 = "coordD";
    private static final String PARAMS_COORD2 = "coordS";
    private static final String PARAMS_SORT = "sortby";

    //private static final String PARAMS_PAGE = "page";



    private static URL buildURL(int time, int money, String type, double c1, double c2, String sort) {
        URL result = null;

        Uri uri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(PARAMS_TIME, Integer.toString(time))
                .appendQueryParameter(PARAMS_MONEY, Integer.toString(money))
                .appendQueryParameter(PARAMS_TYPE, type)
                .appendQueryParameter(PARAMS_COORD1, Double.toString(c1))
                .appendQueryParameter(PARAMS_COORD2, Double.toString(c2))
                .appendQueryParameter(PARAMS_SORT, sort)
                .build();
        try {
            result = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static JSONObject getJSONFromNetwork(int time, int money, String type, double c1, double c2, String sort) {
        JSONObject result = null;
        URL url = buildURL(time, money, type, c1, c2, sort);
        try {
            result = new JSONLoadTask().execute(url).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static class JSONLoadTask extends AsyncTask<URL, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(URL... urls) {
            JSONObject result = null;
            if (urls == null || urls.length == 0) {
                return result;
            }
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) urls[0].openConnection();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                StringBuilder builder = new StringBuilder();
                String line = reader.readLine();
                while (line != null) {
                    builder.append(line);
                    line = reader.readLine();
                }
                result = new JSONObject(builder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
            return result;
        }
    }
}
