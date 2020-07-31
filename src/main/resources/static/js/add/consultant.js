
const consultantForm = document.getElementById("consultant");

const consultantName = document.getElementById("consultantName");
const consultantEmail = document.getElementById("consultantEmail");
const consultantPhone = document.getElementById("consultantPhone");

consultantName.addEventListener("change", function (event) {
    if (!namePattern.test(consultantName.value)) {
        removeClass(consultantName, "uk-form-success");
        addAnotherClass(consultantName, "uk-form-danger");
    } else {
        removeClass(consultantName, "uk-form-danger");
        addAnotherClass(consultantName, "uk-form-success")
    }
})

consultantEmail.addEventListener("change", function (event) {
    if (!emailPattern.test(consultantEmail.value)) {
        removeClass(consultantEmail, "uk-form-success");
        addAnotherClass(consultantEmail, "uk-form-danger");
    } else {
        removeClass(consultantEmail, "uk-form-danger");
        addAnotherClass(consultantEmail, "uk-form-success");
    }
})

consultantPhone.addEventListener("change", function (event) {
    if (!phonePattern.test(consultantPhone.value)) {
        removeClass(consultantPhone, "uk-form-success");
        addAnotherClass(consultantPhone, "uk-form-danger");
    } else {
        removeClass(consultantPhone, "uk-form-danger");
        addAnotherClass(consultantPhone, "uk-form-success");
    }
})

submitButton.addEventListener("click", function() {
    if (validateConsultant()){
        removeClass(submitButton, "uk-animation-shake");
        removeClass(submitButton, "uk-button-danger");
        addAnotherClass(submitButton, "uk-button-primary");
        consultantForm.submit();
        setTimeout(function() {
            makeIconVisible(checkIcon);
            consultantForm.reset();
        }, 3000);
    }
    else {
        makeIconInvisible(checkIcon);
        addAnotherClass(submitButton, "uk-animation-shake");
        addAnotherClass(submitButton, "uk-button-danger");
        setTimeout(function() {
            removeClass(submitButton, "uk-animation-shake");
            removeClass(submitButton, "uk-button-danger");
            addAnotherClass(submitButton, "uk-button-primary");
        }, 1000);
    }

})

function validateConsultant() {
    return (
        validateName(consultantName.value)
        &&
        validateEmail(consultantEmail.value)
        &&
        validatePhone(consultantPhone.value)
    );
}