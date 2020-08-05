<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add drug</title>
    <%@include file="../components/head.jsp" %>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp" %>
    <main class="main">
        <div class="mainBody">
            <div class="formContainer">
                <div class="card">
                    <form:form
                            modelAttribute="drug"
                            action="/add/drug"
                            method="post"
                            name="drug"
                            id="drug"
                    >
                        <div class="formInputContainer">
                            <label class="formLabel" for="drugName">Drug Name</label>
                            <br/>
                            <input class="formInput inputText" id="drugName" name="drugName" type="text"
                                   placeholder="Selegiline">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="drugClassification">Drug Classification</label>
                            <br/>
                            <input class="formInput inputText" id="drugClassification" name="drugClassification"
                                   type="text" placeholder="MAO-B Inhibitor">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="drugMechanism">Drug Mechanism</label>
                            <br/>
                            <textarea class="formInput inputText" id="drugMechanism" name="drugMechanism" rows="5"
                                      placeholder="Selegiline increases dopamine by inhibiting it's metabolism by MAO-B."></textarea>
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
    </main>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/forms/drug.js"></script>
<%@include file="../components/scripts.jsp" %>
</body>
</html>
