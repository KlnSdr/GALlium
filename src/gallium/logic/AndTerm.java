package gallium.logic;

import gallium.Gal;

import java.util.ArrayList;

public class AndTerm {
    private final ArrayList<Variable> variables = new ArrayList<>();

    public void addVariable(gallium.logic.Variable var) {
        variables.add(var);
    }

    public boolean evaluate(Gal gal) {
        boolean result = true;
        for (Variable variable : variables) {
            result &= variable.evaluate(gal);
        }

        return result;
    }
}
