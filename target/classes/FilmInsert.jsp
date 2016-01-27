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
   	<title><fmt:message key="title.film.add"/></title>
   	<script src="js/jquery-2.1.3.min.js"></script>
   	<script src="js/validation.js"></script>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
           <h1><fmt:message key="title.film.add"/></h1>
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
        <div class="col-md-9">
            <form class="form-horizontal" role="form" method="post" onsubmit="return validate();">
                <div class="form-group">
                    <label for="filmName" class="col-md-2 control-label"><fmt:message key="lbl.filmName"/> </label>

                    <div class="col-md-7">
                        <input type="text" onblur="validateName()" class="form-control" id="filmName" name="filmName">
                    </div>
                </div>
                <div class="form-group">
                    <label for="filmGenre" class="col-md-2 control-label"><fmt:message key="lbl.filmGenre"/></label>

                    <div class="col-md-7">
                    	<select class="form-control" id="filmGenre" name="filmGenre">
                    		<c:forEach items="${genres}" var="genre">
                    			<option value="${genre.id}"><c:out value="${genre.name}"/></option>
                    		</c:forEach>
                    	</select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="filmYear" class="col-md-2 control-label"><fmt:message key="lbl.filmYear"/></label>

                    <div class="col-md-7">
                        <input type="text" onblur="validateDate()" class="form-control" id="filmYear" name="filmYear">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-7">
                        <button type="submit" class="btn btn-info"><fmt:message key="btn.insert"/></button>
                    </div>
                </div>
            </form>
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