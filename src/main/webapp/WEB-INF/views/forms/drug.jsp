<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add drug</title>
    <%@include file="../components/stylesheets.jsp"%>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp"%>
    <main class="main">
        <div class="mainBody">

            <%--<div class="formContainer">
                <form:form modelAttribute="drug" action="/add/drug" method="post" name="drug"
                           id="drug">
                    <fieldset class="uk-fieldset">
                        <legend class="uk-legend">Add a drug</legend>
                        <div class="uk-margin">
                            <label class="uk-form-label" for="drugName">Drug name</label>
                            <br />
                            <input id="drugName" name="drugName" class="uk-input uk-form-width-large" type="text" placeholder="Selegiline">
                        </div>

                        <div class="uk-margin">
                            <label class="uk-form-label" for="drugClassification">Drug classification</label>
                            <br />
                            <input id="drugClassification" name="drugClassification" class="uk-input uk-form-width-large" type="text" placeholder="MAO-B inhibitor">
                        </div>

                        <div class="uk-margin">
                            <label class="uk-form-label" for="drugMechanism">Drug mechanism</label>
                            <br />
                            <input id="drugMechanism" name="drugMechanism" class="uk-input uk-form-width-large" type="text" placeholder="Increases dopamine by inhibiting it's metabolism by MAO.">
                        </div>

                        <div class="uk-margin">
                            <button id="submitButton" type="button" class="uk-button uk-button-primary">Submit</button>
                            &nbsp;&nbsp;
                            <span id="checkIcon" class="uk-margin-small-right" uk-icon="check" style="color: mediumspringgreen; display: none;"></span>

                        </div>
                        <div>
                            <c:if test="submittedForm">
                                <h6>${status ? "Successfully added " : "Failed to add "}a drug!</h6>
                            </c:if>
                        </div>
                    </fieldset>
                </form:form>
            </div>--%>

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
                                <input class="formInput inputText" id="drugName" name="drugName" type="text" placeholder="Selegiline">
                            </div>

                            <div class="formInputContainer">
                                <label class="formLabel" for="drugClassification">Drug Classification</label>
                                <br/>
                                <input class="formInput inputText" id="drugClassification" name="drugClassification" type="text" placeholder="MAO-B Inhibitor">
                            </div>

                            <div class="formInputContainer">
                                <label class="formLabel" for="drugMechanism">Drug Mechanism</label>
                                <br/>
                                <textarea class="formInput inputText" id="drugMechanism" name="drugMechanism" rows="5" placeholder="Selegiline increases dopamine by inhibiting it's metabolism by MAO-B."></textarea>
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

<script type="text/javascript" src="../resources/js/forms/drug.js"></script>
<%@include file="../components/scripts.jsp"%>
</body>
</html>
