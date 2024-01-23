import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Marksheet {
    Scanner sc = new Scanner(System.in);

    public void displayMsheet() throws SQLException {
        String q1 = "SELECT * FROM marksheet";
        PreparedStatement stmt1 = Main.con.prepareStatement(q1);
        ResultSet rs1 = stmt1.executeQuery();

        System.out.println("+------------+---------+----------+-------------+-------+------+--------+-------+");
        System.out.println("| Student ID | Physics | Chemistry| Mathematics | Biology | Total| Obtained | Grade |");
        System.out.println("+------------+---------+----------+-------------+-------+------+--------+-------+");

        while (rs1.next()) {
            int studentId = rs1.getInt("Student_id");
            int physics = rs1.getInt("Physics");
            int chemistry = rs1.getInt("Chemistry");
            int mathematics = rs1.getInt("Mathematics");
            int biology = rs1.getInt("Biology");
            int totalm = rs1.getInt("total_marks");
            int obm = rs1.getInt("obtained_marks");
            int perc = rs1.getInt("percentage");
            String grade = rs1.getString("Grade");

            System.out.printf("| %-10d | %-7d | %-8d | %-11d | %-5d | %-4d | %-7d | %-5s |%n",
                    studentId, physics, chemistry, mathematics, biology, totalm, obm, perc,grade);
        }

        System.out.println("+------------+---------+----------+-------------+-------+------+--------+-------+");

        rs1.close();
        stmt1.close();
    }


    public void insertDatamks() throws SQLException {
        String q2 = "INSERT INTO marksheet (student_Id, Physics, Chemistry, Mathematics, Biology) VALUES (?, ?, ?, ?, ?)";

        System.out.println("Enter student ID");
        int studentId = sc.nextInt();
        System.out.println("Marks of Physics out of 100");
        int physics = sc.nextInt();
        System.out.println("Marks of Chemistry out of 100");
        int chemistry = sc.nextInt();
        System.out.println("Marks of Mathematics out of 100");
        int mathematics = sc.nextInt();
        System.out.println("Marks of Biology out of 100");
        int biology = sc.nextInt();

        PreparedStatement stmt2 = Main.con.prepareStatement(q2);
        stmt2.setInt(1, studentId);
        stmt2.setInt(2, physics);
        stmt2.setInt(3, chemistry);
        stmt2.setInt(4, mathematics);
        stmt2.setInt(5, biology);

        stmt2.executeUpdate();
        System.out.println("Data entered successfully...");
        stmt2.close();
    }


    public void updateDatamks() throws SQLException {
        String updateQuery = "UPDATE marksheet SET Physics = ?, Chemistry = ?, Mathematics = ?, Biology = ? WHERE Student_Id = ?";
        System.out.println("enter id");
        int s_id = sc.nextInt();

        System.out.println("Marks of Physics out of 100");
        int Physics = sc.nextInt();
        System.out.println("Marks of Chemistry out of 100");
        int Chemistry = sc.nextInt();
        System.out.println("Marks of Mathematics out of 100");
        int Mathematics = sc.nextInt();
        System.out.println("Marks of Biology out of 100");
        int Biology = sc.nextInt();

        PreparedStatement stmt = Main.con.prepareStatement(updateQuery);
        stmt.setInt(1, Physics);
        stmt.setInt(2, Chemistry);
        stmt.setInt(3, Mathematics);
        stmt.setInt(4, Biology);
        stmt.setInt(5, s_id);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Update successful.");
        } else {
            System.out.println("No records updated. Student ID might not exist.");
        }

        stmt.close();
    }

    public void deleteDatamks() throws SQLException {
        String q4 = "DELETE FROM marksheet WHERE student_Id = ?";

        System.out.println("student id");
        int id = sc.nextInt();

        PreparedStatement stmt4 = Main.con.prepareStatement(q4);
        stmt4.setInt(1, id);

        int rowsDeleted = stmt4.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("No record found for the given student ID.");
        }

        stmt4.close();
    }
        public void getIndividualMarksheet() throws SQLException {
            String query = "SELECT * FROM marksheet WHERE student_Id = ?";

            System.out.println("enter student's ID:");

            PreparedStatement statement = Main.con.prepareStatement(query);
            int studentId = sc.nextInt();
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                studentId = resultSet.getInt("student_Id");
                int physics = resultSet.getInt("Physics");
                int chemistry = resultSet.getInt("Chemistry");
                int mathematics = resultSet.getInt("Mathematics");
                int biology = resultSet.getInt("Biology");
                int totalMarks = resultSet.getInt("total_marks");
                int obtainedMarks = resultSet.getInt("obtained_marks");
                int percentage = resultSet.getInt("percentage");
                String grade = resultSet.getString("Grade");


                System.out.println("Student ID: " + studentId);
                System.out.println("Physics: " + physics);
                System.out.println("Chemistry: " + chemistry);
                System.out.println("Mathematics: " + mathematics);
                System.out.println("Biology: " + biology);
                System.out.println("Total Marks: " + totalMarks);
                System.out.println("Obtained Marks: " + obtainedMarks);
                System.out.println("Percentage: " + percentage);
                System.out.println("Grade: " + grade);
                System.out.println();
            }

            resultSet.close();
            statement.close();
        }
    }


