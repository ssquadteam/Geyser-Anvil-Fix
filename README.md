# Geyser Anvil Fix
Finally get your Custom Enchants working with Anvils on Bedrock!


# PaperMC Setup

1. Make sure [Geyser](https://geysermc.org/download/) and/or [floodgate](https://geysermc.org/download/?project=floodgate) is in your plugins
2. Download and install [PacketEvents](https://github.com/retrooper/packetevents) version 2.7.0
3. Download and place this plugin in the plugins folder.
4. Restart/Start server


# Proxy Setup (Checkout [ApiaryProxy](https://github.com/ssquadteam/ApiaryProxy) btw)

1. Install Geyser on proxy
2. Install floodgate on servers behind proxy and proxy [(more info, under "Proxy Servers" tab)](https://geysermc.org/wiki/floodgate/setup/)
3. Install this plugin and [PacketEvents](https://github.com/retrooper/packetevents) on servers behind the proxy
4. Run servers to generate files/directories
5. Move "GeyserAnvilFix-Mapping.json" (Located in this plugin's folder) to Geyser's "custom-mappings" folder
6. Move "GeyserAnvilFix-Pack.mcpack" (same place) to Geyser's "packs" folder

# Features
- Allows Bedrock players to use Anvils with custom enchantments
- Compatible with 1.21.X servers
- Uses PacketEvents instead of ProtocolLib for packet handling
- Supports multiple anvil interaction modes (Always, When Sneaking, When Not Sneaking)

# Credits
This plugin is a rewrite of the original Geyser Anvil Fix concept.

Original concept credits to [Sideways Sky](https://github.com/Sideways-Sky/Geyser-Recipe-Fix)

# BedrockAnvil

A Spigot/Paper plugin that provides a custom anvil interface for Bedrock players (via GeyserMC), enabling them to use custom enchantments properly.

## Features

- Custom anvil interface specifically designed for Bedrock players
- Allows Bedrock players to use anvils with custom enchantments
- Compatible with Minecraft 1.21.X servers
- Option to access vanilla anvil interface if needed
- Multiple activation modes (Always, When Sneaking, When Not Sneaking)

## Requirements

- Spigot or Paper 1.21.X
- [GeyserMC](https://geysermc.org/) or [Floodgate](https://geysermc.org/download/?project=floodgate)
- [PacketEvents](https://github.com/retrooper/packetevents) 2.7.0

## Installation

### Server Setup

1. Install [GeyserMC](https://geysermc.org/download/) and/or [Floodgate](https://geysermc.org/download/?project=floodgate)
2. Install [PacketEvents](https://github.com/retrooper/packetevents) version 2.7.0
3. Download and place BedrockAnvil in your plugins folder
4. Restart your server

### Proxy Setup

If you're using a proxy setup (like Velocity, BungeeCord, or [ApiaryProxy](https://github.com/ssquadteam/ApiaryProxy)):

1. Install Geyser on your proxy
2. Install Floodgate on both your proxy and backend servers [(more info)](https://geysermc.org/wiki/floodgate/setup/)
3. Install BedrockAnvil and PacketEvents on your backend servers
4. Run servers to generate necessary files
5. Move mapping and resource pack files to Geyser's directories

## Configuration

```yaml
# BedrockAnvil Configuration

anvil:
  # When should the anvil interface be replaced with the custom interface for Bedrock players
  # ENABLED - Always replace the anvil interface (default)
  # DISABLED - Never replace the anvil interface
  # SNEAKING - Only replace the anvil interface when the player is sneaking
  # NOTSNEAKING - Only replace the anvil interface when the player is not sneaking
  mode: "ENABLED"

  # Whether to show a button that allows opening the vanilla anvil interface
  # This is useful for players who want to access the vanilla functionality
  forward: true

# Enable debug logging (will be verbose)
debug: false
```

## Building from Source

See [IMPLEMENTATION.md](IMPLEMENTATION.md) for details on building the plugin from source and the technical implementation details.

> **Note**: There are known issues with PacketEvents import paths in the code. You'll need to manually install the correct version of PacketEvents (2.7.0) and ensure the import paths match the actual library structure.

## License

This plugin is available under the MIT License. See the LICENSE file for more details.

## Credits

- Special thanks to the developers of PacketEvents, Geyser, and Floodgate
- Inspired by the concept from [Geyser Recipe Fix by Sideways Sky](https://github.com/Sideways-Sky/Geyser-Recipe-Fix)
