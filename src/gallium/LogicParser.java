package gallium;

import gallium.logic.AndTerm;
import gallium.logic.Dnf;
import gallium.logic.Variable;

import java.util.Arrays;

public class LogicParser {
    private static final String AND = "&";
    private static final String OR = "#";
    private static final String NOT = "!";
    public static void parse(String[] logicText, Gal gal) {
        for (String line : logicText) {
            parse(line, gal);
        }
    }

    public static void parse(String line, Gal gal) {
        if (line.trim().isEmpty()) {
            return;
        }
        if (line.lastIndexOf('=') != line.indexOf('=') || line.indexOf('=') == -1 || !line.endsWith(";")) {
            throw new IllegalArgumentException("Line must contain exactly one = and end with ;");
        }

        String[] parts = line.split("=");
        parts = Arrays.stream(parts).map(String::trim).toArray(String[]::new);

        String lhs = parts[0];
        String rhs = parts[1].substring(0, parts[1].length() - 1);

        if (lhs.matches("PIN.*")) {
            parsePinAliasing(lhs.replaceFirst("PIN", "").trim(), rhs, gal);
        } else if (lhs.matches(".*\\.d.*")) {
            parseLogicBurn(lhs.replace(".d", ""), rhs, gal);
        }
    }

    private static void parsePinAliasing(String pin, String alias, Gal gal) {
        int pinNumber = Integer.parseInt(pin);
        gal.setAlias(pinNumber, alias);
    }

    private static void parseLogicBurn(String pinAlias, String logic, Gal gal) {
        logic = logic.replaceAll(" ", "");

        final String[] terms = logic.split(OR);
        final Dnf dnf = new Dnf();

        for(String term: terms) {
            term = term.replaceAll("\\(", "").replaceAll("\\)", "");
            final String[] vars = term.split(AND);
            final AndTerm andTerm = new AndTerm();

            for (String var: vars) {
                boolean isNegation = var.startsWith(NOT);
                final Variable variable = new Variable(isNegation ? var.substring(1) : var, isNegation);
                andTerm.addVariable(variable);
            }

            dnf.addTerm(andTerm);
        }

        gal.programPin(pinAlias, dnf);
    }
}
