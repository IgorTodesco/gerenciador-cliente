package com.igortodesco.gerenciadorcliente.utils;

import java.text.DecimalFormat;

public class FormatadorCPF {
	public static String formatarCPF(String cpfSemMascara) {
        if (cpfSemMascara == null) {
            return null;
        }
       
        cpfSemMascara = cpfSemMascara.replaceAll("[^0-9]", "");
        
        if (cpfSemMascara.length() != 11) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos.");
        }
        
        return String.format("%s.%s.%s-%s",
                cpfSemMascara.substring(0, 3),
                cpfSemMascara.substring(3, 6),
                cpfSemMascara.substring(6, 9),
                cpfSemMascara.substring(9));
    }
}
