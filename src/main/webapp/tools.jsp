<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Expression language jest włączony--%>
<%@ page isELIgnored="false" %>
<%--JSTL jest włączony--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tools</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
</head>
<body>

    <table>

        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Type</th>
            <th>Available</th>
        </tr>
        <c:forEach items="${requestScope.tools}" var="tool">
            <tr>
                <td>${tool.id}</td>
                <td>${tool.name}</td>
                <td>${tool.type}</td>
                <td class="${tool.availability ? '' : 'not-'}available">
                    <form method="post">
                        <input type="hidden" name="id" value="${tool.id}">
                        <input type="hidden" name="isAvailable" value="${!tool.availability}">
                        <input type="submit" value="Toggle">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
