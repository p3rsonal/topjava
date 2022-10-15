<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <title>Show all userMeals</title>
    <style>
        .normal {color: green;}
        .exceeded {color: red;}
    </style>
</head>
<body>
    <h3><a href="index.jsp">Home</a></h3>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Time</th>
                <th>Description</th>
                <th>Calories</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${userMeals}" var="userMeal">
                <jsp:useBean id="userMeal" type="ru.javawebinar.topjava.model.UserMealWithExcess"/>
                <tr class="${userMeal.excess ? 'exceeded' : 'normal'}">
                    <td>${userMeal.id}</td>
                    <td><%=TimeUtil.toString(userMeal.getDateTime()) %></td>
                    <td>${userMeal.description}</td>
                    <td>${userMeal.calories}</td>
                    <td><a href="MealController?action=edit&id=<c:out value="${userMeal.id}"/>">Update</a></td>
                    <td><a href="MealController?action=delete&id=<c:out value="${userMeal.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="MealController?action=insert">Add user meal</a></p>
</body>
</html>