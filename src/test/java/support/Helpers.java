/*
 * Created by Artem Oganesyan on 13.09.2022
 */

package support;

import org.openqa.selenium.JavascriptExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.sql.PreparedStatement;

import static support.TestContext.getDriver;

public class Helpers {
    static final String DB_URL = "jdbc:mysql://44.198.158.182:3306/application?autoReconnect=true&useSSL=false";
    static final String USER = "appuser";
    static final String PASS = "Portnov321";

    public static String getAccessToken(String userEmail) throws SQLException {
        String result = "No data";
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

        try(PreparedStatement pstmt = con.prepareStatement("SELECT id, activationCode FROM users WHERE email = ?");) {
            pstmt.setString(1, userEmail);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                result = rs.getString("id") + ";" + rs.getString("activationCode");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void activateUser(int userId, String activationCode) throws IOException {
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

}