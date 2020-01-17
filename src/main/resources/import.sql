/* Tabela de Cliente Inicial */
INSERT INTO COSTUMERS (costumerid, firstname, lastname, email, create_at, status) VALUES (1,'Robin','Morin','robinmorin79@gmail.com','2019-05-03',1);
INSERT INTO COSTUMERS (costumerid, firstname, lastname, email, create_at, status) VALUES (2,'Adrian','Morin','adriandmorinc2010@gmail.com','2019-08-28',1);
INSERT INTO COSTUMERS (costumerid, firstname, lastname, email, create_at, status) VALUES (3,'Javier','Jimenez','jj2012@gmail.com','2019-08-30',1);
INSERT INTO COSTUMERS (costumerid, firstname, lastname, email, create_at, status) VALUES (4,'Pedro','Perez','pp2012@gmail.com','2019-09-15',1);
INSERT INTO COSTUMERS (costumerid, firstname, lastname, email, create_at, status) VALUES (5,'Carmen','Da Silva','cds2000@gmail.com','2019-10-16',1);

/* Tabela de Produto */
INSERT INTO PRODUCTS (productid, productname, price_unit, create_at, status) VALUES (1,'Sofa Tipo 1',10,'2020-01-01',1);
INSERT INTO PRODUCTS (productid, productname, price_unit, create_at, status) VALUES (2,'Sofa Tipo 2',20,'2020-01-01',1);
INSERT INTO PRODUCTS (productid, productname, price_unit, create_at, status) VALUES (3,'Sofa Tipo 3',30,'2020-01-01',0);
INSERT INTO PRODUCTS (productid, productname, price_unit, create_at, status) VALUES (4,'Sofa Tipo 4',40,'2020-01-01',1);
INSERT INTO PRODUCTS (productid, productname, price_unit, create_at, status) VALUES (5,'Sofa Tipo 5',50,'2020-01-01',1);

/* Tabela de Faturamento */
INSERT INTO INVOICES (invoiceid,costumerid, create_at, total_amount) VALUES (1,3,'2020-01-17','1500');

/* Tabela Items Nota Fiscal */
INSERT INTO ITEMS_INVOICE (invoiceid, productid, amount,price_unit) VALUES (1,2,30,20.00);
INSERT INTO ITEMS_INVOICE (invoiceid, productid, amount,price_unit) VALUES (1,4,10,40.00);
INSERT INTO ITEMS_INVOICE (invoiceid, productid, amount,price_unit) VALUES (1,5,10,50.00);
