# Projeto de Transferências e Carteiras

Este projeto foi desenvolvido como parte de um desafio de vaga Júnior para o PicPay. O objetivo foi aprimorar minhas habilidades em Java e Spring, criando uma aplicação que permite criar usuários e lojistas, bem como realizar transferências entre eles. O projeto possui dois endpoints principais: `/transfer` e `/wallets`.

## Endpoints

### 1. `POST /transfer`

Este endpoint é usado para realizar transferências. Ele requer os seguintes campos no corpo da requisição:

- `value`: Valor da transferência. Deve ser um valor decimal maior ou igual a 0.01.
- `payer`: ID do pagador.
- `payee`: ID do recebedor.

#### Exemplo de requisição:

```json
{
  "value": 100.00,
  "payer": 1,
  "payee": 2
}
```
### 2. `POST /wallets`

Este endpoint é usado para criar uma nova carteira. Ele requer os seguintes campos no DTO:

- `fullName`: Nome completo do usuário.
- `cpfCnpj`: CPF ou CNPJ do usuário..
- `email`: email do usuário.
- `password`: senha do usuário.
- `walletType`: Tipo da carteira (usuário ou lojista).

#### Exemplo de requisição:

```json
{
  "fullName": "João da Silva",
  "cpfCnpj": "12345678909",
  "email": "joao.silva@example.com",
  "password": "senhaSegura123",
  "walletType": "USER"
}
```

### Considerações Finais
Este projeto foi desenvolvido para demonstrar minhas habilidades em desenvolvimento de aplicações Java com Spring. Ele inclui funcionalidades essenciais para criação de usuários e lojistas, bem como transferência de valores entre contas. Utilizei o Hibernate para gerenciar as transações de forma eficiente e segura.