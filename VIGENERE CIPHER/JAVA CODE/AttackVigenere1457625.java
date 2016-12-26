
import java.util.ArrayList;




public class AttackVigenere1457625 {
	
	public static void main(String[]args) {
		String ciphertext = "gigbjiwmelqjgshlgwopngqrolraqpzeeidmvrgzgicieinhneqiphovhuriofrbqacsfmusprqkjenxrekrbwbjgcwygbjspwuzkifmaojemfvviimjbcntmipctvzvbnvlzjvmphvytctsaxumhiqieagryxbbjmnxewqtxszmvljyawvrzeentshxuquwzwfqqrdrgmthdggmximcswypjjggteixjqpkneimvlzinoniainbjimhxqpkfirxvlzsoagupcfwuxmmpbnioxumrvdifbkrnyexnmxijpkxzxuivhzjhvexdzruwwdgpipfzxumfivxulkzdrvviwreatgwoxumtilyvmopvgxpkwmmtpveihgpqyovrjniyegmfgmsjbjeoxuguewprogryieuconxjqvlolrjtivxubjspkvduxvrqbconxzwpknxbctqjyevgvnwuinxolbcisciemvlzeabjihhbbjgjqzmpgzpbdgeihpwpwoeakamnhriftcsrvkbvrqbjioyebniaprlkrvqhbwegjyioiavbujiigraqxciltqzyeftqzzmabyedruifxcirauiigrjwxdrbvgxrsqquxdrpbuhdzvaksirbvgrpqomtxciemkrgsimyenwyikrcinzvwmizwvitigvqxvwhvfimhvaveigriphisfxcgzanauizrgekboxuquxpvgtgeihuquupirvdyomabjihmgegvzejwphzvfwdioarmpxciztqzzhvluldrrbjeoxumvymxymuerlvatmblgnnehmaokrolrxjszrvfumblgmkxcieecwolrwvlzvfukrztewrimxlecwolhactkeytgholnbvlzwrthavwawvxcifioinmaoniiegctinhbcdpzrnugrzmgpgvoabvqvjrrecwxeytghminaqrdrvbuigjpwpjjyalghnejlkzdwvwpkmsjbqkzxumtxjxumowzpimuczxrqvlzvamkxcieakqkpregvzwbegpggbursprqmfxcegqvgmmrljsrxecgeoanqpwzizmvlolvaesigbzfeixbvgpjzrpcwminaqrminaqrisamkjrlnbremxfkcrnsemoedrjpgvzycwpmoqnlgxcmfbjvzrrbqxcicpqiimkipholrlqzzgbawtmizmueihfbcvnsstqzzefkjsmyfbqxcivzvvvkvkugzrrbjvzrbadivyggvvpxuiphmeeqvcbvnkgmieytumhtyqemocumtizrptqwymakkryieanmzhrivldwawyxcicpqiimkvgwoealvlzxhzvpzwywaegfemcwoxbmvimrvbahjxuzgwoprixmikawrsnxrzkxtxjiurjxgpgmmmankvhmggkxrefucvmmrlelvwgqvcovhbjqvcfmgqwygkcrisgjgfzehbafmetjwxomfvqxnlrbtyolnvffzehbafpvvmffzxbbjmnyevnioxuwuimicikvolnbcvzivbjimxecgsmjnqtjjvgpgwzhriffdvqaumblnxtetie";
		ciphertext.toLowerCase();
		int length = Vigenere1457625.kasiski(ciphertext, 4, 9);
		System.out.println("LUNGHEZZA KEYWORD:" + length);
		ArrayList<ArrayList<Character>> list1 = columns(length,ciphertext);
		ArrayList<double[]> percentuali = createPerc(list1);
		for(int i=0;i<percentuali.size();i++) {
			double[] rif = percentuali.get(i);
			System.out.println("Percentuali array: "+i);
			for(int j=0; j<rif.length;j++) {
				System.out.println("Percentuale " + (char)(97+j) + " " + rif[j]);
			}
		}
		
	}
	
	public static ArrayList<ArrayList<Character>> columns(int length, String ciphertext) {
		
		ArrayList<ArrayList<Character>> nodes = new ArrayList<ArrayList<Character>>();
		for(int i=0; i<length;i++) {
			nodes.add(i,new ArrayList<Character>());
		}

		for(int i=0; i<ciphertext.length();i++) {
			nodes.get(i%length).add(ciphertext.charAt(i));
		}
		return nodes;
	}
	
	
	public static double[] perc(ArrayList<ArrayList<Character>> list, int index) {
		double[] percent = new double[26];
		int[] count = new int[26];
		ArrayList<Character> list2 = list.get(index);
		int total = list2.size();
		for (int j = 0; j < list2.size(); j++) {
			int ref = (list2.get(j)) - 97;
			count[ref]++;
		}

		for(int i=0; i<count.length;i++) {
			percent[i] = (count[i]*100)/total;
			//System.out.println("CONTA: "+ (char)(97+i) + " " +count[i]);
		}
		return percent;
	}
	
	public static ArrayList<double[]> createPerc(ArrayList<ArrayList<Character>> list) {
		ArrayList<double[]> res = new ArrayList<double[]>();
		for(int i=0; i<list.size();i++) {
			res.add(perc(list,i));
		}
		return res;
	}
}
