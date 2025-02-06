-- Inserindo Usuários (4 Admins, 6 Users)
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil) VALUE (1, 'Carlos Silva', 'carlos.silva@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'ADMIN');
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil) VALUE (2, 'Fernanda Souza', 'fernanda.souza@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'ADMIN');
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil) VALUE (3, 'Rafael Costa', 'rafael.costa@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'ADMIN');
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil) VALUE (4, 'Juliana Mendes', 'juliana.mendes@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'ADMIN');
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil) VALUE (5, 'Lucas Rezende', 'lucas.rezende@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'USER');
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil) VALUE (6, 'Mariana Oliveira', 'mariana.oliveira@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'USER');
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil) VALUE (7, 'Thiago Almeida', 'thiago.almeida@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'USER');
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil) VALUE (8, 'Patrícia Lima', 'patricia.lima@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'USER');
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil) VALUE (9, 'Gabriel Santos', 'gabriel.santos@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'USER');
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil) VALUE (10, 'Amanda Rocha', 'amanda.rocha@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'USER');

-- Inserindo Projetos
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (1, 'Programa de Trainee 2025', 'Programa para novos talentos', '2025-01-01', '2025-06-30', 'EM ANDAMENTO', 1, NOW(), 'ALTA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (2, 'Sistema de Gestão ERP', 'Desenvolvimento de um ERP para empresas', '2025-02-01', '2025-12-31', 'PLANEJADO', 2, NOW(), 'ALTA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (3, 'Aplicativo Mobile', 'Criação de um app mobile para clientes', '2025-03-15', '2025-09-30', 'PLANEJADO', 3, NOW(), 'MEDIA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (4, 'Plataforma de E-commerce', 'Desenvolvimento de um sistema de e-commerce', '2025-04-01', '2025-10-31', 'PLANEJADO', 4, NOW(), 'ALTA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (5, 'Dashboard de Relatórios', 'Sistema para relatórios gerenciais', '2025-05-01', '2025-11-30', 'PLANEJADO', 5, NOW(), 'BAIXA');

-- Inserindo Atividades
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (1, 1, 'Recrutamento', 'Triagem de candidatos', '2025-01-05', '2025-01-20', 'CONCLUIDA', 6, NOW());
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (2, 1, 'Treinamento Técnico', 'Capacitação dos trainees', '2025-01-21', '2025-03-30', 'EM_ANDAMENTO', 7, NOW());
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (3, 1, 'Desenvolvimento de Prova', 'Criação da prova final', '2025-04-01', '2025-05-15', 'PLANEJADO', 8, NOW());
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (4, 2, 'Arquitetura do ERP', 'Definição da arquitetura', '2025-02-05', '2025-03-10', 'PLANEJADO', 9, NOW());
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (5, 2, 'Desenvolvimento Backend', 'Implementação dos serviços', '2025-03-11', '2025-06-30', 'PLANEJADO', 10, NOW());

-- Inserindo Lançamentos de Horas
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (1, 1, 6, 'Análise de currículos', '2025-01-05', '2025-01-06', NOW());
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (2, 1, 7, 'Entrevistas com candidatos', '2025-01-07', '2025-01-10', NOW());
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (3, 2, 8, 'Preparação de material didático', '2025-01-21', '2025-01-25', NOW());
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (4, 2, 9, 'Aulas práticas de desenvolvimento', '2025-01-26', '2025-02-10', NOW());
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (5, 4, 10, 'Modelagem do banco de dados ERP', '2025-02-06', '2025-02-12', NOW());

-- Inserindo Participação de Usuários nos Projetos
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (1, 6, 1, '2025-01-01');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (2, 7, 1, '2025-01-05');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (3, 8, 1, '2025-01-10');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (4, 9, 2, '2025-02-01');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (5, 10, 2, '2025-02-05');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (6, 5, 3, '2025-03-15');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (7, 6, 3, '2025-03-20');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (8, 7, 4, '2025-04-01');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (9, 8, 4, '2025-04-05');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (10, 9, 5, '2025-05-01');