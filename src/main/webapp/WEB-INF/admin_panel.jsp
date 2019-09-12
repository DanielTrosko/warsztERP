<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <h2>In main</h2>

</head>
<body>

<c:url var="users" value="/admin/users"/>
<c:url var="cars" value="/admin/cars"/>

<a href="<c:out value='${users}'/>">Użytkownicy</a>
<a href="<c:out value='${cars}'/>">Pojazdy</a>


</body>
</html>