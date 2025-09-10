package com.itau.desafio.service;

import com.itau.desafio.model.Estatistica;
import com.itau.desafio.model.Transacao;
import com.itau.desafio.exception.TransacaoInvalidaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TransacaoServiceTest {
    private TransacaoService service;
@BeforeEach
//esse befoeach é para inicialisar o serviso antes de cada test void e evitar repetição de código
    void setup() {
service = new TransacaoService ();


    }
    @Test
    void deveAdicionarTransacaoValida () {
        Transacao transacao = new Transacao ();
        ttransacao.setValor(BigDecimal.valueOf(100));
//setando o valor da transacao como 100, para testar o método adicionar
            t.setDataHora(OffsetDateTime.now().minusSeconds(10));
                    service.adicionar(transacao);
                        Estatistica  estatistica = service.calcular();
                            assertThat(estatistica.getCount()).iseEqualTo(1);
                            //verificando se o count da estatistica é 1
                                    assertThat(estatistica.getSum()).isEqualTo(BigDecimal.valueOf(100));
                                    //verificando se sun da estatistica é 100 assetThat
    }
        @Test
            void naopoderaNegativo() {
                Transacao transacao = new Transacao ();
                    ttransacao.setValor(BigDecimal.valueOf(-10));
        transacao.setDataHora(OffsetDateTime.now().minusSeconds(10));
        assertThatThrownBy(() -> service.adicionar(t))
                .isInstanceOf(TransacaoInvalidaException.class);
                //verificando se a exceção é lançada 
            }
            @Test
                    void naoPodeDataFutura() {
                        Transacao transacao = new Transacao ();
                            transacao.setValor(BigDecimal.valueOf(50));
                        transacao.setDataHora(OFFSetDateTime.now().PlusSeconds(30));
                            assertThatThrownBy(() -> service.adicionar(transacao));
                                .isInstanceOf(transacaoInvalidaException.class);
                    }
                    @Test
                    public void limpaTransacoes() {
                        Transacao t1 = new Transacao();
                            ttransacao.setValor(bigDecimal.valueOF(100));
                                transacao.setDataHora(OffsetDateTime.now().minusSeconds(20));

                            Transacao t2 = new Transacao ();
//criando duas  transações para testar o método limpar
                        t2.setValor(BigDecimal.valueOF(200));
                                t2.setDataHora(OffsetDateTime.now().minusSeconds(30));
                                    service.adicionar(t1);
                                        service.adicionar(t2);
                                        //colocando o t1 e t2 no service para testar o limpar o service 
                                            service.limpar();
                                
                                                    Estatistica estatistica = service.calcular();
                        assertThat(estatistica.getCount()).isZero();                            
                    }
@Test
                        void deveCalcularEstatisticasCorretamente() {
                                Transacao t1 = new Transacao();
                                    t1.setValor(BigDecimal.valueOf(10));
                                        t1.DataHora(OffsetDateTime.now().minusSeconds(10));
        Transacao t2 = new Transacao();
        t2.setValor(BigDecimal.valueOf(20));
        t2.setDataHora(OffsetDateTime.now().minusSeconds(20));

        Transacao t3 = new Transacao();
        t3.setValor(BigDecimal.valueOf(30));
        t3.setDataHora(OffsetDateTime.now().minusSeconds(30));

        service.adicionar(t1);
        service.adicionar(t2);
        service.adicionar(t3);

        Estatistica estatistica = service.calcular();

        assertThat(estatistica.getCount()).isEqualTo(3);
        assertThat(estatistica.getSum()).isEqualTo(BigDecimal.valueOf(60));
        assertThat(estatistica.getAvg()).isEqualTo(BigDecimal.valueOf(20));
        assertThat(estatistica.getMin()).isEqualTo(BigDecimal.valueOf(10));
        assertThat(estatistica.getMax()).isEqualTo(BigDecimal.valueOf(30));
    }

    @Test
    void deveRetornarZeroQuandoNaoHaTransacoesNosUltimos60Segundos() {
        Transacao t = new Transacao();
        t.setValor(BigDecimal.valueOf(100));
        t.setDataHora(OffsetDateTime.now().minusMinutes(2)); // fora da janela de 60s

        service.adicionar(t);

        Estatistica estatistica = service.calcular();

        assertThat(estatistica.getCount()).isZero();
        assertThat(estatistica.getSum()).isEqualTo(BigDecimal.ZERO);
        assertThat(estatistica.getAvg()).isEqualTo(BigDecimal.ZERO);
        assertThat(estatistica.getMin()).isEqualTo(BigDecimal.ZERO);
        assertThat(estatistica.getMax()).isEqualTo(BigDecimal.ZERO);
    }
}
 
                        }
            