package vn.tvn;
//task06_findLongestString là class chứa method
public class task06_findLongestString {
    /*
     * Function Signature:
     *
     * public  → method có thể được gọi từ bên ngoài class
     * static  → có thể gọi method trực tiếp thông qua class,
     *           không cần tạo object
     * String  → kiểu dữ liệu mà method sẽ RETURN
     * findLongestString → tên của method
     * String[] stringArray → parameter:
     *                        nhận vào một array chứa các String
     */
    public static String findLongestString(String[] stringArray){
        /*
         * Kiểm tra 2 trường hợp đặc biệt:
         *
         * 1. stringArray == null
         *    → cả array không tồn tại
         *
         * 2. stringArray.length == 0
         *    → array tồn tại nhưng không có phần tử nào
         *
         * Trong cả 2 trường hợp, đề bài yêu cầu return ""
         */
        if (stringArray== null || stringArray.length ==0){
            return "";
        }

        /*
         * current:
         * Lưu độ dài (number of characters) của String hiện tại
         * đang được kiểm tra trong vòng for.
         */
        int current = 0;
        /*
         * longestString:
         * Lưu chính String đang có độ dài lớn nhất.
         *
         * Ban đầu cho = "" để biến có giá trị ngay từ đầu.
         */
        int longest = 0;
        /*
         * for loop:
         *
         * Duyệt qua từng phần tử trong stringArray.
         *
         * i = index (vị trí) của phần tử hiện tại.
         *
         * i < stringArray.length
         * → tiếp tục cho đến phần tử cuối cùng.
         *
         * i++
         * → sau mỗi vòng lặp, i tăng thêm 1.
         */
        String longestString= "";
        for (int i=0; i< stringArray.length; i++){
            if (stringArray[i] == null){
                /*
                 * continue:
                 * Bỏ qua phần còn lại của vòng lặp hiện tại
                 * và chuyển sang phần tử tiếp theo.
                 */
                continue;
            }
            /*
             * .length()
             * → method của String dùng để lấy số ký tự trong String.
             *
             * Ví dụ:
             * "cat".length()  → 3
             * "dogs".length() → 4
             *
             * current lưu độ dài của String hiện tại.
             */
            current = stringArray[i].length();
            /*
             * So sánh độ dài String hiện tại với độ dài lớn nhất
             * mà chúng ta đã tìm thấy.
             *
             * Dùng > thay vì >=.
             *
             * Vì nếu 2 String có cùng length,
             * chúng ta phải giữ String xuất hiện đầu tiên.
             */
            if (current > longest){
                /*
                 * Cập nhật độ dài lớn nhất.
                 */
               longest= current;

                /*
                 * Lưu String hiện tại vì nó đang là String dài nhất.
                 */
               longestString = stringArray[i];
            }
        }
        /*
         * return:
         * Trả kết quả của method về nơi đã gọi method.
         *
         * Ở đây kết quả là String dài nhất.
         */
        return longestString;

    }
}
