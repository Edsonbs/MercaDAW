-- He eliminado la tabla Supermercado que habia puesto en el entidad-relacion porque no le veo sentido crearla puesto que no vamos a guardar nada sobre ella
CREATE TABLE empleados (
    id                   INT(5) NOT NULL,
    nombre               VARCHAR(50),
    apellidos            VARCHAR(50),
    categoria            VARCHAR(50)
);

ALTER TABLE empleados ADD CONSTRAINT empleados_pk PRIMARY KEY (id);


CREATE TABLE productos (
    id                   INT(5) NOT NULL,
    nombre               VARCHAR(50),
    marca                VARCHAR(50),
    categoria            VARCHAR(50),
    precio_en_euros      DECIMAL(10, 2),
    iva                  DECIMAL(5, 2),
    altura_en_metros     DECIMAL(5, 2),
    anchura_en_metros    DECIMAL(5, 2),
    peso_en_kg           DECIMAL(5, 2),
    numero_elementos     INT(5),
    descripcion          VARCHAR(100)
);

ALTER TABLE productos ADD CONSTRAINT productos_pk PRIMARY KEY (id);


CREATE TABLE stock (
    productos_id INT(5) NOT NULL,
    cantidad     INT(10)
);

ALTER TABLE stock ADD CONSTRAINT stock_productos_pk PRIMARY KEY (productos_id);
ALTER TABLE stock ADD CONSTRAINT stock_productos_fk FOREIGN KEY (productos_id) REFERENCES productos (id);
ALTER TABLE stock  ADD CONSTRAINT stock_productos_fk  FOREIGN KEY (productos_id) REFERENCES productos (id) ON DELETE CASCADE;



CREATE TABLE clientes (
    id                   INT(5) NOT NULL,
    codigo_postal        INT(5),
    correo_electronico   VARCHAR(50)
);

ALTER TABLE clientes ADD CONSTRAINT clientes_pk PRIMARY KEY (id);


CREATE TABLE compra (
    clientes_id    INT(5) NOT NULL,
    productos_id   INT(5) NOT NULL,
    id_compra      INT(10),
    cantidad       INT(10),
    fecha_compra   DATE
);

ALTER TABLE compra ADD CONSTRAINT compra_pk PRIMARY KEY (clientes_id, productos_id);
ALTER TABLE compra ADD CONSTRAINT compra_clientes_fk FOREIGN KEY (clientes_id) REFERENCES clientes (id);
ALTER TABLE compra ADD CONSTRAINT compra_productos_fk FOREIGN KEY (productos_id) REFERENCES productos (id);

INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (1, 'Juan', 'Perez', 'REPONEDOR');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (2, 'Ana', 'Garcia', 'REPONEDOR');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (3, 'Luis', 'Rodriguez', 'REPONEDOR');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (4, 'Maria', 'Lopez', 'REPONEDOR');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (5, 'Carlos', 'Hernandez', 'REPONEDOR');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (6, 'Elena', 'Martinez', 'CAJERO');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (7, 'Miguel', 'Gonzalez', 'CAJERO');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (8, 'Lucia', 'Fernandez', 'CAJERO');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (9, 'Pablo', 'Gomez', 'ENCARGADO');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (10, 'Sofia', 'Diaz', 'ENCARGADO');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (11, 'David', 'Alvarez', 'OTRO');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (12, 'Laura', 'Moreno', 'OTRO');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (13, 'Sergio', 'Muñoz', 'OTRO');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (14, 'Raquel', 'Jimenez', 'OTRO');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (15, 'Jorge', 'Ruiz', 'OTRO');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (16, 'Sara', 'Sanchez', 'OTRO');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (17, 'Adrian', 'Ramirez', 'OTRO');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (18, 'Paula', 'Torres', 'OTRO');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (19, 'Alberto', 'Flores', 'OTRO');
INSERT INTO empleados (id, nombre, apellidos, categoria) VALUES (20, 'Isabel', 'Navarro', 'OTRO');


INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (1, 'Leche Entera', 'Puleva', 'ALIMENTACION', 0.89, 0.04, 0.2, 0.1, 1, 1, 'Leche entera 1L');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (2, 'Pan Integral', 'Bimbo', 'ALIMENTACION', 1.50, 0.04, 0.1, 0.2, 0.5, 1, 'Pan integral 500g');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (3, 'Arroz', 'SOS', 'ALIMENTACION', 2.00, 0.04, 0.3, 0.1, 1, 1, 'Arroz 1kg');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (4, 'Pasta', 'Gallo', 'ALIMENTACION', 1.20, 0.04, 0.2, 0.1, 1, 1, 'Pasta 1kg');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (5, 'Aceite de Oliva', 'Carbonell', 'ALIMENTACION', 5.00, 0.04, 0.4, 0.1, 1, 1, 'Aceite de oliva 1L');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (6, 'Tomate Frito', 'Orlando', 'ALIMENTACION', 1.00, 0.04, 0.15, 0.1, 0.5, 1, 'Tomate frito 500g');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (7, 'Azúcar', 'Azucarera', 'ALIMENTACION', 0.80, 0.04, 0.2, 0.1, 1, 1, 'Azúcar 1kg');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (8, 'Sal', 'Sal Costa', 'ALIMENTACION', 0.40, 0.04, 0.1, 0.1, 0.5, 1, 'Sal 1kg');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (9, 'Café', 'Nescafé', 'ALIMENTACION', 3.00, 0.04, 0.2, 0.1, 0.5, 1, 'Café 500g');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (10, 'Lechuga', 'Florette', 'ALIMENTACION', 1.00, 0.04, 0.3, 0.2, 0.5, 1, 'Lechuga fresca');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (11, 'Manzanas', 'Pink Lady', 'ALIMENTACION', 2.50, 0.04, 0.15, 0.15, 1, 6, 'Manzanas 1kg');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (12, 'Zumo de Naranja', 'Don Simón', 'ALIMENTACION', 2.00, 0.04, 0.3, 0.1, 1, 1, 'Zumo de naranja 1L');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (13, 'Yogur Natural', 'Danone', 'ALIMENTACION', 2.00, 0.04, 0.1, 0.1, 0.5, 8, 'Yogur natural 8x125g');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (14, 'Queso Rallado', 'El Caserío', 'ALIMENTACION', 2.50, 0.04, 0.1, 0.1, 0.2, 1, 'Queso rallado 200g');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (15, 'Cereales', 'Kelloggs', 'ALIMENTACION', 3.50, 0.04, 0.3, 0.1, 0.5, 1, 'Cereales 500g');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (16, 'Huevos', 'Coren', 'ALIMENTACION', 1.50, 0.04, 0.1, 0.1, 0.5, 12, 'Huevos 12 unidades');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (17, 'Mantequilla', 'Central Lechera Asturiana', 'ALIMENTACION', 1.80, 0.04, 0.1, 0.1, 0.25, 1, 'Mantequilla 250g');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (18, 'Cerveza', 'Mahou', 'ALIMENTACION', 0.60, 0.04, 0.15, 0.1, 0.5, 1, 'Cerveza 330ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (19, 'Agua Mineral', 'Font Vella', 'ALIMENTACION', 0.50, 0.04, 0.3, 0.1, 1, 1, 'Agua mineral 1.5L');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (20, 'Vino Tinto', 'Rioja', 'ALIMENTACION', 5.00, 0.04, 0.3, 0.1, 1, 1, 'Vino tinto 750ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (21, 'Champú', 'HyS', 'COSMETICA', 3.50, 0.21, 0.25, 0.1, 0.5, 1, 'Champú revitalizante 500ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (22, 'Gel de Ducha', 'Dove', 'COSMETICA', 2.50, 0.21, 0.3, 0.1, 0.5, 1, 'Gel de ducha 500ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (23, 'Crema Hidratante', 'Nivea', 'COSMETICA', 4.00, 0.21, 0.2, 0.1, 0.5, 1, 'Crema hidratante 200ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (24, 'Desodorante', 'Rexona', 'COSMETICA', 2.00, 0.21, 0.2, 0.1, 0.5, 1, 'Desodorante 150ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (25, 'Pasta de Dientes', 'Colgate', 'COSMETICA', 1.50, 0.21, 0.15, 0.1, 0.5, 1, 'Pasta de dientes 100ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (26, 'Jabón Facial', 'La Toja', 'COSMETICA', 3.00, 0.21, 0.1, 0.1, 0.5, 1, 'Jabón facial 150g');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (27, 'Lápiz Labial', 'Maybelline', 'COSMETICA', 5.00, 0.21, 0.05, 0.05, 0.2, 1, 'Lápiz labial rojo');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (28, 'Perfume', 'Chanel', 'COSMETICA', 20.00, 0.21, 0.1, 0.05, 0.2, 1, 'Perfume 50ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (29, 'Maquillaje', 'Loréal', 'COSMETICA', 10.00, 0.21, 0.1, 0.05, 0.2, 1, 'Maquillaje 30ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (30, 'Crema Solar', 'Nivea Sun', 'COSMETICA', 8.00, 0.21, 0.2, 0.1, 0.5, 1, 'Crema solar 200ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (31, 'Jabón de Manos', 'Dove', 'COSMETICA', 1.50, 0.21, 0.15, 0.1, 0.5, 1, 'Jabón de manos 250ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (32, 'Mascarilla Facial', 'Garnier', 'COSMETICA', 2.50, 0.21, 0.05, 0.05, 0.2, 1, 'Mascarilla facial');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (33, 'Loción Corporal', 'Vaseline', 'COSMETICA', 5.00, 0.21, 0.2, 0.1, 0.5, 1, 'Loción corporal 400ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (34, 'Crema Antiarrugas', 'Olay', 'COSMETICA', 10.00, 0.21, 0.05, 0.05, 0.2, 1, 'Crema antiarrugas 50ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (35, 'Desmaquillante', 'Garnier', 'COSMETICA', 3.00, 0.21, 0.1, 0.1, 0.5, 1, 'Desmaquillante 200ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (36, 'Acondicionador', 'Pantene', 'COSMETICA', 4.00, 0.21, 0.25, 0.1, 0.5, 1, 'Acondicionador 250ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (37, 'Tónico Facial', 'Clinique', 'COSMETICA', 12.00, 0.21, 0.15, 0.1, 0.5, 1, 'Tónico facial 200ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (38, 'Champú Anticaspa', 'HyS', 'COSMETICA', 4.00, 0.21, 0.25, 0.1, 0.5, 1, 'Champú anticaspa 400ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (39, 'Esmalte de Uñas', 'Essie', 'COSMETICA', 9.00, 0.21, 0.05, 0.05, 0.1, 1, 'Esmalte de uñas 15ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (40, 'Serum Facial', 'The Ordinary', 'COSMETICA', 7.00, 0.21, 0.05, 0.05, 0.1, 1, 'Serum facial 30ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (41, 'Detergente Líquido', 'Ariel', 'DROGUERIA', 5.00, 0.10, 0.4, 0.2, 2, 1, 'Detergente líquido 2L');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (42, 'Suavizante', 'Mimosín', 'DROGUERIA', 3.00, 0.10, 0.3, 0.2, 2, 1, 'Suavizante 1.5L');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (43, 'Lavavajillas', 'Fairy', 'DROGUERIA', 2.50, 0.10, 0.2, 0.1, 1, 1, 'Lavavajillas 750ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (44, 'Lejía', 'Conejo', 'DROGUERIA', 1.00, 0.10, 0.3, 0.1, 1, 1, 'Lejía 1L');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (45, 'Multiusos', 'KH-7', 'DROGUERIA', 3.00, 0.10, 0.2, 0.1, 1, 1, 'Multiusos 750ml');INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (46, 'Ambientador', 'Air Wick', 'DROGUERIA', 4.00, 0.10, 0.2, 0.1, 0.5, 1, 'Ambientador 250ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (47, 'Desinfectante', 'Sanytol', 'DROGUERIA', 3.50, 0.10, 0.2, 0.1, 1, 1, 'Desinfectante 1L');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (48, 'Limpiacristales', 'Cristasol', 'DROGUERIA', 2.00, 0.10, 0.2, 0.1, 1, 1, 'Limpiacristales 750ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (49, 'Papel Higiénico', 'Scottex', 'DROGUERIA', 4.00, 0.10, 0.4, 0.2, 0.5, 12, 'Papel higiénico 12 rollos');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (50, 'Toallitas', 'Dodot', 'DROGUERIA', 3.00, 0.10, 0.3, 0.2, 1, 64, 'Toallitas húmedas 64 unidades');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (51, 'Esponja', 'Spontex', 'DROGUERIA', 1.50, 0.10, 0.1, 0.1, 0.1, 1, 'Esponja de cocina');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (52, 'Fregasuelos', 'Asevi', 'DROGUERIA', 2.50, 0.10, 0.3, 0.1, 1, 1, 'Fregasuelos 1L');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (53, 'Cepillo', 'Vileda', 'DROGUERIA', 5.00, 0.10, 0.4, 0.2, 1, 1, 'Cepillo de barrer');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (54, 'Recambio de Mopa', 'Swiffer', 'DROGUERIA', 4.00, 0.10, 0.2, 0.1, 1, 10, 'Recambio de mopa 10 unidades');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (55, 'Bolsa de Basura', 'Albal', 'DROGUERIA', 3.00, 0.10, 0.3, 0.2, 1, 20, 'Bolsa de basura 20 unidades');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (56, 'Desatascador', 'Tiret', 'DROGUERIA', 5.00, 0.10, 0.4, 0.2, 1, 1, 'Desatascador 1L');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (57, 'Quitamanchas', 'Vanish', 'DROGUERIA', 4.50, 0.10, 0.3, 0.2, 1, 1, 'Quitamanchas 750ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (58, 'Blanqueador', 'Neutrex', 'DROGUERIA', 2.00, 0.10, 0.3, 0.1, 1, 1, 'Blanqueador 1L');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (59, 'Insecticida', 'Bloom', 'DROGUERIA', 3.50, 0.10, 0.2, 0.1, 1, 1, 'Insecticida 400ml');
INSERT INTO productos (id, nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion) VALUES (60, 'Limpiador WC', 'Harpic', 'DROGUERIA', 2.50, 0.10, 0.2, 0.1, 1, 1, 'Limpiador WC 750ml');



INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (1, 28001, 'juan.perez1@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (2, 28001, 'maria.garcia2@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (3, 28002, 'luis.martinez3@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (4, 28002, 'ana.lopez4@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (5, 28003, 'jose.sanchez5@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (6, 28003, 'carmen.fernandez6@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (7, 28004, 'david.gonzalez7@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (8, 28004, 'laura.rodriguez8@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (9, 28005, 'javier.hernandez9@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (10, 28005, 'elena.diaz10@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (11, 28006, 'sergio.ruiz11@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (12, 28006, 'isabel.morales12@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (13, 28007, 'carlos.romero13@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (14, 28007, 'alicia.torres14@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (15, 28008, 'pablo.gimenez15@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (16, 28008, 'sonia.martin16@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (17, 28001, 'fernando.vazquez17@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (18, 28001, 'laura.garcia18@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (19, 28002, 'jorge.perez19@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (20, 28002, 'luisa.sanchez20@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (21, 28003, 'mario.fernandez21@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (22, 28003, 'eva.martinez22@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (23, 28004, 'miguel.lopez23@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (24, 28004, 'rosa.gomez24@example.com');
INSERT INTO clientes (id, codigo_postal, correo_electronico) VALUES (25, 28005, 'alberto.ruiz25@example.com');

INSERT INTO stock (productos_id, cantidad) VALUES (1, 1);
INSERT INTO stock (productos_id, cantidad) VALUES (2, 6);
INSERT INTO stock (productos_id, cantidad) VALUES (3, 30);
INSERT INTO stock (productos_id, cantidad) VALUES (4, 41);
INSERT INTO stock (productos_id, cantidad) VALUES (5, 15);
INSERT INTO stock (productos_id, cantidad) VALUES (6, 26);
INSERT INTO stock (productos_id, cantidad) VALUES (7, 47);
INSERT INTO stock (productos_id, cantidad) VALUES (8, 58);
INSERT INTO stock (productos_id, cantidad) VALUES (9, 9);
INSERT INTO stock (productos_id, cantidad) VALUES (10, 10);
INSERT INTO stock (productos_id, cantidad) VALUES (11, 1);
INSERT INTO stock (productos_id, cantidad) VALUES (12, 22);
INSERT INTO stock (productos_id, cantidad) VALUES (13, 13);
INSERT INTO stock (productos_id, cantidad) VALUES (14, 14);
INSERT INTO stock (productos_id, cantidad) VALUES (15, 15);
INSERT INTO stock (productos_id, cantidad) VALUES (16, 16);
INSERT INTO stock (productos_id, cantidad) VALUES (17, 17);
INSERT INTO stock (productos_id, cantidad) VALUES (18, 18);
INSERT INTO stock (productos_id, cantidad) VALUES (19, 39);
INSERT INTO stock (productos_id, cantidad) VALUES (20, 20);
INSERT INTO stock (productos_id, cantidad) VALUES (21, 21);
INSERT INTO stock (productos_id, cantidad) VALUES (22, 22);
INSERT INTO stock (productos_id, cantidad) VALUES (23, 23);
INSERT INTO stock (productos_id, cantidad) VALUES (24, 24);
INSERT INTO stock (productos_id, cantidad) VALUES (25, 25);
INSERT INTO stock (productos_id, cantidad) VALUES (26, 26);
INSERT INTO stock (productos_id, cantidad) VALUES (27, 57);
INSERT INTO stock (productos_id, cantidad) VALUES (28, 28);
INSERT INTO stock (productos_id, cantidad) VALUES (29, 26);
INSERT INTO stock (productos_id, cantidad) VALUES (30, 30);
INSERT INTO stock (productos_id, cantidad) VALUES (31, 31);
INSERT INTO stock (productos_id, cantidad) VALUES (32, 32);
INSERT INTO stock (productos_id, cantidad) VALUES (33, 13);
INSERT INTO stock (productos_id, cantidad) VALUES (34, 34);
INSERT INTO stock (productos_id, cantidad) VALUES (35, 35);
INSERT INTO stock (productos_id, cantidad) VALUES (36, 36);
INSERT INTO stock (productos_id, cantidad) VALUES (37, 35);
INSERT INTO stock (productos_id, cantidad) VALUES (38, 38);
INSERT INTO stock (productos_id, cantidad) VALUES (39, 39);
INSERT INTO stock (productos_id, cantidad) VALUES (40, 40);
INSERT INTO stock (productos_id, cantidad) VALUES (41, 41);
INSERT INTO stock (productos_id, cantidad) VALUES (42, 42);
INSERT INTO stock (productos_id, cantidad) VALUES (43, 43);
INSERT INTO stock (productos_id, cantidad) VALUES (44, 44);
INSERT INTO stock (productos_id, cantidad) VALUES (45, 15);
INSERT INTO stock (productos_id, cantidad) VALUES (46, 46);
INSERT INTO stock (productos_id, cantidad) VALUES (47, 47);
INSERT INTO stock (productos_id, cantidad) VALUES (48, 48);
INSERT INTO stock (productos_id, cantidad) VALUES (49, 42);
INSERT INTO stock (productos_id, cantidad) VALUES (50, 50);
INSERT INTO stock (productos_id, cantidad) VALUES (51, 1);
INSERT INTO stock (productos_id, cantidad) VALUES (52, 2);
INSERT INTO stock (productos_id, cantidad) VALUES (53, 3);
INSERT INTO stock (productos_id, cantidad) VALUES (54, 42);
INSERT INTO stock (productos_id, cantidad) VALUES (55, 35);
INSERT INTO stock (productos_id, cantidad) VALUES (56, 56);
INSERT INTO stock (productos_id, cantidad) VALUES (57, 77);
INSERT INTO stock (productos_id, cantidad) VALUES (58, 18);
INSERT INTO stock (productos_id, cantidad) VALUES (59, 39);
INSERT INTO stock (productos_id, cantidad) VALUES (60, 10);

CREATE OR REPLACE VIEW EMPLEADOS_VIEW AS 
SELECT ID, NOMBRE, APELLIDOS, CATEGORIA
FROM empleados;

CREATE OR REPLACE VIEW CLIENTES_VIEW AS 
SELECT ID, CODIGO_POSTAL, CORREO_ELECTRONICO
FROM clientes;

CREATE OR REPLACE VIEW PRODUCTOS_VIEW AS 
SELECT ID, NOMBRE, MARCA, CATEGORIA, PRECIO_EN_EUROS, IVA, ALTURA_EN_METROS, ANCHURA_EN_METROS, PESO_EN_KG, NUMERO_ELEMENTOS, DESCRIPCION
FROM productos;

CREATE OR REPLACE VIEW STOCK_VIEW AS
SELECT PRODUCTOS_ID, CANTIDAD
FROM stock;

CREATE OR REPLACE VIEW COMPRA_VIEW AS
SELECT CLIENTES_ID, PRODUCTOS_ID, ID_COMPRA, CANTIDAD, FECHA_COMPRA
FROM compra;






