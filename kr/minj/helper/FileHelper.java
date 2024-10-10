package kr.minj.helper;
import java.io.*;

import java.io.FileOutputStream;

public class FileHelper {
    private static FileHelper current;

    public static FileHelper getInstance() {
        if (current == null) {
            current = new FileHelper();
        }

        return current;
    }

    private FileHelper() {
        super();
    }

    public void write(String filePath, byte[] data) throws Exception {
      OutputStream os = new FileOutputStream(filePath);
      os.write(data);
    }

    public byte[] read(String filePath) throws Exception {
      //try-catch
      InputStream is = new FileInputStream(filePath);
      byte[] data = new byte[is.available()];
      is.read(data);

      return data;
    }

    public void writeString(String filePath, String content) throws Exception {
      this.write(filePath, content.getBytes("utf-8"));
    }

    public String readString(String filePath) throws Exception {
      byte[] data = read(filePath);
      String content = new String(data, "utf-8");
      return content;
    }
}