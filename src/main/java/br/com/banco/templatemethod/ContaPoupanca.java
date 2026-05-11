package br.com.banco.templatemethod;

public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }


    @Override
    public double getPercentualTarifa() {
        return 0.005;
    }

    @Override
    public String getTipoConta() {
        return "ContaPoupanca";
    }
}
