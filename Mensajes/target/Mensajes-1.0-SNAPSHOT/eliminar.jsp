<%-- 
    Document   : eliminar
    Created on : 25 oct. 2020, 17:39:44
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page import="com.oregoom.mensajes.MensajeDao"%>
<%@page import="com.oregoom.mensajes.Mensaje"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
			String id = request.getParameter("id");
			Mensaje mensaje = new Mensaje(Integer.valueOf(id));
			MensajeDao mensajeDao = new MensajeDao();
			mensajeDao.eliminar(mensaje);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		%>
    </body>
</html>
