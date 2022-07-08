@echo off
@echo --------------------------------------------------------------------------------
@echo -- Autor            : Roger Israel Cabrera Muñoz
@echo -- Creado            : 07/07/2022
@echo -- Proposito        : Ejecutar bacheros automaticamente
@echo --------------------------------------------------------------------------------
::  --------------------------------------------------------------------------------
::  SECCIÓN DE VARIABLES
::  --------------------------------------------------------------------------------
@echo Seteo Variables
 ::set rutaBacheros=%1
	set rutaBacheros="INSWIFT.bat OUTSWIFT.bat LCSWAIT.bat"
	
::  --------------------------------------------------------------------------------
::  OBTENCION DE FECHAS
::  --------------------------------------------------------------------------------
	for /f "tokens=2-4 delims=/- " %%a in ('date /t') do set FECHA=%%a%%b%%c
	for /f "tokens=1-4 delims=:. " %%a in ('time /t') do set HORA=%%a%%b
	pause
	set fecha=%FECHA%_%HORA%
	
@echo la ruta de los bacheros es : %rutaBacheros% 
@echo.
@echo Ejecutar bat
(for %%a in (%rutaBacheros:"=%) do ( 
	@echo --------------------------------------------------------------------------------
	@echo -------------ejecutando %%a 
	call %%a
	@echo -------------fin de ejecución de %%a
	@echo --------------------------------------------------------------------------------
	@echo ********************************************************************************
))> Log_Main_%fecha%.txt

@echo fin de batchero

goto Salir

:Salir
start Log_Main_%fecha%.txt
pause
exit
