package dev.ayushm.med.repository;

import dev.ayushm.med.model.Consultant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ConsultantRepositoryTest {

    @Autowired
    private ConsultantRepository consultantRepository;

    @Before
    public void saver() {
        Consultant consultant = new Consultant(
                1,
                "John Doe",
                "john@doe.com",
                "9898766723",
                "Neurology",
                12
        );

        consultantRepository.save(consultant);
    }

    @Test
    public void shouldNotBeEmpty() {
        assertTrue(consultantRepository.findByConsultantNameContaining("John").size() > 0);
    }

}
