package vn.tvn;

public class ValidAnagram2 {

    // =========================================================
    // CÁCH 4: ARRAY COUNTING SOLUTION
    // =========================================================
    //
    // Ví dụ:
    // s = "anagram"
    // t = "nagaram"
    //
    // Ý tưởng:
    // Dùng một int[] có 26 phần tử để đếm số lần xuất hiện
    // của từng chữ cái từ 'a' đến 'z'.
    //
    // Không dùng HashMap.
    // Chỉ áp dụng cho chữ cái tiếng Anh thường: a → z.
    //
    // Quy ước:
    //
    // count[0]  → số lần xuất hiện của 'a'
    // count[1]  → số lần xuất hiện của 'b'
    // count[2]  → số lần xuất hiện của 'c'
    // ...
    // count[25] → số lần xuất hiện của 'z'
    //
    // Cách đếm:
    // - Gặp ký tự trong s → +1
    // - Gặp ký tự trong t → -1
    //
    // Nếu cuối cùng tất cả phần tử trong count đều = 0
    // → số lượng từng ký tự của s và t giống nhau
    // → s và t là Anagram.


    public boolean process4(String s, String t) {

        // Nếu độ dài 2 chuỗi khác nhau
        // → chắc chắn không thể là Anagram.
        if (s.length() != t.length()) {
            return false;
        }


        // Tạo một array có 26 phần tử.
        //
        // Ban đầu tất cả giá trị đều bằng 0:
        //
        // count =
        // [0, 0, 0, 0, 0, ..., 0]
        //
        // 26 vị trí tương ứng với 26 chữ cái:
        //
        // count[0]  → 'a'
        // count[1]  → 'b'
        // count[2]  → 'c'
        // ...
        // count[25] → 'z'
        int[] count = new int[26];


        // Duyệt qua từng vị trí của s và t.
        //
        // Vì ở trên đã kiểm tra s.length() == t.length()
        // nên có thể xử lý s và t trong cùng một vòng for.
        for (int i = 0; i < s.length(); i++) {


            // =================================================
            // PHẦN 1: ĐẾM KÝ TỰ TRONG s
            // =================================================
            //
            // s.charAt(i)
            // → lấy ký tự tại vị trí i của chuỗi s.
            //
            // Ví dụ:
            // s.charAt(i) = 'c'
            //
            // Trong ASCII:
            // 'a' = 97
            // 'b' = 98
            // 'c' = 99
            //
            // Ta lấy giá trị của ký tự hiện tại trừ cho
            // giá trị của 'a' để chuyển nó thành index 0 → 25.
            //
            // Với 'a':
            // 97 - 97 = 0
            // → count[0]
            //
            // Với 'b':
            // 98 - 97 = 1
            // → count[1]
            //
            // Với 'c':
            // 99 - 97 = 2
            // → count[2]
            //
            // Vì vậy:
            //
            // 'a' → index 0
            // 'b' → index 1
            // 'c' → index 2
            // ...
            // 'z' → index 25
            //
            // Sau khi tìm được index:
            // ++ nghĩa là tăng giá trị tại vị trí đó lên 1.
            //
            // Ví dụ:
            // gặp 'c'
            // → tìm được index 2
            // → count[2]++
            // → số lượng 'c' tăng thêm 1.
            count[s.charAt(i) - 'a']++;


            // =================================================
            // PHẦN 2: TRỪ KÝ TỰ TRONG t
            // =================================================
            //
            // t.charAt(i)
            // → lấy ký tự tại vị trí i của chuỗi t.
            //
            // Tương tự s ở trên, ta chuyển ký tự thành
            // index từ 0 → 25 bằng cách lấy giá trị của
            // ký tự trừ cho giá trị của 'a'.
            //
            // Ví dụ:
            // nếu t.charAt(i) = 'c'
            //
            // 'c' có giá trị 99
            // 'a' có giá trị 97
            //
            // 99 - 97 = 2
            //
            // → count[2]--
            //
            // -- nghĩa là giảm giá trị tại vị trí đó đi 1.
            //
            // Gặp ký tự trong t → trừ đi 1.
            count[t.charAt(i) - 'a']--;
        }


        // =====================================================
        // KIỂM TRA KẾT QUẢ
        // =====================================================
        //
        // Sau khi duyệt hết s và t:
        //
        // Nếu s và t là Anagram:
        // → mỗi ký tự xuất hiện trong s bao nhiêu lần
        // → cũng phải xuất hiện trong t bấy nhiêu lần.
        //
        // Vì:
        // s → +1
        // t → -1
        //
        // nên số lượng sẽ được cân bằng về 0.
        //
        // Ví dụ:
        //
        // s có 'a' 3 lần → +3
        // t có 'a' 3 lần → -3
        //
        // Kết quả:
        // count[0] = 0
        //
        // Tất cả các ký tự đều phải có kết quả = 0.


        // for-each:
        // Lấy lần lượt từng giá trị trong array count.
        //
        // c là giá trị hiện tại của một phần tử trong count.
        for (int c : count) {

            // Nếu có bất kỳ phần tử nào khác 0:
            //
            // → có ít nhất một ký tự có số lượng
            //   không giống nhau giữa s và t.
            //
            // → không phải Anagram.
            if (c != 0) {
                return false;
            }
        }


        // Nếu chạy đến đây:
        // → tất cả 26 phần tử đều bằng 0.
        //
        // → số lượng tất cả ký tự của s và t đều cân bằng.
        // → s và t là Anagram.
        return true;
    }
}