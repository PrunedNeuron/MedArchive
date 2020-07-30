package dev.ayushm.med.controller;

import dev.ayushm.med.model.Patient;
import dev.ayushm.med.service.PatientService;
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

    @GetMapping("/consultation")
    public String getAddConsultation() {
        return "/add/consultation";
    }

    @GetMapping("/illness")
    public String getAddIllness() {
        return "/add/illness";
    }

    @GetMapping("/diagnosis")
    public String getAddDiagnosis() {
        return "/add/diagnosis";
    }

    @GetMapping("/drug")
    public String getAddDrug() {
        return "/add/drug";
    }

    @GetMapping("/treatment")
    public String getAddTreatment() {
        return "/add/treatment";
    }

}
