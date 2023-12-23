package org.example;

import java.util.ArrayList;
import java.util.List;

public class PessoaJuridica implements Correntista {
    private String cnpj;
    private String nome;
    private String nomeFantasia;
    private String endereco;
    private String telefone;
    private List<Conta> contas;


    public PessoaJuridica(String cnpj, String nome, String nomeFantasia, String endereco, String telefone) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.nomeFantasia = nomeFantasia;
        this.endereco = endereco;
        this.telefone = telefone;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
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

    public String getCnpj() {
        return cnpj;
    }

    public String getNumeroDocumentoIdentificacao() {
        return this.cnpj;
    }

    public String getNomeIdenticacao() {
        return this.nomeFantasia;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

}
