package hospital_case_21_02_2026;
import java.time.LocalDate;

public class Task5Test {

    public static void main(String[] args) {

        DoctorService docService = new DoctorService();

        Doctor d = new Doctor("Dr. Shah");

        Patient p1 = new Patient("Amit", LocalDate.now(), "A+", "8888");
        Patient p2 = new Patient("Neha", LocalDate.now(), "B+", "7777");

        d.addPatient(p1);
        d.addPatient(p2);

        docService.create(d);

        System.out.println("Task5 Done");
    }
}
