REM
REM 
REM Please edit this script and provide values for the variables below.
REM

SET MYSQL_HOME=
SET USERNAME=
SET HOST_NAME=
SET DB_NAME=

ECHO Creating tables ... 

%MYSQL_HOME%\bin\mysql -u %USERNAME%  -h %HOST_NAME% -p %DB_NAME% < MySQLDDL.sql

ECHO Loading tables ... 

%MYSQL_HOME%\bin\mysql -u %USERNAME%  -h %HOST_NAME% -p %DB_NAME% < MySQLLoader.sql

echo
echo ----------------------------------------
echo Finished
echo ----------------------------------------

