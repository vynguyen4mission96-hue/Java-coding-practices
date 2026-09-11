package vn.tvn;

public class LongestPalindrome {
    //s="babad"
    //s="dbbd"--> tâm của string này là 2 ch ở giữa "bb"
    //Palindrome --> luôn c 1 tâm đối xứng
    //tâm chẵn, tâm lẻ
    //
     //
     //
    // ============================================================
    // BÀI TOÁN:
    // Given a string s,
    // return the longest palindromic substring in s.
    //
    // Palindromic substring:
    // - Palindrome = đọc từ trái sang phải hay phải sang trái
    //   đều giống nhau.
    // - Substring = một đoạn ký tự LIÊN TIẾP trong String.
    //
    // Ví dụ:
    // s = "babad"
    //
    // Có 2 palindrome dài nhất:
    //
    //     "bab"        "aba"
    //      ↑             ↑
    //     tâm           tâm
    //
    // Cả hai đều có độ dài = 3.
    // Vì vậy "bab" và "aba" đều là đáp án hợp lệ
    // nếu đề không quy định phải chọn một đáp án cụ thể.
    //
    //
    // ============================================================
    // Ý TƯỞNG CHÍNH: EXPAND AROUND CENTER
    //
    // Thay vì thử từng substring rồi kiểm tra palindrome,
    // ta làm ngược lại:
    //
    //     1. Chọn một TÂM.
    //     2. Từ tâm đó mở rộng sang trái và phải.
    //     3. Nếu 2 ký tự giống nhau -> tiếp tục mở rộng.
    //     4. Nếu khác nhau -> dừng.
    //
    // Một palindrome có thể có:
    //
    //     TÂM LẺ:   1 ký tự ở giữa
    //
    //                 a
    //               /   \
    //              b     b
    //
    //              Ví dụ: "bab"
    //
    //
    //     TÂM CHẴN: tâm nằm giữa 2 ký tự
    //
    //                 | |
    //                 b b
    //
    //              Ví dụ: "bb"
    //
    //
    // Vì có 2 loại tâm nên tại mỗi i,
    // ta phải thử cả 2 trường hợp.
    // ============================================================

    // Ví dụ:
    // s = "babad"
    //
    // index:  0 1 2 3 4
    //         b a b a d
    //
    // Ví dụ:
    // s = "dbbd"
    //
    // index:  0 1 2 3
    //         d b b d
    //
    // "bb" là palindrome có TÂM CHẴN.
    // Tâm nằm giữa index 1 và index 2:
    //
    //         d b | b d
    //             ↑
    //          tâm ở giữa
    //
    // ============================================================

