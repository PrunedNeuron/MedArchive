<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ayush
  Date: 7/31/20
  Time: 5:33 PM
  To change this template use File | Settings | File Templates.
--%>
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
            <div class="cards">
                <c:forEach var="consultation" items="${consultations}">
                    <div class="centered cardContainer">
                        <div class="uk-card uk-card-default">
                            <div class="uk-card-body">
                                <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">Patient</span>
                                        ${consultation.patient.patientName}
                                </div>
                                <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">Consultant</span>
                                        ${consultation.consultant.consultantName}
                                </div>

                            </div>
                            <div class="uk-card-footer">
                                <a href="/consultants/${consultation.consultationId}" class="uk-button uk-button-default">View
                                    consultation</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </main>
</div>


</body>
</html>


<%@include file="components/scripts.jsp"%>
</body>
</html>
