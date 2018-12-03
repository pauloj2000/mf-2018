This directory includes very rudimentary scripts for importing the LOINC codes
into a MySQL database. These scripts are very basic and should not be used 
in a production environment. They are provided as a starting point to show 
one method that can be used to load the LOINC data.
 
It is highly recommended that you consult with your database administrator
before attempting to run these scripts or load these data.

It is assumed that you are working in a Windows environment and have the 
MySQL software installed on your PC. LoadMySQL.bat is 
a Windows batch file and will not run on other operating systems. 

Before this script can be used, it must be modified for your environment. At
the very least it must be edited to provide the following information:

 MYSQL_HOME
 USERNAMENAME
 HOST_NAME
 DB_NAME
 
 
 