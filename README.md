# trabalho_faculdade-projetoBiblioteca
 
# Sistema de Controle de Biblioteca

## Descrição do Sistema

O sistema foi desenvolvido para gerenciar o empréstimo de livros em uma instituição de ensino, substituindo o controle manual em planilhas.

Permite cadastrar livros e alunos, registrar empréstimos e devoluções, controlar o estoque e evitar inconsistências como empréstimos duplicados ou falta de controle de devolução.

---

## Tabelas Identificadas

### Livro
Armazena os livros disponíveis na biblioteca.

| Campo       | Tipo    | Descrição                         |
|------------|--------|-----------------------------------|
| id         | int    | Identificador único do livro      |
| titulo     | String | Título do livro                   |
| autor      | String | Autor do livro                    |
| quantidade | int    | Quantidade disponível em estoque  |

---

### Aluno
Armazena os dados dos alunos.

| Campo | Tipo    | Descrição             |
|------|--------|-----------------------|
| nome | String | Nome do aluno         |
| ra   | String | Registro acadêmico    |

---

### Emprestimo
Representa o empréstimo de um livro.

| Campo           | Tipo       | Descrição                          |
|----------------|-----------|----------------------------------|
| livro          | Livro     | Livro emprestado                 |
| aluno          | Aluno     | Aluno que realizou o empréstimo |
| dataEmprestimo | LocalDate | Data do empréstimo              |
| dataDevolucao  | LocalDate | Data prevista de devolução      |
| devolvido      | boolean   | Indica se foi devolvido         |

---

## Regras de Negócio

RN01 — Livro deve possuir título válido  
Não é permitido cadastrar livros com título vazio.

RN02 — Quantidade não pode ser negativa  
O sistema não permite cadastrar livros com quantidade negativa.

RN03 — Aluno deve possuir nome e RA válidos  
Não é permitido cadastrar alunos com dados vazios.

RN04 — RA não pode ser duplicado  
Não é permitido cadastrar dois alunos com o mesmo RA.

RN05 — Controle de estoque  
Um livro só pode ser emprestado se houver quantidade disponível.

RN06 — Atualização automática de estoque  
Ao emprestar um livro, a quantidade é reduzida. Ao devolver, é aumentada.

RN07 — Registro de empréstimo  
Todo empréstimo registra automaticamente a data atual.

RN08 — Prazo de devolução automático  
A devolução é definida automaticamente para 7 dias após o empréstimo.

RN09 — Controle de devolução  
O sistema permite marcar um empréstimo como devolvido.

RN10 — Não permitir devolução duplicada  
Não é possível devolver um livro que já foi devolvido.

RN11 — Consulta de empréstimos em aberto  
O sistema lista todos os empréstimos ainda não devolvidos.

RN12 — Busca de livros  
Permite buscar livros por título ou autor.

RN13 — Identificação de empréstimos  
Cada empréstimo pode ser identificado por índice para devolução.

---

## Regras Adicionais

RN14 — Busca flexível de aluno  
O sistema permite buscar alunos por nome, RA ou índice.

RN15 — Relatório detalhado  
O sistema exibe informações completas sobre os empréstimos.

RN16 — Controle de datas formatadas  
A data de devolução é exibida com dia da semana.

---

## Estrutura dos Projetos

ProjetoBiblioteca/  
├── src/  
│   ├── Livro.java  
│   ├── Aluno.java  
│   ├── Emprestimo.java  
│   ├── SistemaBiblioteca.java  
│   └── Main.java  

---

ProjetoBiblioteca_MVC/  
├── controller/  
│   ├── AlunoController.java  
│   ├── EmprestimoController.java  
│   ├── LivroController.java  
├── model/  
│   ├── Livro.java  
│   ├── Aluno.java  
│   ├── Emprestimo.java  
│   └── Repositorio.java  
├── view/  
│   └── Menu.java  
└── Main.java  
