package pl.gruchotki.invoicesIntegrator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;
import pl.gruchotki.invoicesIntegrator.dto.FileUploadResponse;
import pl.gruchotki.invoicesIntegrator.dto.InvoiceDtoRequest;
import pl.gruchotki.invoicesIntegrator.dto.InvoiceDtoResponse;
import pl.gruchotki.invoicesIntegrator.file.FileUploadUtil;
import pl.gruchotki.invoicesIntegrator.service.InvoiceService;

import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static pl.gruchotki.invoicesIntegrator.dto.DTOWithParsedXML.parseInvoicesXML;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping("/{id}")
    public InvoiceDtoResponse get(@PathVariable Long id) {
        return invoiceService.get(id);
    }

    @GetMapping
    public List<InvoiceDtoResponse> getAll() {
        return invoiceService.getAll();
    }

//   @PostMapping
//    public List<InvoiceDtoResponse> add(@Valid @RequestBody InvoiceDtoRequest newPatient) {
//        return invoiceService.saveInvoices(newPatient);
//    }

    @PostMapping
    public InvoiceDtoResponse add(@RequestBody InvoiceDtoRequest newInvoice) {
        return invoiceService.saveInvoice(newInvoice);
    }

    @PostMapping(value = "/uploadFile", consumes = {"multipart/form-data"})
    public ResponseEntity<FileUploadResponse> uploadFile(
            @RequestParam("file") MultipartFile multipartFile)
            throws IOException, ParserConfigurationException, SAXException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();

        String filecode = FileUploadUtil.saveFile(fileName, multipartFile);

        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile/" + filecode);

        File xmlFile = new File("Files-Upload/"+fileName);
        invoiceService.saveInvoices(parseInvoicesXML(xmlFile));

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
