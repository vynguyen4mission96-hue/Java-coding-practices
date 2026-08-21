package vn.tvn;

public class vowelchecker {
    // =========================================================
    // METHOD 1: isVowel()
    // =========================================================

    // public  -> method có thể được gọi từ class khác
    // boolean -> kiểu dữ liệu mà method sẽ trả về: true hoặc false
    // isVowel -> tên method
    // String input -> method nhận vào một String tên là input
    public boolean isVowel(String input)//khai báo boolean trả về true or false
    {
        // Kiểm tra 2 trường hợp không hợp lệ:
        //
        // 1. input == null
        //    -> input không chứa giá trị nào
        //
        // 2. input.length() != 1
        //    -> độ dài của input khác 1
        //    Ví dụ:
        //       "a"  -> length = 1  -> hợp lệ
        //       "aa" -> length = 2  -> không hợp lệ
        //       ""   -> length = 0  -> không hợp lệ
        //
        // || = OR
        // Chỉ cần MỘT trong hai điều kiện đúng thì toàn bộ điều kiện đúng.
        //
        // != = NOT EQUAL / khác
        if (input == null || input.length() != 1){
            // return false
            // -> kết thúc method ngay lập tức
            // -> trả kết quả false về nơi đã gọi method
            return false;
        }
        //equals là kiểm tra có bằng value (phân biệt viết hoa và biết thường)
        //equalsIgnoreCase bằng chính value đó không phân biệt viết hoa hay viết thường (a hay A cũng là a)
        //để fix test case 9 failed do không nhận diện được viết hoa hay thường, thêm toLowerCase() để chuyển text về lowercase hết
        input =input.toLowerCase();
        if (input. equals("a")){
            return true;
        }

        // Kiểm tra input có bằng "e" hay không.
        //
        // equalsIgnoreCase() cũng dùng để so sánh String
        // nhưng KHÔNG phân biệt chữ hoa / chữ thường.
        //
        // Ví dụ:
        // "e".equalsIgnoreCase("E") -> true
        // "e".equalsIgnoreCase("e") -> true
        //
        // Lưu ý:
        // Ở đây thực ra không cần equalsIgnoreCase()
        // nữa vì input đã được toLowerCase().
        if (input. equalsIgnoreCase("e")){
            return true;
        }
        if (input. equalsIgnoreCase("i")){
            return true;
        }
        if (input. equalsIgnoreCase("o")){
            return true;
        }
        if (input. equalsIgnoreCase("u")){
            return true;
        }
        // không còn điều kiện nào true nữa thì trả về false
        return false;
    }

    // =========================================================
    // METHOD 2: isVowel2()
    // =========================================================

    // Đây là một cách viết khác để giải quyết cùng một bài toán.
    //
    // isVowel()
    // -> kiểm tra từng nguyên âm bằng nhiều if.
    //
    // isVowel2()
    // -> dùng contains() để kiểm tra input
    //    có nằm trong chuỗi "aeiou" hay không.
    public boolean isVowel2(String input)//khai báo boolean trả về true or false
    {      // != là khác
        if (input == null || input.length() != 1) {
            return false;
        }
        input = input.toLowerCase();
        //operation
        // input chứa "aeiou" thì return true
        // contains() dùng để kiểm tra:
        //
        // "aeiou" có chứa input hay không?
        //
        // Nếu có -> true
        // Nếu không -> false
        //
        // Ví dụ:
        //
        // "aeiou".contains("a") -> true
        // "aeiou".contains("e") -> true
        // "aeiou".contains("k") -> false
        //
        // Vì contains() đã trả về boolean,
        // nên không cần:
        //
        // if (...) {
        //     return true;
        // }
        // return false;
        //
        // Có thể return trực tiếp kết quả của contains().
        // bấm ctl +click vào method ".contains" để đọc nhiều hơn trong thư viện Java
        return "aeiou".contains(input);

    }

    // =========================================================
    // METHOD 3: isVowel3()
    // =========================================================

    // Đây là cách thứ 3 để giải quyết cùng bài toán.
    //
    // Điểm khác:
    // isVowel3() chuyển String thành char
    // rồi so sánh char với từng ký tự nguyên âm.
    public boolean isVowel3(String input){
        if (input == null || input.length() != 1) {
            return false;
        }
        // Chuyển String thành chữ thường.
        //
        // "A" -> "a"
        input = input.toLowerCase();
        // char là kiểu dữ liệu dùng để lưu MỘT ký tự.
        //
        // input.charAt(0)
        // -> lấy ký tự ở vị trí index 0.
        //
        // Ví dụ:
        //
        // input = "a"
        //
        // index:
        //   0
        //   ↓
        //  "a"
        //
        // input.charAt(0) -> 'a'
        //
        // Lưu ý:
        // String dùng "a"
        // char dùng 'a'
        char c = input.charAt(0);
        //bằng 1 trong những ký tự "aeiou" thì return true
        // Kiểm tra c có phải là một trong:
        //
        // 'a'
        // 'e'
        // 'i'
        // 'o'
        // 'u'
        //
        // == dùng để so sánh giá trị.
        //
        // || = OR
        //
        // Chỉ cần một điều kiện đúng
        // thì toàn bộ biểu thức là true.
        //
        // Ví dụ:
        //
        // c = 'a'
        //
        // c == 'a' -> true
        //
        // true || false || false || false || false
        // -> true
        return  c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u';

    }

}
