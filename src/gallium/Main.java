package gallium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final Gal gal = new Gal();
        int ticks = 10;
        String filePath = "";

        // Parsing command line arguments
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.equals("--ticks") || arg.equals("-t")) {
                // Make sure there is another argument available
                if (i + 1 < args.length) {
                    ticks = Integer.parseInt(args[i + 1]);
                    i++; // Skip the next argument since it's the value
                } else {
                    System.err.println("Missing value for ticks argument.");
                }
            } else if (arg.equals("--file") || arg.equals("-f")) {
                // Make sure there is another argument available
                if (i + 1 < args.length) {
                    filePath = args[i + 1];
                    i++; // Skip the next argument since it's the value
                } else {
                    System.err.println("Missing value for filePath argument.");
                }
            } else if (arg.equals("--initial") || arg.equals("-i")) {
                // Make sure there is another argument available
                if (i + 1 < args.length) {
                    setInitialState(args[i + 1], gal);
                    i++; // Skip the next argument since it's the value
                } else {
                    System.err.println("Missing value for initial argument.");
                }
            }
        }

        LogicParser.parse(loadFile(filePath), gal);

        for (int i = 0; i < ticks; i++) {
            gal.pulse();
            System.out.println("tick: " + i);
            System.out.println(gal);
        }
    }

    private static String[] loadFile(String path) {
        ArrayList<String> output = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                output.add(line);
            }
        } catch (Exception e) {
            System.out.println("could not read file: " + path);
        }
        return output.toArray(new String[0]);
    }

    private static void setInitialState(String state, Gal gal) {
        int initialValue;
        if (state.startsWith("0b")) {
            state = state.replaceAll("0b", "");
            initialValue = Integer.parseInt(state, 2);
        } else if (state.startsWith("0x")) {
            state = state.replaceAll("0x", "");
            initialValue = Integer.parseInt(state, 16);
        } else {
            initialValue = Integer.parseInt(state, 16);
        }

        initialValue &= 0xffff; // just for funsies

        for (int i = 0; i < 20; i++) {
            long bit = (initialValue >> i) & 1;
            gal.setPin(i + 1, bit == 1);
        }
    }
}
