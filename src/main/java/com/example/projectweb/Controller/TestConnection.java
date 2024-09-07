package com.example.projectweb.Controller;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("123456789");
        ds.setServerName("DESKTOP-5EKOMHK\\SQLEXPRESS01");
        ds.setPortNumber(1433);
        ds.setDatabaseName("Project");

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
