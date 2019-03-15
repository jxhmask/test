package testapp;



import java.net.URL;
import java.util.List;

import org.codehaus.xfire.client.Client;
import org.dom4j.Element;

public class Checknamemobile {

	static final String WEB_SERVICE_URL = "http://220.191.242.43:8082/outService_Sql/services/CdtOutNewAccess?wsdl";
	//static final String WEB_SERVICE_URL = "http://220.191.244.132:8081/outService_Sql/services/CdtOutNewAccess?wsdl";
	//static final String WEB_SERVICE_URL = "http://192.168.1.25:8080/outService_wy/services/CdtOutNewAccess?wsdl";
	//static final String WEB_SERVICE_URL = "http://220.191.242.43:8082/outService_wy/services/CdtOutNewAccess?wsdl";
	//static final String WEB_SERVICE_URL = "http://220.191.238.91/outService/services/CdtOutNewAccess?wsdl";//衢州履职
	//static final String WEB_SERVICE_URL = "http://220.191.244.132:8081/outService_wy/services/CdtOutNewAccess?wsdl";
	//static final String WEB_SERVICE_XLH = "E61BBAF1-3535-4A26-837D-C61D8754D0D3";//提案
	static final String WEB_SERVICE_XLH = "45732AED69DDC2AB3D486597E5705288";//履职
	//static final String WEB_SERVICE_XLH = "E043F98D-63F2-494A-8B34-0331E661ECEA";
	/**
	 * @param jkid
	 * @param xlh
	 * @param xmlDoc
	 * @return
	 */
	public static String outService(String jkid,String xlh,String xmlDoc) {
		try {
			Client client = new Client(new URL(WEB_SERVICE_URL));
			Object[] result = client.invoke("outService",new Object[]{jkid,xlh,"test","","","","192.168.0.1",xmlDoc});

			return (String)result[0];
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
	}
	
	
	public static void main(String[] args) throws Exception {

		/* String xmlDoc = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><WriteCondition>"
				 +"<summary>测试</summary>"
				 +"<remark>测试</remark>"
				 +"<text>测试%</text>"
				 +"<periodSession>114</periodSession>"
				 +"<zhuban>11</zhuban>"
				 +"<basis></basis>"
				 +"<lingxianId>0332D0B6-FB9C-4687-970F-895AB257B87B</lingxianId>"
				 +"<fuyiId></fuyiId>"
				 +"<userId>2013198201EA491B</userId>"
				 +"</WriteCondition></root>" */
				 ;
		
		
		 
		/*String xmlDoc =  "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><WriteCondition>"
			 +"<userId>2016120514104260167260262</userId>"
			 +"<personIds>20131962012DFB9F</personIds>"
			 +"<meetId>2017041419552443504677589</meetId>"
			 +"<content>测试催促2017年4月17日15:41:50</content>"		
			 +"</WriteCondition></root>"
			 ;*/
			
		String xmlDoc =  "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><QueryCondition>"
					 +"<name></name>"
				+"<type></type>"
				+"<conferenceGroupInfoId></conferenceGroupInfoId>"
				+"<meetId>2016122616454063982232464</meetId>"
				+"<attendance>00</attendance>"
				+"</QueryCondition></root>";
				
		 
	    String xlh=WEB_SERVICE_XLH;
		String jkid = "A003000";
		
		String result = outService(jkid,xlh,xmlDoc); 

		System.out.println(result);
	
	}
	
	
    public static void print(List<Element> els){
        for(Element el:els){
            System.out.println("##"+el.getName()+"--value=="+el.getTextTrim());
            if(el.hasContent()){
                print(el.elements());
            }
        }
    }

}
