package com.igortodesco.gerenciadorcliente.utils;

public class FormatadorTelefone {
	public static String formatarTelefone(String numeroSemMascara) {
        if (numeroSemMascara == null) {
            return null;
        }

        // Remova qualquer caractere não numérico do número de telefone
        numeroSemMascara = numeroSemMascara.replaceAll("[^0-9]", "");

        // Adicione a máscara, por exemplo: (##) #####-####
        if (numeroSemMascara.length() == 10) {
            return String.format("(%s) %s-%s",
                    numeroSemMascara.substring(0, 2),
                    numeroSemMascara.substring(2, 6),
                    numeroSemMascara.substring(6));
        } else if (numeroSemMascara.length() == 11) {
            return String.format("(%s) %s-%s",
                    numeroSemMascara.substring(0, 2),
                    numeroSemMascara.substring(2, 7),
                    numeroSemMascara.substring(7));
        } else {
            throw new IllegalArgumentException("Número de telefone inválido. Deve conter 10 ou 11 dígitos.");
        }
    }
}
