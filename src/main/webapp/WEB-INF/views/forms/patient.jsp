<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add patient</title>
    <%@include file="../components/head.jsp" %>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp" %>
        <div class="mainBody">
            <div class="formContainer">

                <div class="card">
                    <form:form
                            modelAttribute="patient"
                            action="/add/patient"
                            method="post"
                            name="patient"
                            id="patient"
                    >
                        <div class="formInputContainer">
                            <label class="formLabel" for="patientName">Name</label>
                            <br/>
                            <input class="formInput inputText" id="patientName" name="patientName" type="text"
                                   placeholder="John Doe">
                        </div>
                        <div class="formInputContainer">
                            <label class="formLabel" for="patientEmail">Email Address</label>
                            <br/>
                            <input class="formInput inputText" id="patientEmail" name="patientEmail" type="email"
                                   placeholder="johndoe@gmail.com">
                        </div>

                        <div class="formInputContainer inlineBlock">
                            <label class="formLabel" for="patientAge">Age</label>
                            <br/>
                            <input class="formInput" id="patientAge" name="patientAge" type="number" min="0" max="122"
                                   placeholder="27">
                        </div>

                        <div class="formInputContainer inlineBlock">
                            <label class="formLabel">Gender</label>
                            <br/>
                            <input class="formInput inputRadio" id="patientGenderMale" type="radio" name="patientGender"
                                   value="male">
                            <label for="patientGenderMale">Male</label>
                            <input class="formInput inputRadio" id="patientGenderFemale" type="radio"
                                   name="patientGender" value="female">
                            <label for="patientGenderFemale">Female</label>
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="patientPhone">
                                Phone Number
                            </label>
                            <br/>
                            <input class="formInput inputText" id="patientPhone" name="patientPhone" type="number"
                                   min="0" minlength="10" maxlength="10" placeholder="8485517336">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="patientAllergicTo">Drugs the patient is allergic to</label>
                            <br/>
                            <textarea class="formInput inputText" id="patientAllergicTo" name="patientAllergicTo"
                                      rows="5"
                                      placeholder="(space separated)"></textarea>
                        </div>

                        <div class="formInputContainer">
                            <button id="submitButton" type="button" class="submitButton">Submit</button>
                            <div id="formStatusMessage" class="inlineBlock" style="margin-left: 1rem; color: #00d465">
                                <c:if test="${status == true}">
<%--                                    Added patient with ID = ${modelId}--%>
                                    <i class="fas fa-check"></i>
                                    Success!
                                </c:if>
                            </div>
                        </div>
                        <div>
                            <c:if test="submittedForm">
                                <h6>${status ? "Successfully added " : "Failed to add "}a patient!</h6>
                            </c:if>
                        </div>
                    </form:form>
                </div>
            </div>

        </div>
    <%@include file="../components/footer.jsp" %>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/forms/patient.js"></script>
<%@include file="../components/scripts.jsp" %>
</body>
</html>
