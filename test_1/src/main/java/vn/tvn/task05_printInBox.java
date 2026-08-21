package vn.tvn;

public class task05_printInBox {
    // void là data type không có RETURN
    public static void printinBox(String numberstring){

        //nếu numstring== null, biến numstring thanh 1 chuỗi rỗng
        //khi in ra numstring sẽ trống
        if (numberstring== null){
            numberstring="";
        }
        String boxline ="";
        // i<numberstring.length()+2; để vẽ - sao cho số nằm ở giữa
        //ví dụ: 5 có length()= 1, thì vẽ --- tức là 3 dấu -
        for  (int i=0; i < numberstring.length()+2; i++){
            // nối chuỗi, cứ 1 vòng lặp i th tăng thêm -
            boxline = boxline + "-";
        }
        //hàng 1
        System.out.println("+"+boxline+"+");
        //hàng 2
        System.out.println("+"+" "+numberstring+" "+"+");
        //hàng 3
        System.out.println("+"+boxline+"+");

    }
}
