package charset_conversion;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;


public class GBKtoUTF8 {
    // 遍历文件
    public static void fileList(File file) {
        File rootFile = file;
        File[] files = rootFile.listFiles();
        if (files != null) {
            for (File f : files) {
                if (!f.isDirectory() && f.getName().endsWith(".java")) {
                    codeConvert(f);
                    System.out.println(f.getPath());
                } else {
                    System.out.println("skip" + f.getPath());
                    fileList(f);// 递归调用子文件夹下的文件
                }
            }
        }
    }

    public static void codeConvert(File file) {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), Charset.forName("GBK")));
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
                sb.append("\n");
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
            (new FileOutputStream(file), Charset.forName("UTF-8")));
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "E:\\6-javase\\java300尚学堂_高淇\\code99-207";
        File file = new File(path);
        GBKtoUTF8.fileList(file);
    }
}
