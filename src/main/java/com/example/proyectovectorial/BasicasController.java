package com.example.proyectovectorial;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Vector;


public class BasicasController {
    @FXML
    private TextField vector1x;
    @FXML
    private TextField vector1y;
    @FXML
    private TextField vector1z;
    @FXML
    private TextField vector2x;
    @FXML
    private TextField vector2y;
    @FXML
    private TextField vector2z;
    @FXML
    private TextField vector3x;
    @FXML
    private TextField vector3y;
    @FXML
    private TextField vector3z;
    @FXML
    private Label vectorResultado;

    public Vector<Double> obtenerVectorA() {
        double x = Double.parseDouble(vector1x.getText());
        double y = Double.parseDouble(vector1y.getText());
        double z = Double.parseDouble(vector1z.getText());

        Vector<Double> vectorA = new Vector<>(3);
        vectorA.add(x);
        vectorA.add(y);
        vectorA.add(z);

        return vectorA;
    }

    public Vector<Double> obtenerVectorB() {
        double x = Double.parseDouble(vector2x.getText());
        double y = Double.parseDouble(vector2y.getText());
        double z = Double.parseDouble(vector2z.getText());

        Vector<Double> vectorB = new Vector<>(3);
        vectorB.add(x);
        vectorB.add(y);
        vectorB.add(z);

        return vectorB;
    }
    public Vector<Double> obtenerVectorC() {
        double x = Double.parseDouble(vector3x.getText());
        double y = Double.parseDouble(vector3y.getText());
        double z = Double.parseDouble(vector3z.getText());

        Vector<Double> vectorB = new Vector<>(3);
        vectorB.add(x);
        vectorB.add(y);
        vectorB.add(z);

        return vectorB;
    }
    public Vector<Double> calcularProductoCruz(Vector<Double> vectorA, Vector<Double> vectorB) {
        double x1 = vectorA.get(0);
        double y1 = vectorA.get(1);
        double z1 = vectorA.get(2);

        double x2 = vectorB.get(0);
        double y2 = vectorB.get(1);
        double z2 = vectorB.get(2);

        double resultX = y1 * z2 - z1 * y2;
        double resultY = z1 * x2 - x1 * z2;
        double resultZ = x1 * y2 - y1 * x2;

        Vector<Double> productoCruz = new Vector<>(3);
        productoCruz.add(resultX);
        productoCruz.add(resultY);
        productoCruz.add(resultZ);

        return productoCruz;
    }

    public void ProductoCruz() {
        Vector<Double> vectorA = obtenerVectorA();
        Vector<Double> vectorB = obtenerVectorB();

        Vector<Double> productoCruz = calcularProductoCruz(vectorA, vectorB);
        String resultado = "AXB=(" + productoCruz.get(0) + ", " + productoCruz.get(1) + ", " + productoCruz.get(2) + ")";
        vectorResultado.setText(resultado);
    }

    public void ProductoPunto(){
        Vector<Double> vectorA = obtenerVectorA();
        Vector<Double> vectorB = obtenerVectorB();
        double productoPunto = calcularProductoPunto(vectorA, vectorB);
        String resultado = "A*B = " + productoPunto;
        vectorResultado.setText(resultado);
    }

    public double calcularProductoPunto(Vector<Double> vectorA, Vector<Double> vectorB) {
        if (vectorA.size() != vectorB.size()) {
            throw new IllegalArgumentException("Los vectores deben tener la misma longitud");
        }

        double productoPunto = 0.0;
        for (int i = 0; i < vectorA.size(); i++) {
            productoPunto += vectorA.get(i) * vectorB.get(i);
        }

        return productoPunto;
    }
    public void ProductoTripleEscalar(){
        Vector<Double> vectorA = obtenerVectorA();
        Vector<Double> vectorB = obtenerVectorB();
        Vector<Double> vectorC = obtenerVectorC();
        double productoTripleEscalar=CalcularProductoTripleEscalar(vectorA,vectorB,vectorC);
        String resultado= "A*(BXC) = "+productoTripleEscalar;
        vectorResultado.setText(resultado);
    }

    public double CalcularProductoTripleEscalar(Vector<Double> vectorA, Vector<Double> vectorB,Vector<Double> vectorC){
        Vector<Double> productoCruz = calcularProductoCruz(vectorB, vectorC);
        double productoTripleEscalar = calcularProductoPunto(vectorA, productoCruz);
        return productoTripleEscalar;
    }


}