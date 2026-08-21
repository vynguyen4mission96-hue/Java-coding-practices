package vn.tvn;

// Import class Assert của JUnit.
// Assert cung cấp các method để kiểm tra
// kết quả thực tế có đúng với kết quả mong đợi hay không.
import org.junit.Assert;//nó tự tạo
// Import @Test.
//
// @Test nói cho JUnit biết:
// "Method ngay bên dưới là một TEST CASE."
import org.junit.Test;// tự nó tạo khi viết @test ầu tiên


// TDD = Test-Driven Development
public class VowelcheckerTest {
    // =========================================================
    // TEST 01
    // =========================================================

    // @Test = đây là một test case của JUnit.
    // a. e, i, o, u
    @Test
    public void test01(){
        //new object of vowelchecker

        // Tạo một OBJECT từ class vowelchecker.
        //
        // vowelchecker
        // -> kiểu dữ liệu / class
        //
        // vowelChecker
        // -> tên biến tham chiếu tới object
        //
        // new vowelchecker()
        // -> tạo một object mới.
        //
        // Có thể hiểu đơn giản:
        //
        // Class = bản thiết kế
        // Object = một đối tượng được tạo ra từ bản thiết kế
        vowelchecker vowelChecker= new vowelchecker();
        //
        // Gọi method isVowel()
        // và truyền input = "a".
        //
        // Method trả về boolean:
        //
        // true hoặc false
        //
        // Kết quả được lưu vào biến rs.
        //
        // rs = result
        boolean rs = vowelChecker.isVowel("a");

        // ASSERTION = kiểm tra kết quả.
        //
        // assertTrue()
        // -> chúng ta EXPECT kết quả phải là true.
        //
        // Nếu rs == true
        // -> TEST PASS
        //
        // Nếu rs == false
        // -> TEST FAIL
        Assert.assertTrue(rs);


    }
    @Test
    public void test02(){
        //new object of vowelchecker
        vowelchecker vowelChecker= new vowelchecker();
        //
        boolean rs = vowelChecker.isVowel("e");
        // Expected result = true.
        Assert.assertTrue(rs);


    }
    @Test
    public void test03(){
        //new object of vowelchecker
        vowelchecker vowelChecker= new vowelchecker();
        //
        boolean rs = vowelChecker.isVowel("i");
        Assert.assertTrue(rs);


    }
    @Test
    public void test04(){
        //new object of vowelchecker
        vowelchecker vowelChecker= new vowelchecker();
        //
        boolean rs = vowelChecker.isVowel("o");
        Assert.assertTrue(rs);


    }
    @Test
    public void test05(){
        //new object of vowelchecker
        vowelchecker vowelChecker= new vowelchecker();
        //
        boolean rs = vowelChecker.isVowel("u");
        Assert.assertTrue(rs);


    }
    @Test
    public void test06(){
        //new object of vowelchecker
        vowelchecker vowelChecker= new vowelchecker();

        // "k" không phải nguyên âm.
        boolean rs = vowelChecker.isVowel("k");
        // Lần này EXPECT result = false.
        //
        // assertFalse()
        // -> kết quả chúng ta mong đợi phải là false.
        //
        // rs = false
        // -> PASS
        //
        // rs = true
        // -> FAIL
        Assert.assertFalse(rs);


    }
    @Test
    public void test07(){
        //new object of vowelchecker
        vowelchecker TestvowelChecker= new vowelchecker();
        //rs là biến results để coi n trả về cái gì
        // "aa" có length = 2.
        //
        // "aa" có length = 2.
        //
        // Method yêu cầu input phải có đúng 1 ký tự.
        boolean rs = TestvowelChecker.isVowel("aa");
        // Vì "aa" không hợp lệ,
        // chúng ta EXPECT false.
        Assert.assertFalse(rs);


    }
    //thay isvowel2 hay isvowel3 để test thử METHOD 2 hoặc METHOD 3
    @Test
    public void test08(){
        //new object of vowelchecker
        //Java phân biệt tên class và tên biến dựa vào vị trí của chúng, chứ không bắt buộc tên biến phải khác tên class.
        //vowelchecker là class type
        // vowelChecker là variable name (viết giống hay khác class cũng được, không có error)- đặt tên gì cũng được
        //new vowelchecker() là object created
        vowelchecker vowelChecker= new vowelchecker();
        //
        // Test chuỗi rỗng "".
        //
        // "" có length = 0.
        //
        // Vì length != 1
        // -> method phải return false.
        boolean rs = vowelChecker.isVowel2("");
        Assert.assertFalse(rs);

    //thay isvowel2 hay isvowel3 để test thử METHOD 2 hoặc METHOD 3
    }
    @Test
    public void test09() {
        //new object of vowelchecker
        //Java phân biệt tên class và tên biến dựa vào vị trí của chúng, chứ không bắt buộc tên biến phải khác tên class.
        //vowelchecker là class type
        // vowelchecker thứ 2 là variable name (viết giống hay khác class cũng được, không có error)- đặt tên gì cũng được
        //new vowelchecker() là object created
        vowelchecker vowelchecker = new vowelchecker();
        //
        boolean rs = vowelchecker.isVowel3("A");
        Assert.assertTrue(rs);
    }


}
