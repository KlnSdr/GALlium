package gallium.logic;

import gallium.Gal;

public class Variable {
    private final boolean isNegation;
    private final String pinAlias;

    public Variable(String pinAlias, boolean isNegation) {
        this.isNegation = isNegation;
        this.pinAlias = pinAlias;
    }

    public boolean evaluate(Gal gal) {
        boolean value = gal.getPin(pinAlias);
        return isNegation != value;
    }
}
