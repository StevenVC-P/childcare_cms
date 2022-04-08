<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<header>
    <h1>Families</h1>
</header>

<main class="main">
    <table class="table container">
        <thead class="container">
        <tr class="row">
            <th scope="col" class="col-3"><h5>Primary Contact</h5></th>
            <th scope="col" class="col-3"><h5>Email</h5></th>
            <th scope="col" class="col-3"><h5>Address</h5></th>
            <th scope="col" class="col-3"></th>
        </tr>
        </thead>
        <tbody class="container" id="table-body">
            <c:forEach items="${parents}" var="parent">
                <tr scope="row">
                    <td>${parent.primaryContact}</td>
                    <td>${parent.email}</td>
                    <td>${parent.address}</td>
                </tr>
            </c:forEach>

            <div>
                <form action="/user/families/${id}" method="post">

                    <input type="hidden" name="id" value="${familyForm.id}">

                    <label for="primaryContact" class="sr-only">Primary Contact</label>
                    <input class="col" type="text" name="primaryContact" id="primaryContact" value="${familyForm.primaryContact}" required/>

                    <label for="email" class="sr-only">Email</label>
                    <input class="col" type="text" name="email" id="email" value="${familyForm.email}" required/>

                    <label for="phone" class="sr-only">Phone</label>
                    <input class="col" type="text" name="phone" id="phone" value="${familyForm.phone}" required/>

                    <label for="address" class="sr-only">Street Address</label>
                    <input class="col" type="text" name="address" id="address" value="${familyForm.address}" required/>

                    <label for="city" class="sr-only">City</label>
                    <input class="col" type="text" name="city" id="city" value="${familyForm.city}" required/>

<%--                    <label for="state" class="sr-only">State</label>--%>
<%--                    <select class="col" name="dropdown" id="state" value="${familyForm.state}" required>--%>
<%--                        <option value="AL">Alabama</option>--%>
<%--                        <option value="AK">Alaska</option>--%>
<%--                        <option value="AZ">Arizona</option>--%>
<%--                        <option value="AR">Arkansas</option>--%>
<%--                        <option value="CA">California</option>--%>
<%--                        <option value="CO">Colorado</option>--%>
<%--                        <option value="CT">Connecticut</option>--%>
<%--                        <option value="DE">Delaware</option>--%>
<%--                        <option value="DC">District Of Columbia</option>--%>
<%--                        <option value="FL">Florida</option>--%>
<%--                        <option value="GA">Georgia</option>--%>
<%--                        <option value="HI">Hawaii</option>--%>
<%--                        <option value="ID">Idaho</option>--%>
<%--                        <option value="IL">Illinois</option>--%>
<%--                        <option value="IN">Indiana</option>--%>
<%--                        <option value="IA">Iowa</option>--%>
<%--                        <option value="KS">Kansas</option>--%>
<%--                        <option value="KY">Kentucky</option>--%>
<%--                        <option value="LA">Louisiana</option>--%>
<%--                        <option value="ME">Maine</option>--%>
<%--                        <option value="MD">Maryland</option>--%>
<%--                        <option value="MA">Massachusetts</option>--%>
<%--                        <option value="MI">Michigan</option>--%>
<%--                        <option value="MN">Minnesota</option>--%>
<%--                        <option value="MS">Mississippi</option>--%>
<%--                        <option value="MO">Missouri</option>--%>
<%--                        <option value="MT">Montana</option>--%>
<%--                        <option value="NE">Nebraska</option>--%>
<%--                        <option value="NV">Nevada</option>--%>
<%--                        <option value="NH">New Hampshire</option>--%>
<%--                        <option value="NJ">New Jersey</option>--%>
<%--                        <option value="NM">New Mexico</option>--%>
<%--                        <option value="NY">New York</option>--%>
<%--                        <option value="NC">North Carolina</option>--%>
<%--                        <option value="ND">North Dakota</option>--%>
<%--                        <option value="OH">Ohio</option>--%>
<%--                        <option value="OK">Oklahoma</option>--%>
<%--                        <option value="OR">Oregon</option>--%>
<%--                        <option value="PA">Pennsylvania</option>--%>
<%--                        <option value="RI">Rhode Island</option>--%>
<%--                        <option value="SC">South Carolina</option>--%>
<%--                        <option value="SD">South Dakota</option>--%>
<%--                        <option value="TN">Tennessee</option>--%>
<%--                        <option value="TX">Texas</option>--%>
<%--                        <option value="UT">Utah</option>--%>
<%--                        <option value="VT">Vermont</option>--%>
<%--                        <option value="VA">Virginia</option>--%>
<%--                        <option value="WA">Washington</option>--%>
<%--                        <option value="WV">West Virginia</option>--%>
<%--                        <option value="WI">Wisconsin</option>--%>
<%--                        <option value="WY">Wyoming</option>--%>
<%--                    </select>--%>

                    <label for="zip" class="sr-only">Zip Code</label>
                    <input class="col" type="text" name="zip" id="zip" value="${familyForm.zip}" required/>

                    <button class="btn btn-lg btn-primary btn-block col" id="submit" type="submit">Add new family</button>
                </form>
            </div>
        </tbody>
    </table>
</main>


<jsp:include page="../include/footer.jsp"/>