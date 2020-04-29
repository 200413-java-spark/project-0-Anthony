# Java Warrior: A text-based CLI Battle simulator
## Features include:
### 1. Battling Enemies with Tiered Health and Damage Values
### 2. Saved Game Files on a persistent SQL Database
### 3. In Game Store
### 4. Character Attributes and Levels
## Build
### Java
>mvn clean compile exec:java
### or 
>./runbuild.sh

## Usage
### For entertainment

## Design
### Architecture
- Java Warrior is designed to be a cookie cutter text-based RPG adventure/fighting game.
- Players, Enemies, and items are categorized into classes and subclasses
- The io.SqlDataManagement file reads, writes, and updates SQL files to and from a persistent SQL Database

### Gameplay
- Gameplay starts with entering a name for the character
- Once started, 4 options await:
  - Battle
    - Battle a random enemy. These enemies are not scaled, so you may encounter difficult enemies at the start
    - Enemies have a chance to drop trinkets, which may be sold for gold in the town store. More difficult enemies drop better trinkets.
    - Players may guard attacks to reduce damage. This may be useful against stronger enemies.
    - Players may drink potions, restoring their health.
    - Players may flee.  Beware, this will cause the enemy to perform an opportune attack on the fleeing player, dealing extra damage.
  - Shop
    - In the shop, players may buy or sell items
      - Buying Items
        - Items for sale are potions for 30 gold, and large potions, for 60 gold.  
        - Each potion restores 30 and 60 health, respectively
      - Selling Items
        - Players may sell trinkets they receive from defeating monsters
        - Bronze trinkets sell for 20 gold
        - Silver trinkets sell for 40 gold
        - Golden trinkets sell for 80 gold
  - Save
    - When not in combat, players may save their game to the persistent SQL database
  - Quit
    - When not in combat, players may save and exit the game
- Enemies
  - Bandit
    - The most common enemy, has the highest chance of appearing
    - May drops bronze trinkets, and is relatively weak
  - Witch
    - Another common enemy, has lower health, but increased damage
    - Drops bronze trinkets, with a small chance of dropping silver trinkets
  - Werewolf
    - Uncommon enemy, has increased health and damage
    - Drops bronze and silver trinkets, with a small chance of dropping golden trinkets
  - Demon
    - Rare enemy, has the most amount of health and damage
    - Drops silver trinkets, with a chance of dropping golden trinkets
- Defeating Enemies
  - Each enemy defeated will award a point. Points are tracked and updated to the SQL Database
- Falling in Battle
  - If the player falls in battle, the character is deleted from the database.
  - Restarting the application will prompt for a new name

- Future Development
  - Restructuring Engine.java to be more object oriented
  - Additional JUnit tests
  - User customizable difficulty
  - Character levels, experience, equipment
  - Bosses, locations, special abilities