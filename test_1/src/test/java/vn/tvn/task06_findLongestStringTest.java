package vn.tvn;

public class task06_findLongestStringTest {
    /*
     * main() là điểm bắt đầu khi chúng ta chạy class này.
     *
     * String[] args:
     * parameter của main().
     *
     * args có thể chứa các argument được truyền vào
     * khi chạy chương trình.
     *
     * Ở các bài hiện tại, chúng ta chưa cần sử dụng args.
     */
    public static void main(String[] args){
        System.out.println("result1: "+task06_findLongestString.findLongestString(new String[]{"1","1234","45","123456789","8","99","666","55555","2228"}));
        System.out.println("result2: "+task06_findLongestString.findLongestString(new String[]{"cat", "dogs", "bird", "fish"}));
        /*
         * TEST 3
         *
         * Array có một phần tử null ở giữa.
         *
         * Method phải bỏ qua null
         * và tiếp tục kiểm tra các String còn lại.
         *
         * Expected result:
         * "dogs"
         */
        System.out.println("result3: "+task06_findLongestString.findLongestString(new String[]{"cat", "dogs", null,"bird", "fish"}));
        /*
         * TEST 4
         *
         * Array có một String rỗng "".
         *
         * "" là một String hợp lệ.
         *
         * "".length() = 0
         *
         * Expected result:
         * ""
         */
        System.out.println("result4: "+task06_findLongestString.findLongestString(new String[]{""}));
        /*
         * TEST 5
         *
         * Empty array:
         *
         * new String[]{}
         *
         * Array tồn tại nhưng có 0 phần tử.
         *
         * Method phải return "".
         */
        System.out.println("result5: "+task06_findLongestString.findLongestString(new String[]{}));
        /*
         * TEST 6
         *
         * Array có 1 phần tử và phần tử đó là null.
         *
         * Method phải bỏ qua null bằng continue.
         *
         * Không được gọi:
         *
         * null.length()
         *
         * vì điều đó sẽ gây NullPointerException.
         *
         * Expected result:
         * ""
         */
        System.out.println("result6: "+task06_findLongestString.findLongestString(new String[]{null}));
    }
}
