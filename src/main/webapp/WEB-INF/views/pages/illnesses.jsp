<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Illnesses</title>
    <%@include file="../components/stylesheets.jsp"%>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp"%>
    <main class="main">
        <div class="mainBody">

            <h1>Illnesses</h1>
            <ul class="uk-list">
                <c:forEach var="illness" items="${illnesses}">
                    <c:set var="illnessUri" value="${fn:replace(illness.illnessName, ' ', '_')}" />
                    <li>
                        <h3 class="uk-heading-bullet">
                            <a href="https://en.wikipedia.org/wiki/${illnessUri}"
                               target="_blank" rel="noopener noreferrer">Illnesses
                                    ${illness.illnessName} <i class="fas fa-external-link-alt"></i>
                            </a>
                        </h3>
                        <p>${illness.illnessDescription}
                            <br />
                            Symptoms include ${illness.illnessSymptoms}, etc.
                        </p>
                    </li>
                    <br />
                </c:forEach>
            </ul>

        </div>
    </main>
    <%@include file="../components/footer.jsp"%>
</div>

<%@include file="../components/scripts.jsp"%>
</body>
</html>
