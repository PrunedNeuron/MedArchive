<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Error</title>
    <%@include file="../components/head.jsp" %>
</head>
<body>

<div class="bodyContainer">
    <%@include file="../components/navigation.jsp" %>
    <div class="mainBody">
        <div style="display: flex; justify-content: left; align-items: center; flex-wrap: wrap;">
            <h1>Sorry, the page you're looking for does not exist.</h1>
            <h1>Go <a href="/">home</a>.</h1>
        </div>
    </div>
    <%@include file="../components/footer.jsp" %>
</div>

<%@include file="../components/scripts.jsp" %>
</body>
</html>
