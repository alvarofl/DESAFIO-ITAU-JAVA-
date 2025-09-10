//esse @restcontrolleradvice para tratar exceções de forma global
@RestControllerAdvice


public class GlobalExceptionHandler {
    @ExceptionHandler(TransacaoInvalidaException.class)
    // esse @globalExctionHandler para tratar todas exceções
    public ResponseEntity<Void> handleTransacaoInvalida() {
        // esse response entity handle para retornar uma resposta http vasia
    }@ExceptionHandler(httpMenssageNotReadableException.Class)

    

    public ResponseEntity<Void> handlejsonInvalido() {
        return ResponseEntity.badRquest().build();
    }

}


