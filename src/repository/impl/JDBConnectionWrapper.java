package repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBConnectionWrapper {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final int TIMEOUT = 5;

    private Connection connection;

    public JDBConnectionWrapper(String schemaName) {
        try {
            connection = DriverManager.getConnection(DB_URL + schemaName + "?useSSL=false", USER, PASS);
            createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTables() throws SQLException {
        Statement statement = connection.createStatement();


        String safe="SET SQL_SAFE_UPDATES=0;";
        statement.execute(safe);
       String sql = "CREATE TABLE IF NOT EXISTS person (" +
                "  id BIGINT(100) NOT NULL AUTO_INCREMENT," +
                "  nume varchar(45) NOT NULL," +
                "  CNP varchar(45) NOT NULL," +
                "  addres varchar(45) NOT NULL," +
                "  PRIMARY KEY (id)," +
                "  UNIQUE KEY id_UNIQUE (id)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;";
        statement.execute(sql);

        sql = "CREATE TABLE IF NOT EXISTS user (" +
                "  id BIGINT(100) NOT NULL AUTO_INCREMENT," +
                "  user_name varchar(255) NOT NULL UNIQUE ," +
                "  password varchar(255) NOT NULL," +
                "  role BIT NOT NULL," +
                "  PRIMARY KEY (id)," +
                "  UNIQUE KEY id_UNIQUE (id)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;";
        statement.execute(sql);

        sql = "CREATE TABLE IF NOT EXISTS account (" +
                "  id BIGINT(100) NOT NULL AUTO_INCREMENT," +
                "  iban varchar(20) NOT NULL UNIQUE," +
                "  id_person BIGINT(100) NOT NULL," +
                "  typeAc varchar(45) NOT NULL," +
                "  money INT ," +
                "  date_of_creation date," +
                "  PRIMARY KEY (id)," +
                "  FOREIGN KEY (id_person) REFERENCES user(id)," +
                "  UNIQUE KEY id_UNIQUE (id)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;";

        statement.execute(sql);

        sql = "CREATE TABLE IF NOT EXISTS trans (" +
                "  id BIGINT(100) NOT NULL AUTO_INCREMENT," +
                "  id_exp BIGINT(100) NOT NULL," +
                "  id_dest BIGINT(100) NOT NULL," +
                "  money INT ," +
                "  PRIMARY KEY (id)," +
                "  FOREIGN KEY (id_exp) REFERENCES account(id)," +
                "  FOREIGN KEY (id_dest) REFERENCES account(id)," +
                "  UNIQUE KEY id_UNIQUE (id)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;";

        statement.execute(sql);

        statement.execute(safe);

    }

    public boolean testConnection() throws SQLException {
        return connection.isValid(TIMEOUT);
    }

    public Connection getConnection() {
        return connection;
    }
}
