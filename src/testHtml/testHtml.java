package testHtml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class testHtml {
	@Test
	public void testhtml() {
/*		String str ="<p style='text-align:center;line-height:40px'><span style='font-size:21px;font-family:����'>���ڷ�����ɽ���Ͻɵ����������õ�</span></p><p style='text-align:center;line-height:40px'><span style='font-size:21px;font-family:����'>�����г�ʹ�÷�ʡ�ֳɲ��ֵĽ���</span></p><p>&nbsp;</p><p style='text-indent: 43px;line-height: 37px'><span style='font-size:21px;font-family:����_GB2312'>�����ϸ�ʵ�н�����Ŀռ�ø���ռ��ƽ���ƶȣ��ر���2015�������ϼ���������Ҫ���ϸ�ִ�С�ռ�Ų��ţ�ռˮ��ˮ���ƶȣ���Щ���ߵ�ʵʩ��Ч�ı����˸�����Դ����ַ��Ӹ���ռ��ƽ��Թ�ҵ�������򻯽���ռ�ø��صĲ������ã�Ϊ���ظ��غ��߷����˻�����Ϊ�����Եش�������������ɽȺ��������������Դ�Ĳ�����Ӱ��������չ���ر��ǽ�����������ɽȺ�������������Ȳ��ϼӴ���ɫʯ�������ղ�ҵ԰��Զ����ҵ���ص��ش���Ŀ�׷���أ���Ŀ��������Ҫռ�ø��������������ӡ�Ϊ��ʵ����ռ��ƽ�⣬��ɽ�в�ȡ���⹺�������ָ�ꡢ������صȶ��ַ�ʽ������ء���Ŀǰ�⹺�������ָ��۸��������ǣ��Ѵﵽʡ����߱�׼��ˮ��35��Ԫ/Ķ������20��Ԫ/Ķ�ͱ�׼ũ��7��Ԫ/Ķ��ˮ��ָ�껹�м����У���2016����о�֧��3.7��Ԫ�������⹺�������ָ�ꣻ��������������ں�����������������٣����и��غ���Դ�ر������ʵĺ���Դ���ز��㣬��������ѶȲ��ϼӴ���ɽ�����������޿ɿ���ˮ����������ʿɿ��ѵĺ󱸸���Ҳ����ϡȱ��ֻ��ͨ��Χ����ػ�����︴�ѵ��ֶΣ���Χ����سɱ��Ѿ�����60��Ԫ/Ķ�����︴�ѳɱ�Ҳ������20��Ԫ/Ķ������ڸ��мƻ�ʵʩ���ɽ����γ�������أ���Ŀ��Ͷ��11��Ԫ��Ķ���ɱ���22��Ԫ/Ķ���⹺�������ָ��Ϳ�����سɱ��������ǣ������в��������˾޴��ѹ�������������г�ʹ�÷���Ϊ��ȷ�涨���ڻ���ũ�ｨ�衢���ؿ�����֧�����շѣ�2014-2015��������м��������������Ͻ�22135��Ԫ������ʡ�ֳɲ���Ϊ15494.5��Ԫ��ʡ����ز��Ű����ط��ۺϿ��Ǹ���<a name='OLE_LINK1'></a>�߱�׼����ũ����Ƚ������񡢻���ũ�ﱣ����������ˮ������Լ�����ʡ������������ѵ����أ����ת��֧�������ϵ����ȷ�������ʽ��ȣ���Ȼ���ط����ѽ���ɽ����Ϊһ��ת��֧�����أ�����Ϊ���и߱�׼����ũ����Ƚ������񡢻���ũ�ﱣ����������ˮ�������������������Ȼ�������������ط�ʡ��������3384��Ԫ����ˣ�Ϊ������в�������ռ��ƽ���ʽ�ѹ����ͬʱ��Ҳ��Ϊ��һ��֧����ɽȺ�����������һ����Ч��ʩ���������ɽʵ�и��Żݵķ������ߣ�����2017�꿪ʼ������ȫ��ظ����Ͻɵ����������õ������г�ʹ�÷�ʡ���ֳɲ��֡�</span></p><p style='text-indent: 43px;line-height: 37px'><span style='font-size:21px;font-family:����_GB2312'>&nbsp;</span></p><p style='text-indent: 43px;line-height: 37px'><span style='font-size:21px;font-family:����_GB2312'>&nbsp;</span></p><p style='text-indent: 43px;line-height: 37px'><span style='font-size:21px;font-family:����_GB2312'>&nbsp;</span></p><p>&nbsp;</p><p><br/></p>";
		
		str = str.replace("&nbsp;", "");
		
		int i = str.indexOf("<", 0);
		int j = str.indexOf(">", 1);
		
		while(i < j){
			str = str.replace(str.substring(i, j + 1), "");
			i = str.indexOf("<", 0);
			j = str.indexOf(">", 1);
		}
	
		System.out.println(str);*/
		
		List<String> l = Collections.synchronizedList(new ArrayList());

		
		l.add("1");
		l.add("2");
		l.add("3");
		l.add("4");
		l.add("5");
		l.add("6");
		
		synchronized(l) {

		for(String str : l){
			if("3".equals(str)){
				l.remove("3");
			}
			
		}
		}
		Iterator<String> it = l.iterator();
		 while(it.hasNext()){
			String str = it.next();
			if("3".equals(str)){
				it.remove();
			}
			
		}
		
		
		System.out.println(l);
	}
}
