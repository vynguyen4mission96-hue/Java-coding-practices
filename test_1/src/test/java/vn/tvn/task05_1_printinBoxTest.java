package vn.tvn;

public class task05_1_printinBoxTest {
    public static void main(String[] args){
        //test thử chuỗi trên màn hình console
        System.out.println("TEST");
        System.out.println("");

        //mảng chính
        //truyền input vào mảng
        //new String[] tạo mảng ngay tại chỗ, tương đương String[] numbers = {}
        //new String[]{} là argument (đối số)-dữ liệu thực tế đưa vào
        task05_1_printinBox.printInBox(new String[]{"1","2","3","1234","5","6","45","8","9"});

    }
}
