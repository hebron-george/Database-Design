import java.io.*;


public class P1 {
	
	/* Define data structures for holding the data here */

    public P1() {
        /* initialize the data structures */
    }
    
    public void run() {
        CommandParser parser = new CommandParser();

        System.out.println("The mini-DB of NBA coaches and teams");
        System.out.println("Please enter a command.  Enter 'help' for a list of commands.");
        System.out.println();
        System.out.print("> "); 
        
        Command cmd = null;
        while ((cmd = parser.fetchCommand()) != null) {
            //System.out.println(cmd);
            
            boolean result=false;
            
            if (cmd.getCommand().equals("help")) 
            {
                result = doHelp();

                /* You need to implement all the following commands */
            } 
            
            else if (cmd.getCommand().equals("add_coach")) 
            {
            	try
            	{
            		String params[] = cmd.getParameters(), submitStr;
            		FileWriter fw = new FileWriter("coaches_season.txt", true);
            		fw.write("\n");
            		submitStr = params[0] + "," + params[1] + ",," + params[2] + "," + params[3] + "," + params[4] + "," + params[5];
            		submitStr += "," + params[6] + "," + params[7] + "," + params[8];
            		fw.write(submitStr);
            		fw.close();
            	}
            	catch (Exception ex)
            	{
					System.out.println("A problem has occurred. Refer to the next line about the exception that was thrown.");
					System.out.println(ex.toString());            		
            	}
            } 
            
            else if (cmd.getCommand().equals("add_team")) 
            {
            	try
            	{
            		String params[] = cmd.getParameters(), submitStr = params[0];
            		FileWriter fw = new FileWriter("teams.txt", true); //true sets it to append instead of overwrite
            		fw.write("\n");
            		for (int i = 1; i < params.length; i++)
            		{
            			submitStr += "," + params[i];
            		}
            		fw.write(submitStr);
            		fw.close();
            	}
            	catch (Exception ex)
            	{
					System.out.println("A problem has occurred. Refer to the next line about the exception that was thrown.");
					System.out.println(ex.toString());            		
            	}
			} 
            
            else if (cmd.getCommand().equals("print_coaches")) 
			{
				try
				{
					FileInputStream fstream = new FileInputStream("coaches_season.txt");
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					String strLine, pieces[];
					strLine = br.readLine(); // Reads in and ignores the first line which defines the structure of columns
					
					while ((strLine = br.readLine()) != null) {
						pieces = strLine.split(",");
						if (pieces.length == 10)
						{
							// Print the content on the console
							System.out.print (pieces[0] + " " + pieces[1] + " " + pieces[3] + " " + pieces[4] + " " + pieces[5] + " " + pieces[6] + " ");
							System.out.println(pieces[7] + " " + pieces[8] + " " + pieces[9]);
						}
					}
					
					in.close();
				
				}
				catch (Exception ex)
				{
					System.out.println("A problem has occurred. Refer to the next line about the exception that was thrown.");
					System.out.println(ex.toString());
				}
	
		   	} 
			
			else if (cmd.getCommand().equals("print_teams")) 
		   	{
		   		try
		   		{
					FileInputStream fstream = new FileInputStream("teams.txt");
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					String strLine, pieces[];
					strLine = br.readLine(); // Reads in and ignores the first line which defines the structure of columns
					
					while ((strLine = br.readLine()) != null)
					{
						pieces = strLine.split(",");
						if (pieces.length == 4)
						{
							System.out.println(pieces[0] + " " + pieces[1] + " " + pieces[2] + " " + pieces[3]);
						}
						
					}
					br.close();
		   			
		   		}
		   		catch (Exception ex)
		   		{
					System.out.println("A problem has occurred. Refer to the next line about the exception that was thrown.");
					System.out.println(ex.toString());
		   		}
	
			} 
			
			else if (cmd.getCommand().equals("coaches_by_name")) 
			{
				try
				{
					FileInputStream fstream = new FileInputStream("coaches_season.txt");
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					String strLine, pieces[];				
					String parameters[] = cmd.getParameters();
					
					while ((strLine = br.readLine()) != null)
					{
						pieces = strLine.split(",");
						if (pieces.length == 10)
							if (pieces[4].trim().equals(parameters[0].replace("+", " ")))
						
								System.out.println(pieces[0] + " " + pieces[1] + " " + pieces[3] + " " + pieces[4] + " " + pieces[5] + " " + pieces[6] + " " + pieces[7] + " " + pieces[8] + " " + pieces[9]);
						
					}
					br.close();
				}
				catch (Exception ex)
				{
					System.out.println("A problem has occurred. Refer to the next line about the exception that was thrown.");
					System.out.println(ex.toString());
				}
	
			} 
			
			else if (cmd.getCommand().equals("teams_by_city")) 
			{
				try
				{
					FileInputStream fstream = new FileInputStream("teams.txt");
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					String strLine, pieces[];				
					String parameters[] = cmd.getParameters();
					
					while ((strLine = br.readLine()) != null)
					{
						pieces = strLine.split(",");
						if (pieces.length == 4 && pieces[1].trim().equals(parameters[0]))
						{
							System.out.println(strLine);
						}
					}
					br.close();
				}
				catch (Exception ex)
				{
					System.out.println("A problem has occurred. Refer to the next line about the exception that was thrown.");
					System.out.println(ex.toString());
				}
				
			} 
			
			else if (cmd.getCommand().equals("load_coaches")) 
			{
				try
				{
					String params[] = cmd.getParameters(), strLine;
					FileInputStream fstream = new FileInputStream(params[0]);
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					FileWriter fw = new FileWriter("coaches_season.txt", true);
					strLine = br.readLine(); //reads in and ignores first line which is the schema
					while ((strLine = br.readLine()) != null)
					{
						fw.write("\n" + strLine);
					}
					fw.close();
				}
				catch (Exception ex)
				{
					System.out.println("A problem has occurred. Refer to the next line about the exception that was thrown.");
					System.out.println(ex.toString());
				}
	        } 
			
			else if (cmd.getCommand().equals("load_teams")) 
			{
				try
				{
					String params[] = cmd.getParameters(), strLine;
					FileInputStream fstream = new FileInputStream(params[0]);
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					FileWriter fw = new FileWriter("teams.txt", true);
					strLine = br.readLine(); //reads in and ignores first line which is the schema
					while ((strLine = br.readLine()) != null)
					{
						fw.write("\n" + strLine);
					}
					fw.close();
					
				}
				catch (Exception ex)
				{
					System.out.println("A problem has occurred. Refer to the next line about the exception that was thrown.");
					System.out.println(ex.toString());
				}			
			} 
			
			else if (cmd.getCommand().equals("best_coach")) 
			{
				try
				{
					FileInputStream fstream = new FileInputStream("coaches_season.txt");
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					String strLine, pieces[];				
					String parameters[] = cmd.getParameters(), tempLine = "";
					int netWins = 0;
					
					while ((strLine = br.readLine()) != null)
					{
						pieces = strLine.split(",");
						if (pieces.length == 10 && pieces[1].trim().equals(parameters[0]))
						{
							if (netWins < Integer.parseInt(pieces[5].trim()) - Integer.parseInt(pieces[6].trim()))
							{
								netWins = Integer.parseInt(pieces[5].trim()) - Integer.parseInt(pieces[6].trim());
								tempLine = pieces[3].trim() + " " + pieces[4].trim();
							}
						}
					}
					System.out.println(tempLine);
					br.close();
				}
				catch (Exception ex)
				{
					System.out.println("A problem has occurred. Refer to the next line about the exception that was thrown.");
					System.out.println(ex.toString());
				}
	
			} 
			
			else if (cmd.getCommand().equals("search_coaches")) 
			{
				try
				{
					String[] params = cmd.getParameters();
					FileInputStream fstream = new FileInputStream("coaches_season.txt");
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					String strLine, pieces[];				
					
					while ((strLine = br.readLine()) != null)
					{
						if (!strLine.equals(""))
						{
							boolean inRow = true;
							pieces = strLine.split(",");
							for (int i = 0; i < params.length; i++)
							{
								if (!pieces[findIndex(params[i].split("=")[0].trim())].trim().equals(params[i].split("=")[1].trim()))
								{
									inRow = false;
								}
							}
							if (inRow)
							{
								System.out.println(strLine.replace(",", ""));
							}
						}
					}
					br.close();
					
				}
				catch (ArrayIndexOutOfBoundsException ex)
				{
					System.out.println("You have entered an invalid column name.");
				}
				catch (Exception ex)
				{
					System.out.println("A problem has occurred. Refer to the next line about the exception that was thrown.");
					System.out.println(ex.toString());
				}
	
			} 
			
			else if (cmd.getCommand().equals("exit")) 
			{
				System.out.println("Leaving the database, goodbye!");
				break;
			} 
			
			else if (cmd.getCommand().equals("")) 
			{
				
			} 
			
			else 
			{
				System.out.println("Invalid Command, try again!");
           	} 
	            
		    if (result) {
	                // ...
	            }

            System.out.print("> "); 
        }        
    }
    
