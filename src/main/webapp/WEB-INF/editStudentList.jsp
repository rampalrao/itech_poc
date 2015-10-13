<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Spring 3 hibernate integration example</title>
    </head>
    <body>
    <h2>Student Management Screen</h2>
    <form:form method="post" action="add" commandName="student">
        <table>
        <tr>
            <td><form:label path="firstname"><spring:message text="Firstname"/></form:label></td>
            <td><form:input path="firstname" /></td>
        </tr>
        <tr>
            <td><form:label path="lastname"><spring:message text="Lastname"/></form:label></td>
            <td><form:input path="lastname" /></td>
        </tr>
        <tr>
            <td><form:label path="email"><spring:message text="Email"/></form:label></td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td><form:label path="telephone"><spring:message text="Telephone"/></form:label></td>
            <td><form:input path="telephone" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message text="Add"/>"/>
            </td>
        </tr>
    </table>
    </form:form>
    <h3>Students</h3>
    <c:if  test="${!empty studentList}">
    <table class="data">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Telephone</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.lastname}, ${student.firstname} </td>
            <td>${student.email}</td>
            <td>${student.telephone}</td>
            <td><a href="delete/${student.studentid}">delete</a></td>
        </tr>
    </c:forEach>
    </table>
    </c:if>
    </body>
</html>