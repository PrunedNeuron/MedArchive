<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add consultation</title>
    <%@include file="../components/stylesheets.jsp"%>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp"%>
    <main class="main">
        <div class="mainBody">

            <div class="formContainer">
                <div class="card">
                    <form:form
                            modelAttribute="consultationForm"
                            action="/add/consultation"
                            method="post"
                            name="consultation"
                            id="consultation"
                    >
                        <div class="formInputContainer">
                            <label class="formLabel" for="patientName">Patient Name</label>
                            <br/>
                            <input class="formInput inputText" id="patientName" name="patientName" type="text" placeholder="Nathan Drake">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="consultantName">Consultant Name</label>
                            <br/>
                            <input class="formInput inputText" id="consultantName" name="consultantName" type="text" placeholder="Edward Kenway">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="consultationLocation">Consultation Location</label>
                            <br/>
                            <input class="formInput inputText" id="consultationLocation" name="consultationLocation" type="text" placeholder="Chicago, IL">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="consultationDate">Consultation Date</label>
                            <br />
                            <input class="formInput inputText" id="consultationDate" name="consultationDate" type="date" placeholder="Consultation Date">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="testName">Test Performed</label>
                            <br/>
                            <input class="formInput inputText capitalize" id="testName" name="testName" type="text" placeholder="Alanine Transaminase">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="testValue">Test Result</label>
                            <br/>
                            <input class="formInput inputText" id="testValue" name="testValue" type="text" placeholder="24 mg/dl">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="illnessName">Diagnosis</label>
                            <br/>
                            <input class="formInput inputText capitalize" id="illnessName" name="illnessName" type="text" placeholder="Leptospirosis">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="drugName">Drug Prescribed</label>
                            <br/>
                            <input class="formInput inputText capitalize" id="drugName" name="drugName" type="text" placeholder="Doxycycline">
                        </div>

                        <div class="formInputContainer">
                            <button id="submitButton" type="button" class="submitButton">Submit</button>
                            <div id="formStatusMessage" class="inlineBlock" style="margin-left: 1rem; color: #00d465">
                                <c:if test="${status == true}">
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
    </main>
</div>

<%@include file="../components/scripts.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/forms/consultation.js"></script>
</body>
</html>
