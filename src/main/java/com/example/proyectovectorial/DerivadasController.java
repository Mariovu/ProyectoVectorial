package com.example.proyectovectorial;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

public class DerivadasController {
    @FXML
    private TextField funcionx;
    @FXML
    private TextField funciony;
    @FXML
    private TextField funcionz;
    @FXML
    private Label matrizJacobianaLabel;
    public void Derivada(){
        String fx= funcionx.getText();
        String fy=funciony.getText();
        String fz=funcionz.getText();

        String[][] matrizJacobiana=CalcularDerivadasParciales(fx,fy,fz);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrizJacobiana.length; i++) {
            for (int j = 0; j < matrizJacobiana[i].length; j++) {
                sb.append(matrizJacobiana[i][j]).append("\t\t\t");
            }
            sb.append("\n");
        }

        // Establecer la cadena de texto en el Label
        matrizJacobianaLabel.setText(sb.toString());

    }
    public String[][] CalcularDerivadasParciales(String fx,String fy,String fz) {
        DJep djep = new DJep();
        Node nodoFx,nodoFy,nodoFz;
        String[][] derivadasParciales = new String[3][3]; // Vector para almacenar las derivadas parciales de x, y, z

        try {
            // Configuración de DJep
            djep.addStandardFunctions();
            djep.addStandardConstants();
            djep.addComplex();
            djep.setAllowUndeclared(true);
            djep.setAllowAssignment(true);
            djep.setImplicitMul(true);
            djep.addStandardDiffRules();

            // Parsear la función
            nodoFx = djep.parse(fx);
            nodoFy = djep.parse(fy);
            nodoFz = djep.parse(fz);

            // Calcular las derivadas parciales de x, y, z
            Node derivadafxX = djep.differentiate(nodoFx, "x");
            Node derivadafxY = djep.differentiate(nodoFx, "y");
            Node derivadafxZ = djep.differentiate(nodoFx, "z");

            Node derivadafyX = djep.differentiate(nodoFy, "x");
            Node derivadafyY = djep.differentiate(nodoFy, "y");
            Node derivadafyZ = djep.differentiate(nodoFy, "z");

            Node derivadafzX = djep.differentiate(nodoFz, "x");
            Node derivadafzY = djep.differentiate(nodoFz, "y");
            Node derivadafzZ = djep.differentiate(nodoFz, "z");

            // Simplificar las derivadas parciales
            Node nodoDerivadafxX = djep.simplify(derivadafxX);
            Node nodoDerivadafxY = djep.simplify(derivadafxY);
            Node nodoDerivadafxZ = djep.simplify(derivadafxZ);

            Node nodoDerivadafyX = djep.simplify(derivadafyX);
            Node nodoDerivadafyY = djep.simplify(derivadafyY);
            Node nodoDerivadafyZ = djep.simplify(derivadafyZ);

            Node nodoDerivadafzX = djep.simplify(derivadafzX);
            Node nodoDerivadafzY = djep.simplify(derivadafzY);
            Node nodoDerivadafzZ = djep.simplify(derivadafzZ);

            // Obtener las representaciones en cadena de las derivadas parciales
            derivadasParciales[0][0] = djep.toString(nodoDerivadafxX);
            derivadasParciales[1][0] = djep.toString(nodoDerivadafxY);
            derivadasParciales[2][0] = djep.toString(nodoDerivadafxZ);

            derivadasParciales[0][1] = djep.toString(nodoDerivadafyX);
            derivadasParciales[1][1] = djep.toString(nodoDerivadafyY);
            derivadasParciales[2][1] = djep.toString(nodoDerivadafyZ);

            derivadasParciales[0][2] = djep.toString(nodoDerivadafzX);
            derivadasParciales[1][2] = djep.toString(nodoDerivadafzY);
            derivadasParciales[2][2] = djep.toString(nodoDerivadafzZ);

        } catch (ParseException e) {
            System.out.println("Error: " + e.getErrorInfo());
        }

        return derivadasParciales;
    }





}
