package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private Map<String, Conta> saldoContas;

    public BancoServiceServer() throws RemoteException {
        saldoContas = new HashMap<>();
        saldoContas.put("1", new Conta("1", 100.0));
        saldoContas.put("2", new Conta("2",156.0));
        saldoContas.put("3", new Conta("3",950.0));
        saldoContas.put("4", new Conta("4",335.0));
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return this.saldoContas.get(conta).getSaldo();
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return saldoContas.size();
    }

    @Override
    public String adicionarConta(String numero, Double saldo) throws RemoteException {
        Conta conta = new Conta(numero, saldo);
        while(this.saldoContas.get(conta.getNumero()) != null){
            conta.setNumero(conta.getNumero() + 1);
        }
        this.saldoContas.put(conta.getNumero(), conta);
        return conta.getNumero();
    }

    @Override
    public Conta pesquisarConta(String numeroConta) throws RemoteException {
        return this.saldoContas.get(numeroConta);
    }

    @Override
    public boolean removerConta(String numeroConta) throws RemoteException {
        if (this.saldoContas.get(numeroConta) != null){
            this.saldoContas.remove(numeroConta);
            return true;
        } else{
            return false;
        }
    }

}
