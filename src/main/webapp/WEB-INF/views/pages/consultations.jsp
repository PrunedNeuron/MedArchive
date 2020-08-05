
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
    <div class="mainBody">
        <c:if test="${consultation.consultationId != null}">

            <div class="cards">
                    <div class="card subcard patientLess">
                        <div class="badge" style="float: right;">${consultationDate}</div>
                        <div class="item capitalize">
                            <span class="mutedText">ID</span> ${consultation.consultationId}
                        </div>
                        <div class="item capitalize">
                            <span class="mutedText">Patient</span> ${consultation.patient.patientName}
                        </div>
                        <div class="item capitalize">
                            <span class="mutedText">Consultant</span> ${consultation.consultant.consultantName}
                        </div>
                        <div class="item capitalize">
                            <span class="mutedText">Location</span> ${consultation.consultationLocation}
                        </div>
                        <div class="item">
                            <span class="mutedText">Tests</span> <span class="capitalize">${consultation.test.testName}</span> - ${consultation.test.testValue}
                        </div>
                        <div class="item capitalize">
                            <span class="mutedText">Diagnosis</span> ${diagnoses}
                        </div>
                        <div class="item capitalize">
                            <span class="mutedText">Treated with</span> ${drugs}
                        </div>
                        <hr />
                        <div class="item capitalize cardFooterButton noselect">
                            <a href="/patients/${consultation.patientId}" class="button">View Patient</a>
                            <a href="/consultants/${consultation.consultantId}" class="button">View Consultant</a>
                        </div>
                    </div>
            </div>
        </c:if>
        <c:if test="${consultation.consultationId == null}">
            <h4>All Consultations</h4>
            <div class="cards">
                <c:forEach var="consultation" items="${consultationList}">
                    <div class="card subcard patientLess">
                        <div class="item capitalize">
                            <span class="mutedText">Patient</span> ${consultation.patient.patientName}
                        </div>
                        <div class="item capitalize">
                            <span class="mutedText">Consultant</span> ${consultation.consultant.consultantName}
                        </div>
                        <hr />
                        <div class="item capitalize cardFooterButton noselect">
                            <a href="/consultations/${consultation.consultationId}" class="button">View Consultation</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>

    <c:if test="${consultation.consultationId == null}">
        <%@include file="../components/footer.jsp"%>
    </c:if>


</div>

<%@include file="../components/scripts.jsp"%>
</body>
</html>
