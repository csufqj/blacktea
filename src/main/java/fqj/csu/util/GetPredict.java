package fqj.csu.util;
import java.io.*;

//通过调用python本地程序得到预测值，python本地程序读取的图片就是用户上传图片之后保存的位置
public class GetPredict {

    private static final String PY_URL = "C:\\Users\\Administrator\\Desktop\\blacktea\\predict.py";

    public static String getPredict() {
        Process proc = null;
        String predict = "";
        try {
            proc = Runtime.getRuntime().exec("python " + PY_URL);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
           while((line = in.readLine())!=null) {
               predict += line;
           }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return predict;
    }


//    public static void main(String[] args) throws IOException {
//        System.out.println(getPredict());
//    }

}

