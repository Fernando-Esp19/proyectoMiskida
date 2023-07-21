/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.reporte;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static pe.edu.utp.config.Conexion.getConexion;

/**
 *
 * @author mafer
 */
public class registros {
    
    
    
    public static void crearExcel() throws SQLException {
   
    Workbook book = new XSSFWorkbook();
    Sheet sheet = book.createSheet();

    try {
       // CONFIGURACIÓN DEL TITULO DE LA PRIMERA TABLA
    CellStyle tituloStyle = book.createCellStyle();
    tituloStyle.setAlignment(HorizontalAlignment.CENTER);
    tituloStyle.setVerticalAlignment(VerticalAlignment.CENTER);

    Font tituloFont = book.createFont();
    tituloFont.setFontName("Arial");
    tituloFont.setBold(true);
    tituloFont.setFontHeightInPoints((short) 14);
    tituloStyle.setFont(tituloFont);

    Row filaTitulo = sheet.createRow(1);
    Cell celdaTitulo = filaTitulo.createCell(1);
    celdaTitulo.setCellStyle(tituloStyle);
    celdaTitulo.setCellValue("Cantidad de postres elaborados");
    sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));
    // ********************************************************

    // CONFIGURACIÓN DE LOS ENCABEZADOS DE LA PRIMERA TABLA
    String[] encabezados1 = new String[]{"Código", "Nombre_prod", "Precio",
            "Tipo_prenda", "Marca", "Talla", "Costo_compra", "Cant_tienda", "Cant_almacé", "Fecha entrada","Costo_total","Ganancia deseada"};
    // estilo
    CellStyle encabezados1Style = book.createCellStyle();
    encabezados1Style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
    encabezados1Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    encabezados1Style.setBorderBottom(BorderStyle.THIN);
    encabezados1Style.setBorderLeft(BorderStyle.THIN);
    encabezados1Style.setBorderRight(BorderStyle.THIN);
    encabezados1Style.setBorderTop(BorderStyle.THIN);
    // fuente
    Font encabezados1Font = book.createFont();
    encabezados1Font.setFontName("Arial");
    encabezados1Font.setBold(true);
    encabezados1Font.setColor(IndexedColors.BLACK.getIndex());
    encabezados1Font.setFontHeightInPoints((short) 12);
    encabezados1Style.setFont(encabezados1Font);

    Row filaEncabezados1 = sheet.createRow(4);
    for (int i = 0; i < encabezados1.length; i++) {
        Cell celdaEncabezado1 = filaEncabezados1.createCell(i);
        celdaEncabezado1.setCellStyle(encabezados1Style);
        celdaEncabezado1.setCellValue(encabezados1[i]);
    }
    // ************************************************************

    // SUBIDA DE DATOS DE LA PRIMERA TABLA
    Connection con = getConexion();
    PreparedStatement ps;
    ResultSet res;
    int filaDatos1 = 5;
    CellStyle datos1Style = book.createCellStyle();
    datos1Style.setBorderBottom(BorderStyle.THIN);
    datos1Style.setBorderLeft(BorderStyle.THIN);
    datos1Style.setBorderRight(BorderStyle.THIN);
    datos1Style.setBorderTop(BorderStyle.THIN);

    ps = con.prepareStatement("SELECT p.cod_prod, p.nombre_prod, p.precio, tp.tipo_prenda, m.nombre_marca,\n"
            + "       p.talla, k.costocompra, k.cant_tienda, k.cant_almacen, k.fecentr\n"
            + "FROM kardex k\n"
            + "JOIN producto p ON k.cod_prod = p.cod_prod\n"
            + "JOIN tipo_prenda tp ON p.id_tipo = tp.id_tipo\n"
            + "JOIN marca m ON p.id_marca = m.id_marca;");
    res = ps.executeQuery();

    while (res.next()) {
        int tienda=res.getInt(8);
        int alma=res.getInt(9);
        int cost=res.getInt(7);
        int precio=res.getInt(3);
        int ganan=(alma+tienda)*precio;
        int costototal=(alma+tienda)*cost;
        Row newFilaDatos1 = sheet.createRow(filaDatos1);
        for (int x = 0; x < 12; x++) {
            Cell celdaDato1 = newFilaDatos1.createCell(x);
            celdaDato1.setCellStyle(datos1Style);
            if (x == 0 || x == 1 || x == 3 || x == 4 || x == 5 || x == 9) {
                celdaDato1.setCellValue(res.getString(x + 1));
                
            } else if (x == 2 || x == 6 || x == 7 || x == 8) {
                celdaDato1.setCellValue(res.getInt(x + 1));
                
            }else if(x==10){
                celdaDato1.setCellValue(costototal);
            }else if(x==11){
                celdaDato1.setCellValue(ganan);
            }
        }
        filaDatos1++;
    }
    sheet.autoSizeColumn(0);
    sheet.autoSizeColumn(1);
    sheet.autoSizeColumn(2);
    sheet.autoSizeColumn(3);
    sheet.autoSizeColumn(4);
    sheet.autoSizeColumn(5);
    sheet.autoSizeColumn(6);
    sheet.autoSizeColumn(7);
    sheet.autoSizeColumn(8);
    sheet.autoSizeColumn(9);
    sheet.autoSizeColumn(10);
    sheet.autoSizeColumn(11);
        
   
        // GUARDAR Y ABRIR EL ARCHIVO
        FileOutputStream is = new FileOutputStream("C:\\Users\\mafer\\Desktop\\reporte_de_almacen.xlsx");
        File file = new File("C:\\Users\\mafer\\Desktop\\reporte_de_almacen.xlsx");
        book.write(is);
        is.close();
        Desktop.getDesktop().open(file);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(registros.class.getName()).log(Level.SEVERE, null, ex);
    } catch(IOException ex) {
            Logger.getLogger(registros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
    }
    
    
    
    
    
}
