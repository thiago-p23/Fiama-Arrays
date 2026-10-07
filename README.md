# Fiama-Arrays

# Desafio: Sistema Simples de Cache de Pessoas

**FIAMA BRENDA BARBOSA DOS SANTOS**

## Descrição

Este projeto consiste na criação de um sistema simples de cache de pessoas utilizando Java.

A aplicação simula um banco de dados contendo informações de pessoas e um cache responsável por armazenar temporariamente os dados das pessoas que foram pesquisadas recentemente.

Quando o usuário informa o ID de uma pessoa, o sistema primeiro verifica se ela está no cache. Caso esteja, os dados são obtidos diretamente do cache.

Se a pessoa não estiver no cache, o sistema realiza uma busca no banco de dados. Se encontrar a pessoa, seus dados são adicionados ao cache para facilitar futuras consultas.

O cache possui capacidade máxima de 10 pessoas. Quando estiver cheio, a pessoa mais antiga é removida antes que uma nova pessoa seja adicionada.

---

## Objetivo

O objetivo deste desafio é compreender, de forma prática, o funcionamento básico de um sistema de cache e aplicar conceitos de programação em Java.

O exercício trabalha principalmente com:

* Classes e objetos
* Programação Orientada a Objetos
* Encapsulamento
* Construtores
* `ArrayList`
* Estruturas de repetição
* Estruturas condicionais
* `Scanner`
* Busca de dados
* Armazenamento temporário
* Controle de limite de elementos

---

# Instruções do Desafio

## Criar a classe Pessoa

Deve ser criada uma classe chamada `Pessoa` contendo os seguintes atributos:

```java
int id;
String nome;
int idade;
```

Os atributos são utilizados para representar as informações de cada pessoa.

No projeto, eles foram definidos como `private`, aplicando o conceito de encapsulamento:

```java
private int id;
private String nome;
private int idade;
```

A classe também possui um construtor para receber os dados da pessoa.

---

## Criar duas listas na Main

Na classe `Main`, devem ser criadas duas listas:

```java
ArrayList<Pessoa> banco = new ArrayList<>();
ArrayList<Pessoa> cache = new ArrayList<>();
```

### Banco

A lista `banco` representa o banco de dados.

Ela contém os dados das pessoas que podem ser pesquisadas pelo sistema.

### Cache

A lista `cache` representa os dados que foram acessados recentemente.

Quando uma pessoa é encontrada no banco, ela é adicionada ao cache.

---

# Dados Mockados

De acordo com o desafio, o banco deve possuir pelo menos cinco pessoas cadastradas.

Neste projeto foram utilizados os seguintes dados:

```java
banco.add(new Pessoa(1, "João", 25));
banco.add(new Pessoa(2, "Maria", 30));
banco.add(new Pessoa(3, "Carlos", 22));
banco.add(new Pessoa(4, "Ana", 28));
banco.add(new Pessoa(5, "Pedro", 35));
```

Esses dados são chamados de dados mockados, pois são informações criadas apenas para simular um banco de dados real durante o desenvolvimento e os testes do programa.

---

# Funcionamento do Sistema

O funcionamento do programa segue uma ordem específica.

## 1. Solicitar o ID

Primeiro, o sistema solicita ao usuário o ID da pessoa:

```java
System.out.print("Digite o ID da pessoa: ");
int id = scanner.nextInt();
```

O ID informado será utilizado para realizar a busca.

---

## 2. Verificar o cache

Antes de consultar o banco, o sistema verifica se a pessoa já está no cache:

```java
for (Pessoa pessoa : cache) {
    if (pessoa.getId() == id) {
        pessoaEncontrada = pessoa;

        System.out.println(
            "Pessoa encontrada no cache: " + pessoa
        );

        break;
    }
}
```

Essa é a primeira busca realizada pelo programa.

Se a pessoa estiver no cache, o sistema encontra os dados e não precisa consultar o banco.

A mensagem exibida será:

```text
Pessoa encontrada no cache: ...
```

---

## 3. Buscar no banco

Se a pessoa não estiver no cache, o programa realiza uma nova busca na lista `banco`:

```java
for (Pessoa pessoa : banco) {
    if (pessoa.getId() == id) {
        pessoaEncontrada = pessoa;

        ...
        
        break;
    }
}
```

Caso a pessoa seja encontrada, ela será adicionada ao cache.

---

## 4. Adicionar a pessoa ao cache

Quando uma pessoa é encontrada no banco, o sistema verifica primeiro se o cache está cheio.

```java
if (cache.size() >= 10) {
    cache.remove(0);
}
```

Se o cache possuir 10 pessoas, o primeiro elemento da lista será removido.

Depois disso, a nova pessoa será adicionada:

```java
cache.add(pessoa);
```

O programa então informa:

```text
Pessoa buscada no banco e adicionada ao cache: ...
```

---

# Limite do Cache

