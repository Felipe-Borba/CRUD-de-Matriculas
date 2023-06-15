CREATE DATABASE crud_app;
USE crud_app;
CREATE TABLE IF NOT EXISTS estudante (
    id int AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade int,
    email VARCHAR(255),
    endereco VARCHAR(255),
    cep VARCHAR(255),
    telefone VARCHAR(255),
    usuario VARCHAR(255),
    senha VARCHAR(255),
    curso VARCHAR(255),
    textolivre VARCHAR(255),
    ativo bool
);