<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<header>
    <h1>Kids</h1>
</header>

<main class="main">
    <table class="table container">
        <thead class="container">
        <tr class="row">
            <th scope="col" class="col">First Name</th>
            <th scope="col" class="col">Last Name</th>
            <th scope="col" class="col">Birth Day</th>
            <th scope="col" class="col">Age Category</th>

        </tr>
        </thead>
        <tbody class="container" id="table-body">
        <c:forEach items="${children}" var="children">
            <tr class="row">
                <td  class="col">${children.firstName}</td>
                <td  class="col">${children.lastName}</td>
                <td  class="col">${children.birthDate}</td>
                <td class="col">${children.ageGroup.ageGroup}</td>
            </tr>
        </c:forEach>
        <tr class="row">
            <form action="/user/addChildren/" method="post">
                <input type="hidden" name="id" value="${form.id}">
                <td class="col">
                    <input type="text" class="form-control" id="firstName" name="firstName" class="form-control"
                           value="${form.firstName}" placeholder="First Name" autofocus>
                </td>
                <td class="col">
                    <input type="text" class="form-control" id="lastName" name="lastName" class="form-control"
                           value="${form.lastName}" placeholder="Last Name">
                </td>
                <td class="col">
                    <input type="date" class="form-control" id="birthDay" name="birthDay" class="form-control" value="${form.birth}" placeholder="Birth Day">
                </td>
                <td class="col">
                    <button class="btn btn-lg btn-primary" type="submit" style="width: 100%">Add Child</button>
                </td>
            </form>
        </tr>
        </tbody>
    </table>
</main>

<jsp:include page="../include/footer.jsp"/>