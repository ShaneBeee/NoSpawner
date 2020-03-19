# NoSpawner

A simple Spigot plugin to prevent mobs from spawning from spawners. 

This plugin is extremely basic, I just saw someone was looking for something like this so I created it.

###Sample config:

```
NoSpawner:
   Prefix: '[NoSpawner]'
   enableForAllWorlds: false
   enableSpawnersInWorld:
   - world
   - world_nether
```
   
###Compile the plugin:
  1. clone the repo
  2. cd into the repo
  3. mvn package