<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<main class="main">
    <table class="table container" style="width:75pc;">
        <thead class="container">
            <tr class="row">
                <th class="col-3">Select</th>
                <th class="col-5">Invoice Number</th>
                <th class="col-4">Invoice Date</th>
            </tr>
        </thead>
        <tbody>
            <div class="container">
               <form>
                    <c:forEach items="${invoices}" var="invoices">
                        <tr class="row">
                            <td class="col-3" ><input type="radio" name="invoice" value=${invoices.invoiceNumber}></td>
                            <td  class="col-5">${invoices.invoiceNumber}</td>
                            <td  class="col-4">${invoices.invoiceDate}</td>
                        </tr>
                    </c:forEach>
                    <button id="getPdfBtn" class="btn btn-lg btn-primary" type="submit" style="width: 200px" onclick='f1(this)'>Select Invoice</button>
               </form>
            </div>
        </tbody>
    </table>
</main>
<script src="../../../pub/js/openPDF.js"></script>
<jsp:include page="../include/footer.jsp"/>