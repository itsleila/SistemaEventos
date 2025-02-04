# API de Gerenciamento de Eventos

Este projeto é uma API desenvolvida em **Java** utilizando **Spring Boot** e **Maven** para gerenciar eventos, agências e localidades. Ele permite a criação, listagem, obtenção e exclusão de eventos e agências.

## 📌 Tecnologias Utilizadas

- **Java** (Spring Boot)
- **Maven**
- **Postman** (para testes de API)

## 📮 Importando a Coleção do Postman

1. Abra o **Postman**
2. Vá em **File > Import**
3. Selecione o arquivo `api-leiila.postman_collection.json`
4. Faça as requisições para testar a API

## 🔗 Endpoints da API

### Eventos

- **Criar Evento**: `POST /api/eventos/incluir`
- **Listar Eventos**: `GET /api/eventos/listar`
- **Obter Evento por ID**: `GET /api/eventos/{id}`
- **Excluir Evento**: `DELETE /api/eventos/{id}/excluir`

### Agências

- **Criar Agência**: `POST /api/agencia/incluir`
- **Listar Agências**: `GET /api/agencia/listar`
- **Obter Agência por ID**: `GET /api/agencia/{id}`
- **Excluir Agência**: `DELETE /api/agencia/{id}/excluir`
