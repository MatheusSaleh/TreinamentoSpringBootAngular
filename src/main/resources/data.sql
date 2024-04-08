INSERT INTO usuario (nome) VALUES
                               ('João'),
                               ('Maria'),
                               ('Pedro');



-- Inserir alguns dados iniciais na tabela tarefa
INSERT INTO tarefa (usuario_id, titulo, descricao, situacao) VALUES
                                                                 (1, 'Fazer compras', 'Comprar itens de supermercado', 'Em andamento'),
                                                                 (2, 'Estudar para o exame', 'Revisar os capítulos 1 a 5 do livro', 'Pendente'),
                                                                 (3, 'Consertar o carro', 'Levar o carro ao mecânico para conserto', 'Aguardando aprovação');
