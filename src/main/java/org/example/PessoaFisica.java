package org.example;

import java.util.ArrayList;
import java.util.List;

public class PessoaFisica implements Correntista {
    private String cpf;
    private String nome;
    private String endereco;
    private String dataNascimento;
    private String telefone;
    private List<Conta> contas;

    public PessoaFisica(String cpf, String nome, String endereco, String dataNascimento, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String getNumeroDocumentoIdentificacao() {
        return this.cpf;
    }

    @Override
    public String getNomeIdenticacao() {
        return this.nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }
}
