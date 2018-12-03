OPTIONS (errors=0, SKIP=1, SILENT=(FEEDBACK))
LOAD DATA 
CHARACTERSET UTF8                                                                      
INFILE '../MapTo.csv'  
BADFILE 'MapTo.bad'
DISCARDFILE 'MapTo.dsc'                                                           
INTO TABLE MapTo                                                                
FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'                                                       
TRAILING NULLCOLS                                                               
(                                                                               
   LOINC          CHAR NULLIF (LOINC=BLANKS)              
 , MAP_TO         CHAR NULLIF (MAP_TO=BLANKS)              
 , "COMMENT"      CHAR(150000) NULLIF ("COMMENT"=BLANKS)               
)                                                                               
