<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<main>
    <table class="table container">
        <thead class="container">
        <tr class="row">
            <th scope="col" class="col">Invoice Number</th>
            <th scope="col" class="col">Invoice Date</th>
        </tr>
        </thead>
        <tbody class="container" id="table-body">
        <c:forEach items="${invoices}" var="invoices">
        <tr class="row">
            <td  class="col">${invoice.invoiceNumber}</td>
            <td  class="col">${invoice.invoiceDate}</td>
            <td  class="col">${children.birthDate}</td>
            <td class="col">
<%--                <a href="/user/children/${children.id}" class="btn btn-lg btn-danger btn-block col">View</a>--%>
            </td>
        </tr>
        </c:forEach>
</main>



<jsp:include page="../include/footer.jsp"/>