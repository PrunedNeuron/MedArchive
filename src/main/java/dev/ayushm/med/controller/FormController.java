package dev.ayushm.med.controller;

import dev.ayushm.med.model.*;
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

    @GetMapping("/added")
    public String getAddedPage() {
        return "/add/added";
    }

    @GetMapping("/patient")
    public String getAddPatient() {
        return "/add/patient";
    }

    @PostMapping("/patient")
    public String postAddPatient(@ModelAttribute("patient") Patient patient, BindingResult result, Model model) {
        if (result.hasErrors())
            return "error";

        logger.info("Added patient: " + patient.toString());
        logger.info("Added patient: " + patient.getPatientName());

        patientService.addPatient(patient);

        model.addAttribute("submittedForm", true);
        model.addAttribute("status", patient != null);
        model.addAttribute("modelName", "patient");

        return "/add/added";
    }


    @GetMapping("/consultant")
    public String getAddConsultant() {
        return "/add/consultant";
    }

    @PostMapping("/consultant")
    public String postAddConsultant(@ModelAttribute("consultant") Consultant consultant, BindingResult result, Model model) {

        if (result.hasErrors())
            return "error";

        logger.info("Added consultant: " + consultant.toString());
        logger.info("Added consultant: " + consultant.getConsultantName());

        consultantService.addConsultant(consultant);

        model.addAttribute("submittedForm", true);
        model.addAttribute("status", consultant != null);
        model.addAttribute("modelName", "consultant");

        return "add/added";
    }

    @GetMapping("/consultation")
    public String getAddConsultation() {
        return "/add/consultation";
    }

    @PostMapping("/consultation")
    public String postAddConsultation(@ModelAttribute("consultation") Consultation consultation, BindingResult result, Model model) {

        if (result.hasErrors())
            return "error";

        logger.info("Added consultant: " + consultation.toString());

        consultationService.addConsultation(consultation);

        model.addAttribute("submittedForm", true);
        model.addAttribute("status", consultation != null);
        model.addAttribute("modelName", "consultation");

        return "add/added";
    }

    @GetMapping("/illness")
    public String getAddIllness() {
        return "/add/illness";
    }

    @PostMapping("/illness")
    public String postAddIllness(@ModelAttribute("illness") Illness illness, BindingResult result, Model model) {

        if (result.hasErrors())
            return "error";

        logger.info("Added illness: " + illness.toString());

        illnessService.addIllness(illness);

        model.addAttribute("submittedForm", true);
        model.addAttribute("status", illness != null);
        model.addAttribute("modelName", "illness");

        return "add/added";
    }


    @GetMapping("/diagnosis")
    public String getAddDiagnosis() {
        return "/add/diagnosis";
    }

    @PostMapping("/diagnosis")
    public String postAddDiagnosis(@ModelAttribute("diagnosis") Diagnosis diagnosis, BindingResult result, Model model) {

        if (result.hasErrors())
            return "error";

        logger.info("Added diagnosis: " + diagnosis.toString());

        diagnosisService.addDiagnosis(diagnosis);

        model.addAttribute("submittedForm", true);
        model.addAttribute("status", diagnosis != null);
        model.addAttribute("modelName", "diagnosis");

        return "add/added";
    }

    @GetMapping("/drug")
    public String getAddDrug() {
        return "/add/drug";
    }

    @PostMapping("/drug")
    public String postAddDrug(@ModelAttribute("drug") Drug drug, BindingResult result, Model model) {

        if (result.hasErrors())
            return "error";

        logger.info("Added drug: " + drug.toString());

        drugService.addDrug(drug);

        model.addAttribute("submittedForm", true);
        model.addAttribute("status", drug != null);
        model.addAttribute("modelName", "drug");

        return "add/added";
    }

    @GetMapping("/treatment")
    public String getAddTreatment() {
        return "/add/treatment";
    }

    @PostMapping("/treatment")
    public String postAddTreatment(@ModelAttribute("treatment") Treatment treatment, BindingResult result, Model model) {

        if (result.hasErrors())
            return "error";

        logger.info("Added treatment: " + treatment.toString());

        treatmentService.addTreatment(treatment);

        model.addAttribute("submittedForm", true);
        model.addAttribute("status", treatment != null);
        model.addAttribute("modelName", "treatment");

        return "add/added";
    }

}
