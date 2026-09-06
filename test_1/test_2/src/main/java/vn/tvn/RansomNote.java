package vn.tvn;

// HashMap là lớp dùng để lưu dữ liệu theo dạng "key → value".
// Ví dụ: 'a' → 2 nghĩa là chữ 'a' xuất hiện 2 lần.
import java.util.HashMap;// tự nó tạo

// Map là interface đại diện cho cấu trúc dữ liệu lưu theo dạng "key → value".
// Ở đây dùng Map ở bên trái và HashMap ở bên phải:
// Map<Character, Integer> map = new HashMap<>();
// Character = ký tự, Integer = số lượng ký tự đó.
import java.util.Map;// ự nó tạo

public class RansomNote {

    //cách 1:hashmap
    public boolean process(String ransomNote, String magazine){
        // Tạo một Map rỗng để lưu:
        // "ký tự" → "số lần ký tự đó xuất hiện trong magazine"
        //
        // Ví dụ magazine = "aabbc"
        // thì map sẽ có:
        // 'a' → 2
        // 'b' → 2
        // 'c' → 1
        Map<Character, Integer> map = new HashMap<>();
        // DUYỆT QUA magazine ĐỂ "NHẬP KHO"
        //
        // Mỗi lần gặp một ký tự, ta tăng số lượng của ký tự đó lên 1.
        for (int i=0; i<magazine.length(); i++){
            // Lấy ký tự tại vị trí i trong magazine.
            // Ví dụ:
            // magazine = "aab"
            // i = 0 → c = 'a'
            // i = 1 → c = 'a'
            // i = 2 → c = 'b'
            char c = magazine.charAt(i);
            // map.getOrDefault(c, 0):
            // - Nếu c đã có trong map → lấy số lượng hiện tại.
            // - Nếu c chưa có → lấy giá trị mặc định là 0.
            //
            // Sau đó +1 vì vừa gặp thêm một chữ c.
            //
            // Ví dụ gặp 'a' lần đầu:
            // map chưa có 'a'
            // → lấy 0
            // → 0 + 1 = 1
            //
            // Gặp 'a' lần thứ hai:
            // map đang có 'a' → 1
            // → 1 + 1 = 2
            //
            // Kết quả cuối cùng là số lần xuất hiện của từng ký tự.
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        // DUYỆT QUA ransomNote ĐỂ KIỂM TRA CÓ ĐỦ "NGUYÊN LIỆU" HAY KHÔNG
        //
        // toCharArray() chuyển String thành một mảng các ký tự.
        //
        // Ví dụ:
        // ransomNote = "aba"
        // → ['a', 'b', 'a']

        //c lần lượt nhận từng phần tử (từng ký tự) của mảng ký tự được tạo ra từ ransomNote
        for (char c: ransomNote.toCharArray()){
            // Kiểm tra 2 trường hợp KHÔNG ĐỦ ký tự:
            //
            // 1. !map.containsKey(c)
            //    → trong kho hoàn toàn không có ký tự c.
            //
            // 2. map.get(c) == 0
            //    → có ký tự c trong kho, nhưng đã sử dụng hết.
            //
            // Chỉ cần một trong hai trường hợp xảy ra
            // → ransomNote không thể được tạo ra.
            if (!map.containsKey(c)|| map.get(c)==0){
                return false;
            }
            // Nếu kho vẫn còn ký tự c:
            // sử dụng 1 ký tự c
            // → số lượng c trong kho giảm đi 1.
            //
            // Ví dụ:
            // map đang có 'a' → 3
            // sử dụng một 'a'
            // → 'a' → 2
            map.put(c, map.get(c)-1);
        }
        // Nếu duyệt hết ransomNote mà không gặp trường hợp thiếu ký tự
        // → magazine có đủ ký tự để tạo ransomNote.
       return true;

    }

    // CÁCH 2: Dùng mảng int[26]
    //
    // Cách này dựa trên giả định đề bài chỉ sử dụng
    // các chữ cái thường từ 'a' đến 'z'.
    public boolean process2(String ransomNote, String magazine){
        // Tạo một mảng gồm 26 phần tử.
        //
        // Mỗi phần tử đại diện cho một chữ cái:
        //
        // count[0]  → số lượng chữ 'a'
        // count[1]  → số lượng chữ 'b'
        // count[2]  → số lượng chữ 'c'
        // ...
        // count[25] → số lượng chữ 'z'
        //
        // Ban đầu tất cả phần tử đều bằng 0.
        int[] count= new int[26];
        // DUYỆT QUA magazine ĐỂ "NHẬP KHO"

        //c lần lượt nhận từng phần tử (từng ký tự) của mảng ký tự được tạo ra từ magazine
        for (char c : magazine.toCharArray()){
            // Chuyển ký tự c thành vị trí tương ứng trong mảng.
            //
            // Trong Java, ký tự 'a' có giá trị số 97,
            // 'b' có giá trị số 98,
            // 'c' có giá trị số 99,...
            //
            // Vì vậy:
            // 'a' - 'a' = 97 - 97 = 0 → vị trí 0
            // 'b' - 'a' = 98 - 97 = 1 → vị trí 1
            // 'c' - 'a' = 99 - 97 = 2 → vị trí 2
            //
            // Nhờ phép trừ này, 26 chữ cái 'a' → 'z'
            // được chuyển thành các index từ 0 → 25.
            //
            // Ví dụ c = 'c':
            // c - 'a' = 99 - 97 = 2
            // → count[2] là nơi lưu số lượng chữ 'c'.
            //
            // Sau đó ++ để tăng số lượng chữ c lên 1.
            count[c-'a']++;
        }
        // DUYỆT QUA ransomNote ĐỂ KIỂM TRA CÓ ĐỦ KÝ TỰ KHÔNG
        //c lần lượt nhận từng phần tử (từng ký tự) của mảng ký tự được tạo ra từ ransomNote
        for (char c : ransomNote.toCharArray()){
            // Xác định vị trí của ký tự c trong mảng.
            //
            // Nếu count[c - 'a'] == 0:
            // → kho không còn ký tự c.
            //
            // Nghĩa là ransomNote cần c
            // nhưng magazine không còn c để sử dụng.
            if ((count[c-'a']==0)){
                return false;
            }
            // Nếu count[c - 'a'] > 0:
            // → kho vẫn còn ít nhất một ký tự c.
            //
            // Ta sử dụng một ký tự c
            // → giảm số lượng c đi 1.
            //
            // Ví dụ:
            // count['a'] đang là 3
            // sử dụng một 'a'
            // → còn 2.
            count[c-'a']--;

        }
        // Nếu duyệt hết ransomNote mà không phát hiện ký tự nào bị thiếu
        // → magazine có đủ ký tự để tạo ransomNote.
        return true;
    }



}
