package main.Input;

public class Estilos {

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static final String BOLD = "\u001B[1m";
    public static final String ITALIC = "\u001B[3m";
    public static final String UNDERLINE = "\u001B[4m";

    public static final String BG_BLACK = "\u001B[40m";
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_PURPLE = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";
    public static final String BG_WHITE = "\u001B[47m";

    public static String black(String texto) {
        return BLACK + texto + RESET;
    }

    public static String red(String texto) {
        return RED + texto + RESET;
    }

    public static String green(String texto) {
        return GREEN + texto + RESET;
    }

    public static String yellow(String texto) {
        return YELLOW + texto + RESET;
    }

    public static String blue(String texto) {
        return BLUE + texto + RESET;
    }

    public static String purple(String texto) {
        return PURPLE + texto + RESET;
    }

    public static String cyan(String texto) {
        return CYAN + texto + RESET;
    }

    public static String white(String texto) {
        return WHITE + texto + RESET;
    }

    public static String bold(String texto) {
        return BOLD + texto + RESET;
    }

    public static String italic(String texto) {
        return ITALIC + texto + RESET;
    }

    public static String underline(String texto) {
        return UNDERLINE + texto + RESET;
    }

    public static String bgBlack(String texto) {
        return BG_BLACK + texto + RESET;
    }

    public static String bgRed(String texto) {
        return BG_RED + texto + RESET;
    }

    public static String bgGreen(String texto) {
        return BG_GREEN + texto + RESET;
    }

    public static String bgYellow(String texto) {
        return BG_YELLOW + texto + RESET;
    }

    public static String bgBlue(String texto) {
        return BG_BLUE + texto + RESET;
    }

    public static String bgPurple(String texto) {
        return BG_PURPLE + texto + RESET;
    }

    public static String bgCyan(String texto) {
        return BG_CYAN + texto + RESET;
    }

    public static String bgWhite(String texto) {
        return BG_WHITE + texto + RESET;
    }

}
