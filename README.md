## LPOO_1608 - Pentis

Following up on one of the most successful video games in all history, Pentis surges forward to claim its own spot along
its small brother Tetris as one of the greatest of all time.
With all new desgin and shape, a challenge is guaranteed to be presented before you.

But there's more. Besides hold more than twice the amount of shape presented than in Tetris, the big brother also
gives you the opportunity to call onto Miss Luck and switch the playing shape once everytime a new round starts.
 
This project was developed by *Pedro Fonseca* (*up202108653*@fe.up.pt) and *Jorge Restivo* (*up202108886*@fe.up.pt)
for LPOO 2022/23.

### IMPLEMENTED FEATURES

- **Main Menu** - The player has an interface where they can choose to either
start a new game, enter the HighScore Menu or to exit the game.
- **Automatic Start** - As soon as the player hops into a new game, a shape
to control is already drawn onto the screen, ready to be controlled.

### PLANNED FEATURES

- **Window borders** - To be implemented a "wall" for the game window which will serve as a collision detector so that 
the shapes the player is controlling don't go out of screen.
- **Points Mechanic** - The player will be awarded points every time they clear a line, "survive" another round, 
increasing in value the longer the player has survived.
- **Level counter** - After a player is awarded a certain amount of points, their in-game level is increased, along 
with the game's difficulty.
- **Difficulty Increase** - When a player rises in level, so will the difficulty of the game, meaning the shapes takes
less time to fall, leaving the player with less time to think.
- **HighScore Mechanic** - A tab in the Main Menu where you can see the highest scorer 
- **File To Save HighScore** - A file that saves the current highscores.
- **Shape-Shifting** - The player will have the chance to switch the shape they're controlling once every round.

### DESIGN

> This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts:

- **Problem in Context.** The description of the design context and the concrete problem that motivated the instantiation of the pattern. Someone else other than the original developer should be able to read and understand all the motivations for the decisions made. When refering to the implementation before the pattern was applied, don’t forget to [link to the relevant lines of code](https://help.github.com/en/articles/creating-a-permanent-link-to-a-code-snippet) in the appropriate version.
- **The Pattern.** Identify the design pattern to be applied, why it was selected and how it is a good fit considering the existing design context and the problem at hand.
- **Implementation.** Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it with a UML class diagram, and refer to the corresponding source code with links to the relevant lines (these should be [relative links](https://help.github.com/en/articles/about-readmes#relative-links-and-image-paths-in-readme-files)). When doing this, always point to the latest version of the code.
- **Consequences.** Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with those of alternative solutions.

**Example of one of such subsections**:

------

#### THE JUMP ACTION OF THE KANGAROOBOY SHOULD BEHAVE DIFFERENTLY DEPENDING ON ITS STATE

**Problem in Context**

There was a lot of scattered conditional logic when deciding how the KangarooBoy should behave when jumping, as the jumps should be different depending on the items that came to his possession during the game (a helix will alow him to fly, driking a potion will allow him to jump double the height, etc.). This is a violation of the **Single Responsability Principle**. We could concentrate all the conditional logic in the same method to circumscribe the issue to that one method but the **Single Responsability Principle** would still be violated.

**The Pattern**

We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass). This pattern allowed to address the identified problems because […].

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.

![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)

These classes can be found in the following files:

- [Character](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/Character.java)
- [JumpAbilityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/JumpAbilityState.java)
- [DoubleJumpState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/DoubleJumpState.java)
- [HelicopterState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/HelicopterState.java)
- [IncreasedGravityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/IncreasedGravityState.java)

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the character’s hability to jump become explicit in the code, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.

#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation, and suggest ways in which the code could be refactored to eliminate them. Each smell and refactoring suggestions should be described in its own subsection.

**Example of such a subsection**:

------

#### DATA CLASS

The `PlatformSegment` class is a **Data Class**, as it contains only fields, and no behavior. This is problematic because […].

A way to improve the code would be to move the `isPlatformSegmentSolid()` method to the `PlatformSegment` class, as this logic is purely concerned with the `PlatformSegment` class.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should email the teacher explaining the disagreement.

**Example**:

- John Doe: 40%
- Jane Doe: 60%