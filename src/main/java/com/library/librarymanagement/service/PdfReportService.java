package com.library.librarymanagement.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

@Service
public class PdfReportService {

    public String generateOverdueBooksReport(List<Map<String, Object>> overdueBooks) {
        try {
            // This saves the PDF to your Desktop so you can easily find it!
            String filePath = System.getProperty("user.home") + "\\Desktop\\OverdueBooksReport.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            document.add(new Paragraph("Overdue Books Report"));
            document.add(new Paragraph(" ")); // Empty line for spacing

            // Create a table with 4 columns
            PdfPTable table = new PdfPTable(4);
            table.addCell("Member Name");
            table.addCell("Phone");
            table.addCell("Book Title");
            table.addCell("Due Date");

            for (Map<String, Object> row : overdueBooks) {
                table.addCell(row.get("name") != null ? row.get("name").toString() : "");
                table.addCell(row.get("phone") != null ? row.get("phone").toString() : "");
                table.addCell(row.get("title") != null ? row.get("title").toString() : "");
                table.addCell(row.get("due_date") != null ? row.get("due_date").toString() : "");
            }

            document.add(table);
            document.close();
            return "PDF Generated at Desktop: " + filePath;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error generating PDF";
        }
    }
}
