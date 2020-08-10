package dev.ayushm.med.repository;

import dev.ayushm.med.model.Consultant;
import dev.ayushm.med.model.Consultation;
import dev.ayushm.med.model.Patient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ConsultationRepositoryTest {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ConsultantRepository consultantRepository;

    @Before
    public void saver() throws ParseException {
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

        Consultant consultant = new Consultant(
                1,
                "John Doe",
                "john@doe.com",
                "9898766723",
                "Neurology",
                12
        );

        consultantRepository.save(consultant);

        Consultation consultation = new Consultation(
                1,
                null,
                1,
                null,
                1,
                null,
                null,
                "New York, NY",
                new SimpleDateFormat("yyyy-mm-d").parse("2020-08-11")
        );

        consultationRepository.save(consultation);

    }

    @Test
    public void shouldNotBeEmpty() {
        assertTrue(StreamSupport.stream(consultationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList()).size() > 0);
    }

}
