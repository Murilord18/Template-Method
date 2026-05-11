package br.com.banco;

import br.com.banco.templatemethod.ContaCorrente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaPoupancaTest {

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
}
