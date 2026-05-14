package org.serratec.aula03.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.serratec.aula03.exception.EnumValidationException;

public enum TipoCliente {
    
    PESSOA_FISICA("PF"), 
    PESSOA_JURIDICA("PJ");

    private String valor;

    private TipoCliente(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @JsonCreator
    public static TipoCliente paraEnum(String valor) throws EnumValidationException {
        for (TipoCliente tipo : TipoCliente.values()) {
            
            if (tipo.name().equalsIgnoreCase(valor) || tipo.getValor().equalsIgnoreCase(valor)) {
                return tipo;
            }
        }
       
        throw new EnumValidationException("O tipo de cliente '" + valor + "' é inválido. Escolha PF ou PJ.");
    }
}