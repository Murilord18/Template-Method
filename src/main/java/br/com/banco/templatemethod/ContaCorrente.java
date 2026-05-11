package br.com.banco.templatemethod;

public class ContaCorrente extends ContaBancaria {

    public ContaCorrente(String numeroConta, String titular, double saldo) {
        super(numeroConta,titular,saldo);
    }

    @Override
    public double getPercentualTarifa() {
        return 0.02;
    }

    @Override
    public String getTipoConta() {
        return "ContaCorrente";
    }
}
