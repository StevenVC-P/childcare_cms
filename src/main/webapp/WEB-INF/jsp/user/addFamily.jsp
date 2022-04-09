<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<header>
    <h1>Add Families</h1>
</header>

<main class="main">
    <%--will be able to remove id from URL after demo--%>
    <form class="container" action="/user/registerFamily/" method="post">

        <input type="hidden" name="id" value="${familyForm.id}">

        <div class="row">
            <label for="primaryContact" class="sr-only">Primary Contact</label>
            <input class="col" type="text" name="primaryContact" id="primaryContact" value="${familyForm.primaryContact}" required/>
        </div>

        <div class="row">
            <label for="email" class="sr-only">Email</label>
            <input class="col" type="text" name="email" id="email" value="${familyForm.email}" required/>
        </div>

        <div class="row">
            <label for="phone" class="sr-only">Phone</label>
            <input class="col" type="text" name="phone" id="phone" value="${familyForm.phone}" required/>
        </div>

        <div class="row">
            <label for="address" class="sr-only">Street Address</label>
            <input class="col" type="text" name="address" id="address" value="${familyForm.address}" required/>
        </div>

        <div class="row">
            <label for="city" class="sr-only">City</label>
            <input class="col" type="text" name="city" id="city" value="${familyForm.city}" required/>
        </div>

        <div class="row">
            <label for="state" class="sr-only">State</label>
            <select class="col" name="dropdown" id="state" required>
                <jsp:include page="../include/statedropdown.jsp"/>
            </select>
        </div>

        <div class="row">
            <label for="zip" class="sr-only">Zip Code</label>
            <input class="col" type="text" name="zip" id="zip" value="${familyForm.zip}" required/>
        </div>

        <div class="row">
            <button class="btn btn-lg btn-primary btn-block col" id="submit" type="submit">Add new family</button>
        </div>

    </form>
</main>


<jsp:include page="../include/footer.jsp"/>