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


REM ============================================
REM Problem 1 - function ranked_height

create or replace function ranked_height (low_bound IN INT, high_bound IN INT)
return INT
IS
numRows INT := 0;
-- define local variables here
rank INT;
counter INT;
previousH VARCHAR2(10);
CURSOR rows IS
	SELECT FIRSTNAME, LASTNAME, (H_FEET * 30.48 + H_INCHES * 2.54) AS HEIGHT
  	FROM system.PLAYERS P
  	WHERE H_FEET IS NOT NULL AND H_INCHES IS NOT NULL AND H_INCHES >= 0 AND H_FEET >= 0
  	ORDER BY HEIGHT DESC;
BEGIN
-- implement function body here 
	rank := 1;

	numRows := 0;
	counter := 0;
	FOR player IN rows LOOP	
		IF (counter = 0) THEN
		 	counter := 1;
		 	IF (rank >= low_bound and rank <= high_bound) THEN
		 		DBMS_OUTPUT.PUT_LINE(player.FIRSTNAME || ' ' || player.LASTNAME || ' Height: ' || player.HEIGHT || ' Rank: ' || rank);
				numRows := numRows + 1;
			END IF;
		 	previousH := player.HEIGHT;
		ELSIF (previousH = player.HEIGHT) THEN
		 	IF (rank >= low_bound and rank <= high_bound) THEN
			 	DBMS_OUTPUT.PUT_LINE(player.FIRSTNAME || ' ' || player.LASTNAME || ' Height: ' || player.HEIGHT || ' Rank: ' || rank);
				numRows := numRows + 1;
			END IF;
		ELSE
			rank := rank + 1;
			previousH := player.HEIGHT;
		 	IF (rank >= low_bound and rank <= high_bound) THEN
			 	DBMS_OUTPUT.PUT_LINE(player.FIRSTNAME || ' ' || player.LASTNAME || ' Height: ' || player.HEIGHT || ' Rank: ' || rank);
				numRows := numRows + 1;
			END IF;
		END IF;
	END LOOP;

	
-- return value here
    RETURN numRows;
END;
/
REM ============================================




REM ============================================
REM Problem 2 - An anonymous block that calls function ranked_height
DECLARE
	returnedVal INT;
BEGIN
	returnedVal := ranked_height(1, 4);
	IF returnedVal <= 0 THEN
		DBMS_OUTPUT.PUT_LINE('No players fall into this range!');
	END IF;
END;
/
REM ============================================




REM ============================================
REM Problem 3 - procedure point_triangle
create or replace procedure point_triangles (team_name IN VARCHAR2)
AS
-- define local variables here
CURSOR rows
IS
SELECT FIRSTNAME, LASTNAME, SUM(PTS) AS points
FROM system.PLAYERREGULARSEASON
WHERE TEAM = team_name
GROUP BY FIRSTNAME, LASTNAME
ORDER BY points DESC;
currentCount INT;
maxCount INT;
BEGIN
FOR player IN rows LOOP
	
	currentCount := maxCount;
	DBMS_OUTPUT.PUT(player.FIRSTNAME || ' ' || player.LASTNAME || ':' || player.points || ' ');

	--DBMS_OUTPUT.NEW_LINE();
END LOOP;

END;
/
REM ============================================



REM ============================================
REM Problem 4 - execute the above procedure 
BEGIN
point_triangles('IND');
END;
/
REM Do NOT change the following lines
drop procedure point_triangles;
drop function ranked_height;
REM ============================================


SPOOL OFF;