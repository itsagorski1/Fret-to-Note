package com.jonah;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.System;

public class fretToNote {
    public int fret;
    public String string;
    public int octave;
    public int note;
    public int tuning;
    public String finalNote;
    public static HashMap<Integer, String> notes = new HashMap<Integer, String>();
    public static Scanner sc = new Scanner(System.in);
    public static void notes() {
        notes.put(1,"C");
        notes.put(2,"C#");
        notes.put(3,"D");
        notes.put(4,"D#");
        notes.put(5,"E");
        notes.put(6,"F");
        notes.put(7,"F#");
        notes.put(8,"G");
        notes.put(9,"G#");
        notes.put(10,"A");
        notes.put(11,"A#");
        notes.put(12,"B");
    }
    public static int getFret() {
        System.out.print("What Fret?\n>> ");
        int fret = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline
        return fret;
    }
    public static String getString() {
        System.out.print("What String?\n>> ");
        return sc.nextLine();
    }
    public static int getTuning() {
        System.out.print("What Tuning?\n>> ");
        int tune = sc.nextInt();
        sc.nextLine();
        return tune;
    }
    public static void main(String[] args) {
        fretToNote nonStaticVars = new fretToNote();
        nonStaticVars.fret = getFret();
        nonStaticVars.string = getString();
        nonStaticVars.tuning = getTuning();
        notes();
        if (nonStaticVars.string.equals("E")) {
            nonStaticVars.note = 5; // E is the 5th note (if C=1)
            nonStaticVars.octave = 2;
        } else if (nonStaticVars.string.equals("A")) {
            nonStaticVars.note = 10; // A is the 10th note
            nonStaticVars.octave = 2;
        } else if (nonStaticVars.string.equals("D")) {
            nonStaticVars.note = 3; // D is the 3rd note
            nonStaticVars.octave = 3;
        } else if (nonStaticVars.string.equals("G")) {
            nonStaticVars.note = 8; // G is the 8th note
            nonStaticVars.octave = 3;
        } else if (nonStaticVars.string.equals("B")) {
            nonStaticVars.note = 12; // B is the 12th note
            nonStaticVars.octave = 3;
        } else if (nonStaticVars.string.equals("e'")) {
            nonStaticVars.note = 5; // High e is the 5th note
            nonStaticVars.octave = 4;
        } else {
            System.err.println("Invalid string input. Exiting.");
            System.exit(1);
        }
        nonStaticVars.note += nonStaticVars.tuning;
        nonStaticVars.note += nonStaticVars.fret;
        if (nonStaticVars.note <= 0) {
            System.err.println("Resulting note index is invalid (0 or negative). Exiting.");
            System.exit(1);
        }
        int noteIndex = nonStaticVars.note;
        if (noteIndex > 12) {
            nonStaticVars.octave += (noteIndex - 1) / 12;
            noteIndex = noteIndex % 12;
            if (noteIndex == 0) {
                noteIndex = 12;
            }
        }
        nonStaticVars.finalNote = fretToNote.notes.get(noteIndex);
        System.out.print(String.format("The note is %s%s.", nonStaticVars.finalNote, nonStaticVars.octave));
    }
}