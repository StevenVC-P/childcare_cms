<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<header>
    <h1>View Families</h1>
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
                    <td>${parent.address}, ${parent.city} ${parent.state}, ${parent.zip}</td>
                    <td><button class="btn btn-lg btn-primary btn-block col" id="submit" type="submit" action="/user/kids">View Kids</button></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</main>

<jsp:include page="../include/footer.jsp"/>