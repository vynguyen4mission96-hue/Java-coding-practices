package vn.tvn;

import java.util.Map;

public class RomantoInteger {
    //chữ nhỏ trước chữ lớn -> trừ
    //chữ nh sau chữ lơ -> cộng
    //I=1, V=5, X=10, L=50
    //C=100, D=500. M=1000
    //VI -> 5+1 =6
    //IV-> 5-1= 4
    //IV, IX, XL, XC, CD, CM-> không có ghép DM
    //duyệt String ừ trái sang phải
    //nếu ký ự hiện tại < ký tự tiếp theo -> trừ
    //ngược lại cộng

    //
    // ============================================================
    // 1. BẢNG GIÁ TRỊ CỦA CÁC KÝ TỰ ROMAN
    // ============================================================
    //
    // Roman numeral có 7 ký tự cơ bản:
    //
    // I = 1
    // V = 5
    // X = 10
    // L = 50
    // C = 100
    // D = 500
    // M = 1000
    //
    // Ta tạo một Map để:
    //     ký tự Roman  --->  giá trị số
    //
    // Ví dụ:
    //     romanMap.get('I')  --->  1
    //     romanMap.get('V')  --->  5
    //     romanMap.get('X')  --->  10
    //
    // Nhờ Map, khi gặp một ký tự trong String,
    // ta có thể nhanh chóng lấy được giá trị của nó.
    public int process (String s){

       Map<Character, Integer> romanMap =Map.of(
               'I', 1,
               'V', 5,
               'X', 10,
               'L', 50,
               'C', 100,
               'D', 500,
               'M', 1000

        );
        // ============================================================
        // 2. BIẾN result
        // ============================================================
        //
        // result là nơi tích lũy kết quả cuối cùng.
        //
        // Ban đầu chưa tính gì:
        //
        // result = 0
        //
        // Trong quá trình duyệt String:
        //     gặp trường hợp CỘNG  ---> result += currentValue
        //     gặp trường hợp TRỪ   ---> result -= currentValue
        //
        // Cuối cùng result chính là số nguyên cần trả về.
        int result =0;

        // ============================================================
        // 3. DUYỆT STRING TỪ TRÁI SANG PHẢI
        // ============================================================
        //
        // Tại mỗi vị trí i, ta cần nhìn:
        //
        //      ký tự hiện tại       ký tự kế tiếp
        //            ↓                   ↓
        //            i                 i + 1
        //
        // Ví dụ:
        //
        //      M   C   M
        //          ↑   ↑
        //          i  i+1
        //
        // Vì cần nhìn i + 1 nên vòng lặp KHÔNG được chạy
        // tới ký tự cuối cùng.
        //
        // String: "MCM"
        // index:   0  1  2
        //
        // Ta chỉ duyệt:
        //      i = 0
        //      i = 1
        //
        // Không duyệt i = 2 ở vòng lặp này,
        // vì index 2 không có ký tự phía sau nữa.
        //
        // Vì vậy:
        //
        // i < s.length() - 1
        //
        // Ví dụ s.length() = 3
        //
        // i < 3 - 1
        // i < 2
        //
        // => i chỉ nhận 0 và 1.
        for (int i=0; i < s.length()-1; i++){
            // ========================================================
            // 4. LẤY GIÁ TRỊ CỦA KÝ TỰ HIỆN TẠI
            // ========================================================
            //
            // s.charAt(i)
            //     lấy ký tự ở vị trí i trong String.
            //
            // Ví dụ:
            //
            // s = "MCM"
            //
            // i = 1
            //
            // s.charAt(1) ---> 'C'
            //
            // Sau đó:
            //
            // romanMap.get('C') ---> 100
            //
            // Nên:
            //
            // currentValue = 100
            int currentValue =romanMap.get(s.charAt(i));

            // ========================================================
            // 5. LẤY GIÁ TRỊ CỦA KÝ TỰ KẾ TIẾP
            // ========================================================
            //
            // s.charAt(i + 1)
            //     lấy ký tự ngay bên phải ký tự hiện tại.
            //
            // Ví dụ:
            //
            // s = "MCM"
            //
            // i = 1
            //
            // s.charAt(i)     ---> 'C'
            // s.charAt(i + 1) ---> 'M'
            //
            // romanMap.get('M') ---> 1000
            //
            // Nên:
            //
            // nextValue = 1000
            int nextValue = romanMap.get(s.charAt(i+1));
            // ========================================================
            // 6. ĐÂY LÀ "TRÁI TIM" CỦA BÀI
            // ========================================================
            //
            // So sánh:
            //
            //       GIÁ TRỊ HIỆN TẠI
            //               với
            //       GIÁ TRỊ KẾ TIẾP
            //
            // Có 2 trường hợp:
            //
            // ┌─────────────────────────────────────────────────────┐
            // │ currentValue < nextValue                            │
            // │                                                     │
            // │ ký tự nhỏ đứng trước ký tự lớn                     │
            // │                    ↓                                │
            // │                  TRỪ                                │
            // │                                                     │
            // │ Ví dụ: IV                                           │
            // │       1 < 5                                          │
            // │       => -1                                         │
            // │                                                     │
            // │ Ví dụ: IX                                           │
            // │       1 < 10                                         │
            // │       => -1                                         │
            // └─────────────────────────────────────────────────────┘
            //
            //
            // ┌─────────────────────────────────────────────────────┐
            // │ currentValue >= nextValue                           │
            // │                                                     │
            // │ ký tự hiện tại lớn hơn hoặc bằng ký tự kế tiếp      │
            // │                    ↓                                │
            // │                  CỘNG                               │
            // │                                                     │
            // │ Ví dụ: VI                                           │
            // │       5 >= 1                                         │
            // │       => +5                                         │
            // │                                                     │
            // │ Ví dụ: XI                                           │
            // │       10 >= 1                                        │
            // │       => +10                                        │
            // └─────────────────────────────────────────────────────┘
            if (currentValue <nextValue){
                // Ký tự hiện tại nhỏ hơn ký tự phía sau
                // => phải TRỪ giá trị hiện tại.
                //
                // Ví dụ:
                //
                // I V
                // ↑ ↑
                // 1 5
                //
                // 1 < 5
                // => result = result - 1
                result -= currentValue;
            }
            else{
                // Ký tự hiện tại lớn hơn hoặc bằng ký tự phía sau
                // => CỘNG giá trị hiện tại.
                //
                // Ví dụ:
                //
                // V I
                // ↑ ↑
                // 5 1
                //
                // 5 >= 1
                // => result = result + 5
                result += currentValue;
            }
        }
        // ============================================================
        // 7. CỘNG KÝ TỰ CUỐI CÙNG
        // ============================================================
        //
        // Đây là chỗ rất dễ thắc mắc:
        //
        // "Tại sao vòng for không duyệt ký tự cuối?"
        //
        // Vì vòng for cần nhìn:
        //
        //       current       next
        //          i          i + 1
        //
        // Nếu i đã là vị trí cuối cùng thì:
        //
        //       i + 1
        //
        // không còn tồn tại.
        //
        // Vì vậy ta cố tình bỏ ký tự cuối ra khỏi vòng lặp.
        //
        // Sau khi xử lý tất cả các ký tự trước nó,
        // ta cộng riêng ký tự cuối cùng.
        //
        // Ví dụ:
        //
        // "VI"
        //
        // Vòng for xử lý V:
        //
        // V I
        // 5 1
        //
        // 5 >= 1
        // => +5
        //
        // Sau vòng for:
        // result = 5
        //
        // Ký tự cuối là I:
        // => +1
        //
        // result = 6
        result += romanMap.get(s.charAt(s.length()-1));
        // ============================================================
        // 7. CỘNG KÝ TỰ CUỐI CÙNG
        // ============================================================
        //
        // Đây là chỗ rất dễ thắc mắc:
        //
        // "Tại sao vòng for không duyệt ký tự cuối?"
        //
        // Vì vòng for cần nhìn:
        //
        //       current       next
        //          i          i + 1
        //
        // Nếu i đã là vị trí cuối cùng thì:
        //
        //       i + 1
        //
        // không còn tồn tại.
        //
        // Vì vậy ta cố tình bỏ ký tự cuối ra khỏi vòng lặp.
        //
        // Sau khi xử lý tất cả các ký tự trước nó,
        // ta cộng riêng ký tự cuối cùng.
        //
        // Ví dụ:
        //
        // "VI"
        //
        // Vòng for xử lý V:
        //
        // V I
        // 5 1
        //
        // 5 >= 1
        // => +5
        //
        // Sau vòng for:
        // result = 5
        //
        // Ký tự cuối là I:
        // => +1
        //
        // result = 6
        return result;
    }

}
