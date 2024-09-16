# Geyser Anvil Fix
Finally get your Custom Enchants working with Anvils on Bedrock!


# PaperMC Setup

1. Make sure [Geyser](https://geysermc.org/download/) and/or [floodgate](https://geysermc.org/download/?project=floodgate) is in your plugins
2. Download and install [ProtocolLib](https://ci.dmulloy2.net/job/ProtocolLib/) (If you don't already have it)
3. Download and place in the plugins folder.
4. Restart/Start server


# Proxy Setup (Checkout [ApiaryProxy](https://github.com/ssquadteam/ApiaryProxy) btw)

Install Geyser on proxy
Install floodgate on servers behind proxy and proxy [(more info, under "Proxy Servers" tab)](https://geysermc.org/wiki/floodgate/setup/)
Install this plugin on servers behind the proxy (with [ProtocolLib](https://ci.dmulloy2.net/job/ProtocolLib/))
Run servers to generate files/directories
Move "GeyserAnvilFix-Mapping.json" (Located in this plugin's folder) to Geyser's "custom-mappings" folder
Move "GeyserAnvilFix-Pack.mcpack" (same place) to Geyser's "packs" folder
