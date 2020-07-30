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
                <form:form modelAttribute="consultation" action="/add/consultation" method="post" name="consultation"
                           id="consultation">
                    <fieldset class="uk-fieldset">
                        <legend class="uk-legend">Add a consultation</legend>
                        <div class="uk-margin">
                            <label>
                                <input id="patientId" name="patientId" class="uk-input uk-form-width-large" type="number" placeholder="Patient ID">
                            </label>
                        </div>
                        <div class="uk-margin">
                            <label>
                                <input id="consultantId" name="consultantId" class="uk-input uk-form-width-large" type="number" placeholder="Consultant ID">
                            </label>
                        </div>

                        <div class="uk-margin">
                            <label>
                                <input id="consultationLocation" name="consultationLocation" class="uk-input uk-form-width-large" type="text" placeholder="Consultation location">
                            </label>
                        </div>


                        <div class="uk-margin">
                            <label>
                                <input id="consultationDate" name="consultationDate" class="uk-input uk-form-width-large" type="date" placeholder="Consultation Date">
                            </label>
                        </div>

                        <div class="uk-margin">
                            <button id="submitButton" type="button" class="uk-button uk-button-primary">Submit</button>
                            &nbsp;&nbsp;
                            <span id="checkIcon" class="uk-margin-small-right" uk-icon="check" style="color: mediumspringgreen; display: none;"></span>

                        </div>
                        <div>
                            <c:if test="submittedForm">
                                <h6>${status ? "Successfully added " : "Failed to add "}a consultation!</h6>
                            </c:if>
                        </div>
                    </fieldset>
                </form:form>
            </div>
        </div>
    </main>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/add/consultation.js"></script>
<%@include file="../components/scripts.jsp"%>
</body>
</html>
