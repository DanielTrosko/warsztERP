<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="UserDTO" type="com.example.warszterp.dto.UserDTO"--%>
<html>
<head>


</head>

<body>

<table border="2">
    <thead></thead>
    <tr>Lista kart przyjęć pojazdów:</tr>
    <tr>
        <td>#</td>
        <td>numer</td>
        <td>data przyjecia</td>
        <td>data oddania</td>
        <td>koszt naprawy</td>
        <td>uwagi klienta </td>
        <td>tabl.rejestr. pojazdu</td>
        <td>właściciel</td>
        <td>szczegóły</td>


    </tr>
    <tbody></tbody>
<c:forEach var="elem" items="${list}" varStatus="no">
<tr>
    <td>${no.count}</td>
    <td>${elem.acceptanceNumber}</td>
    <td>${elem.dateOfAdmission}</td>
    <td>${elem.dataOfPickup}</td>
    <td>${elem.estimatedRepairCost}</td>
    <td>${elem.scopeOfWork}</td>
    <td>${elem.car.plateNumber}</td>
    <td>${elem.user.firstName} ${elem.user.surname}</td>
    <td>
        <c:url value="/car/acceptance/one" var="url">
            <c:param name="id" value="${elem.id}"/>
        </c:url>
        <a href="<c:out value='${url}'/>">dokument</a>
    </td>
</tr>
</c:forEach>
</table>


</body>
</html>