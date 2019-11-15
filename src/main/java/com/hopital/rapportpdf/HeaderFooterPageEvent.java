package com.hopital.rapportpdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class HeaderFooterPageEvent extends PdfPageEventHelper {

    private PdfTemplate t;
    private Image total;

    public void onOpenDocument(PdfWriter writer, Document document){
        t = writer.getDirectContent().createTemplate(30, 16);
        try{
            total = Image.getInstance(t);
            total.setRole(PdfName.ARTIFACT);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document){
        addHeader(writer);
        addFooter(writer);
    }

    private void addHeader(PdfWriter writer){
        try{
            //Image.getInstance(GenererListMode.class.getResource("./image/entete.jpeg"));
            Image image = Image.getInstance("C:\\Users\\Judicael\\IdeaProjects\\hopital\\src\\main\\java\\com\\hopital\\image\\entetes.jpg");
            //image = Image.getInstance(img);
            image.setAlignment(Element.ALIGN_TOP);
            image.setAbsolutePosition(0, 763);
            image.scalePercent(55.5f, 21.0f);
            writer.getDirectContent().addImage(image, true);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addFooter(PdfWriter writer){
        PdfPTable footer = new PdfPTable(1);

        try{
            footer.setWidths(new int[]{24});
            footer.setTotalWidth(527);;
            footer.setLockedWidth(true);
            footer.getDefaultCell().setFixedHeight(40);
            footer.getDefaultCell().setBorder(Rectangle.TOP);
            footer.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

            //Texte du footer
            footer.addCell(new Phrase("Centre Médico Social Ophtamologique: Agoènyivé - Rue AYASSOR 2ème VON à droite après la CEET d'Agoè", FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLUE)));

            //Ecrire le footer dans le pdf
            PdfContentByte canvas = writer.getDirectContent();
            canvas.beginMarkedContentSequence(PdfName.ARTIFACT);
            footer.writeSelectedRows(0, -1, 34, 50, canvas);
            canvas.endMarkedContentSequence();

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void onCloseDocument(PdfWriter writer, Document document){
        int totalLenght = String.valueOf(writer.getPageNumber()).length();
        int totalWidth = totalLenght * 5;
        ColumnText.showTextAligned(t, Element.ALIGN_RIGHT,
                new Phrase(String.valueOf(writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)),
                totalWidth, 6, 0);
     }

}
