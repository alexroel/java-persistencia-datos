<%-- 
    Document   : editar
    Created on : 25 oct. 2020, 16:58:07
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page import="com.oregoom.mensajes.Mensaje"%>
<%@page import="com.oregoom.mensajes.MensajeDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Mensaje</title>
		<link rel="stylesheet" 
			  href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" 
			  integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" 
			  crossorigin="anonymous">
    </head>
    <body>
        <!-- Modal -->
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="editar.jsp" method="POST">
					<div class="modal-header">
						<h5 class="modal-title">Editar Mensaje</h5>
					</div>
					<div class="modal-body">

						<div class="form-group">
							<input type="hidden" name="id" value="<%=request.getParameter("id")%>" >
							<label>Ingrese el Mensaje</label>
							<textarea class="form-control" name="mensaje" rows="3"><%=request.getParameter("mensaje")%>
							</textarea>

						</div>
						<div class="form-group">
							<label>Autor</label>
							<input type="text" name="autor" class="form-control" value="<%=request.getParameter("autor")%>">
						</div>

					</div>
					<div class="modal-footer">
						<a href="index.jsp" type="submit" class="btn btn-danger">Regresar</a>
						<button type="submit" class="btn btn-primary" name="enviar">Guardar Cambios</button>
					</div>
				</form>
			</div>
		</div>

		<%
			MensajeDao mensajeDao = new MensajeDao();

			String id = request.getParameter("id");

			if (request.getParameter("enviar") != null) {
				Mensaje mensaje = new Mensaje(
						Integer.parseInt(id.trim()),
						request.getParameter("mensaje"),
						request.getParameter("autor")
				);
				mensajeDao.editar(mensaje);
			}

		%>
    </body>
</html>
