<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<fmt:bundle basename="messages"/>
<!DOCTYPE html>
<html lang="sk">
<head>
    <link rel='stylesheet' href='webjars/bootstrap/3.3.1/css/bootstrap.min.css'>
    <meta charset="UTF-8">
    <title><fmt:message key="Filmindex.header"/></title>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1><fmt:message key="Filmindex.header"/></h1>
        </div>
    </div>
    <c:if test="${not empty message}">
        <div class="row">
            <div class="col-md-12">
                <span class="label label-success"><fmt:message key="${message}"/></span>
            </div>
        </div>
    </c:if>
    <div class="row">
        <div class="col-md-8">
            <c:if test="${not empty films}">
            <form action="SFilmList" method="get">
                <table class="table table-striped">
                	<tr>
                		<td><fmt:message key="film.id"/></td>
                		<td><fmt:message key="film.name"/></td>
                		<td><fmt:message key="film.year"/></td>
                		<td><fmt:message key="film.genre"/></td>
                		<td><fmt:message key="film.state"/></td>
                		<td><fmt:message key="film.edit"/></td>
                		<td><fmt:message key="film.delete"/></td>
                	</tr>
                    <c:forEach items="${films}" var="film">
                        <tr>
                            <td>
                                <c:out value="${film.id}"/>
                            </td>
                            <td>
                                <c:out value="${film.name}"/>
                            </td>
                            <td>
                            	<fmt:formatDate value="${film.year}" pattern="yyyy" /> 
                            </td>
                            <td>
                                <c:out value="${film.genre.name}"/>
                            </td>
                            <td>
                                <c:out value="${film.state.name}"/>
                            </td>
                            <td>
                                <a role="button" href="SFilmEdit?filmId=${film.id}" class="btn btn-info"><fmt:message
                                        key="btn.edit"/></a>
                            </td>
                            <td>
                                <a role="button" href="SFilmDelete?filmId=${film.id}" class="btn btn-danger"><fmt:message
                                        key="btn.delete"/></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                </form>
            </c:if>
        </div>
        <div class="col-md-3">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" class="active"><a href="SFilmList"><fmt:message key="index.select"/> </a></li>
                <li role="presentation"><a href="ins"><fmt:message key="index.insert"/></a></li>
            </ul>
        </div>
    </div>

</div>
</body>

</html>