    // ============================================================
    // HÀM process()
    //
    // Đây là HÀM CHÍNH của bài.
    //
    // Nhiệm vụ:
    // - duyệt qua từng vị trí i trong String
    // - lấy i làm tâm
    // - thử tâm lẻ
    // - thử tâm chẵn
    // - lấy palindrome dài hơn
    // - nếu nó dài hơn kết quả hiện tại
    //   thì lưu lại vị trí start/end của nó
    // ============================================================
    public String process(String s) {
        // --------------------------------------------------------
        // Kiểm tra input.
        //
        // Nếu s == null:
        //     String không tồn tại.
        //
        // Nếu s.isEmpty():
        //     String tồn tại nhưng không có ký tự nào.
        //
        // Trong cả 2 trường hợp,
        // không có palindrome để tìm.
        //
        // Vì vậy trả về String rỗng: ""
        // --------------------------------------------------------
        if (s == null || s.isEmpty()) return "";

        // --------------------------------------------------------
        // start và end dùng để LƯU VỊ TRÍ của palindrome dài nhất
        // mà ta đang tìm được.
        //
        // start = index bắt đầu palindrome.
        // end   = index kết thúc palindrome.
        //
        // Ban đầu:
        //
        // start = 0
        // end   = 0
        //
        // nghĩa là ta tạm coi ký tự đầu tiên
        // là palindrome tốt nhất.
        //
        // Ví dụ:
        //
        // s = "babad"
        //
        // index:
        //         0 1 2 3 4
        //         b a b a d
        //
        // ban đầu:
        //
        //         start = 0
        //         end   = 0
        //
        // kết quả hiện tại là:
        //
        //         "b"
        // --------------------------------------------------------
        int start = 0, end = 0;

        // --------------------------------------------------------
        // Duyệt từng index của String.
        //
        // i sẽ lần lượt là:
        //
        //         0 -> 1 -> 2 -> 3 -> 4
        //
        // Mỗi i được xem như một VỊ TRÍ TÂM.
        //
        // Tại mỗi i:
        //     thử tâm lẻ
        //     thử tâm chẵn
        // --------------------------------------------------------
        for (int i = 0; i < s.length(); i++) {
            // ====================================================
            // TRƯỜNG HỢP 1: TÂM LẺ
            //
            // expand(s, i, i)
            //
            // left  = i
            // right = i
            //
            // Nghĩa là left và right cùng đứng tại
            // MỘT KÝ TỰ.
            //
            // Ví dụ:
            //
            //         b a b
            //           ↑
            //        i = 1
            //
            // left  = 1
            // right = 1
            //
            // Đây là cách tìm palindrome có độ dài LẺ:
            //
            //         "b"
            //         "bab"
            //         "aba"
            //         "racecar"
            //
            // ====================================================

            int len1 = expand(s, i, i);

            // ====================================================
            // TRƯỜNG HỢP 2: TÂM CHẴN
            //
            // expand(s, i, i + 1)
            //
            // left  = i
            // right = i + 1
            //
            // Nghĩa là tâm nằm GIỮA 2 KÝ TỰ.
            //
            // Ví dụ:
            //
            //         d b | b d
            //             ↑
            //            tâm
            //
            // i     = 1
            // i + 1 = 2
            //
            // left  = 1
            // right = 2
            //
            // Đây là cách tìm palindrome có độ dài CHẴN:
            //
            //         "bb"
            //         "abba"
            //         "noon"
            //
            // ====================================================
            int len2 = expand(s, i, i + 1);

            // ----------------------------------------------------
            // Có 2 kết quả:
            //
            // len1 = độ dài palindrome có tâm lẻ
            // len2 = độ dài palindrome có tâm chẵn
            //
            // Chỉ cần lấy cái dài hơn.
            //
            // Ví dụ:
            //
            // len1 = 3
            // len2 = 0
            //
            // Math.max(3, 0) -> 3
            // ----------------------------------------------------
            int len = Math.max(len1, len2);
            //chỗ này quan trọng
            //if (len > end - start+1)-> kết quá là bab
            //if (len > end - start)-> kết quả là aba
            //if (len >= end - start+1) -> kết quả cũng là aba

            // ====================================================
            // SO SÁNH VỚI PALINDROME ĐANG LƯU
            //
            // Đây là chỗ RẤT QUAN TRỌNG.
            //
            // len:
            //     độ dài palindrome MỚI vừa tìm được.
            //
            // end - start + 1:
            //     độ dài palindrome ĐANG LƯU.
            //
            // Tại sao phải +1?
            //
            // Vì start và end đều là index được tính vào.
            //
            // Ví dụ:
            //
            //         b a b
            //         0 1 2
            //
            // start = 0
            // end   = 2
            //
            // độ dài:
            //
            //         2 - 0 + 1 = 3
            //
            // Nếu chỉ viết:
            //
            //         end - start
            //
            // thì sẽ ra:
            //
            //         2 - 0 = 2
            //
            // -> SAI, vì palindrome thực tế dài 3 ký tự.
            //
            //
            // Vì vậy:
            //
            //         end - start + 1
            //
            // là ĐỘ DÀI THẬT của palindrome đang lưu.
            // ====================================================
            if (len > end - start+1) {
                // ------------------------------------------------
                // Nếu palindrome mới DÀI HƠN palindrome đang lưu
                // thì cập nhật lại start.
                //
                // Công thức này tính xem palindrome mới
                // bắt đầu ở index nào.
                //
                // Ví dụ:
                //
                //         "bab"
                //         i = 1
                //         len = 3
                //
                // start = 1 - (3 - 1) / 2
                //       = 1 - 1
                //       = 0
                //
                // Vậy palindrome bắt đầu ở index 0.
                // ------------------------------------------------
                start = i - (len - 1) / 2;
                // ------------------------------------------------
                // Tính vị trí KẾT THÚC của palindrome.
                //
                // Với:
                //
                //         i = 1
                //         len = 3
                //
                // end = 1 + 3 / 2
                //     = 1 + 1
                //     = 2
                //
                // Vậy "bab" nằm từ:
                //
                //         index 0 -> index 2
                // ------------------------------------------------
                end = i + len / 2;
            }

        }

        // ========================================================
        // Sau khi duyệt hết String,
        // start và end đang chứa vị trí của
        // palindrome dài nhất.
        //
        // substring(start, end + 1)
        //
        // rất quan trọng:
        //
        // substring(start, end)
        // KHÔNG lấy ký tự ở vị trí end.
        //
        // Ví dụ:
        //
        //         b a b a d
        //         0 1 2 3 4
        //
        // start = 0
        // end   = 2
        //
        // Muốn lấy:
        //
        //         index 0, 1, 2
        //
        // phải viết:
        //
        //         substring(0, 3)
        //
        // tức là:
        //
        //         substring(start, end + 1)
        //
        // -> "bab"
        // ========================================================
        return s.substring(start, end + 1);
    }


