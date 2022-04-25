<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Butterfly+Kids&display=swap" rel="stylesheet">
<%--    <link rel="stylesheet" href="style.css" />--%>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../../pub/css/register.css" />
    <title>Register</title>
</head>

<body class="body">

<nav class="navbar navbar-dark">
    <sec:authorize access="!isAuthenticated()">
         &nbsp; <a href="/login/login">Login</a>
          |   <a href="/login/register">Register</a>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <a href="/user/addFamily/">Add Family</a>
        | <a href="/user/families/">Families</a>
        | <a href="/user/agegroup/">Age Categories</a>
        | <a href="/user/createInvoice/">Create Invoice</a>
        | <a href="/user/invoice/">View Invoices</a>
        | <a href="/login/logout">Logout</a>
        | Welcome <sec:authentication property="principal.username" />
    </sec:authorize>
</nav>



<%--<c:set var="pathinfo" value="${fn:split(pageContext.request.requestURI, '/')}" />--%>
<%--<c:set var="len" value="${fn:length(pathinfo)}" />--%>
<%--<c:set var="id" value="${pathinfo[len-3]}" />--%>

<%--<jsp:useBean id="pathinfo" type="java.lang.String" />--%>
<%--<jsp:useBean id="len" type="java.lang.String" />--%>
<%--<jsp:useBean id="id" type="java.lang.String" />--%>

<%--<c:out value="${pathinfo}"/>--%>
<%--<br>--%>
<%--<c:out value="${len}"/>--%>
<%--<br>--%>
<%--<c:out value="${id}"/>--%>

<%--<c:if test="${pageContext.request.requestURI.contains(register)}">--%>
<%--    <nav class="navbar navbar-light bg-light">--%>

<%--        <span class="navbar-brand mb-0 h1">Navbar</span>--%>
<%--        <a href="../user/families/{id}">Families</a> |--%>
<%--        <a href="../user/agegroup/{id}">Age Categories</a>--%>
<%--    </nav>--%>
<%--</c:if>--%>