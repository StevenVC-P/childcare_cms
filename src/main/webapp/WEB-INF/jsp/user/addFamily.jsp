<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<header>
    <h1>Add Families</h1>
</header>

<main class="main">
    <%--will be able to remove id from URL after demo--%>
    <form class="container" action="/user/registerFamily/" method="post">

        <input type="hidden" name="id" value="${form.id}">

        <div class="row">
            <label for="primaryContact" class="sr-only">Primary Contact</label>
            <input class="col" type="text" name="primaryContact" id="primaryContact" value="${form.primaryContact}"/>
            <c:forEach items='${bindingResult.getFieldErrors("primaryContact")}' var="error">
                <div style="color: red;">${error.getDefaultMessage()}</div>
            </c:forEach>
        </div>

        <div class="row">
            <label for="email" class="sr-only">Email</label>
            <input class="col" type="text" name="email" id="email" value="${form.email}"/>
            <c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">
                <div style="color: red;">${error.getDefaultMessage()}</div>
            </c:forEach>
        </div>

        <div class="row">
            <label for="phone" class="sr-only">Phone</label>
            <input class="col" type="text" name="phone" id="phone" value="${form.phone}"/>
            <c:forEach items='${bindingResult.getFieldErrors("phone")}' var="error">
                <div style="color: red;">${error.getDefaultMessage()}</div>
            </c:forEach>
        </div>

        <div class="row">
            <label for="address" class="sr-only">Street Address</label>
            <input class="col" type="text" name="address" id="address" value="${form.address}"/>
            <c:forEach items='${bindingResult.getFieldErrors("address")}' var="error">
                <div style="color: red;">${error.getDefaultMessage()}</div>
            </c:forEach>
        </div>

        <div class="row">
            <label for="city" class="sr-only">City</label>
            <input class="col" type="text" name="city" id="city" value="${form.city}" />
            <c:forEach items='${bindingResult.getFieldErrors("city")}' var="error">
                <div style="color: red;">${error.getDefaultMessage()}</div>
            </c:forEach>
        </div>

        <div class="row">
            <label for="stateSelect" class="sr-only">State</label>
            <select class="col form-select" name="state" id="stateSelect" >
                <jsp:include page="../include/statedropdown.jsp"/>
            </select>
        </div>

        <div class="row">
            <label for="zip" class="sr-only">Zip Code</label>
            <input class="col" type="text" name="zip" id="zip" value="${form.zip}" />
            <c:forEach items='${bindingResult.getFieldErrors("zip")}' var="error">
                <div style="color: red;">${error.getDefaultMessage()}</div>
            </c:forEach>
        </div>

        <div class="row">
            <button class="btn btn-lg btn-primary btn-block col" id="submit" type="submit">Add new family</button>
        </div>

    </form>
</main>


<jsp:include page="../include/footer.jsp"/>