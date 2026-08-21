package vn.tvn;
//src/test/java: Viết main()

public class task01_vowelcheckTest {
    public static void main(String[] args)
    //[] có nghĩa là mảng (array).
    //args = danh sách dữ liệu được truyền vào chương trình- một tên biến
    //String[] là một tập hợp gồm nhiều chuỗi kí tự
    //main() là điểm bắt đâầu của chương trình. khi bấm run, Java sẽ tìm hàm main() đầu tiên
    {
        System.out.println(task01_Vowelcheck.isvowel("a"));
        System.out.println(task01_Vowelcheck.isvowel("E"));
        System.out.println(task01_Vowelcheck.isvowel("b"));
        System.out.println(task01_Vowelcheck.isvowel("Z"));
        System.out.println(task01_Vowelcheck.isvowel(""));
        System.out.println(task01_Vowelcheck.isvowel("ae"));
        System.out.println(task01_Vowelcheck.isvowel(null));

        //gọi hàm isvowel()
        // truyền charinput= a vào
        //kết quả in ra màn hình (
    }
}