# Maze-Exploration-Game
This project is a text-based maze exploration game developed in Java. 
The goal of the game is to guide a player from a starting point (B) to an end point (E) within a 15x15 two-dimensional character matrix representing a maze. Along the way, the player encounters obstacles and collects bonuses to achieve the highest possible score.

🕹️ Gameplay Features
Player Movement:

W – Move Up

A – Move Left

S – Move Down

D – Move Right

Obstacles:

#: Wall – Can only be removed if the player has the Remove Obstacle Bonus (R).

!: Mine – Explodes unless the player has the Defuse Mine Bonus (F).

Bonuses:

T: Teleport to a user-chosen coordinate (cannot be wall or mine).

R: Remove a wall in the current direction.

H: Decrease total step count by 2.

F: Defuse a mine and move forward.

Dynamic Elements:

Every 5 steps, all mines and bonuses are randomly repositioned.

The game prints updates after each move and handles user input interactively.

🛠️ Additional Features
Console-based user interface.

Input validation and edge-case handling.

Tracks steps and collected bonuses.
