public class Gal {
    private final Pin[] pins = new Pin[20];

    public Gal() {
        for (int i = 0; i < 20; i++) {
            pins[i] = new Pin();
        }
        // hardcoding, let's fucking gooooo!
        pins[0].setSpecialValue("CLK");  // pin 1
        pins[9].setSpecialValue("GND");  // pin 10
        pins[19].setSpecialValue("VCC"); // pin 20
        pins[10].setSpecialValue("OE");  // pin 11
    }

    public boolean getPin(int pin) {
        if (pin < 1 || pin > 20) {
            throw new IllegalArgumentException("Pin must be between 1 and 20");
        }

        return pins[pin - 1].getValue();
    }

    public void setPin(int pin, boolean value) {
        if (pin < 1 || pin > 20) {
            throw new IllegalArgumentException("Pin must be between 1 and 20");
        }

        pins[pin - 1].setValue(value);
    }

    public boolean getPin(String alias) {
        for (Pin pin : pins) {
            if (pin.getAlias().equals(alias)) {
                return pin.getValue();
            }
        }

        throw new IllegalArgumentException("Pin with alias " + alias + " not found");
    }

    public void setPin(String alias, boolean value) {
        for (Pin pin : pins) {
            if (pin.getAlias().equals(alias)) {
                pin.setValue(value);
                return;
            }
        }

        throw new IllegalArgumentException("Pin with alias " + alias + " not found");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append((i + 1)).append("\t").append(pins[i]).append(" --- ").append(pins[19 - i]).append("\t").append(20 - i).append("\n");
        }
        return sb.toString();
    }
}
