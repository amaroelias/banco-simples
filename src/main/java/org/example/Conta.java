package org.example;

import java.util.List;

public interface Conta {

    public int getNumero();
    public void setNumero(int numero);
    public Correntista getCorrentista();
    public void setCorrentista(Correntista correntista);
    public boolean isEspecial();
    public double getSaldo();
    public void setSaldo(double saldo);
    public void addCredito(double credito);
    public double getCredito();
    public void setCredito(double credito);
    public List<Transacao> getTransacoes();
    public void addTransacao(Transacao transacao);
}
