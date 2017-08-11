import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ReadJson {
	public static void main(String[] args) {
		try {
			//创建json解析器
			JsonParser parser = new JsonParser();
			
			//通过解析器将当前的json文件转为json对象
			JsonObject object = (JsonObject) parser.parse(new FileReader("test.json"));
			
			//直接读取根元素
			System.out.println("cat="+object.get("cat").getAsString());
			System.out.println("pop="+object.get("pop").getAsBoolean());
			
			//获取子节点中的对象数组
			JsonArray array = object.get("languages").getAsJsonArray();
			//循环遍历json数组中的值
			for (int i = 0; i < array.size(); i++) {
				System.out.println("-------------");
				JsonObject subObject = (JsonObject) array.get(i);
				System.out.println("id="+subObject.get("id").getAsInt());
				System.out.println("name="+subObject.get("name").getAsString());
				System.out.println("ide="+subObject.get("ide").getAsString());
			}
			
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
