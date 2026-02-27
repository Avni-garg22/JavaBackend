package hospital_case_21_02_2026;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HibernateConfigurationTest {

    @Test
    public void configurationShouldBuildSessionFactory() {
        SessionFactory factory = HibernateUtil.getFactory();
        assertNotNull(factory, "SessionFactory should not be null");
        assertFalse(factory.isClosed(), "SessionFactory should be open");
        factory.close();
    }
}