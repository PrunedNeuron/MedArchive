<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${patient.patientName}'s Medical History</title>
    <%@include file="components/stylesheets.jsp"%>
</head>
<body>

<div class="bodyContainer">
    <%@include file="components/navigation.jsp"%>
    <main class="main">
        <div class="mainBody">
            <c:set var="length" scope="session" value="${fn:length(consultations)}" />
            <h4>${consultations[0].patient.patientName} has had ${length} ${length > 1 ? "consultations" : "consultation"}.</h4>
            <div class="cards">
                <c:forEach var="consultation" items="${consultations}">
                    <div class="card subcard patientLess">
                        <div class="item capitalize">
                            <span class="mutedText">Patient</span> ${consultation.patient.patientName}
                        </div>
                        <div class="item capitalize">
                            <span class="mutedText">Consultant</span> ${consultation.consultant.consultantName}
                        </div>
                        <div class="item capitalize">
                            <span class="mutedText">Location</span> ${consultation.consultationLocation}
                        </div>
                        <hr />
                        <div class="item capitalize cardFooterButton noselect">
                            <a href="/consultations/${consultation.consultationId}" class="button">View Consultation</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </main>
    <%@include file="components/footer.jsp"%>
</div>


</body>
</html>


<%@include file="components/scripts.jsp"%>
</body>
</html>
