CREATE TRIGGER TRG_CLIENT_ID
  BEFORE INSERT
  ON CLIENT
  FOR EACH ROW
  BEGIN
    SELECT client_id_seq.nextval
    INTO :new.id
    FROM dual;
  END;


