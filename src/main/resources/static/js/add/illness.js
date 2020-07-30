
const illnessForm = document.getElementById("illness");

const illnessName = document.getElementById("illnessName");

const checkIcon = document.getElementById("checkIcon");
const submitButton = document.getElementById("submitButton");

const namePattern = /^[a-zA-Z ]{2,30}$/;

illnessName.addEventListener("change", function (event) {
    if (!validateName(illnessName.value)) {
        removeClass(illnessName, "uk-form-success");
        addAnotherClass(illnessName, "uk-form-danger");
    } else {
        removeClass(illnessName, "uk-form-danger");
        addAnotherClass(illnessName, "uk-form-success")
    }
})

submitButton.addEventListener("click", function() {
    if (validateIllness()){
        removeClass(submitButton, "uk-animation-shake");
        removeClass(submitButton, "uk-button-danger");
        addAnotherClass(submitButton, "uk-button-primary");
        illnessForm.submit();
        setTimeout(function() {
            makeIconVisible(checkIcon);
            illnessForm.reset();
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

function validateIllness() {
    return (
        validateName(illnessName.value)
    );
}

function validateName(name) {
    return namePattern.test(name);
}

function validateAddress(address) {
    return addressPattern.test(address)
}

function validateId(id) {
    return id > 0;
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