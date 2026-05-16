## Final Project 

Welcome to my Finall project Bank Account 

## Author: Eric Orea
## Date: 5/13/26

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `doc`: the folder to maintain documentation related to my project (UML diagram, etc)

## 🏛️ Application Architecture

The system consists of three primary source files:

1. **`BankAccount.java`**: Which is the foundational class that creates the (ID, owner name, balance) and makes sure that it works by (validating non-negative entries and handles automatic serial ID etc).
2. **`BankApp.java`**: A robust text-based Command Line Interface. Which Uses a looping menu structure with validation mechanics to process transactions and handle scanner token errors safely.
3. **`BankAccountGUI.java`**: A functional swing desktop layout featuring a dynamic real-time dashboard view, centralized window action listening components, and because it is a graphical user interface it might be easier to understand since it is something that is visual and most people can understand things more clearly when something is visual.

## ✨ Features

* **Auto-Generated ID**: Which makes it so each person has their own id sequence which initialization begins at `1000`.
* **State Mutation Integrity**: mutation updates (`Edit Name`) which preserves the existing account ID and current balances safely while being able to change the name of the account.
* **Safe Transaction Handlers**: Built-in logic bounds parameters to reject non-positive, or other inputs as well.

## 🚀 Setup & Execution


### Prerequisites
* **Java Development Kit (JDK)**
* **Environment Variable**: Ensure `java` and `javac` are configured correctly in your system PATH.

### 1. Build Compilation
You can usually copy the source files into a single project folder, open your terminal/command prompt within that directory, and run the following command.

### 2. Launching Options
I would say you only really have one option and that option is option A: To run the Graphical Desktop (GUI) version Because that is what most people have been doing in my Class.



 
 