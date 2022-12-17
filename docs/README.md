## LDTS_1608 - Pentis

Following up on one of the most successful video games in all history, Pentis surges forward to claim its own spot 
along its small brother Tetris as one of the greatest of all time.
With all new desgin and shape, a challenge is guaranteed to be presented before you.

But there's more. Besides hold more than twice the amount of shape presented than in Tetris, the big brother also
gives you the opportunity to call onto Miss Luck and switch the playing shape once everytime a new round starts.
 
This project was developed by *Pedro Fonseca* (*up202108653*@fe.up.pt) and *Jorge Restivo* (*up202108886*@fe.up.pt)
for LDTS 2022/23.

### IMPLEMENTED FEATURES

- **Main Menu** - The player has an interface where they can choose to either
start a new game, enter the HighScore Menu or to exit the game.
- **Automatic Start** - As soon as the player hops into a new game, a shape is already drawn onto the screen, ready to
be controlled.
- **Window borders** - Implemented a "wall" for the game gameWindow which will serve as a collision detector so that
  the shape the player is controlling doesn't go out of bounds.
- **Collision Detector** - This allows the game to not let the shape go out of bounds or make it stop once it reaches
  the floor.
- **Next Shapes** - A visual hint letting the player know what the next 2 playable shapes will look like.
- **Shape Rotation** - By pressing the Arrow-Up key, the shape rotates 90º clockwise.
- **Points Mechanic** - The player is awarded points every time they clear a line or push down a Shape,
  increasing in value the longer the player has survived.
- **Level counter** - After a player is awarded a certain amount of points, their in-game level is increased, along
  with the game's difficulty.
- **Difficulty Increase** - When a player rises in level, so will the difficulty of the game, meaning the shapes takes
  less time to fall, leaving the player with less time to think.
- **Shape-Shifting** - The player has the chance to switch the shape they're controlling once every round.
- **HighScore Mechanic** - A tab in the Main Menu where you can see the highest scorer.
- **File To Save HighScore** - A file that saves the current highscores.

### PLANNED FEATURES


### DESIGN

The UML pattern is the following:
![UML class diagram](img.png)


### TESTING

### SELF-EVALUATION

- Pedro Fonseca: 50%
- Jorge Restivo: 50%