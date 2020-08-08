package dev.ayushm.med.controller;

import dev.ayushm.med.model.*;
import dev.ayushm.med.model.form.ConsultationForm;
import dev.ayushm.med.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/add")
public class FormController {

    private static final Logger log = LoggerFactory.getLogger(FormController.class);

    private final PatientService patientService;
    private final ConsultantService consultantService;
    private final ConsultationService consultationService;
    private final IllnessService illnessService;
    private final DiagnosisService diagnosisService;
    private final DrugService drugService;
    private final TreatmentService treatmentService;
    private final TestService testService;

    @Autowired
    public FormController(PatientService patientService, ConsultantService consultantService, ConsultationService consultationService, IllnessService illnessService, DiagnosisService diagnosisService, DrugService drugService, TreatmentService treatmentService, TestService testService) {
        this.patientService = patientService;
        this.consultantService = consultantService;
        this.consultationService = consultationService;
        this.illnessService = illnessService;
        this.diagnosisService = diagnosisService;
        this.drugService = drugService;
        this.treatmentService = treatmentService;
        this.testService = testService;
    }


    @GetMapping("/patient")
    public String getPatientForm() {
        return "/forms/patient";
    }

    @PostMapping("/patient")
    public String postPatientForm(@ModelAttribute("patient") Patient patient, BindingResult result, Model model) {
        if (result.hasErrors())
            return "pages/error";

        patientService.addPatient(patient);
        log.info("Added patient from form.");

        model.addAttribute("status", patient != null);

        return "/forms/patient";
    }


    @GetMapping("/consultant")
    public String getConsultantForm() {
        return "/forms/consultant";
    }

    @PostMapping("/consultant")
    public String postConsultantForm(@ModelAttribute("consultant") Consultant consultant, BindingResult result, Model model) {

        if (result.hasErrors())
            return "pages/error";

        consultantService.addConsultant(consultant);
        log.info("Added consultant from form.");

        model.addAttribute("status", consultant != null);

        return "forms/consultant";
    }

    @GetMapping("/consultation")
    public String getConsultationForm() {
        return "/forms/consultation";
    }

    @PostMapping("/consultation")
    public String postConsultationForm(@ModelAttribute("consultationForm") ConsultationForm consultationForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            System.out.println(result.toString());
            return "pages/error";
        }

        log.info("About to add consultation.");

        List<Patient> formPatients = patientService.getPatientsByName(consultationForm.getPatientName());
        List<Consultant> formConsultants = consultantService.getConsultantsByName(consultationForm.getConsultantName());
        List<Illness> formIllnesses = illnessService.getIllnessesByName(consultationForm.getIllnessName());
        List<Drug> formDrugs = drugService.getDrugsByName(consultationForm.getDrugName());

        Patient formPatient = formPatients.get(0);
        Consultant formConsultant = formConsultants.get(0);
        Illness formIllness, addedIllness;
        Drug formDrug, addedDrug;

        try {
            formDrug = formDrugs.get(0);
        } catch (IndexOutOfBoundsException e) {
            log.error("Could not find a drug that matches the name '" + consultationForm.getDrugName() + "'.");
            Drug drug = new Drug(null, consultationForm.getDrugName(), null, null);
            addedDrug = drugService.addDrug(drug);
            formDrug = addedDrug;
        }

        try {
            formIllness = formIllnesses.get(0);
        } catch (IndexOutOfBoundsException e) {
            // Add
            log.error("Could not find an illness that matches the name '" + consultationForm.getIllnessName() + "'.");
            Illness illness = new Illness(
                    null,
                    consultationForm.getIllnessName(),
                    null,
                    null);
            addedIllness = illnessService.addIllness(illness);
            formIllness = addedIllness;
        }

        Test test = new Test(null, consultationForm.getTestName(), consultationForm.getTestValue());
        Test addedTest = testService.addTest(test);
        log.info("Added test " + addedTest);

