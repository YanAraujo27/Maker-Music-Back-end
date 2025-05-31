# ⚙️ API Robusta para Portal de Escola de Música: Spring Boot & Java 21

Este repositório contém o código-fonte do **backend robusto e seguro** que serve como a espinha dorsal para o portal da escola de música. Desenvolvido com as mais recentes tecnologias **Java 21, Spring Boot 3.5 e Maven**, esta API RESTful é responsável por toda a lógica de negócios, persistência de dados e segurança da aplicação, fornecendo endpoints eficientes e bem definidos para o front-end.

## ✨ Destaques Técnicos e Arquiteturais:

* **Stack Principal:**
    * **Java 21:** Utilizando os recursos mais recentes da plataforma Java.
    * **Spring Boot 3.5:** Para desenvolvimento ágil e configuração simplificada de aplicações Spring.
    * **Spring MVC:** (Com modificações) Para a criação dos endpoints RESTful.
    * **Spring Data JPA:** Para interação simplificada com o banco de dados.
    * **Spring Security:** Para a implementação da camada de segurança.
* **Gerenciamento de Dependências:** **Maven** para um controle de projeto e bibliotecas eficiente.
* **Persistência de Dados:** **MySQL Server** como sistema de gerenciamento de banco de dados relacional.
* **Segurança Avançada:** Implementação de autenticação e autorização baseadas em **JSON Web Tokens (JWT)**, incluindo mecanismos de **criptografia** para garantir a integridade e confidencialidade dos dados e tokens.
* **Arquitetura Limpa (Clean Architecture):** O código foi meticulosamente estruturado seguindo os princípios da **Clean Architecture**. Essa abordagem promove alta coesão, baixo acoplamento, excelente testabilidade e facilidade de manutenção, isolando as regras de negócio de detalhes de infraestrutura.
* **Padrão MVC Adaptado:** O padrão Model-View-Controller (MVC) foi utilizado e adaptado para se encaixar na estrutura da Clean Architecture, garantindo uma separação clara de responsabilidades entre a apresentação (controllers), a lógica de aplicação (casos de uso/serviços) e o domínio.
* **Design da API:** Fornece uma gama completa de endpoints RESTful para suportar todas as funcionalidades do portal front-end, incluindo gerenciamento de usuários (alunos, professores, responsáveis), aulas, turmas, materiais didáticos, acompanhamento de progresso e sistemas de comunicação.

## 💡 Propósito e Visão:

Este backend foi desenvolvido individualmente para ser a fundação sólida e confiável do portal da escola de música. A arquitetura escolhida visa não apenas a funcionalidade atual, mas também a escalabilidade e a facilidade para futuras expansões e manutenções.
