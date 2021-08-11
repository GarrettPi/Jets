# Jets App

### Overview
Jets App is fully functional jet management database.  It allows the user to view, add, and remove jets from a database representing a nearby airfield.  Additionally, the user can issue orders to the jets to demonstrate special abilities of the airframes.  Jets app also tracks the pilots on the airfield and their current aircraft assignments.
### How to Use
The program's functions are easily accessed from a clear and concise textual menu.  Each menu option is numbered.  To activate any of the options, the user only needs to enter the correct line number and the program will carry out the command.

##### **The Menu**

Please Make a Selection:
1. List Fleet
2. Fly a Jet
3. Fly All Jets
4. View Fastest Jet
5. View Jet With Longest Range
6. Launch All Spaceworthy Jets Into Orbit
7. Cloak All Stealth Jets
8. Add a Jet to Fleet
9. Remove a Jet From Fleet
10. Save Fleet to a File
11. Load a Different Fleet From File
12. Hire a New Pilot
13. List Available Pilots
14. List Assigned Pilots
15. Quit

**Operation**     
**List Fleet** 					- Will display all technical data for all aircraft in the database, along with the assigned pilot.       
**Fly a Jet** 					- Will order an aircraft to take off.  It will then display fuel endurance for the aircraft.        
**Fly All Jets**					- Will order all aircraft to take off.  It will then display fuel endurance for all aircraft.       
**View Fastest Jet** 			- Will access the data on all aircraft, and display the data for the jet with the highest speed.     
**View Jet with Longest Range** - As fastest jet, except will display the data for the jet with the longest range.       
**Launch All Spaceworthy Jets** - Will order all aircraft capable of orbital operations into orbit.      
**Cloak All Stealth Jets** 		- Will order all jets with active camouflage to engage their cloaking devices.       
**Add a Jet to Fleet** 			- Will prompt the user for the type of jet, and all technical data, then add it to database.       
**Remove a Jet From Fleet**		- Will allow the user to specify a jet to be removed from the database.       
**Save Fleet to a File** 		- Will create a local copy of the fleet in a formatted .txt document.        
**Load a Different Fleet** 		- Will prompt the user for the file name, and then load the new fleet into database.        
**Hire New Pilot** 				- Will ask user for name and callsign of new pilot to be hired.     
**List Available Pilots**       - Will list out all the pilots that are currently not assigned to a jet.                        
**List Assigned Pilots**        - Will list out all the pilots currently assigned to a jet, as well as the jet to which they are assigned.                     
**Quit**							- Will exit the program.              

### Technologies

* Collections (Set<> and List<>)
* Interfaces
* File IO
* Exception Management
* Object Oriented Programming
* Abstraction
* Encapsulation
* Instantiation of objects
* Custom Constructors
* Stringbuilders

### Lessons Learned

The main solid lesson I learned with this project is this: attempting to account for all possible user-created errors is going to be the longest part of any development process by far, both initially and then in ongoing maintenance.  I completed my project fairly quickly and then attempted to anticipate all locations where the user might cause errors and I've got to say, it's been quite a slog.  Creating if() statements to catch mistyped entries or try/catch blocks to ensure the user entered the correct type of information could easily have taken just as long as the initial coding did.  I did implement some of this but my time constraints, and fleeting sanity, forced me to reevaluate my priorities for the time being.  Developing a coding practice that initially anticipates, plans for, and implements these safe guards is going to be of top importance to a successful workflow. 