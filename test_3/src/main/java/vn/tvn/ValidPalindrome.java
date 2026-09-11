package vn.tvn;
//Palindrome (chuỗi đối xứng) trong Java là một chuỗi ký tự
// hoặc một số mà khi đọc từ trái sang phải
// hay từ phải sang trái đều giống nhau

public class ValidPalindrome {
    //cách 1: simple solution
    //1.remove non-alphanumeric characters
    //2.convert to lower case
    //3.reverse the string
    //4.compare the original string with the reverse

    // ============================================================
    // CÁCH 1: SIMPLE SOLUTION
    //
    // Ý tưởng:
    // 1. Loại bỏ tất cả ký tự không phải chữ cái hoặc chữ số.
    // 2. Chuyển tất cả về chữ thường.
    // 3. Đảo ngược chuỗi.
    // 4. So sánh chuỗi ban đầu với chuỗi đã đảo.
    //
    // Nếu 2 chuỗi giống nhau -> palindrome -> true
    // Nếu khác nhau -> không phải palindrome -> false
    // ============================================================

    public boolean process(String s) {
        // Nếu s == null thì không có chuỗi để kiểm tra.
        // Ở đây ta quy ước null -> false.
        if (s == null) {
            return false;
        }
        //[^a-zA-Z0-9] là gì?
        //
         //
        // replaceAll() dùng Regular Expression (Regex)
        // để tìm và thay thế các ký tự trong chuỗi.
        //
        // "[^a-zA-Z0-9]" có nghĩa:
        //
        // a-z     -> chữ cái thường từ a đến z
        // A-Z     -> chữ cái hoa từ A đến Z
        // 0-9     -> chữ số từ 0 đến 9
        //
        // Dấu ^ nằm ngay sau [ có nghĩa là "KHÔNG phải".
        //
        // Vì vậy:
        // [^a-zA-Z0-9]
        // = một ký tự KHÔNG phải chữ cái hoặc chữ số.
        //
        // replaceAll(..., "")
        // = tìm những ký tự đó và thay bằng chuỗi rỗng ""
        // = xóa chúng đi.
        //
        // Ví dụ:
        // "A man, a plan!"
        //
        // sau replaceAll():
        // "Amanaplan"
        //
        // Sau đó:
        // toLowerCase()
        // chuyển tất cả thành chữ thường:
        //
        // "amanaplan"
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // StringBuilder(cleaned)
        // -> tạo một StringBuilder chứa chuỗi cleaned.
        //
        // reverse()
        // -> đảo thứ tự các ký tự.
        //
        // toString()
        // -> chuyển StringBuilder trở lại String.
        //
        // Ví dụ:
        //
        // cleaned = "abcba"
        //
        // reverse = "abcba"
        //
        // cleaned = "hello"
        //
        // reverse = "olleh"

        //StringBuilder:
        //→ một "công cụ chứa chuỗi" cho phép mình sửa/thay đổi chuỗi dễ dàng
        String reverse = new StringBuilder(cleaned).reverse().toString();
        // equals() dùng để so sánh NỘI DUNG của hai String.
        //
        // Nếu:
        // cleaned  = "abcba"
        // reverse  = "abcba"
        //
        // -> giống nhau -> true
        //
        // Nếu:
        // cleaned  = "hello"
        // reverse  = "olleh"
        //
        // -> khác nhau -> false
        return cleaned.equals(reverse);

    }

    // ============================================================
    // CÁCH 2: TWO POINTERS
    //
    // Vẫn tạo ra chuỗi cleaned trước.
    //
    // Sau đó:
    //
    // left  -> đứng ở đầu chuỗi
    // right -> đứng ở cuối chuỗi
    //
    // So sánh 2 đầu:
    //
    // cleaned[left] == cleaned[right]
    //
    // thì:
    // left  tiến vào giữa  ->
    // right tiến vào giữa  <-
    //
    // Nếu gặp một cặp khác nhau -> false ngay.
    // Nếu hai pointer gặp nhau mà chưa phát hiện khác nhau -> true.
    // ============================================================

