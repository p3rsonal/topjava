<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru">
<head>
    <title>Add new userMeal</title>
</head>
<body>
<section>
    <jsp:useBean id="userMeal" type="ru.javawebinar.topjava.model.UserMeal" scope="request"/>
    <form method="POST" action='MealController' name="frmAddMeal">
        <input type="hidden" name="id" value="${userMeal.id}">
        <dl>
            <dt>DateTime:</dt>
            <dd><input type="datetime-local" value="${userMeal.dateTime}" name="dateTime"></dd>
        </dl>
        <dl>
            <dt>Description</dt>
            <dd><input type="text" value="${userMeal.description}" size="40" name="description"></dd>
        </dl>
        <dl>
            <dt>Calories</dt>
            <dd><input type="number" value="${userMeal.calories}" name="calories"></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
</body>
</html>