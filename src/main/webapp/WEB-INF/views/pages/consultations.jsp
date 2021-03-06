<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Consultations</title>
    <%@include file="../components/head.jsp" %>
</head>
<body>
<div class="bodyContainer">
    <%@include file="../components/navigation.jsp" %>
    <div class="mainBody">
        <c:if test="${consultation.consultationId != null}">
            <div class="cards">
                <div class="card subcard patientLess">
                    <div class="badge noselect" style="float: right;">${consultationDate}</div>
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
                        <span class="mutedText">Tests</span> <span
                            class="capitalize">${consultation.test.testName}</span> - ${consultation.test.testValue}
                    </div>
                    <div class="item capitalize">
                        <span class="mutedText">Diagnosis</span> ${diagnoses}
                    </div>
                    <div class="item capitalize">
                        <span class="mutedText">Treated with</span> ${drugs}
                    </div>
                    <hr/>
                    <div class="item capitalize cardFooterButton noselect">
                        <a href="/patients/${consultation.patientId}" class="button">View Patient</a>
                        <a href="/consultants/${consultation.consultantId}" class="button">View Consultant</a>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${consultation.consultationId == null}">
            <h2 style="text-align: center;">All Consultations</h2>
            <div class="cards">
                <c:forEach var="consultation" items="${consultationList}">
                    <div class="card multicard">
                        <div class="deleteButtonContainer" title="Delete">
                            <div class="deleteButton" onclick="deleteConsultation(${consultation.consultationId})">
                                <i class="fas fa-minus"></i>
                            </div>
                        </div>
                        <div class="item capitalize">
                            <span class="mutedText">Patient</span> ${consultation.patient.patientName}
                        </div>
                        <div class="item capitalize">
                            <span class="mutedText">Consultant</span> ${consultation.consultant.consultantName}
                        </div>
                        <hr/>
                        <div class="item capitalize cardFooterButton noselect">
                            <a href="/consultations/${consultation.consultationId}" class="button">View Consultation</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>
    <%@include file="../components/footer.jsp" %>
</div>

<script>
    function deleteConsultation(id) {
        console.log("About to delete consultation #" + id)
        $.ajax({
            url: "/api/consultations/" + id,
            type: 'DELETE',
            failure: function () {
                console.log("Failed to delete consultation.");
            },
            success: function () {
                console.log("Deleted consultation successfully.");
                location.reload();
            }
        });
    }
</script>

<%@include file="../components/scripts.jsp" %>
</body>
</html>