    // tại sao có hàm private? công dụng của nó là gì? hoạt dđộng ra sao?

    // ============================================================
    // HÀM expand()
    //
    // Đây là HELPER METHOD (hàm phụ).
    //
    // private nghĩa là:
    //
    //     Chỉ class LongestPalindrome được phép gọi trực tiếp
    //     hàm này.
    //
    // Bên ngoài class không thể gọi:
    //
    //     object.expand(...)
    //
    // Đây không phải hàm chính của bài.
    //
    // Nó chỉ hỗ trợ process().
    //
    //
    // Có thể hình dung:
    //
    //         process()
    //             |
    //             | gọi
    //             v
    //         expand()
    //
    // process() = người làm công việc chính
    //
    // expand()  = người phụ việc,
    //              chuyên mở rộng palindrome từ một cái tâm.
    // ============================================================
    private int expand(String s, int left, int right) {

        // ========================================================
        // while sẽ tiếp tục chạy KHI CẢ 3 điều kiện đều đúng.
        //
        // Điều kiện 1:
        //
        //         left >= 0
        //
        // left chưa đi ra ngoài bên trái String.
        //
        //
        // Điều kiện 2:
        //
        //         right < s.length()
        //
        // right chưa đi ra ngoài bên phải String.
        //
        //
        // Điều kiện 3:
        //
        //         s.charAt(left) == s.charAt(right)
        //
        // ký tự bên trái và ký tự bên phải giống nhau.
        //
        // Nếu cả 3 đúng:
        //
        //         -> palindrome vẫn đối xứng
        //         -> tiếp tục mở rộng.
        // ========================================================
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // ----------------------------------------------------
            // left--
            //
            // Sau khi 2 ký tự hiện tại giống nhau,
            // ta thử đi thêm 1 bước sang TRÁI.
            //
            // Ví dụ:
            //
            //         b a b
            //         ↑   ↑
            //       left right
            //
            // Sau:
            //
            //         left--
            //
            // left đi sang ký tự bên trái.
            // ----------------------------------------------------
            left--;
            // ----------------------------------------------------
            // right++
            //
            // Đồng thời thử đi thêm 1 bước sang PHẢI.
            //
            // Vì palindrome phải đối xứng,
            // nên left và right luôn mở rộng cùng nhau.
            //
            //         ← left     right →
            //
            // ----------------------------------------------------
            right++;

        }

        // ========================================================
        // Khi while kết thúc:
        //
        // left và right đã đi RA NGOÀI palindrome 1 bước.
        //
        // Ví dụ:
        //
        //         s = "babad"
        //
        //         b a b
        //         0 1 2
        //
        // Sau khi tìm được "bab":
        //
        //         left  = -1
        //         right = 3
        //
        // left  = -1 -> đã ra ngoài bên trái
        // right = 3  -> đã ra ngoài bên phải của palindrome
        //
        //
        // Vì left và right đều đã vượt ra ngoài 1 bước,
        // độ dài palindrome là:
        //
        //         right - left - 1
        //
        //
        // Ví dụ:
        //
        //         3 - (-1) - 1
        //         = 3
        //
        // -> palindrome dài 3 ký tự.
        //
        //
        // ĐIỂM CẦN NHỚ:
        //
        // expand() KHÔNG trả về chuỗi.
        //
        // expand() chỉ trả về:
        //
        //         ĐỘ DÀI palindrome
        // ========================================================
        return right - left - 1;
    }
}

// step run:
// input s = "babad" --> index = 0,1,2,3,4
// b,a,b,a,d
//
//i=0;
//expand(s,0,0) -> 'b==b'-> length=1;
//expand(s.0,1)->'b != a' ->length= 0;
//start = 0, end =0; -> substring (0,1)="b"
//
//i= 1;
//expand(s,1,1) -> 'b==b'-> length=1;
//expand(s.1,2)->'b != a' ->length= 0;
//start = 0, end =0; -> substring (0,1)="b"
 //
//
//i=2;
// expand(s,2,2)-> 'b==b' -> 'a==a'-> length= 3;
//expand (s,2,3) -> 'b !=a'-> length=0;
//start = 1, end =3; -> substring (1,4)='aba'
