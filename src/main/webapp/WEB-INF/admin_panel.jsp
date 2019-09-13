<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <h2>In main</h2>

</head>
<body>

<c:url var="users" value="/admin/user"/>
<c:url var="cars" value="/admin/car"/>

<a href="<c:out value='${users}'/>">Użytkownicy</a><br>
<a href="<c:out value='${cars}'/>">Pojazdy</a><br>


</body>
</html>