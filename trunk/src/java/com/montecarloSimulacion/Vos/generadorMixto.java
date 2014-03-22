/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montecarloSimulacion.Vos;

/**
 *
 * @author Miguel
 */
public class generadorMixto {
  
  private Double[] MisNumeros;
  private Double numeroA;
  private Double numeroC;
  private Double numeroM;
  private int Size;
  public generadorMixto(Double numeroA, Double numeroC, Double numeroM) {
    this.Size =  (int) Math.floor(numeroM);
    this.MisNumeros = new Double[Size];
    this.MisNumeros[0] = 1.0;
    this.numeroA = numeroA;
    this.numeroC = numeroC;
    this.numeroM = numeroM;
  }

  public Double[] getMisNumeros() {
    return MisNumeros;
  }

  public void setMisNumeros() {
    for(int i =0; i < this.Size; i++){
      Double Xn = this.MisNumeros[i];
      Xn = (numeroA*Xn+numeroC)%numeroM;
      this.MisNumeros[i+1] = Xn;
    }
  }

  public Double getNumeroA() {
    return numeroA;
  }

  public void setNumeroA(Double numeroA) {
    this.numeroA = numeroA;
  }

  public Double getNumeroC() {
    return numeroC;
  }

  public void setNumeroC(Double numeroC) {
    this.numeroC = numeroC;
  }

  public Double getNumeroM() {
    return numeroM;
  }

  public void setNumeroM(Double numeroM) {
    this.numeroM = numeroM;
  }
  
  
  
  
  
  
}