    private boolean doHelp() {
        System.out.println("add_coach ID SEASON FIRST_NAME LAST_NAME SEASON_WIN "); 
	System.out.println("          EASON_LOSS PLAYOFF_WIN PLAYOFF_LOSS TEAM - add new coach data");
        System.out.println("add_team ID LOCATION NAME LEAGUE - add a new team");
        System.out.println("print_coaches - print a listing of all coaches");
        System.out.println("print_teams - print a listing of all teams");
        System.out.println("coaches_by_name NAME - list info of coaches with the specified name");
        System.out.println("teams_by_city CITY - list the teams in the specified city");
	    System.out.println("load_coach FILENAME - bulk load of coach info from a file");
        System.out.println("load_team FILENAME - bulk load of team info from a file");
        System.out.println("best_coach SEASON - print the name of the coach with the most netwins in a specified season");
        System.out.println("search_coaches field=VALUE - print the name of the coach satisfying the specified conditions");
		System.out.println("exit - quit the program");        
        return true;
    }
    private int findIndex(String input)
    {
    	if (input.equals("coachid"))
    	{
    		return 0;
    	}
    	else if (input.equals("year"))
    	{
    		return 1;
    	}
    	else if (input.equals("yr_order"))
    	{
    		return 2;
    	}
    	else if (input.equals("firstname"))
    	{
    		return 3;
    	}
    	else if (input.equals("lastname"))
    	{
    		return 4;
    	}
    	else if (input.equals("season_win"))
    	{
    		return 5;
    	}
    	else if (input.equals("season_loss"))
    	{
    		return 6;
    	}
    	else if (input.equals("playoff_win"))
    	{
    		return 7;
    	}
    	else if (input.equals("playoff_loss"))
    	{
    		return 8;
    	}
    	else if (input.equals("team"))
    	{
    		return 9;
    	}
    	else
    	{
    		return -1;
    	}
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        new P1().run();
    }
    
    

}
