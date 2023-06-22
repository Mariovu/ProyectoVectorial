package com.example.proyectovectorial;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
import org.nfunk.jep.Variable;




public class EcPlanoController {
    @FXML
    private TextField txtfuncion;
    @FXML
    private TextField Px;
    @FXML
    private TextField Py;
    @FXML
    private TextField Pz;
    @FXML
    private Label txtResultado;
    public void EcTangente(){
        String funcion=txtfuncion.getText();

        double xValue=Double.parseDouble(Px.getText());
        double yValue=Double.parseDouble(Py.getText());
        double zValue=Double.parseDouble(Pz.getText());

        CalcularEcTangente(funcion,xValue,yValue,zValue);
    }

    public void CalcularEcTangente(String funcion,double xValue,double yValue,double zValue) {
        DJep djep = new DJep();
        Node nodoFuncion;
        Node nodoDerivadax, nodoDerivaday;

        try {
            // Configuración de DJep
            djep.addStandardFunctions();
            djep.addStandardConstants();
            djep.addComplex();
            djep.setAllowUndeclared(true);
            djep.setAllowAssignment(true);
            djep.setImplicitMul(true);
            djep.addStandardDiffRules();

            nodoFuncion = djep.parse(funcion);
            Node diffx = djep.differentiate(nodoFuncion, "x");
            Node diffy = djep.differentiate(nodoFuncion, "y");
            nodoDerivadax = djep.simplify(diffx);
            nodoDerivaday = djep.simplify(diffy);

            // Evaluar las derivadas en el punto (xValue, yValue)
            djep.addVariable("x", xValue);
            djep.addVariable("y", yValue);

            try {
                Object dxObj = djep.evaluate(nodoDerivadax);
                Object dyObj = djep.evaluate(nodoDerivaday);

                if (dxObj != null && dyObj != null) {
                    String dx = dxObj.toString();
                    String dy = dyObj.toString();

                    // Construir la ecuación del plano tangente
                    String tangentPlaneEquation = dx + " * (x - " + xValue + ") + " + dy + " * (y - " + yValue + ") + " + zValue + " = 0";

                    // Imprimir la ecuación del plano tangente
                    txtResultado.setText("Ecuación del plano tangente: " + tangentPlaneEquation);
                } else {
                    System.err.println("Error al evaluar las derivadas parciales.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}