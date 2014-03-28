/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montecarloSimulacion.servlets;

import com.montecarloSimulacion.Vos.areaBajoCurva;
import com.montecarloSimulacion.Vos.numerosAleatoriosVo;
import com.montecarloSimulacion.Vos.numerosGraficaVo;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sebastian Rojas
 */
@WebServlet(name = "aleatoriosServlet", urlPatterns = {"/aleatoriosServlet"})
public class aleatoriosServlet extends HttpServlet {

  ArrayList matrizAleatorios = new ArrayList();
  ArrayList<String> numerosGrafica = new ArrayList<String>();
  ArrayList<Double> numeroBajoCurva = new ArrayList<Double>();
  areaBajoCurva miAreaBC = new areaBajoCurva();
  Double AreaBajoCurva;

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      String labels = "";
      String data = "";
      HttpSession session = request.getSession();
      for (int i = 0; i < numerosGrafica.size(); i++) {
        List<String> posicionXY = Arrays.asList(numerosGrafica.get(i).split("\\,"));
        labels += "\"" + posicionXY.get(0) + "\",";
        data += posicionXY.get(1) + ",";

      }
      BigInteger a = new BigDecimal(AreaBajoCurva).toBigInteger();
      session.setAttribute("labels", labels.substring(0, labels.length() - 1));
      session.setAttribute("data", data.substring(0, data.length() - 1));
      session.setAttribute("matrizAleatorios", matrizAleatorios);
      session.setAttribute("AreaBajoCurva", "" + a);
      session.setAttribute("numeroBajoCurva", numeroBajoCurva);
      session.setMaxInactiveInterval(30 * 60);
      response.sendRedirect("pages/grafico.jsp");
    } finally {
      out.close();
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    Integer numeroA = Integer.parseInt(request.getParameter("numeroA"));
    Integer numeroC = Integer.parseInt(request.getParameter("numeroC"));
    Integer numeroM = Integer.parseInt(request.getParameter("numeroM"));
    String ecuacionEscrita = request.getParameter("ecuacionEscrita");
    numerosAleatoriosVo numerosVo = new numerosAleatoriosVo(numeroA, numeroC, numeroM);
    numerosVo.generarNumerosAleatorios();
    matrizAleatorios = numerosVo.getMatrizAleatorios();
    miAreaBC.divifrMatriz(matrizAleatorios);
    AreaBajoCurva = miAreaBC.totalArea(ecuacionEscrita, (double) numerosVo.getMaximo(), (double) numerosVo.getMinimo());
    numeroBajoCurva = miAreaBC.getNumeroBajoCurva();
    numerosGraficaVo graficaVo = new numerosGraficaVo();
    graficaVo.generarMatrizParaGraficar((double) numerosVo.getMaximo(), (double) numerosVo.getMinimo(), ecuacionEscrita);
    numerosGrafica = graficaVo.getNumerosGrafica();
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
