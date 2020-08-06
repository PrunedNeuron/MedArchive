
const submitButton = document.getElementById("submitButton");
const addressPattern = /^[\w\-,\s]+$/
const namePattern = /^[a-zA-Z ]{2,30}$/;
const emailPattern = /\S+@\S+\.\S+/;
const phonePattern = /^[1-9][0-9]{9}$/;

function validatePhone(phone) {
    return phonePattern.test(phone)
}

function validateEmail(email) {
    return emailPattern.test(email);
}

function validateName(name) {
    return namePattern.test(name);
}

function validateAddress(address) {
    return addressPattern.test(address)
}

function validateRadios(radioA, radioB) {
    return radioA.checked || radioB.checked;
}

function validateAge(age) {
    return parseInt(age) <= 122 && parseInt(age) >= 1;
}

function validateId(id) {
    return id > 0;
}

function addAnotherClass(element, addend) {
    $(element).addClass(addend)
}

function removeClass(element, substring) {
    $(element).removeClass(substring);
}

function hideElement(element) {
    element.style.display = "none";
}

function validateText(text) {
    return text != null && text !== "";
}


setTimeout(function() {
    hideElement(formStatusMessage);
}, 5000);