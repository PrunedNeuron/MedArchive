<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="components/stylesheets.jsp"%>
</head>
<body>

<div class="bodyContainer">
    <%@include file="components/navigation.jsp"%>
    <main class="main">
        <div class="mainBody">
            <h4>All treatments and diagnoses</h4>
            <div class="ui cards">
                <c:forEach var="treatment" items="${treatments}">
                    <div class="centered cardContainer" uk-scrollspy="cls: uk-animation-fade; target: .uk-card; delay: 250; repeat: true">
                        <div class="uk-card uk-card-default" >
                            <div class="uk-card-body">

                                <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">Diagnosis</span>
                                        ${treatment.diagnosis.illness.illnessName}
                                </div>
                                <div>
                                <span style="display: inline-block"
                                      class="uk-text-muted uk-text-small uk-text-uppercase">Drug</span>
                                        ${treatment.drug.drugName}
                                </div>
                            </div>
                            <div class="uk-card-footer" style="display: flex; justify-content: center">
                                <a href="/drugs" class="uk-button uk-button-default">
                                    View drugs
                                </a>
                                <a href="/illnesses" class="uk-button uk-button-default">
                                    View diagnoses
                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </main>
</div>

<%@include file="components/scripts.jsp"%>
</body>
</html>