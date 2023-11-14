# GALlium
Ein simples Programm, dass die einfachste Verwendung eines ?Gal16v8? simuliert.

### Verwendung
- Programmcode in eine Datei schreiben (nur den Teil die Pins betreffend, keine Konfiguration)
- Programm ausführen `java -jar gallium.jar [options]`
  - mit `-t` spezifizieren wie viele Zeitintervalle "simuliert" werden sollen
  - mit `-f` pfad zur datei mit dem Programmcode übergeben
  - mit `-r` werden nur die Bitwerte der Pins als Binärzahl ausgegeben. (Pin 20 = lsb)
  - mit `-i` den initialen Zustand des Gal hinterlegen
    - die übergebene Zahl wird von lsb = pin 1 bis ende/bit 20 = pin 20 gelesen
    - unterstützte formate:
      - `0b` => binär
      - `0x` => hexadezimal
      - *nichts* => dezimal
### Hinweise
- **Gleichungsformen**: Aktuell werden DNF erwartet, alles Weitere wird nicht richtig interpretiert werden.
- **Errorhandling**: Das Program stürzt bei Fehlern stilecht ab.
- **Pins**: Es wird erwartet, dass die D-FF gesetzt werden. Externes Verkabeln ist nicht implementiert.
