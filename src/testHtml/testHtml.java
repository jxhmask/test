package testHtml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class testHtml {
	@Test
	public void testhtml() {
/*		String str ="<p style='text-align:center;line-height:40px'><span style='font-size:21px;font-family:宋体'>关于返回舟山市上缴的新增建设用地</span></p><p style='text-align:center;line-height:40px'><span style='font-size:21px;font-family:宋体'>土地有偿使用费省分成部分的建议</span></p><p>&nbsp;</p><p style='text-indent: 43px;line-height: 37px'><span style='font-size:21px;font-family:仿宋_GB2312'>国家严格实行建设项目占用耕地占补平衡制度，特别是2015年以来上级国土部门要求严格执行“占优补优，占水补水”制度，这些政策的实施有效的保护了耕地资源，充分发挥耕地占补平衡对工业化、城镇化建设占用耕地的补救作用，为坚守耕地红线发挥了积极作为。但对地处海岛地区的舟山群岛新区，耕地资源的不足已影响新区发展，特别是近年来随着舟山群岛新区开发力度不断加大，绿色石化、航空产业园、远洋渔业基地等重大项目纷纷落地，项目建设中需要占用耕地数量不断增加。为落实耕地占补平衡，舟山市采取了外购补充耕地指标、垦造耕地等多种方式补充耕地。但目前外购补充耕地指标价格逐年上涨，已达到省定最高标准，水田35万元/亩、旱田20万元/亩和标准农田7万元/亩，水田指标还有价无市，仅2016年该市就支出3.7亿元，用于外购补充耕地指标；而垦造耕地受限于海岛地区缓坡丘陵较少，该市耕地后备资源特别是优质的后备资源严重不足，补充耕地难度不断加大，舟山本岛基本已无可开垦水田地区，优质可开垦的后备耕地也严重稀缺，只能通过围海造地或对盐田复垦等手段，而围海造地成本已经超过60万元/亩，盐田复垦成本也超过了20万元/亩，如近期该市计划实施的岱山火箭盐场垦造耕地，项目总投资11亿元，亩均成本近22万元/亩。外购补充耕地指标和垦造耕地成本不断上涨，给该市财政带来了巨大的压力，新增建设有偿使用费作为明确规定用于基本农田建设、耕地开发等支出的收费，2014-2015两年该市市级（含两区）共上缴22135万元，其中省分成部分为15494.5万元，省级相关部门按因素法综合考虑各地<a name='OLE_LINK1'></a>高标准基本农田年度建设任务、基本农田保护面积、灌溉水田面积以及缴入省级国库的新增费等因素，结合转移支付等相关系数，确定返回资金额度，虽然因素法中已将舟山市列为一类转移支付市县，但因为该市高标准基本农田年度建设任务、基本农田保护面积、灌溉水田面积等因素受限于自然条件，根据因素法省级仅返回3384万元。因此，为缓解该市财政耕地占补平衡资金压力，同时，也作为进一步支持舟山群岛新区建设的一项有效措施，建议对舟山实行更优惠的返回政策，即从2017年开始，逐年全额返回该市上缴的新增建设用地土地有偿使用费省级分成部分。</span></p><p style='text-indent: 43px;line-height: 37px'><span style='font-size:21px;font-family:仿宋_GB2312'>&nbsp;</span></p><p style='text-indent: 43px;line-height: 37px'><span style='font-size:21px;font-family:仿宋_GB2312'>&nbsp;</span></p><p style='text-indent: 43px;line-height: 37px'><span style='font-size:21px;font-family:仿宋_GB2312'>&nbsp;</span></p><p>&nbsp;</p><p><br/></p>";
		
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
