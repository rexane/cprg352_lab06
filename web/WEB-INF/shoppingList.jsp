
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}</p>
        <a href="ShoppingList?action=logout">Logout</a>

        <form action="" method="POST">
            <h2>List</h2>
            <label>Add Item: </label>
            <input type="text" name="item"><input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        
        <form action="" method="POST">
            <c:if test="${list != null}">
                <ul style="list-style-type:none;">
                    <c:forEach var="listItem" items="${list}">
                        <li>
                            <input type="radio" name="item" value="${listItem}">${listItem}
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
                    
            <input type="hidden" name="action" value="delete">
            <c:if test="${list.size() > 0}">
                <input type="submit" value="Delete">
            </c:if>
        </form>
        
    </body>
</html>
