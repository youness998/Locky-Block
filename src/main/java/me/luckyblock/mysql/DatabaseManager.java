
package me.luckyblock.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private Connection connection;
    private final String host, database, username, password;
    private final int port;

    public DatabaseManager(String host, String database, String username, String password, int port) {
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(
            "jdbc:mysql://" + host + ":" + port + "/" + database,
            username,
            password
        );
    }

    public Connection getConnection() {
        return connection;
    }
}
