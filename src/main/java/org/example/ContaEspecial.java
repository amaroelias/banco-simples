package org.example;

import java.util.ArrayList;
import java.util.List;

public class ContaEspecial implements Conta {
    private int numero;
    private Correntista correntista;
    private boolean especial = true;
    private double credito;
    private List<Transacao> transacoes;
    private double saldo;

    public ContaEspecial(int numero, Correntista correntista) {
        this.numero = numero;
        this.correntista = correntista;
        this.transacoes = new ArrayList<>();
    }

    @Override
    public int getNumero() {
        return this.numero;
    }

    @Override
    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public Correntista getCorrentista() {
        return this.correntista;
    }

    @Override
    public void setCorrentista(Correntista correntista) {
        this.correntista = correntista;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    @Override
    public boolean isEspecial() {
        return this.especial;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void addCredito(double credito) {
        this.credito += credito;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    @Override
    public void addTransacao(Transacao transacao) {
        this.transacoes.add(transacao);
    }
}
