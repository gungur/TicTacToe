# Tic Tac Toe Game

## Overview
This is a simple Java implementation of the classic Tic Tac Toe game where a player can compete against a computer opponent. The game features a text-based interface and follows standard Tic Tac Toe rules.

## Features
- Player vs CPU gameplay
- Input validation to prevent overwriting occupied positions
- Clear visual representation of the game board
- Automatic win/tie detection
- Random CPU moves

## How to Play
1. Clone or download the repository
2. Compile and run the `TicTacToe.java` file
3. When prompted, enter a number from 1-9 to place your 'X' on the corresponding board position:
   ```
    1 | 2 | 3
    ---------
    4 | 5 | 6
    ---------
    7 | 8 | 9
   ```
4. The CPU will automatically make its move after your turn
5. The game continues until either player wins or the board is full (tie)

## Game Rules
- The player is 'X' and goes first
- The CPU is 'O' and moves randomly
- First to get three in a row (horizontally, vertically, or diagonally) wins
- Game ends in a tie if all positions are filled without a winner

## Code Structure
The program consists of:
- `main()` method to run the game loop
- `printGameBoard()` to display the current board state
- `placePiece()` to update the board with player/CPU moves
- `checkWinner()` to determine game outcome

## Requirements
- Java JDK (version 8 or higher recommended)

## Example Output
```
Enter your placement (1-9)
2
 |X| 
-+-+-
 | | 
-+-+-
O| | 
```

## Limitations
- No difficulty settings (CPU always plays randomly)
- Basic text interface
- No score tracking between games

## Future Improvements
- Add multiple difficulty levels
- Implement a graphical interface
- Add score tracking
- Allow player vs player mode
