<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add illness</title>
    <%@include file="../components/head.jsp" %>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp" %>
    <div class="mainBody">
        <div class="formContainer">
            <div class="card">
                <form:form
                        modelAttribute="illness"
                        action="/add/illness"
                        method="post"
                        name="illness"
                        id="illness"
                >
                    <div class="formInputContainer">
                        <label class="formLabel" for="illnessName">Illness Name</label>
                        <br/>
                        <input class="formInput inputText" id="illnessName" name="illnessName" type="text"
                               placeholder="eg. Histoplasmosis">
                    </div>
                    <div class="formInputContainer">
                        <label class="formLabel" for="illnessDescription">Illness Description</label>
                        <br/>
                        <textarea class="formInput inputText" id="illnessDescription" name="illnessDescription" rows="5"
                                  placeholder="Histoplasmosis is caused by a fungus."></textarea>
                    </div>

                    <div class="formInputContainer">
                        <label class="formLabel" for="illnessSymptoms">Illness Symptoms</label>
                        <br/>
                        <textarea class="formInput inputText" id="illnessSymptoms" name="illnessSymptoms" rows="5"
                                  placeholder="Fever, cough, fatigue, chills"></textarea>
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

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/forms/illness.js"></script>
<%@include file="../components/scripts.jsp" %>
</body>
</html>
