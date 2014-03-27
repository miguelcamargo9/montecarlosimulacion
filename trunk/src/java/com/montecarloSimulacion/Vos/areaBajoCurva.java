/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montecarloSimulacion.Vos;

import java.util.ArrayList;

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
  
  public void divifrMatriz(ArrayList<Double> listaAleatorios){
    ArrayList<Double> matrizAX = new ArrayList<Double>();
    ArrayList<Double> matrizAY = new ArrayList<Double>();
    int mitad = 0;
    if(listaAleatorios.size() % 2 != 0){
      mitad = (int) Math.floor(listaAleatorios.size()/2);  
    }
    for(int j = 0; j < listaAleatorios.size(); j++){
      if(j < mitad){
        matrizAX.add(listaAleatorios.get(j));
      }else{
        matrizAY.add(listaAleatorios.get(j));
      }
    }
    this.setMatrizAleatoriosX(matrizAX);
    this.setMatrizAleatoriosY(matrizAY);
  }
  
  public Double totalArea(ArrayList<Integer> funcion){
    Double x = 0.0;
    Double y;
    for(int j = 0; j < this.getMatrizAleatoriosX().size(); j++){
      y = this.getMatrizAleatoriosY().get(j);
      for(int i = 0; i < funcion.size(); i++){
        
      }
    }
    return x;
  }
  
  
  
  
  
}