O desafio determina que o cache pode armazenar no máximo 10 pessoas.

Essa regra é implementada através:

```java
if (cache.size() >= 10) {
    cache.remove(0);
}
```

O método:

```java
cache.size()
```

informa quantas pessoas existem atualmente no cache.

Já:

```java
cache.remove(0);
```

remove o primeiro elemento da lista.

Como as pessoas são adicionadas no final da lista, o primeiro elemento representa a pessoa que está há mais tempo no cache.

Dessa maneira, quando o cache estiver cheio, a pessoa mais antiga será removida para dar espaço à nova pessoa.

---

# Caso a Pessoa Não Exista

Se o ID informado não estiver presente no banco, o sistema não encontrará nenhuma pessoa.

Nesse caso:

```java
if (pessoaEncontrada == null) {
    System.out.println("Pessoa não encontrada.");
}
```

Será exibida a mensagem:

```text
Pessoa não encontrada.
```

---

# Estrutura do Projeto

```text
SistemaCache/
│
├── Main.java
├── Pessoa.java
└── README.md
```

## Main.java

Responsável pela execução do programa.

Suas principais responsabilidades são:

* Criar o `Scanner`
* Criar o banco
* Criar o cache
* Solicitar o ID ao usuário
* Procurar a pessoa no cache
* Procurar a pessoa no banco
* Adicionar pessoas ao cache
* Controlar o limite de 10 pessoas
* Informar o resultado da busca

## Pessoa.java

Representa uma pessoa do sistema.

Possui:

* `id`
* `nome`
* `idade`

Também possui métodos getters para permitir o acesso aos atributos e um método `toString()` para facilitar a exibição dos dados.

---

# Conceitos de Programação Orientada a Objetos

## Encapsulamento

Os atributos da classe `Pessoa` são privados:

```java
private int id;
private String nome;
private int idade;
```

Isso impede que outras classes alterem diretamente os valores dos atributos.

O acesso é realizado através de métodos como:

```java
getId()
getNome()
getidade()
```

---

## Construtor

O construtor permite criar uma pessoa informando seus dados:

```java
public Pessoa(int id, String nome, int idade) {
    this.id = id;
    this.nome = nome;
    this.idade = idade;
}
```

Por exemplo:

```java
new Pessoa(1, "João", 25);
```

Cria uma pessoa com:

```text
ID: 1
Nome: João
Idade: 25
```

---

## ArrayList

O `ArrayList` é utilizado para armazenar várias pessoas.

No projeto existem duas listas:

```java
ArrayList<Pessoa> banco
```

e:

```java
ArrayList<Pessoa> cache
```

Isso permite simular a separação entre os dados permanentes do banco e os dados temporariamente armazenados no cache.

---

# Exemplo de Execução

## Primeira consulta

O usuário informa:

```text
Digite o ID da pessoa: 2
```

Como Maria ainda não está no cache, o sistema procura no banco.

Resultado:

```text
Pessoa buscada no banco e adicionada ao cache:
ID: 2
Nome: Maria
Idade: 30
```

---

## Segunda consulta

Se o usuário pesquisar novamente:

```text
Digite o ID da pessoa: 2
```

Agora Maria já está no cache.

Resultado:

```text
Pessoa encontrada no cache:
ID: 2
Nome: Maria
Idade: 30
```

Nesse caso, o sistema não precisa realizar novamente a busca no banco.

---

## ID inexistente

Se o usuário informar:

```text
Digite o ID da pessoa: 10
```

Como não existe uma pessoa com esse ID no banco, o resultado será:

```text
Pessoa não encontrada.
```

---

# Desafio do Cache

O desafio adicional determina que, quando o cache atingir 10 pessoas, a pessoa mais antiga deve ser removida antes da entrada de uma nova pessoa.

O código responsável por essa regra é:

```java
if (cache.size() >= 10) {
    cache.remove(0);
}

cache.add(pessoa);
```

O funcionamento é:

```text
Cache com 10 pessoas
        ↓
Nova pessoa encontrada
        ↓
Remove a pessoa mais antiga
        ↓
Adiciona a nova pessoa
        ↓
Cache continua com no máximo 10 pessoas
```

---

# Tecnologias Utilizadas

* Java
* `ArrayList`
* `Scanner`
* Programação Orientada a Objetos

---

# Conclusão

O projeto implementa um sistema simples de cache utilizando duas listas para representar um banco de dados e os dados acessados recentemente.

A aplicação primeiro procura a pessoa no cache. Caso não encontre, realiza a busca no banco e adiciona o resultado ao cache.

Além disso, o sistema possui um limite de 10 pessoas no cache. Quando esse limite é atingido, a pessoa mais antiga é removida antes que uma nova pessoa seja adicionada.

O exercício permite compreender na prática como um cache pode evitar buscas repetidas e também reforça conceitos fundamentais de Java e Programação Orientada a Objetos.
