# DESAFIO-ITAU-JAVA-
Esse repositório tem o objetivo de resolver o desafio público do GitHub para o cargo de back_junior, o desafio tem a finalidade de criar uma API com Spring Boot.

---

# Itaú Unibanco - Desafio de Programação

Este é um desafio bacana tanto de desenvolvimento de software quanto de engenharia de software. Queremos testar sua capacidade de construir um software com várias partes diferentes funcionando em conjunto!

## 1. Introdução

Sua missão, caso você aceite, é criar uma API REST que recebe Transações e retorna Estatísticas sob essas transações. Para este desafio, a API deve ser criada utilizando Java ou [Kotlin](https://kotlinlang.org/) e Spring Boot.

Um bom lugar para se começar é o [Spring Starter](https://start.spring.io/).

> **Dica:** Não existe uma forma certa ou errada de resolver o desafio! Vamos avaliar coisas como a qualidade do seu código, o quão fácil é de compreender o código, organização do projeto, quantidade e qualidade dos testes, preocupação com segurança e vários outros fatores :)

## 2. Definição do desafio

Neste desafio você deve **criar uma API REST** no [GitHub](https://github.com/) ou [GitLab](https://gitlab.com/). **Leia com atenção todas as instruções a seguir!**

### 2.1. Restrições Técnicas

Seu projeto:

- **DEVE** estar no [GitHub](https://github.com/) ou [GitLab](https://gitlab.com/)
- **NÃO DEVE** fazer _fork_ de nenhum outro projeto
- **DEVE** ter pelo menos 1 commit por cada endpoint (mínimo de 3 commits)
- Todos os commits **DEVEM** ser feitos pelo mesmo usuário que criou o projeto
- **DEVE** seguir exatamente os _endpoints_ descritos a seguir
- **DEVE** aceitar e responder com objetos exatamente como descritos
- **NÃO DEVE** utilizar quaisquer sistemas de banco de dados (H2, MySQL, PostgreSQL, etc.) ou cache (Redis, Memcached, etc.)
- **DEVE** armazenar todos os dados **em memória**
- **DEVE** aceitar e responder apenas com [JSON](https://www.json.org/json-pt.html)

> **Atenção!** Por motivos de segurança, não podemos aceitar projetos enviados como arquivos. Você **DEVE** disponibilizar seu projeto publicamente.

### 2.2. Endpoints da API

#### 2.2.1. Receber Transações: `POST /transacao`

```json
{
    "valor": 123.45,
    "dataHora": "2020-08-07T12:34:56.789-03:00"
}
Campos:
Campo
Significado
Obrigatório?
valor
Valor em decimal com ponto flutuante da transação
Sim
dataHora
Data/Hora no padrão ISO 8601 em que a transação aconteceu


Respostas esperadas:
• 
201 Created — transação aceita
• 
422 Unprocessable Entity — transação inválida
• 
400 Bad Request — JSON inválido
2.2.2. Limpar Transações: DELETE /transacao
Apaga todos os dados de transações.
• 
200 OK — todos os dados apagados com sucesso
2.2.3. Calcular Estatísticas: GET /estatistica
Retorna estatísticas das transações dos últimos 60 segundos:
json

{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}
Dica: Você pode usar DoubleSummaryStatistics do Java 8+ para calcular os valores.
 
4. Extras (opcional)
1. 
Testes automatizados (unitários ou funcionais)
2. 
Containerização
3. 
Logs
4. 
Observabilidade (healthcheck)
5. 
Performance
6. 
Tratamento de erros personalizado
7. 
Documentação da API (Swagger, RAML, etc.)
8. 
Documentação do sistema para execução
9. 
Configurações (ex.: tempo de cálculo das estatísticas customizável)
 
