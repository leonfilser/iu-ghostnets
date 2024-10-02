/**
 * Enum representing the different states a ghostnet can have.
 */

public enum GhostnetState {
    GEMELDET("Gemeldet"),
    BERGUNG_BEVORSTEHEND("Bergung Bevorstehend"),
    GEBORGEN("Geborgen"),
    VERSCHOLLEN("Verschollen");

    // Human-readable name of the state for display purposes
    private final String displayName;

    GhostnetState(String displayName) {
        this.displayName = displayName;
    }

    //Returns the display name of the ghostnet state.
    public String getDisplayName() {
        return displayName;
    }


    //Overrides the default toString() method to return the display name.
    @Override
    public String toString() {
        return displayName;
    }
}