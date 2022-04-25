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
                <tr class="row">
                    <td class="col">${parent.primaryContact}</td>
                    <td class="col">${parent.email}</td>
                    <td class="col">${parent.address}, ${parent.city} ${parent.state}, ${parent.zip}</td>
                    <td class="col"><a href="/user/${parent.id}/children" class="btn btn-lg btn-primary btn-block col">View Kids</a></td>
                    <td class="col"><a href="/user/editFamily/${parent.id}" class="btn btn-lg btn-danger btn-block col">Edit</a></td>
                    <td class="col"><a href="/user/families/${parent.id}/delete" class="btn btn-lg btn-danger btn-block col">Delete</a></td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</main>

<jsp:include page="../include/footer.jsp"/>