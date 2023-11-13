public class Main {
    private static final String[] program = {
            "PIN 19 = Q2;",
            "PIN 18 = Q1;",
            "PIN 17 = Q0;"
    };
    public static void main(String[] args) {
        final Gal gal = new Gal();
        LogicParser.parse(program, gal);
        System.exit(0);

        gal.programPin("Q2", gal2 -> {
            boolean q0 = gal2.getPin("Q0");
            boolean q1 = gal2.getPin("Q1");
            boolean q2 = gal2.getPin("Q2");
            boolean x = gal2.getPin("x");

            return (!q2 && q1 && q0) || (q2 && !q1 && !q0) || (q2 && !q1 && x) || (q2 && !q0 && x);
        });
        gal.programPin("Q1", gal2 -> {
            boolean q0 = gal2.getPin("Q0");
            boolean q1 = gal2.getPin("Q1");
            boolean q2 = gal2.getPin("Q2");
            boolean x = gal2.getPin("x");

            return (!q2 && !q1 && q0) || (!q2 && q1 && !q0) || (q1 && !q0 && x) || (!q1 && q0 && x);
        });
        gal.programPin("Q0", gal2 -> {
            boolean q0 = gal2.getPin("Q0");
            boolean q1 = gal2.getPin("Q1");
            boolean q2 = gal2.getPin("Q2");
            boolean x = gal2.getPin("x");

            return (!q2 && !q0) || (!q0 && x) || (!q1 && !q0);
        });
        gal.setPin("x", true);

        for (int i = 1; i <= 12; i++) {
            gal.pulse();
            System.out.println(gal);
        }
    }
}
