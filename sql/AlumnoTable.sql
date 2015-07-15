-- Table: alumno

-- DROP TABLE alumno;

CREATE TABLE alumno
(
  nro_cedula integer,
  nombre_apellido character varying,
  email character varying,
  nro_celular character varying
)
WITH (
  OIDS=FALSE
);
ALTER TABLE alumno
  OWNER TO gsoria;