package hospital_case_21_02_2026;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class HospitalMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DepartmentService deptSvc = new DepartmentService();
        DoctorService docSvc = new DoctorService();
        PatientService patSvc = new PatientService();
        AppointmentService appSvc = new AppointmentService();

        System.out.println("=== Hospital CRUD CLI ===");
        while (true) {
            System.out.println("\nSelect option:");
            System.out.println("0) Seed sample data");
            System.out.println("1) Create department");
            System.out.println("2) Create doctor");
            System.out.println("3) Create patient");
            System.out.println("4) Schedule appointment");
            System.out.println("5) List all (departments, doctors, patients, appointments)");
            System.out.println("6) Update patient phone");
            System.out.println("7) Delete patient");
            System.out.println("8) Exit");
            System.out.print("choice: ");
            String input = scanner.nextLine();
            if (input.isEmpty()) continue;
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
                continue;
            }

            switch (choice) {
                case 0:
                    DataSeeder.seed();
                    break;
                case 1:
                    System.out.print("Department name: ");
                    String dname = scanner.nextLine();
                    Department dep = new Department(dname);
                    deptSvc.create(dep);
                    System.out.println("Created department id=" + dep.getId());
                    break;

                case 2:
                    System.out.print("Doctor name: ");
                    String docName = scanner.nextLine();
                    System.out.print("Department id: ");
                    Long deptId = Long.parseLong(scanner.nextLine());
                    Department d = deptSvc.find(deptId);
                    if (d == null) {
                        System.out.println("Department not found");
                        break;
                    }
                    Doctor doc = new Doctor(docName);
                    d.addDoctor(doc);
                    docSvc.create(doc);
                    System.out.println("Created doctor id=" + doc.getId());
                    break;

                case 3:
                    System.out.print("Patient name: ");
                    String pName = scanner.nextLine();
                    System.out.print("DOB (yyyy-MM-dd): ");
                    LocalDate dob = LocalDate.parse(scanner.nextLine());
                    System.out.print("Blood group: ");
                    String bg = scanner.nextLine();
                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();
                    Patient pat = new Patient(pName, dob, bg, phone);
                    patSvc.create(pat);
                    System.out.println("Created patient id=" + pat.getId());
                    break;

                case 4:
                    System.out.print("Doctor id: ");
                    Long did = Long.parseLong(scanner.nextLine());
                    System.out.print("Patient id: ");
                    Long pid = Long.parseLong(scanner.nextLine());
                    Doctor dd = docSvc.find(did);
                    Patient pp = patSvc.find(pid);
                    if (dd == null || pp == null) {
                        System.out.println("Doctor or patient not found");
                        break;
                    }
                    Appointment appt = new Appointment(LocalDateTime.now(), "SCHEDULED");
                    appt.setDoctor(dd);
                    appt.setPatient(pp);
                    // don't touch the doctor's or patient's lazy collections while they are detached
                    appSvc.create(appt);
                    System.out.println("Created appointment id=" + appt.getId());
                    break;

                case 5:
                    System.out.println("Departments:");
                    deptSvc.getAll().forEach(dep2 ->
                            System.out.println(dep2.getId() + ": " + dep2.getName()));
                    System.out.println("Doctors:");
                    docSvc.getAll().forEach(doc2 ->
                            System.out.println(doc2.getId() + ": " + doc2.getName()));
                    System.out.println("Patients:");
                    patSvc.getAll().forEach(p2 ->
                            System.out.println(p2.getId() + ": " + p2.getName()));
                    System.out.println("Appointments:");
                    appSvc.getAll().forEach(a2 ->
                            System.out.println(a2.getId() + ": dr=" +
                                    (a2.getDoctor() != null ? a2.getDoctor().getId() : "?") +
                                    " pat=" + (a2.getPatient() != null ? a2.getPatient().getId() : "?") +
                                    " status=" + a2.getStatus()));
                    break;

                case 6:
                    System.out.print("Patient id: ");
                    Long updPid = Long.parseLong(scanner.nextLine());
                    Patient upd = patSvc.find(updPid);
                    if (upd == null) {
                        System.out.println("Patient not found");
                        break;
                    }
                    System.out.print("New phone: ");
                    String newPhone = scanner.nextLine();
                    upd.setPhone(newPhone);
                    patSvc.update(upd);
                    System.out.println("Updated");
                    break;

                case 7:
                    System.out.print("Patient id: ");
                    Long delPid = Long.parseLong(scanner.nextLine());
                    patSvc.delete(delPid);
                    System.out.println("Deleted");
                    break;

                case 8:
                    System.out.println("Exiting");
                    scanner.close();
                    HibernateUtil.getFactory().close();
                    return;

                default:
                    System.out.println("Unknown option");
            }
        }
    }
}
