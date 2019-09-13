<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="UserDTO" type="com.example.warszterp.dto.UserDto"--%>
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
    <p>Formularz użytkownika:</p>
    <form:form method="post" action="/admin/user/add" modelAttribute="user">
        <form:hidden path="id"/>
        <form:hidden path="addressId"/>
        <form:label path="username">Nazwa użytkownika</form:label>
        <form:input path="username"/>
            <form:errors path="username"/><br>
        <form:label path="email">Email</form:label>
        <form:input path="email"/>
            <form:errors path="email"/><br>
        <form:label path="password">Hasło</form:label>
        <form:password path="password"/>
            <form:errors path="password"/><br>
        <form:label path="rePassword">Powtórz hasło</form:label>
        <form:password path="rePassword"/>
            <form:errors path="rePassword"/><br>
        <form:label path="company">Firma</form:label>
        <form:input path="company"/><br>
        <form:label path="firstName">Imie</form:label>
        <form:input path="firstName"/>
            <form:errors path="firstName"/><br>
        <form:label path="surname">Nazwisko</form:label>
        <form:input path="surname"/>
            <form:errors path="surname"/><br>
        <form:label path="phoneNumber">Telefon</form:label>
        <form:input path="phoneNumber"/>
        <form:errors path="phoneNumber"/><br>
        <form:label path="street">Ulica</form:label>
        <form:input path="street"/>
            <form:errors path="street"/><br>
        <form:label path="houseNumber">Numer</form:label>
        <form:input path="houseNumber"/>
            <form:errors path="houseNumber"/><br>
        <form:label path="postCode">Kod pocztowy</form:label>
        <form:input path="postCode"/>
            <form:errors path="postCode"/><br>
        <form:label path="city">Miasto</form:label>
        <form:input path="city"/>
            <form:errors path="city"/><br>
        <form:button value="submit">Zapisz</form:button>
    </form:form>



</div>

</body>
</html>