<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add consultant</title>
    <%@include file="../components/head.jsp" %>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp" %>
    <div class="mainBody">
        <div class="formContainer">
            <div class="card">
                <form:form
                        modelAttribute="consultant"
                        action="/add/consultant"
                        method="post"
                        name="consultant"
                        id="consultant"
                >
                    <div class="formInputContainer">
                        <label class="formLabel" for="consultantName">Name</label>
                        <br/>
                        <input class="formInput inputText" id="consultantName" name="consultantName" type="text"
                               placeholder="John Doe">
                    </div>
                    <div class="formInputContainer">
                        <label class="formLabel" for="consultantEmail">Email Address</label>
                        <br/>
                        <input class="formInput inputText" id="consultantEmail" name="consultantEmail" type="email"
                               placeholder="johndoe@gmail.com">
                    </div>

                    <div class="formInputContainer">
                        <label class="formLabel" for="consultantPhone">
                            Phone Number
                        </label>
                        <br/>
                        <input class="formInput inputText" id="consultantPhone" name="consultantPhone" type="number"
                               min="0" minlength="10" maxlength="10" placeholder="8485517336">
                    </div>

                    <div class="formInputContainer">
                        <label class="formLabel" for="consultantSpecialty">
                            Specialty
                        </label>
                        <div class="selectContainer">
                            <select style="text-transform: capitalize;" class="select" id="consultantSpecialty"
                                    name="consultantSpecialty">
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
                                <option>ophthalmology</option>
                                <option>otorhinolaryngology</option>
                                <option>pulmonology</option>
                                <option>anesthesiology</option>
                            </select>
                        </div>
                    </div>

                    <div class="formInputContainer inlineBlock">
                        <label class="formLabel" for="consultantExperience">Experience</label>
                        <br/>
                        <input class="formInput" id="consultantExperience" name="consultantExperience" type="number"
                               min="1" max="80"
                               placeholder="12">
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

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/forms/consultant.js"></script>
<%@include file="../components/scripts.jsp" %>
</body>
</html>
