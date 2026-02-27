package hospital_case_21_02_2026;


import java.time.LocalDate;

public class Task1Test {

    public static void main(String[] args) {

        PatientService service = new PatientService();

        Patient p = new Patient("Avni",
                LocalDate.now(),
                "B+",
                "99999");

        MedicalRecord r = new MedicalRecord(
                LocalDate.now(),
                "Flu",
                "Rest 3 days");

        p.setMedicalRecord(r);

        service.create(p);

        System.out.println("Task1 Done");
    }
}
