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
    <main class="main">
        <div class="mainBody">
            <h4>Recent Consultations</h4>
            <div class="cards">
                <c:forEach var="consultation" items="${consultations}">
                    <div class="cardContainer">
                        <div class="card">

                            <div class="card-body">
                                <div class="text-gray" style="display: inline-block">Patient</div> <div style="display: inline-block">${consultation.patient.patientName}</div>
                                <br />
                                <div class="text-gray" style="display: inline-block">Consultant</div> ${consultation.consultant.consultantName}
                            </div>
                            <div class="card-footer">
                                <a href="/consultations/${consultation.consultationId}"><button class="btn btn-primary">View More</button></a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </main>
</div>

<%@include file="components/scripts.jsp"%>
</body>
</html>