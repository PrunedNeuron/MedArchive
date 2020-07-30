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
                            <label>
                                <input id="consultantName" name="consultantName" class="uk-input uk-form-width-large" type="text" placeholder="Name">
                            </label>
                        </div>
                        <div class="uk-margin">
                            <label>
                                <input id="consultantEmail" name="consultantEmail" class="uk-input uk-form-width-large" type="email" placeholder="Email">
                            </label>
                        </div>

                        <div class="uk-margin">
                            <label>
                                <input id="consultantPhone" name="consultantPhone" class="uk-input uk-form-width-large" type="number" min="6000000000" minlength="10" maxlength="10" placeholder="Phone Number">
                            </label>
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
