package dev.ayushm.med.utility.populate;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ayushm.med.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.fasterxml.jackson.core.JsonToken.START_OBJECT;

@Component
@ConditionalOnProperty(
        value = "prepopulate.sampleData",
        havingValue = "true",
        matchIfMissing = true)
public class PopulatorUtility implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PopulatorUtility.class);

    private static final String BASE_URL = "http://localhost:8080/api";
    private static final String BASE_PATH = "src/main/resources/data/json";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();

    public static void populatePatients() throws IOException {
        String url = BASE_URL + "/patients";
        String json = new String(Files.readAllBytes(Paths.get(BASE_PATH + "/patient.json")));
        JsonParser parser = new JsonFactory().createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == START_OBJECT) {
            Patient patient = mapper.readValue(parser, Patient.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(patient), headers);
            restTemplate.postForObject(url, entity, String.class);
        }
    }

    public static void populateConsultants() throws IOException {
        String url = BASE_URL + "/consultants";
        String json = new String(Files.readAllBytes(Paths.get(BASE_PATH + "/consultant.json")));
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == START_OBJECT) {
            Consultant consultant = mapper.readValue(parser, Consultant.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(consultant), headers);
            restTemplate.postForObject(url, entity, String.class);
        }
    }

    public static void populateConsultations() throws IOException {
        String url = BASE_URL + "/consultations";
        String json = new String(Files.readAllBytes(Paths.get(BASE_PATH + "/consultation.json")));
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == START_OBJECT) {
            Consultation consultation = mapper.readValue(parser, Consultation.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(consultation), headers);
            restTemplate.postForObject(url, entity, String.class);
        }
    }

    public static void populateIllnesses() throws IOException {
        String url = BASE_URL + "/illnesses";
        String json = new String(Files.readAllBytes(Paths.get(BASE_PATH + "/illness.json")));
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == START_OBJECT) {
            Illness illness = mapper.readValue(parser, Illness.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(illness), headers);
            restTemplate.postForObject(url, entity, String.class);
        }
    }

    public static void populateDiagnoses() throws IOException {
        String url = BASE_URL + "/diagnoses";
        String json = new String(Files.readAllBytes(Paths.get(BASE_PATH + "/diagnosis.json")));
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == START_OBJECT) {
            Diagnosis diagnosis = mapper.readValue(parser, Diagnosis.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(diagnosis), headers);
            restTemplate.postForObject(url, entity, String.class);
        }
    }

    public static void populateDrugs() throws IOException {
        String url = BASE_URL + "/drugs";
        String json = new String(Files.readAllBytes(Paths.get(BASE_PATH + "/drug.json")));
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == START_OBJECT) {
            Drug drug = mapper.readValue(parser, Drug.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(drug), headers);
            restTemplate.postForObject(url, entity, String.class);
        }
    }

    public static void populateTreatments() throws IOException {
        String url = BASE_URL + "/treatments";
        String json = new String(Files.readAllBytes(Paths.get(BASE_PATH + "/treatment.json")));
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == START_OBJECT) {
            Treatment treatment = mapper.readValue(parser, Treatment.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(treatment), headers);
            restTemplate.postForObject(url, entity, String.class);
        }
    }

    public static void populateTests() throws IOException {
        String url = BASE_URL + "/tests";
        String json = new String(Files.readAllBytes(Paths.get(BASE_PATH + "/test.json")));
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == START_OBJECT) {
            Test test = mapper.readValue(parser, Test.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(test), headers);
            restTemplate.postForObject(url, entity, String.class);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Setting headers, application/json.");
        headers.setContentType(MediaType.APPLICATION_JSON);

        long start = System.currentTimeMillis();
        log.info("Populating database...");
        populate();
        long delta = System.currentTimeMillis() - start;
        double elapsedSeconds = delta / 1000.0;

        log.info("The database has been populated with sample data.");
        log.info("Insertion took " + elapsedSeconds + " seconds.");
    }

    public void populate() throws IOException {
        populateTests();
        populateDrugs();
        populatePatients();
        populateConsultants();
        populateConsultations();
        populateIllnesses();
        populateDiagnoses();
        populateTreatments();
    }

}
