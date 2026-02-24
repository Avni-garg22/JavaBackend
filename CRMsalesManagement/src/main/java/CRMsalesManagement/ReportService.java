package CRMsalesManagement;

import java.util.List;

import javax.persistence.EntityManager;

public class ReportService {

    private EntityManager em;

    public ReportService(EntityManager em) {
        this.em = em;
    }

    public List<Lead> getEmployeePerformance(Long employeeId) {
        return em.createQuery(
            "SELECT l FROM Lead l WHERE l.employee.id = :id AND l.status = 'CONVERTED'",
            Lead.class
        ).setParameter("id", employeeId)
         .getResultList();
    }
}