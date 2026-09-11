package vn.tvn;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromeTest {
    @Test
    public void test01(){
        LongestPalindrome object = new LongestPalindrome();
        //var = để Java tự suy luận kiểu dữ liệu từ giá trị khởi tạo (bên main code)
        var rs = object.process("abccccdd");
        Assert.assertEquals("cccc", rs);
        var rs2= rs;
        System.out.println(rs2);

    }

    @Test
    public void test02(){
        LongestPalindrome object = new LongestPalindrome();
        //var = để Java tự suy luận kiểu dữ liệu từ giá trị khởi tạo (bên main code)
        var rs = object.process("babad");
        // do bên main là if (len > end - start+1)
        Assert.assertEquals("bab", rs);
        //nếu bên main là if (len > end - start) thì output sẽ trở thành "aba"
        var rs2= rs;
        System.out.println(rs2);

    }

    @Test
    public void test03(){
        LongestPalindrome object = new LongestPalindrome();
        //var = để Java tự suy luận kiểu dữ liệu từ giá trị khởi tạo (bên main code)
        var rs = object.process("cbbd");
        Assert.assertEquals("bb", rs);
        var rs2= rs;
        System.out.println(rs2);

    }
}
