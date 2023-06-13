# CRUD-de-Matriculas

Neste trabalho, cada grupo terá que desenvolver um sistema para cadastro de matrículas de estudantes, também conhecido popularmente como CRUD (Create, Retrieve, Update, Delete), referindo-se as quatro operações fundamentais de um sistema de cadastro: criação, recuperação, atualização e remoção. O sistema deverá ser implementado segundo o paradigma de programação orientada a objetos, utilizando a linguagem de programação Java. O sistema deverá também possuir uma interface gráfica de usuário (GUI - Graphical User Interface), utilizando a biblioteca Java Swing, e estar integrada a um banco de dados MySQL.

## Funcionamento do Sistema
A tela inicial do sistema deverá exibir uma tabela com os estudantes cadastrados no sistema. Nesta tabela, devem constar todas as informações do estudante, exceto seu usuário e senha. Esta tela também deve possuir uma opção para cadastrar um novo estudante no sistema (criação), uma opção para atualizar um estudante já cadastrado (selecionado na tabela) e uma opção para remover um estudante já cadastrado (selecionado na tabela). Ao solicitar a remoção de um estudante cadastrado, o sistema deve solicitar a confirmação do usuário antes de proceder com a exclusão do cadastro. O cadastro de cada estudante deve conter as seguintes informações:

- Nome completo (obrigatório);
- Idade na matrícula (anos completos; obrigatório);
- E-mail (obrigatório);
- Endereço (obrigatório);
- CEP;
- Telefone;
- Usuário (para acesso ao sistema acadêmico; obrigatório);
- Senha (para acesso ao sistema acadêmico; obrigatório);
- Curso (de um conjunto de opções previamente cadastradas; obrigatório);
- Observações (texto livre);
- Ativo (sim/não; obrigatório).
- O sistema deve utilizar caixas de diálogo para avisar o preenchimento incorreto de campos e informar erros no sistema.

## Requisitos Técnicos
- O trabalho deve ser desenvolvido em grupos de 04 (quatro) integrantes;
- O trabalho deve ser desenvolvido em Java;
- A GUI deve ser implementada em Java Swing;
- O sistema deve estar integrado a um banco de dados MySQL;
- O desenvolvimento deve seguir os princípios do paradigma de programação orientada a objetos.

## Avaliação
Esta atividade avaliativa consiste de duas entregas: o código-fonte do sistema e a apresentação.

**Código-fonte:** A avaliação do código-fonte corresponde à 60% da nota desta atividade avaliativa e é atribuída igualmente a todos os membros do grupo. Um membro de cada grupo deve postar no AVA, até **19/06/2023 às 19:00**, o link para o repositório do GitHub contendo o programa, acompanhado do nome da Tag/Release que deve ser considerada para avaliação. Postagens realizadas sem Tag/Release terão 0,5 (meio) ponto descontados da nota desta atividade. Postagens realizadas após o horário estipulado perdem 01 (um) ponto na nota desta atividade. Para cada hora adicional de atraso, 01 (um) ponto é descontado da nota desta atividade.

**Apresentação:** A avaliação da apresentação corresponde à 40% da nota desta atividade avaliativa e é atribuída individualmente a cada membro do grupo. As apresentações serão realizadas na sala F21, no dia **19/06/2023 a partir das 19:00**. Cada grupo terá até 05 (cinco) minutos para apresentar seu jogo em funcionamento. Não é necessário slides ou explicação do código durante a apresentação. Após a apresentação, o professor realizará questionamentos a alguns integrantes do grupo, à sua escolha, sobre o código-fonte do sistema. É obrigatória a participação de todos os integrantes do grupo na apresentação do trabalho.

Se identificado plágio no desenvolvimento do sistema, seja de material publicado na Internet, de projeto de colegas ou de ferramentas de geração automática (ex.: ChatGPT), será atribuída nota zero ao trabalho de todos os envolvidos. Se identificado que um dos integrantes do grupo não participou do desenvolvimento do trabalho, este receberá nota zero no trabalho.
