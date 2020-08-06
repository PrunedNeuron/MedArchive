<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
    <title>Patients</title>
    <%@include file="../components/head.jsp" %>
</head>
<body>

<style>
    .cards .badge {
        float: right;
        background-color: #ff1b3d;
    }
</style>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp" %>
    <div class="mainBody">
        <c:if test="${patient.patientId != null}">
            <div class="cards">
                <div class="card subcard">
                    <c:if test="${allergyAlert == true}">
                        <div class="badge noselect">
                            ALLERGIC DRUG ALERT!
                        </div>
                    </c:if>
                    <div class="item capitalize">
                        <span class="mutedText">ID</span> ${patient.patientId}
                    </div>
                    <div class="item capitalize">
                        <span class="mutedText">Name</span> ${patient.patientName}
                    </div>
                    <div class="item capitalize">
                        <span class="mutedText">Age</span> ${patient.patientAge}
                    </div>
                    <div class="item capitalize">
                        <span class="mutedText">Gender</span> ${patient.patientGender}
                    </div>
                    <div class="item capitalize">
                        <span class="mutedText">Phone</span> ${patient.patientPhone}
                    </div>
                    <div class="item">
                        <span class="mutedText">Email</span>
                        <span style="font-family: monospace">
                            <a href="mailto:${patient.patientEmail}">
                                    ${patient.patientEmail}
                            </a>
                        </span>
                    </div>
                    <c:if test="${illnesses != null && illnesses != \"\"}">
                        <div class="item capitalize">
                            <span class="mutedText">
                                <c:if test="${fn:containsIgnoreCase(illnesses, ',')}">
                                    Diagnoses
                                </c:if>
                                <c:if test="${not fn:containsIgnoreCase(illnesses, ',')}">
                                    Diagnosis
                                </c:if>
                            </span> ${illnesses}
                        </div>
                    </c:if>

                    <c:if test="${drugs != null && drugs != \"\"}">
                        <div class="item capitalize">
                            <span class="mutedText">Prescribed</span> ${drugs}
                        </div>
                    </c:if>

                    <c:if test="${patient.patientAllergicTo != null && patient.patientAllergicTo != \"\"}">
                        <div class="item capitalize">
                            <span class="mutedText">Allergic to</span> ${patient.patientAllergicTo}
                        </div>
                    </c:if>

                    <hr />
                    <div class="item capitalize cardFooterButton noselect">
                        <a href="/patients/${patient.patientId}/history" class="button">View Patient History</a>
                    </div>

                </div>
            </div>
        </c:if>
        <c:if test="${patient.patientId == null}">
            <h2 style="text-align: center;">All Patients</h2>
            <div class="cards">
                <c:forEach var="patient" items="${patients}">
                    <div class="card multicard">
                        <div class="item capitalize">
                            <span class="mutedText">Name</span> ${patient.patientName}
                        </div>
                        <div class="item capitalize">
                            <span class="mutedText">Age</span> ${patient.patientAge}
                        </div>
                        <div class="item capitalize">
                            <span class="mutedText">Gender</span> ${patient.patientGender}
                        </div>
                        <hr />
                        <div class="item capitalize cardFooterButton noselect">
                            <a href="/patients/${patient.patientId}" class="button">View Patient</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>

    <%@include file="../components/footer.jsp" %>

</div>

<%@include file="../components/scripts.jsp" %>
</body>
</html>
