package org.example;

import java.util.List;

public interface Correntista {
    public String getNumeroDocumentoIdentificacao();
    public String getNomeIdenticacao();
    public List<Conta> getContas();
    public void addConta(Conta conta);
    public String getTelefone();
    public String getEndereco();
}
