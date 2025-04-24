public enum Languages {
    PT_BR("Portuguese", "PT_BR.txt"),
    EN_US("English", "EN_US.txt");

    private final String description;
    private final String fileName;

    Languages(String description, String fileName) {
        this.description = description;
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public String getFileName() {
        return fileName;
    }
}
