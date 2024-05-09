CREATE SEQUENCE item_code_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE reduction_code_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE supplier_code_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE user_code_seq START WITH 1 INCREMENT BY 1;

INSERT INTO "user" (id, user_code, name, email, password)
VALUES
(1, nextval('user_code_seq'), 'Paco', 'paco@gmail.com', '123'),
(2, nextval('user_code_seq'), 'Maria', 'maria@gmail.com', '456');

INSERT INTO "supplier" (id, supplier_code, country, name)
VALUES
(1, nextval('supplier_code_seq'), 'Japon', 'kawasaki'),
(2, nextval('supplier_code_seq'), 'Italia', 'aprila'),
(3, nextval('supplier_code_seq'), 'Japon', 'yamaha');

INSERT INTO "reduction" (id, reduction_code, end_date, reduced_price, start_date)
VALUES
(1, nextval('reduction_code_seq'), '2024-04-01', 0.1, '2024-03-01'),
(2, nextval('reduction_code_seq'), '2024-04-01', 0.2, '2024-03-01'),
(3, nextval('reduction_code_seq'), '2024-04-01', 0.5, '2024-03-01');