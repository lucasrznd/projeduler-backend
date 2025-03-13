-- Inserindo Usuários (4 Admins, 6 Users)
-- Senha padrão para todos usuários: 1234
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil, ativo) VALUE (1, 'Carlos Silva', 'carlos.silva@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'ADMIN', 1);
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil, ativo) VALUE (2, 'Fernanda Souza', 'fernanda.souza@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'ADMIN', 1);
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil, ativo) VALUE (3, 'Rafael Costa', 'rafael.costa@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'ADMIN', 1);
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil, ativo) VALUE (4, 'Juliana Mendes', 'juliana.mendes@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'ADMIN', 1);
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil, ativo) VALUE (5, 'Lucas Rezende', 'lucas.rezende@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'USER', 1);
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil, ativo) VALUE (6, 'Mariana Oliveira', 'mariana.oliveira@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'USER', 1);
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil, ativo) VALUE (7, 'Thiago Almeida', 'thiago.almeida@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'USER', 1);
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil, ativo) VALUE (8, 'Patrícia Lima', 'patricia.lima@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'USER', 1);
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil, ativo) VALUE (9, 'Gabriel Santos', 'gabriel.santos@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'USER', 1);
INSERT INTO tb_usuario (id, nome, email, senha, data_criacao, ultimo_login, perfil, ativo) VALUE (10, 'Amanda Rocha', 'amanda.rocha@email.com', '$2a$10$gNvkDBhwwZsb6XYb9xeQ0e6xWlBj7Qn9rU2rhVeH9gpVEQE5h5hYm', NOW(), NOW(), 'USER', 1);

-- Inserindo Projetos
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (1, '[P001] Programa de Trainee 2025', 'Programa para novos talentos', '2025-01-01', '2025-06-30', 'EM ANDAMENTO', 1, NOW(), 'ALTA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (2, '[P002] Sistema de Gestão ERP', 'Desenvolvimento de um ERP para empresas', '2025-02-01', '2025-12-31', 'PLANEJADO', 2, NOW(), 'ALTA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (3, '[P003] Aplicativo Mobile', 'Criação de um app mobile para clientes', '2025-03-15', '2025-09-30', 'PLANEJADO', 3, NOW(), 'MEDIA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (4, '[P004] Plataforma de E-commerce', 'Desenvolvimento de um sistema de e-commerce', '2025-04-01', '2025-10-31', 'PLANEJADO', 4, NOW(), 'ALTA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (5, '[P005] Dashboard de Relatórios', 'Sistema para relatórios gerenciais', '2025-05-01', '2025-11-30', 'PLANEJADO', 5, NOW(), 'BAIXA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (6, '[P006] Automação de Processos', 'Projeto para automatizar processos internos', '2025-06-01', '2025-12-31', 'PLANEJADO', 3, NOW(), 'MEDIA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (7, '[P007] Chatbot Inteligente', 'Desenvolvimento de um chatbot com IA', '2025-07-01', '2025-11-30', 'PLANEJADO', 4, NOW(), 'ALTA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (8, '[P008] Sistema de Gestão Financeira', 'Plataforma para controle financeiro de empresas', '2025-08-01', '2026-02-28', 'PLANEJADO', 5, NOW(), 'ALTA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (9, '[P009] Aplicação de Monitoramento', 'Sistema para monitoramento de servidores', '2025-09-01', '2026-01-31', 'PLANEJADO', 6, NOW(), 'MEDIA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (10, '[P010] Plataforma de Ensino Online', 'Desenvolvimento de uma plataforma EAD', '2025-10-01', '2026-03-31', 'PLANEJADO', 7, NOW(), 'ALTA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (11, '[P011] Sistema de Gestão de RH', 'Plataforma para gerenciamento de Recursos Humanos', '2024-02-01', '2024-07-31', 'CONCLUIDO', 3, '2024-01-10', 'ALTA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (12, '[P012] Plataforma de E-commerce', 'Desenvolvimento de uma loja virtual personalizada', '2024-03-01', '2024-08-15', 'CONCLUIDO', 4, '2024-02-05', 'MEDIA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (13, '[P013] Dashboard de Indicadores', 'Ferramenta para visualização de KPIs', '2024-04-10', '2024-10-30', 'CONCLUIDO', 5, '2024-03-20', 'MEDIA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (14, '[P014] Sistema de Controle de Estoque', 'Projeto para otimizar a gestão de estoque', '2024-05-01', '2024-09-10', 'CANCELADO', 6, '2024-04-01', 'BAIXA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (15, '[P015] Aplicativo de Agendamento', 'App para agendamento de serviços', '2024-06-15', '2024-11-20', 'CANCELADO', 7, '2024-05-05', 'BAIXA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (16, '[P016] Sistema de Atendimento ao Cliente', 'Plataforma para gerenciar tickets de suporte', '2024-01-15', '2024-06-30', 'CONCLUIDO', 2, '2024-01-05', 'ALTA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (17, '[P017] Automação de Processos', 'Ferramenta para automação de workflows empresariais', '2024-02-20', '2024-07-25', 'CONCLUIDO', 3, '2024-02-10', 'MEDIA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (18, '[P018] Aplicativo de Delivery', 'Plataforma para gerenciamento de pedidos', '2024-05-01', NULL, 'EM ANDAMENTO', 4, '2024-04-20', 'ALTA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (19, '[P019] Sistema de Monitoramento', 'Projeto de monitoramento de servidores', '2024-06-15', NULL, 'EM ANDAMENTO', 5, '2024-05-30', 'MEDIA', 1);
INSERT INTO tb_projeto (id, nome, descricao, data_inicio, data_fim, status, usuario_responsavel_id, data_criacao,
                        prioridade,
                        ativo) VALUE (20, '[P020] Plataforma de Educação Online', 'Sistema de ensino à distância', '2024-07-10', NULL, 'EM ANDAMENTO', 6, '2024-06-25', 'ALTA', 1);

-- Inserindo Participação de Usuários nos Projetos
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (1, 6, 1, '2025-01-01', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (2, 7, 1, '2025-01-05', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (3, 8, 1, '2025-01-10', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (4, 9, 2, '2025-02-01', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (5, 10, 2, '2025-02-05', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (6, 5, 3, '2025-03-15', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (7, 6, 3, '2025-03-20', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (8, 7, 4, '2025-04-01', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (9, 8, 4, '2025-04-05', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (10, 9, 5, '2025-05-01', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (11, 8, 6, '2025-06-01', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (12, 9, 7, '2025-07-01', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (13, 10, 8, '2025-08-01', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (14, 6, 9, '2025-09-01', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (15, 7, 10, '2025-10-01', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (16, 8, 11, '2024-02-01', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (17, 9, 11, '2024-02-01', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (18, 10, 12, '2024-03-01', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (19, 6, 12, '2024-03-01', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (20, 7, 13, '2024-04-10', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (21, 7, 16, '2024-01-15', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (22, 8, 16, '2024-01-15', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (23, 9, 17, '2024-02-20', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (24, 10, 17, '2024-02-20', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (25, 6, 18, '2024-05-01', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (26, 7, 18, '2024-05-01', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (27, 8, 19, '2024-06-15', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (28, 9, 19, '2024-06-15', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (29, 10, 20, '2024-07-10', 1);
INSERT INTO tb_usuario_projeto (id, usuario_id, projeto_id, data_entrada, ativo) VALUE (30, 2, 20, '2024-07-10', 1);

-- Inserindo Atividades
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (1, 1, 'Recrutamento', 'Triagem de candidatos', '2025-01-05', '2025-01-20', 'CONCLUIDA', NOW(), 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (2, 1, 'Treinamento Técnico', 'Capacitação dos trainees', '2025-01-21', '2025-03-30', 'EM ANDAMENTO', NOW(), 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (3, 1, 'Desenvolvimento de Prova', 'Criação da prova final', '2025-04-01', '2025-05-15', 'ABERTA', NOW(), 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (4, 2, 'Arquitetura do ERP', 'Definição da arquitetura', '2025-02-05', '2025-03-10', 'ABERTA', NOW(), 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (5, 2, 'Desenvolvimento Backend', 'Implementação dos serviços', '2025-03-11', '2025-06-30', 'ABERTA', NOW(), 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (6, 6, 'Mapeamento de Processos', 'Análise e modelagem dos processos internos', '2025-06-05', '2025-07-10', 'ABERTA', NOW(), 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (7, 7, 'Desenvolvimento do NLP', 'Implementação da camada de IA para chatbot', '2025-07-10', '2025-09-15', 'ABERTA', NOW(), 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (8, 8, 'Definição de Requisitos', 'Levantamento e análise de requisitos do sistema', '2025-08-05', '2025-09-10', 'ABERTA', NOW(), 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (9, 9, 'Configuração de Servidores', 'Setup e configuração inicial dos servidores', '2025-09-05', '2025-10-20', 'ABERTA', NOW(), 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (10, 10, 'Criação de Conteúdo EAD', 'Produção de materiais didáticos e videoaulas', '2025-10-10', '2025-12-15', 'ABERTA', NOW(), 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (11, 11, 'Desenvolvimento do Módulo de Folha de Pagamento', 'Criação do módulo para folha de pagamento', '2024-02-05', '2024-05-30', 'CONCLUIDA', '2024-01-15 08:10:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (12, 11, 'Integração com Banco de Dados', 'Configuração e modelagem do banco de dados', '2024-02-10', '2024-06-15', 'CONCLUIDA', '2024-01-20 09:15:20', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (13, 12, 'Desenvolvimento do Frontend', 'Criação do frontend da plataforma', '2024-03-05', '2024-07-10', 'CONCLUIDA', '2024-02-10 09:20:15', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (14, 12, 'Configuração do Gateway de Pagamento', 'Integração com sistemas de pagamento', '2024-04-01', '2024-08-10', 'CONCLUIDA', '2024-03-05 10:58:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (15, 13, 'Criação de Relatórios de Indicadores', 'Desenvolvimento de gráficos e relatórios', '2024-05-01', '2024-10-20', 'CONCLUIDA', '2024-04-10 11:15:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (16, 16, 'Desenvolvimento do Chatbot de Suporte', 'Criação de um chatbot para atendimento automático', '2024-02-01', '2024-04-15', 'CONCLUIDA', '2024-01-25 13:15:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (17, 16, 'Integração com CRM', 'Conexão com sistemas de CRM', '2024-03-10', '2024-05-20', 'CONCLUIDA', '2024-02-15 07:15:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (18, 17, 'Criação de Fluxos de Automação', 'Definição e implementação dos workflows', '2024-02-25', '2024-06-10', 'CONCLUIDA', '2024-02-18 09:22:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (19, 17, 'Testes de Automação', 'Validação dos fluxos automatizados', '2024-04-01', '2024-07-20', 'CONCLUIDA', '2024-03-10 09:50:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (20, 18, 'Desenvolvimento do App Mobile', 'Criação do aplicativo para Android e iOS', '2024-05-05', NULL, 'EM ANDAMENTO', '2024-04-30 10:01:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (21, 18, 'Implementação do Sistema de Pagamentos', 'Integração com gateways de pagamento', '2024-05-20', NULL, 'EM ANDAMENTO', '2024-05-10 08:58:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (22, 19, 'Configuração do Monitoramento de Servidores', 'Setup de ferramentas de monitoramento', '2024-06-20', NULL, 'EM ANDAMENTO', '2024-06-15 14:15:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (23, 19, 'Criação de Alertas Automáticos', 'Configuração de notificações automáticas', '2024-07-01', NULL, 'EM ANDAMENTO', '2024-06-28 13:12:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (24, 20, 'Desenvolvimento da Plataforma Web', 'Implementação do portal educacional', '2024-07-15', NULL, 'EM ANDAMENTO', '2024-07-05 17:15:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (25, 20, 'Criação de Conteúdo Interativo', 'Produção de vídeos e quizzes', '2024-07-20', NULL, 'EM ANDAMENTO', '2024-07-10 16:15:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (26, 1, 'Onboarding de Novos Trainees', 'Introdução ao programa de trainee', '2025-02-21', '2025-02-25', 'EM ANDAMENTO', '2025-02-19 15:00:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (27, 3, 'Protótipo UI Aplicativo', 'Criação do design do app mobile', '2025-02-23', '2025-02-28', 'PLANEJADO', '2025-02-21 09:00:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (28, 4, 'Estratégia de Vendas E-commerce', 'Planejamento comercial do e-commerce', '2025-02-24', '2025-02-27', 'PLANEJADO', '2025-02-22 16:20:12', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (29, 5, 'Dashboard de KPIs', 'Definição dos indicadores no dashboard', '2025-02-25', '2025-02-28', 'PLANEJADO', '2025-02-23 12:20:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (30, 6, 'Automação de Relatórios', 'Criação de scripts para automação', '2025-02-26', '2025-03-01', 'PLANEJADO', '2025-02-15 13:40:20', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (31, 7, 'Treinamento IA Chatbot', 'Configuração inicial do chatbot', '2025-02-27', '2025-03-03', 'PLANEJADO', '2025-01-30 15:30:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (32, 8, 'Configuração de Contas Financeiras', 'Integração com APIs bancárias', '2025-02-28', '2025-03-04', 'PLANEJADO', '2025-02-25 08:00:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (33, 9, 'Monitoramento de Servidores','Definição de métricas para monitoramento', '2025-03-01', '2025-03-06','PLANEJADO', '2025-02-21 08:40:00', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (34, 9, 'Monitoramento de Servidores', 'Definição de métricas para monitoramento', '2025-03-01', '2025-03-06', 'PLANEJADO', '2025-02-27 12:45:21', 1);
INSERT INTO tb_atividade (id, projeto_id, nome, descricao, data_inicio, data_fim, status,
                          data_criacao,
                          ativo) VALUE (35, 10, 'Implementação de Gamificação', 'Criação de sistema de pontos na plataforma EAD', '2025-03-02', '2025-03-07', 'PLANEJADO', '2025-03-01 09:00:00', 1);

-- Inserindo relações entre usuários e atividades
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (6, 1, '2025-01-05 08:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (7, 2, '2025-01-21 09:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (8, 3, '2025-04-01 10:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (9, 4, '2025-02-05 11:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (10, 5, '2025-03-11 12:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (8, 6, '2025-06-05 13:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (9, 7, '2025-07-10 14:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (10, 8, '2025-08-05 15:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (6, 9, '2025-09-05 16:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (7, 10, '2025-10-10 17:00:00', 1);

-- Adicionando múltiplos usuários para algumas atividades
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (6, 3, '2025-04-02 08:30:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (7, 3, '2025-04-02 08:45:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (8, 5, '2025-03-12 09:15:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (9, 6, '2025-06-06 10:20:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (10, 7, '2025-07-11 11:30:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (6, 8, '2025-08-06 12:40:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (7, 9, '2025-09-06 13:50:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (8, 10, '2025-10-11 14:55:00', 1);

-- Inserindo usuários para atividades concluídas
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (8, 11, '2024-02-05 08:10:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (9, 12, '2024-02-10 09:15:20', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (10, 13, '2024-03-05 09:20:15', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (6, 14, '2024-04-01 10:58:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (7, 15, '2024-05-01 11:15:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (7, 16, '2024-02-01 13:15:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (8, 17, '2024-03-10 07:15:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (9, 18, '2024-02-25 09:22:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (10, 19, '2024-04-01 09:50:00', 1);

-- Adicionando usuários em atividades em andamento
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (6, 20, '2024-05-05 10:01:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (7, 21, '2024-05-20 08:58:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (8, 22, '2024-06-20 14:15:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (9, 23, '2024-07-01 13:12:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (10, 24, '2024-07-15 17:15:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (2, 25, '2024-07-20 16:15:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (5, 26, '2025-02-21 09:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (6, 27, '2025-02-22 10:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (7, 28, '2025-02-23 11:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (8, 29, '2025-02-24 09:30:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (9, 30, '2025-02-25 14:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (5, 31, '2025-02-26 08:45:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (6, 32, '2025-02-27 13:15:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (7, 33, '2025-02-28 09:45:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (8, 34, '2025-03-01 10:30:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (9, 35, '2025-03-02 15:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (5, 11, '2025-03-10 08:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (6, 12, '2025-03-10 09:30:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (7, 13, '2025-03-11 10:15:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (8, 14, '2025-03-11 14:45:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (9, 15, '2025-03-12 08:30:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (5, 16, '2025-03-12 13:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (6, 17, '2025-03-13 09:00:00', 1);
INSERT INTO tb_usuario_atividade (usuario_id, atividade_id, data_entrada, ativo) VALUE (7, 18, '2025-03-13 15:30:00', 1);

-- Inserindo Lançamentos de Horas
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (1, 1, 6, 'Análise de currículos', '2025-01-05 09:00:00', '2025-01-05 12:00:00', '2025-01-06 08:00:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (2, 1, 7, 'Entrevistas com candidatos', '2025-01-07 14:00:00', '2025-01-07 18:00:00', '2025-01-07 19:00:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (3, 2, 8, 'Preparação de material didático', '2025-01-21 08:30:00', '2025-01-21 17:30:00', '2025-01-21 17:35:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (4, 2, 9, 'Aulas práticas de desenvolvimento', '2025-01-26 10:00:00', '2025-01-26 16:00:00', '2025-01-26 17:00:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (5, 4, 10, 'Modelagem do banco de dados ERP', '2025-02-06 09:15:00', '2025-02-06 15:45:00', '2025-02-06 15:48:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (6, 6, 8, 'Análise de processos existentes', '2025-03-09 13:00:00', '2025-03-09 17:00:00', '2025-03-09 17:01:20');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (7, 7, 9, 'Treinamento de modelo NLP', '2025-03-08 08:45:00', '2025-03-08 19:00:00', '2025-03-08 19:10:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (8, 8, 10, 'Reunião com stakeholders', '2025-03-06 10:30:00', '2025-03-06 14:00:00', '2025-03-06 14:05:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (9, 9, 6, 'Configuração de infraestrutura inicial', '2025-03-05 07:50:00', '2025-03-05 18:20:00', '2025-03-05 18:25:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (10, 10, 7, 'Gravação de videoaulas', '2025-03-12 09:00:00', '2025-03-12 16:30:00', '2025-03-12 16:31:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (11, 11, 8, 'Implementação do cálculo de salários', '2024-02-06 08:00:00', '2024-02-06 18:00:00', '2024-02-06 18:03:10');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (12, 12, 9, 'Modelagem das tabelas do banco', '2024-02-11 10:15:00', '2024-02-11 16:45:00', '2024-02-11 16:50:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (13, 13, 10, 'Desenvolvimento do layout responsivo', '2024-03-06 09:30:00', '2024-03-06 17:30:00', '2024-03-06 17:35:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (14, 14, 6, 'Teste de integração do gateway de pagamento', '2024-04-02 14:20:00', '2024-04-02 12:10:00', '2024-04-02 12:30:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (15, 15, 7, 'Configuração dos filtros de relatórios', '2024-05-02 08:45:00', '2024-05-02 16:20:00', '2024-05-02 16:22:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (16, 26, 5, 'Participação no treinamento inicial', '2025-02-21 09:00:00', '2025-02-21 12:00:00', '2025-02-21 12:10:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (17, 27, 6, 'Análise de requisitos para modelagem', '2025-02-22 10:00:00', '2025-02-22 13:00:00', '2025-02-22 13:20:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (18, 28, 7, 'Desenvolvimento do protótipo inicial', '2025-02-23 11:00:00', '2025-02-23 14:30:00', '2025-02-23 14:35:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (19, 29, 8, 'Discussão de estratégia comercial', '2025-02-24 09:30:00', '2025-02-24 12:30:00', '2025-02-24 13:30:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (20, 30, 9, 'Definição de métricas para dashboard', '2025-02-25 14:00:00', '2025-02-25 17:00:00', '2025-02-25 17:50:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (21, 31, 5, 'Automatização de processos de relatórios', '2025-02-26 08:45:00', '2025-02-26 12:00:00', '2025-02-26 13:00:12');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (22, 32, 6, 'Testes e ajustes no chatbot', '2025-02-27 13:15:00', '2025-02-27 16:30:00', '2025-02-27 16:31:12');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (23, 33, 7, 'Configuração de contas financeiras', '2025-02-28 09:45:00', '2025-02-28 13:00:00', '2025-02-28 13:30:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (24, 34, 8, 'Definição de alertas no monitoramento', '2025-03-01 10:30:00', '2025-03-01 14:30:00', '2025-03-01 14:35:45');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (25, 35, 9, 'Planejamento da gamificação da plataforma', '2025-03-02 15:00:00', '2025-03-02 18:00:00', '2025-03-02 18:10:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (26, 11, 5, 'Análise de feedbacks do onboarding', '2025-03-10 08:00:00', '2025-03-10 11:00:00', '2025-03-10 11:30:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (27, 12, 6, 'Modelagem de tabelas adicionais', '2025-03-10 09:30:00', '2025-03-10 12:30:00', '2025-03-10 12:45:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (28, 13, 7, 'Ajustes no protótipo do UI', '2025-03-11 10:15:00', '2025-03-11 13:15:00', '2025-03-11 13:30:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (29, 14, 8, 'Definição de estratégias para campanhas', '2025-03-11 14:45:00', '2025-03-11 17:30:00', '2025-03-11 17:45:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (30, 15, 9, 'Configuração de gráficos no dashboard', '2025-03-12 08:30:00', '2025-03-12 11:30:00', '2025-03-12 11:45:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (31, 16, 5, 'Correção de bugs nos scripts de automação', '2025-03-12 13:00:00', '2025-03-12 16:00:00', '2025-03-12 16:15:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (32, 17, 6, 'Testes de integração com chatbot', '2025-03-13 09:00:00', '2025-03-13 12:00:00', '2025-03-13 12:30:00');
INSERT INTO tb_lancamento_hora (id, atividade_id, usuario_id, descricao, data_inicio, data_fim,
                                data_registro) VALUE (33, 18, 7, 'Revisão dos endpoints da API bancária', '2025-03-13 15:30:00', '2025-03-13 18:30:00', '2025-03-13 18:45:00');