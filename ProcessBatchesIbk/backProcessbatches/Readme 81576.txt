                 SOFTWARE DELIVERY DOCUMENT 
. 
Attention Helpdesk - Please update into the CSI standard Delivery Advice 
. 
Thu 08/27/2015 
. 
------------------------------------------------------------------ 
  CLIENT: INTLP    Interbank Lima Peru                                                      
------------------------------------------------------------------ 
  RELEASE: REL-14 
------------------------------------------------------------------ 
  CSI LOG NUMBER: CSI81576_J.A 
------------------------------------------------------------------ 
  CLIENT LOG NUMBER: INTBK-INT-SWIFT
------------------------------------------------------------------ 
  EXPLANATION OF PROGRAM CHANGES: 
  Migration Win NT to Win 2008 Servers.
  Parametrizacion de displays en el archivo SWIFT.LOG (swift incoming)
-----------------------------------------------------------------------------  
INSTALLATION INSTRUCTION:                                                      
-----------------------------------------------------------------------------  
  FILE    I DESCRIPTION ITRANSFERI           INSTALLATIONN INSTRUCTIONS      I 
EXTENSION I             I  TYPE  I                                           I 
----------I-------------I--------I-------------------------------------------I 
ccp.obj   I on-line     I binary I 1.Transfer object to on-line object lib.  I 
          I object      I        I 2.Link-edit object to CICS load library   I 
----------I-------------I--------I-------------------------------------------I 
NOTE:                                                                          
  PLEASE MAKE SURE "CEMT NEW COPY" IS SET FOR ON-LINE OBJECTS and maps.        
.                                                                              
------------------------------------------------------------------

          LIST OF NEW DOCUMENTS:

------------------------------------------------------------------
Hacer backup de versiones previas y cambiar tipo de archivo .so
a .exe

Se creo nuevo parametro en archivo de configuracion SWIFT.INI :

        LOGSWI=Y

Y = Graba informacion de traces en SWIFT.LOG
N = No Graba informacion de traces en SWIFT.LOG

se adjunta archivo SWIFT.INI de muestra
------------------------------------------------------------------ 
. 
             LIST OF MODULES SENT: 
. 
------------------------------------------------------------------ 
LCIS00B.so
LCIS02B.so
------------------------------------------------------------------ 

