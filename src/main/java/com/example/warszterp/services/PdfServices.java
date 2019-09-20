package com.example.warszterp.services;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class PdfServices {


    public static ByteArrayInputStream generatePdf(AcceptanceDataDto dto) throws DocumentException, IOException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();


        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(60);
        table.setWidths(new int[]{1, 2});
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);





        PdfPCell cell;
        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("Number", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getAcceptanceNumber()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Repair Id", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getRepairId().toString()));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Date Of Admission", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(String.valueOf(dto.getDateOfAdmission())));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Data Of Pickup", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getDataOfPickup().toString()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Estimated Repair Cost", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getEstimatedRepairCost().toString()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Scope Of Work", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getScopeOfWork()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("User Information", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase("User Information"));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("First name", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getFirstName()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Surname", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getSurname()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Company", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getCompany()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Phone number", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getPhoneNumber()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("E-mail", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getEmail()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Car", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase("Car"));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Mark", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getMake()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Model", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getModel()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Year", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getYear()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Fuel", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getFuel().toString()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Car type", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getType().toString()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Plate number", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getPlateNumber()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Vin number", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getVinNo()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("User address", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase("User address"));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Street", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getStreet()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("House number", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getHouseNumber()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("City", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getCity()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        hcell = new PdfPCell(new Phrase("Post Code", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        cell = new PdfPCell(new Phrase(dto.getPostCode()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);


        Font topFont = FontFactory.getFont(FontFactory.COURIER,25F);
        Paragraph top = new Paragraph();
        top.setFont(topFont);


        Chunk topChunk = new Chunk("CAR ACCEPTANCE FORM");
        top.setAlignment(Element.ALIGN_CENTER);
        top.add(topChunk);



        PdfWriter.getInstance(document, out);
        document.open();
        Image logo = Image.getInstance("/home/daniel/IdeaProjects/warsztERP/src/main/resources/static/img/0.5x/Obszar roboczy 1@0.5x.png");
        logo.scaleAbsolute(180f, 100f);
        document.add(logo);
        document.add(top);
        document.add(table);

        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
