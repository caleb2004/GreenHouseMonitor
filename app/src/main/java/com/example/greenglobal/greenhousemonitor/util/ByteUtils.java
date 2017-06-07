package com.example.greenglobal.greenhousemonitor.util;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class ByteUtils {

    private static final String TAG = ByteUtils.class.getSimpleName();
    private static final String CHARSET_NAME = "ISO646-US"; // ASCII

    private ByteUtils() {
        // Not meant to be instantiated.
    }

    public static int parseInt(final byte[] bytes) {
        if (bytes.length > 4) {
            throw new IllegalArgumentException("The integer value might change during conversion.");
        }

        return (int) parseLong(bytes);
    }

    public static long parseLong(final byte[] bytes) {
        long value = 0;
        for (int i = bytes.length - 1; i >= 0; i--) {
            final byte aByte = bytes[i];
            value = (value << 8) + (aByte & 0xff);
        }
        return value;
    }

    public static String parseString(final byte[] bytes) {
        try {
            return new String(bytes, CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "Unsupported charset " + CHARSET_NAME, e);
            return null;
        }
    }

    public static byte[] readBytes(final File file) {
        final byte[] data = new byte[(int) file.length()];
        try {
            final FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(data);
        } catch (Exception e) {
            Log.e(TAG, "Error reading file: " + file.getName(), e);
        }
        return data;
    }

    public static byte[] readBytes(final InputStream inputStream) {
        final ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

        final byte[] buffer = new byte[1024];

        try {
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                byteBuffer.write(buffer, 0, length);
            }
        } catch (Exception e) {
            Log.e(TAG, "Couldn't convert input stream to bytes.", e);
        }

        return byteBuffer.toByteArray();
    }

    public static byte intToByte(final int value){
        return ByteBuffer.allocate(4).putInt(value).array()[3];
    }
}
