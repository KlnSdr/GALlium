import java.util.Arrays;

public class LogicParser {
    public static void parse(String[] logicText, Gal gal) {
        for (String line : logicText) {
            parse(line, gal);
        }
    }

    public static void parse(String line, Gal gal) {
        if (line.lastIndexOf('=') != line.indexOf('=') || line.indexOf('=') == -1 || !line.endsWith(";")) {
            throw new IllegalArgumentException("Line must contain exactly one = and end with ;");
        }

        String[] parts = line.split("=");
        parts = Arrays.stream(parts).map(String::trim).toArray(String[]::new);

        String lhs = parts[0];
        String rhs = parts[1].substring(0, parts[1].length() - 1);

        if (lhs.matches("PIN.*")) {
            parsePinAliasing(lhs.replaceFirst("PIN", "").trim(), rhs, gal);
        }
    }

    private static void parsePinAliasing(String pin, String alias, Gal gal) {
        int pinNumber = Integer.parseInt(pin);
        gal.setAlias(pinNumber, alias);
    }
}
