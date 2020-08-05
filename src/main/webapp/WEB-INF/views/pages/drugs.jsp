<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Drugs</title>
    <%@include file="../components/stylesheets.jsp"%>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp"%>
    <main class="main">
        <div class="mainBody">

            <h3 style="text-align: center">The following drugs are currently present in the database.</h3>
            <ul class="uk-list">
                <c:forEach var="drug" items="${drugs}">
                    <li>
                        <h3 class="uk-heading-bullet">
                            <a href="https://en.wikipedia.org/wiki/${drug.drugName}"
                               target="_blank" rel="noopener noreferrer">
                                    ${drug.drugName} <i class="fas fa-external-link-alt"></i>
                            </a>
                            <br />
                            <span class="uk-text-muted" style="text-transform: capitalize; font-size: 1rem; font-weight: 300;">${drug.drugClassification}</span>
                        </h3>

                        <p>${drug.drugMechanism}</p>
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
