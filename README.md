# GALlium
Ein simples Programm, dass die einfachste Verwendung eines ?Gal16v8? simuliert.

### Andwendung
- Programmcode in eine Datei schreiben (nur den Teil die Pins betreffend, keine Konfiguration)
- Programm ausführen
  - mit `-t` spezifizieren wie viele Zeitintervalle "simuliert" werden sollen
  - mit `-f` pfad zur datei mit dem Programmcode übergeben
  - mit `-i` den initialen Zustand des Gal hinterlegen
    - die übergebene Zahl wird von lsb = pin 1 bis ende/bit 20 = pin 20 gelesen
    - unterstützte formate:
      - `0b` => binär
      - `0x` => hexadezimal
      - *nichts* => dezimal
### Hinweise
- **Gleichungsformen**: Aktuell werden DNF erwartet, für alles Weitere wird nicht richtig interpretiert werden.
- **Errorhandling**: Das Program stürzt bei Fehlern stilecht ab.
