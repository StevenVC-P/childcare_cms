<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp"/>
<header>
    <h1>Create Invoices</h1>
</header>

<main>
    <div class="container">
        <form action="/user/createInvoices/" method="post">
            <div class="row"><h2>Families</h2></div>
            <c:forEach items="${families}" var="families">
                <div class="row">
                    <input class="col" type="checkbox" name="invoice" value="${families.id}">
                    <h5 class="col">${families.primaryContact}</h5>
                </div>
            </c:forEach>
            <div class="row"><h2>Invoice Date</h2></div>
            <td class="row">
                <input type="date" class="form-control" id="invoiceDate" name="invoiceDate" class="form-control" value="${form.birth}" placeholder="Invoice Date">
            </td>
            <button class="btn btn-lg btn-primary" type="submit" style="width: 100%">Make Invoices</button>
        </form>
    </div>
</main>

<jsp:include page="../include/footer.jsp"/>