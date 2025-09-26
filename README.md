# Gerenciador de projetos



* Author: Henrique Silva Moreira
* Github: HeinrichDev6002
* Title: Software project manager

## About


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

### Routes:
<br>

* api/v1/cadastrar - POST, Cadastra um novo User
* api/v1/login - POST, Faz login de User já cadastrado
* api/v1/criar - POST, novo projeto gerado
* api/v1/editar - PUT, edita projeto existente
* api/v1/deletar - DELETE, Deleta projeto existente
* api/v1/user/projetos/{id} - GET, Todos projetos públicos, ou privados se tiver autorização ou apenas algum específico pelo id
* api/v1/user/projetos? - GET, filtra os projetos, ex: por contribuidores

### Classes
<br>

* User, Model - Classe de usuário.
* UserDTO, DTO - Classe de usuário seguindo padrão DTO para garantir a segurança.
* Projects, Model - Classe de projetos, responsável por representar os projetos reais.
* ProjectRequest, Model - Classe para fazer requisição de projetos, permite a um cliente pedir a um outro User que aceite seu projeto.
* ProjectRequestDTO, DTO - Para impedir que o cliente force outro User aceitar projetos sem permissão.
* Image, Model - Classe para imagens genéricas, podem ser UMLs, imagens de Design, MER, e etc.
* UserImage, Model - Imagem do usuário para identificação visual do próprio.
* Task, Model - Entidade responsável por representar e permitir a adição de tarefas nos projetos.