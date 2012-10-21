REM ============================================
REM COP 4710 Fall 2012
REM Project 3 - SQL functions and procedures
REM Your Name : Hebron George
REM Your NetID: hgeorge3
REM ============================================

REM do not change the following two lines!

SET PAGESIZE 5000;
SET serveroutput on size 32000; 

REM Change output file name to proj3-NetID.out!
SPOOL proj3-hgeorge3.out;

REM the "/" is needed to separate each block of code, do NOT delete them!
REM follow the exact function/procedure signatures defined here, do NOT change them!

REM Problem 1 - function ranked_height

create or replace function ranked_height (low_bound IN INT, high_bound IN INT)
return INT
IS
-- define local variables here

BEGIN
-- implement function body here 
    

-- return value here
    
END;
/

REM Problem 2 - An anonymous block that calls function ranked_height



REM Problem 3 - procedure point_triangle
create or replace procedure point_triangles (team_name IN VARCHAR2)
AS
-- define local variables here

BEGIN


END;
/

REM Problem 4 - execute the above procedure 



REM Do NOT change the following lines
drop procedure point_triangles;
drop function ranked_height;

SPOOL OFF;



