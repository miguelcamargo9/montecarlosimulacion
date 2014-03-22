/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montecarloSimulacion.Vos;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Rojas
 */
public class numerosAleatoriosVo {

  ArrayList matrizAleatorios = new ArrayList();
  Integer numeroA;
  Integer numeroC;
  Integer numeroM;

  public numerosAleatoriosVo(Integer numeroA, Integer numeroC, Integer numeroM) {
    this.numeroA = numeroA;
    this.numeroC = numeroC;
    this.numeroM = numeroM;
  }

  public void generarNumerosAleatorios() {
    double Xn=0;
    boolean bandera = true;
    double XnMasUno;
    double aleatorio;
    for (int i = 0; i < 100; i++) {
      if(bandera){
       Xn = 1; 
      } 
      XnMasUno = (numeroA*Xn+numeroC)%numeroM;
      aleatorio = XnMasUno/numeroM;
      this.matrizAleatorios.add(aleatorio);
      Xn = XnMasUno;
      bandera=false;
    }
    for (int i = 0; i < this.matrizAleatorios.size(); i++) {
      System.out.println("numero"+i+": "+this.matrizAleatorios.get(i));
    }
  }

}
