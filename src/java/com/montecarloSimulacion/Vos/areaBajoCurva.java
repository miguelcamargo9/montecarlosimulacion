/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montecarloSimulacion.Vos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author miguelcamargo9
 */
public class areaBajoCurva {

  private ArrayList<Double> matrizAleatoriosX = new ArrayList<Double>();
  private ArrayList<Double> matrizAleatoriosY = new ArrayList<Double>();
  private Double AreaTotal;

  public areaBajoCurva() {
  }

  public ArrayList<Double> getMatrizAleatoriosX() {
    return matrizAleatoriosX;
  }

  public void setMatrizAleatoriosX(ArrayList<Double> matrizAleatoriosX) {
    this.matrizAleatoriosX = matrizAleatoriosX;
  }

  public ArrayList<Double> getMatrizAleatoriosY() {
    return matrizAleatoriosY;
  }

  public void setMatrizAleatoriosY(ArrayList<Double> matrizAleatoriosY) {
    this.matrizAleatoriosY = matrizAleatoriosY;
  }

  public Double getAreaTotal() {
    return AreaTotal;
  }

  public void setAreaTotal() {
    this.AreaTotal = AreaTotal;
  }

  public void divifrMatriz(ArrayList<Double> listaAleatorios) {
    ArrayList<Double> matrizAX = new ArrayList<Double>();
    ArrayList<Double> matrizAY = new ArrayList<Double>();
    int mitad = 0;
    if (listaAleatorios.size() % 2 != 0) {
      mitad = (int) Math.floor(listaAleatorios.size() / 2);
    }
    for (int j = 0; j < listaAleatorios.size(); j++) {
      if (j < mitad) {
        matrizAX.add(listaAleatorios.get(j));
      } else {
        matrizAY.add(listaAleatorios.get(j));
      }
    }
    this.setMatrizAleatoriosX(matrizAX);
    this.setMatrizAleatoriosY(matrizAY);
  }

  public Double resuelveEcuacion(String Ecuacion, Double x) {
    Double preResultado = 0.0;
    Double resultado = 0.0;
    List<String> vEcuacion = Arrays.asList(Ecuacion.split("\\+"));
    for (int j = 0; j < vEcuacion.size(); j++) {
      if (vEcuacion.get(j).indexOf("^") != -1) {
        List<String> expresion = Arrays.asList(vEcuacion.get(j).split("\\^"));
        preResultado = Math.pow(x, Double.parseDouble(expresion.get(1)));
        resultado = resultado + preResultado;
      } else {
        resultado = resultado + Double.parseDouble(vEcuacion.get(j));
      }
    }
    return resultado;
  }

  public Double totalArea(String funcion, Double Max, Double Min) {
    Double x = 0.0;
    Double y = 0.0;
    int Contador = 0;
    for (int j = 0; j < this.getMatrizAleatoriosX().size(); j++) {
      y = this.getMatrizAleatoriosY().get(j);
      x = this.resuelveEcuacion(funcion, this.getMatrizAleatoriosX().get(j));
      if(y > x)
      Contador ++;
    }
    Double AreaCuadrado = this.resuelveEcuacion(funcion, Max)*Max-Min;
    return (double) (Contador/this.getMatrizAleatoriosX().size())*AreaCuadrado;
  }
}
