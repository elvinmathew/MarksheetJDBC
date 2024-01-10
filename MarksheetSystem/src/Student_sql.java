import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Student_sql {
    public static void main(String[] args) {

    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MarksheetSystem", "root", "7307");

            System.out.println("Enter student data: ");
            String q = "insert into students(s_id,s_name,s_class) values(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);

            Scanner sc = new Scanner(System.in);
        System.out.println("enter Id: ");
            int s_id=sc.nextInt();
            pstmt.setInt(1,s_id);

            sc.nextLine();
        System.out.println("enter name: ");
            String s_name=sc.nextLine();
        sc.nextLine();
            pstmt.setString(2,s_name);

        System.out.println("enter Std/Grade/Class: ");
            int s_class=sc.nextInt();
            pstmt.setInt(3,s_class);


        System.out.println("data entered successfully...");
        pstmt.executeUpdate();
        sc.close();
        pstmt.close();
        con.close();

        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
}
}