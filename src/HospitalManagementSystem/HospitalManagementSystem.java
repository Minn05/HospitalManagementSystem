package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalManagementSystem {
    private static final String url = "jdbc:mysql://localhost:3306/hospital";
    private static final String username = "root";
    private static final String password = "12345678";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Patient patient = new Patient(connection, scanner);
            Doctor doctor = new Doctor(connection);
            while (true){
                System.out.println("HOSPITAL MANAGEMENT SYSTEM");
                System.out.println("1. Add Patient");
                System.out.println("2. View Patients");
                System.out.println("3. View Doctors");
                System.out.println("4. Book Appointment");
                System.out.println("5. Exit");
                System.out.println("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice){
                    case 1:
                        //Add Patient
                        patient.addPatient();
                    case 2:
                        //View Patients
                        patient.viewPatient();
                    case 3:
                        //View Doctors
                        doctor.viewDoctor();
                    case 4:
                        //Book Appointment

                    case 5:
                        return;
                    default:
                        System.out.println("Enter your valid choice!!!");
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
