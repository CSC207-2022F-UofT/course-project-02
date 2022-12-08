## Program Specification

Our game is basically a chess game involves two players and their army to fight with each other.
The entire game is based on the UI pages, and the "Login" class is the presenter page of our program. 
By running this file, we can access our UI page and enter the game.
We introduce lots of mouselisteners in our UI pages.
In this case, our program will react when players click on the UI pages depending on what decisions players are making.


## Program Instruction
 
The name of the game is "NO MAN'S LAND", and we will provide some instructions to run this program.
First, we should find the "Login" class to enter the game. 
Once you see the login frame, you should enter both the password and username "admin".
Since our game only allow two players to join the game on the same computer, players only need to login once.
Then, players are going to choose their countries on the UI by clicking the related images.
Next, players can choose to buy army on empty cells and start to fight.
To end and switch the turn to the next player, you should click the little square which labed "END TURN",
and confirm by clicking the label "YES" on the right side of the screen.

## Design Pattern 

Overall, our design pattern is Observer design pattern. When the players play the game, our program will create a list
of units, like infantries, tanks, etc. These units are dependents of players. When one player end his turn, then the
units he has will automatically change from selectable to unselectable. When the player decide to attack, these units will call methods to fight or determine what
the attack, defend or other attributes without our commands. These units will also call method that calculate the remaining
HP, which means that these units are automatically adjusting their status. Noticeably, our entities, like
arms and types of constructions follow this design pattern.

Also, we use Builder Design pattern. We build up arms steps by steps and encapsulates codes in each steps. First, we build armnew class
that include all basic variables and methods that a unit should have. Then, we build up different types of arm based on this class, by 
specifying the parameters like HP and rewriting methods like "ToString" method for each types of units. After setting the parameters 
for each type of units, we build classes to determine which players this arm belongs to and the image represent this type of units. 
The implementation of Builder Design pattern enable us to develop different arm types based on armnew

Moreover, we use Strategy Design pattern. There are many selections of different algorithms throughout the game. The most obvious example exists
when we are calculating the damage or deduction in HP if there is a battle happen, when the player decide to use unit A to attack B, 
if the "attack" points of A is lower than the defense of B, our program will choose the algorithm that will cause a 5 point deduction in HP of B. 
When the attack point of A is higher than the defense of unit B, the damage or deduction in HP of unit B will be the attack point of unit A minus the defense of unit B.
The difference in choosing the algorithm based on different parameters/inputs proved our implementation of Strategy Design Pattern

## About tests

Since we include four use cases in our program, which are "Dead", "EndTerm", "fight" and "GetLocation".
Therefore, we generate four related tests for these four use cases under the file of "Test" to ensure we 
follow the clean architecture rule. Also, our code coverage report is include below. 
Since we include four use cases in our program, which are "Dead", "EndTerm", "fight" and "GetLocation".
Therefore, we generate four related tests for these four use cases under the file of "Test" to ensure we
follow the clean architecture rule. Also, our code coverage report is include below.