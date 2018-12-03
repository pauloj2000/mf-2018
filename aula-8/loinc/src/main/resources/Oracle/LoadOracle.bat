REM
REM 
REM Please edit this script and provide values for the variables below.
REM
SET ORACLE_HOME=
SET USERNAME=
SET PASSWORD=
SET TNS_NAME=

ECHO Creating tables ... 
 
%ORACLE_HOME%\bin\sqlplus %USERNAME%/%PASSWORD%@%TNS_NAME% @OracleDDL.SQL > OracleDDL.LOG

ECHO Loading tables ... 

%ORACLE_HOME%\bin\sqlldr %USERNAME%/%PASSWORD%@%TNS_NAME% control="Loinc.ctl"
%ORACLE_HOME%\bin\sqlldr %USERNAME%/%PASSWORD%@%TNS_NAME% control="MapTo.ctl"
%ORACLE_HOME%\bin\sqlldr %USERNAME%/%PASSWORD%@%TNS_NAME% control="SourceOrganization.ctl"

ECHO Loading tables has completed.  

