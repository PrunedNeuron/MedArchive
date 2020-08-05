<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tests</title>
    <%@include file="../components/stylesheets.jsp"%>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp"%>
    <main class="main">
        <div class="mainBody">

            <h2>Medical Tests</h2>
            <ul class="list" style="text-align: left">
                <c:forEach var="test" items="${tests}">
                    <c:if test="${test.testName != null}">
                        <c:set var="testUri" value="${fn:replace(test.testName, ' ', '_')}"/>
                        <li>
                            <p class="capitalize">

                                <a href="https://en.wikipedia.org/wiki/${testUri}"
                                   target="_blank" rel="noopener noreferrer">
                                        ${test.testName} <i class="fas fa-external-link-alt"></i>
                                </a>
                            </p>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>

        </div>
    </main>
    <%@include file="../components/footer.jsp"%>
</div>

<%@include file="../components/scripts.jsp"%>
</body>
</html>
