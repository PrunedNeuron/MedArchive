
const consultantForm = document.getElementById("consultant");

const consultantName = document.getElementById("consultantName");
const consultantEmail = document.getElementById("consultantEmail");
const consultantPhone = document.getElementById("consultantPhone");

const checkIcon = document.getElementById("checkIcon");
const submitButton = document.getElementById("submitButton");

const namePattern = /^[a-zA-Z ]{2,30}$/;
const emailPattern = /\S+@\S+\.\S+/;
const phonePattern = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/;


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
    if (validatePatient()){
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

function makeIconVisible(icon) {
    icon.style.display = "";
}

function makeIconInvisible(icon) {
    icon.style.display = "none";
}

function validatePatient() {
    return (
        validateName(consultantName.name)
        &&
        validateEmail(consultantEmail.value)
        &&
        validatePhone(consultantPhone.value)
    );
}

function validatePhone(phone) {
    return phonePattern.test(phone)
}

function validateEmail(email) {
    return emailPattern.test(email);
}

function validateName(name) {
    return namePattern.test(name);
}

function addAnotherClass(element, addend) {
    const array = element.className.split(" ");
    if (array.indexOf(addend) == -1) {
        element.className += " " + addend;
    }
}

function removeClass(element, substring) {
    element.className = element.className.replaceAll(substring, "");
}