package com.xiazeyu.spider.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipUtil {

    private static final byte[] DEFAULT_BINARY = new byte[0];

    private static final String DEFAULT_CONTENT = "";

    public static final String GZIP_ENCODE_UTF_8 = "UTF-8";

    public static final String GZIP_ENCODE_ISO_8859_1 = "ISO-8859-1";

    public static byte[] compress(String content) {
        return compress(content, GZIP_ENCODE_UTF_8);
    }

    public static byte[] compress(String content, String encoding) {
        if (content == null || content.isEmpty()) {
            return DEFAULT_BINARY;
        }
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             GZIPOutputStream gos = new GZIPOutputStream(baos)
        ) {
            gos.write(content.getBytes(encoding));
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DEFAULT_BINARY;
    }

    public static String extract(byte[] binary) {
        return extract(binary, GZIP_ENCODE_UTF_8);
    }

    public static String extract(byte[] binary, String encoding) {
        if (binary == null || binary.length == 0) {
            return DEFAULT_CONTENT;
        }
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ByteArrayInputStream bais = new ByteArrayInputStream(binary);
             GZIPInputStream gis = new GZIPInputStream(bais)
        ) {
            byte[] buffer = new byte[1024];
            int n;
            while ((n = gis.read(buffer)) >= 0) {
                baos.write(buffer, 0, n);
            }
            return baos.toString(encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DEFAULT_CONTENT;
    }

}
