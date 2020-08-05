const submitButton = document.getElementById("submitButton");

const addressPattern = /^[\w\-,\s]+$/
const namePattern = /^[a-zA-Z ]{2,30}$/;
const emailPattern = /\S+@\S+\.\S+/;
const phonePattern = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/;

function makeIconVisible(icon) {
    icon.style.display = "";
}

function makeIconInvisible(icon) {
    icon.style.display = "none";
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

function makeIconVisible(icon) {
    icon.style.display = "";
}

function makeIconInvisible(icon) {
    icon.style.display = "none";
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

function hideElement(element) {
    element.style.display = "none";
}

function validateText(text) {
    return text != null && text != "";
}


setTimeout(function() {
    hideElement(formStatusMessage);
}, 5000);