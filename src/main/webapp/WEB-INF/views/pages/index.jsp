<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DigiMedArchive</title>
    <%@include file="../components/head.jsp" %>
</head>
<body>
<div class="bodyContainer">
    <%@include file="../components/navigation.jsp" %>
    <div class="mainBody">
        <div class="cards">
            <div class="card singleCard">
                <div class="cardTitle">
                    <h3>Recent Prescriptions</h3>
                </div>
                <div class="cardBody">
                    <ul>
                        <c:forEach var="treatment" items="${treatments}">
                            <li style="margin: 1rem;">
                                <div class="badge noselect">
                                    <fmt:formatDate value="${treatment.diagnosis.consultation.consultationDate}"
                                                    pattern="dd MMMM, yyyy"/>
                                </div>
                                <a href="/drugs/${treatment.drug.drugId}">
                                        ${treatment.drug.drugName}
                                </a>
                                was prescribed as a treatment for
                                <a href="/illnesses/${treatment.diagnosis.illnessId}">
                                        ${treatment.diagnosis.illness.illnessName}
                                </a>
                                by
                                <a href="/consultants/${treatment.diagnosis.consultation.consultantId}">
                                    Dr. ${treatment.diagnosis.consultation.consultant.consultantName}.
                                </a>

                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

            <div class="card singleCard">
                <div class="cardTitle">
                    <h3>Recent consultations</h3>
                </div>
                <div class="cardBody">
                    <ul>
                        <c:forEach var="consultation" items="${consultations}">
                            <li style="margin: 1rem;">
                                <div class="badge noselect">
                                    <fmt:formatDate value="${consultation.consultationDate}" pattern="dd MMMM, yyyy"/>
                                </div>
                                <a href="/patients/${consultation.patient.patientId}">
                                        ${consultation.patient.patientName}
                                </a>
                                consulted
                                <a href="/consultants/${consultation.consultant.consultantId}">
                                    Dr. ${consultation.consultant.consultantName}.
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>

    </div>
    <%@include file="../components/footer.jsp" %>
</div>

<%@include file="../components/scripts.jsp" %>
</body>
</html>