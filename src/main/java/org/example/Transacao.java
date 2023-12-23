package org.example;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private double valor;
    private String tipoTransacao;
    private LocalDateTime data;

    public Transacao(double valor, String tipoTransacao) {
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        this.data = LocalDateTime.now();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = getData().format(formatter);
        return formattedDateTime + " " + getTipoTransacao() + "  " + getValor();
    }
}
