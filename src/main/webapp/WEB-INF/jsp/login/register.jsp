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
        <div id="errorUserName"></div>
    </div>
    <div class="container">
        <label for="emailId" class="sr-only">Email address</label>
        <input type="email" id="emailId" name="email" class="form-control" value="${form.email}" placeholder="Email Address">
        <div id="errorEmail"></div>
    </div>
    <div class="container">
        <label for="passwordId" class="sr-only">Password</label>
        <input type="password" id="passwordId" name="password" class="form-control" placeholder="Password">
        <div id="errorPassword"></div>
    </div>
    <div class="container">
        <label for="confirmPasswordId" class="sr-only">Confirm Password</label>
        <input type="password" id="confirmPasswordId" name="confirmPassword" class="form-control" placeholder="Confirm Password">
        <div id="errorConfirmPassword"></div>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>
<div>
    <p>Already have an account?</p><a href="./login.html">Login</a>
</div>

<jsp:include page="../include/footer.jsp"/>