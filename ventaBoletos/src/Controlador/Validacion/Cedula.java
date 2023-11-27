/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Validacion;

/**
 *
 * @author Usuario
 */
public class Cedula {
    //validar cedula
    public static boolean validadorDeCedula(String cedula) {
        if (cedula.length() != 10) {
            return false;
        }

        for (int i = 0; i < cedula.length(); i++) {
            if (!Character.isDigit(cedula.charAt(i))) {
                return false;
            }
        }

        int suma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cedula.charAt(i));
            if (i % 2 == 0) {
                digito *= 2;
                if (digito > 9) {
                    digito -= 9;
                }
            }
            suma += digito;
        }

        int modulo = suma % 10;
        int digitoVerificador = (modulo == 0) ? 0 : 10 - modulo;

        return digitoVerificador == Character.getNumericValue(cedula.charAt(9));
    }
    
    
}
