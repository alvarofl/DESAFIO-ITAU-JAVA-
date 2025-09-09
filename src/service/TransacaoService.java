import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
//esse @ é um anotation do spring
    public  class TransacaoService {
        private final List<Transacao> transacoes  = new CopyOnWriteArrayList<>();
        //copyOnWriteArrayList é uma lista thread save ou seja segura para acesso concorrente
        public void adicionar(Transacao t) {
                            if (t.getValor().compareTo(BigDecimal.ZERO) < 0 || t.getDataHora().isAfter(OffsetDateTime.now())) {
                                //se o valor for negativo ou a for maior que a data atual 
            throw new TransacaoInvalidaException();
        }
        transacoes.add(t);    
    }
    public void limparTransacoes() {
        transacoes.clear();
    }
//criando método para calcular  estatisticas 
    public Estatisticas calcularEstatisticas () {
        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);
//pegando o tempo e subitraindo 60 segundos
                DoubleSummaryStatistics stats = transacoes.stream()
                //criando um stream para filtrar as transacoes
                .filter(t -> t.getDataHora().isAfter(limite))
                .mapToDouble(t -> t.getValor().doubleValue())
                //convertendo para double
                .summaryStatistics();
//pegando as estatistica do stream
        if (stats.getCount() == 0) {
            return new Estatistica(0, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
            //se não tiver transacoes retorna 0
        }
            return new Estatisticas(
stats.getCount(),
//pegando a quantidade de transacoes
BigDecimal.valueOf(stats.getSum()),
//pegando as somas das transacoes
        BigDecimal.valueOf(stats.getAverage()),
        //pegando a média das transcoes
        BigDecimal.valueOf(stats.getMin()),
        //pega do a men or valor
        BigDecimal.valueOf(stats.getMax())
//pega o maior valor
);

            


    }

    }