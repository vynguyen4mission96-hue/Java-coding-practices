package vn.tvn;

import org.junit.Test;

public class BackspaceStringCompare_Test {
    @Test
    public void test01(){
        BackspaceStringCompare object = new BackspaceStringCompare();
        var rs =object.process("ab#c", "ad#c");
        assert rs;
        System.out.println(rs);
    }

    @Test
    public void test02(){
        BackspaceStringCompare object = new BackspaceStringCompare();
        var rs =object.process("ab#c", "adc");
        assert !rs;
        System.out.println(rs);
    }

    @Test
    public void test03(){
        BackspaceStringCompare object = new BackspaceStringCompare();
        var rs =object.process("ab##", "c#d#");
        assert rs;
        System.out.println(rs);
    }
}
