import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Convert {
  public static void main(String[] args) throws IOException {
    try (FileInputStream fis = new FileInputStream("sample.txt")) {
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"))) {

        int chapter = 1;
        int lineNumber = 0;

        String line;
        StringBuilder content = new StringBuilder();
        while ((line = reader.readLine()) != null) {

          line = line.trim();
          // ignore empty lines
          if (line.equals("")) {
            continue;
          }

          // output previously captured chapter
          if ("------------".equals(line)) {
            try (FileOutputStream fos = new FileOutputStream("output/" + (chapter++) + ".html")) {
              fos.write(content.toString().getBytes("UTF-8"));
            }
            content = new StringBuilder();
            lineNumber = 0;
            continue;
          }

          lineNumber++;
          if (lineNumber == 1) {
            // content.append("<h1>").append(line.replaceFirst("\\s",
            // "&nbps;")).append("</h1>");
            try (FileOutputStream fos = new FileOutputStream("output/" + chapter + ".txt")) {
              fos.write(line.replaceFirst("\\s", ": ").getBytes("UTF-8"));
            }
          } else {
            content.append("<p lang=\"zh-Hans\">").append(line).append("</p>");
          }
        }
      }
    }
  }
}