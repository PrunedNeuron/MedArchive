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
                <form:form modelAttribute="treatment" action="/add/treatment" method="post" name="treatment"
                           id="treatment">
                    <fieldset class="uk-fieldset">
                        <legend class="uk-legend">Add a treatment</legend>
                        <div class="uk-margin">
                            <label>
                                <input id="consultationId" name="consultationId" class="uk-input uk-form-width-large" type="number" placeholder="Diagnosis ID">
                            </label>
                        </div>
                        <div class="uk-margin">
                            <label>
                                <input id="illnessId" name="illnessId" class="uk-input uk-form-width-large" type="number" placeholder="Drug ID">
                            </label>
                        </div>
                        <div class="uk-margin">
                            <button id="submitButton" type="button" class="uk-button uk-button-primary">Submit</button>
                            &nbsp;&nbsp;
                            <span id="checkIcon" class="uk-margin-small-right" uk-icon="check" style="color: mediumspringgreen; display: none;"></span>

                        </div>
                        <div>
                            <c:if test="submittedForm">
                                <h6>${status ? "Successfully added " : "Failed to add "}a treatment!</h6>
                            </c:if>
                        </div>
                    </fieldset>
                </form:form>
            </div>
        </div>
    </main>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/add/treatment.js"></script>
<%@include file="../components/scripts.jsp"%>
</body>
</html>
