This is what I would have submitted as a summative, if it weren't cancelled by the TDSB due to 
quadmesters.

## TTTGenerator
In the TTTGenerator folder, Main.java simulates a game of Tic-Tac-Toe between two players, making 
random moves. It runs the simulation 10 times, and displays results at the end. This program uses 
2D arrays, methods, loops, conditional statements, arithmetic operators, and ArrayLists.

To compile: `javac Main.java`<br>
To run: `java Main`

## TTTGame
In the TTTGame folder, Main.java contains the driver code for a Tic-Tac-Toe game against a 
computer. Board.java conatins a Board class that prints a BoardState into a nicely formatted 
display to the console. BoardState.java contains the BoardState class, used to store information 
about a board state, including the filled squares, winner, and optimal move.

The driver code runs DFS to precompute all possible board states, and stores the results in a 
HashMap for easy lookup. When the player starts playing, the optimal move is retrieved from the 
precomputed BoardStates, and the computer returns the optimal move.

This program uses 2D arrays, methods, classes, loops, conditional statements, arithmetic 
operators, ArrayLists, HashMaps, Streams, and basic graph theory algorithms.

To compile: `javac Main.java`<br>
To run: `java Main`
