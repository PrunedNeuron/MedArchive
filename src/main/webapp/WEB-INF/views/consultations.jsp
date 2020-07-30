
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
                <div class="centered cardContainer">
                    <div class="uk-card uk-card-default">

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
                        </div>
                        <div class="uk-card-footer">
                            <a href="/patients/${consultation.patient.patientId}" class="uk-button uk-button-default">View Patient</a>
                            <a href="/consultants/${consultation.consultant.consultantId}" class="uk-button uk-button-default">View Consultant</a>
                        </div>
                    </div>
                </div>
            </div>


        </c:if>
        <c:if test="${consultation.consultationId == null}">
            <h4>All Consultations</h4>
            <c:forEach var="consultationEntry" items="${consultationList}">
                <div class="cards">
                    <div class="centered cardContainer">
                        <div class="uk-card uk-card-default">
                            <div class="uk-card-body">
                                <div class="uk-card-badge uk-label">${consultationDate}</div>
                                <div>
                                    <span style="display: inline-block" class="uk-text-muted uk-text-small uk-text-uppercase">Patient</span>
                                        ${consultationEntry.patient.patientName}
                                </div>
                                <div>
                                    <span style="display: inline-block" class="uk-text-muted uk-text-small uk-text-uppercase">Consultant</span>
                                        ${consultationEntry.consultant.consultantName}
                                </div>
                            </div>
                            <div class="uk-card-footer">
                                <a href="/consultations/${consultationEntry.consultationId}" class="uk-button uk-button-default">View Consultation</a>

                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>

<%@include file="components/scripts.jsp"%>
</body>
</html>
