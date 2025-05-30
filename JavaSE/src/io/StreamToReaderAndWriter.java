package io;

import java.io.*;

public class StreamToReaderAndWriter {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);

        OutputStream outputStream = System.out;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

    }
}
