package cn.xxx.crawler.sina;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

import net.sf.json.JSONObject;

public class RepeatCheck {

	public static void match() throws IOException{
		FileInputStream fis = new FileInputStream("d:\\sinaret1.txt");
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		BufferedReader reader = new BufferedReader(isr);	
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\sinaret_serail_common.txt"), "utf-8"));
	
		String carString = "", ret = "", outRet = "", lastBrand = "", lastSerail = "";
		boolean equal = true;
		String s = null;
		while ((s = reader.readLine()) != null) {
			String ss[] = s.split("\\|");
			String brand = ss[0];
			String serail = ss[1];
			
			String model = ss[3];
			String currentRet = ss[4].substring(18, ss[4].length()-2);
			JSONObject json = JSONObject.fromObject(currentRet);
			String current = json.optJSONObject("data").values().toString();
			//System.out.println(current);
			
			if (!ss[2].equals(carString)) {
				if (equal) {
					String out = lastBrand + "|" + lastSerail + "|" +  carString +  "|" + outRet;
					System.out.println(out);
					writer.append(out);
					writer.newLine();
				}
				equal = true;
				carString = ss[2];
				ret = current;
				outRet = ss[4];
				lastBrand = brand;
				lastSerail = serail;
				continue;
			}
			
			if (!current.equals(ret)) {
				equal = false;
				//System.out.println("serail result different " + serail);
			}
			//System.out.println(brand + " " + serail + " " + model);
			
		}
		reader.close();
	}
	
	public static void findNoRepeat() throws IOException{
		Integer[] repeatIds = new Integer[]{747, 234, 239, 553, 1341, 948, 620, 534, 236, 1933, 1730, 1654, 1741, 1455, 1574, 1453, 350, 807, 1594, 576, 1628, 731, 1726, 1602, 1727, 734, 735, 736, 737, 738, 847, 1107, 646, 88, 602, 794, 1528, 145, 1329, 395, 1279, 324, 306, 605, 300, 301, 491, 322, 489, 320, 321, 1414, 1270, 828, 809, 1811, 1377, 198, 416, 415, 789, 411, 558, 412, 1652, 1556, 1651, 1269, 621, 622, 1417, 554, 798, 144, 1571, 904, 1180, 530, 154, 952, 26, 1253, 837, 881, 696, 1436, 1586, 546, 373, 833, 917, 921, 1028, 1393, 769, 219, 905, 1606, 1152, 1866, 873, 59, 1503, 1442, 1489, 1680, 1495, 1473, 1890, 43, 419, 2068, 1153, 723, 946, 858, 1532, 1514, 934, 965, 775, 782, 2012, 1744, 1581, 1745, 1585, 1282, 556, 555, 923, 353, 1925, 1281, 612, 936, 422, 13, 567, 638, 1757, 1267, 720, 649, 1668, 465, 72, 894, 1423, 1748, 800, 801, 799, 1562, 718, 1784, 1863, 839, 969, 504, 616, 691, 505, 862, 524, 1753, 1755, 906, 864, 260, 1593, 139, 492, 1821, 100, 60, 354, 334, 61, 887, 1778, 1728, 1733, 1185, 1233, 1280, 54, 56, 466, 1427, 668, 666, 1278, 1849, 506, 1724, 589, 1722, 1256, 1221, 584, 1387, 958, 1665, 1168, 1756, 656, 1147, 92, 1531, 1653, 494, 109, 739, 1560, 959, 849, 960, 746, 1822, 1825, 1826, 868, 124, 1173, 1937, 1920, 1919, 1785, 1441, 1549, 542, 644, 1677, 1660, 730, 835, 116, 1670, 776, 1601, 669, 560, 421, 813, 1552, 701, 661, 869, 1487, 1071, 1070, 1768, 902, 1719, 1720, 667, 1698, 890, 678, 1813, 579, 951, 932, 760, 1655, 987, 1559, 286, 446, 210, 820, 793, 792, 499, 1650, 1895, 812, 1878, 55, 1569, 447, 897, 191, 351, 1258, 420, 1582, 192, 136, 797, 551, 1816, 359, 1591, 552, 1817, 1121, 1855, 933, 1156, 702, 795, 918, 1864, 705, 381, 265, 722, 266, 945, 821, 264, 268, 635, 284, 282, 1425, 379, 1158, 1159, 1359, 891, 42, 153, 40, 514, 1658, 1352, 518, 608, 1383, 610, 1926, 525, 1847, 1725, 885, 660, 768, 550, 1161, 383, 403, 1874, 1160, 1260, 1576, 1882, 1879, 1883, 1880, 1881, 1090, 1088, 1749, 473, 671, 402, 1376, 1595, 695, 755, 766, 340, 482, 643, 1929, 250, 507, 664, 707, 85, 185, 1666, 892, 1820, 1553, 676, 815, 629, 277, 474, 1162, 159, 523, 428, 877, 729, 93, 764, 690, 1491, 988, 1421, 829, 547, 740, 1717, 1751, 443, 418, 585, 1462, 1777, 166, 1850, 884, 601, 1767, 1782, 180, 1023, 417, 450, 297, 336, 304, 1314, 462, 1015, 1851, 1073, 860, 79, 688, 714, 1384, 238, 1843, 841, 698, 58, 832, 1079, 330, 390, 545, 745, 1667, 830, 25, 1923, 651, 590, 1572, 181, 1350, 182, 1119, 1149, 1418, 440, 557, 943, 370, 1217, 1550, 1551, 924, 1835, 495, 1166, 648, 1524, 1788, 1608, 1790, 1791, 1789, 1786, 1530, 1529, 597, 609, 1095, 1170, 1691, 928, 1809, 1100};
		List<Integer> repeatIdList =  Arrays.asList(repeatIds);
		
		FileInputStream fis = new FileInputStream("d:\\sinaret1.txt");
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		BufferedReader reader = new BufferedReader(isr);	
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\sinaret_serail_not_common.txt"), "utf-8"));
				
		String s = null;
		while ((s = reader.readLine()) != null) {
			String ss[] = s.split("\\|");
			String brand = ss[0];
			String serail = ss[1];
			
			String carString = ss[2];
			int carId = Integer.parseInt(carString);
			if (!repeatIdList.contains(carId)) {//已经确认为相同的车系，不输出
				System.out.println(s);
				writer.append(s);
				writer.newLine();
			}else {
				//System.out.println(s);
			}	
			
		}
		reader.close();
		writer.close();
	}
	
	public static void main(String[] args) throws IOException {
		//match();
		findNoRepeat();
	}
}
