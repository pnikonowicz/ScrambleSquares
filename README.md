# ScrambleSquares
This project solves the guitar version of [Scramble Squares](http://www.b-dazzle.com/scramble.asp) although it can easily be 
modified to solve any of those puzzles of any size. Scrambe Squares has 4^9 * 9! combinations and far fewer solutions. 

![Scramble Squares Image](https://github.com/pnikonowicz/ScrambleSquares/blob/master/docs/scramble_square_image.jpg?raw=true)

# Strategy
Each card has 1/2 of an image. These cards are classified in [Cards.java](https://github.com/pnikonowicz/ScrambleSquares/blob/master/src/Cards.java) as a Top (T) side and a Bottom (B) side. After this, the idea is to basically brute force the solution by grabbing cards, rotating them, and greedily appling cards to the card board until a solution that "fits" is found. 

# How to adapt this to your game
If you would like to use this to solve your game, you will need to be able to build this project yourself. Change [Cards.java](https://github.com/pnikonowicz/ScrambleSquares/blob/master/src/Cards.java) to match the cards you have. Each [Card](https://github.com/pnikonowicz/ScrambleSquares/blob/master/src/Card.java) expects 4 sides to exist. 