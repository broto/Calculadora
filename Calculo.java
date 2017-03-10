/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraparenteses;

import java.util.Scanner;

/**
 *
 * @author CPMARRA
 */
public class Calculo {

    public static double calcExp(String exp) {
        if (exp.contains("(")) {
            String exp_aux = exp.substring(0, exp.indexOf("("));
            exp_aux += String.valueOf(calcExp(exp.substring(exp.indexOf("(") + 1, exp.lastIndexOf(")"))));
            if ((exp_aux.contains("+")) || (exp_aux.contains("-")) || (exp_aux.contains("*")) || (exp_aux.contains("/"))) {
                return calcula(exp_aux);
            } else {
                return Double.parseDouble(exp_aux);
            }
        } else {
            return calcula(exp);
        }
    }

    public static double calcula(String result) {
        String y = "";
        char[] operadores = {'+', '-', '/', '*'};
        char operadorSelecionado = 0;
        String x = result;
        //y = "";
        for (int i = 0; i < operadores.length; i++) {
            if (x.indexOf(operadores[i]) != -1) {
                operadorSelecionado = operadores[i];
                break;
            }
        }
        String parte1 = x.substring(0, x.indexOf(operadorSelecionado));
        String parte2 = x.substring(x.indexOf(operadorSelecionado) + 1);
        switch (operadorSelecionado) {
            case '+':
                y = String.valueOf(
                        Double.parseDouble(parte1)
                        + Double.parseDouble(parte2));
                break;
            case '-':
                y = String.valueOf(
                        Double.parseDouble(parte1)
                        - Double.parseDouble(parte2));
                break;
            case '/':
                y = String.valueOf(
                        Double.parseDouble(parte1)
                        / Double.parseDouble(parte2));
                break;
            case '*':
                y = String.valueOf(
                        Double.parseDouble(parte1)
                        * Double.parseDouble(parte2));
                break;
            default:
                System.out.println("Operador desconhecido");
                break;
        }
        return Double.parseDouble(y);
    }

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe uma expressão: ");
        String exp = sc.next();
        System.out.println("O resultado é: " + calcExp(exp));
    }
}
