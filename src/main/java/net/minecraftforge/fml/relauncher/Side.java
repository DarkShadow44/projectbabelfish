package net.minecraftforge.fml.relauncher;

/* Don't delete, works around some fucking bug in Forge relauncher */

public enum Side {
    CLIENT, SERVER;

    public boolean isServer()
    {
        return !isClient();
    }

    public boolean isClient()
    {
        return this == CLIENT;
    }
}
