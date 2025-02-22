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
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (6, 'Automação de Processos', 'Projeto para automatizar processos internos', '2025-06-01', '2025-12-31', 'PLANEJADO', 3, NOW(), 'MEDIA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (7, 'Chatbot Inteligente', 'Desenvolvimento de um chatbot com IA', '2025-07-01', '2025-11-30', 'PLANEJADO', 4, NOW(), 'ALTA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (8, 'Sistema de Gestão Financeira', 'Plataforma para controle financeiro de empresas', '2025-08-01', '2026-02-28', 'PLANEJADO', 5, NOW(), 'ALTA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (9, 'Aplicação de Monitoramento', 'Sistema para monitoramento de servidores', '2025-09-01', '2026-01-31', 'PLANEJADO', 6, NOW(), 'MEDIA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (10, 'Plataforma de Ensino Online', 'Desenvolvimento de uma plataforma EAD',
                                           '2025-10-01', '2026-03-31', 'PLANEJADO', 7, NOW(), 'ALTA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (11, 'Sistema de Gestão de RH', 'Plataforma para gerenciamento de Recursos Humanos', '2024-02-01', '2024-07-31', 'CONCLUIDO', 3, '2024-01-10', 'ALTA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (12, 'Plataforma de E-commerce', 'Desenvolvimento de uma loja virtual personalizada', '2024-03-01', '2024-08-15', 'CONCLUIDO', 4, '2024-02-05', 'MEDIA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (13, 'Dashboard de Indicadores', 'Ferramenta para visualização de KPIs', '2024-04-10', '2024-10-30', 'CONCLUIDO', 5, '2024-03-20', 'MEDIA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (14, 'Sistema de Controle de Estoque', 'Projeto para otimizar a gestão de estoque', '2024-05-01', '2024-09-10', 'CANCELADO', 6, '2024-04-01', 'BAIXA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (15, 'Aplicativo de Agendamento', 'App para agendamento de serviços', '2024-06-15', '2024-11-20', 'CANCELADO', 7, '2024-05-05', 'BAIXA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (16, 'Sistema de Atendimento ao Cliente', 'Plataforma para gerenciar tickets de suporte', '2024-01-15', '2024-06-30', 'CONCLUIDO', 2, '2024-01-05', 'ALTA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (17, 'Automação de Processos', 'Ferramenta para automação de workflows empresariais', '2024-02-20', '2024-07-25', 'CONCLUIDO', 3, '2024-02-10', 'MEDIA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (18, 'Aplicativo de Delivery', 'Plataforma para gerenciamento de pedidos', '2024-05-01', NULL, 'EM ANDAMENTO', 4, '2024-04-20', 'ALTA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (19, 'Sistema de Monitoramento', 'Projeto de monitoramento de servidores', '2024-06-15', NULL, 'EM ANDAMENTO', 5, '2024-05-30', 'MEDIA');
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade) VALUE (20, 'Plataforma de Educação Online', 'Sistema de ensino à distância', '2024-07-10', NULL, 'EM ANDAMENTO', 6, '2024-06-25', 'ALTA');

-- Inserindo Atividades
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (1, 1, 'Recrutamento', 'Triagem de candidatos', '2025-01-05', '2025-01-20', 'CONCLUIDA', 6, NOW());
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (2, 1, 'Treinamento Técnico', 'Capacitação dos trainees', '2025-01-21', '2025-03-30', 'EM ANDAMENTO', 7, NOW());
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (3, 1, 'Desenvolvimento de Prova', 'Criação da prova final', '2025-04-01', '2025-05-15', 'ABERTA', 8, NOW());
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (4, 2, 'Arquitetura do ERP', 'Definição da arquitetura', '2025-02-05', '2025-03-10', 'ABERTA', 9, NOW());
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (5, 2, 'Desenvolvimento Backend', 'Implementação dos serviços', '2025-03-11', '2025-06-30', 'ABERTA', 10, NOW());
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (6, 6, 'Mapeamento de Processos', 'Análise e modelagem dos processos internos', '2025-06-05', '2025-07-10', 'ABERTA', 8, NOW());
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (7, 7, 'Desenvolvimento do NLP', 'Implementação da camada de IA para chatbot', '2025-07-10', '2025-09-15', 'ABERTA', 9, NOW());
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (8, 8, 'Definição de Requisitos', 'Levantamento e análise de requisitos do sistema', '2025-08-05', '2025-09-10', 'ABERTA', 10, NOW());
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (9, 9, 'Configuração de Servidores', 'Setup e configuração inicial dos servidores', '2025-09-05', '2025-10-20', 'ABERTA', 6, NOW());
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (10, 10, 'Criação de Conteúdo EAD', 'Produção de materiais didáticos e videoaulas', '2025-10-10', '2025-12-15', 'ABERTA', 7, NOW());
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (11, 11, 'Desenvolvimento do Módulo de Folha de Pagamento', 'Criação do módulo para folha de pagamento', '2024-02-05', '2024-05-30', 'CONCLUIDA', 8, '2024-01-15 08:10:00');
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (12, 11, 'Integração com Banco de Dados', 'Configuração e modelagem do banco de dados', '2024-02-10', '2024-06-15', 'CONCLUIDA', 9, '2024-01-20 09:15:20');
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (13, 12, 'Desenvolvimento do Frontend', 'Criação do frontend da plataforma', '2024-03-05', '2024-07-10', 'CONCLUIDA', 10, '2024-02-10 09:20:15');
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (14, 12, 'Configuração do Gateway de Pagamento', 'Integração com sistemas de pagamento', '2024-04-01', '2024-08-10', 'CONCLUIDA', 6, '2024-03-05 10:58:00');
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (15, 13, 'Criação de Relatórios de Indicadores', 'Desenvolvimento de gráficos e relatórios', '2024-05-01', '2024-10-20', 'CONCLUIDA', 7, '2024-04-10 11:15:00');
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (16, 16, 'Desenvolvimento do Chatbot de Suporte', 'Criação de um chatbot para atendimento automático', '2024-02-01', '2024-04-15', 'CONCLUIDA', 7, '2024-01-25 13:15:00');
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (17, 16, 'Integração com CRM', 'Conexão com sistemas de CRM', '2024-03-10', '2024-05-20', 'CONCLUIDA', 8, '2024-02-15 07:15:00');
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (18, 17, 'Criação de Fluxos de Automação', 'Definição e implementação dos workflows', '2024-02-25', '2024-06-10', 'CONCLUIDA', 9, '2024-02-18 09:22:00');
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (19, 17, 'Testes de Automação', 'Validação dos fluxos automatizados', '2024-04-01', '2024-07-20', 'CONCLUIDA', 10, '2024-03-10 09:50:00');
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (20, 18, 'Desenvolvimento do App Mobile', 'Criação do aplicativo para Android e iOS', '2024-05-05', NULL, 'EM ANDAMENTO', 6, '2024-04-30 10:01:00');
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (21, 18, 'Implementação do Sistema de Pagamentos', 'Integração com gateways de pagamento', '2024-05-20', NULL, 'EM ANDAMENTO', 7, '2024-05-10 08:58:00');
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (22, 19, 'Configuração do Monitoramento de Servidores', 'Setup de ferramentas de monitoramento', '2024-06-20', NULL, 'EM ANDAMENTO', 8, '2024-06-15 14:15:00');
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (23, 19, 'Criação de Alertas Automáticos', 'Configuração de notificações automáticas', '2024-07-01', NULL, 'EM ANDAMENTO', 9, '2024-06-28 13:12:00');
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (24, 20, 'Desenvolvimento da Plataforma Web', 'Implementação do portal educacional', '2024-07-15', NULL, 'EM ANDAMENTO', 10, '2024-07-05 17:15:00');
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id,
                          data_criacao) VALUE (25, 20, 'Criação de Conteúdo Interativo', 'Produção de vídeos e quizzes', '2024-07-20', NULL, 'EM ANDAMENTO', 2, '2024-07-10 16:15:00');

-- Inserindo Lançamentos de Horas
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (1, 1, 6, 'Análise de currículos', '2025-01-05 09:00:00', '2025-01-06 12:00:00', NOW());
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (2, 1, 7, 'Entrevistas com candidatos', '2025-01-07 14:00:00', '2025-01-10 18:00:00', NOW());
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (3, 2, 8, 'Preparação de material didático', '2025-01-21 08:30:00', '2025-01-25 17:30:00', NOW());
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (4, 2, 9, 'Aulas práticas de desenvolvimento', '2025-01-26 10:00:00', '2025-02-10 16:00:00', NOW());
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (5, 4, 10, 'Modelagem do banco de dados ERP', '2025-02-06 09:15:00', '2025-02-12 15:45:00', NOW());
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (6, 6, 8, 'Análise de processos existentes', '2025-06-06 13:00:00', '2025-06-10 17:00:00', NOW());
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (7, 7, 9, 'Treinamento de modelo NLP', '2025-07-15 08:45:00', '2025-07-20 19:00:00', NOW());
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (8, 8, 10, 'Reunião com stakeholders', '2025-08-07 10:30:00', '2025-08-08 14:00:00', NOW());
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (9, 9, 6, 'Configuração de infraestrutura inicial', '2025-09-10 07:50:00', '2025-09-15 18:20:00', NOW());
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (10, 10, 7, 'Gravação de videoaulas', '2025-10-15 09:00:00', '2025-10-20 16:30:00', NOW());
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (11, 11, 8, 'Implementação do cálculo de salários', '2024-02-06 08:00:00', '2024-02-15 18:00:00', '2024-02-16');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (12, 12, 9, 'Modelagem das tabelas do banco', '2024-02-11 10:15:00', '2024-02-20 16:45:00', '2024-02-21');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (13, 13, 10, 'Desenvolvimento do layout responsivo', '2024-03-06 09:30:00', '2024-03-15 17:30:00', '2024-03-16');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (14, 14, 6, 'Teste de integração do gateway de pagamento', '2024-04-02 14:20:00', '2024-04-10 12:10:00', '2024-04-11');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (15, 15, 7, 'Configuração dos filtros de relatórios', '2024-05-02 08:45:00', '2024-05-15 16:20:00', '2024-05-16');

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
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (11, 8, 6, '2025-06-01');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (12, 9, 7, '2025-07-01');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (13, 10, 8, '2025-08-01');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (14, 6, 9, '2025-09-01');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (15, 7, 10, '2025-10-01');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (16, 8, 11, '2024-02-01');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (17, 9, 11, '2024-02-01');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (18, 10, 12, '2024-03-01');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (19, 6, 12, '2024-03-01');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (20, 7, 13, '2024-04-10');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (21, 7, 16, '2024-01-15');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (22, 8, 16, '2024-01-15');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (23, 9, 17, '2024-02-20');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (24, 10, 17, '2024-02-20');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (25, 6, 18, '2024-05-01');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (26, 7, 18, '2024-05-01');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (27, 8, 19, '2024-06-15');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (28, 9, 19, '2024-06-15');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (29, 10, 20, '2024-07-10');
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada) VALUE (30, 2, 20, '2024-07-10');