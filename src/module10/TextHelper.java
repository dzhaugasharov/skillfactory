package module10;

import java.io.*;
import java.nio.charset.Charset;

public class TextHelper {

    public static void main(String[] args) throws IOException {
        String fp = "./src/tempFile.txt";
        System.out.println(readFile(fp, "utf-8"));
        writeFile("./src/nelly.txt", "COmss f lskdf ывалваг 3гва ");

        replaceWordsInFile(fp, "asd", "ASD");
    }

    public static String readFile(String filePath, String charsetName) throws IOException {
        File file = new File(filePath);
        Charset charset = Charset.forName(charsetName);
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
        char[] ch = new char[1024];
        StringBuffer sb = new StringBuffer();
        int len;
        while((len = r.read(ch)) > 0) {
            sb.append(ch, 0, len);
        }
        r.close();
        return sb.toString();
    }

    public static void writeFile(String filePath, String text) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(text);
        fw.close();
    }

    public static void replaceWordsInFile(String filePath, String targetWord, String newWord) throws IOException {
        String s = readFile(filePath, "utf-8");
        writeFile(filePath, s.replaceAll(targetWord, newWord));
    }
}
