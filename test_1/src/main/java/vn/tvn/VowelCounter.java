package vn.tvn;
// =========================================================
// METHOD countVowels()
// =========================================================
// public
// -> method có thể được gọi từ class khác.
//
// static
// -> method thuộc về CLASS,
//    không bắt buộc phải tạo object để gọi method.
//
// int
// -> kiểu dữ liệu trả về.
//    Method này trả về một số nguyên.
//
// countVowels
// -> tên method.
//
// String inputString
// -> method nhận vào một String.
public class VowelCounter {
    //inputString ="hello World"
    //H -> isVowel= No
    //e ->isVowel= Yes-> count= 1
    //L ->isVowel= No-> count= 1 (biến count không tăng)
    //L ->isVowel= No-> count= 1 (biến count không tăng)
    //o-> isVowel= yes-> count= 2
    public static int countVowels(String inputString){
        //nếu chuỗi không tồn tại, chuỗi rỗng thì trả về 0
        // =====================================================
        // BƯỚC 1: KIỂM TRA INPUT KHÔNG HỢP LỆ
        // =====================================================

        // Nếu inputString == null
        // -> không có String nào được truyền vào.
        //
        // Nếu inputString.isEmpty()
        // -> String tồn tại nhưng không chứa ký tự nào.
        //
        // || = OR
        // -> chỉ cần một trong hai điều kiện đúng
        //    thì toàn bộ điều kiện là true.
        //
        // Nếu input không hợp lệ:
        // -> không cần đếm nữa
        // -> trả về 0.
        if (inputString == null || inputString.isEmpty()){
            return 0;
        }
        // =====================================================
        // BƯỚC 2: TẠO BIẾN COUNT
        // =====================================================

        // count dùng để lưu số lượng vowel đã tìm thấy.
        //
        // Ban đầu chưa tìm thấy vowel nào:
        //
        // count = 0
        int count =0;
        //tạo new object để gọi method "isVowel3" từ class vowelchecker file "vowelchecker"
        //
        // =====================================================
        // BƯỚC 3: TẠO OBJECT VOWELCHECKER
        // =====================================================

        // Chúng ta đã có một class khác là:
        //
        // vowelchecker
        //
        // Class đó có method:
        //
        // isVowel3()
        //
        // Method isVowel3() có nhiệm vụ:
        //
        // input là một ký tự
        //       ↓
        // kiểm tra có phải vowel không
        //       ↓
        // return true / false
        //
        // Vì isVowel3() là NON-STATIC,
        // nên cần tạo object để gọi nó.
        //
        // Cấu trúc:
        //
        // Class         Variable       Object
        //   ↓               ↓              ↓
        // vowelchecker vowelChecker = new vowelchecker();
        //
         //Với non-static method, cần một object để gọi nó
        vowelchecker vowelChecker = new vowelchecker();
        // =====================================================
        // BƯỚC 4: DUYỆT TỪNG KÝ TỰ TRONG STRING
        // =====================================================

        // for loop dùng để đi qua từng ký tự
        // trong inputString.
        //
        // i = 0
        // -> bắt đầu từ vị trí đầu tiên.
        //
        // i < inputString.length()
        // -> tiếp tục khi i vẫn còn nằm trong String.
        //
        // i++
        // -> sau mỗi vòng lặp, tăng i lên 1.
        for (int i =0; i< inputString.length(); i++){
            //String.valueOf(inputString.charAt(i)) → mục đích là chuyển char thành String để truyền vào isVowel3(String input).
            // =================================================
            // BƯỚC 5: LẤY KÝ TỰ HIỆN TẠI
            // =================================================

            // inputString.charAt(i)
            // -> lấy ký tự tại vị trí i.
            //
            // Ví dụ:
            //
            // inputString = "hello"
            //
            // i = 0
            // charAt(0) -> 'h'
            //
            // i = 1
            // charAt(1) -> 'e'
            //
            // charAt() trả về kiểu char.
            //
            // Nhưng method isVowel3() của chúng ta
            // đang nhận String:
            //
            // isVowel3(String input)
            //
            // Vì vậy cần chuyển char thành String.
            //
            // String.valueOf(...)
            // -> chuyển giá trị thành String.
            // Kết quả được lưu vào biến c.
            String c = String.valueOf(inputString.charAt(i));
            // =================================================
            // BƯỚC 6: KIỂM TRA CÓ PHẢI VOWEL KHÔNG
            // =================================================

            // Gọi method isVowel3() từ object vowelChecker.
            //
            // vowelChecker.isVowel3(c)
            //
            // Method sẽ trả về:
            //
            // true  -> c là vowel
            // false -> c không phải vowel
            //
            //
            // Nếu kết quả là true:
            // -> tăng count lên 1.
            //
            // isVowel3 -> tên method
            //nghĩa là phải truyền chuỗi vài biến c, xong mới check từng ký t (char) để tăng count nếu char đó la vowel
            if ( (vowelChecker.isVowel3(c))){
                //count++ nghĩa là tăng count lên 1 mỗi khi gặp nguyên âm.
                count ++;
            }
        }
        //không còn vòng lặp hay điều kiện nào nữa, return về count cuối cùng
        // =====================================================
        // BƯỚC 7: TRẢ VỀ KẾT QUẢ CUỐI CÙNG
        // =====================================================

        // Khi for loop kết thúc:
        //
        // count đã chứa tổng số vowel tìm được.
        //
        // return count
        // -> trả kết quả về nơi đã gọi method.
        return count;
    }
}
