<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="components/stylesheets.jsp" %>
</head>
<body>

<div class="bodyContainer">
    <%@include file="components/navigation.jsp" %>
    <div class="mainBody">
        <c:if test="${consultant.consultantId != null}">

            <div class="cards">
                <div class="centered cardContainer">
                    <div class="uk-card uk-card-default">

                        <div class="uk-card-header">
                            <div class="uk-grid-small uk-flex-middle" uk-grid>
                                <div class="uk-width-expand">
                                    <h3 class="uk-card-title uk-margin-remove-bottom">Consultant #${consultant.consultantId}</h3>
                                </div>
                            </div>
                        </div>

                        <div class="uk-card-body">
                            <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">Name</span>
                                    ${consultant.consultantName}
                            </div>
                            <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">Phone</span>
                                    ${consultant.consultantPhone}
                            </div>
                            <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">Email</span>
                                    <span style="font-family: monospace">${consultant.consultantEmail}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </c:if>
        <c:if test="${consultant.consultantId == null}">
            <h4>All consultants</h4>
            <div class="cards">
                <c:forEach var="consultantEntry" items="${consultants}">
                    <div class="centered cardContainer">
                        <div class="uk-card uk-card-default">
                            <div class="uk-card-body">
                                <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">Name</span>
                                        ${consultantEntry.consultantName}
                                </div>

                            </div>
                            <div class="uk-card-footer">
                                <a href="/consultants/${consultantEntry.consultantId}" class="uk-button uk-button-default">View
                                    consultant</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>
</div>

<%@include file="components/scripts.jsp" %>
</body>
</html>
