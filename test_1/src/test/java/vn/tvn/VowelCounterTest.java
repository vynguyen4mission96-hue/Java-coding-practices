package vn.tvn;
// Import Assert của JUnit.
//
// Assert cung cấp các method để kiểm tra
// Actual Result có đúng Expected Result hay không.
import org.junit.Assert;
// Import @Test.
//
// @Test đánh dấu method bên dưới
// là một TEST CASE của JUnit.
import org.junit.Test;


// TDD = Test-Driven Development
// Class chứa các Unit Test
// cho class VowelCounter.
public class VowelCounterTest {
    @Test
    public  void testvowelCounterTest01(){
        VowelCounter object =new VowelCounter();
        //khởi tạo object mới
        //gán biến rs (results)= new object
        // Gọi method countVowels()
        // và truyền vào String:
        //
        // "Hello World"
        //
        // Method trả về int
        // -> số lượng vowel.
        //
        // Kết quả được lưu vào biến rs.
        //
        // rs = result
        int rs= object.countVowels("Hello World");
        //trả về có 3 vowels thì passed: e, o, o
        // assertEquals(expected, actual)
        Assert.assertEquals(3, rs);

    }

    @Test
    public  void testvowelCounterTest02(){
        VowelCounter object =new VowelCounter();
        int rs= object.countVowels("Education");
        //trả về có 5 vowels thì passed: e, u, a, i, o
        Assert.assertEquals(5, rs);

    }

    @Test
    public  void testvowelCounterTest03(){
        VowelCounter object =new VowelCounter();
        int rs= object.countVowels("");
        //không có vowel nào-> trả về 0
        Assert.assertEquals(0, rs);

    }

    @Test
    public  void testvowelCounterTest04(){
        VowelCounter object =new VowelCounter();
        int rs= object.countVowels("rhythm");
        //không có vowel nào-> trả về 0
        Assert.assertEquals(0, rs);

    }
}
