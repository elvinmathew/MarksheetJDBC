import java.sql.*;
public class Course {
    public void dispCourse() throws SQLException {
        String q1 = "SELECT * FROM course";
        PreparedStatement pstmt = Main.con.prepareStatement(q1);
        ResultSet rs1 = pstmt.executeQuery();

        System.out.println("+------------+---------------------+");
        System.out.println("| Course ID  |      Course Name     |");
        System.out.println("+------------+---------------------+");

        while (rs1.next()) {
            int courseId = rs1.getInt("c_id");
            String courseName = rs1.getString("c_name");

            System.out.printf("| %-10d | %-19s |%n", courseId, courseName);
        }

        System.out.println("+------------+---------------------+");

        rs1.close();
    }
}

