package db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Alisson Chiquitto <chiquitto@gmail.com>
 */
public class DB {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                System.out.printf("Open database: %s%n", url);

                conn = DriverManager.getConnection(url, props);
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new DbException(ex.getMessage());
            }
        }

        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new DbException(ex.getMessage());
            }
        }
    }

    private static Properties loadProperties() {
        File file = new File("../banco/banco.properties");
        System.out.printf("Open file: %s%n", file.getAbsoluteFile());
        try (FileInputStream fs = new FileInputStream(file)) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new DbException(ex.getMessage());
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new DbException(ex.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new DbException(ex.getMessage());
            }
        }
    }
}
