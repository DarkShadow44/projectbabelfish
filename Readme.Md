# Project Babelfish

### WARNING: HEAVILY WIP

Currently Supported Version: 1.16.5
Might or might not be suddenly abandoned. The sheer complexity of the task may make this unfeasible, especially for a single developer.

### About

Project Babelfish is an attempt to run Forge mods on Fabric. Not only the latest version (like PatchworkMC), but also older forge mods, notably the ones made for 1.12.2 and 1.7.10.
Later maybe even older Fabric mods.
Only mods that are completely out of the question, are mods that either do jar modding or heavy core modding with asm. Mixin should be supported in the future, but not a priority as of now.

### Status

Protype Stage
An early POC is ready is done for 1.7.10 on 1.12.2
Currently developing 1.16.5 forge on 1.16.5 fabric

### How to Use

Download the latest version from \<TODO\>
Currently, don't. Unless you like broken stuff, then feel free to compile from source. :)

### Mod Support

NONE. At this point, don't bother opening issues.

### Issues

For unsupported mods, don't bother reporting an issue, it will be ignored. You can however, request a mod to be officially supported.

For officially supported mods, please update to the latest version of Project Babelfish and try again.
If the issue persists, check the open issues at https://github.com/DarkShadow44/projectbabelfish/issues
If the problem is not reported yet, please open a ticket.

### Technical Details

Project Babelfish is basically a mod loader itself.
We load mods into a sandbox, completely separating all their classes from Vanilla Minecraft / Forge. This transformation ensures that every breaking change in Minecraft/Forge/Fabric can be abstracted away.
Missing functionality (i.e. ISBRH from 1.7.10) needs to be reimplemented on top of Vanilla Minecraft and Fabric API.
Mixins will also be transformed, but need special handling - they need to be manually called for each mod, making coremod support a lot harder.
ASM would need to bre rewritten as Mixins, and is thus not planned to be supported.

All needed hooks for the Mixins of the supported mods and used Forge APIs will be added into the Project Babelfish library for easier reuse.

### Roadmap

1) Support for smaller 1.16.5 mods (Tiny Redstone?)
2) Support for complex 1.16.5 mods (Create?)
3) Support for smaller 1.12.2 mods
4) Support for complex 1.12.2 mods
5) Support for smaller 1.10.2 mods (Super Circuit Maker)
6) Support for smaller 1.7.10 mods (Garden Stuff)
7) Support for complex 1.7.10 mods (Thaumcraft)


### Credits

Thanks to the Fabric Team for making this possible.
Also thanks to the Forge Team for making the Forge API in the first place. Some code of Forge will be used in this project.
