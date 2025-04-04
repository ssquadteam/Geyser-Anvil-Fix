# BedrockAnvil Implementation Guide

This guide explains how to properly implement and build the BedrockAnvil plugin.

## Prerequisites

1. Java 21 or higher
2. Gradle (included as wrapper)
3. Required dependencies (see below)

## Dependencies

The plugin requires the following dependencies:

1. **PacketEvents 2.7.0**
   - Download from: https://github.com/retrooper/packetevents/releases/tag/v2.7.0
   - Maven: `com.github.retrooper:packetevents-spigot:2.7.0`

2. **Geyser API**
   - Maven: `org.geysermc.geyser:api:2.2.0-SNAPSHOT`
   - Repository: https://repo.opencollab.dev/main/

3. **Floodgate API**
   - Maven: `org.geysermc.floodgate:api:2.2.2-SNAPSHOT`
   - Repository: https://repo.opencollab.dev/main/

## Building the Plugin

1. Place the PacketEvents JAR in the `libs` directory (create it if it doesn't exist)
2. Run `./gradlew clean build` to build the plugin
3. The JAR file will be located in `build/libs/`

## Implementation Notes

- The plugin uses PacketEvents to modify anvil-related packets for Bedrock players
- It provides a custom anvil interface that supports proper enchanting for Bedrock players
- The plugin works with either Geyser or Floodgate (or both) for detecting Bedrock players

## Plugin Structure

- `BedrockAnvilPlugin` - Main plugin class
- `hooks` - Contains hooks for Geyser and Floodgate
- `inventory` - Contains classes for the custom anvil inventory
- `events` - Contains packet and event handlers
- `config` - Contains configuration classes

## Common Issues

If you encounter issues with the PacketEvents imports, ensure you're using the correct package paths:

```java
// Correct imports for PacketEvents 2.7.0
import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
```

## Resources

For more information on how to use PacketEvents, refer to:
- PacketEvents Wiki: https://github.com/retrooper/packetevents/wiki 