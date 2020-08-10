package dev.ayushm.med.repository;

import dev.ayushm.med.model.Patient;
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
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Before
    public void saver() {
        Patient patient = new Patient(
                1,
                "John Doe",
                "john@nsa.gov",
                "9519529539",
                25,
                "male",
                "aspirin"
        );

        patientRepository.save(patient);
    }

    @Test
    public void shouldNotBeEmpty() {
        assertTrue(patientRepository.findByPatientNameContaining("John").size() > 0);
    }

}
