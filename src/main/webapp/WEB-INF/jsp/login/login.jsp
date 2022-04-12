<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<form action = "/login/loginSubmit" method="Post">

    Username: <input type="text" name="username">
    <br>
    Password: <input type="password" name="password">
    <br>
    <button type="submit">Submit</button>

</form>


<jsp:include page="../include/footer.jsp"/>