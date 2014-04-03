<%-- 
    Document   : grafico
    Created on : 25-mar-2014, 15:33:08
    Author     : open12
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  String labels = null;
  String data = null;
  String AreaTotal = null;
  ArrayList<Double> matrizAleatoriosX = new ArrayList<Double>();
  ArrayList<Double> matrizAleatoriosY = new ArrayList<Double>();
  ArrayList<Double> numeroBajoCurva = new ArrayList<Double>();
  labels = (String) session.getAttribute("labels");
  data = (String) session.getAttribute("data");
  AreaTotal = (String) session.getAttribute("AreaBajoCurva");
  matrizAleatoriosX = (ArrayList<Double>) session.getAttribute("matrizAleatoriosX");
  matrizAleatoriosY = (ArrayList<Double>) session.getAttribute("matrizAleatoriosY");
  numeroBajoCurva = (ArrayList<Double>) session.getAttribute("numeroBajoCurva");

%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../js/DataTables/media/css/jquery.dataTables.css" rel="stylesheet">
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/DataTables/media/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="../js/Chartjs/Chart.js"></script>
    <script type="text/javascript">
      $(document).ready(function() {
        //Get context with jQuery - using jQuery's .get() method.
        var ctx = $("#myChart").get(0).getContext("2d");
//This will get the first returned node in the jQuery collection.
        var myNewChart = new Chart(ctx);
        var data = {
          labels: [<%=labels%>],
          datasets: [
            {
              fillColor: "rgba(151,187,205,0.5)",
              strokeColor: "rgba(151,187,205,1)",
              pointColor: "rgba(151,187,205,1)",
              pointStrokeColor: "#fff",
              data: [<%=data%>]
            }
          ]
        };
        var options = {
          scaleOverlay: false
        };

        new Chart(ctx).Line(data, options);
      });


    </script>
  </head>
  <body>
    <fieldset>  
      <legend>Calculo del Area</legend>
      <strong>Area Bajo la Curva: <%= AreaTotal%></strong>
    </fieldset>
    <br>
    <br>
    <fieldset>  
      <legend>Grafica</legend>
      <canvas id="myChart" width="1200" height="500"></canvas>
    </fieldset>
    <br>
    <fieldset>
      <legend>Numeros Aleatorios X</legend>
      <%
        for (Double NumAle : matrizAleatoriosX) {
      %>
      - <%=NumAle%>
      <%
        }
      %>
    </fieldset>
    <fieldset>
      <legend>Numeros Aleatorios Y</legend>
      <%
        for (Double NumAle : matrizAleatoriosY) {
      %>
      - <%=NumAle%>
      <%
        }
      %>
    </fieldset>
    <br>
    <fieldset>
      <legend>Numeros Bajo la Curva</legend>
      <%
        for (Double NumBaj : numeroBajoCurva) {
      %>
      - <%=NumBaj%>
      <%
        }
      %>
    </fieldset>
    <br>
  </body>
</html>
