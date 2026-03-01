package student_entity;

import javax.persistence.*;

@Entity
@Table(name = "students", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private int marks;

    public Student() {
    }

    public Student(String name, String email, int marks) {
        this.name = name;
        this.email = email;
        setMarks(marks);
    }

    // Validation for Bonus
    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getMarks() { return marks; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}
