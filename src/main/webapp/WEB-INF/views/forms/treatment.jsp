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
                <div class="card">

                    <form:form modelAttribute="treatment" action="/add/treatment" method="post" name="treatment"
                               id="treatment">

                        <div class="formInputContainer">
                            <label class="formLabel" for="diagnosisId">Diagnosis ID</label>
                            <br/>
                            <input class="formInput inputText" id="diagnosisId" name="diagnosisId" type="number" min="1" placeholder="12">
                        </div>

                        <div class="formInputContainer">
                            <label class="formLabel" for="drugId">Drug ID</label>
                            <br/>
                            <input class="formInput inputText" id="drugId" name="drugId" type="number" min="1" placeholder="15">
                        </div>

                        <div class="formInputContainer">
                            <button id="submitButton" type="button" class="submitButton">Submit</button>
                        </div>

                    </form:form>
                </div>
            </div>
        </div>
    </main>
</div>

<script type="text/javascript" src="../resources/js/forms/treatment.js"></script>
<%@include file="../components/scripts.jsp"%>
</body>
</html>
