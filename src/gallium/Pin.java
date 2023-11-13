package gallium;

import gallium.logic.Dnf;

import java.util.Objects;

public class Pin {
    private String alias;
    private boolean value;
    private String specialValue;
    private Dnf logic;

    public Pin(Pin other) {
        this.alias = other.alias;
        this.value = other.value;
        this.specialValue = other.specialValue;

        this.logic = other.logic;
    }

    public Pin() {
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public boolean getValue() {
        return specialValue == null && value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public String getSpecialValue() {
        return specialValue;
    }

    public void setSpecialValue(String specialValue) {
        this.specialValue = specialValue;
    }

    public Dnf getLogic() {
        return logic;
    }

    public void setLogic(Dnf logic) {
        this.logic = logic;
    }

    public boolean evaluate(Gal gal) {
        if (logic == null) {
            return value;
        }

        return logic.evaluate(gal);
    }

    @Override
    public String toString() {
        return Objects.requireNonNullElseGet(specialValue, () -> value ? " 1 " : " 0 ");
    }
}
