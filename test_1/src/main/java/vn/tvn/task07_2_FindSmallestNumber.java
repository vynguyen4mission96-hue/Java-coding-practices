package vn.tvn;

public class task07_2_FindSmallestNumber {
    // Method này nhận vào N
    // và trả về số nhỏ nhất có tổng các chữ số bằng N.
    //
    // Ví dụ:
    // N = 16 → 79
    // vì 7 + 9 = 16
    public static int findSmallestNumber (int N){
        // Nếu N = 0 thì số nhỏ nhất có tổng chữ số bằng 0
        // chính là số 0.
        //
        // return dùng để kết thúc method ngay tại đây.
        if (N ==0){
            return 0;
        }
        // digits:
        // Số lượng chữ số mà kết quả cần có.
        //
        // firstDigit:
        // Chữ số đầu tiên (bên trái) của kết quả.
        //
        // remaining:
        // Phần tổng còn lại sau khi đã lấy firstDigit.
        int digits = 0;
        int firstDigit =0;
        int remaining =0;

        // ---------------------------------------------------------
        // BƯỚC 1: Xác định cần bao nhiêu chữ số
        // ---------------------------------------------------------

        // Một chữ số chỉ có thể có giá trị từ 0 đến 9.
        // Vì vậy mỗi chữ số có thể đóng góp tối đa 9 vào tổng.
        //
        // capacity = tổng tối đa mà số lượng chữ số hiện tại
        //            có thể tạo ra.
        int capacity = 0;
        // Tiếp tục thêm khả năng chứa thêm 1 chữ số (9)
        // cho đến khi capacity đủ lớn để chứa N.
        //
        // Ví dụ N = 25:
        //
        // lần 1: capacity = 9   → chưa đủ
        // lần 2: capacity = 18  → chưa đủ
        // lần 3: capacity = 27  → đủ
        //
        // Vì vậy N = 25 cần 3 chữ số.
        while(capacity<N){

            // Thêm khả năng của một chữ số mới.
            // Mỗi chữ số tối đa là 9.
            // capacity +=9
            capacity = capacity+9;
            // Đếm xem hiện tại đã cần bao nhiêu chữ số.
            digits = digits+1;
        }
        // ---------------------------------------------------------
        // BƯỚC 2: Tìm chữ số đầu tiên nhỏ nhất
        // ---------------------------------------------------------

        // Muốn số cuối cùng là số NHỎ NHẤT,
        // chữ số bên trái phải càng nhỏ càng tốt.
        //
        // Nhưng các chữ số phía sau vẫn phải đủ để tạo ra tổng N.
        //
        // Có (digits - 1) chữ số ở phía sau.
        // Mỗi chữ số phía sau tối đa là 9.
        //
        // Vì vậy tổng tối đa của phần phía sau là:
        //
        // (digits - 1) * 9
        //
        // Phần còn lại bắt buộc phải đặt vào firstDigit.
        //
        // Ví dụ N = 16:
        //
        // digits = 2
        //
        // firstDigit = 16 - (2 - 1) * 9
        //            = 16 - 9
        //            = 7
        //
        // → chữ số đầu tiên là 7
        // → chữ số còn lại là 9
        // → kết quả là 79
        firstDigit= N- (digits-1)*9;

        // Tổng còn lại sau khi đã sử dụng firstDigit.
        //
        // Ví dụ:
        // N = 16
        // firstDigit = 7
        //
        // remaining = 16 - 7
        //           = 9
        remaining= N - firstDigit;
        // ---------------------------------------------------------
        // BƯỚC 3: Bắt đầu tạo số kết quả
        // ---------------------------------------------------------

        // result là số cuối cùng mà method sẽ trả về.
        int result=0;
        // Thêm firstDigit vào result.
        //
        // Công thức:
        //
        // result * 10 + digit
        //
        // dùng để thêm một chữ số vào BÊN PHẢI của một số.
        //
        // Ví dụ:
        // result = 7
        // digit  = 9
        //
        // 7 * 10 + 9
        // = 70 + 9
        // = 79
        result= result*10 + firstDigit;
        // ---------------------------------------------------------
        // BƯỚC 4: Thêm các chữ số còn lại
        // ---------------------------------------------------------

        // remaining là tổng vẫn chưa được đưa vào các chữ số.
        //
        // Trong khi remaining vẫn còn > 0,
        // chúng ta tiếp tục lấy các chữ số để thêm vào result.
        while (remaining>0){
            // Một chữ số tối đa chỉ có thể là 9.
            //
            // Math.min(A, B) trả về số NHỎ HƠN giữa A và B.
            //
            // Vì vậy:
            //
            // remaining = 18 → Math.min(18, 9) = 9
            // remaining = 5  → Math.min(5, 9)  = 5
            //
            // Điều này giúp chúng ta không bao giờ tạo ra
            // một chữ số lớn hơn 9.
            int digitMin = Math.min(remaining, 9);
            // Thêm digitMin vào BÊN PHẢI của result.
            //
            // Ví dụ:
            // result = 7
            // digitMin = 9
            //
            // result = 7 * 10 + 9
            //        = 79
            result= result*10 + digitMin;
            // Đã sử dụng digitMin rồi,
            // nên phải trừ nó khỏi phần tổng còn lại.
            //
            // Ví dụ:
            // remaining = 18
            // digitMin = 9
            //
            // remaining = 18 - 9
            //           = 9
            //
            // Vòng lặp sẽ tiếp tục với remaining = 9.
            remaining= remaining-digitMin;
        }
        // Sau khi remaining = 0,
        // tất cả tổng N đã được phân bổ vào các chữ số.
        //
        // result chính là số nhỏ nhất cần tìm.
        return result;
    }
}
