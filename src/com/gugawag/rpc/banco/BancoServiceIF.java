package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancoServiceIF extends Remote {

    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    String adicionarConta(String numero, Double saldo) throws RemoteException;
    Conta pesquisarConta(String numeroConta) throws RemoteException;
    boolean removerConta(String numeroConta) throws RemoteException;
    
}
