
const consultantForm = document.getElementById("consultant");

const consultantName = document.getElementById("consultantName");
const consultantEmail = document.getElementById("consultantEmail");
const consultantPhone = document.getElementById("consultantPhone");
const consultantSpecialty = document.getElementById("consultantSpecialty");
const consultantExperience = document.getElementById("consultantExperience");
const formStatusMessage = document.getElementById("formStatusMessage");

consultantName.addEventListener("change", function (event) {
    if (!namePattern.test(consultantName.value)) {
        removeClass(consultantName, "formSuccess");
        addAnotherClass(consultantName, "formDanger");
    } else {
        removeClass(consultantName, "formDanger");
        addAnotherClass(consultantName, "formSuccess")
    }
})

consultantEmail.addEventListener("change", function (event) {
    if (!emailPattern.test(consultantEmail.value)) {
        removeClass(consultantEmail, "formSuccess");
        addAnotherClass(consultantEmail, "formDanger");
    } else {
        removeClass(consultantEmail, "formDanger");
        addAnotherClass(consultantEmail, "formSuccess");
    }
})

consultantPhone.addEventListener("change", function (event) {
    if (!phonePattern.test(consultantPhone.value)) {
        removeClass(consultantPhone, "formSuccess");
        addAnotherClass(consultantPhone, "formDanger");
    } else {
        removeClass(consultantPhone, "formDanger");
        addAnotherClass(consultantPhone, "formSuccess");
    }
})

consultantSpecialty.addEventListener("change", function (event) {
    if (!validateSpecialty(consultantSpecialty.value)) {
        removeClass(consultantSpecialty, "formSuccess");
        addAnotherClass(consultantSpecialty, "formDanger");
    } else {
        removeClass(consultantSpecialty, "formDanger");
        addAnotherClass(consultantSpecialty, "formSuccess");
    }
})

consultantExperience.addEventListener("change", function (event) {
    if (!validateExperience(consultantExperience.value)) {
        removeClass(consultantExperience, "formSuccess");
        addAnotherClass(consultantExperience, "formDanger");
    } else {
        removeClass(consultantExperience, "formDanger");
        addAnotherClass(consultantExperience, "formSuccess");
    }
})


submitButton.addEventListener("click", function() {
    if (validateConsultant()){
        removeClass(submitButton, "shakeAnimation");
        removeClass(submitButton, "buttonDanger");
        addAnotherClass(submitButton, "buttonPrimary");
        consultantForm.submit();
        setTimeout(function() {
            makeIconVisible(checkIcon);
            consultantForm.reset();
        }, 3000);
    }
    else {
        addAnotherClass(submitButton, "shakeAnimation");
        addAnotherClass(submitButton, "buttonDanger");
        setTimeout(function() {
            removeClass(submitButton, "shakeAnimation");
            removeClass(submitButton, "buttonDanger");
            addAnotherClass(submitButton, "buttonPrimary");
        }, 1000);
    }

})

function validateExperience() {
    return parseInt(consultantExperience.value) > 0 && parseInt(consultantExperience.value) <= 80;
}

function validateSpecialty() {
    return consultantSpecialty.selectedIndex > 0;
}

function validateConsultant() {
    return (
        validateName(consultantName.value)
        &&
        validateEmail(consultantEmail.value)
        &&
        validatePhone(consultantPhone.value)
        &&
        validateSpecialty()
        &&
        validateExperience()
    );
}

