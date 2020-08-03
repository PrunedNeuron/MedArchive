package dev.ayushm.med.utility.populate;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ayushm.med.model.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PopulatorUtility {

    static final String BASE_URL = "http://localhost:8080/api";
    static RestTemplate restTemplate = new RestTemplate();
    static HttpHeaders headers = new HttpHeaders();

    public static void populate() throws IOException {

        headers.setContentType(MediaType.APPLICATION_JSON);
        populatePatients();
        populateConsultants();
        populateConsultations();
        populateIllnesses();
        populateDiagnoses();
        populateDrugs();
        populateTreatments();
        populateTests();

    }

    public static void populatePatients() throws IOException {
        String url = BASE_URL + "/patients";

        String json = new String(Files.readAllBytes(Paths.get("src/main/java/dev/ayushm/med/utility/populate/json/patient.json")));
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == JsonToken.START_OBJECT) {
            Patient patient = mapper.readValue(parser, Patient.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(patient), headers);
            String answer = restTemplate.postForObject(url, entity, String.class);
        }

    }

    public static void populateConsultants() throws IOException {
        String url = BASE_URL + "/consultants";
        String json = new String(Files.readAllBytes(Paths.get("src/main/java/dev/ayushm/med/utility/populate/json/consultant.json")));
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == JsonToken.START_OBJECT) {
            Consultant consultant = mapper.readValue(parser, Consultant.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(consultant), headers);
            String answer = restTemplate.postForObject(url, entity, String.class);
        }
    }

    public static void populateConsultations() throws IOException {
        String url = BASE_URL + "/consultations";
        String json = new String(Files.readAllBytes(Paths.get("src/main/java/dev/ayushm/med/utility/populate/json/consultation.json")));
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == JsonToken.START_OBJECT) {
            Consultation consultation = mapper.readValue(parser, Consultation.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(consultation), headers);
            String answer = restTemplate.postForObject(url, entity, String.class);
        }
    }

    public static void populateIllnesses() throws IOException {
        String url = BASE_URL + "/illnesses";
        String json = new String(Files.readAllBytes(Paths.get("src/main/java/dev/ayushm/med/utility/populate/json/illness.json")));
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == JsonToken.START_OBJECT) {
            Illness illness = mapper.readValue(parser, Illness.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(illness), headers);
            String answer = restTemplate.postForObject(url, entity, String.class);
        }
    }

    public static void populateDiagnoses() throws IOException {
        String url = BASE_URL + "/diagnoses";
        String json = new String(Files.readAllBytes(Paths.get("src/main/java/dev/ayushm/med/utility/populate/json/diagnosis.json")));
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == JsonToken.START_OBJECT) {
            Diagnosis diagnosis = mapper.readValue(parser, Diagnosis.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(diagnosis), headers);
            String answer = restTemplate.postForObject(url, entity, String.class);
        }
    }

    public static void populateDrugs() throws IOException {
        String url = BASE_URL + "/drugs";
        String json = new String(Files.readAllBytes(Paths.get("src/main/java/dev/ayushm/med/utility/populate/json/drug.json")));
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == JsonToken.START_OBJECT) {
            Drug drug = mapper.readValue(parser, Drug.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(drug), headers);
            String answer = restTemplate.postForObject(url, entity, String.class);
        }
    }

    public static void populateTreatments() throws IOException {
        String url = BASE_URL + "/treatments";
        String json = new String(Files.readAllBytes(Paths.get("src/main/java/dev/ayushm/med/utility/populate/json/treatment.json")));
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == JsonToken.START_OBJECT) {
            Treatment treatment = mapper.readValue(parser, Treatment.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(treatment), headers);
            String answer = restTemplate.postForObject(url, entity, String.class);
        }
    }

    public static void populateTests() throws IOException {
        String url = BASE_URL + "/tests";

        String json = new String(Files.readAllBytes(Paths.get("src/main/java/dev/ayushm/med/utility/populate/json/test.json")));
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        parser.nextToken();
        ObjectMapper mapper = new ObjectMapper();

        while (parser.nextToken() == JsonToken.START_OBJECT) {
            Test test = mapper.readValue(parser, Test.class);
            HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(test), headers);
            String answer = restTemplate.postForObject(url, entity, String.class);
        }

    }

}
