package vn.tvn;

public class task03_char_removeTest {
    public static void main(String[] args){
        //xóa ký tự ở vị trí 2
        System.out.println(task03_char_remove.removeCharatindex("hello", 2));
        //class → truy cập method → gọi method → nhận return
        //"task03_char_remove.removeCharatindex" nghãi là ClassA.methodA()
        //
        //xóa ký tự ở vị trí 0
        System.out.println(task03_char_remove.removeCharatindex("Java", 0));
        //
        //xóa ký tự ở vị trí KHÔNG HỢP LỆ
        System.out.println(task03_char_remove.removeCharatindex("hello", 10));
        //
        //chuỗi rỗng
        System.out.println(task03_char_remove.removeCharatindex("", 5));
        //
         //data không tồn tại
        System.out.println(task03_char_remove.removeCharatindex(null, 5));
    }


}
