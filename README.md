# Automação da API Petstore

Este projeto é um exemplo de automação da API Petstore, desenvolvido em Java utilizando a biblioteca RestAssured.

## Endpoints Testados

Os seguintes endpoints foram testados:

- **Cadastrar novo pedido de pet com sucesso (POST /store/order)**
- **Pesquisar por um pet inexistente (GET /pet/{petId})**
- **Atualizar dados de um pet existente (PUT /pet)**
- **Pesquisar por pets com status “pending” (GET /pet/findByStatus)**

## Validações Realizadas

Em cada um desses testes, foram realizadas as seguintes validações:

- **Status Code**: Verifica se a resposta possui o código de status esperado.
- **Estrutura da Resposta**: Valida se a resposta está de acordo com o schema definido.
- **Valores dos Dados**: Confirma se os valores retornados correspondem às expectativas definidas.

## Tecnologias Utilizadas

- **Java**
- **RestAssured**

## Como Executar os Testes

1. Clone o repositório.
2. Certifique-se de que possui o JDK e as dependências necessárias configuradas.
3. Execute os testes utilizando sua IDE ou com o comando Maven `mvn test`
