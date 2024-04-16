// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   userverifydb.java
package loginandsignup;
import java.sql.*;

public class userverifydb
{
    private Connection connection;
    
    
    public userverifydb(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int verificarCredenciales(String nombre, String contrasena)
    {
        ResultSet resultSet = null;
        int count = 0;
        String query = "SELECT COUNT(*) FROM medicologin WHERE Nombre = ? AND Passwordd = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, contrasena);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
                System.out.println("Resultado: " + count);
                return count <= 0 ? 0 : 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
}
