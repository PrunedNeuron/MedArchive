<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../components/stylesheets.jsp"%>
</head>
<body>

    <div class="bodyContainer">
        <%@include file="../components/navigation.jsp"%>
        <main class="main">
            <div class="mainBody">
                <div class="formContainer">
                    <form:form modelAttribute="patient" action="/add/patient" method="post" name="patient"
                    id="patient">
                        <fieldset class="uk-fieldset">
                            <legend class="uk-legend">Add a patient</legend>
                            <div class="uk-margin">
                                <label>
                                    <input id="patientName" name="patientName" class="uk-input uk-form-width-large" type="text" placeholder="Name">
                                </label>
                            </div>
                            <div class="uk-margin">
                                <label>
                                    <input id="patientEmail" name="patientEmail" class="uk-input uk-form-width-large" type="email" placeholder="Email">
                                </label>
                            </div>

                            <div class="uk-margin">
                                <label>
                                    <input id="patientAge" name="patientAge" class="uk-input uk-form-width-large" type="number" min="0" max="122" placeholder="Age">
                                </label>
                            </div>

                            <div class="uk-margin uk-grid-small uk-child-width-auto uk-grid">
                                <label><input id="patientGenderMale" class="uk-radio uk-form-width-large" type="radio" name="patientGender" value="male">&nbsp;Male</label>
                                <label><input id="patientGenderFemale" class="uk-radio uk-form-width-large" type="radio" name="patientGender" value="female">&nbsp;Female</label>
                            </div>

                            <div class="uk-margin">
                                <label>
                                    <input id="patientPhone" name="patientPhone" class="uk-input uk-form-width-large" type="number" min="6000000000" minlength="10" maxlength="10" placeholder="Phone Number">
                                </label>
                            </div>

                            <div class="uk-margin">
                                <label>
                                    <textarea id="patientAllergicTo" name="patientAllergicTo" class="uk-textarea uk-form-width-large" rows="5" placeholder="Drugs the patient is allergic to (space separated)"></textarea>
                                </label>
                            </div>

                            <div class="uk-margin">
                                <button id="submitButton" type="button" class="uk-button uk-button-primary">Submit</button>
                                &nbsp;&nbsp;
                                <span id="checkIcon" class="uk-margin-small-right" uk-icon="check" style="color: mediumspringgreen; display: none;"></span>

                            </div>
                            <div>
                                <c:if test="submittedForm">
                                    <h6>${status ? "Successfully added " : "Failed to add "}a patient!</h6>
                                </c:if>
                            </div>
                        </fieldset>
                    </form:form>
                </div>

            </div>
        </main>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/add/patient.js"></script>
    <%@include file="../components/scripts.jsp"%>
</body>
</html>
