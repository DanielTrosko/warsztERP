package com.example.warszterp.controller;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.services.AcceptanceService;
import com.example.warszterp.services.PdfServices;
import com.example.warszterp.services.UserService;
import com.itextpdf.text.*;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;

@Controller
@RequestMapping("/employee/pdf")
public class PdfController {
    private AcceptanceService acceptanceService;
    private PdfServices pdfServices;
    private UserService userService;

    public PdfController(AcceptanceService acceptanceService, PdfServices pdfServices, UserService userService) {
        this.acceptanceService = acceptanceService;
        this.pdfServices = pdfServices;
        this.userService = userService;
    }

    @GetMapping(value = "/generated/", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> generatePdf(@RequestParam Long id, Model model) throws IOException, DocumentException {
        AcceptanceDataDto dto = acceptanceService.getById(id);
        ByteArrayInputStream bis = PdfServices.generatePdf(dto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "inline; filename=pdf.pdf");

        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));

    }
}
