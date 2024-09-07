package com.example.projectweb.Controller;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("12345");
        ds.setServerName("DESKTOP-3G0AG05\\SQLEXPRESS");
        ds.setPortNumber(1433);
        ds.setDatabaseName("webbangiay");

        ds.setTrustServerCertificate(true);

        try (Connection conn = ds.getConnection()) {
            System.out.println("Connection success!");
            System.out.println(conn.getMetaData());
        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
