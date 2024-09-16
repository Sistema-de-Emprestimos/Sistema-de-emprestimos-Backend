-- Tabela de Funcionários
CREATE TABLE funcionarios (
    funcionario_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    funcao VARCHAR(255),
    data_admissao DATE NOT NULL
);

-- Tabela de Equipamentos
CREATE TABLE equipamentos (
    equipamento_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    data_compra DATE,
    peso DECIMAL(10, 2),
    largura DECIMAL(10, 2),
    comprimento DECIMAL(10, 2),
    estado_conservacao ENUM('NOVO', 'OTIMO', 'BOM', 'RUIM') NOT NULL,
    disponivel BOOLEAN DEFAULT TRUE
);

-- Tabela de Empréstimos
CREATE TABLE emprestimos (
    emprestimo_id INT AUTO_INCREMENT PRIMARY KEY,
    data_saida DATETIME NOT NULL,
    data_retorno DATETIME,
    funcionario_id INT,
    equipamento_id INT,
    observacoes VARCHAR(255),
    concluido BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_funcionario FOREIGN KEY (funcionario_id) REFERENCES funcionarios(funcionario_id),
    CONSTRAINT fk_equipamento FOREIGN KEY (equipamento_id) REFERENCES equipamentos(equipamento_id)
);

-- Tabela de Manutenções
CREATE TABLE manutencoes (
    manutencao_id INT AUTO_INCREMENT PRIMARY KEY,
    data DATE NOT NULL,
    descricao TEXT,
    equipamento_id INT,
    CONSTRAINT fk_equipamento_manutencao FOREIGN KEY (equipamento_id) REFERENCES equipamentos(equipamento_id)
);


