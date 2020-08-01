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
                <form:form modelAttribute="consultant" action="/add/consultant" method="post" name="consultant"
                           id="consultant">
                    <fieldset class="uk-fieldset">
                        <legend class="uk-legend">Add a medical consultant</legend>
                        <div class="uk-margin">
                            <label class="uk-form-label" for="consultantName">Full Name</label>
                            <br />
                            <input id="consultantName" name="consultantName" class="uk-input uk-form-width-large" type="text" placeholder="John Doe">
                        </div>
                        <div class="uk-margin">
                            <label class="uk-form-label" for="consultantEmail">Email Address</label>
                            <br />
                            <input id="consultantEmail" name="consultantEmail" class="uk-input uk-form-width-large" type="email" placeholder="abc@xyz.com">
                        </div>

                        <div class="uk-margin">
                            <label class="uk-form-label" for="consultantPhone">Phone Number</label>
                            <br />
                            <input id="consultantPhone" name="consultantPhone" class="uk-input uk-form-width-large" type="number" min="6000000000" minlength="10" maxlength="10" placeholder="10 digits">
                        </div>
                        <div class="uk-margin">
                            <label class="uk-form-label" for="consultantSpecialty">Specialty</label>
                            <div class="uk-form-controls">
                                <select style="text-transform: capitalize;" class="uk-select" id="consultantSpecialty" name="consultantSpecialty">
                                    <option disabled selected value>Choose a specialty</option>
                                    <option>infectious disease</option>
                                    <option>cardiology</option>
                                    <option>nephrology</option>
                                    <option>neurology</option>
                                    <option>immunology</option>
                                    <option>internal medicine</option>
                                    <option>gastroenterology</option>
                                    <option>psychiatry</option>
                                    <option>oncology</option>
                                    <option>dermatology</option>
                                    <option>opthalmology</option>
                                    <option>otorhinolaryngology</option>
                                    <option>pulmonology</option>
                                    <option>anesthesiology</option>
                                </select>
                            </div>
                        </div>

                        <div class="uk-margin">
                            <label class="uk-form-label" for="consultantExperience">Experience</label>
                            <br />
                            <input id="consultantExperience" name="consultantExperience" class="uk-input uk-form-width-large" type="number" min="1" max="80" placeholder="(in years)">

                        </div>

                        <div class="uk-margin">
                            <button id="submitButton" type="button" class="uk-button uk-button-primary">Submit</button>
                            &nbsp;&nbsp;
                            <span id="checkIcon" class="uk-margin-small-right" uk-icon="check" style="color: mediumspringgreen; display: none;"></span>

                        </div>
                        <div>
                            <c:if test="submittedForm">
                                <h6>${status ? "Successfully added " : "Failed to add "}a consultant!</h6>
                            </c:if>
                        </div>
                    </fieldset>
                </form:form>
            </div>

        </div>
    </main>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/add/consultant.js"></script>
<%@include file="../components/scripts.jsp"%>
</body>
</html>
