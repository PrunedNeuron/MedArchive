<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Drugs</title>
    <%@include file="../components/head.jsp" %>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp" %>
    <div class="mainBody">

        <c:if test="${drug.drugId != null}">
            <div class="cards">
                <div class="card subcard">
                    <div class="item capitalize">
                        <span class="mutedText">Name</span> ${drug.drugName}
                    </div>
                    <div class="item capitalize">
                        <span class="mutedText">Classification</span> ${drug.drugClassification}
                    </div>
                    <div class="item">
                        <span class="mutedText">Mechanism of Action</span> ${drug.drugMechanism}
                    </div>
                    <hr/>
                    <div class="item capitalize cardFooterButton noselect">
                        <a
                                target="_blank"
                                rel="noopener noreferrer"
                                href="https://en.wikipedia.org/wiki/${drug.drugName}"
                                class="button"
                        >
                            View on Wikipedia
                        </a>
                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${drug.drugId == null}">
            <h2>Medications / Drugs</h2>
            <ul class="list">
                <c:forEach var="drug" items="${drugs}">
                    <li>
                        <h3>
                            <a href="/drugs/${drug.drugId}">
                                    ${drug.drugName} <i class="fas fa-link"></i>
                            </a>
                            <br/>
                            <span style="text-transform: capitalize; font-size: 1rem; font-weight: 300;">${drug.drugClassification}</span>
                        </h3>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
    </div>
    <%@include file="../components/footer.jsp" %>
</div>

<%@include file="../components/scripts.jsp" %>
</body>
</html>
