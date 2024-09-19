public enum GhostnetState {
    GEMELDET("Gemeldet"),
    BERGUNG_BEVORSTEHEND("Bergung Bevorstehend"),
    GEBORGEN("Geborgen"),
    VERSCHOLLEN("Verschollen");

    // Feld für den benutzerfreundlichen Namen
    private final String displayName;

    // Konstruktor
    GhostnetState(String displayName) {
        this.displayName = displayName;
    }

    // Methode zum Abrufen des benutzerfreundlichen Namens
    public String getDisplayName() {
        return displayName;
    }

    // Überschreiben der toString()-Methode, um den benutzerfreundlichen Namen zurückzugeben
    @Override
    public String toString() {
        return displayName;
    }
}