<%-- 
    Document   : index
    Created on : 4/03/2014, 12:23:09 AM
    Author     : Sebastian Rojas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="js/DataTables/media/css/jquery.dataTables.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/DataTables/media/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript">
      $(document).ready(function() {
        $('#ecuacion').dataTable({
          "aoColumns": [
            {"sTitle": "Variable"},
            {"sTitle": "Valor"}
          ]
        });
        $('#factores').hide();
      });

      function f_generarTablaFactores() {
        var grado = $("#gradoEcuacion").val();
        var oTabla = $('#ecuacion').dataTable();
        var mDatos = new Array();
        oTabla.fnClearTable();
        for (var i = 0; i < grado; i++) {
          var datos = new Array();
          var valor = i != 0 ? "x^" + i : "constante";
          datos.push(valor);
          datos.push("<input type=\"text\" name=\"constante" + i + "\" placeholder=\"" + valor + "\" class=\"form-control\" required>");
          oTabla.fnAddData(datos);
        }
        $('#factores').show();
      }

      function f_generarEcuacion() {
        var oTabla = $('#ecuacion').dataTable();
        var cDatos = $('input', oTabla.fnGetNodes()).serialize();
        var mDatos = cDatos.split("&");
        var ecuacion = "";
        for (var i = mDatos.length - 1; i >= 0; i--) {
          var vExpresion = mDatos[i].split("=");
          var valor = i !== 0 ? "x^" + i : "";
          ecuacion += vExpresion[1] + valor + "+";
        }
        $("#ecuacionEscrita").val(ecuacion.substr(0, ecuacion.length - 1));
      }

    </script>
    <title>Monte Carlo</title>
  </head>
  <body>
    <form class="form-horizontal" action="aleatoriosServlet" method="post">  
      <fieldset>  
        <legend>Generador de Numeros Aleatorios</legend>
        <table class="table table-hover">
          <tr>
            <td><input type="text" name="numeroA" placeholder="Numero A" class="form-control" required></td>
          </tr>
          <tr>
            <td><input type="text" name="numeroC" placeholder="Numero C" class="form-control" required></td>
          </tr>
          <tr>
            <td><input type="text" name="numeroM" placeholder="Numero M" class="form-control" required></td>
          </tr>
          <tr>
            <td>
              <input type="text" id="gradoEcuacion" placeholder="grado Ecuacion" class="form-control" required>
            </td>
            <td>
              <button type="button" class="btn btn-default" onclick="f_generarTablaFactores();">
                <span class="glyphicon glyphicon-plus"></span> Generar
              </button>
            </td>
          </tr>
        </table>
        <div id="factores">
          <table id="ecuacion">
          </table>
          <br>
          <textarea name="ecuacionEscrita" id="ecuacionEscrita">
            
          </textarea>
          <button type="button" class="btn btn-default" onclick="f_generarEcuacion();">
            <span class="glyphicon glyphicon-send"></span> Generar Ecuacion
          </button>
        </div>
        <br>
        <input type="submit" value="enviar" class="btn btn-primary">
      </fieldset>
      <strong>Presentado Por:Miguel Camargo y Sebastian Rojas</strong>
    </form>
  </body>
</html>