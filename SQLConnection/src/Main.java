import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Database {
    static Database INSTANCE;

    synchronized static Database getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Database();
        }
        return INSTANCE;
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "myuser", "mypassword");
    }
}

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();

        connection.createStatement().executeQuery("SELECT * FROM table");
    }
}