import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Connection con;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:/MarksheetSystem", "root", "7307");

        System.out.println("Welcome, .............................This is a Marksheet generating system...................................");
        System.out.println("""
                Type --> 1 <-- to view our students\s
                Type --> 2 <-- to view our faculty\s
                Type --> 3 <-- to update the student record\s
                Type --> 4 <-- to view students' marksheet\s
                Type --> 5 <-- to update marksheet\s
                Type --> 6 <-- to view courses offered\s
                Type --> 7 <-- to insert into to the student table\s
                Type --> 8 <-- to an entry from the student table\s
                Type --> 9 <-- to insert an entry into to the marksheet table\s
                Type --> 10 <-- to delete an entry from the marksheet table\s
                Type --> 11 <-- to view a student's marksheet\s
                """);

        Scanner sc = new Scanner(System.in);
        String input;
        Students st =new Students();
        Course cs = new Course();
        Marksheet mks= new Marksheet();

        do {
            input = sc.nextLine();
            switch (input) {
                case "2" -> Teacher.DispTeach();
                case "3" -> st.updateData();
                case "4" ->mks.displayMsheet();
                case "7" -> st.insertData();
                case "5" -> mks.updateDatamks();
                case "6" -> cs.dispCourse();
                case "1" -> st.displayTable();
                case "8" -> st.deleteData();
                case "9" -> mks.insertDatamks();
                case "10" -> mks.deleteDatamks();
                case "11" -> mks.getIndividualMarksheet();
                default -> System.out.println("Invalid input. Please enter a valid option.");
            }
        } while (!input.equals("exit"));
        con.close();
    }
}