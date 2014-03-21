<%-- 
    Document   : index
    Created on : 4/03/2014, 12:23:09 AM
    Author     : Sebastian Rojas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  String mensaje = "";
  mensaje = (String) session.getAttribute("mensaje");
  mensaje = mensaje == null ? "": mensaje;
  String error = "";
  error = (String) session.getAttribute("error");
  error = error == null ? "": error;
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="librerias/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="librerias/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
    <title>Monte Carlo</title>
  </head>
  <body>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Monte Carlo</a>
        </div>
        <div class="navbar-collapse collapse">          
          <form action="generadorServlet" method="post" class="navbar-form navbar-right" role="form">
            <div class="form-group">
              <input type="text" name="numeroA" placeholder="Numero A" class="form-control" required>
            </div>
            <div class="form-group">
              <input type="text" name="numeroC" placeholder="Numero C" class="form-control" required>
            </div>
            <div class="form-group">
              <input type="text" name="numeroM" placeholder="Numero M" class="form-control" required>
            </div>
            <input type="submit" class="btn btn-success" value="Ingresar">
          </form>

        </div><!--/.navbar-collapse -->
      </div>
    </div>
    <div class="jumbotron">
      <div class="container">
        <h1>Metodo Monte Carlo</h1>
        <p>Generador Congruencial Mixto</p>
      </div>
      <% if(!mensaje.equals("")){
      %>
      <div class="alert alert-success">
        <strong>
          <%=mensaje%>
        </strong>
      </div>
      <%
      }
        if (!error.equals("")) {
      %>
      <div class="alert alert-danger">
        <strong>
          <%=error%>
        </strong>
      </div>
      <%
      }
      session.removeAttribute("error");
      session.removeAttribute("mensaje");
      %>
    </div>
  </body>
</html>