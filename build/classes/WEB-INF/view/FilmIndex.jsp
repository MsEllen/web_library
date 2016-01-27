<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" tagdir="/WEB-INF/tags" %>

<m:Base title="Zoznam">
    <form action="<c:url value='/FilmList' />" method="POST">
        <label for="nadpis">Nadpis</label>
        <input type="text" name="nadpis" />
        <br>
        <textarea name="obsah" cols="40" rows="5"></textarea>
        <br>
        <input value="Pridat" type="submit" />
    </form>

    <c:if test="${param.upozorneni}">
        <span>Musíte vyplnit obě pole.<br></span>
    </c:if>

    <c:choose>
        <c:when test="${not empty Film}">
            <c:forEach items="${films}">
                <div class="film">
                    <div class="nadpis"><c:out value="${film.name}"/></div>
                    <div class="button">
                        <form method="GET" action="<c:url value='/update'/>">
                            <input type="hidden" value="${film.id}" name="id" />
                            <input type="submit" value="Update"/>
                        </form>                               
                        <form method="POST" action="<c:url value='/delete'/>">
                            <input type="hidden" value="${film.id}" name="id" />
                            <input type="submit" value="Delete"/>
                        </form>                               
                    </div>
                    <div class="obsah"><c:out value="${film.year}"/></div>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <span>Dosud nebyl přidán žádný zápisek.</span>
        </c:otherwise>
    </c:choose>
</m:Base>