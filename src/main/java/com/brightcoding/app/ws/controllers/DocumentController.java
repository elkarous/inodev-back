package com.brightcoding.app.ws.controllers;

import com.brightcoding.app.ws.entities.CondidatEntity;
import com.brightcoding.app.ws.entities.DocumentEntity;
import com.brightcoding.app.ws.entities.OfferEntity;
import com.brightcoding.app.ws.repositories.DocumentRepository;
import com.brightcoding.app.ws.requests.DocumentRequest;
import com.brightcoding.app.ws.responses.DocumentResponse;
import com.brightcoding.app.ws.responses.UserResponse;
import com.brightcoding.app.ws.services.DocumentService;
import com.brightcoding.app.ws.shared.dto.CondidatDto;
import com.brightcoding.app.ws.shared.dto.DocumentDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    ServletContext context;
    @Autowired
    DocumentService educationService;
    @Autowired
    DocumentRepository repository;
  //http://localhost:8081/document
    @GetMapping
    public ResponseEntity<List<DocumentResponse>> getDocument(Principal principal) {

        List<DocumentDto> education = educationService.getAllDocument(principal.getName());

        Type listType = new TypeToken<List<DocumentResponse>>() {}.getType();
        List<DocumentResponse> educationResponse = new ModelMapper().map(education, listType);

        return new ResponseEntity<List<DocumentResponse>>(educationResponse, HttpStatus.OK);

    }
  //http://localhost:8081/document/get/{principal}

    @GetMapping("/get/{principal}")
    public ResponseEntity<List<DocumentResponse>> getDocumentuser(@PathVariable String principal) {

        List<DocumentDto> education = educationService.getAllDocument(principal);

        Type listType = new TypeToken<List<DocumentResponse>>() {}.getType();
        List<DocumentResponse> educationResponse = new ModelMapper().map(education, listType);

        return new ResponseEntity<List<DocumentResponse>>(educationResponse, HttpStatus.OK);


    }
  //http://localhost:8081/document

    @PostMapping(
        
    )
    public DocumentDto StoreEducation(@RequestPart("file") MultipartFile file, @RequestPart(value = "body") String principale) throws JsonMappingException, JsonProcessingException {
    	DocumentDto educationDto = new ObjectMapper().readValue(principale, DocumentDto.class);

    	boolean isExit = new File(context.getRealPath("src/web/doc/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("src/web/doc/")).mkdir();
            
        }
        if (file.getName() != null) {
            String filename = file.getOriginalFilename();
            String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
            File serverFile = new File (context.getRealPath("src/web/doc/"+File.separator+newFileName));
            String distfile = "src/web/doc/"+ file.getOriginalFilename();
            try
            {
               
                FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
                Files.copy(file.getInputStream(),
                        Paths.get(distfile),
                        StandardCopyOption.REPLACE_EXISTING);

            }catch(Exception e) {
                e.printStackTrace();
            }
        }
      

        educationDto.setNom(file.getOriginalFilename());
      
        DocumentDto createEducation = educationService.createDocument(educationDto);
        createEducation.setNom(file.getOriginalFilename());

        

        return createEducation;
    }
  //http://localhost:8081/document/{id}


    @GetMapping("/{id}")
    public  DocumentDto getOneDocument(@PathVariable(name="id") String educationId) {

    	return educationService.getDocument(educationId);

    }
  //http://localhost:8081/document/doc/{id}

    @GetMapping(path="/doc/{id}")
    public byte[] getPhoto(@PathVariable String id) throws Exception{
        DocumentDto doc = educationService.getDocument(id);
        return Files.readAllBytes(Paths.get("C:/Users/ASUS/Documents/GitHub/inodev-back/src/web/doc/"+doc.getNom()));

    }
  //http://localhost:8081/document/download/{id}

    @GetMapping(path="/download/{id}")
    public void download(@PathVariable String id, HttpServletResponse response) throws Exception {
       String folderPath = "C:/Users/ASUS/Documents/GitHub/inodev-back/src/web/doc/";
        Path path = Paths.get("C:/Users/ASUS/Documents/GitHub/inodev-back/src/web/doc/" + id);
        if (id.indexOf(".doc") > -1) response.setContentType("application/msword");
        if (id.indexOf(".docx") > -1) response.setContentType("application/msword");
        if (id.indexOf(".xls") > -1) response.setContentType("application/vnd.ms-excel");
        if (id.indexOf(".csv") > -1) response.setContentType("application/vnd.ms-excel");
        if (id.indexOf(".ppt") > -1) response.setContentType("application/ppt");
        if (id.indexOf(".pdf") > -1) response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" +id);
        response.setHeader("Content-Transfer-Encoding", "binary");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            FileInputStream fis = new FileInputStream(folderPath+id);
            int len;
            byte[] buf = new byte[1024];
            while((len = fis.read(buf)) > 0) {
                bos.write(buf,0,len);
            }
            bos.close();
            response.flushBuffer();
        }
        catch(IOException e) {
            e.printStackTrace();

        }
    }

  //http://localhost:8081/document/{id}
    
    
    @DeleteMapping("/{idCondidat}/{id}")
	@ResponseBody 
	public void deleteDocument(@PathVariable("idCondidat") Long idCondidat,@PathVariable("id") int id ){
    	educationService.deleteDocument(id,idCondidat);
	}


  /*  @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDocument(@PathVariable(name="id") String educationId) {

        educationService.deleteDocument(educationId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/
  //http://localhost:8081/document/{id}

    @PutMapping(
            path="/{id}",
            consumes={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<DocumentResponse> updateDocument(@PathVariable String id , @RequestPart("file") MultipartFile file, Principal principale) {



        boolean isExit = new File(context.getRealPath("src/web/doc/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("src/web/doc/")).mkdir();
            System.out.println("mk dir.............");
        }
        if (file.getName() != null) {
            String filename = file.getOriginalFilename();
            String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
            File serverFile = new File (context.getRealPath("src/web/doc/"+File.separator+newFileName));
            String distfile = "src/web/doc/"+ file.getOriginalFilename();
            try
            {
                System.out.println("Image");
                FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
                Files.copy(file.getInputStream(),
                        Paths.get(distfile),
                        StandardCopyOption.REPLACE_EXISTING);

            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        ModelMapper modelMapper = new ModelMapper();

        DocumentDto educationDto = modelMapper.map(file, DocumentDto.class);
        educationDto.setNom(file.getOriginalFilename());

        DocumentDto createEducation = educationService.updateDocument(id, educationDto);
        createEducation.setNom(file.getOriginalFilename());
        DocumentResponse userResponse = new DocumentResponse();
        BeanUtils.copyProperties(createEducation, userResponse);

        return new ResponseEntity<DocumentResponse>(userResponse, HttpStatus.ACCEPTED);
    }
}
