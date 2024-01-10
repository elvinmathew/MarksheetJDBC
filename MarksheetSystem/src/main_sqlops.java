import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class main_sqlops {
    public static void main(String[] args) {
        try{

        Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheetsystem","root","7307");
            //course table {created and executed prior to other tables}
//
//            String q3="create table course(c_id int primary key auto_increment," +
//                    "c_name varchar(100))";

            //students table
//            String q1="create table students(s_id int primary key auto_increment," +
//                    "s_name varchar(200) not null," +
//                    "s_class int not null)";

            //teachers' table
//            String q2="create table teachers(t_id int primary key auto_increment," +
//                    "t_name varchar(200) not null," +
//                    "t_course varchar(100) not null," +//f-key
//                    "t_courseId int," +//f-key
//                    "foreign key (t_course_Id) references course (c_id)," +
//                    "foreign key (t_course) references course(c_name))";

//               String q4="create table marksheet(student_Id int primary key," +
//                       "name varchar (200)," +
//                       "class int," +
//                       "course varchar(100)," +
//                       "course_id int," +
//                       "total_marks int," +
//                       "obtained_marks int," +
//                       "percentage int)";




            Statement stmt=con.createStatement();
//            stmt.executeUpdate(q1);
//            stmt.executeUpdate(q2);
//            stmt.executeUpdate(q3);
//              stmt.executeUpdate(q4);
//              String q1="ALTER TABLE course ADD INDEX ne_index_s_name (c_name)";
              String altq="alter table marksheet " +
                      "add constraint name foreign key (name) references students (s_name)," +
                      "add constraint class foreign key (class) references students (s_class)," +
                      "add constraint course foreign key (course) references course (c_name)," +
                      "add constraint id foreign key (course_id) references course(c_id)";
              stmt.executeUpdate(altq);
            System.out.println("tables created...");
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}