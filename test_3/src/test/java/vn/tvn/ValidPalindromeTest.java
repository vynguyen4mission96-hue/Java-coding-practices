package vn.tvn;

import org.junit.Assert;
import org.junit.Test;

public class ValidPalindromeTest {
    @Test
    public void test01(){
        ValidPalindrome object= new ValidPalindrome();
        //var là biến có thể chứa bất kỳ kiểu gì
        var rs= object.process("A man, a plan, a canal: Panama");
        Assert.assertTrue(rs);
        System.out.println(rs);

    }

    @Test
    public void test02(){
        ValidPalindrome object= new ValidPalindrome();
        var rs= object.process("race a car");
        Assert.assertFalse(rs);
        var rs2 = rs;
        System.out.println(rs2);

    }

    @Test
    public void test03(){
        ValidPalindrome object= new ValidPalindrome();
        var rs= object.process("");
        Assert.assertTrue(rs);
        var rs2 = rs;
        System.out.println(rs2);

    }

    @Test
    public void test04(){
        ValidPalindrome object= new ValidPalindrome();
        var rs= object.process2("A man, a plan, a canal: Panama");
        Assert.assertTrue(rs);
        var rs2 = rs;
        System.out.println(rs2);

    }

    @Test
    public void test05(){
        ValidPalindrome object= new ValidPalindrome();
        var rs= object.process3("A man, a plan, a canal: Panama");
        Assert.assertTrue(rs);
        var rs2 = rs;
        System.out.println(rs2);

    }

}
