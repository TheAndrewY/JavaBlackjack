# Java Blackjack Console Application

This is a simple console-based Blackjack game implemented in Java. It served as a project to test and reinforce my knowledge of Java's Object-Oriented Programming (OOP) concepts.

## Features

- Play a classic game of Blackjack against the computer (the dealer).
- Follows the standard rules of Blackjack.
- Implements basic OOP principles to model the game components.

## Rules
-  You and the dealer are dealt two cards each initially.
-  You can choose to 'hit' (take another card) or 'stand' (keep your current hand).
-  The goal is to get as close to 21 points without going over.
-  If you or the dealer goes over 21, they lose.

## File Structure
- **Card.java**: Handles card randomization and card object creation.
- **Hand.java**: Handles hand generation and subsequent card draws
- **Person.java**: Parent class for Dealer and Player to handle common actions.
- **Dealer.java**: handles Dealer actions and decisions.
- **Player.java**: Handles player's inputs and actions.
- **Game.java**: The main application that initializes the game.

