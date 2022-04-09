<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<header>
    <h1>Age Groups</h1>
</header>

<main class="main">
    <table class="table container">
        <thead class="container">
        <tr class="row">
            <th scope="col" class="col">Age Category</th>
            <th scope="col" class="col">Maximum Age</th>
            <th scope="col" class="col">Weekly Charge</th>
        </tr>
        </thead>
        <tbody class="container" id="table-body">
            <c:forEach items="${ageGroup}" var="ageGroup">
                <tr class="row">
                    <td>${ageGroup.ageGroup}</td>
                    <td>${ageGroup.months}</td>
                    <td>${ageGroup.cost}</td>
                </tr>
            </c:forEach>

<%--            <tr class="row">--%>
<%--                <td class="col"><button id="addCategory" class="btn btn-lg btn-primary" type="submit" style="width: 100%">Add Category</button></td>--%>
<%--                <td class="col"><button id="editCategories" class="btn btn-lg btn-danger" type="submit" style="width: 100%">Edit Categories</button></td>--%>
<%--            </tr>--%>
            <tr class="row">
                <form action="/user/addAgeGroup/" method="post">
                    <input type="hidden" name="id" value="${form.id}">
                    <td class="col">
                        <input type="text" class="form-control" id="ageGroup" name="ageGroup" class="form-control" value="${form.ageGroup}" placeholder="Age Category" autofocus>
                    </td>
                    <td class="col">
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <input class="col-5" type="number" id="addMaxAge" name="months" value="${form.months}" placeholder="Max Age" autofocus>
<%--                                    <select  class="col-6" name="dropdown" id="dropdown">--%>
<%--                                        <option value="${form.period}">Month</option>--%>
<%--                                        <option value="${form.period}">Years</option>--%>
<%--                                    </select>--%>
                                </div>
                            </div>
                        </div>
                    </td>

                    <td class="col"><input type="number" id="addCost" class="form-control" name="cost" value="${form.cost}" placeholder="Weekly Charge" autofocus></td>
                    <td class="col"><button class="btn btn-lg btn-primary" type="submit" style="width: 100%">Add Category</button></td>
                </form>
            </tr>
        </tbody>
    </table>
</main>


<jsp:include page="../include/footer.jsp"/>