package br.com.banco.templatemethod;

import java.util.Locale;


public abstract class ContaBancaria {

    private String numeroConta;
    private String titular;
    private double saldo;

    public ContaBancaria(String numeroConta, String titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }


    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }



    public abstract double getPercentualTarifa();




    public double calcularTarifaMensal() {
        return this.saldo * this.getPercentualTarifa();
    }

    public String verificarSaldoAposCobranca() {
        double saldoApos = this.saldo - this.calcularTarifaMensal();
        if (saldoApos >= 0) {
            return "Saldo suficiente";
        } else {
            return "Saldo insuficiente";
        }
    }


    public String getExtrato() {
        return getTipoConta() + "{"
                + "numeroConta='" + this.numeroConta + "'"
                + ", titular='" + this.titular + "'"
                + ", saldo=" + String.format(Locale.ROOT, "%.2f", this.saldo)
                + ", tarifaMensal=" + String.format(Locale.ROOT, "%.2f", this.calcularTarifaMensal())
                + ", status='" + this.verificarSaldoAposCobranca() + "'"
                + "}";
    }


    public String getTipoConta() {
        return "ContaBancaria";
    }
}
