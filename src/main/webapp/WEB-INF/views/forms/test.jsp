<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add test</title>
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
                            modelAttribute="test"
                            action="/add/test"
                            method="post"
                            name="test"
                            id="test"
                    >
                        <div class="formInputContainer">
                            <label class="formLabel" for="consultationId">Consultation ID</label>
                            <br/>
                            <input class="formInput inputText" id="consultationId" name="consultationId" type="number" min="1" placeholder="2">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="testName">Test Name</label>
                            <br/>
                            <input class="formInput inputText" id="testName" name="testName" type="text" placeholder="Alanine Transaminase">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="testValue">Test Value</label>
                            <br/>
                            <input class="formInput inputText" id="testValue" name="testValue" type="text" placeholder="24">
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
                                <h6>${status ? "Successfully added " : "Failed to add "}a test!</h6>
                            </c:if>
                        </div>
                    </form:form>
                </div>
            </div>

        </div>
    </main>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/forms/test.js"></script>
<%@include file="../components/scripts.jsp"%>
</body>
</html>