    public boolean process2(String s) {
        // Kiểm tra trường hợp s không tồn tại.
        if (s == null) {
            return false;
        }
        // Loại bỏ tất cả ký tự không phải chữ cái/chữ số
        // rồi chuyển toàn bộ thành chữ thường.
        //
        // Ví dụ:
        //
        // "A man, a plan!"
        //      ↓
        // "Amanaplan"
        //      ↓
        // "amanaplan"
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // left bắt đầu từ index đầu tiên.
        //
        // Ví dụ:
        // cleaned = "abcba"
        //
        // index:
        //   0 1 2 3 4
        //   a b c b a
        //   ^
        //  left
        int left = 0;
        // right bắt đầu từ index cuối cùng.
        //
        // cleaned.length() = 5
        //
        // index cuối = 5 - 1 = 4
        //
        //         right
        //            |
        //   0 1 2 3 4
        //   a b c b a
        int right = cleaned.length() - 1;
        // Chừng nào left vẫn còn đứng TRƯỚC right
        // thì vẫn còn một cặp ký tự cần kiểm tra.
        //
        // left < right
        //
        // Ví dụ:
        //
        // left = 0
        // right = 4
        //
        // 0 < 4 -> tiếp tục.
        while (left < right) {
            // So sánh ký tự ở hai đầu.
            //
            // cleaned.charAt(left)
            // -> lấy ký tự tại vị trí left.
            //
            // cleaned.charAt(right)
            // -> lấy ký tự tại vị trí right.
            //
            // Nếu hai ký tự khác nhau:
            // -> chắc chắn không phải palindrome.
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            // Hai ký tự giống nhau.
            //
            // Không cần kiểm tra lại chúng nữa.
            //
            // left tiến sang phải 1 bước.
            left++;
            // right tiến sang trái 1 bước.
            right--;
        }
        // Nếu chạy hết vòng while mà chưa return false
        // nghĩa là tất cả các cặp từ ngoài vào trong đều giống nhau.
        //
        // -> palindrome.
        return true;
    }

    // ============================================================
    // CÁCH 3: TWO POINTERS WITHOUT CREATING A NEW STRING
    //
    // Đây là cách tối ưu hơn về ý tưởng xử lý.
    //
    // Ta KHÔNG tạo String cleaned.
    //
    // Thay vào đó:
    //
    // left  đi từ trái sang phải
    // right đi từ phải sang trái
    //
    // Nếu gặp ký tự không phải chữ cái/chữ số:
    // -> bỏ qua ký tự đó.
    //
    // Nếu gặp chữ cái/chữ số ở cả hai bên:
    // -> chuyển về chữ thường
    // -> so sánh.
    // ============================================================
    public boolean process3(String s) {
        // Nếu s == null thì không có dữ liệu để kiểm tra.
        if (s == null) {
            return false;
        }
        // left bắt đầu ở ký tự đầu tiên của chuỗi.
        int left = 0;

        // right bắt đầu ở ký tự cuối cùng của chuỗi.
        //
        // length() là số lượng ký tự.
        //
        // Vì index bắt đầu từ 0 nên:
        //
        // index cuối = length() - 1
        int right = s.length() - 1;

        // Tiếp tục khi left vẫn đứng trước right.
        //
        // Khi left >= right:
        // -> hai pointer đã gặp nhau hoặc vượt qua nhau.
        // -> không còn cặp nào cần kiểm tra.
        while (left < right) {

            // ====================================================
            // BƯỚC 1: LEFT BỎ QUA KÝ TỰ KHÔNG HỢP LỆ
            // ====================================================
            //
            // Character.isLetterOrDigit(...)
            // kiểm tra một ký tự có phải:
            //
            // - chữ cái
            // hoặc
            // - chữ số
            //
            // hay không.
            //
            // Dấu ! nghĩa là "KHÔNG".
            //
            // Vì vậy:
            //
            // !Character.isLetterOrDigit(...)
            //
            // nghĩa là:
            // "ký tự này KHÔNG phải chữ cái hoặc chữ số".
            //
            // Nếu đúng:
            // -> left bỏ qua ký tự đó
            // -> left tăng lên 1.
            while (left<right&& !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            // ====================================================
            // BƯỚC 2: RIGHT BỎ QUA KÝ TỰ KHÔNG HỢP LỆ
            // ====================================================
            //
            // Tương tự left.
            //
            // Nếu ký tự ở vị trí right không phải
            // chữ cái hoặc chữ số:
            //
            // -> bỏ qua nó
            // -> right giảm xuống 1.
            while (left<right&& !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            // ====================================================
            // BƯỚC 3: SO SÁNH HAI KÝ TỰ
            // ====================================================
            //
            // Lúc này:
            //
            // s.charAt(left)
            // và
            // s.charAt(right)
            //
            // đều đã là chữ cái hoặc chữ số.
            //
            // Character.toLowerCase(...)
            // chuyển ký tự thành chữ thường.
            //
            // Nhờ vậy:
            //
            // 'A' và 'a'
            //
            // được xem là giống nhau.
            //
            // Nếu sau khi chuyển thành chữ thường
            // mà hai ký tự vẫn khác nhau:
            //
            // -> chắc chắn không phải palindrome.
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
            {
                return false;
            }
            // ====================================================
            // BƯỚC 4: HAI KÝ TỰ GIỐNG NHAU
            // ====================================================
            //
            // Không cần kiểm tra lại cặp này nữa.
            //
            // Cho left tiến vào trong 1 bước.
            // Cho right tiến vào trong 1 bước.
                    left++;
                    right--;

        }
        // Nếu toàn bộ các cặp hợp lệ đều giống nhau
        // -> đây là palindrome.

        return true;
    }

}

