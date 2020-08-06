<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Consultants</title>
    <%@include file="../components/head.jsp" %>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp" %>
    <div class="mainBody">
        <c:if test="${consultant.consultantId != null}">
            <div class="cards">
                <div class="card subcard">
                    <div class="item capitalize">
                        <span class="mutedText">ID</span> ${consultant.consultantId}
                    </div>
                    <div class="item capitalize">
                        <span class="mutedText">Name</span> ${consultant.consultantName}
                    </div>
                    <div class="item capitalize">
                        <span class="mutedText">Specialty</span> ${consultant.consultantSpecialty}
                    </div>
                    <div class="item capitalize">
                        <span class="mutedText">Experience</span> ${consultant.consultantExperience}
                    </div>
                    <div class="item capitalize">
                        <span class="mutedText">Phone</span> ${consultant.consultantPhone}
                    </div>
                    <div class="item">
                        <span class="mutedText">Email</span>
                        <span style="font-family: monospace">
                            <a href="mailto:${consultant.consultantEmail}">
                                    ${consultant.consultantEmail}
                            </a>
                        </span>
                    </div>

                    <hr />
                    <div class="item capitalize cardFooterButton noselect">
                        <a href="/consultants/${consultant.consultantId}/patients" class="button">View Patients</a>
                    </div>

                </div>
            </div>
        </c:if>
        <c:if test="${consultant.consultantId == null}">
            <h2 style="text-align: center;">All Consultants</h2>
            <div class="cards">
                <c:forEach var="consultant" items="${consultants}">
                    <div class="card multicard">
                        <div class="item capitalize">
                            <span class="mutedText">Name</span> ${consultant.consultantName}
                        </div>
                        <div class="item capitalize">
                            <span class="mutedText">Specialty</span> ${consultant.consultantSpecialty}
                        </div>
                        <div class="item capitalize">
                            <span class="mutedText">Experience</span> ${consultant.consultantExperience}
                        </div>
                        <hr />
                        <div class="item capitalize cardFooterButton noselect">
                            <a href="/consultants/${consultant.consultantId}" class="button">View Consultant</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>
    <%@include file="../components/footer.jsp" %>
</div>

<%@include file="../components/scripts.jsp" %>
</body>
</html>
