<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Illnesses</title>
    <%@include file="../components/stylesheets.jsp" %>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp" %>
    <div class="mainBody">

        <c:if test="${illness.illnessId != null}">
            <c:set var="illnessUri" value="${fn:replace(illness.illnessName, ' ', '_')}"/>
            <div class="cards">
                <div class="card subcard">
                    <div class="item capitalize">
                        <span class="mutedText">Name</span> ${illness.illnessName}
                    </div>
                    <div class="item">
                        <span class="mutedText">Description</span> ${illness.illnessDescription}
                    </div>
                    <div class="item capitalize">
                        <span class="mutedText">Symptoms</span> ${illness.illnessSymptoms}
                    </div>
                    <hr/>
                    <div class="item capitalize cardFooterButton noselect">
                        <a
                                target="_blank"
                                rel="noopener noreferrer"
                                href="https://en.wikipedia.org/wiki/${illnessUri}"
                                class="button"
                        >
                            View on Wikipedia
                        </a>
                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${illness.illnessId == null}">
            <h2>Illnesses</h2>
            <ul class="list">
                <c:forEach var="illness" items="${illnesses}">
                    <li>
                        <h3>
                            <a href="/illnesses/${illness.illnessId}"
                               target="_blank" rel="noopener noreferrer">
                                    ${illness.illnessName} <i class="fas fa-link"></i>
                            </a>
                        </h3>
                        <p>
                            <c:if test="${illness.illnessDescription != null}">
                                ${illness.illnessDescription}
                            </c:if>
                            <br/>
                            <c:if test="${illness.illnessSymptoms != null}">
                                Symptoms include ${illness.illnessSymptoms}, etc.
                            </c:if>
                        </p>
                    </li>
                    <br/>
                </c:forEach>
            </ul>
        </c:if>
    </div>
    <c:if test="${illness.illnessId == null}">
        <%@include file="../components/footer.jsp" %>
    </c:if>
</div>

<%@include file="../components/scripts.jsp" %>
</body>
</html>
