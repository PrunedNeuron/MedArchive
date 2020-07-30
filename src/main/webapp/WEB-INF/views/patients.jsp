<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patients</title>
    <%@include file="components/stylesheets.jsp"%>
</head>
<body>

<div class="bodyContainer">
    <%@include file="components/navigation.jsp"%>
    <main class="main">
        <div class="mainBody">
            <h4>All patients</h4>
            <div class="cards">
                <c:forEach var="patient" items="${patients}">
                    <div class="cardContainer">
                        <div class="card">
                            <div class="card-body">
                                <div class="text-gray" style="display: inline-block">Name</div> <div style="display: inline-block">${patient.patientName}</div>
                                <br />
                                <div class="text-gray" style="display: inline-block">Age</div> ${patient.patientAge}
                            </div>
                            <div class="card-footer">
                                <a href="/patients/${patient.patientId}"><button class="btn btn-primary">View More</button></a>
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
