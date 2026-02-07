# Sistema Web de Controle de Equipamentos – CCXP23

Aplicação web desenvolvida em **Java Spring Boot + MySQL + Thymeleaf** para uso operacional durante a **CCXP23**, com o objetivo de substituir planilhas de Excel por um sistema centralizado de controle de equipamentos e ativos.

O sistema foi utilizado pelo **time de Suporte e Infraestrutura** durante o evento, permitindo cadastro, edição, rastreio e consulta rápida de equipamentos em tempo real.

---

## 🚀 Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring MVC  
- Spring Data JPA  
- MySQL  
- Thymeleaf  
- Maven  
- HTML / CSS  

---

## 📌 Funcionalidades

O sistema permite:

- Cadastro de equipamentos  
- Edição de equipamentos  
- Listagem de equipamentos em tabela  
- Busca por patrimônio, modelo ou local  
- Visualização detalhada de registros  
- Persistência em banco MySQL  

---

## ▶️ Como rodar o projeto

### Pré-requisitos

- Java 17  
- Maven  
- MySQL  
- Git  

### Passos

```bash
git clone https://github.com/petersonbersanetti/controleDeEstoqueCCXP23.git
cd controleDeEstoqueCCXP23
mvn spring-boot:run
Configuração do banco (MySQL)


No arquivo src/main/resources/application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/estoque_ccxp
spring.datasource.username=root
spring.datasource.password=SEU_PASSWORD
spring.jpa.hibernate.ddl-auto=update


Crie o banco antes de rodar:
CREATE DATABASE estoque_ccxp;


A aplicação ficará disponível em:
http://localhost:8080/equipamentos/omelete

📂 Estrutura do Projeto
src/main/java/br/com/ccxp23/estoque
 ├── controller/
 ├── exception/
 ├── service/
 ├── repository/
 ├── model/
 └── EstoqueCcxp23Application.java


🔧 Próximos passos (melhorias possíveis)
-Implementar autenticação com Spring Security
-Adicionar paginação e filtros avançados
-Criar API REST paralela (além do Thymeleaf)
-Incluir testes automatizados (JUnit + Spring Boot Test)
-Containerizar com Docker

👤 Autor
Peterson Bersanetti
LinkedIn: petersonbersanetti
GitHub: petersonbersanetti
```

## 🖼️ Telas da aplicação

![image](https://github.com/petersonbersanetti/controleDeEstoqueCCXP23/assets/74914733/717e09d8-2659-4678-a73d-373b89183fcb)

![image](https://github.com/petersonbersanetti/controleDeEstoqueCCXP23/assets/74914733/ad1dcfc6-7b2d-46ef-b3ba-71055a7e4c27)

![image](https://github.com/petersonbersanetti/controleDeEstoqueCCXP23/assets/74914733/79324742-614d-4a17-ab84-d3b7f1b2e4db)

![image](https://github.com/petersonbersanetti/controleDeEstoqueCCXP23/assets/74914733/b44f58ad-6b2e-4fc0-ae4b-cc4b791d5809)

![image](https://github.com/petersonbersanetti/controleDeEstoqueCCXP23/assets/74914733/ad3d560d-63f7-4f9a-ac51-9385513c00d0)




