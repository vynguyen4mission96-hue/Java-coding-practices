package vn.tvn;

public class task07_1_SumofDigits {
    /*
     * Function Signature:
     *
     * public
     * → method có thể được gọi từ bên ngoài class.
     *
     * static
     * → có thể gọi method trực tiếp thông qua class,
     *   không cần tạo object.
     *
     * int
     * → kiểu dữ liệu mà method sẽ return.
     *
     * sumOfDigits
     * → tên method.
     *
     * int digits
     * → parameter (tham số).
     *   Method nhận vào một số nguyên.
     */

    //Java thường dùng camelCase, tức chữ đầu tiên viết thường: sumOfDigits
    public static int sumOfDigits(int digits) {

        /*
         * Biến sum dùng để lưu tổng các chữ số
         * mà chúng ta đã tính được.
         *
         * Ban đầu chưa cộng chữ số nào
         * nên sum = 0.
         */
        int sum = 0;
        /*
         * Biến modulo dùng để lưu
         * chữ số cuối cùng của digits.
         *
         * Ví dụ:
         * 12345 % 10 → 5
         */
        int modulo = 0;

        /*
         * Lặp lại khi digits vẫn còn lớn hơn 0.
         *
         * Mỗi vòng lặp sẽ:
         * 1. Lấy chữ số cuối.
         * 2. Cộng chữ số đó vào sum.
         * 3. Bỏ chữ số cuối khỏi digits.
         *
         * Khi digits = 0 → đã xử lý hết các chữ số.
         */
        while (digits > 0){
            /*
             * % (modulo):
             * Lấy phần dư của phép chia.
             *
             * Với số nguyên dương chia cho 10,
             * phần dư chính là chữ số cuối cùng.
             *
             * Ví dụ:
             * 12345 % 10 → 5
             * 1234  % 10 → 4
             * 123   % 10 → 3
             */
            modulo = digits%10;

            /*
             * Cộng chữ số vừa lấy được vào tổng.
             *
             * Ví dụ:
             * sum = 0
             * modulo = 5
             *
             * → sum = 5
             */

            //sum += modulo;
            sum = modulo+sum;

            /*
             * / 10:
             * Với int, phép chia cho 10 sẽ bỏ phần thập phân.
             *
             * Mục đích ở đây là bỏ chữ số cuối.
             *
             * Ví dụ:
             * 12345 / 10 → 1234
             * 1234  / 10 → 123
             * 123   / 10 → 12
             * 12    / 10 → 1
             * 1     / 10 → 0
             */
            digits = digits/10;

        }
        /*
         * Trả tổng các chữ số về nơi đã gọi method.
         */
        return sum;
    }
}
