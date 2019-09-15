<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="UserDTO" type="com.example.warszterp.dto.UserDTO"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.9/css/mdb.min.css" rel="stylesheet">    <link rel="stylesheet" href="../static/style.css">
    <meta charset="UTF-8">
	
</head>
<body>


<div class="karta-przyjecia">
    <div class="container">
        <h2>Karta przyjęcia pojazdu do warsztatu:</h2>



                <form:form method="post" action="/car/acceptance/add" modelAttribute="data">
                    <form:input path="userId" hidden="true"/>
                    <form:input path="carId" hidden="true"/>
                    <form:input path="repairId" hidden="true"/>
                <div class="row">
                    <fieldset>
                        <legend>Dane karty przyjęcia pojazdu</legend>
                        <form:label  path="dateOfAdmission">Data przyjęcia pojazdu</form:label>
                        <form:input type="Date" path="dateOfAdmission"/>
                        <form:errors path="dateOfAdmission"/><br>
                        <form:label  path="acceptanceNumber">Numer zlecenia</form:label>
                        <form:input type="text" path="acceptanceNumber"/>
                        <form:errors path="acceptanceNumber"/><br>

                    </fieldset>


                </div>

                <div class="row">
                    <div class="col-md-8">
                        <fieldset>
                            <legend>Dane klienta</legend>
                            <form:label  path="firstName">Imię</form:label>
                            <div class="input-boi">
                                <form:input type="text" path="firstName"/>
                            </div>

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

                    </div>


                </div>
                   <div class="row text-right">
                       <fieldset>
                       <legend>Dane pojazdu</legend>
                       <form:label  path="make">Marka</form:label>
                       <form:input type="text" path="make"/>
                       <form:errors path="make"/><br>

                       <form:label  path="model">Model</form:label>
                       <form:input type="text" path="model"/>
                       <form:errors path="model"/><br>

                       <form:label  path="year">Rok produkcji</form:label>
                       <form:input type="text" path="year"/>
                       <form:errors path="year"/><br>

                       <form:label path="fuel">Typ paliwa</form:label>
                       <form:select path="fuel">
                           <form:options items="${fuels}"/>
                       </form:select><br>


                       <form:label path="type">Typ nadwozia</form:label>
                       <form:select path="type">
                           <form:options items="${types}"/>

                       </form:select><br>
                       <form:label  path="plateNumber">Numer tablicy rejestr.</form:label>
                       <form:input type="text" path="plateNumber"/>
                       <form:errors path="plateNumber"/><br>

                       <form:label  path="vinNo">Numer VIN</form:label>
                       <form:input type="text" path="vinNo"/>
                       <form:errors path="vinNo"/>

                   </fieldset>
                   </div>
                    <div class="row">
                        <fieldset>
                            <legend>Informacje dodatkowe</legend>
                            <form:label  path="dataOfPickup">Data odbioru</form:label>
                            <form:input type="Date" path="dataOfPickup"/>
                            <form:errors path="dataOfPickup"/><br>
                            <form:label  path="estimatedRepairCost">Szacowany koszt naprawy</form:label>
                            <form:input  path="estimatedRepairCost"/>
                            <form:errors path="estimatedRepairCost"/>

                        </fieldset>

                    </div>

                    <div class="row">
                        <fieldset>
                            <legend>Dodatkowy opis</legend>
                            <form:label  path="scopeOfWork">Zakres prac zleconych przez klienta</form:label>
                            <form:input type="text" path="scopeOfWork"/>
                            <form:errors path="scopeOfWork"/>
                        </fieldset>

                    </div>

                    <div class="row">
                        <form:button value="submit" type="submit" >Zapisz zlecenie</form:button>
                        </form:form>
                    </div>





    </div>
</div>



</body>
</html>