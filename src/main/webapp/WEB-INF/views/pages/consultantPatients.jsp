<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Patients treated by ${consultant.consultantName}</title>
    <%@include file="../components/head.jsp" %>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp" %>
    <div class="mainBody">
        <h2 style="text-align: center;">Dr. <a href="/consultants/${consultant.consultantId}">${consultant.consultantName}</a> has treated ${fn:length(patients)} ${fn:length(patients) != 1 ? "patients" : "patient"}.</h2>
        <div class="cards">
            <c:forEach var="patient" items="${patients}">
                <div class="card">
                    <div class="item capitalize">
                        <span class="mutedText">Patient ID</span> ${patient.patientId}
                    </div>
                    <div class="item capitalize">
                        <span class="mutedText">Patient Name</span> ${patient.patientName}
                    </div>
                    <hr />
                    <div class="item capitalize cardFooterButton noselect">
                        <a href="/patients/${patient.patientId}" class="button">View Patient</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <%@include file="../components/footer.jsp" %>
</div>

<%@include file="../components/scripts.jsp" %>
</body>
</html>
