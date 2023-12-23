package org.example;

import java.util.ArrayList;
import java.util.List;

public class ContaSimples implements Conta {
    private int numero;
    private Correntista correntista;
    private boolean especial = false;
    private List<Transacao> transacoes;
    private double saldo;
    private double credito;

    public ContaSimples(int numero, Correntista correntista) {
        this.numero = numero;
        this.correntista = correntista;
        this.transacoes = new ArrayList<>();
        this.saldo = 0;
        this.credito = 0;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void addCredito(double credito) {
        this.credito += credito;
    }

    @Override
    public double getCredito() {
        return credito;
    }

    @Override
    public void setCredito(double credito) {
        this.credito = credito;
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

    @Override
    public boolean isEspecial() {
        return especial;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }
    @Override
    public void addTransacao(Transacao transacao) {
        this.transacoes.add(transacao);
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
