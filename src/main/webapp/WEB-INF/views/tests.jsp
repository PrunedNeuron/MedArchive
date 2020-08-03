<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tests</title>
    <%@include file="components/stylesheets.jsp"%>
</head>
<body>

<div class="bodyContainer">
    <%@include file="components/navigation.jsp"%>
    <main class="main">
        <div class="mainBody">

            <h3 style="text-align: center">The following tests are currently present in the database.</h3>
            <ul class="list">
                <c:forEach var="test" items="${tests}">
                    <c:if test="${test.testName != null}">
                        <li>
                            <h3 class="capitalize">
                                    ${test.testName}
                            </h3>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>

        </div>
    </main>
    <%@include file="components/footer.jsp"%>
</div>

<%@include file="components/scripts.jsp"%>
</body>
</html>
