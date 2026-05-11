package br.com.banco.templatemethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaCorrenteTest {

    @Test
    void deveCalcularTarifaMensalCorretamente() {
        ContaCorrente conta = new ContaCorrente("001-1", "João Silva", 1000.00);
        assertEquals(20.00, conta.calcularTarifaMensal(), 0.001);
    }

    @Test
    void deveRetornarSaldoSuficienteQuandoHaSaldo() {
        ContaCorrente conta = new ContaCorrente("001-2", "Maria Souza", 500.00);
        assertEquals("Saldo suficiente", conta.verificarSaldoAposCobranca());
    }

    @Test
    void deveRetornarSaldoInsuficienteQuandoSaldoZerado() {
        ContaCorrente conta = new ContaCorrente("001-3", "Pedro Costa", 0.00);
        assertEquals("Saldo suficiente", conta.verificarSaldoAposCobranca());
    }

    @Test
    void deveRetornarExtratoCorreto() {
        ContaCorrente conta = new ContaCorrente("002-1", "Ana Lima", 1000.00);
        String extrato = conta.getExtrato();
        assertEquals(
                "ContaCorrente{numeroConta='002-1', titular='Ana Lima', saldo=1000.00, tarifaMensal=20.00, status='Saldo suficiente'}",
                extrato
        );
    }

    @Test
    void deveRetornarTipoContaCorrente() {
        ContaCorrente conta = new ContaCorrente("003-1", "Carlos Mendes", 200.00);
        assertEquals("ContaCorrente", conta.getTipoConta());
    }
}
