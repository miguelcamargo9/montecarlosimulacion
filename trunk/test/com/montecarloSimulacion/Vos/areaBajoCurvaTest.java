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
   * Test of getNumeroBajoCurva method, of class areaBajoCurva.
   */
  public void testGetNumeroBajoCurva() {
    System.out.println("getNumeroBajoCurva");
    areaBajoCurva instance = new areaBajoCurva();
    ArrayList expResult = null;
    ArrayList result = instance.getNumeroBajoCurva();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setNumeroBajoCurva method, of class areaBajoCurva.
   */
  public void testSetNumeroBajoCurva() {
    System.out.println("setNumeroBajoCurva");
    ArrayList<Double> numeroBajoCurva = null;
    areaBajoCurva instance = new areaBajoCurva();
    instance.setNumeroBajoCurva(numeroBajoCurva);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
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
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
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
    String Ecuacion = "";
    Double x = null;
    areaBajoCurva instance = new areaBajoCurva();
    Double expResult = null;
    Double result = instance.resuelveEcuacion(Ecuacion, x);
    assertEquals(expResult, result);
  }

  /**
   * Test of totalArea method, of class areaBajoCurva.
   */
  public void testTotalArea() {
    System.out.println("totalArea");
    String funcion = "";
    Double Max = null;
    Double Min = null;
    areaBajoCurva instance = new areaBajoCurva();
    Double expResult = null;
    Double result = instance.totalArea(funcion, Max, Min);
    assertEquals(expResult, result);
  }
}
