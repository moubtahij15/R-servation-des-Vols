package mvc.helpers;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {


    public static synchronized Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }

    private static Connection instance;

    private Connection() {
    }

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HOST = "localhost";
    private static final String DATA_BASE = "test3";
    private static final int PORT = 5432;
    private static final String URL = "jdbc:mysql://" + HOST + ':' + PORT + '/' + DATA_BASE;
    private static final String USER = "root";
    private static final String PASS = "";

    public Connection getConnection()
            throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);

        Connection conn = (Connection) DriverManager.getConnection(URL, USER, PASS);
        System.out.println("connexion Bien: " + URL);
        return conn;
    }
}
