package com.hopital.controller;

import com.hopital.model.Facture;
import com.hopital.rapportpdf.GenererListMode;
import com.itextpdf.io.IOException;
import com.itextpdf.text.DocumentException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("api")
public class FactureController {
    @RequestMapping(value = "/facture", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> report(@Valid @RequestBody Facture facture) throws IOException, DocumentException {

        ByteArrayInputStream bis = GenererListMode.ticketReport(facture);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename = Facture.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
