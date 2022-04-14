<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<header>
    <h1>Register to Dovecot</h1>
</header>

<form action="/login/registerSubmit" method="post">
    <h1 class="h3 mb-3 font weight-normal">Create an account</h1>
    <input type="hidden" name="id" value="${form.id}">
    <div class="container">
        <label for="userNameId" class="sr-only">User Name</label>
        <input type="text" id="userNameId" name="userName" class="form-control" value="${form.userName}" placeholder="User Name" autofocus>
        <c:forEach items='${bindingResult.getFieldErrors("userName")}' var="error">
            <div style="color: red;">${error.getDefaultMessage()}</div>
        </c:forEach>
    </div>
    <div class="container">
        <label for="emailId" class="sr-only">Email address</label>
        <input type="email" id="emailId" name="email" class="form-control" value="${form.email}" placeholder="Email Address">
        <c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">
            <div style="color: red;">${error.getDefaultMessage()}</div>
        </c:forEach>
    </div>
    <div class="container">
        <label for="passwordId" class="sr-only">Password</label>
        <input type="password" id="passwordId" name="password" class="form-control" placeholder="Password">
        <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">
            <div style="color: red;">${error.getDefaultMessage()}</div>
        </c:forEach>
    </div>
    <div class="container">
        <label for="confirmPasswordId" class="sr-only">Confirm Password</label>
        <input type="password" id="confirmPasswordId" name="confirmPassword" class="form-control" placeholder="Confirm Password">
        <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
            <div style="color: red;">${error.getDefaultMessage()}</div>
        </c:forEach>
<%--        <c:forEach items="'${}"--%>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>
<div>
    <p>Already have an account?</p><a href="./login.html">Login</a>
</div>

<jsp:include page="../include/footer.jsp"/>