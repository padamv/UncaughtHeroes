# UncaughtHeroes

UncaughtHeros is a SPRING BOOT-based RPG (Role-Playing Game) application designed to manage various characters and campaigns along with their current progress and states.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

UncaughtHeros is an exciting RPG game that allows players to create, customize, and embark on thrilling adventures in various campaigns. With this SPRING BOOT application, players can manage their characters, track their progress, and engage in captivating storytelling.

## Features

- **Character Management**: Create and manage multiple characters with unique abilities, attributes, and equipment.
- **Campaign Tracking**: Keep track of the progress and achievements of your characters in different campaigns.
- **State Management**: Record and update the current state of characters and campaigns, such as levels, experience points, items, and quest progress.
- **Interaction**: Interact with non-player characters (NPCs), other players, and the game world to discover quests, engage in combat, and explore the game universe.
- **Battle System**: Engage in turn-based battles, strategize your actions, and defeat enemies to level up and obtain rewards.
- **Item Management**: Acquire and manage various items, weapons, armor, and consumables to enhance your characters' abilities.
- **Storytelling**: Immerse yourself in rich narrative-driven campaigns with engaging quests, dialogues, and hero interactions.

## Requirements

To run the UncaughtHeros application, you need the following:

- Java Development Kit (JDK) 17 or above
- Maven build tool
- Docker

## Installation
1. Clone the repository and go to the repository's folder
2. If needed, rebuild all docker images with ```docker-compose build --no-cache```
3. Start the application with ```docker-compose up -d```

## Usage
After the docker deployment is done you can access the startpage at http://localhost:8081/html/uncaught_heroes.html or http://127.0.0.1:8081/html/uncaught_heroes.html \
Access the API documentation at http://localhost:8080/swagger-ui/index.html
In the examples folder you can find and example json that you can import to the DB's dungeons folder.

## Contributing
## License