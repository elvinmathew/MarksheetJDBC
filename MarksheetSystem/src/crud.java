import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class crud {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:/MarksheetSystem", "root", "7307");


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }
}
