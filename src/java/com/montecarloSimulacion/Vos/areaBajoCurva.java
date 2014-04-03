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
  private ArrayList<Double> numeroBajoCurva = new ArrayList<Double>();
  private Double AreaTotal;

  public areaBajoCurva() {
  }

  public ArrayList<Double> getNumeroBajoCurva() {
    return numeroBajoCurva;
  }

  public void setNumeroBajoCurva(ArrayList<Double> numeroBajoCurva) {
    this.numeroBajoCurva = numeroBajoCurva;
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
//    int mitad = 0;
//    if (listaAleatorios.size() % 2 != 0) {
//      mitad = (int) Math.floor(listaAleatorios.size() / 2);
//      listaAleatorios.remove(listaAleatorios.size()-1);
//    }else{
//      mitad = listaAleatorios.size() / 2;
//    }
    for (int j = 0; j < listaAleatorios.size(); j++) {
        matrizAX.add(listaAleatorios.get(j));
    }
    for (int i = listaAleatorios.size()-1; i >= 0; i--) {
        matrizAY.add(listaAleatorios.get(i));
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
        Integer numeroMultiplicar = Integer.parseInt(expresion.get(0).substring(0, expresion.get(0).length()-1));
        preResultado = Math.pow(x, Double.parseDouble(expresion.get(1)));
        if(numeroMultiplicar!=null) {
          preResultado = preResultado*numeroMultiplicar;
        }
        resultado = resultado + preResultado;
      } else {
        resultado = resultado + Double.parseDouble(vEcuacion.get(j));
      }
    }
    return resultado;
  }

  public Double totalArea(String funcion, Double Max, Double Min) {
    ArrayList<Double> numerosBajoCurva = new ArrayList<Double>();
    Double x = 0.0;
    Double y = 0.0;
    int Contador = 0;
    Double sizeX = (double)this.getMatrizAleatoriosX().size();
    Double sizeY = (double)this.getMatrizAleatoriosY().size();
    for (int j = 0; j < sizeX; j++) {
      y = this.getMatrizAleatoriosY().get(j);
      x = this.resuelveEcuacion(funcion, this.getMatrizAleatoriosX().get(j));
      if(y < x){
        Contador ++;
        numerosBajoCurva.add(this.getMatrizAleatoriosX().get(j));
      }
    }
    this.setNumeroBajoCurva(numerosBajoCurva);
    Double AreaCuadrado = this.resuelveEcuacion(funcion, Max)*(Max-(Min));
    Double AreaPuntos = (double)Contador/(sizeX+sizeY);
    return (AreaPuntos*AreaCuadrado);
  }
}
