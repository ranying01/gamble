import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Arithmetic {

    private static final String filePath = "D:\\1.txt";


    public static void main(String[] args) {

        Map<String, Integer> historicalMap = readFileByLines(filePath);

        System.out.println("一共有：" + historicalMap.size() + "个数");

        Map<String, Integer> allNumbers = new HashMap<String, Integer>();

        for (int i = 0; i < 100; i++) {

        }

    }


    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static Map<String, Integer> readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        Map<String, Integer> map = new HashMap<String, Integer>();
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);

                String[] numbers = tempString.split("\\s+");
                if (numbers.length > 0) {
                    for (int i = 0; i < numbers.length; i++) {
                        if (map.containsKey(numbers[i])) {
                            map.put(numbers[i], map.get(numbers[i]) + 1);
                        } else {
                            map.put(numbers[i], 1);
                        }
                    }
                }
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return map;
    }

}
