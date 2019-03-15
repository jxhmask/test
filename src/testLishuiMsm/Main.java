package testLishuiMsm;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.w3c.dom.Node;



public class Main {
	private static final String SOAP_ACTION = "http://openmas.chinamobile.com/sms/ISms/SendListMessage";
	private static final String NAMESPACE_URI = "http://openmas.chinamobile.com/sms";
	private static String smsUrl = "http://112.13.167.64:9080/OpenMasService";

	public static void main(String[] args) {
		if(sendsms("7806114510", "DT2T0D6H", "15867103843", "haha, success!", null, "0")){
			System.out.print("success");
		}
	}

	/**
	 * 
	 * 
	 * @param appid
	 * @param pwd
	 * @param mobile
	 * @param smsContent
	 * @param extendCode
	 * @param mobileType
	 * @return
	 */
	public static boolean sendsms(final String appid, final String pwd,
			final String mobile, final String smsContent,
			final String extendCode, final String mobileType) {
		StringBuilder sb = new StringBuilder();
		sb.append("<SmsSend><Account>");
		sb.append(appid);
		sb.append("</Account><PassWord>");
		sb.append(pwd);
		sb.append("</PassWord><ListMessage>");
		sb.append("<SendMessage><ID>");
		sb.append(1);
		sb.append("</ID><MobileNumber>");
		sb.append(mobile);
		sb.append("</MobileNumber><Content>");
		sb.append(smsContent);
		sb.append("</Content><ExtendCode>");
		sb.append(extendCode);
		sb.append("</ExtendCode><MobileType>");
		sb.append(mobileType);
		sb.append("</MobileType></SendMessage></ListMessage></SmsSend>");

		String xml = sb.toString();
				
		try {
			SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory
					.newInstance();
			SOAPConnection connection = soapConnFactory.createConnection();

			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage message = messageFactory.createMessage();

			MimeHeaders mHers = message.getMimeHeaders();
			mHers.setHeader("SOAPAction", SOAP_ACTION);

			SOAPPart soapPart = message.getSOAPPart();

			QName ename = new QName(NAMESPACE_URI, "SendListMessage");

			SOAPEnvelope envelope = soapPart.getEnvelope();
			SOAPBody body = envelope.getBody();
			SOAPElement bodyElement = body.addBodyElement(ename);
			bodyElement.addChildElement("xml").addTextNode(xml);

			message.saveChanges();
			URL url = new URL(smsUrl);

			SOAPMessage reply = connection.call(message, url);
			connection.close();
			SOAPBody ycBody = reply.getSOAPBody();
			Node ycResp = ycBody.getFirstChild();
			if (ycResp.getFirstChild() != null
					&& "SendListMessageResult".equals(ycResp.getFirstChild()
							.getNodeName())) {
				String result = ycResp.getFirstChild().getTextContent()
						.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
				String msgId = result.substring(
						result.indexOf("<MessageId>") + 11,
						result.indexOf("</MessageId>"));
				if (msgId == null
						|| msgId.trim().length() == 0) {
					return false;
				}
				
				return true;
			} else {
				System.out.println("Sms Interface Response: "
						+ ycResp.getTextContent());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
