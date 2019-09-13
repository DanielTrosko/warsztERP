<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="UserDTO" type="com.example.warszterp.dto.UserDTO"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<c:url var="users" value="/admin/user"/>
<c:url var="cars" value="/admin/car"/>

<a href="<c:out value='${users}'/>">Użytkownicy</a><br>
<a href="<c:out value='${cars}'/>">Pojazdy</a><br>
<div style="margin-top: 40px;">
    <table border="2">
        <thead>
        <tr>Pojazdy</tr>
        <tr>
            <th>#</th>
            <th>Numer rej.</th>
            <th>Marka</th>
            <th>Model</th>
            <th>Właściciel</th>
            <th>Status</th>
            <th>Akcje</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="elem" items="${list}" varStatus="no">
            <tr>
                <td>${no.count}</td>
                <td>${elem.plateNumber}</td>
                <td>${elem.make}</td>
                <td>${elem.model}</td>
                <td>${elem.owner.firstName} ${elem.owner.surname}</td>
                <td> - </td>
                <td>
                    <c:url var="delete" value="/admin/car/delete">
                        <c:param name="id" value="${elem.id}"/>
                    </c:url>
                    <c:url var="edit" value="/admin/car/edit">
                        <c:param name="id" value="${elem.id}"/>
                    </c:url>
                    <a href="<c:out value="${delete}"/>">usuń | </a>
                    <a href="<c:out value="${edit}"/>">edytuj</a>
                </td>
            </tr>
        </c:forEach>
        <tr></tr>
        </tbody>
    </table>
</div>
<c:url var="add" value="/admin/car/add"/>
<a href="<c:out value='${add}'/>">Dodaj pojazd</a><br>


</body>
</html>