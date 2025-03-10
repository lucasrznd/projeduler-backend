DROP TABLE IF EXISTS tb_lancamento_hora;
DROP TABLE IF EXISTS tb_usuario_projeto;
DROP TABLE IF EXISTS tb_usuario_atividade;
DROP TABLE IF EXISTS tb_notificacao;
DROP TABLE IF EXISTS tb_atividade;
DROP TABLE IF EXISTS tb_projeto;
DROP TABLE IF EXISTS tb_usuario;

CREATE TABLE tb_usuario
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome          VARCHAR(150) NOT NULL,
    email         VARCHAR(100) NOT NULL UNIQUE,
    senha         VARCHAR(255) NOT NULL,
    data_criacao  DATETIME     NOT NULL,
    ultimo_login  DATETIME,
    perfil        VARCHAR(30)  NOT NULL,
    ativo         TINYINT      NOT NULL,
    data_exclusao DATETIME
);

CREATE TABLE tb_projeto
(
    id                     BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome                   VARCHAR(100) NOT NULL,
    descricao              TEXT,
    data_inicio            DATE,
    data_fim               DATE,
    status                 VARCHAR(50),
    usuario_responsavel_id BIGINT       NOT NULL,
    data_criacao           DATETIME     NOT NULL,
    prioridade             VARCHAR(20),
    ativo                  TINYINT      NOT NULL,
    data_exclusao          DATETIME
);

CREATE TABLE tb_usuario_projeto
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    usuario_id   BIGINT   NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES tb_usuario (id),
    projeto_id   BIGINT   NOT NULL,
    FOREIGN KEY (projeto_id) REFERENCES tb_projeto (id),
    data_entrada DATETIME NOT NULL,
    ativo         TINYINT  NOT NULL,
    data_exclusao DATETIME
);

CREATE TABLE tb_atividade
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    projeto_id   BIGINT       NOT NULL,
    FOREIGN KEY (projeto_id) REFERENCES tb_projeto (id),
    nome         VARCHAR(100) NOT NULL,
    descricao    TEXT,
    data_inicio  DATE,
    data_fim     DATE,
    status       VARCHAR(50),
    data_criacao DATETIME     NOT NULL,
    ativo         TINYINT  NOT NULL,
    data_exclusao DATETIME
);

CREATE TABLE tb_usuario_atividade
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    usuario_id   BIGINT   NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES tb_usuario (id),
    atividade_id BIGINT   NOT NULL,
    FOREIGN KEY (atividade_id) REFERENCES tb_atividade (id),
    data_entrada DATETIME NOT NULL,
    ativo         TINYINT  NOT NULL,
    data_exclusao DATETIME
);

CREATE TABLE tb_lancamento_hora
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    atividade_id  BIGINT   NOT NULL,
    FOREIGN KEY (atividade_id) REFERENCES tb_atividade (id),
    usuario_id    BIGINT   NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES tb_usuario (id),
    descricao     TEXT,
    data_inicio   DATETIME,
    data_fim      DATETIME,
    data_registro DATETIME NOT NULL
);

CREATE TABLE tb_notificacao
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    usuario_id   BIGINT      NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES tb_usuario (id),
    mensagem     TEXT        NOT NULL,
    tipo         VARCHAR(50) NOT NULL,
    data_criacao DATETIME    NOT NULL,
    lida         BOOLEAN     NOT NULL DEFAULT FALSE,
    projeto_id   BIGINT,
    FOREIGN KEY (projeto_id) REFERENCES tb_projeto (id),
    atividade_id BIGINT,
    FOREIGN KEY (atividade_id) REFERENCES tb_atividade (id)
);