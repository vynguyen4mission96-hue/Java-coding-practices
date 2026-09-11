package vn.tvn;

import org.junit.Test;

public class RomantoIntegerTest {
            @Test
            public void test01() {
            RomantoInteger object = new RomantoInteger();
            var rs = object.process("III");
            assert rs == 3;
            System.out.println(rs);
    }
    @Test
    public void test02() {
        RomantoInteger object = new RomantoInteger();
        var rs = object.process("LVIII");
        assert rs == 58;
        System.out.println(rs);
    }

    @Test
    public void test03() {
        RomantoInteger object = new RomantoInteger();
        var rs = object.process("MCMXCIV");
        assert rs == 1994;
        System.out.println(rs);
    }

}
