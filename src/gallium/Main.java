package gallium;

public class Main {
    private static final String[] program = {
            "PIN 2 = x;",
            "PIN 19 = q2;",
            "PIN 18 = q1;",
            "PIN 17 = q0;",
            "q0.d = (!q2 & !q0) # (!q0 & x) # (!q1 & !q0);",
            "q1.d = (!q2 & !q1 & q0) # (!q2 & q1 & !q0) # (q1 & !q0 & x) # (!q1 & q0 & x);",
            "q2.d = (!q2 & q1 & q0) # (q2 & !q1 & !q0) # (q2 & !q1 & x) # (q2 & !q0 & x);"
    };
    public static void main(String[] args) {
        final Gal gal = new Gal();
        LogicParser.parse(program, gal);
        gal.setPin("x", true);

        for (int i = 1; i <= 12; i++) {
            gal.pulse();
            System.out.println(gal);
        }
    }
}
