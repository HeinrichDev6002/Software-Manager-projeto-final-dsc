# Gerenciador de projetos



* Author: Henrique Silva Moreira
* Github: HeinrichDev6002
* Title: Software project manager

# About

### English:
<br>
This project is part of an assessment made by the Professor Daniel Faustino
who is in charge of the matter named Desenvolvimento de Sistemas Corporativos. 
The purpose of this project is to help programmers with their projects management.

### Português:
<br>
Esse projeto é parte da avaliação realizada pelo professor Daniel Faustino
responsável pela matéria chamada Desenvolvimento de Sistemas Corporativos. O objetivo
deste projeto é ajudar os desenvolvedores com o gerenciamento de seus projetos.

# Routes

## GET

* api/v2/users - Retorna uma lista com todos os usuários.
* api/v2/users/{userId} - Retorna um usuário específico.

## POST

* api/v2/users - Cadastra um novo usuário.

## PUT

* api/v2/users/{userId} - Atualiza um usuário existente.

## DELETE

* api/v2/users/{userId} - Deleta um usuário existente.

<br>

## Entities
<br>

* User - Entidade que representa o usuário.
* Projects - Entidade que representa o projeto.
* Task - Entidade que representa uma tarefa associada a um time.
* Team - Entidade que representa um time, associada a um projeto.