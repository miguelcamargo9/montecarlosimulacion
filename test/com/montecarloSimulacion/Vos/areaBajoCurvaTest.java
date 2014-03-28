/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montecarloSimulacion.Vos;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author miguelcamargo9
 */
public class areaBajoCurvaTest extends TestCase {
  
  public areaBajoCurvaTest(String testName) {
    super(testName);
  }

  /**
   * Test of getMatrizAleatoriosX method, of class areaBajoCurva.
   */
  public void testGetMatrizAleatoriosX() {
    System.out.println("getMatrizAleatoriosX");
    areaBajoCurva instance = new areaBajoCurva();
    ArrayList expResult = null;
    ArrayList result = instance.getMatrizAleatoriosX();
    assertEquals(expResult, result);
  }

  /**
   * Test of setMatrizAleatoriosX method, of class areaBajoCurva.
   */
  public void testSetMatrizAleatoriosX() {
    System.out.println("setMatrizAleatoriosX");
    ArrayList<Double> matrizAleatoriosX = null;
    areaBajoCurva instance = new areaBajoCurva();
    instance.setMatrizAleatoriosX(matrizAleatoriosX);
  }

  /**
   * Test of getMatrizAleatoriosY method, of class areaBajoCurva.
   */
  public void testGetMatrizAleatoriosY() {
    System.out.println("getMatrizAleatoriosY");
    areaBajoCurva instance = new areaBajoCurva();
    ArrayList expResult = null;
    ArrayList result = instance.getMatrizAleatoriosY();
    assertEquals(expResult, result);
  }

  /**
   * Test of setMatrizAleatoriosY method, of class areaBajoCurva.
   */
  public void testSetMatrizAleatoriosY() {
    System.out.println("setMatrizAleatoriosY");
    ArrayList<Double> matrizAleatoriosY = null;
    areaBajoCurva instance = new areaBajoCurva();
    instance.setMatrizAleatoriosY(matrizAleatoriosY);
  }

  /**
   * Test of getAreaTotal method, of class areaBajoCurva.
   */
  public void testGetAreaTotal() {
    System.out.println("getAreaTotal");
    areaBajoCurva instance = new areaBajoCurva();
    Double expResult = null;
    Double result = instance.getAreaTotal();
    assertEquals(expResult, result);
  }

  /**
   * Test of setAreaTotal method, of class areaBajoCurva.
   */
  public void testSetAreaTotal() {
    System.out.println("setAreaTotal");
    areaBajoCurva instance = new areaBajoCurva();
    instance.setAreaTotal();

  }

  /**
   * Test of divifrMatriz method, of class areaBajoCurva.
   */
  public void testDivifrMatriz() {
    System.out.println("divifrMatriz");
    ArrayList<Double> listaAleatorios = null;
    areaBajoCurva instance = new areaBajoCurva();
    instance.divifrMatriz(listaAleatorios);
  }

  /**
   * Test of resuelveEcuacion method, of class areaBajoCurva.
   */
  public void testResuelveEcuacion() {
    System.out.println("resuelveEcuacion");
    String Ecuacion = "x^3+x^1";
    Double x = 3.0;
    areaBajoCurva instance = new areaBajoCurva();
    Double expResult = 30.0;
    Double result = instance.resuelveEcuacion(Ecuacion, x);
    assertEquals(expResult, result);
  }

  /**
   * Test of totalArea method, of class areaBajoCurva.
   */
  public void testTotalArea() {
    System.out.println("totalArea");
    ArrayList<Integer> funcion = null;
    areaBajoCurva instance = new areaBajoCurva();
    Double expResult = null;
    Double result = instance.totalArea(funcion);
    assertEquals(expResult, result);
  }
}
