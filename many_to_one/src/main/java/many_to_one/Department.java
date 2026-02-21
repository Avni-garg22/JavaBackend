package many_to_one;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="number_sequence")
    @SequenceGenerator(name="number_sequence",sequenceName="number_sequence",initialValue=100,allocationSize=1) //to define name not generate
    private int id;
    private String name;
    private String mgrname;
    private int totemp;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "department")
    private List<Employee> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMgrname() {
        return mgrname;
    }

    public void setMgrname(String mgrname) {
        this.mgrname = mgrname;
    }

    public int getTotemp() {
        return totemp;
    }

    public void setTotemp(int totemp) {
        this.totemp = totemp;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}