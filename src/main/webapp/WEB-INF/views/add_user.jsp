
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="UserDTO" type="com.example.warszterp.dto.UserDTO"--%>
<form:form method="POST" action="/createuser" modelAttribute="UserDTO">
    <form:input class="formControl" type="text" path="id" hidden="true"/>

    <div class="form-group">
        <form:label path="username">Username</form:label>
        <form:input class="formControl" type="text" required="required" path="username"/>
    </div>
    <div class="form-group">
        <form:label path="password">Password</form:label>
        <form:input class="formControl" type="password" required="required" path="password"/>
    </div>
    <div class="form-group">
        <form:label path="name">Name</form:label>
        <form:input class="formControl" type="text" required="required" path="name"/>
    </div>
    <div class="form-group">
        <form:label path="surname">Surname</form:label>
        <form:input class="formControl" type="text" required="required" path="surname"/>
    </div>
    <div class="form-group">
        <form:label path="email">Email</form:label>
        <form:input class="formControl" type="email" required="required" path="email"/>
    </div>
    <div class="form-group">
        <form:label path="city">City</form:label>
        <form:input class="formControl" type="text" required="required" path="city"/>
    </div>
    <div class="form-group">
        <form:label path="street">Street</form:label>
        <form:input class="formControl" type="text" required="required" path="street"/>
    </div>
    <div class="form-group">
        <form:label path="street">Post code</form:label>
        <form:input class="formControl" type="text" required="required" path="postCode"/>
    </div>
    <div class="form-group">
        <form:label path="houseNumber">House Number</form:label>
        <form:input class="formControl" type="text" required="required" path="houseNumber"/>
    </div>
    <div class="form-group">
        <form:label path="apartamentNumber">Appartment Number</form:label>
        <form:input class="formControl" type="text" required="required" path="apartamentNumber"/>
    </div>

    <form:button type="submit" class="btn btn-primary" value="Submit">Register</form:button>
</form:form>
