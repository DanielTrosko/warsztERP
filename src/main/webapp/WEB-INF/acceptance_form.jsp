<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="UserDTO" type="com.example.warszterp.dto.UserDto"--%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2>Karta przyjęcia pojazdu do warsztatu:</h2>
<div>
    <form:form method="post" action="/car/acceptance/add" modelAttribute="data">

        <form:input path="userId" hidden="true"/>
        <form:input path="carId" hidden="true"/>
        <form:input path="repairId" hidden="true"/>
    <fieldset>
        <legend>dane karty przyjęcia pojazdu</legend>
        <form:label  path="dateOfAdmission">Data przyjęcia pojazdu</form:label>
        <form:input type="Date" path="dateOfAdmission"/>
            <form:errors path="dateOfAdmission"/><br>
        <form:label  path="acceptanceNumber">Numer zlecenia</form:label>
        <form:input type="text" path="acceptanceNumber"/>
            <form:errors path="acceptanceNumber"/><br>
    </fieldset>
    <fieldset>
        <legend>dane klienta</legend>
        <form:label  path="firstName">Imię</form:label>
        <form:input type="text" path="firstName"/>
            <form:errors path="firstName"/><br>
        <form:label  path="surname">Nazwisko</form:label>
        <form:input type="text" path="surname"/>
            <form:errors path="surname"/><br>
        <form:label  path="company">Firma</form:label>
        <form:input type="text" path="company"/>
            <form:errors path="company"/><br>
        <form:label  path="phoneNumber">Numer telefonu</form:label>
        <form:input type="text" path="phoneNumber"/>
            <form:errors path="phoneNumber"/><br>
        <form:label  path="street">Ulica</form:label>
        <form:input type="text" path="street"/>
            <form:errors path="street"/><br>
        <form:label  path="houseNumber">Numer mieszkania</form:label>
        <form:input type="text" path="houseNumber"/>
            <form:errors path="houseNumber"/><br>
        <form:label  path="postCode">Kod pocztowy</form:label>
        <form:input type="text" path="postCode"/>
            <form:errors path="postCode"/><br>
        <form:label  path="city">Miasto</form:label>
        <form:input type="text" path="city"/>
            <form:errors path="city"/>

    </fieldset>
    <fieldset>
        <legend>dane pojazdu</legend>
        <form:label  path="make">Marka</form:label>
        <form:input type="text" path="make"/>
            <form:errors path="make"/><br>
        <form:label  path="model">Model</form:label>
        <form:input type="text" path="model"/>
            <form:errors path="model"/><br>
        <form:label  path="year">Rok produkcji</form:label>
        <form:input type="text" path="year"/>
            <form:errors path="year"/><br>
        <form:label  path="fuel">Rodzaj paliwa</form:label>
        <form:radiobuttons items = "${fuels}" path = "fuel" />
            <form:errors path="fuel"/><br>
        <form:label  path="type">Typ nadwozia</form:label>
        <form:radiobuttons items = "${cars}" path = "type" />
            <form:errors path="type"/><br>
        <form:label  path="plateNumber">Numer tablicy rejestr.</form:label>
        <form:input type="text" path="plateNumber"/>
            <form:errors path="plateNumber"/><br>
        <form:label  path="vinNo">Numer VIN</form:label>
        <form:input type="text" path="vinNo"/>
            <form:errors path="vinNo"/>

    </fieldset>
    <fieldset>
        <legend>informacje dodatkowe</legend>
        <form:label  path="dataOfPickup">Data odbioru</form:label>
        <form:input type="Date" path="dataOfPickup"/>
            <form:errors path="dataOfPickup"/><br>
        <form:label  path="estimatedRepairCost">Szacowany koszt naprawy</form:label>
        <form:input  path="estimatedRepairCost"/>
            <form:errors path="estimatedRepairCost"/>

    </fieldset>
    <fieldset>
        <legend>dodatkowy opis</legend>
        <form:label  path="scopeOfWork">Zakres prac zleconych przez klienta</form:label>
        <form:input type="text" path="scopeOfWork"/>
             <form:errors path="scopeOfWork"/>
    </fieldset>
        <form:button value="submit" type="submit" >Zapisz zlecenie</form:button>
    </form:form>
</div>
</body>
</html>