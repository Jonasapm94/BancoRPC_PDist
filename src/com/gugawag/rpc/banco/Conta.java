package com.gugawag.rpc.banco;

import java.io.Serializable;

public class Conta implements Serializable{
    private String numero;
    private Double saldo;

    public Conta(String numero, Double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    public Double getSaldo(){
        return this.saldo;
    }

    public boolean addSaldo(Double valor){
        if(valor > 0.0){
            this.saldo += valor;
            return true;
        }
        return false;
    }

    public boolean retrieveSaldo(Double valor){
        if (valor <= this.saldo){
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String novoNumero){
        this.numero = novoNumero;
    }
}
