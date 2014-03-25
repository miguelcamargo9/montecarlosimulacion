/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montecarloSimulacion.Vos;

import java.util.ArrayList;

/**
 *
 * @author Sebastian Rojas
 */
public class numerosAleatoriosVo {

  ArrayList<Double> matrizAleatorios = new ArrayList<Double>();
  ArrayList<Double> preMatrizAleatorios = new ArrayList<Double>();
  Integer numeroA;
  Integer numeroC;
  Integer numeroM;
  Integer maximo;
  Integer minimo;

  public numerosAleatoriosVo(Integer numeroA, Integer numeroC, Integer numeroM) {
    this.numeroA = numeroA;
    this.numeroC = numeroC;
    this.numeroM = numeroM;
    this.minimo = numeroM;
    this.maximo = 0;
  }

  public void generarNumerosAleatorios() {
    double Xn = 0;
    double semilla = 1.0;
    boolean bandera = true;
    double XnMasUno;
    double aleatorio;
    double preAleatorio;
    for (int i = 0; i < numeroM; i++) {
      if (bandera) {
        Xn = semilla;
      }
      XnMasUno = (numeroA * Xn + numeroC) % numeroM;
      preAleatorio = XnMasUno;
      this.preMatrizAleatorios.add(preAleatorio);
      Xn = XnMasUno;
      bandera = false;
    }
    for (int i = 0; i < preMatrizAleatorios.size(); i++) {
      if (preMatrizAleatorios.get(i) == semilla) {
        maximo = minimo + i + 1;
        break;
      }
    }

    for (int i = 0; i < preMatrizAleatorios.size(); i++) {
      preAleatorio = preMatrizAleatorios.get(i) / numeroM;
      aleatorio = preAleatorio * (maximo - minimo + 1) + minimo;
      this.matrizAleatorios.add(aleatorio);
    }
  }

  public ArrayList getMatrizAleatorios() {
    return matrizAleatorios;
  }

}
