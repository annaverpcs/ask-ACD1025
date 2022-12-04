package support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.sql.PreparedStatement;


public class DB_ConnectionHelper {

    // Constant for Database URL, contains db ip
    static final String DB_URL = "jdbc:mysql://44.198.158.182:3306/application?autoReconnect=true&useSSL=false";
    //Database Username
    static final String USER = "appuser";
    // Database Password
    static final String PASS = "Portnov321";


    public static String getAccessToken(String userEmail) throws SQLException {
        String result = "No data";

        //establish the connection
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

        try (PreparedStatement pstmt = con.prepareStatement("SELECT id, activationCode FROM users WHERE email = ?");) {
            //.setString accepts int parameterIndex, String x
            //in our db email is in the second column, so index of 1, then we want that to be called userEmail
            pstmt.setString(1, userEmail);
            //execute the query and store the results
            ResultSet rs = pstmt.executeQuery();

//loop through the results
            while (rs.next()) {
                //we need to get the id as well, to later use it to activate the right user
                result = rs.getString("id") + ";" + rs.getString("activationCode");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void activateUser(int userId, String activationCode) throws IOException, IOException {
        URL url = new URL("http://ask-internship.portnov.com/api/v1/activate/" + userId + "/" + activationCode);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "USER_AGENT");
        int responseCode = con.getResponseCode();
        System.out.println("Activation request response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response);
        } else {
            System.out.println("Error occurred while trying to send get request");
        }
    }


    ////////delete
    public static void deleteUser(int userId) throws IOException {
        URL url = new URL("http://ask-internship.portnov.com/api/v1/users/" + userId );
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("User-Agent", "USER_AGENT");
        int responseCode = con.getResponseCode();
        System.out.println("Activation request response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response);
        } else {
            System.out.println("Error occurred while trying to send get request");
        }
    }

}


