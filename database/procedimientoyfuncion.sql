-- Funcion
DROP FUNCTION OBTENER_IDENTIFICADOR_COMPRA;
CREATE DEFINER=`root`@`%` FUNCTION `OBTENER_IDENTIFICADOR_COMPRA`() RETURNS int(11)
    READS SQL DATA
BEGIN
  DECLARE v_id INT;
  SELECT MAX(id_compra) + 1 INTO v_id
  FROM compra;
    return v_id;
END

-- Procedimiento
CREATE PROCEDURE ALTA_COMPRA((IN cliente INT, IN producto INT)
BEGIN
    DECLARE v_id_compra INT;
    DECLARE v_fecha_compra DATE;
    DECLARE v_cantidad INT;

    SET v_id_compra = OBTENER_IDENTIFICADOR_COMPRA();
    
    SET v_fecha_compra = CURDATE();

    SELECT cantidad INTO v_cantidad
    FROM stock
    WHERE productos_id = producto;
    
    IF v_cantidad > 0 THEN
    UPDATE stock
    SET cantidad = cantidad - 1
    WHERE productos_id = producto;

    INSERT INTO compra (clientes_id, productos_id, id_compra, cantidad, fecha_compra) VALUES (cliente, producto, v_id_compra, 1, v_fecha_compra);
    
    ELSE
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Stock insuficiente';
    END IF;
END;