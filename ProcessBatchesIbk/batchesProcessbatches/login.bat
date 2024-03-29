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
::  --------------------------------------------------------------------------------
::  OBTENCION DE FECHAS
::  --------------------------------------------------------------------------------
	for /f "tokens=2-4 delims=/- " %%a in ('date /t') do set FECHA=%%a%%b%%c
	for /f "tokens=1-4 delims=:. " %%a in ('time /t') do set HORA=%%a%%b
	set fecha=%FECHA%_%HORA%
@echo.

	wmic computersystem get username >user.txt
	set username=type user.txt | findstr /v UserName | findstr "{\r\n}"
	type users.json | find /i /c "%username%" >count.txt
	
	for /f "delims=" %%a in (count.txt) do (
	  set/a counter=%%a
	)
	
	DEL /F /A user.txt
	DEL /F /A count.txt
	
	if %counter% GTR 0 goto executeNode
	
	goto salir


:executeNode
@echo Ejecutar bat
::(
	@echo --------------------------------------------------------------------------------
	@echo -------------ejecutando back node and front
	@echo on
	start cmd
	cd ..\backProcessbatches\
	::call npm start
	start powershell.exe -Command "npm start"
	::start cmd
	cd ..\frontProcessbatches\
	start powershell.exe -Command "npm start"
	
	@echo off
	
	@echo -------------fin de ejecución 
	@echo --------------------------------------------------------------------------------
	@echo ********************************************************************************
::)> Log_Login_%fecha%.txt
@echo fin de batchero
pause
exit

:salir
@echo no tiene permisos para ejecutar batcheros
pause
exit
