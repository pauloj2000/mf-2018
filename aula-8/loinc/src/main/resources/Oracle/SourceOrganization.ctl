OPTIONS (errors=999, SKIP=1, SILENT=(FEEDBACK))
LOAD DATA 
CHARACTERSET UTF8                                                                      
INFILE '../SourceOrganization.csv'  
BADFILE 'SourceOrganization.bad'
DISCARDFILE 'SourceOrganization.dsc'                                                           
INTO TABLE SourceOrganization                                                                
FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'                                                       
TRAILING NULLCOLS                                                               
(  
	COPYRIGHT_ID		CHAR NULLIF (COPYRIGHT_ID=BLANKS)                                                                             
 , NAME            CHAR NULLIF (NAME=BLANKS)              
 , COPYRIGHT       CHAR(150000) NULLIF (COPYRIGHT=BLANKS)              
 , TERMS_OF_USE    CHAR(150000) NULLIF (TERMS_OF_USE=BLANKS)               
 , URL             CHAR(150000) NULLIF (URL=BLANKS)             
)                                                                               
