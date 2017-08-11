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
			//����json������
			JsonParser parser = new JsonParser();
			
			//ͨ������������ǰ��json�ļ�תΪjson����
			JsonObject object = (JsonObject) parser.parse(new FileReader("test.json"));
			
			//ֱ�Ӷ�ȡ��Ԫ��
			System.out.println("cat="+object.get("cat").getAsString());
			System.out.println("pop="+object.get("pop").getAsBoolean());
			
			//��ȡ�ӽڵ��еĶ�������
			JsonArray array = object.get("languages").getAsJsonArray();
			//ѭ������json�����е�ֵ
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
