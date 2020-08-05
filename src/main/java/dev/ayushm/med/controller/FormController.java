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

    private static final Logger logger = LoggerFactory.getLogger(FormController.class);

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

    @GetMapping("/added")
    public String getAddedPage() {
        return "/forms/added";
    }

    @GetMapping("/patient")
    public String getPatientForm() {
        return "/forms/patient";
    }

    @PostMapping("/patient")
    public String postPatientForm(@ModelAttribute("patient") Patient patient, BindingResult result, Model model) {
        if (result.hasErrors())
            return "pages/error";

        Patient addedPatient = patientService.addPatient(patient);
        logger.info("Added patient: " + addedPatient.toString());

        model.addAttribute("submittedForm", addedPatient != null);
        model.addAttribute("status", patient != null);
        model.addAttribute("modelName", "patient");
        model.addAttribute("modelId", addedPatient.getPatientId());

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
        logger.info("Added consultant: " + addedConsultant.toString());

        model.addAttribute("submittedForm", addedConsultant != null);
        model.addAttribute("status", consultant != null);
        model.addAttribute("modelName", "consultant");
        model.addAttribute("modelId", addedConsultant.getConsultantId());

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

        logger.info("About to add consultation form: " + consultationForm.toString());

        List<Patient> formPatients = patientService.getPatientsByName(consultationForm.getPatientName());
        List<Consultant> formConsultants = consultantService.getConsultantsByName(consultationForm.getConsultantName());
        List<Illness> formIllnesses = illnessService.getIllnessesByName(consultationForm.getIllnessName());
        List<Drug> formDrugs = drugService.getDrugsByName(consultationForm.getDrugName());

        Patient formPatient = formPatients.get(0);;
        Consultant formConsultant = formConsultants.get(0);
        Illness formIllness, addedIllness;
        Drug formDrug, addedDrug;

        /*try {
            formPatient = formPatients.get(0);
        } catch (IndexOutOfBoundsException e) {
            logger.error("Could not find a patient with name '" + consultationForm.getPatientName() + "'.");
            logger.info("Create patient in /add/patient and then try again!");
        }

        try {
            formConsultant = formConsultants.get(0);
        } catch (IndexOutOfBoundsException e) {
            logger.error("Could not find a consultant with name '" + consultationForm.getConsultantName() + "'.");
            logger.info("Create consultant in /add/consultant and then try again!");
        }*/

        try {
            formDrug = formDrugs.get(0);
        } catch (IndexOutOfBoundsException e) {
            logger.error("Could not find a drug that matches the name '" + consultationForm.getDrugName() + "'.");
            Drug drug = new Drug(null, consultationForm.getDrugName(), null, null);
            addedDrug = drugService.addDrug(drug);
            formDrug = addedDrug;
        }

        try {
            formIllness = formIllnesses.get(0);
        } catch (IndexOutOfBoundsException e) {
            // Add
            logger.error("Could not find an illness that matches the name '" + consultationForm.getIllnessName() + "'.");
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
        logger.info("Added test " + addedTest);

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
        logger.info("Added consultation ", addedConsultation);

        Diagnosis diagnosis = new Diagnosis(
                null,
                addedConsultation,
                addedConsultation.getConsultationId(),
                formIllness,
                formIllness.getIllnessId());

        Diagnosis addedDiagnosis = diagnosisService.addDiagnosis(diagnosis);
        logger.info("Added diagnosis " + addedDiagnosis);

        Treatment treatment = new Treatment(
                null,
                addedDiagnosis,
                addedDiagnosis.getDiagnosisId(),
                formDrug,
                formDrug.getDrugId());

        Treatment addedTreatment = treatmentService.addTreatment(treatment);
        logger.info("Added treatment " + addedTreatment);


        model.addAttribute("submittedForm", addedConsultation != null);
        model.addAttribute("status", consultationForm != null);
        model.addAttribute("modelName", "consultation");
        model.addAttribute("modelId", addedConsultation.getConsultationId());

        return "forms/consultation";
    }

    @GetMapping("/illness")
    public String getIllnessForm() {
        return "/forms/illness";
    }

    @PostMapping("/illness")
    public String postIllnessForm(@ModelAttribute("illness") Illness illness, BindingResult result, Model model) {

        if (result.hasErrors())
            return "pages/error";

        logger.info("Added illness: " + illness.toString());

        Illness addedIllness = illnessService.addIllness(illness);

        model.addAttribute("submittedForm", addedIllness != null);
        model.addAttribute("status", illness != null);
        model.addAttribute("modelName", "illness");
        model.addAttribute("modelId", addedIllness.getIllnessId());

        return "forms/illness";
    }


    @GetMapping("/diagnosis")
    public String getDiagnosisForm() {
        return "/forms/diagnosis";
    }

    @PostMapping("/diagnosis")
    public String postDiagnosisForm(@ModelAttribute("diagnosis") Diagnosis diagnosis, BindingResult result, Model model) {

        if (result.hasErrors())
            return "pages/error";

        logger.info("Added diagnosis: " + diagnosis.toString());

        Diagnosis addedDiagnosis = diagnosisService.addDiagnosis(diagnosis);

        model.addAttribute("submittedForm", addedDiagnosis != null);
        model.addAttribute("status", diagnosis != null);
        model.addAttribute("modelName", "diagnosis");
        model.addAttribute("modelId", addedDiagnosis.getDiagnosisId());

        return "forms/diagnosis";
    }

    @GetMapping("/drug")
    public String getDrugForm() {
        return "/forms/drug";
    }

    @PostMapping("/drug")
    public String postDrugForm(@ModelAttribute("drug") Drug drug, BindingResult result, Model model) {

        if (result.hasErrors())
            return "pages/error";

        logger.info("Added drug: " + drug.toString());

        Drug addedDrug = drugService.addDrug(drug);

        model.addAttribute("submittedForm", addedDrug != null);
        model.addAttribute("status", drug != null);
        model.addAttribute("modelName", "drug");
        model.addAttribute("modelId", addedDrug.getDrugId());

        return "forms/drug";
    }

    @GetMapping("/treatment")
    public String getTreatmentForm() {
        return "/forms/treatment";
    }

    @PostMapping("/treatment")
    public String postTreatmentForm(@ModelAttribute("treatment") Treatment treatment, BindingResult result, Model model) {

        if (result.hasErrors())
            return "pages/error";

        logger.info("Added treatment: " + treatment.toString());

        Treatment addedTreatment = treatmentService.addTreatment(treatment);

        model.addAttribute("submittedForm", addedTreatment != null);
        model.addAttribute("status", treatment != null);
        model.addAttribute("modelName", "treatment");
        model.addAttribute("modelId", addedTreatment.getTreatmentId());

        return "forms/treatment";
    }

    @GetMapping("/test")
    public String getTestForm() {
        return "/forms/test";
    }

    @PostMapping("/test")
    public String postTestForm(@ModelAttribute("test") Test test, BindingResult result, Model model) {

        if (result.hasErrors())
            return "pages/error";

        logger.info("Added test: " + test.toString());

        Test addedTest = testService.addTest(test);

        model.addAttribute("submittedForm", addedTest != null);
        model.addAttribute("status", test != null);
        model.addAttribute("modelName", "test");
        model.addAttribute("modelId", addedTest.getTestId());

        return "forms/test";
    }

}
