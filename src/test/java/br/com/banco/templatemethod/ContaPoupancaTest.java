package br.com.banco.templatemethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContaPoupancaTest {

    @Test
    void deveCalcularTarifaMensalCorretamente() {

        ContaPoupanca conta = new ContaPoupanca("004-1", "Fernanda Rocha", 1000.00);
        assertEquals(5.00, conta.calcularTarifaMensal(), 0.001);
    }


    @Test
    void deveRetornarSaldoSuficienteQuandoHaSaldo() {
        ContaPoupanca conta = new ContaPoupanca("004-2", "Roberto Alves", 200.00);
        assertEquals("Saldo suficiente", conta.verificarSaldoAposCobranca());
    }

    @Test
    void tarifaDaPoupancaDeveSerMenorQueContaCorrente() {
        ContaPoupanca poupanca = new ContaPoupanca("005-1", "Lucia Torres", 1000.00);
        ContaCorrente corrente = new ContaCorrente("005-2", "Lucia Torres", 1000.00);

        assertTrue(poupanca.calcularTarifaMensal() < corrente.calcularTarifaMensal());
    }

    @Test
    void deveRetornarExtratoCorreto() {
        ContaPoupanca conta = new ContaPoupanca("006-1", "Marcos Ferreira", 2000.00);
        String extrato = conta.getExtrato();
        assertEquals(
                "ContaPoupanca{numeroConta='006-1', titular='Marcos Ferreira', saldo=2000.00, tarifaMensal=10.00, status='Saldo suficiente'}",
                extrato
        );
    }

    @Test
    void deveRetornarTipoContaPoupanca() {
        ContaPoupanca conta = new ContaPoupanca("007-1", "Beatriz Nunes", 500.00);
        assertEquals("ContaPoupanca", conta.getTipoConta());
    }
}
