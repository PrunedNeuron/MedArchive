<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
    <title>Title</title>
    <%@include file="components/stylesheets.jsp" %>
</head>
<body>

<div class="bodyContainer">
    <%@include file="components/navigation.jsp" %>
    <div class="mainBody">
        <c:if test="${patient.patientId != null}">

            <div class="cards">
                <div class="centered cardContainer" uk-scrollspy="cls: uk-animation-fade; target: .uk-card; delay: 250; repeat: true">
                    <div class="uk-card uk-card-primary" >

                        <div class="uk-card-header">
                            <div class="uk-grid-small uk-flex-middle" uk-grid>
                                <div class="uk-width-expand">
                                    <h3 class="uk-card-title uk-margin-remove-bottom">Patient #${patient.patientId}</h3>
                                </div>
                            </div>
                        </div>

                        <div class="uk-card-body">
                            <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">Name</span>
                                    ${patient.patientName}
                            </div>
                            <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">Age</span>
                                    ${patient.patientAge}
                            </div>
                            <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">Gender</span>
                                <span style="text-transform: capitalize">${patient.patientGender}</span>
                            </div>
                            <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">Phone</span>
                                    ${patient.patientPhone}
                            </div>
                            <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">
                                    <c:if test="${fn:containsIgnoreCase(illnesses, ',')}">
                                        Diagnoses
                                    </c:if>
                                    <c:if test="${not fn:containsIgnoreCase(illnesses, ',')}">
                                        Diagnosis
                                    </c:if>
                                </span>
                                    ${illnesses}
                            </div>
                            <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">
                                    Prescribed
                                </span>
                                    ${drugs}
                            </div>
                            <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted">Allergic to</span>
                                <span style="text-transform: capitalize">${patient.patientAllergicTo}</span>
                            </div>
                        </div>
                        <div class="uk-card-footer">
                            <a href="/patients/history/${consultation.patient.patientId}" class="uk-button uk-button-default">View Patient History</a>
                        </div>
                    </div>
                </div>
            </div>


        </c:if>
        <c:if test="${patient.patientId == null}">
            <h4>All patients</h4>
            <div class="cards">
            <c:forEach var="patientEntry" items="${patients}">
                    <div class="centered cardContainer" uk-scrollspy="cls: uk-animation-fade; target: .uk-card; delay: 250; repeat: true">
                        <div class="uk-card uk-card-primary" >
                            <div class="uk-card-body">
                                <div class="uk-card-badge uk-label">${patientDate}</div>
                                <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">Name</span>
                                        ${patientEntry.patientName}
                                </div>
                                <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">Age</span>
                                        ${patientEntry.patientAge}
                                </div>
                                <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">Gender</span>
                                    <span style="text-transform: capitalize">${patientEntry.patientGender}</span>
                                </div>
                            </div>
                            <div class="uk-card-footer">
                                <a href="/patients/${patientEntry.patientId}" class="uk-button uk-button-default">View
                                    Patient</a>
                            </div>
                        </div>
                    </div>
            </c:forEach>
            </div>
        </c:if>
    </div>
</div>

<%@include file="components/scripts.jsp" %>
</body>
</html>
