
const drugForm = document.getElementById("drug");

const drugName = document.getElementById("drugName");

const checkIcon = document.getElementById("checkIcon");
const submitButton = document.getElementById("submitButton");

const namePattern = /^[a-zA-Z ]{2,30}$/;

drugName.addEventListener("change", function (event) {
    if (!namePattern.test(drugName.value)) {
        removeClass(drugName, "uk-form-success");
        addAnotherClass(drugName, "uk-form-danger");
    } else {
        removeClass(drugName, "uk-form-danger");
        addAnotherClass(drugName, "uk-form-success")
    }
})

submitButton.addEventListener("click", function() {
    if (validateDrug()){
        removeClass(submitButton, "uk-animation-shake");
        removeClass(submitButton, "uk-button-danger");
        addAnotherClass(submitButton, "uk-button-primary");
        drugForm.submit();
        setTimeout(function() {
            makeIconVisible(checkIcon);
            drugForm.reset();
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

function validateDrug() {
    return (
        validateName(drugName.value)
    );
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