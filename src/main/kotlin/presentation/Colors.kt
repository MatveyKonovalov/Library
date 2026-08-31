package org.example.presentation

enum class Colors(private val command: String) {
    CYAN("\u001B[36m"),    // Title app
    GREEN("\u001B[32m"),   // Title chapter
    RED("\u001B[31m"),     // Invalid Input
    RESET_COLORS("\u001B[0m");

    private val useColors: Boolean = useColorInCurrentSystem()

    fun getColor(): String {
        return if (useColors) command else ""
    }

}

private fun useColorInCurrentSystem(): Boolean {
    val osName = System.getProperty("os.name").lowercase()
    return osName.contains("nix") || osName.contains("nux") ||
            osName.contains("mac") || osName.contains("aix")
}