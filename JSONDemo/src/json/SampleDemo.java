package json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javabean.Address;
import javabean.Student;

public class SampleDemo {
	
	public static void demoO() {
		Map<String,String> map=new HashMap<String, String>();
		map.put("s01", "zs");
		map.put("s02", "ls");
		map.put("s03", "ww");
		JSONObject json=new JSONObject(map);
		System.out.println(json);
		
	}
	public static void demoT() {
		Address address=new Address("xa","bj");
		Student student=new Student("zs",1,address);
		JSONObject json=new JSONObject(student);
		System.out.println(json);
		
	}
	public static void demoTR() {
		String JSONstr="{\"s04\":\"yy\",\"s05\":\"uu\",\"s06\":\"zz\"}";
		JSONObject json=new JSONObject(JSONstr);
		System.out.println(json);
	}
//	�ļ�תΪjson
	public void fileJson() throws IOException {
//		InputStream in = super.getClass().getClassLoader().getResourceAsStream("per.json");
//		byte[] bs=new byte[10];
//		int length=-1;
//		StringBuffer stringBuffer = new StringBuffer();
//		while((length=in.read(bs)) !=-1) {
////		�ֽ�������ַ���
//			String str=new String(bs,0,length);
//			stringBuffer.append(str);
//		}
//		String s=stringBuffer.toString();
//		JSONObject json=new JSONObject(s);
//		System.out.println(json);
		
		File file=new File("D:\\Workspace-sts-3.9.7.RELEASE\\JSONDemo\\src\\per.json");
		String str=FileUtils.readFileToString(file);
		JSONObject json=new JSONObject(str);
		System.out.println(json);
	}
//	json�����ļ�
	public static void demoF() throws IOException {
		Map<String,Student> map=new HashMap<String, Student>();
		Student student1=new Student("zs",23,new Address("xa","bj"));
		Student student2=new Student("ls",44,new Address("ca","lq"));
		Student student3=new Student("ww",43,new Address("wn","hc"));
		map.put("zs",student1);
		map.put("ls", student2);
		map.put("ww", student3);
		JSONObject json=new JSONObject(map);
		FileWriter fileWriter = new FileWriter("D:\\json.obj");
		json.write(fileWriter);
		fileWriter.close();
	}
//	string->json����
	public static void DemoFi() {
		String JsonArryStr="[\r\n" + 
				"	{\"name\":\"zs\",\"age\":23},\r\n" + 
				"	{\"classname\":\"lq\",\"classno\":1},\r\n" + 
				"	{\"schoolname\":\"nudt\",\"zone\":\"cs\"}\r\n" + 
				"	]";
		JSONArray jArry=new JSONArray(JsonArryStr);
		System.out.println(jArry);
	}
//	map->json����
	public static void demoS() {
		Map<String,String> map=new HashMap<String, String>();
		map.put("s01", "zs");
		map.put("s02", "ls");
		map.put("s03", "ww");
//		�������������ض�һ��
		
		net.sf.json.JSONArray jArray=new net.sf.json.JSONArray();
		jArray = jArray.fromObject(map);
		System.out.println(jArray);
		
	}
//	JSONArrayתmap����
	public static void demoSE() {
//	׼��JSONArray����
		String JsonArryStr="[\r\n" + 
				"	{\"name\":\"zs\",\"age\":23},\r\n" + 
				"	{\"classname\":\"lq\",\"classno\":1},\r\n" + 
				"	{\"schoolname\":\"nudt\",\"zone\":\"cs\"}\r\n" + 
				"	]";
		net.sf.json.JSONArray jArray=new net.sf.json.JSONArray();
		jArray = jArray.fromObject(JsonArryStr);
		Map<String,Object> map=new HashMap<String, Object>();
//		��ȡÿһ��json
		for (int i = 0; i < jArray.size(); i++) {
			net.sf.json.JSONObject Json =(net.sf.json.JSONObject) jArray.get(i);
//			��ȡÿһ��json��k��v
			Set<String> keys = Json.keySet();//ÿ��json������key
			for(String key:keys) {
				Object value=Json.get(key);
				map.put(key, value);
			}
		}
		System.out.println(map);
		
	}
	public static void main(String[] args) throws IOException{
		demoO();demoT();demoTR();
		SampleDemo json=new SampleDemo();
			json.fileJson();
			demoF();
			DemoFi();
			demoS();
			demoSE();
	}
	
}
