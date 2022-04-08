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
        <c:forEach items="${ageGroup}" var="parent">
            <tr class="row">
                <td>${ageGroup.ageCategory}</td>
                <td>${ageGroup.maxAge}</td>
                <td>${ageGroup.charge}</td>
            </tr>
        </c:forEach>

            <tr class="row">
                <td class="col"><button id="addCategory" class="btn btn-lg btn-primary" type="submit" style="width: 100%">Add Category</button></td>
                <td class="col"><button id="editCategories" class="btn btn-lg btn-danger" type="submit" style="width: 100%">Edit Categories</button></td>
            </tr>
            <tr class="row">
                <form action="/user/agegroup/${id}" method="post">
                    <td class="col">
                        <input type="text" class="form-control" id="ageCategory" name="ageCategory" class="form-control" value="${form.ageCategory}" placeholder="Age Category" autofocus>
                    </td>
                    <td class="col">
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <input class="col-5" type="text" id="addMaxAge" name="age" value="${form.age}" placeholder="Max Age" autofocus>
                                    <select  class="col-6" name="dropdown" id="dropdown">
                                        <option value="month">Month</option>
                                        <option value="year">Years</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </td>

                    <td class="col"><input type="text" id="addChargeAmount" class="form-control" name="charge" value="${form.charge}" placeholder="Weekly Charge" autofocus></td>
                    <td class="col"><button class="btn btn-lg btn-primary" type="submit" style="width: 100%">Add Category</button></td>
                </form>
            </tr>
        </tbody>
    </table>
</main>


<jsp:include page="../include/footer.jsp"/>