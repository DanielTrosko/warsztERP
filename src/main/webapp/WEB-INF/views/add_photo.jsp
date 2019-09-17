<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding photos</title>
</head>
<body>
<h1>Photo for order number: ${id}</h1>

<h2>Add a new photo</h2>
<div>
    <form enctype="multipart/form-data" method="post" action="/car/photo/add/${id}">
        <p>
            Add photo: <input type="file" name="file"/>
        </p>
        <p>
            <input type="submit" value="Add"/>
        </p>
    </form>
    <c:if test="${not empty photo}">
        <font color="red">${photo}</font>
    </c:if>
</div>
<h2>Photo list</h2>
<table>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Type</th>
    </tr>
    <%--@elvariable id="files" type="java.util.List"--%>
    <c:forEach items="${files}" var="file" varStatus="stat">
        <tr>
            <td>${stat.count}</td>
            <td>${file.fileName}</td>
            <td>${file.contentType}</td>
            <td>
                <c:url var="getPhoto" value="/car/photo/show/${file.id}"/>
                <img src="${getPhoto}" width="200" height="200" alt="Blad"/>

            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
