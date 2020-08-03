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
                <div class="card">
                    <form:form
                            modelAttribute="consultation"
                            action="/add/consultation"
                            method="post"
                            name="consultation"
                            id="consultation"
                    >
                        <div class="formInputContainer">
                            <label class="formLabel" for="patientId">Patient ID</label>
                            <br/>
                            <input class="formInput inputText" id="patientId" name="patientId" type="number" min="1" placeholder="12">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="consultantId">Consultant ID</label>
                            <br/>
                            <input class="formInput inputText" id="consultantId" name="consultantId" type="number" min="1" placeholder="15">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="consultationLocation">Consultation Location</label>
                            <br/>
                            <input class="formInput inputText" id="consultationLocation" name="consultationLocation" type="text" placeholder="Newark, NY">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="consultationDate">Consultation Date</label>
                            <br />
                            <input class="formInput inputText" id="consultationDate" name="consultationDate" type="date" placeholder="Consultation Date">
                        </div>

                        <div class="formInputContainer">
                            <button id="submitButton" type="button" class="submitButton">Submit</button>
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

<script type="text/javascript" src="../resources/js/forms/consultation.js"></script>
<%@include file="../components/scripts.jsp"%>
</body>
</html>
