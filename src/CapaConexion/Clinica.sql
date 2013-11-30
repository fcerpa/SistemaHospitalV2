SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Clinica` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `Clinica` ;

-- -----------------------------------------------------
-- Table `Clinica`.`Doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`Doctor` (
  `RutDoctor` INT NOT NULL,
  `NombreDoctor` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `Especialidad` VARCHAR(45) NULL,
  `Celular` VARCHAR(45) NULL,
  `Sexo` VARCHAR(45) NULL,
  PRIMARY KEY (`RutDoctor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`Paciente` (
  `RutPaciente` INT NOT NULL,
  `NombrePaciente` VARCHAR(45) NULL,
  `Edad` VARCHAR(45) NULL,
  `Sexo` VARCHAR(45) NULL,
  `Hora` VARCHAR(45) NULL,
  `TipoAtencion` VARCHAR(45) NULL,
  `FechaAtencion` VARCHAR(45) NULL,
  `TipoSistemaSalud` VARCHAR(45) NULL,
  `nombreSistemaSalud` VARCHAR(45) NULL,
  `NombreEspecialidad` VARCHAR(45) NULL,
  `TipoCirugia` VARCHAR(45) NULL,
  PRIMARY KEY (`RutPaciente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`EspecialidadDoctores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`EspecialidadDoctores` (
  `codEspecialidad` INT NOT NULL,
  `NombresEspecialidad` VARCHAR(45) NULL,
  `TipoCirugia` VARCHAR(45) NULL,
  PRIMARY KEY (`codEspecialidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`ResumenFichaClinica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`ResumenFichaClinica` (
  `CodFichaClinica` INT NOT NULL,
  `Nom_FichaClinica` VARCHAR(45) NULL,
  PRIMARY KEY (`CodFichaClinica`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`DefinirTratamientos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`DefinirTratamientos` (
  `codTratamiento` INT NOT NULL,
  `TipoTratamiento` VARCHAR(45) NULL,
  `ObservacionMedica` VARCHAR(45) NULL,
  PRIMARY KEY (`codTratamiento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Examenes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`Examenes` (
  `CodExamen` INT NOT NULL,
  `Exa_Finales` VARCHAR(45) NULL,
  `Exa_Progreso` VARCHAR(45) NULL,
  PRIMARY KEY (`CodExamen`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`ExamenesResumenFichaClinica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`ExamenesResumenFichaClinica` (
  `Examenes_CodExamen` INT NOT NULL,
  `ResumenFichaClinica_CodFichaClinica` INT NOT NULL,
  PRIMARY KEY (`Examenes_CodExamen`, `ResumenFichaClinica_CodFichaClinica`),
  INDEX `fk_Examenes_has_ResumenFichaClinica_ResumenFichaClinica1_idx` (`ResumenFichaClinica_CodFichaClinica` ASC),
  INDEX `fk_Examenes_has_ResumenFichaClinica_Examenes1_idx` (`Examenes_CodExamen` ASC),
  CONSTRAINT `fk_Examenes_has_ResumenFichaClinica_Examenes1`
    FOREIGN KEY (`Examenes_CodExamen`)
    REFERENCES `Clinica`.`Examenes` (`CodExamen`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Examenes_has_ResumenFichaClinica_ResumenFichaClinica1`
    FOREIGN KEY (`ResumenFichaClinica_CodFichaClinica`)
    REFERENCES `Clinica`.`ResumenFichaClinica` (`CodFichaClinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`DoctorEspecialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`DoctorEspecialidad` (
  `Doctor_RutDoctor` INT NOT NULL,
  `Especialidad_codEspecialidad` INT NOT NULL,
  PRIMARY KEY (`Doctor_RutDoctor`, `Especialidad_codEspecialidad`),
  INDEX `fk_Doctor_has_Especialidad_Especialidad1_idx` (`Especialidad_codEspecialidad` ASC),
  INDEX `fk_Doctor_has_Especialidad_Doctor1_idx` (`Doctor_RutDoctor` ASC),
  CONSTRAINT `fk_Doctor_has_Especialidad_Doctor1`
    FOREIGN KEY (`Doctor_RutDoctor`)
    REFERENCES `Clinica`.`Doctor` (`RutDoctor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Doctor_has_Especialidad_Especialidad1`
    FOREIGN KEY (`Especialidad_codEspecialidad`)
    REFERENCES `Clinica`.`EspecialidadDoctores` (`codEspecialidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Atencion_Doctores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`Atencion_Doctores` (
  `Doctor_RutDoctor` INT NOT NULL,
  `Paciente_RutPaciente` INT NOT NULL,
  PRIMARY KEY (`Doctor_RutDoctor`, `Paciente_RutPaciente`),
  INDEX `fk_Doctor_has_Paciente_Paciente1_idx` (`Paciente_RutPaciente` ASC),
  INDEX `fk_Doctor_has_Paciente_Doctor1_idx` (`Doctor_RutDoctor` ASC),
  CONSTRAINT `fk_Doctor_has_Paciente_Doctor1`
    FOREIGN KEY (`Doctor_RutDoctor`)
    REFERENCES `Clinica`.`Doctor` (`RutDoctor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Doctor_has_Paciente_Paciente1`
    FOREIGN KEY (`Paciente_RutPaciente`)
    REFERENCES `Clinica`.`Paciente` (`RutPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`DefinirTratamientos_Examenes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`DefinirTratamientos_Examenes` (
  `DefinirTratamientos_codTratamiento` INT NOT NULL,
  `Examenes_CodExamen` INT NOT NULL,
  PRIMARY KEY (`DefinirTratamientos_codTratamiento`, `Examenes_CodExamen`),
  INDEX `fk_DefinirTratamientos_has_Examenes_Examenes1_idx` (`Examenes_CodExamen` ASC),
  INDEX `fk_DefinirTratamientos_has_Examenes_DefinirTratamientos1_idx` (`DefinirTratamientos_codTratamiento` ASC),
  CONSTRAINT `fk_DefinirTratamientos_has_Examenes_DefinirTratamientos1`
    FOREIGN KEY (`DefinirTratamientos_codTratamiento`)
    REFERENCES `Clinica`.`DefinirTratamientos` (`codTratamiento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DefinirTratamientos_has_Examenes_Examenes1`
    FOREIGN KEY (`Examenes_CodExamen`)
    REFERENCES `Clinica`.`Examenes` (`CodExamen`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`DefinirTratamientos_Atencion_Doctores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`DefinirTratamientos_Atencion_Doctores` (
  `DefinirTratamientos_codTratamiento` INT NOT NULL,
  `Atencion_Doctores_Doctor_RutDoctor` INT NOT NULL,
  `Atencion_Doctores_Paciente_RutPaciente` INT NOT NULL,
  PRIMARY KEY (`DefinirTratamientos_codTratamiento`, `Atencion_Doctores_Doctor_RutDoctor`, `Atencion_Doctores_Paciente_RutPaciente`),
  INDEX `fk_DefinirTratamientos_has_Atencion_Doctores_Atencion_Docto_idx` (`Atencion_Doctores_Doctor_RutDoctor` ASC, `Atencion_Doctores_Paciente_RutPaciente` ASC),
  INDEX `fk_DefinirTratamientos_has_Atencion_Doctores_DefinirTratami_idx` (`DefinirTratamientos_codTratamiento` ASC),
  CONSTRAINT `fk_DefinirTratamientos_has_Atencion_Doctores_DefinirTratamien1`
    FOREIGN KEY (`DefinirTratamientos_codTratamiento`)
    REFERENCES `Clinica`.`DefinirTratamientos` (`codTratamiento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DefinirTratamientos_has_Atencion_Doctores_Atencion_Doctores1`
    FOREIGN KEY (`Atencion_Doctores_Doctor_RutDoctor` , `Atencion_Doctores_Paciente_RutPaciente`)
    REFERENCES `Clinica`.`Atencion_Doctores` (`Doctor_RutDoctor` , `Paciente_RutPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Paciente_ResumenFichaClinica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`Paciente_ResumenFichaClinica` (
  `Paciente_RutPaciente` INT NOT NULL,
  `ResumenFichaClinica_CodFichaClinica` INT NOT NULL,
  PRIMARY KEY (`Paciente_RutPaciente`, `ResumenFichaClinica_CodFichaClinica`),
  INDEX `fk_Paciente_has_ResumenFichaClinica_ResumenFichaClinica1_idx` (`ResumenFichaClinica_CodFichaClinica` ASC),
  INDEX `fk_Paciente_has_ResumenFichaClinica_Paciente1_idx` (`Paciente_RutPaciente` ASC),
  CONSTRAINT `fk_Paciente_has_ResumenFichaClinica_Paciente1`
    FOREIGN KEY (`Paciente_RutPaciente`)
    REFERENCES `Clinica`.`Paciente` (`RutPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paciente_has_ResumenFichaClinica_ResumenFichaClinica1`
    FOREIGN KEY (`ResumenFichaClinica_CodFichaClinica`)
    REFERENCES `Clinica`.`ResumenFichaClinica` (`CodFichaClinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