        Consultation consultation = new Consultation(
                null,
                formPatient,
                formPatient.getPatientId(),
                formConsultant,
                formConsultant.getConsultantId(),
                addedTest,
                addedTest.getTestId(),
                consultationForm.getConsultationLocation(),
                consultationForm.getConsultationDate());

        Consultation addedConsultation = consultationService.addConsultation(consultation);
        log.info("Added consultation from form.");

        Diagnosis diagnosis = new Diagnosis(
                null,
                addedConsultation,
                addedConsultation.getConsultationId(),
                formIllness,
                formIllness.getIllnessId());

        Diagnosis addedDiagnosis = diagnosisService.addDiagnosis(diagnosis);
        log.info("Added diagnosis from form.");

        Treatment treatment = new Treatment(
                null,
                addedDiagnosis,
                addedDiagnosis.getDiagnosisId(),
                formDrug,
                formDrug.getDrugId());

        treatmentService.addTreatment(treatment);
        log.info("Added treatment from form.");


        model.addAttribute("status", consultationForm.getPatientName() != null);

        return "forms/consultation";
    }

    @GetMapping("/illness")
    public String getIllnessForm() {
        log.info("Returning illness form view...");
        return "/forms/illness";
    }

    @PostMapping("/illness")
    public String postIllnessForm(@ModelAttribute("illness") Illness illness, BindingResult result, Model model) {

        if (result.hasErrors()) {
            log.error("Encountered errors. Returning error page."); // TODO: Add more error details
            return "pages/error";
        }

        illnessService.addIllness(illness);
        log.info("Added illness from form.");

        model.addAttribute("status", illness != null);

        return "forms/illness";
    }


    @GetMapping("/diagnosis")
    public String getDiagnosisForm() {
        log.info("Returning diagnosis form view...");
        return "/forms/diagnosis";
    }

    @PostMapping("/diagnosis")
    public String postDiagnosisForm(@ModelAttribute("diagnosis") Diagnosis diagnosis, BindingResult result, Model model) {

        if (result.hasErrors()) {
            log.error("Encountered errors. Returning error page."); // TODO: Add more error details
            return "pages/error";
        }

        diagnosisService.addDiagnosis(diagnosis);
        log.info("Added diagnosis from form.");

        model.addAttribute("status", diagnosis != null);

        return "forms/diagnosis";
    }

    @GetMapping("/drug")
    public String getDrugForm() {
        log.info("Returning drug form view...");
        return "/forms/drug";
    }

    @PostMapping("/drug")
    public String postDrugForm(@ModelAttribute("drug") Drug drug, BindingResult result, Model model) {

        if (result.hasErrors()) {
            log.error("Encountered errors. Returning error page."); // TODO: Add more error details
            return "pages/error";
        }

        drugService.addDrug(drug);
        log.info("Added drug from form.");

        model.addAttribute("status", drug != null);

        return "forms/drug";
    }

    @GetMapping("/treatment")
    public String getTreatmentForm() {
        log.info("Returning treatment form view...");
        return "/forms/treatment";
    }

    @PostMapping("/treatment")
    public String postTreatmentForm(@ModelAttribute("treatment") Treatment treatment, BindingResult result, Model model) {

        if (result.hasErrors()) {
            log.error("Encountered errors. Returning error page."); // TODO: Add more error details
            return "pages/error";
        }

        treatmentService.addTreatment(treatment);
        log.info("Added treatment from form.");

        model.addAttribute("status", treatment != null);

        return "forms/treatment";
    }

    @GetMapping("/test")
    public String getTestForm() {
        log.info("Returning test form view...");
        return "/forms/test";
    }

    @PostMapping("/test")
    public String postTestForm(@ModelAttribute("test") Test test, BindingResult result, Model model) {

        if (result.hasErrors()) {
            log.error("Encountered errors. Returning error page."); // TODO: Add more error details
            return "pages/error";
        }

        testService.addTest(test);
        log.info("Added test from form.");

        model.addAttribute("status", test != null);

        return "forms/test";
    }

}
