<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="UserDTO" type="com.example.warszterp.dto.UserDTO"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>



</head>
<body>
<td>
    <c:url value="/car/acceptance/edit" var="url">
        <c:param name="id" value="${data.repairId}"/>
    </c:url>

</td>

<h2>Karta przyjęcia pojazdu na warsztat | <a href="<c:out value='${url}'/>">edytuj dokument</a> </h2>

<table border="2">
    <thead>
    <tr>dane karty przyjęcia pojazdu</tr>
    <tr>
        <th>numer zlecenia</th>
        <th>data przyjęcia</th>
        <th>data odbioru</th>
        <th>koszt naprawy</th>
        <th>uwagi klienta</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${data.acceptanceNumber}</td>
            <td>${data.dateOfAdmission}</td>
            <td>${data.dataOfPickup}</td>
            <td>${data.estimatedRepairCost}</td>
            <td>${data.scopeOfWork}</td>
        </tr>

    </tbody>
</table>

<table border="2">
    <thead>
    <tr>dane klienta</tr>
    <tr>
        <th>Nazwisko</th>
        <th>Firma</th>
        <th>Telefon</th>
        <th>Adres</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${data.firstName} ${data.surname}</td>
        <td>${data.company}</td>
        <td>${data.phoneNumber}</td>
        <td>${data.street} ${data.houseNumber} ${data.city}</td>

    </tr>
    </tbody>
</table>

<table border="2">
    <thead>
    <tr>dane pojazdu</tr>
    <tr>
        <th>Numer rejest.</th>
        <th>Numer VIN.</th>
        <th>Marka</th>
        <th>Model</th>
        <th>Rok prod.</th>
        <th>Typ paliwa</th>
        <th>Typ nadwozia</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${data.plateNumber}</td>
        <td>${data.vinNo}</td>
        <td>${data.make}</td>
        <td>${data.model}</td>
        <td>${data.year}</td>
        <td>${data.fuel}</td>
        <td>${data.type}</td>
    </tr>
    </tbody>
</table>

</body>
</html>