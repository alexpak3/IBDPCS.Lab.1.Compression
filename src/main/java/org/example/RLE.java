package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RLE {

    public static void main(String[] args) throws FileNotFoundException {
        String decompressedString = textToString("src/main/resources/COVID-19");
        String compressedString = compress(decompressedString);
        System.out.println(compressedString);
    }

    /** This method converts the information stored in a text file into a String. */
    public static String textToString(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            String subSeq = sc.next();
            for (int i = 0; i < subSeq.length(); i++) {
                sb.append(subSeq.charAt(i));
            }
        }
        return sb.toString();
    }

    /** TODO 1: Given a String (a genome sequence of COVID-19) implement the RLE algorithm that will use RLE to compress a String. Returns the compressed String. */
    public static String compress(String uncompressed) {if ( uncompressed.isEmpty() || uncompressed == null){
        return null;

    }
        StringBuilder str = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= uncompressed.length(); i++) {

            if (i == uncompressed.length() || uncompressed.charAt(i) != uncompressed.charAt(i - 1)) {
                str.append(count);
                str.append(uncompressed.charAt(i - 1));
                count = 1;
            } else {
                count++;
            }
        }

        return str.toString();}

    /** TODO 2: Given a String (a genome sequence of COVID-19) implement the RLE algorithm that will use RLE to decompress a String. Returns the uncompressed String. */
    public static String decompress(String compressed) {
        if (compressed.isEmpty() || compressed == null){
            return null;
        }
        StringBuilder str = new StringBuilder();

        int i = 0;

        while (i < compressed.length()) {
            StringBuilder countBuilder = new StringBuilder();
            while (i < compressed.length() && Character.isDigit(compressed.charAt(i))) {
                countBuilder.append(compressed.charAt(i));
                i++;
            }

            if (i < compressed.length()) {
                char character = compressed.charAt(i);
                i++;
                int count = Integer.parseInt(countBuilder.toString());
                for (int j = 0; j < count; j++) {
                    str.append(character);
                }
            }
        }

        return str.toString();    }


}
