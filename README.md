﻿![logo](https://github.com/emanueljn/forumhub/assets/141789277/acadd806-c178-423f-b897-111b6766937d)

💻 Sobre o projeto
Este é um projeto de uma api rest de um fórum. Ela fornece endpoits para CRUD de tópicos, respostas e usuários.
Foi desenvolvido como resolução de um Challenge do Projeto ONE Oracle Next Education Alura + Oracle.

---
⚙️ Funcionalidades

1. cadastrar tópico
2. listar tópico
3. detalhar tópico
4. excluir tópicos
5. cadastrar resposta
6. listar resposta
7. detalhar resposta
8. excluir resposta
8. cadastrar usuário
9. listar usuário
10. detalhar usuário 
11. excluir usuário
12. fazer login

---
Como usar
1. Clone o repositório para sua máquina local ou baixe o projeto;
2. Crie um banco de dados Mysql na sua máquina;
3. Subistitua pelas suas informações de host, nome do banco de dados, usuario e senha no arquivo application.properties, que está no diretório resources;
2. Compile o projeto utilizando o compilador Java ou uma IDE;
3. Execute a classe ForumhubApplication.java para iniciar o programa;

Pronto! A Api Fórum Hub já estará funcionando, pronta para receber requisições.

INFORMAÇÕES IMPORTANTES

Para liberar acesso a todos os end points da api, deverá cadastrar um usuário no endpoint "/usuario" via método POST, enviando um json com nome, login(será um e-mail válido) e senha.
Para mais detalhes da api , após compilar, acesse as urls: "/swagger-ui.html" e "/v3/api-docs".

---

🛠 Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:

* Java 22
* Spring Boot 3
* Maven
* Mysql
* Hibernate
* Spring security

---
📝 Autor

[Emanuel de Jesus Nardes</sub>](https://github.com/emanueljn)

---
📝 Licença
Este projeto está licenciado sob a Licença MIT.
Este projeto está licenciado sob a [Licença MIT](LICENSE).
