CREATE TABLE veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255),
    modelo VARCHAR(255),
    placa VARCHAR(255),
    ano INT,
    cor VARCHAR(255),
    valor_diaria DECIMAL(10,2)
);

CREATE TABLE pessoas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(255),
    nome VARCHAR(255),
    telefone VARCHAR(255),
    email VARCHAR(255)
);

INSERT INTO veiculos (marca, modelo, placa, ano, cor, valor_diaria) VALUES
    ('Chevrolet', 'Celta', 'ABC-1234', 2010, 'preto', 100.00);

INSERT INTO pessoas (cpf, nome, telefone, email) VALUES
    ('12312312312', 'John Lenon', '11233223323', 'john.21@gmail.com');
