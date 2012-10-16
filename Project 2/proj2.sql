REM -------------------------------------------
REM COP4710 Fall 2012 
REM Project 2 - NBA Databse
REM Your name: Hebron George
REM Your NetID: hgeorge3
REM -------------------------------------------

REM Do NOT delete the following two lines! 
REM Change output file name to proj2-xxx.out where xxx is your NetID

SET PAGESIZE 500;
SPOOL proj2.out;


REM Problem 1: Find all players (first and last names) who played in New York but not in Miami;
REM SELECT system.PLAYERREGULARSEASON.FIRSTNAME, system.PLAYERREGULARSEASON.LASTNAME, system.PLAYERREGULARSEASON.TEAM, system.PLAYERREGULARSEASON.YEAR FROM system.PLAYERREGULARSEASON WHERE system.PLAYERREGULARSEASON.TEAM = 'MIA';
REM SELECT system.PLAYERREGULARSEASON.FIRSTNAME, system.PLAYERREGULARSEASON.LASTNAME FROM system.PLAYERREGULARSEASON WHERE system.PLAYERREGULARSEASON.TEAM = 'NYK') EXCEPT (SELECT system.PLAYERREGULARSEASON.FIRSTNAME, system.PLAYERREGULARSEASON.LASTNAME WHERE system.PLAYERREGULARSEASON.TEAM = 'MIA');


REM Problem 2: Find all the coaches (and the teams they coached) who has never coached a San Antonio team in the "A" league and sort them by <first name, last name>


REM Problem 3: Find all the all star players who ever played for a Detroit team. Print their names and the season(s) they played in the all-star team (hint: an all-star player must have attended the regular season in the same year)


REM Problem 4: Find the best coach(es) in season(year) 1998. Best coach is the one(s) with the largest number of net wins, which is defined as (season_win - eason_loss) + (playoff_win - playoff_loss). Specifically, print the first name, last name, and the net wins in a new column named “netwin”;


REM Problem 5


REM Problem 6


REM Problem 7


REM Problem 8


REM Problem 9


REM Problem 10


REM Problem 11


REM Problem 12


REM Do NOT change the following line
SPOOL OFF;



