# Password Validator

Este projeto implementa um validador de senhas como um serviço REST simples usando Spring Boot.

### Regras de validação
- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
- Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto
- Não possuir espaços em branco

### Design pattern utilizado

- Strategy: cada regra de validação (`PasswordRule`) é implementada como uma estratégia (ex.: `DigitRequiredRule`, `LowercaseRequiredRule`, ...).
  As regras são injetadas como uma lista em `PasswordValidatorServiceImpl` através do `PasswordValidatorConfig`,
  permitindo adicionar/remover regras sem alterar a lógica de validação central.

### Endpoint de validação

- POST /api/v1/password/validate
- Payload de exemplo:

```json
{
  "password": "Exemplo@123"
}
```

- Resposta de exemplo:

```json
{
  "valid": true
}
```

### Comentários

- As regras são definidas em `src/main/java/.../validator/rules`.
- A configuração que monta a lista de regras está em `PasswordValidatorConfig`.
- O serviço principal é `PasswordValidatorServiceImpl`.
- Foram implementados testes usando JUnit 5 e Mockito.

#### Comportamento para `password: null`

Quando `password` for enviado como `null`, optei por retornar `400 Bad Request` em vez de apenas retornar `{"valid": false}`.
Isso indica ao usuário que o corpo da requisição está incompleto/inválido, em vez de tratá-lo como uma senha inválida.


## Testes

Foram adicionados testes unitários e de controller (integração leve). Os testes usam JUnit 5 e Mockito (pelo `spring-boot-starter-test`).

Principais testes implementados:

- `src/test/java/com/gabriel_arruda/password_validator/validator/rules/`
  - `DigitRequiredRuleTest.java`
  - `LowercaseRequiredRuleTest.java`
  - `MinimumLengthRuleTest.java`
  - `NoRepeatedCharactersRuleTest.java`
  - `NotEmptyRequiredRuleTest.java`
  - `NoWhitespaceRuleTest.java`
  - `SpecialCharacterRequiredRuleTest.java`
  - `UppercaseRequiredRuleTest.java`
- `src/test/java/com/gabriel_arruda/password_validator/service/impl/`
  - `PasswordValidatorServiceImplTest.java`
- `src/test/java/com/gabriel_arruda/password_validator/controller/`
  - `PasswordControllerTest.java` (testes standalone com MockMvc; cobre `password: null` -> 400, casos válidos e inválidos)

### Como rodar o projeto

Pré-requisitos

- Java 21 instalado e configurado no PATH
- Maven instalado (ou usar o Maven Wrapper incluído no projeto)

#### Executar a aplicação

No diretório raiz do projeto:

**Usando Maven Wrapper (recomendado - não requer Maven instalado):**

Windows:
```powershell
.\mvnw.cmd spring-boot:run
```

Linux/Mac:
```bash
./mvnw spring-boot:run
```

**Usando Maven (se já tiver instalado):**
```powershell
mvn spring-boot:run
```

A aplicação vai subir na porta 8080 por padrão.

Executar os testes:

**Usando Maven Wrapper:**

Windows:
```powershell
.\mvnw.cmd test
```

Linux/Mac:
```bash
./mvnw test
```

**Usando Maven:**
```powershell
mvn test
```

## Estrutura principal do projeto

```
password-validator/
├─ pom.xml
├─ README.md
└─ src/
   ├─ main/
   │  ├─ java/
   │  │  └─ com/gabriel_arruda/password_validator/
   │  │     ├─ PasswordValidatorApplication.java
   │  │     ├─ config/
   │  │     │  └─ PasswordValidatorConfig.java
   │  │     ├─ controller/
   │  │     │  └─ PasswordController.java
   │  │     ├─ dto/
   │  │     │  ├─ PasswordValidationRequest.java
   │  │     │  └─ PasswordValidationResponse.java
   │  │     ├─ exception/
   │  │     │  └─ GlobalExceptionHandler.java
   │  │     ├─ service/
   │  │     │  ├─ PasswordValidatorService.java
   │  │     │  └─ impl/PasswordValidatorServiceImpl.java
   │  │     └─ validator/
   │  │        ├─ PasswordRule.java
   │  │        └─ rules/
   │  │           ├─ DigitRequiredRule.java
   │  │           ├─ LowercaseRequiredRule.java
   │  │           ├─ MinimumLengthRule.java
   │  │           ├─ NoRepeatedCharactersRule.java
   │  │           ├─ NotEmptyRequiredRule.java
   │  │           ├─ NoWhitespaceRule.java
   │  │           ├─ SpecialCharacterRequiredRule.java
   │  │           └─ UppercaseRequiredRule.java
   │  └─ resources/
   │     └─ application.properties
   └─ test/
      └─ java/
         └─ com/gabriel_arruda/password_validator/
            ├─ PasswordValidatorApplicationTests.java
            ├─ controller/
            │  └─ PasswordControllerTest.java
            ├─ service/impl/
            │  └─ PasswordValidatorServiceImplTest.java
            └─ validator/rules/
               ├─ DigitRequiredRuleTest.java
               ├─ LowercaseRequiredRuleTest.java
               ├─ MinimumLengthRuleTest.java
               ├─ NoRepeatedCharactersRuleTest.java
               ├─ NotEmptyRequiredRuleTest.java
               ├─ NoWhitespaceRuleTest.java
               ├─ SpecialCharacterRequiredRuleTest.java
               └─ UppercaseRequiredRuleTest.java
```
