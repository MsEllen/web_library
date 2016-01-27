<%@tag language="java" description="basic site template" pageEncoding="UTF-8"%>
<%@ attribute name="title" rtexprvalue="true" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
        <link rel='stylesheet' href='<c:url value="/css/style.css"/>' />
    </head>
    <body>
        <h1>Zoznam filmov</h1>
 
       <jsp:doBody/>
   </body>
</html>