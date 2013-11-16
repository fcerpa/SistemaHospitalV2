SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `Clinica` ;
CREATE SCHEMA IF NOT EXISTS `Clinica` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `Clinica` ;

-- -----------------------------------------------------
-- Table `Clinica`.`Doctor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Clinica`.`Doctor` ;

CREATE TABLE IF NOT EXISTS `Clinica`.`Doctor` (
  `RutDoctor` VARCHAR(45) NOT NULL,
  `NombreDoctor` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `Especialidad` VARCHAR(45) NULL,
  `Celular` VARCHAR(45) NULL,
  `Sexo` VARCHAR(45) NULL,
  PRIMARY KEY (`RutDoctor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Tipo SistemaSalud`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Clinica`.`Tipo SistemaSalud` ;

CREATE TABLE IF NOT EXISTS `Clinica`.`Tipo SistemaSalud` (
  `TipoSistemaSalud` VARCHAR(50) NOT NULL,
  `Nom_SistemaSalud` VARCHAR(45) NULL,
  PRIMARY KEY (`TipoSistemaSalud`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Paciente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Clinica`.`Paciente` ;

CREATE TABLE IF NOT EXISTS `Clinica`.`Paciente` (
  `RutPaciente` VARCHAR(45) NOT NULL,
  `NombrePaciente` VARCHAR(45) NULL,
  `Edad` VARCHAR(45) NULL,
  `Sexo` VARCHAR(45) NULL,
  `Hora` VARCHAR(45) NULL,
  `Tipo SistemaSalud_TipoSistemaSalud` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`RutPaciente`),
  CONSTRAINT `fk_Paciente_Tipo SistemaSalud1`
    FOREIGN KEY (`Tipo SistemaSalud_TipoSistemaSalud`)
    REFERENCES `Clinica`.`Tipo SistemaSalud` (`TipoSistemaSalud`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Paciente_Tipo SistemaSalud1_idx` ON `Clinica`.`Paciente` (`Tipo SistemaSalud_TipoSistemaSalud` ASC);


-- -----------------------------------------------------
-- Table `Clinica`.`Especialidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Clinica`.`Especialidad` ;

CREATE TABLE IF NOT EXISTS `Clinica`.`Especialidad` (
  `TipoEspecialidad` VARCHAR(45) NOT NULL,
  `NombresEspecialidad` VARCHAR(45) NULL,
  PRIMARY KEY (`TipoEspecialidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Medico Especialista`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Clinica`.`Medico Especialista` ;

CREATE TABLE IF NOT EXISTS `Clinica`.`Medico Especialista` (
  `NombreEspecialidad` VARCHAR(50) NOT NULL,
  `Especialidad_TipoEspecialidad` VARCHAR(45) NOT NULL,
  `Doctor_RutDoctor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`NombreEspecialidad`),
  CONSTRAINT `fk_MedicoEspecialista_Especialidad1`
    FOREIGN KEY (`Especialidad_TipoEspecialidad`)
    REFERENCES `Clinica`.`Especialidad` (`TipoEspecialidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Medico Especialista_Doctor1`
    FOREIGN KEY (`Doctor_RutDoctor`)
    REFERENCES `Clinica`.`Doctor` (`RutDoctor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_MedicoEspecialista_Especialidad1_idx` ON `Clinica`.`Medico Especialista` (`Especialidad_TipoEspecialidad` ASC);

CREATE INDEX `fk_Medico Especialista_Doctor1_idx` ON `Clinica`.`Medico Especialista` (`Doctor_RutDoctor` ASC);


-- -----------------------------------------------------
-- Table `Clinica`.`Atencion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Clinica`.`Atencion` ;

CREATE TABLE IF NOT EXISTS `Clinica`.`Atencion` (
  `NumeroAtencion` INT NOT NULL,
  `FechaAtencion` VARCHAR(45) NULL,
  `MedicoEspecialista_NombreEspecialidad` VARCHAR(50) NOT NULL,
  `Paciente_RutPaciente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`NumeroAtencion`),
  CONSTRAINT `fk_Atencion_MedicoEspecialista1`
    FOREIGN KEY (`MedicoEspecialista_NombreEspecialidad`)
    REFERENCES `Clinica`.`Medico Especialista` (`NombreEspecialidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Atencion_Paciente1`
    FOREIGN KEY (`Paciente_RutPaciente`)
    REFERENCES `Clinica`.`Paciente` (`RutPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Atencion_MedicoEspecialista1_idx` ON `Clinica`.`Atencion` (`MedicoEspecialista_NombreEspecialidad` ASC);

CREATE INDEX `fk_Atencion_Paciente1_idx` ON `Clinica`.`Atencion` (`Paciente_RutPaciente` ASC);


-- -----------------------------------------------------
-- Table `Clinica`.`Observaciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Clinica`.`Observaciones` ;

CREATE TABLE IF NOT EXISTS `Clinica`.`Observaciones` (
  `NumeroObservaciones` INT NOT NULL,
  `Observaciones` VARCHAR(45) NULL,
  `Atencion_NumeroAtencion` INT NOT NULL,
  PRIMARY KEY (`NumeroObservaciones`),
  CONSTRAINT `fk_Observaciones_Atencion1`
    FOREIGN KEY (`Atencion_NumeroAtencion`)
    REFERENCES `Clinica`.`Atencion` (`NumeroAtencion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Observaciones_Atencion1_idx` ON `Clinica`.`Observaciones` (`Atencion_NumeroAtencion` ASC);


-- -----------------------------------------------------
-- Table `Clinica`.`Ficha Clinica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Clinica`.`Ficha Clinica` ;

CREATE TABLE IF NOT EXISTS `Clinica`.`Ficha Clinica` (
  `NumeroFichaClinica` INT NOT NULL,
  `Nom_FichaClinica` VARCHAR(45) NULL,
  `Atencion_NumeroAtencion` INT NOT NULL,
  PRIMARY KEY (`NumeroFichaClinica`),
  CONSTRAINT `fk_FichaClinica_Atencion1`
    FOREIGN KEY (`Atencion_NumeroAtencion`)
    REFERENCES `Clinica`.`Atencion` (`NumeroAtencion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_FichaClinica_Atencion1_idx` ON `Clinica`.`Ficha Clinica` (`Atencion_NumeroAtencion` ASC);


-- -----------------------------------------------------
-- Table `Clinica`.`Tratamientos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Clinica`.`Tratamientos` ;

CREATE TABLE IF NOT EXISTS `Clinica`.`Tratamientos` (
  `NumeroTratamientos` INT NOT NULL,
  `Tipo_Tratamiento` VARCHAR(45) NULL,
  `Atencion_NumeroAtencion` INT NOT NULL,
  PRIMARY KEY (`NumeroTratamientos`),
  CONSTRAINT `fk_Tratamientos_Atencion1`
    FOREIGN KEY (`Atencion_NumeroAtencion`)
    REFERENCES `Clinica`.`Atencion` (`NumeroAtencion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Tratamientos_Atencion1_idx` ON `Clinica`.`Tratamientos` (`Atencion_NumeroAtencion` ASC);


-- -----------------------------------------------------
-- Table `Clinica`.`Examenes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Clinica`.`Examenes` ;

CREATE TABLE IF NOT EXISTS `Clinica`.`Examenes` (
  `NumeroExamenes` INT NOT NULL,
  `Exa_Finales` VARCHAR(45) NULL,
  `Exa_Progreso` VARCHAR(45) NULL,
  `Tratamientos_NumeroTratamientos` INT NOT NULL,
  `Observaciones_NumeroObservaciones` INT NOT NULL,
  PRIMARY KEY (`NumeroExamenes`),
  CONSTRAINT `fk_Examenes_Tratamientos1`
    FOREIGN KEY (`Tratamientos_NumeroTratamientos`)
    REFERENCES `Clinica`.`Tratamientos` (`NumeroTratamientos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Examenes_Observaciones1`
    FOREIGN KEY (`Observaciones_NumeroObservaciones`)
    REFERENCES `Clinica`.`Observaciones` (`NumeroObservaciones`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Examenes_Tratamientos1_idx` ON `Clinica`.`Examenes` (`Tratamientos_NumeroTratamientos` ASC);

CREATE INDEX `fk_Examenes_Observaciones1_idx` ON `Clinica`.`Examenes` (`Observaciones_NumeroObservaciones` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
