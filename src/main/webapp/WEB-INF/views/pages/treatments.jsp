<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../components/stylesheets.jsp"%>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp"%>
    <main class="main">
        <div class="mainBody">
            <h4>All diagnoses and their treatments</h4>
            <div class="cards">
                <c:forEach var="treatment" items="${treatments}">
                    <div class="card subcard">
                        <div class="item capitalize">
                            <span class="mutedText">Diagnosis</span> ${treatment.diagnosis.illness.illnessName}
                        </div>The following illnesses are currently present in the database.
                        Amyloidosis
                        <div class="item capitalize">
                            <span class="mutedText">Treated with</span> ${treatment.drug.drugName}
                        </div>
                        <hr />
                        <div class="item capitalize cardFooterButton noselect">
                            <a href="/drugs" class="button">View more drugs</a>
                            <a href="/illnesses" class="button">View more illnesses</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </main>
    <%@include file="../components/footer.jsp"%>
</div>

<%@include file="../components/scripts.jsp"%>
</body>
</html>