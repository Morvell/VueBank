package morvell.vuebank.report;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
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

  private Font headFont;

  private GeneratePdfReport() {
    BaseFont bf = null;
    try {
      bf = BaseFont.createFont("C:/Windows/Fonts/Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    } catch (DocumentException e) {
      log.error("dfdf");
    } catch (IOException e) {
      log.error("Dfdf");
    }

    headFont = new Font(bf);
  }

  public void generateReport(Long id) {

    log.info("Start to render {}", id);

    PayYouBank pay = repo.findById(id).get();

    Document document = new Document();
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    try {

      PdfWriter.getInstance(document, out);
      document.open();

      document.add(new Paragraph("ID:           " + pay.getId(), headFont));
      document.add(new Paragraph("От кого:      " + pay.getPaymentFrom(), headFont));
      document.add(new Paragraph("Бик:          " + pay.getBic(), headFont));
      document.add(new Paragraph("Номер счета:  " + pay.getPaymentNumber(), headFont));
      document.add(new Paragraph("За что:       " + pay.getPaymentFor(), headFont));
      document.add(new Paragraph("Сколько:      " + pay.getPaymentSum(), headFont));
      document.close();

    } catch (DocumentException ex) {

      log.error(ex.toString());
    }

    pay.setReport(out.toByteArray());
    repo.save(pay);

    log.info("end render {}", id);
  }
}
