import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CrawlersTest {
	
	public static void main(String[] args) throws Exception {
         Long StartTime = System.currentTimeMillis();
         System.out.println("--請輸入正確的網址如https://www.itread01.com/p/842719.html--");
         Scanner input = new Scanner(System.in);// 例項化鍵盤輸入類
         String webaddress = input.next();// 建立輸入物件
//         String webaddress = "https://www.itread01.com/p/842719.html";
         File file = new File("D:" + File.separator + "test.txt");// 例項化檔案類物件
        // 並指明輸出地址和輸出檔名
         Writer outWriter = new FileWriter(file);// 例項化outWriter類
         URL url = new URL(webaddress);// 例項化URL類。
         URLConnection conn = url.openConnection();// 取得連結
         
         conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
         
         
         BufferedReader buff = new BufferedReader(new InputStreamReader(
         conn.getInputStream(),"utf-8"));// 取得網頁資料
         String line = null;
         int i=0;
//         String regex = "\\[email protected]\\w+(\\.\\w+)+";// 宣告正則，提取網頁前提
//         Pattern p = Pattern.compile(regex);// 為patttern例項化
         outWriter.write("該網頁中所包含的的郵箱如下所示:\r\n");
         while ((line = buff.readLine()) != null) {
//         Matcher m = p.matcher(line);// 進行匹配 mail
//         while (m.find()) {
//         i++;
//         outWriter.write(m.group() + ";\r\n");// 將匹配的字元輸入到目標檔案
//          }
        	 outWriter.write(line + ";\r\n");// 將匹配的字元輸入到目標檔案
        	 i++;
         }
         Long StopTime = System.currentTimeMillis();
         String UseTime=(StopTime-StartTime)+"";
         outWriter.write("--------------------------------------------------------\r\n");
         outWriter.write("本次爬取頁面地址："+webaddress+"\r\n");
         outWriter.write("爬取用時："+UseTime+"毫秒\r\n");
//         outWriter.write("本次共得到郵箱："+i+"條\r\n");
         outWriter.write("****謝謝您的使用****\r\n");
         outWriter.write("--------------------------------------------------------");
         outWriter.close();// 關閉檔案輸出操作
         System.out.println(" —————————————————————\t");
         System.out.println("|頁面爬取成功，請到D盤根目錄下檢視test文件|\t");
         System.out.println("|                                         |");
         System.out.println("|如需重新爬取，請再次執行程式,謝謝您的使用|\t");
         System.out.println(" —————————————————————\t");
         } 

}
