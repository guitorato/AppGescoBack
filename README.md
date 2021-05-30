
# API GESCO

<a href="https://imgbb.com/"><img src="https://i.ibb.co/4mz9wTs/Gest-o-de-Antibi-ticos.gif" alt="Gest-o-de-Antibi-ticos" border="1" width="350"></a>

## Objetivo:

 Projeto sendo desenvolvido para o trabalho de conclusão de curso. <br>
O objetivo do Projeto é, desenvolver um sistema para controle de antibióticos ministrados em um hospital. 
A intenção é que o Médico cuide desta parte junto a farmácia, o médico administra os pacientes cadastrados e a farmácia cuida das validações necessárias.<br>

Outro objetivo é o gerenciamento do estoque de medicamentos, fator importante para que a Farmácia possa aprovar um tratamento com determinado antibiótico, 
uma vez que sem estoque de um determinado medicamento, não será possível iniciar o tratamento com o mesmo.
<br>

O sistema irá ajudar a controlar melhor os medicamentos ministrados em pacientes que estão em tratamento, e controlar 
quais estão em tratamento, diminuindo assim os erros que ocorriam quando esse processo era feito no papel além de auxiliar 
a rotina de médicos e enfermeiros e a melhor comunicação entre esses dois setores.
<br><br>

--------------------------------------------------

## Tecnologias Utilizadas:

O projeto será um aplicativo PWA com ligação a um site.<br>
Ambas partes serão feitas em Java 11 LTS, com as frameworks:<br>
<ul>
<li>SpringBoot 2.3.4</li>
<li>Hibernate 5.4.21</li>
<li>API REST</li>
<li>Swagger 2.1.4</li>
</ul>

--------------------------------------------------

## Estrutura do Projeto:

```jsx
📦src/main/java
 ┣ 📂com.gesco
 ┃ ┗ 📜GescoApplication.java
 ┃ ┣ 📂config
 ┃ ┃ ┣ 📜DevConfig.java
 ┃ ┃ ┣ 📜JWTAuthorizationFilter.java
 ┃ ┃ ┣ 📜JWTConstants.java
 ┃ ┃ ┣ 📜SecurityConfig.java
 ┃ ┃ ┣ 📜SwaggerConfig.java
 ┃ ┃ ┗ 📜TestConfig.java
 ┃ ┣ 📂dto
 ┃ ┃ ┣ 📜AntibioticoDTO.java
 ┃ ┃ ┣ 📜FuncionarioDTO.java
 ┃ ┃ ┣ 📜LoginDTO.java
 ┃ ┃ ┣ 📜PacienteDTO.java
 ┃ ┃ ┣ 📜PrescricaoDTO.java
 ┃ ┃ ┣ 📜SessaoDTO.java
 ┃ ┃ ┣ 📜StatusTratamentoDTO.java
 ┃ ┃ ┗ 📜TratamentoDTO.java
 ┃ ┣ 📂helpers
 ┃ ┃ ┗ 📜Helper.java
 ┃ ┣ 📂domain
 ┃ ┃ ┣ 📂enums
 ┃ ┃ ┃ ┣ 📜StatusTratamento.java
 ┃ ┃ ┃ ┣ 📜TipoFuncionario.java
 ┃ ┃ ┃ ┗ 📜TipoAplicacao.java
 ┃ ┃ ┣ 📜Antibiotico.java
 ┃ ┃ ┣ 📜Funcionario.java
 ┃ ┃ ┣ 📜Hospital.java
 ┃ ┃ ┣ 📜Paciente.java
 ┃ ┃ ┣ 📜Prescricao.java
 ┃ ┃ ┗ 📜Tratamento.java
 ┃ ┣ 📂repositories
 ┃ ┃ ┣ 📜AntibioticoRepository.java
 ┃ ┃ ┣ 📜FuncionarioRepository.java
 ┃ ┃ ┣ 📜HospitalRepository.java
 ┃ ┃ ┣ 📜HospitalRepository.java
 ┃ ┃ ┣ 📜PrescricaoRepository.java
 ┃ ┃ ┗ 📜TratamentoRepository.java
 ┃ ┣ 📂 resources
 ┃ ┃ ┣ 📂exceptions
 ┃ ┃ ┃ ┣ 📜ErrorResponse.java
 ┃ ┃ ┃ ┣ 📜ResourceExceptionHandler.java
 ┃ ┃ ┃ ┗ 📜StandardError.java
 ┃ ┃ ┣ 📜AntibioticoResource.java
 ┃ ┃ ┣ 📜FuncionarioResource.java
 ┃ ┃ ┣ 📜HospitalResource.java
 ┃ ┃ ┣ 📜HospitalResource.java
 ┃ ┃ ┣ 📜PrescricaoResource.java
 ┃ ┃ ┗ 📜TratamentoResource.java
 ┃ ┣ 📂services
 ┃ ┃ ┣ 📂exceptions
 ┃ ┃ ┃ ┣ 📜DataIntegrityException.java
 ┃ ┃ ┃ ┣ 📜NoSuchElementException.java
 ┃ ┃ ┃ ┣ 📜ObjectNotFoundException.java
 ┃ ┃ ┃ ┗ 📜RecordNotFoundException.java
 ┃ ┃ ┣ 📜AntibioticoService.java
 ┃ ┃ ┣ 📜FuncionarioService.java
 ┃ ┃ ┣ 📜HospitalService.java
 ┃ ┃ ┣ 📜HospitalService.java
 ┃ ┃ ┣ 📜PrescricaoService.java
 ┗  ┗  ┗ 📜TratamentoService.java
```

--------------------------------------------------

## Funcionalidades

Abaixo algumas funcionalidades da API. Os exemplos foram todos realizados como teste no [Swagger](https://gesco-api.herokuapp.com/swagger-ui.html#/).

### I. Método Post e Update do Antibiótico:

```
{
"dataValidade": "2020-01-01",
"funcionario": {

"id": 1
},
"lote": "789888",
"nome": "testeATB",
"nomeComercial": "TEST comericla atb",
"tipoAplicacao": 3
}
```
