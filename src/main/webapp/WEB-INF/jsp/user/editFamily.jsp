<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<main>
    <form class="container" action="/user/registerFamily/" method="post">

        <input type="hidden" name="id" value="${form.id}">

        <div class="row">
            <label for="primaryContact" class="sr-only">Primary Contact</label>
            <input class="col" type="text" name="primaryContact" id="primaryContact" value="${form.primaryContact}" required/>
        </div>

        <div class="row">
            <label for="secondaryContact" class="sr-only">Secondary Contact</label>
            <input class="col" type="text" name="secondaryContact" id="secondaryContact" value="${form.secondaryContact}" required/>
        </div>

        <div class="row">
            <label for="email" class="sr-only">Email</label>
            <input class="col" type="text" name="email" id="email" value="${form.email}" required/>
        </div>

        <div class="row">
            <label for="phone" class="sr-only">Phone</label>
            <input class="col" type="text" name="phone" id="phone" value="${form.phone}" required/>
        </div>

        <div class="row">
            <label for="secondaryPhone" class="sr-only">Secondary Phone</label>
            <input class="col" type="text" name="secondaryPhone" id="secondaryPhone" value="${form.secondaryPhone}" required/>
        </div>

        <div class="row">
            <label for="address" class="sr-only">Street Address</label>
            <input class="col" type="text" name="address" id="address" value="${form.address}" required/>
        </div>

        <div class="row">
            <label for="city" class="sr-only">City</label>
            <input class="col" type="text" name="city" id="city" value="${form.city}" required/>
        </div>

        <div class="row">
            <label for="stateSelect" class="sr-only">State</label>
            <select class="col form-select" name="state" id="stateSelect" required>
                <jsp:include page="../include/statedropdown.jsp"/>
            </select>
        </div>

        <div class="row">
            <label for="zip" class="sr-only">Zip Code</label>
            <input class="col" type="text" name="zip" id="zip" value="${form.zip}" required/>
        </div>

        <div class="row">
            <button class="btn btn-lg btn-primary btn-block col" id="submit" type="submit">Update family</button>
        </div>
    </form>
</main>

<jsp:include page="../include/footer.jsp"/>