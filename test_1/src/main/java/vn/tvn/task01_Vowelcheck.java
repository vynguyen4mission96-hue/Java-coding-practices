package vn.tvn;//khai báo package (thư mục chứa file)

//tạo một class tên là task01_Vowelcheck// class: mọi chương trình Java đều viết bên trong mô Class
//src/main/java: Viết hàm isVowel()

public class task01_Vowelcheck{

    //public: hàm này có thể gọi từ bên ngoài
    //boolean: hàm trả về true or false
    //isVowel: tên của hàm
    //String: kiểu dữ liệu của tham số- chuỗi ký tự
    //char input: tên của biến đầu vào
    //static: có thể gọi trực tiếp mà không cần tao đô tượng

    public static boolean isvowel (String charinput){

        //kiểm tra khi data không tồn tại
        if (charinput == null){
             return false;
        }

        //Length() trả về số ký tự trong chuỗi
        //"".Length() = 0
        //"a".Lenght()= 1
        //"ae".Length() = 2
        // != nghĩa là "không bằng/ khác"
        if (charinput.length() != 1){

            // nếu độ dài KHÔNG BẰNG 1, return trả về kết quả ngày lập tức. Hàm dừng lại ở đây

            return false;
        }

        charinput = charinput.toLowerCase();

        //toLowerCase() chuyển chữ hoa thành cữ thường. Ví dụ: A thành a

        return charinput.equals("a")
                ||charinput.equals("e")
                ||charinput.equals("i")
                ||charinput.equals("o")
                ||charinput.equals("u");

        //equals() dùng để so sánh 2 chuỗi. ví dụ: "a".equals("a) thì true. còn "a".equals("b) th false

    }

}
