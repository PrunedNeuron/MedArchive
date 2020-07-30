package dev.ayushm.med.database;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Populator {

    static final String BASE_URL = "http://localhost:8080/api";
    static RestTemplate restTemplate = new RestTemplate();
    static HttpHeaders headers = new HttpHeaders();

    public static void populate() {

        headers.setContentType(MediaType.APPLICATION_JSON);
        populatePatients();
        populateConsultants();
        populateConsultations();
        populateIllnesses();
        populateDiagnoses();
        populateDrugs();
        populateTreatments();

    }

    public static void populatePatients() {
        String url = BASE_URL + "/patients";
        String requestJson = "{\n" +
                "  \"patientName\": \"John Doe\",\n" +
                "  \"patientEmail\": \"john.doe@gmail.com\",\n" +
                "  \"patientPhone\": \"9164425654\",\n" +
                "  \"patientAge\": 24,\n" +
                "  \"patientGender\": \"male\",\n" +
                "  \"patientAllergicTo\": \"ibuprofen\"\n" +
                "}";

        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);
    }

    public static void populateConsultants() {
        String url = BASE_URL + "/consultants";
        String requestJson = "{\n" +
                "  \"consultantName\": \"Gregory House\",\n" +
                "  \"consultantEmail\": \"greg.house@outlook.com\",\n" +
                "  \"consultantPhone\": \"9156628852\"\n" +
                "}";


        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);
        System.out.println(answer);
    }

    public static void populateConsultations() {
        String url = BASE_URL + "/consultations";
        String requestJson = "{\n" +
                "  \"patientId\": 1,\n" +
                "  \"consultantId\": 1,\n" +
                "  \"consultationLocation\": \"New York\",\n" +
                "  \"consultationDate\": \"2020-07-12\"\n" +
                "}";

        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);
        System.out.println(answer);
    }

    public static void populateIllnesses() {
        String url = BASE_URL + "/illnesses";
        String requestJson = "{\n" +
                "  \"illnessName\": \"Amyloidosis\"\n" +
                "}";

        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);
        System.out.println(answer);
    }

    public static void populateDiagnoses() {
        String url = BASE_URL + "/diagnoses";
        String requestJson = "{\n" +
                "  \"consultationId\": 1,\n" +
                "  \"illnessId\": 1\n" +
                "}";

        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);
        System.out.println(answer);
    }

    public static void populateDrugs() {
        String url = BASE_URL + "/drugs";
        String requestJson = "{\n" +
                "  \"drugName\": \"Prednisone\"\n" +
                "}";

        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);
        System.out.println(answer);
    }

    public static void populateTreatments() {
        String url = BASE_URL + "/treatments";
        String requestJson = "{\n" +
                "  \"diagnosisId\": 1,\n" +
                "  \"drugId\": 1\n" +
                "}";

        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);
        System.out.println(answer);
    }

}
