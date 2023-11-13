public class Pin {
    private String alias;
    private boolean value;
    private String specialValue;

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

    public void setSpecialValue(String specialValue) {
        this.specialValue = specialValue;
    }

    @Override
    public String toString() {
        if (specialValue != null) {
            return specialValue;
        }
        return value ? " 1 " : " 0 "; // hardcoding stuff, we sure love it
    }
}
