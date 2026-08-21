package vn.tvn;

public class task02_VowelCounter {
    public static int countvowels(String inputstring) {
        //int là số nguyên
        //nếu không có dữ liệu
        if (inputstring == null) {
            //trả về 0
            return 0;
        }
        if (inputstring.length() == 0) {
            //nếu chuỗi rỗng
            //trả về 0
            return 0;

        }
        //chuyển toàn bộ chuỗi sang chữ thường
        inputstring = inputstring.toLowerCase();

        //tạo biến đếm số lượng vowel trong chuỗi
        // khởi tạo biến số nguyên count= 0
        int count = 0;
        //i là vị trí của ký tự. bắt đầu từ vị trí 0- vị trí đầu tiên
        //i < inputstring.length() thì đếm cho đến ết chuỗi
        // i++ là mỗi lần lặp, tăng i thêm 1
        for (int i = 0; i < inputstring.length(); i++) {
            //inputstring.length() cho biết chuỗi có bao nhiêu ký tự
            // i tại vị trí 0 sử dụng dấu =
            //charAt() là lấy 1 ký tự trong chuỗi
            char letter = inputstring.charAt(i);

            //nếu tìm thấy nguyên âm
            if (letter == 'a'
                    ||letter == 'e'
                    ||letter == 'i'
                    ||letter == 'o'
                    ||letter == 'u'){
                //tăng biến đếm count lên
                count = count + 1;


                //trả về tổng số nguyên âm đếm được trong chuỗi



            }
        }
        return count;
    }
}