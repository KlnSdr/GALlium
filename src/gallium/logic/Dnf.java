package gallium.logic;

import gallium.Gal;

import java.util.ArrayList;

public class Dnf {
    private final ArrayList<AndTerm> andTerms = new ArrayList<>();

    public void addTerm(AndTerm andTerm) {
        andTerms.add(andTerm);
    }

    public boolean evaluate(Gal gal) {
        boolean result = false;
        for (AndTerm andTerm : andTerms) {
            result |= andTerm.evaluate(gal);
        }
        return result;
    }
}
