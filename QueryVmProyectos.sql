--VIEW QUE MUESTRA PROYECTOS GUARDADOS
--MEGAN BOUGLE
CREATE VIEW VW_PROYECTO
AS
SELECT P.NOMBRE_PERSONA REPRESENTANTE,p.TELEFONO,E.NOMBRE_EMPRESA, PR.NOMBRE_PROYECTO ,PR.DESCRIPCION
FROM [GENERAL].[PERSONA] P INNER JOIN [GENERAL].[PROYECTO] PR
ON P.ID_PERSONA = PR.ID_PERSONA
LEFT JOIN [GENERAL].[REPRESENTANTEXEMPRESA] RXE ON P.ID_PERSONA = RXE.ID_PERSONA
LEFT JOIN [GENERAL].[EMPRESA] E ON RXE.ID_EMPRESA = E.ID_EMPRESA

ALTER TABLE [GRANULOMETRIA].[MUESTRA]
	--ALTER COLUMN [PESO_FINAL] FLOAT NULL
	ALTER COLUMN [PESO_INICIAL] FLOAT NULL

DROP VIEW VW_PROYECTO
CREATE VIEW VW_PROYECTO
AS
SELECT PR.NOMBRE_PROYECTO,PR.DESCRIPCION,PR.ID_PROYECTO,E.NOMBRE_EMPRESA,E.ID_EMPRESA,E.TELEFONO TELEFONO_EMPRESA,P.NOMBRE_PERSONA,P.ID_PERSONA,P.TELEFONO,P.CORREO
FROM [GENERAL].[PERSONA] P INNER JOIN [GENERAL].[PROYECTO] PR
ON P.ID_PERSONA = PR.ID_PERSONA
LEFT JOIN [GENERAL].[REPRESENTANTEXEMPRESA] RXE ON P.ID_PERSONA = RXE.ID_PERSONA
LEFT JOIN [GENERAL].[EMPRESA] E ON RXE.ID_EMPRESA = E.ID_EMPRESA

SELECT * FROM [dbo].[VW_PROYECTO]

SELECT [NOMBRE_PERSONA]
FROM [GENERAL].[PERSONA] PER, [GENERAL].[REPRESENTANTE] REP
WHERE PER.ID_PERSONA = REP.ID_PERSONA

SELECT * FROM [GENERAL].[PROYECTO]

SELECT * FROM [GENERAL].[PERSONA]

DELETE FROM [GENERAL].[PERSONA]
WHERE ID_PERSONA = ''

SELECT * FROM [GENERAL].[REPRESENTANTE]


SELECT REP.ID_PERSONA, P.NOMBRE_PERSONA, [TELEFONO], [CORREO]
FROM [GENERAL].[PERSONA] P INNER JOIN [GENERAL].[REPRESENTANTE] REP
ON P.ID_PERSONA=REP.ID_PERSONA