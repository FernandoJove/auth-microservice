CREATE EXTENSION IF NOT EXISTS citext;
CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE rol (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  nombre       VARCHAR(50) NOT NULL UNIQUE,
  descripcion  VARCHAR(200)
);

CREATE TABLE rol (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  nombre       VARCHAR(50) NOT NULL UNIQUE,
  descripcion  VARCHAR(200)
);

CREATE TABLE usuario (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  nombre        VARCHAR(40)  NOT NULL,
  apellido      VARCHAR(40)  NOT NULL,
  email         CITEXT       NOT NULL UNIQUE,
  documento_identidad VARCHAR(11),
  telefono      VARCHAR(20),
  salario_base  NUMERIC(12,2),
  rol_id        UUID REFERENCES rol(id),
  created_at    TIMESTAMPTZ NOT NULL DEFAULT now(),
  updated_at    TIMESTAMPTZ NOT NULL DEFAULT now()
);