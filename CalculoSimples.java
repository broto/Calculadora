/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraparenteses;

import javax.swing.JOptionPane;

/**
 *
 * @author CPMARRA
 */
public class CalculoSimples {

    public String avalieTwo(String equacao) {
        double resultado = 0;

        int valor1 = equacao.indexOf("-");
        int valor2 = equacao.indexOf("+");
        int valor3 = equacao.indexOf("*");
        int valor4 = equacao.indexOf("/");
        if (valor1 == -1 && valor2 == -1 && valor3 == -1 && valor4 == -1) {
            resultado = Double.parseDouble(equacao);
        } else {
            if (valor4 != -1) {
                resultado = Double.parseDouble(avalieTwo(equacao.substring(0, valor4))) / Double.parseDouble(avalieTwo(equacao.substring(valor4 + 1, equacao.length())));
            }
            if (valor3 != -1) {
                resultado = Double.parseDouble(avalieTwo(equacao.substring(0, valor3))) * Double.parseDouble(avalieTwo(equacao.substring(valor3 + 1, equacao.length())));
            }
            if (valor1 != -1) {
                resultado = Double.parseDouble(avalieTwo(equacao.substring(0, valor1))) - Double.parseDouble(avalieTwo(equacao.substring(valor1 + 1, equacao.length())));
            }
            if (valor2 != -1) {
                resultado = Double.parseDouble(avalieTwo(equacao.substring(0, valor2))) + Double.parseDouble(avalieTwo(equacao.substring(valor2 + 1, equacao.length())));
            }

        }

        return resultado + "";
    }

}
