
const illnessForm = document.getElementById("illness");
const illnessName = document.getElementById("illnessName");


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

function validateIllness() {
    return (
        validateName(illnessName.value)
    );
}
