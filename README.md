# 💼 Gerenciador de Clientes

Bem-vindo ao **Gerenciador de Clientes**! Este projeto é uma aplicação em Java criada para gerenciar clientes de maneira eficiente e intuitiva, com funcionalidades que permitem o cadastro, busca, atualização e remoção de clientes. Vamos conferir as funcionalidades e o que torna este gerenciador tão interessante? 👀

## 🚀 Funcionalidades

- **Cadastro Simples e Rápido**: Insira nome, email e telefone para adicionar um cliente ao sistema.
- **Busca pelo ID**: Quer saber mais sobre um cliente específico? Encontre-o facilmente pelo ID.
- **Atualização Personalizável**: Modifique apenas os campos necessários de um cliente, mantendo os dados que deseja.
- **Remoção Segura**: Exclua clientes que não estão mais ativos, garantindo um banco de dados sempre atualizado.
- **Lista Completa de Clientes**: Visualize uma lista de todos os clientes cadastrados e suas informações.
- **Geração de Clientes Fictícios**: Para teste e diversão, o sistema pode gerar clientes fictícios, ajudando a simular situações reais sem precisar adicionar cada cliente manualmente!

## 📋 Pré-requisitos

Para rodar o projeto, você precisa do seguinte:
- **Java 8+**
- IDE como IntelliJ, Eclipse, ou simplesmente seu terminal favorito
- (Opcional) **Maven** se quiser facilitar a configuração do projeto

## 🌟 Destaques do Código

O projeto foi desenvolvido com a preocupação de oferecer uma **interface de linha de comando clara e amigável**, e usa técnicas para tornar o código limpo e de fácil entendimento, incluindo:

- **Tratamento de Exceções**: Evita problemas comuns com entradas inválidas e erros inesperados.
- **Métodos Bem Nomeados**: Com nomes autoexplicativos e fáceis de entender.
- **Limpeza Automática do Console**: Para uma experiência visual mais limpa durante a navegação.

### Estrutura de Classes

- **GerenciadorDeClientes**: A classe principal que cuida das operações com os clientes.
- **Cliente**: Uma representação de um cliente, contendo ID, nome, email e telefone.
  
Esse design modular facilita tanto o uso quanto futuras expansões. ✨

## 📸 Exemplo de Uso

Ao rodar o sistema, você verá o menu principal:

```
--- Menu ---
1. Cadastrar Cliente
2. Listar Clientes
3. Atualizar Cliente
4. Remover Cliente
5. Buscar Cliente
6. Sair
Escolha uma opção:
```

### Exemplos de Interação

**Cadastrar um novo cliente**: Informe o nome, email e telefone, e pronto! O cliente é adicionado com um ID exclusivo.

**Buscar um cliente pelo ID**: Digite o ID do cliente que quer visualizar, e os dados completos dele serão mostrados no console.

**Atualizar informações**: Informe o ID do cliente e só os campos que deseja alterar. Pode deixar os demais em branco. 🎉
