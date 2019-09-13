<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="UserDTO" type="com.example.warszterp.dto.UserDto"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    
</head>
<body>
<form:form action="/admin/car/add" method="post" modelAttribute="car">
    <form:hidden path="id"/>
    <form:label path="owner">Właściciel</form:label>
    <form:select path="owner">
        <form:options items="${users}" itemLabel="surname" />
    </form:select><br>
    <form:label path="plateNumber">Numer rej.</form:label>
    <form:input path="plateNumber"/>
    <form:errors path="plateNumber"/><br>
    <form:label path="vinNo">Numer VIN</form:label>
    <form:input path="vinNo"/>
    <form:errors path="vinNo"/><br>
    <form:label path="make">Producent</form:label>
    <form:input path="make"/>
        <form:errors path="make"/><br>
    <form:label path="model">Model</form:label>
    <form:input path="model"/>
        <form:errors path="model"/><br>
    <form:label path="year">Rok prod.</form:label>
    <form:input path="year"/>
        <form:errors path="year"/><br>
    <form:label path="type">Typ nadwozia</form:label>
    <form:select path="type">
        <form:options items="${types}"/>
    </form:select><br>
    <form:label path="fuel">Typ paliwa</form:label>
    <form:select path="fuel">
        <form:options items="${fuels}"/>
    </form:select><br>
    <form:button type="submit" value="zapisz">Zapisz</form:button>
</form:form>
<div>


</div>
</body>
</html>