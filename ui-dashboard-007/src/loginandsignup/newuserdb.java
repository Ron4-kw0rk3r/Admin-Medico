// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   newuserdb.java
package loginandsignup;

import java.sql.*;

public class newuserdb
{
    private Connection connection;

    public newuserdb(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertMedico(String nombre, String especialidad, String passwordd, String fechaext)
    {
        String query = "INSERT INTO Medicologin (Nombre, Especialidad, passwordd, Fechaext) VALUES (?, ?, ?, ?)";
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, especialidad);
            preparedStatement.setString(3, passwordd);
            preparedStatement.setString(4, fechaext);
            preparedStatement.executeUpdate();
            System.out.println("Datos cargados a la base de datos con éxito.");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    //private Connection connection;
}
