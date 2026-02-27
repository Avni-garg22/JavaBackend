package hospital_case_21_02_2026;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task4Test {

    public static void main(String[] args) {

        AppointmentService service = new AppointmentService();

        Appointment a = new Appointment(LocalDateTime.now(), "COMPLETED");

        Prescription p = new Prescription("Paracetamol", LocalDate.now());

        a.setPrescription(p);

        service.create(a);

        System.out.println("Task4 Done");
    }
}