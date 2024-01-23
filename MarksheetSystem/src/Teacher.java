import java.sql.*;

public class Teacher {
    public static void DispTeach() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:/MarksheetSystem","root","7307");


            String q="select * from teachers";
            PreparedStatement stmt= con.prepareStatement(q);
            ResultSet rs = stmt.executeQuery(q);
            System.out.printf("%-11s| %-22s| %s%n","teacherId","teacherName","teacherCourse");
            while(rs.next()){
                int teacherId=rs.getInt("t_id");
                String teacherName=rs.getString("t_name");
                String teacherCourse=rs.getString("t_course");

                System.out.printf("%-11s| %-22s| %s%n", teacherId, teacherName, teacherCourse);

            }rs.close();
             stmt.close();
        }

    }

