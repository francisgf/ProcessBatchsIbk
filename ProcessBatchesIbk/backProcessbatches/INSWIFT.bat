:BEGIN
CALL LCWSET.EXE
IF ERRORLEVEL 8 GOTO ENDJOB
CALL LCIS00B.EXE
IF ERRORLEVEL 8 GOTO ENDJOB
IF ERRORLEVEL  4 GOTO WAITINT
CALL LCIS01B.EXE
IF ERRORLEVEL 8 GOTO ENDJOB
IF ERRORLEVEL  4 GOTO WAITINT
CALL LCIS02B.EXE
IF ERRORLEVEL 8 GOTO ENDJOB
:WAITINT
CALL LCSWAIT.BAT
GOTO BEGIN
:ENDJOB
@echo.
