:BEGIN
CALL LCWSET.EXE
IF ERRORLEVEL 8 GOTO ENDJOB
@ECHO START LCWOUT
rem PAUSE
CALL LCWOUT.EXE
IF ERRORLEVEL 8 GOTO ENDJOB
IF ERRORLEVEL  4 GOTO WAITINT
@ECHO START LCSWOUT2
rem PAUSE
CALL LCSWOUT2.EXE
@ECHO FINISH LCSWOUT2
rem PAUSE
IF ERRORLEVEL 8 GOTO ENDJOB
:WAITINT
CALL LCSWAIT.BAT
GOTO BEGIN
:ENDJOB
@echo.
