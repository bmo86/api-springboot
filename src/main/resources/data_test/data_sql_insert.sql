-- Paso 1: Elimina los datos de la tabla
DELETE FROM medicos;

-- Paso 2: Resetea el índice de la tabla
ALTER TABLE medicos AUTO_INCREMENT = 1;

-- Inserta 20 registros ficticios en la tabla medicos
INSERT INTO medicos (name, email, document, espacialidad, street, distrito, complement, number, city, phone)
VALUES
    ('Juan Perez', 'Juan.Perez@gmail.com', '111111', 'ORTOPEDIA', 'Calle A', 'Distrito 1', 'Complemento 1', '1234', 'Ciudad 1', '12345678'),
    ('Maria Gonzalez', 'Maria.Gonzalez1@gmail.com', '234568', 'CARDIOLOGIA', 'Calle B', 'Distrito 2', 'Complemento 2', '5678', 'Ciudad 2', '23456789'),
    ('Carlos Rodriguez', 'Carlos.Rodriguez@outlook.com', '222222', 'GINECOLOGIA', 'Calle C', 'Distrito 3', 'Complemento 3', '9876', 'Ciudad 3', '34567890'),
    ('Laura Martinez', 'Laura.Martinez@outlook.com', '444444', 'PEDIATRIA', 'Calle D', 'Distrito 4', 'Complemento 4', '5432', 'Ciudad 4', '45678901'),
    ('Antonio Silva', 'Antonio.Silva@gmail.com', '567891', 'ORTOPEDIA', 'Calle E', 'Distrito 5', 'Complemento 5', '6543', 'Ciudad 5', '56789012'),
    ('Sofia Ramirez', 'Sofia.Ramirez@live.com', '678911', 'CARDIOLOGIA', 'Calle F', 'Distrito 6', 'Complemento 6', '4321', 'Ciudad 6', '67890123'),
    ('Pedro Cruz', 'Pedro.Cruz@live.com', '789033', 'GINECOLOGIA', 'Calle G', 'Distrito 7', 'Complemento 7', '9876', 'Ciudad 7', '78901234'),
    ('Ana Gonzalez', 'Ana.Gonzalez@gmail.com', '890113', 'PEDIATRIA', 'Calle H', 'Distrito 8', 'Complemento 8', '3456', 'Ciudad 8', '89012345'),
    ('Jorge Lopez', 'Jorge.Lopez@gmail.com', '901235', 'ORTOPEDIA', 'Calle I', 'Distrito 9', 'Complemento 9', '2345', 'Ciudad 9', '90123456'),
    ('Patricia Rodriguez', 'Patricia.Rodriguez@outlook.com', '012355', 'CARDIOLOGIA', 'Calle J', 'Distrito 10', 'Complemento 10', '6789', 'Ciudad 10', '01234567'),
    ('Maria Perez', 'Maria.Perez@gmail.com', '123456', 'GINECOLOGIA', 'Calle K', 'Distrito 11', 'Complemento 11', '7890', 'Ciudad 11', '12345678'),
    ('Andres Silva', 'Andres.Silva@outlook.com', '234567', 'PEDIATRIA', 'Calle L', 'Distrito 12', 'Complemento 12', '5678', 'Ciudad 12', '23456789'),
    ('Laura Martinez', 'Laura1.Martinez@gmail.com', '345678', 'ORTOPEDIA', 'Calle M', 'Distrito 13', 'Complemento 13', '9876', 'Ciudad 13', '34567890'),
    ('Carlos Cruz', 'Carlos.Cruz@live.com', '456789', 'CARDIOLOGIA', 'Calle N', 'Distrito 14', 'Complemento 14', '5432', 'Ciudad 14', '45678901'),
    ('Sofia Ramirez', 'Sofia.Ramirez@gmail.com', '567890', 'GINECOLOGIA', 'Calle O', 'Distrito 15', 'Complemento 15', '6543', 'Ciudad 15', '56789012'),
    ('Antonio Gonzalez', 'Antonio.Gonzalez@outlook.com', '678901', 'PEDIATRIA', 'Calle P', 'Distrito 16', 'Complemento 16', '4321', 'Ciudad 16', '67890123'),
    ('Juan Perez', 'Juan.Perez@outlook.com', '789012', 'ORTOPEDIA', 'Calle Q', 'Distrito 17', 'Complemento 17', '9876', 'Ciudad 17', '78901234'),
    ('Maria Gonzalez', 'Maria.Gonzalez@gmail.com', '890123', 'CARDIOLOGIA', 'Calle R', 'Distrito 18', 'Complemento 18', '3456', 'Ciudad 18', '89012345'),
    ('Carlos Rodriguez', 'Carlos.Rodriguez@live.com', '901234', 'GINECOLOGIA', 'Calle S', 'Distrito 19', 'Complemento 19', '2345', 'Ciudad 19', '90123456'),
    ('Laura Martinez', 'Laura.Martinez@gmail.com', '012345', 'PEDIATRIA', 'Calle T', 'Distrito 20', 'Complemento 20', '6789', 'Ciudad 20', '01234567');

