# Password Validator

Este projeto implementa um validador de senhas como um serviço REST simples.

Design pattern utilizado

- Strategy: cada regra de validação (`PasswordRule`) é implementada como uma estratégia distinta(ex.: `DigitRequiredRule`, `LowercaseRequiredRule`, ...).
As regras são injetadas como uma lista em `PasswordValidatorServiceImpl` através do `PasswordValidatorConfig`,
permitindo adicionar/remover regras sem alterar a lógica de validação central.

Endpoint de validação

- POST /api/passwords/validate
- Payload de exemplo:

```json
{
  "password": "Exemplo@123"
}
```

Comportamento para `password: null`

Quando `password` for enviado como `null`, optei por retornar `400 Bad Request` em vez de apenas retornar `{"valid": false}`.
Isso indica ao usuário que o corpo da requisição está incompleto/inválido, em vez de tratá-lo como uma senha inválida.

Comentários

- As regras são definidas em `src/main/java/.../validator/rules`.
- A configuração que monta a lista de regras está em `PasswordValidatorConfig`.
- O serviço principal é `PasswordValidatorServiceImpl`.

## Estrutura principal do projeto

Esquema simplificado com os arquivos/pastas mais relevantes:

```
password-validator/
├─ pom.xml
├─ README.md
└─ src/
   └─ main/
      ├─ java/
      │  └─ com/gabriel_arruda/password_validator/
      │     ├─ PasswordValidatorApplication.java
      │     ├─ config/
      │     │  └─ PasswordValidatorConfig.java
      │     ├─ controller/
      │     │  └─ PasswordController.java
      │     ├─ dto/
      │     │  ├─ PasswordValidationRequest.java
      │     │  └─ PasswordValidationResponse.java
      │     ├─ exception/
      │     │  └─ GlobalExceptionHandler.java
      │     ├─ service/
      │     │  ├─ PasswordValidatorService.java
      │     │  └─ impl/PasswordValidatorServiceImpl.java
      │     └─ validator/
      │        ├─ PasswordRule.java
      │        └─ rules/
      │           ├─ DigitRequiredRule.java
      │           ├─ LowercaseRequiredRule.java
      │           ├─ MinimumLengthRule.java
      │           ├─ NoRepeatedCharactersRule.java
      │           ├─ NotEmptyRequiredRule.java
      │           ├─ NoWhitespaceRule.java
      │           ├─ SpecialCharacterRequiredRule.java
      │           └─ UppercaseRequiredRule.java
      └─ resources/
         └─ application.properties
```
