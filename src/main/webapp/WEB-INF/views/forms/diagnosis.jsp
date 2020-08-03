<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add illness</title>
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
                                modelAttribute="diagnosis"
                                action="/add/diagnosis"
                                method="post"
                                name="diagnosis"
                                id="diagnosis"
                        >
                            <div class="formInputContainer">
                                <label class="formLabel" for="consultationId">Consultation ID</label>
                                <br/>
                                <input class="formInput inputText" id="consultationId" name="consultationId" type="number" min="1" placeholder="12">
                            </div>

                            <div class="formInputContainer">
                                <label class="formLabel" for="illnessId">Illness ID</label>
                                <br/>
                                <input class="formInput inputText" id="illnessId" name="illnessId" type="number" min="1" placeholder="15">
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

<script type="text/javascript" src="../resources/js/forms/diagnosis.js"></script>
<%@include file="../components/scripts.jsp"%>
</body>
</html>
