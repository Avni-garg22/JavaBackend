package hospital_case_21_02_2026;

import java.time.LocalDateTime;

public class Task3Test {

    public static void main(String[] args) {

        DoctorService docService = new DoctorService();

        Doctor d = new Doctor("Dr. Kumar");

        Appointment a1 = new Appointment(LocalDateTime.now(), "SCHEDULED");
        Appointment a2 = new Appointment(LocalDateTime.now(), "COMPLETED");

        d.getAppointments().add(a1);
        d.getAppointments().add(a2);

        docService.create(d);

        System.out.println("Task3 Done");
    }
}
