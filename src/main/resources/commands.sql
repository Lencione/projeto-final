-- Tabela "users"
CREATE TABLE users (
    id NUMBER(10) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR2(100) NOT NULL,
    email VARCHAR2(100) NOT NULL,
    password VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela "Products"
CREATE TABLE products (
    id NUMBER(10) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR2(100) NOT NULL,
    quantity NUMBER(10) NOT NULL,
    price NUMBER(10,2) NOT NULL
);

INSERT INTO products (id,name,quantity,price) VALUES (1,'Relogio',5,50.45);
INSERT INTO products (id,name,quantity,price) VALUES (2,'Mouse',10,20.45);
INSERT INTO products (id,name,quantity,price) VALUES (3,'Teclado',21,25.40);
INSERT INTO products (id,name,quantity,price) VALUES (4,'Monitor',11,1150.54);
