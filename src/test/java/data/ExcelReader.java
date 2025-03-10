package data;

import com.poiji.bind.Poiji;
import modelos.ItemProduct;


import java.io.File;
import java.util.List;

public class ExcelReader {
    public static final String excelPath = "src/test/resources/data/dataExcel.xlsx";

    public static List<ItemProduct> leerListaProductoExcel(){
        return Poiji.fromExcel(new File(excelPath), ItemProduct.class);
    }
}
