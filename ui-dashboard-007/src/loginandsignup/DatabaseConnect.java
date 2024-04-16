// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DatabaseConnect.java

package loginandsignup;

import java.io.PrintStream;
import java.sql.*;

public class DatabaseConnect
{

    public DatabaseConnect(String dbURL, String user, String password)
    {
        try
        {
            connection = DriverManager.getConnection(dbURL, user, password);
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            System.err.println("Error: No se pudo cargar el controlador JDBC.");
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            System.err.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
    }

    public Connection getConnection()
    {
        return connection;
    }

    public void close()
    {
        try
        {
            if(connection != null)
            {
                connection.close();
                System.out.println("Conexi\363n cerrada.");
            }
        }
        catch(SQLException e)
        {
            System.err.println("Error al cerrar la conexi\363n.");
            e.printStackTrace();
        }
    }

    private Connection connection;
}
