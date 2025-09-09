import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@requestMapping("/transacao")
@RequiredArgsConstructor
//esse controller é responsavel por receber as requisições do usuario

public class TransacaoController {
    private final  TransacaoService service;

@PostMapping
//mapeia o entpoint 
    public ResponseEntity<Void> realisaTransacao (@RequestBody @Valid Transacao t) {
            service.adicionarTransacao(t);
        return ResponseEntity.status(201).build();

    }
//retorna o estatus 201 que é o status de criado
@DeleteMapping
public ResponseEntity<Void> removeTransacao() {
        service.apagaTransacao ();
            return ResponseEntity.status(204).build();

}

}
