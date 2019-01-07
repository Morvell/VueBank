package morvell.vuebank.report;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import morvell.vuebank.domain.PayYouBank;
import morvell.vuebank.repo.PayYouBankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GeneratePdfReport {

  @Autowired
  PayYouBankRepo repo;

  public void generateReport(Long id) {

    log.info("Start to render {}", id);

    PayYouBank pay = repo.findById(id).get();

    Document document = new Document();
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    try {

      PdfPTable table = new PdfPTable(3);
      table.setWidthPercentage(60);
      table.setWidths(new int[]{1, 3, 3});

      BaseFont bf = BaseFont.createFont("C:/Windows/Fonts/Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

      Font headFont = new Font(bf);

      PdfPCell hcell;
      hcell = new PdfPCell(new Phrase("Id", headFont));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);

      hcell = new PdfPCell(new Phrase("Name", headFont));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);

      hcell = new PdfPCell(new Phrase("Population", headFont));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);

      PdfPCell cell;

      cell = new PdfPCell(new Phrase(pay.getId().toString()));
      cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(cell);

      cell = new PdfPCell(new Phrase(pay.getPaymentFrom()));
      cell.setPaddingLeft(5);
      cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cell.setHorizontalAlignment(Element.ALIGN_LEFT);
      table.addCell(cell);

      cell = new PdfPCell(new Phrase(String.valueOf(pay.getPaymentFor()), headFont));
      cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
      cell.setPaddingRight(5);
      table.addCell(cell);

      PdfWriter.getInstance(document, out);
      document.open();
      document.add(table);

      document.close();

    } catch (DocumentException ex) {

      log.error(ex.toString());
    } catch (IOException e) {
      log.error("Всё плохо со шрифтами");
    }

    pay.setReport(out.toByteArray());
    repo.save(pay);

    log.info("end render {}", id);
  }
}
