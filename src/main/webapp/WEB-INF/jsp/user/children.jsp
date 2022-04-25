<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<header>
    <h1>Kids</h1>
</header>

<main class="main">
    <table class="table container">
        <thead class="container">
        <tr class="row">
            <th scope="col" class="col">Child's Name</th>
            <th scope="col" class="col">Birth Day</th>
            <th scope="col" class="col"></th>
        </tr>
        </thead>
        <tbody class="container" id="table-body">
        <c:forEach items="${children}" var="children">
            <tr class="row">
                <td  class="col">${children.childName}</td>
                <td  class="col">${children.birthDate}</td>
                <td class="col">
                    <button class="btn btn-lg btn-success btn-block col update" id="" value="${children.id}" onclick='f1(this)'>Edit</button>
                    <a href="/user/children/${children.id}" class="btn btn-lg btn-danger btn-block col">Delete</a>
                </td>
            </tr>
        <tr class="row" id="edit-${children.id}" style="visibility: hidden; display:none">
            <form action="/user/${family_id}/addChildren/" method="post">
                <input type="hidden" name="id" value="${children.id}">
                <td class="col">
                    <input type="text" class="form-control" name="childName" class="form-control"
                           value="${children.childName}" placeholder="Name" autofocus>
                </td>
                <td class="col">
                    <input type="date" class="form-control" name="birthDay" class="form-control" value="${children.birthDate}" placeholder="Birth Day">
                </td>
                <td class="col">
                    <button class="btn btn-lg btn-success" type="submit" style="width: 100%">Edit Child</button>
                </td>
            </form>
        </c:forEach>
        <tr class="row">
            <form action="/user/${family_id}/addChildren/" method="post">
                <input type="hidden" name="id" value="${form.id}">
                <td class="col">
                    <div class="row">
                        <input type="text" class="form-control" name="childName" placeholder="Name" autofocus>
                        <c:forEach items='${bindingResult.getFieldErrors("childName")}' var="error">
                            <div style="color: red;">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </td>
                <td class="col">
                    <div class="row">
                        <input type="date" class="form-control" id="birthDay" name="birthDay" class="form-control" placeholder="Birth Day">
                        <c:forEach items='${bindingResult.getFieldErrors("birthDay")}' var="error">
                            <div style="color: red;">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </td>
                <td class="col">
                    <button class="btn btn-lg btn-primary" type="submit" style="width: 100%">Add Child</button>
                </td>
            </form>
        </tr>
        </tbody>
    </table>
</main>
<script src="../../../pub/js/ageGroupScript.js"></script>
<jsp:include page="../include/footer.jsp"/>