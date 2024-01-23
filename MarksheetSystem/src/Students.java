import java.sql.*;
import java.util.Scanner;

public class Students {
    Scanner sc =new Scanner(System.in);

    public void displayTable() throws SQLException {
        String q1 = "SELECT * FROM students";
        PreparedStatement stmt1 = Main.con.prepareStatement(q1);
        ResultSet rs1 = stmt1.executeQuery();

        System.out.println("+------------+---------------------+----------+");
        System.out.println("| Student ID |      Student Name    | Class   |");
        System.out.println("+------------+---------------------+----------+");

        while (rs1.next()) {
            int Id = rs1.getInt("s_id");
            String studentName = rs1.getString("s_name");
            int studentClass = rs1.getInt("s_class");

            System.out.printf("| %-10d | %-19s | %-8d |%n", Id, studentName, studentClass);
        }

        System.out.println("+------------+---------------------+----------+");

        rs1.close();
        stmt1.close();
    }


    public void insertData() throws SQLException {
        String q2 = "INSERT INTO students (s_id, s_name) VALUES (?,?)";

        System.out.println("enter student's unique Id");
        int s_id = sc.nextInt();

        sc.nextLine();
        System.out.println("enter student's name");
        String name = sc.nextLine();


        PreparedStatement stmt2 = Main.con.prepareStatement(q2);
        stmt2.setInt(1, s_id);
        stmt2.setString(2, name);


        stmt2.executeUpdate();
        System.out.println("Data entered successfully...");


        stmt2.close();
    }

    public void updateData() throws SQLException {

        System.out.println("enter student's name");
        String name = sc.nextLine();

        sc.nextLine();
        System.out.println("enter student's id");
        int s_id = sc.nextInt();

        String q3 = "UPDATE students SET s_name = ? WHERE s_id = ?";
        PreparedStatement stmt3 = Main.con.prepareStatement(q3);
        stmt3.setString(1, name);
        stmt3.setInt(2, s_id);
        int r =stmt3.executeUpdate();
        if(r>=1) {
            System.out.println("successfully updated"+r);
        }else{
            System.out.println("updation failed");

        }
        stmt3.close();
    }

    public void deleteData() throws SQLException {
        System.out.println("enter student's id");
        int s_id=sc.nextInt();

        String q4 = "DELETE FROM students WHERE s_id = ?";
        PreparedStatement stmt4 = Main.con.prepareStatement(q4);
        stmt4.setInt(1, s_id);


        int r=stmt4.executeUpdate();
        if(r>=1) {
            System.out.println("successfully deleted");
        }else{
            System.out.println("deletion failed");

            stmt4.close();

        }
    }




}
