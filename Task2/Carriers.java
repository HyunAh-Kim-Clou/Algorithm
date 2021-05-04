import java.io.*;
import java.util.Vector;

public class Carriers {
    Vector<String> keys = new Vector<String>();
    Vector<String> values = new Vector<String>();

    void readFile(String filepath) {
        try {
            File file = new File(filepath);
            // 한글로 인코딩된 파일 읽기
            InputStreamReader isReader = new InputStreamReader(new FileInputStream(file), "euc-kr");
            BufferedReader bufReader = new BufferedReader(isReader);

            String line = "";
            while ((line = bufReader.readLine()) != null) {
                String[] linePieces = line.split("\t");

                keys.add(linePieces[0]);
                values.add(linePieces[1]);
            }
            bufReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String[] getKeys() {
        String[] str_keys = new String[keys.size()];
        str_keys = keys.toArray(str_keys);
        return str_keys;
    }
    String[] getValues() {
        String[] str_values = new String[values.size()];
        str_values = values.toArray(str_values);
        return str_values;
    }
}
