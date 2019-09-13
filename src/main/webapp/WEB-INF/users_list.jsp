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
        <tr>Lista użytkowników:</tr>
        <tr>
            <th>#</th>
            <th>Nazwa</th>
            <th>Adres</th>
            <th>login</th>
            <th>email</th>
            <th>Telefon</th>
            <th>Rola</th>
            <th>Akcje</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="elem" items="${list}" varStatus="no">
            <tr>
                <td>${no.count}</td>
                <td>${elem.firstName} ${elem.surname} ${elem.company}</td>
                <td>${elem.street} ${elem.houseNumber} ${elem.postCode} ${elem.city}</td>
                <td>${elem.username}</td>
                <td>${elem.email}</td>
                <td>${elem.phoneNumber}</td>
                <td> - </td>
                <td><c:url value="/admin/user/delete" var="delete">
                    <c:param name="id" value="${elem.id}"/>
                </c:url>
                    <c:url value="/admin/user/edit" var="edit">
                        <c:param name="id" value="${elem.id}"/>
                    </c:url>
                    <a href="<c:out value="${delete}"/>">usuń | </a>
                    <a href="<c:out value="${edit}"/>">edytuj</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:url var="add" value="/admin/user/add"/>
    <a href="<c:out value='${add}'/>">Dodaj użytkownika</a><br>
</div>
</body>
</html>