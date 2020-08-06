<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add diagnosis</title>
    <%@include file="../components/head.jsp"%>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp"%>
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

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/forms/diagnosis.js"></script>
<%@include file="../components/scripts.jsp"%>
</body>
</html>
