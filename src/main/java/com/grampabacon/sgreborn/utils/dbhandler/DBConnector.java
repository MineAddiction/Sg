package com.grampabacon.sgreborn.utils.dbhandler;

import com.grampabacon.sgreborn.utils.husky.mysql.MySQL;

import java.sql.*;

/**
 * Created by Adam on 13/09/2015.
 */
public class DBConnector {
    public static Connection c = null;
    private final static String host = "localhost";
    private final static String port = "3306";
    private final static String database = "SGReborn";
    private final static String user  = "sgr";
    private final static String password = "RedDog39";

    private static DBConnector instance;

    public DBConnector() {
        instance = this;
        connect();
    }

    public static DBConnector getInstance() {
        return instance;
    }

    public void connect() {
        makeConnection();
        if (c != null) {
            System.out.println("[SGR] Connected to DB");
        }
    }

    public void disconnect() {
        if (c == null) {
            System.out.println("[SGR] Disconnected from DB");
        }
    }

    private void makeConnection() {
        MySQL mySQL = new MySQL(host, port, database, user, password);
        c = mySQL.openConnection();
    }

    public Connection getConnection(){
        try {
            if(c == null || c.isClosed()) {
                connect();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public boolean tableExists(String name) {
        try {
            DatabaseMetaData dbm = c.getMetaData();
            ResultSet tables = dbm.getTables(null, null, name, null);
            if (tables.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean executeQuery(String query) {
        PreparedStatement statement = null;
        boolean b;
        try {
            statement = getConnection().prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.executeUpdate();
            statement.close();
            b = true;
        } catch (SQLException e) {
            e.printStackTrace();
            b = false;
        }
        return b;
    }

    public ResultSet executeQueryAndGetData(String query) {
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
