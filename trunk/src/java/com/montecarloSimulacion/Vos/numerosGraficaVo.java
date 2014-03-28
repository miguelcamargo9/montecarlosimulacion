/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montecarloSimulacion.Vos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author open12
 */
public class numerosGraficaVo {

  ArrayList<String> numerosGrafica = new ArrayList<String>();

  public numerosGraficaVo() {
  }

  public void generarMatrizParaGraficar(Double maximo, Double minimo, String ecuacion) {
    Double resta = maximo - minimo;
    Double rango = resta / 50;
    Double preResultado;
    Double resultado = 0.0;
    Double posicionX = 0.0;
    boolean bandera = true;
    List<String> vEcuacion = Arrays.asList(ecuacion.split("\\+"));
    for (int i = 0; i <= 50; i++) {
      if (bandera) {
        posicionX = minimo;
      } else {
        posicionX = posicionX + rango;
      }
      for (int j = 0; j < vEcuacion.size(); j++) {
        if (vEcuacion.get(j).indexOf("^") != -1) {
          List<String> expresion = Arrays.asList(vEcuacion.get(j).split("\\^"));
          preResultado = Math.pow(posicionX, Double.parseDouble(expresion.get(1)));
          resultado = resultado + (Math.round(preResultado * 100) / 100);
        } else {
          resultado = resultado + Double.parseDouble(vEcuacion.get(j));
        }
      }
      posicionX = Math.round(posicionX * 100) / 100.00;
      numerosGrafica.add(posicionX + "," + resultado);
      preResultado = 0.0;
      resultado = 0.0;
      bandera = false;
    }
  }

  public ArrayList<String> getNumerosGrafica() {
    return numerosGrafica;
  }
}
