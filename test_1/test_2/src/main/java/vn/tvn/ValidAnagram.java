package vn.tvn;

import java.util.Arrays;// nó tự tạo
import java.util.HashMap;// nó tự tạo
import java.util.Map;// nó tự tạo

public class ValidAnagram {
    //anagram
    //1.số ký tự bằng nhau
    //2.số lần xuất hiện của từng ký tự bằng nhau
    //3.theo thứ tự không quna trọng

    // Cách 1: Chuyển 2 chuỗi thành mảng ký tự → sort → so sánh
//
// Ví dụ:
// s = "anagram"
// t = "nagaram"
//
// Hai chuỗi có cùng số ký tự → mới có khả năng là Anagram.
    //s= 6 và t=6
    public boolean process(String s, String t){
        // Nếu độ dài 2 chuỗi khác nhau
        // → chắc chắn không thể là Anagram
        if (s.length() != t.length()){
            return false;
        }
        // Chuyển String thành char[]
        //
        // s = "anagram"
        // sArr = ['a', 'n', 'a', 'g', 'r', 'a', 'm']
        //
        // t = "nagaram"
        // tArr = ['n', 'a', 'g', 'a', 'r', 'a', 'm']
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        // Sắp xếp các ký tự trong 2 mảng
        //
        // sArr → ['a', 'a', 'a', 'g', 'm', 'n', 'r']
        // tArr → ['a', 'a', 'a', 'g', 'm', 'n', 'r']
        //Class Arrays cung cấp nhiều method làm việc với array của s và t
        Arrays.sort(sArr);
        Arrays.sort(tArr);


        // So sánh 2 mảng sau khi đã sort
        //
        // Nếu giống nhau → true
        // Nếu khác nhau → false
        return Arrays.equals(sArr,tArr);

    }

    // Cách 2: HashMap Solution
// Dùng HashMap để đếm số lần xuất hiện của từng ký tự
// trong s và t.
//
// HashMap lưu theo dạng:
// character → số lần xuất hiện
//
// Ví dụ:
// s = "anagram"
// sMap:
// a → 3
// n → 1
// g → 1
// r → 1
// m → 1
//
// Nếu sMap và tMap giống nhau
// → 2 chuỗi có cùng ký tự và cùng số lần xuất hiện
// → là Anagram.
    public boolean process2 (String s, String t){
        // Nếu độ dài 2 chuỗi khác nhau
        // → chắc chắn không thể là Anagram
        if (s.length() != t.length()) {
            return false;
        }
        // Tạo HashMap để đếm ký tự của s
        // Key   = Character → ký tự
        // Value = Integer   → số lần ký tự xuất hiện
        Map<Character, Integer> sMap = new HashMap<>();
        // Tạo HashMap tương tự để đếm ký tự của t
        Map<Character, Integer> tMap = new HashMap<>();
        // Duyệt qua từng vị trí của 2 chuỗi
        //
        // Vì đã kiểm tra độ dài bằng nhau ở trên
        // nên có thể dùng chung một vòng for.
        for (int i= 0; i<s.length(); i++){
            // Lấy ký tự tại vị trí i của s
            char sChar =s.charAt(i);
            // Lấy ký tự tại vị trí i của t
            char tChar =t.charAt(i);
            // Tăng số lần xuất hiện của sChar trong sMap
            //
            // getOrDefault(sChar, 0):
            // - Nếu sChar đã tồn tại → lấy số lần hiện tại
            // - Nếu chưa tồn tại → lấy 0
            //
            // Sau đó + 1 để tăng số lần xuất hiện.
            sMap.put(sChar, sMap.getOrDefault(sChar, 0)+1);
            // Tăng số lần xuất hiện của tChar trong tMap
            //
            // Lưu ý:
            // phải dùng tChar ở cả put() và getOrDefault()
            // vì chúng ta đang đếm ký tự của t.
            tMap.put(tChar, tMap.getOrDefault(tChar, 0)+1);
        }
        // So sánh 2 HashMap
        //
        // Nếu:
        // sMap = {a=3, n=1, g=1, r=1, m=1}
        // tMap = {a=3, n=1, g=1, r=1, m=1}
        //
        // → equals() trả về true
        //
        // Nếu số lượng ký tự khác nhau
        // → equals() trả về false.
        return  sMap.equals(tMap);

    }

