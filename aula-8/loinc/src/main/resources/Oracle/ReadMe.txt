This directory includes very rudimentary scripts for importing the LOINC codes
into an Oracle database. These scripts are very basic and should not be used 
in a production environment. They are provided as a starting point to show 
one method that can be used to load the LOINC data.
 
It is highly recommended that you consult with your database administrator
before attempting to run these scripts or load these data.

It is assumed that you are working in a Windows environment and have the 
Oracle client software installed on your PC. LoadOracle.bat is 
a Windows batch file and will not run on other operating systems. 

The Oracle loader control file (.ctl) and table creation script (.sql)
are generic and should function in any Oracle environment.

Before these scripts can be used, they must be modified for your environment. At
the very least the LoadOracle.bat file must be edited to provide the
following information:

 ORACLE_HOME
 USERNAME
 PASSWORD
 TNS_NAME
 
 
 