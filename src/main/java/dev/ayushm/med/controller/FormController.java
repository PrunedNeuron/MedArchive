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

    @Autowired
    private PatientService patientService;

    @Autowired
    private ConsultantService consultantService;

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private IllnessService illnessService;

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private DrugService drugService;

    @Autowired
    private TreatmentService treatmentService;

    @Autowired
    private TestService testService;



    @GetMapping("/patient")
    public String getPatientForm() {
        return "/forms/patient";
    }

    @PostMapping("/patient")
    public String postPatientForm(@ModelAttribute("patient") Patient patient, BindingResult result, Model model) {
        if (result.hasErrors())
            return "pages/error";

        Patient addedPatient = patientService.addPatient(patient);
        log.info("Added patient: " + addedPatient.toString());

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

        Consultant addedConsultant = consultantService.addConsultant(consultant);
        log.info("Added consultant: " + addedConsultant.toString());

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

        log.info("About to add consultation form: " + consultationForm.toString());

        List<Patient> formPatients = patientService.getPatientsByName(consultationForm.getPatientName());
        List<Consultant> formConsultants = consultantService.getConsultantsByName(consultationForm.getConsultantName());
        List<Illness> formIllnesses = illnessService.getIllnessesByName(consultationForm.getIllnessName());
        List<Drug> formDrugs = drugService.getDrugsByName(consultationForm.getDrugName());

        Patient formPatient = formPatients.get(0);;
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
        log.info("Added consultation " + addedConsultation);

        Diagnosis diagnosis = new Diagnosis(
                null,
                addedConsultation,
                addedConsultation.getConsultationId(),
                formIllness,
                formIllness.getIllnessId());

        Diagnosis addedDiagnosis = diagnosisService.addDiagnosis(diagnosis);
        log.info("Added diagnosis " + addedDiagnosis);

        Treatment treatment = new Treatment(
                null,
                addedDiagnosis,
                addedDiagnosis.getDiagnosisId(),
                formDrug,
                formDrug.getDrugId());

        Treatment addedTreatment = treatmentService.addTreatment(treatment);
        log.info("Added treatment " + addedTreatment);


        model.addAttribute("status", consultationForm != null);

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

        Illness addedIllness = illnessService.addIllness(illness);
        log.info("Added illness from form.");

        model.addAttribute("submittedForm", addedIllness != null);
        model.addAttribute("status", illness != null);
        model.addAttribute("modelName", "illness");
        model.addAttribute("modelId", addedIllness.getIllnessId());

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

        Diagnosis addedDiagnosis = diagnosisService.addDiagnosis(diagnosis);
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

        Drug addedDrug = drugService.addDrug(drug);
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

        Treatment addedTreatment = treatmentService.addTreatment(treatment);
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

        Test addedTest = testService.addTest(test);
        log.info("Added test from form.");

        model.addAttribute("status", test != null);

        return "forms/test";
    }

}
