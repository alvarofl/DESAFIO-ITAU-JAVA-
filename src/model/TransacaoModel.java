import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
//data é uma anotação do loobokque   cria  geters seters e tostring
public class TransacaoModel {
@NotNull
//notnull é uma anotação do java   valida se o campo não é nullo
@DecimalMin ("0.0")
    private BigDecimal valor;
    @NotNull
    private  OffsetDateTime datahora;
//offsetdatetime é uma classe do java que representa uma datahora com fuso horario
}
