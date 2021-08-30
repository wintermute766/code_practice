package test.my;

import java.util.*;
import java.util.stream.Collectors;

class temp {
    static int[] findUnsortedSubarray(int[] array) {
        if (array.length < 2) {
            return (new int[]{-1, -1});
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1])
                min = Math.min(min, array[i]);
        }
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1])
                max = Math.max(max, array[i]);
        }
        if (min == Integer.MAX_VALUE) {
            return (new int[]{-1, -1});
        }

        int left, right;
        for (left = 0; left < array.length; left++) {
            if (min < array[left])
                break;
        }
        for (right = array.length - 1; right >= 0; right--) {
            if (max > array[right])
                break;
        }
        return (new int[]{left, right});
    }

    static String findNumberOfReplacements(String input) {
        String[] arr = input.split("\n");
        int birthdays = Integer.parseInt(arr[0]);

        String[] result = new String[birthdays];

        for (int i = 1; i < birthdays + 1; i++) {
            int num = numberOfReplacements(arr[i].toCharArray());
            result[i - 1] = String.format("Case #%d: %s", i, num);
        }
        return String.join("\n", result);
    }

    static int mostFrequent(char[] arr) {

        Map<Character, Integer> hm = new HashMap<>();

        for (char key : arr) {
            if (hm.containsKey(key)) {
                int freq = hm.get(key);
                freq++;
                hm.put(key, freq);
            } else {
                hm.put(key, 1);
            }
        }

        int max_count = 0, res = -1;

        for (Map.Entry<Character, Integer> val : hm.entrySet()) {
            if (max_count < val.getValue()) {
                res = val.getKey();
                max_count = val.getValue();
            }
        }

        return max_count;
    }

    static int numberOfReplacements(char[] arr) {

        Set<Character> vowels = "AEIOU".chars()
                .mapToObj(chr -> (char) chr)
                .collect(Collectors.toSet());
        Set<Character> consonants = "BCDFGHJKLMNPQRSTVWXZ".chars()
                .mapToObj(chr -> (char) chr)
                .collect(Collectors.toSet());

        Map<Character, Integer> cmap = new HashMap<>();
        Map<Character, Integer> vmap = new HashMap<>();

        int cnumber = 0;
        int vnumber = 0;

        for (char key : arr) {
            if (vowels.contains(key) && vmap.containsKey(key)) {
                int freq = vmap.get(key);
                freq++;
                vmap.put(key, freq);
                vnumber++;
            } else if (vowels.contains(key)) {
                vmap.put(key, 1);
                vnumber++;
            } else if (consonants.contains(key) && cmap.containsKey(key)) {
                int freq = cmap.get(key);
                freq++;
                cmap.put(key, freq);
                cnumber++;
            } else {
                cmap.put(key, 1);
                cnumber++;
            }
        }

        int max_count_v = 0;

        for (Map.Entry<Character, Integer> val : vmap.entrySet()) {
            if (max_count_v < val.getValue()) {
                max_count_v = val.getValue();
            }
        }

        int max_count_c = 0;

        for (Map.Entry<Character, Integer> val : cmap.entrySet()) {
            if (max_count_c < val.getValue()) {
                max_count_c = val.getValue();
            }
        }

        int i1 = vnumber + 2 * (cnumber - max_count_c);
        int i2 = cnumber + 2 * (vnumber - max_count_v);

        if (i1 < 0) {
            return i2;
        }

        if (i2 < 0) {
            return i1;
        }

        return Math.min(i1, i2);
    }

    public static void main(String[] args) {

        String s = "45\n" +
                "EJZITADGAAAKTEIQVEWLLIIZXWLKSEAIUUUIERFKEUOXONORJRXGKGLIUIUBNXINNJHHAEAACBEQWXZ\n" +
                "FBBNOBTGQYATFOVKWIHAHOXQRNOAAIEUUUIKGFQMGEWYYINOIIEQNQHOQKOOLIXIAKOFEURNOZUKAGAVQAYNQ\n" +
                "KDIYULAIEGHARWVOIKBAUTEINPMEBAPRETFOUL\n" +
                "UUKWEQAESOAANZPGYMYEDHQEQZWUPZRZIHIIYEUEICKALGANOHKMIEXMXCUAXXYLODOZKEOUGDFKCNI\n" +
                "AAAAAAAAAAEEEEEEEEEEIIIIIIIIIIOOOOOOOOOOUUUUUUUUUUBBBBBBBBBBBCCCCDDDDFFFFGGGGHHHHJJJJKKKKLLLLMMMMNNN\n" +
                "ABC\n" +
                "OBHMEAIJAJEROOFEHOHEYEVGHHOOUTIPAETOEAQOJVICAUNLWNUL\n" +
                "GLZIAUAIULAYREOPAALTETAGFHAAURKILIEAAZAOOLJNBZKKICUIZOQUOEUKKIDUBUTQOUVRAUWNYIQAPASQA\n" +
                "GJNZWNDWKKNPLRRBSSDNHXFZ\n" +
                "OEOQUIAFDWEXDKOSAFVUMBBYVEUUWDETZUGNHWJEIWAIHITNAMFLYPIGJOLAOCPFOTOEHVEARVPXCSTITMHA\n" +
                "UFOVKZEOUTPUJSWEITEUAIYDRIBGUIUIOEII\n" +
                "OOKMHREFNKYAYIIGKZTIQBUUAEOIOUAKXFIYTGLBZAEEGIEBZEUVUW\n" +
                "BANANA\n" +
                "IPQALOOEQAWOTODUOFNIAZGQPUTHFFSAEZWOOGYEVQSHRIKCALEUSDAVBUFKIACUSIAKSBLU\n" +
                "KTNIUDNSSOOFAMLGAXJGKXOEBHGEOGQQELSAAEZAGKEFEYYRLETFAEBOAHASLIZUUEAGCP\n" +
                "FBHC\n" +
                "MYNTULUYAUBJWTUHTUUOWEOUUIQPGPKFPEAUUAOOARIVSDIQEIMCUIQUQDAUAIIENPILCBGIOCVNUR\n" +
                "IOAOIAAOAEOIEIEAIIEAOUEIEIOOIEIEOIEIOEOUUOEUEOAOEIOOUUUIIOAEIAIEIOIEUOIUUEIEAEIAAIEOE\n" +
                "F\n" +
                "UVZVEOMIJOOAWGLCIEIAUBSQPRM\n" +
                "SYMPHXFDDRQRPMZTJBVFYWMPLGBRBPRYMTTBDBNTMTJFYJ\n" +
                "EDHHDGFGCFHBHCAFGHHCBDHHECAEGGAGAGDGEGGFDGBCDFDCBHFGBDBCGHEACCGFAGEFBFGECFGFCGGBEDGDBFCEHEDHEHHFGCEB\n" +
                "AIIOEAAAUEUUOEOOUAIIIIOEEIEAAAAUAIAEUUOUEUOAUAOIUAOUAAIUIIIE\n" +
                "EASAYUEOXQXEAKAFIUOEAALAUIIUUGPA\n" +
                "AAAAAEEEEEIIIIIOOOOOOUUUUUXYZ\n" +
                "IOIWOWIOIWOWIOIWOWIOIWOWIOIWOWIOIWOWIOIWOWIOIWOWIOIWOWIOIWOWIOIWOWIOIWOWIOIWOWIOIWOWIOIWOWIOIWOWIOI\n" +
                "GMJAIDRIBTPAOJATREMCOOVXODUIHEUBSAGF\n" +
                "OAAOOEUIEOIEAOIOEOAOEIUAEOAAAEAUEOUIAEEOAUOEIEOAOOAAUAUAOAIUAIIAOAAOAOUOEAEAIUUUUIOAOO\n" +
                "OIOUAUOAIEUOEUIUIIUAAAAUOEIEUAIEEOIAOEUEAOOEAIIEEAEIUIOAUIIOEEUEAOEOOAAIAUAO\n" +
                "HLVTMEAUMYEDMFIMUMEEBEUKEAITNWOIIOSGTIAUPBUINUQGYOAAAETCJGOEMWQEAOPUTTDAAQEESKISO\n" +
                "AYOOZMUIADIDNXXHTMDEFFDDJIMPJANSTOAUHSAIGAFXJHTAABWUZBURBOVJEDZICDOBEAXIJADNLMSKHAOAFEJPHWIAHC\n" +
                "RGQQRTUSHOIUEJBEYZSHIIRDASATUUPUBKTHHUZNTPNLOILOOQYU\n" +
                "EMLEKLIXUPNUEAUEAXUCKHPUEJBUIAKJTKCYIGITCIAUPIQAZUO\n" +
                "IEOFAAANDPZTKXEOBULZIEL\n" +
                "ZVOIAGIMOLAHOAIAJEIUBHLNDDFIHGZHCIUWRMGIHIUOPICDOURTUVAOO\n" +
                "CONSISTENCY\n" +
                "FOXEN\n" +
                "OWAMBXIRMUNOIXEUJILQLAPGLHQSFXUNAJLIERKUQEGCIYNHHEEYFHOFIAMH\n" +
                "OEOUAEOUAUAEIEIIIAIOOUAUIAEEUUIAIAIOUIIAUUIIUAUUEAOAOAEEUEUOUAOAIOUUEEIEAUOAIOEEOUIOAUOEOIAEO\n" +
                "OOEUEUIUUOOAUEIOIEEUIAIUAUOOAUUIIEUUOAAIOAEAUEIAOAOOAOOAAIEOAEOEIOIAAEAAIOEEOIIIEEIOIUEIEEEAAEEEEOAA\n" +
                "AHKELEGPWUNIMUEIUAFOEMAJVFNAEGDOIPASOCLZGPBEAZECGJUUOKHFZSIICWUGRGEAAIZANQIEFVNANAITXIOVDVAEOE\n" +
                "HAAACKEEERCUUUP\n" +
                "AOEEUOAOOUEUUUUEEOAOIOOAAEIEAIEUOIAOOAIOUAAUIUEUIOIUUEEOOAEOIEUIUOOOIEIUEIAEEIIEIEEEEAUIOEIIUE\n" +
                "PTCJRYMLRWZVMZZPBKPNSDMFTCFKLCZXLPQLNQCLDXQVQZMYHBXPLQMXMHJQFKLHNXTKCRZMRKBWDTBBPYFTMLBQZMVVRBTXBCM\n" +
                "QPQWJXRJJXBTKKGBKVXNSCQBHZTSFZRYCDZFYQJQWHWHYJVDRXSGWRLJNTHBXYBRBTVXBBPPCXRBFVXVNDQQTHHBKXZDPQZGSHWF\n";
        System.out.println(findNumberOfReplacements(s));
    }
}