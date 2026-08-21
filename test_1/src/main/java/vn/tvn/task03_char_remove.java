package vn.tvn;

public class task03_char_remove {
    // removeCharatindex = tên hàm
    //indextoremove = vị trí của ký tự cần xóa
    public static String removeCharatindex(String inputstring, int indextoremove){
        //null là không có dữ liệu, return về chuỗi rỗng ""
        if (inputstring == null){
            return "";
        }
    // length() là hàm để đếm số ký tự trong chuỗi
        //== là so sánh bằng
        //0 là chuỗi không có ký tự nào, return về chuỗi rỗng ""
        if (inputstring.length() == 0){
            return "";
        }

        if (indextoremove < 0){
            return inputstring;
            //indextoremove <0 nghĩa là vị trí cần xóa nhỏ hơn 0. return (trả) về chuỗi ban đầu
        }

        if (indextoremove >= inputstring.length()){
            return inputstring;
            // indextoremove >= số ký tự chuỗi, return (trả về) chuỗi ban đâu
            //[H][e][l][l][o]
            //[0][1][2][3][4]
            //ví dụ: "Hello" có inputstring.length()= 5, indextoremove=5 là không tồn tại, vì index cuối cùng là 4
        }
        //substring() là hàm dùng để cắt một phần của chuỗi
        //cú pháp: text.substring(vitribatdau, vitriketthuc). Note: substring() chỉ lấy một đoạn liên tiếp.
        //Đây là quy tắc cực kỳ quan trọng của substring(start, end): start được lấy, end KHÔNG được lấy.
        //ví dụ: "hello".substring(0, 2). kết quả là "he"
        //
        //
        //substring(start, end):start được lấy, end KHÔNG được lấy.
        //ví dụ: String leftPart = "hello".substring(0, 2); LẤY:index=0, 1 và KHÔNG LẤY: index=2
        //[H][e][l][l][o]
        //[0][1][2][3][4]
        //kết quả: "he"
        String leftpart = inputstring.substring(0, indextoremove);
        //
         //String rightPart = "hello".substring(2 + 1); nghĩa là bắt đầu từ 3 đến hết
        //[H][e][l][l][o]
        //[0][1][2][3][4]
        //index 4 hết chuỗi nên dừng
        //kết quả: "lo"
        String rightpart = inputstring.substring(indextoremove+1);
        //
         //Muốn "xóa ký tự ở giữa", ta phải lấy phần bên trái + lấy phần bên phải + nối hai phần lại. "he" + "lo"
        return leftpart + rightpart;

    }


}