    // Cách 3: HashMap Solution - "Cân bằng tồn kho"
//
// Ý tưởng:
// Chỉ dùng 1 HashMap để theo dõi số lượng ký tự.
//
// Với mỗi ký tự:
// - Gặp trong s → +1 (nhập tồn kho)
// - Gặp trong t → -1 (trừ tồn kho)
//
// Nếu s và t là Anagram:
// → mỗi ký tự sẽ được cộng và trừ bằng nhau
// → tất cả value trong Map cuối cùng phải = 0.
    public boolean process3 (String s, String t){
        // Nếu độ dài 2 chuỗi khác nhau
        // → chắc chắn không thể là Anagram
        if (s.length() != t.length()) {
            return false;
        }
        // Chỉ cần 1 HashMap
        //
        // Key   = Character → ký tự
        // Value = Integer   → số lượng chênh lệch
        //
        // Ví dụ:
        // "a" → 2
        // nghĩa là hiện tại đang "dư" 2 ký tự 'a'.
        Map<Character, Integer> map = new HashMap<>();
        // Duyệt qua từng vị trí của cả 2 chuỗi
        //
        // Vì 2 chuỗi đã được kiểm tra có cùng độ dài
        // nên có thể xử lý s và t trong cùng một vòng for.
        for (int i=0; i< s.length(); i++){
            // Lấy ký tự tại vị trí i của s
            char sChar = s.charAt(i);
            // Lấy ký tự tại vị trí i của t
            char tChar = t.charAt(i);
            // "Nhập tồn kho": nhập vào
            // Mỗi lần gặp sChar trong s → +1
            //
            // Nếu chưa có sChar → mặc định là 0
            // sau đó +1.
            map.put(sChar, map.getOrDefault(sChar, 0)+1);
            // "Trừ tồn kho": bán ra
            // Mỗi lần gặp tChar trong t → -1
            //
            // Nếu chưa có tChar → mặc định là 0
            // sau đó -1.
            map.put(tChar, map.getOrDefault(tChar, 0)-1);
        }
        // Sau khi duyệt hết 2 chuỗi:
        //
        // Nếu s và t là Anagram
        // → số lượng mỗi ký tự phải cân bằng
        // → tất cả value trong Map phải = 0.
        //
        // Ví dụ:
        // s = "anagram"
        // t = "nagaram"
        //
        // Cuối cùng:
        // a → 0
        // n → 0
        // g → 0
        // r → 0
        // m → 0
        // Duyệt qua tất cả VALUE trong Map
        for (int count: map.values()){
            // Nếu có bất kỳ value nào khác 0
            // → số lượng ký tự không cân bằng
            // → không phải Anagram
            if(count != 0){
                return false;
            }

        }

        // Tất cả value đều = 0
        // → số lượng tất cả ký tự đã cân bằng
        // → s và t là Anagram
        return true;

    }

    //**cách 4:
    // s = "anagram"
    // t = "nagaram"
    //dùng array đếm số lần xuất hiện của từng ký tự
    //không dùng unicode, chỉ dung ASCII characters: 26 phần tử (a đến z)
    public  boolean process4(String s, String t) {
        // Nếu độ dài 2 chuỗi khác nhau
        // → chắc chắn không thể là Anagram
        if (s.length() != t.length()) {
            return false;
        }
        //[0,0,0,0,...,0] mảng 26 phần tử (tương đương 26 vị trí)
        //bắt đầu đếm ký tự xuất hiện thì 0+1
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            //a=97, b=98, c=99,..., z=122
            //s.charAt(i)-'a'
            char a = 'a';
            //1.lấy char tại s vị trí i- 'a'
            //vd: s.charArt(i)='a' -> 'a'-'a' =0
            //count[0]++ -> tăng lên 1 cho giá count[0]
            //vd: s.charArt(i)='b' -> 'b'-'a' =1
            //count[1]++ -> tăng lên 1 cho giá count[1]
            count[s.charAt(i) - 'a']++;
            //2.lấy char tại t vị trí i- 'a'
            //vd: t.charArt(i)='a' -> 'a'-'a' =0
            //count[0]-- -> giảm 1 cho giá count[0]
            //vd: t.charArt(i)='b' -> 'b'-'a' =1
            //count[1]-- -> giảm 1 cho giá count[1]
            count[t.charAt(i) - 'a']--;

        }
        for (int c : count) {
            // Nếu có bất kỳ value nào khác 0
            // → số lượng ký tự không cân bằng
            // → không phải Anagram
            if (c != 0) {
                return false;
            }


        }
        return true;
    }

    //khi nào dùng cách nao2?
    //chỉ c a-z -> dùng mảng 26 phần t
    //unicode/ký tự bất kì -> dùng hashmap
    //muốn code nhanh, dễ nhớ -> dùng sort
    //-> pattern Frequency counter


}
