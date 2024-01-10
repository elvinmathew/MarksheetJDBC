import java.sql.*;

public class course {
    public void dispCourse() throws SQLException {
        String q1 ="select * from course";
        PreparedStatement pstmt= main.con.prepareStatement(q1);
        ResultSet rs1= pstmt.executeQuery();
        while (rs1.next()) {
            int courseId = rs1.getInt("c_id");
            String courseName = rs1.getString("c_name");

            System.out.printf("| %-10s | %-20s |%n", courseId, courseName);
        }
        rs1.close();
    }
}
