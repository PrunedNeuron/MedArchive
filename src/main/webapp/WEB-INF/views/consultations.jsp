
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="components/stylesheets.jsp"%>
</head>
<body>

<div class="bodyContainer">
    <%@include file="components/navigation.jsp"%>
    <div class="mainBody">
        <c:if test="${consultation.consultationId != null}">

            <div class="cards">
                <%--<div class="centered cardContainer" uk-scrollspy="cls: uk-animation-fade; target: .uk-card; delay: 250; repeat: true">
                    <div class="uk-card uk-card-hover uk-card-default">

                        <div class="uk-card-header">
                            <div class="uk-grid-small uk-flex-middle" uk-grid>
                                <div class="uk-width-expand">
                                    <h3 class="uk-card-title uk-margin-remove-bottom">Consultation #${consultation.consultationId}</h3>
                                </div>
                            </div>
                        </div>

                        <div class="uk-card-body">
                            <div class="uk-card-badge uk-label">${consultationDate}</div>
                            <div>
                                <span style="display: inline-block" class="uk-text-muted uk-text-small uk-text-uppercase">Patient</span>
                                    ${consultation.patient.patientName}
                            </div>
                            <div>
                                <span style="display: inline-block" class="uk-text-muted uk-text-small uk-text-uppercase">Consultant</span>
                                    ${consultation.consultant.consultantName}
                            </div>
                            <div>
                                <span style="display: inline-block" class="uk-text-muted uk-text-small uk-text-uppercase">Location</span>
                                    ${consultation.consultationLocation}
                            </div>
                            <div>
                                <span style="display: inline-block" class="uk-text-muted uk-text-small uk-text-uppercase">Diagnosis</span>
                                    ${diagnoses}
                            </div>
                        </div>
                        <div class="uk-card-footer">
                            <a href="/patients/${consultation.patient.patientId}" class="uk-button uk-button-default">View Patient</a>
                            <a href="/consultants/${consultation.consultant.consultantId}" class="uk-button uk-button-default">View Consultant</a>
                        </div>
                    </div>
                </div>--%>
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
                        <div class="item capitalize">
                            <span class="mutedText">Diagnosis</span> ${diagnoses}
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
        <%@include file="components/footer.jsp"%>
    </c:if>


</div>

<%@include file="components/scripts.jsp"%>
</body>
</html>
