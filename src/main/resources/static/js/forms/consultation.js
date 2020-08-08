// JQuery
$(document).ready(function () {
    $('#consultantName').autocomplete({
        source: '/api/consultants/search'
    });

    $('#patientName').autocomplete({
        source: '/api/patients/search'
    });

    $('#drugName').autocomplete({
        source: '/api/drugs/search'
    });

    $('#illnessName').autocomplete({
        source: '/api/illnesses/search'
    });

    $('#testName').autocomplete({
        source: '/api/tests/search'
    });

});
// JQuery end


const consultationForm = document.getElementById("consultation");

const patientName = document.getElementById("patientName");
const consultantName = document.getElementById("consultantName");
const consultationLocation = document.getElementById("consultationLocation");

const testName = document.getElementById("testName");
const testValue = document.getElementById("testValue");

const illnessName = document.getElementById("illnessName");

const drugName = document.getElementById("drugName");


patientName.addEventListener("change", function () {
    if (!validateName(patientName.value)) {
        removeClass(patientName, "formSuccess");
        addAnotherClass(patientName, "formDanger");
    } else {
        removeClass(patientName, "formDanger");
        addAnotherClass(patientName, "formSuccess")
    }
})

consultantName.addEventListener("change", function () {
    if (!validateAddress(consultantName.value)) {
        removeClass(consultantName, "formSuccess");
        addAnotherClass(consultantName, "formDanger");
    } else {
        removeClass(consultantName, "formDanger");
        addAnotherClass(consultantName, "formSuccess")
    }
})

consultationLocation.addEventListener("change", function () {
    if (!validateAddress(consultationLocation.value)) {
        removeClass(consultationLocation, "formSuccess");
        addAnotherClass(consultationLocation, "formDanger");
    } else {
        removeClass(consultationLocation, "formDanger");
        addAnotherClass(consultationLocation, "formSuccess");
    }
})

testName.addEventListener("change", function () {
    if (!validateText(testName.value)) {
        removeClass(testName, "formSuccess");
        addAnotherClass(testName, "formDanger");
    } else {
        removeClass(testName, "formDanger");
        addAnotherClass(testName, "formSuccess")
    }
})

testValue.addEventListener("change", function () {
    if (!validateText(testValue.value)) {
        removeClass(testValue, "formSuccess");
        addAnotherClass(testValue, "formDanger");
    } else {
        removeClass(testValue, "formDanger");
        addAnotherClass(testValue, "formSuccess")
    }
})

illnessName.addEventListener("change", function () {
    if (!validateText(illnessName.value)) {
        removeClass(illnessName, "formSuccess");
        addAnotherClass(illnessName, "formDanger");
    } else {
        removeClass(illnessName, "formDanger");
        addAnotherClass(illnessName, "formSuccess")
    }
})

drugName.addEventListener("change", function () {
    if (!validateText(drugName.value)) {
        removeClass(drugName, "formSuccess");
        addAnotherClass(drugName, "formDanger");
    } else {
        removeClass(drugName, "formDanger");
        addAnotherClass(drugName, "formSuccess")
    }
})

submitButton.addEventListener("click", function () {
    if (validateConsultation()) {
        removeClass(submitButton, "shakeAnimation");
        removeClass(submitButton, "buttonDanger");
        addAnotherClass(submitButton, "buttonPrimary");
        consultationForm.submit();
        setTimeout(function () {
            consultationForm.reset();
        }, 3000);
    } else {
        addAnotherClass(submitButton, "shakeAnimation");
        addAnotherClass(submitButton, "buttonDanger");
        setTimeout(function () {
            removeClass(submitButton, "shakeAnimation");
            removeClass(submitButton, "buttonDanger");
            addAnotherClass(submitButton, "buttonPrimary");
        }, 1000);
    }

})


function validateConsultation() {
    return (
        validateName(patientName.value)
        &&
        validateName(consultantName.value)
        &&
        validateAddress(consultationLocation.value)
        &&
        validateText(testName.value)
        &&
        validateText(testValue.value)
        &&
        validateText(drugName.value)
    );
}