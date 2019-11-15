package com.hopital.rapportpdf;

import com.hopital.model.Facture;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenererListMode {
    public static ByteArrayInputStream ticketReport(Facture facture) throws DocumentException {

        String num_facture = String.valueOf(facture.getNumero());
        Date datejou = facture.getDatejour() ;
        ArrayList an = (ArrayList) facture.getAnalyses();
        String nom = facture.getNom().toUpperCase();
        String prenom = facture.getPrenom();

        Document document = new Document(PageSize.A4, 36, 36, 90, 36);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, out);

        //Ajout du Header et du footer
        HeaderFooterPageEvent event = new HeaderFooterPageEvent();
        writer.setPageEvent(event);

        try {

            /*Les déclarations*/
            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            String newligne = System.getProperty("line.separator");

            /*Déclaration des types de format de date et heure*/
            Date aujourdhui = new Date();
            DateFormat date = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, new Locale("FR","fr"));
            SimpleDateFormat datej = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat heure = new SimpleDateFormat("HH:ss");
            String datejour = datej.format(aujourdhui);
            String heurejour = heure.format(aujourdhui);

            Paragraph paragraph = new Paragraph("Lomé, le " + datejour);
            paragraph.setAlignment(Paragraph.ALIGN_RIGHT);
            paragraph.setSpacingAfter(50);

            Paragraph paragraph1 = new Paragraph("FACTURE" , FontFactory.getFont(FontFactory.HELVETICA, 13, Font.UNDERLINE));
            paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
            paragraph1.setSpacingAfter(10);

            Paragraph paragraph2 = new Paragraph("N° " + num_facture);
            paragraph2.setAlignment(Paragraph.ALIGN_CENTER);
            paragraph2.setSpacingAfter(10);

            Paragraph paragraph3 = new Paragraph("M./Mme/Enft : " + nom + " " + prenom);
            paragraph3.setAlignment(Paragraph.ALIGN_CENTER);
            paragraph3.setSpacingAfter(20);


            PdfPTable table = new PdfPTable(4); // 3 columns.
            table.setWidthPercentage(100);
            PdfPCell cell1 = new PdfPCell(new Phrase("QUANTITE" , FontFactory.getFont(FontFactory.HELVETICA, 13, Font.BOLD)));
            PdfPCell cell2 = new PdfPCell(new Paragraph("PU" , FontFactory.getFont(FontFactory.HELVETICA, 13, Font.BOLD)));
            PdfPCell cell3 = new PdfPCell(new Paragraph("DESIGNATION" , FontFactory.getFont(FontFactory.HELVETICA, 13, Font.BOLD)));
            PdfPCell cell4 = new PdfPCell(new Paragraph("MONTANT" , FontFactory.getFont(FontFactory.HELVETICA, 13, Font.BOLD)));
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);

            PdfPCell cell5 = null, cell6 = null, cell7 = null, cell8 = null;

            int i;
            for(i = 0; i <= an.size(); i++){

                cell5 = new PdfPCell(new Paragraph("Cell 5\n" +
                        "Cell5 biss"));

                 cell6 = new PdfPCell(new Paragraph("Cell 6"));

                cell7  = new PdfPCell(new Paragraph("Cell 7"));

                cell8  = new PdfPCell(new Paragraph("Cell 8"));

            }

            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);

            PdfPCell cell9 = new PdfPCell(new Phrase("TOTAL", FontFactory.getFont(FontFactory.HELVETICA, 13, Font.BOLD)));
            cell9.setColspan(3);
            table.addCell(cell9);

            PdfPCell cell10 = new PdfPCell(new Phrase(""));
            table.addCell(cell10);

            table.setSpacingAfter(20);

            Paragraph paragraph4 = new Paragraph("Arrêté la présente facture à la somme de : ................... FRANCS CFA.");
            paragraph4.setSpacingAfter(150);

            Paragraph paragraph5 = new Paragraph("LE DIRECTEUR", FontFactory.getFont(FontFactory.HELVETICA, 13, Font.BOLD));
            paragraph5.setAlignment(Paragraph.ALIGN_RIGHT);
            paragraph5.setSpacingAfter(10);

            document.open();
            document.add(paragraph);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph3);
            document.add(table);
            document.add(paragraph4);
            document.add(paragraph5);

            document.close();

        } catch (DocumentException ex) {

            Logger.getLogger(GenererListMode.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
