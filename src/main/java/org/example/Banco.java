package org.example;

import java.util.HashMap;
import java.util.Map;

public class Banco {
    private String nome;
    private  int numeroAgencia;
    private Map<String, Correntista> correntistas;
    private Map<Integer, Conta> contas;

    public Banco(String nome, int numeroAgencia) {
        this.nome = nome;
        this.numeroAgencia = numeroAgencia;
        this.contas = new HashMap<>();
        this.correntistas = new HashMap<>();
    }

    public void adicionarCorrentista(Correntista correntista){
        if(correntista == null) throw new RuntimeException("Correntista não pode ser null!");
        this.correntistas.put(correntista.getNumeroDocumentoIdentificacao(), correntista);
    }
    public void criarConta(String numeroDocumentoCorrentista, String tipoConta){
        if(numeroDocumentoCorrentista == null) throw new RuntimeException("Numero de Identificação não pode ser null!");
        if(tipoConta == null) throw new RuntimeException("Tipo da conta não pode ser null!");
        if(tipoConta.toLowerCase() != "conta especial" && tipoConta.toLowerCase() != "conta simples") throw new RuntimeException("Tipo de conta não disponivel!");
        if(getCorrentista(numeroDocumentoCorrentista) == null) throw new RuntimeException("Correntista não encontrado!");
        if(tipoConta.toLowerCase() == "conta especial"){
            Conta conta = new ContaEspecial(contas.size(), getCorrentista(numeroDocumentoCorrentista));
            adicionarConta(conta);
            getCorrentista(numeroDocumentoCorrentista).addConta(conta);
        }else {
            Conta conta = new ContaSimples(contas.size(), correntistas.get(numeroDocumentoCorrentista));
            adicionarConta(conta);
            getCorrentista(numeroDocumentoCorrentista).addConta(conta);
        }
    }
    public void adicionarCredito(int numeroConta, double valorCredito){
        if(getConta(numeroConta) == null) throw new RuntimeException("Conta não encontrada!");
        if(valorCredito <= 0) throw new RuntimeException("Credito não pode ser que 1!");
        if(getConta(numeroConta).isEspecial()){
            getConta(numeroConta).addCredito(valorCredito);
            Transacao transacao = new Transacao(valorCredito, "CREDITO   (R$)");
            getConta(numeroConta).addTransacao(transacao);
        }

    }
    public void depositar(int numeroConta, double valorCredito){
        if(getConta(numeroConta) == null) throw new RuntimeException("Conta não encontrada!");
        if(valorCredito <= 0) throw new RuntimeException("Credito não pode ser menor que 1!");
        double saldo = getConta(numeroConta).getSaldo();
        getConta(numeroConta).setSaldo(saldo+valorCredito);
        Transacao transacao = new Transacao(valorCredito, "DEPOSITO  +R$");
        getConta(numeroConta).addTransacao(transacao);
    }
    public void sacar(int numeroConta, double valorCredito){
        if(getConta(numeroConta) == null) throw new RuntimeException("Conta não encontrada!");
        if(valorCredito <= 0) throw new RuntimeException("Credito não pode ser menor que 1!");
        double saldo = getConta(numeroConta).getSaldo();
        if(getConta(numeroConta).getSaldo() < valorCredito && getConta(numeroConta).isEspecial()){
            if(this.contas.get(numeroConta).getSaldo() + this.contas.get(numeroConta).getCredito() > valorCredito){
                saldo += valorCredito;
                getConta(numeroConta).setSaldo(saldo);
                getConta(numeroConta).setCredito(getConta(numeroConta).getCredito()+saldo);
            }
            else{
                throw new RuntimeException("Valor maior que o saldo!");
            }
        }
        if(getConta(numeroConta).getSaldo() >= valorCredito) {
            getConta(numeroConta).setSaldo(saldo-valorCredito);
        }else{
            throw new RuntimeException("Valor maior que o saldo!");
        }
        Transacao transacao = new Transacao(valorCredito, "SAQUE     -R$");
        getConta(numeroConta).addTransacao(transacao);
    }
    public double saldo(int numeroConta){
        if(getConta(numeroConta) == null) throw new RuntimeException("Conta não encontrada!");
        return this.contas.get(numeroConta).getSaldo();
    }
    public String extrato(int numeroConta){
        if(getConta(numeroConta) == null) throw new RuntimeException("Conta não encontrada!");
        StringBuilder stringBuilder = new StringBuilder();
        for(Transacao transacao : getConta(numeroConta).getTransacoes()){
            stringBuilder.append(transacao.toString() + "\n");
        }
        String extrato;
        String tipoConta = "CONTA SIMPLES";
        if(getConta(numeroConta).isEspecial()){
            tipoConta = "CONTA ESPECIAL";
        }
        return extrato =
                tipoConta+"\n" +
                "Correntista:"+getConta(numeroConta).getCorrentista().getNomeIdenticacao()+"\n" +
                "Número da conta:"+numeroConta+ "\n" +
                "Crédito:"+getConta(numeroConta).getCredito()+"\n" +
                "\n" +
                "EXTRATO:\n" +
                "\n" +
                "\n" +
                stringBuilder+
                "\n" +
                "SALDO DA CONTA: "+getConta(numeroConta).getSaldo();
    }

    public Map<String, Correntista> getCorrentistas() {
        return correntistas;
    }

    public Correntista getCorrentista(String numeroDocumentoIdentificacao){
        return this.correntistas.get(numeroDocumentoIdentificacao);
    }
    public Conta getConta(int numeroConta){
        return this.contas.get(numeroConta);
    }
    public void adicionarConta(Conta conta){
        this.contas.put(conta.getNumero(),conta);
    }
    public Map<Integer, Conta> getContas() {
        return contas;
    }

}
