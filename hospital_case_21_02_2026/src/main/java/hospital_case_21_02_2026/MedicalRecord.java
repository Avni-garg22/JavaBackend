package hospital_case_21_02_2026;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MedicalRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate recordDate;
	private String diagnosis;
	private String notes;

	public MedicalRecord() {
	}

	public MedicalRecord(LocalDate recordDate, String diagnosis, String notes) {
		this.recordDate = recordDate;
		this.diagnosis = diagnosis;
		this.notes = notes;
	}
}
