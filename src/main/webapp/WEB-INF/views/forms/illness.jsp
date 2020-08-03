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
            <%--<div class="formContainer">
                <form:form modelAttribute="illness" action="/add/illness" method="post" name="illness"
                           id="illness">
                    <fieldset class="uk-fieldset">
                        <legend class="uk-legend">Add an illness</legend>
                        <div class="uk-margin">
                            <label class="uk-form-label" for="illnessName">Illness Name</label>
                            <br />
                            <input id="illnessName" name="illnessName" class="uk-input uk-form-width-large" type="text" placeholder="e.g. Histoplasmosis">
                        </div>

                        <div class="uk-margin">
                            <label class="uk-form-label" for="illnessDescription">Illness Description</label>
                            <br />
                            <input id="illnessDescription" name="illnessDescription" class="uk-input uk-form-width-large" type="text" placeholder="Histoplasmosis is caused by a fungus.">
                        </div>

                        <div class="uk-margin">
                            <label class="uk-form-label" for="illnessSymptoms">Illness Symptoms</label>
                            <br />
                            <input id="illnessSymptoms" name="illnessSymptoms" class="uk-input uk-form-width-large" type="text" placeholder="Fever, cough, fatigue, chills, headache">
                        </div>

                        <div class="uk-margin">
                            <button id="submitButton" type="button" class="uk-button uk-button-primary">Submit</button>
                            &nbsp;&nbsp;
                            <span id="checkIcon" class="uk-margin-small-right" uk-icon="check" style="color: mediumspringgreen; display: none;"></span>

                        </div>
                        <div>
                            <c:if test="submittedForm">
                                <h6>${status ? "Successfully added " : "Failed to add "}an illness!</h6>
                            </c:if>
                        </div>
                    </fieldset>
                </form:form>
            </div>--%>

            <style>



            </style>

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
                                <textarea class="formInput inputText" id="illnessDescription" name="illnessDescription" rows="5" placeholder="Histoplasmosis is caused by a fungus."></textarea>
                            </div>

                            <div class="formInputContainer">
                                <label class="formLabel" for="illnessSymptoms">Illness Symptoms</label>
                                <br/>
                                <textarea class="formInput inputText" id="illnessSymptoms" name="illnessSymptoms" rows="5" placeholder="Fever, cough, fatigue, chills"></textarea>
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

<script type="text/javascript" src="../resources/js/forms/illness.js"></script>
<%@include file="../components/scripts.jsp"%>
</body>
</html>
