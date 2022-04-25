<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
            <th class="col"/>
        </tr>
        </thead>
        <tbody class="container" id="table-body">
            <c:forEach items="${ageGroup}" var="ageGroup">
                <tr class="row">
                    <td class="col">${ageGroup.ageGroup}</td>
                    <td class="col">
                        <c:if test="${ageGroup.age >= 36}">
                            <fmt:formatNumber type = "number" maxIntegerDigits = "1" value = "${ageGroup.age / 12}"/>
                             Years
                        </c:if>
                        <c:if test="${ageGroup.age < 36}">
                            ${ageGroup.age} Months
                        </c:if>
                    </td>
                    <td class="col">
                        <fmt:setLocale value = "en_US"/>
                        <fmt:formatNumber value = "${ageGroup.cost}" type = "currency"/>
                    </td>
                    <td class="col">
                        <button class="btn btn-lg btn-success btn-block col" id="" value="${ageGroup.id}" onclick='f1(this)'>Edit</button>
                        <a href="/user/agegroup/${ageGroup.id}" class="btn btn-lg btn-danger btn-block col">Delete</a>
                    </td>
                </tr>
                <tr class="row" id="edit-${ageGroup.id}" style="visibility: hidden; display:none">
                    <form action="/user/addAgeGroup/" method="post">
                            <input type="hidden" name="id" value="${ageGroup.id}">
                            <td class="col">
                                <input type="text" class="form-control" name="ageGroup" class="form-control" value="${form.ageGroup}" placeholder="Age Category">
                            </td>
                            <td class="col">
                                <div class="container">
                                    <div class="row">
                                        <div class="col">
                                            <input class="col-5" type="number"name="age" value="${form.months}" placeholder="Max Age">
                                            <select  class="col-6" name="period">
                                                <option value="Month">Month</option>
                                                <option value="Years">Years</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td class="col">
                                <input type="number" class="form-control" name="cost" value="${form.cost}" placeholder="Weekly Charge" >
                            </td>
                            <td class="col">
                                <button class="btn btn-lg btn-success" style="width: 100%">Confirm Edit</button>
                            </td>
                    </form>
                </tr>
            </c:forEach>
            <tr class="row">
                <form action="/user/addAgeGroup/" method="post">
                    <input type="hidden" name="id" value="${form.id}">
                    <td class="col">
                        <input type="text" class="form-control" id="ageGroup" name="ageGroup" class="form-control" value="${form.ageGroup}" placeholder="Age Group" autofocus>
                    </td>
                    <td class="col">
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                        <input class="col-5" type="number" id="age" name="age" value="${form.months}" placeholder="Max Age" autofocus>
    <%--                                    <label for="periodSelect">Months or Years</label>--%>
                                        <select  class="col-6" name="period" id="periodSelect">
                                            <option value="Month">Month</option>
                                            <option value="Years">Years</option>
                                        </select>
                                </div>
                            </div>
                        </div>
                    </td>

                    <td class="col">
                        <input type="number" id="addCost" class="form-control" name="cost" value="${form.cost}" placeholder="Weekly Charge" autofocus>
                    </td>
                    <td class="col"><button class="btn btn-lg btn-primary" type="submit" style="width: 100%">Add Category</button></td>
                </form>
            </tr>
        </tbody>
    </table>
</main>
<script src="../../../pub/js/ageGroupScript.js"></script>
<jsp:include page="../include/footer.jsp"/>