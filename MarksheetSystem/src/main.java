import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
    static Connection con;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:/MarksheetSystem", "root", "7307");

        System.out.println("Welcome, .............................This is a Marksheet generating system...................................");
        System.out.println("""
                Type --> 1 <-- to view our students\s
                Type --> 2 <-- to view our faculty\s
                Type --> 3 <-- to update to the student table\s
                Type --> 4 <-- to view student's marksheet\s
                Type --> 5 <-- to update marksheet\s
                Type --> 6 <-- to view courses offered\s
                Type --> 7 <-- to insert into to the student table\s
                Type --> 8 <-- to an entry from the student table\s
                Type --> 9 <-- to insert an entry into to the marksheet table\s
                Type --> 10 <-- to delete an entry from the marksheet table\s
                """);

        Scanner sc = new Scanner(System.in);
        String input;
        students st =new students();
        course cs = new course();
        marksheet mks= new marksheet();

        do {
            input = sc.nextLine();
            switch (input) {
                case "2" -> teacher.DispTeach();//works
                case "3" -> st.updateData();//works
                case "4" ->mks.displayMsheet();//works
                case "7" -> st.insertData();//works
                case "5" -> mks.updateDatamks();//works
                case "6" -> cs.dispCourse();//works
                case "1" -> st.displayTable();//works
                case "8" -> st.deleteData();//works
                case "9" -> mks.insertDatamks();//works
                case "10" -> mks.deleteDatamks();//works
                default -> System.out.println("Invalid input. Please enter a valid option.");
            }
        } while (!input.equals("exit"));
        con.close();
    }
}