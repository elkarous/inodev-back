package com.brightcoding.app.ws.controllers;






import com.brightcoding.app.ws.entities.CondidatOffreEntity;
import com.brightcoding.app.ws.entities.OfferEntity;



import com.brightcoding.app.ws.repositories.OfferRepository;
import com.brightcoding.app.ws.services.OfferService;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.brightcoding.app.ws.shared.Utils;
import com.brightcoding.app.ws.shared.dto.OfferDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import java.util.*;

import javax.servlet.ServletContext;

@RestController
@RequestMapping("/offer")
public class OfferController {
	@Autowired
	OfferService offerService;
	@Autowired

	OfferRepository offerRepo;
	 @Autowired
	    Utils util;
	 @Autowired
	    ServletContext context;

	//http://localhost:8081/offer
	
	//get all Offer 
		@GetMapping
		public List<OfferDto> getAll(){
			return offerService.getAllOffre();
		}
		//http://localhost:8081/offer
		// create new offer
		@PostMapping("/add")
		public OfferDto createOffre(  @RequestBody OfferDto offerDto) {
			return offerService.createOffre(offerDto);
			
		}
		//http://localhost:8081/offer/{offerId}
		//get Offer by id 
		@GetMapping("/{id}")
		public OfferDto getOffreById( @PathVariable ("id") int id) {
			return offerService.getOffre(id);
		}
		//http://localhost:8081/offer/{id}
		//delete Offer by id 
		@DeleteMapping("/{id}")
		public void deleteOffre(@PathVariable("id")int id) {
			 offerService.deleteOffre(id);
		}
		//http://localhost:8081/offer/{id}
		//update one Offer
		@PutMapping("/edit/{id}")
		public OfferDto updateOffre( @PathVariable ("id") int Id, @RequestBody OfferDto OfferDto) {
			return offerService.updateOffre(Id, OfferDto);
		}
		

	// find offer by specialite 
		//http://localhost:8081/offer/{specialite}
		@GetMapping("/getbyspe/{specialite}")
		public List<OfferEntity> findOffrebySpe( @PathVariable("specialite") String nom) {
			return offerService.findOffrebySpe(nom);
		}

		//get image de l'offer 
		
		 @GetMapping(path="/Imgarticles/{id}")
		    public byte[] getPhoto(@PathVariable("id") int id) throws Exception{
     OfferEntity offer= offerRepo.findById(id).get();
		        return Files.readAllBytes(Paths.get("C:/Users/ASUS/Documents/GitHub/inodev-back/src/web/spe/"+offer.getImage()));

		    }
		 
		 @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
		    @PostMapping
		    public void createOffre (@RequestParam("file") MultipartFile file,
		                                                   @RequestParam("offre") String offre) throws JsonParseException, JsonMappingException, Exception
		    {
		       
		        OfferEntity off = new ObjectMapper().readValue(offre, OfferEntity.class);
		        boolean isExit = new File(context.getRealPath("src/web/spe/")).exists();
		        if (!isExit)
		        {
		            new File (context.getRealPath("src/web/spe/")).mkdir();
		           
		        }
		        String filename = file.getOriginalFilename();
		        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
		        File serverFile = new File (context.getRealPath("src/web/spe/"+File.separator+newFileName));
		        String distfile = "src/web/spe/"+ file.getOriginalFilename();
		        try
		        {
		       
		            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
		            Files.copy(file.getInputStream(),
		                    Paths.get(distfile),
		                    StandardCopyOption.REPLACE_EXISTING);
		           

		        }catch(Exception e) {
		            e.printStackTrace();
		        }
		        BeanUtils.copyProperties(offre, off);
		        off.setOfferId(util.generateStringId(30));
		        off.setImage(newFileName);
				
		        offerRepo.save(off);
		        
		      
		    

		    }

			@GetMapping("/getCondidates/{acronym}")
			public List<CondidatOffreEntity> getCondidatesByacromym( @PathVariable ("acronym") String acronym) {
		


				return offerRepo.findByAcronym(acronym).get().getCandidtes();
			}

	
	
		//http://localhost:8081/offer/findBy/{niveau}
				//get Offer by niveau
				@GetMapping("/findBy/{niveau}")
				public List<OfferEntity> getOffreByNiveau( @PathVariable ("niveau") String niveau) {
					return offerService.getOffreByNiveau(niveau);
				}
				// get offer by supervisor 
				@GetMapping("/findBysupervisor/{supervisor}")
				public List<OfferEntity> getOffreBySupervisor( @PathVariable ("supervisor") String supervisor) {
					return offerService.getOffreBySupervisor(supervisor);
				}
				
				// get offer by duree
				//http://localhost:8081/offer/findByDurre/{duree}
				@GetMapping("/findByDurre/{duree}")
				public List<OfferEntity> getOffreByDuree( @PathVariable ("duree") String duree) {
					return offerService.getOffreByDuree(duree);
				}
	// search offer
	// 	http://localhost:8081/offer/search/{specialite}/{niveau}/{duree}
				@GetMapping("/search/{specialite}/{duree}/{niveau}")
				public List getBysearch(@PathVariable("specialite") String nom ,@PathVariable ("duree")String duree, @PathVariable("niveau") String niveau) 
				{
				   List offer = new ArrayList<>();
		        if ((nom.contentEquals("null"))&& (niveau.contentEquals("null"))&& (duree.contentEquals("null"))) {
		 
		        	offerService.getAllOffre().forEach(offer::add);
		        }
		        else if (niveau.contentEquals("null") && duree.contentEquals("null"))
		        {
		             offer = offerService.findOffrebySpe(nom);
					
		        }
		        else if (nom.contentEquals("null")&& duree.contentEquals("null"))
		        {
		        	
		             offer = offerService.getOffreByNiveau(niveau);
			        	System.out.println(niveau);
		        }
		        else if (nom.contentEquals("null")&& niveau.contentEquals("null"))
		        {
		             offer = offerService.getOffreByDuree(duree);
		        }
		        else if (nom.contentEquals("null"))
		        {
		    	
		    		for(OfferEntity offerD : offerService.getOffreByDuree(duree)){
			        	System.out.println(offerService.getOffreByDuree(duree));
			        	System.out.println(offerD.getNiveau());
		    			if(offerD.getNiveau().equals(niveau)) {
		    				offer.add(offerD);
				        

		    			}
		    		}
		    		



		        }
		        else if (duree.contentEquals("null"))
		        {
		        	for(OfferEntity offerD : offerService.findOffrebySpe(nom)){
			        	System.out.println(offerService.findOffrebySpe(nom));
			        	System.out.println(offerD.getNiveau());
		    			if(offerD.getNiveau().equals(niveau)) {
		    				offer.add(offerD);
				        

		    			}
		    		}
		        }
		        else if (niveau.contentEquals("null"))
		        {
		        	for(OfferEntity offerD : offerService.findOffrebySpe(nom)){
			        	System.out.println(offerService.findOffrebySpe(nom));
			        	System.out.println(offerD.getDuree());
		    			if(offerD.getDuree().equals(duree)) {
		    				offer.add(offerD);
				        

		    			}
		    		}
		        }
		        else {


		        	for(OfferEntity offerD : offerService.findOffrebySpe(nom)){
			        	System.out.println(offerService.findOffrebySpe(nom));
			        	System.out.println(offerD.getDuree());
		    			if(offerD.getDuree().equals(duree) && offerD.getNiveau().equals(niveau)) {
		    				offer.add(offerD);
				        

		    			}
		    		}
		        }
		        return offer;
				}
}
	
	
	
	
	
	/*
        @Autowired
        OffreRepository repository;
        @Autowired
        SubDeciplineService subDcplineService;
        @Autowired
        CondidatRepository condidatRepository;
    @Autowired
    SpecialiteRepository Srepository;
    @Autowired
    SendMailService mail;
        @Autowired
        ServletContext context;
    @Autowired
    Utils util;
   
/*    @GetMapping
    public List getAllOffres() {

        List  offres = new ArrayList<>();
        repository.findAllcurrent().forEach(offres::add);

        return offres;
    }
    @GetMapping("/getaAll/{type}")
    public List getAllOffresAdmin(@PathVariable String type) {

        List  offres = new ArrayList<>();
        repository.findaAll(type).forEach(offres::add);

        return offres;
    }
    @GetMapping ("/getAll")
    public ResponseEntity<List<String>> getAll()
    {
        List<String> listof = new ArrayList<String>();
        String filesPath = context.getRealPath("src/web/images/");
        File filefolder = new File(filesPath);
        if (filefolder != null)
        {
            for (File file :filefolder.listFiles())
            {
                if(!file.isDirectory())
                {
                    String encodeBase64 = null;
                    try {
                        String extension = FilenameUtils.getExtension(file.getName());
                        FileInputStream fileInputStream = new FileInputStream(file);
                        byte[] bytes = new byte[(int)file.length()];
                        fileInputStream.read(bytes);
                        encodeBase64 = Base64.getEncoder().encodeToString(bytes);
                        listof.add("data:image/"+extension+";base64,"+encodeBase64);
                        fileInputStream.close();


                    }catch (Exception e){

                    }
                }
            }
        }
        return new ResponseEntity<List<String>>(listof, HttpStatus.OK);
    }
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @PostMapping
    public Long createOffre (@RequestParam("file") MultipartFile file,
                                                   @RequestParam("offre") String offre) throws JsonParseException, JsonMappingException, Exception
    {
        System.out.println("Ok .............");
        OffreEntity off = new ObjectMapper().readValue(offre, OffreEntity.class);
        boolean isExit = new File(context.getRealPath("src/web/Images/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("src/web/Images/")).mkdir();
            System.out.println("mk dir.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("src/web/Images/"+File.separator+newFileName));
        String distfile = "src/web/Images/"+ file.getOriginalFilename();
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
            Files.copy(file.getInputStream(),
                    Paths.get(distfile),
                    StandardCopyOption.REPLACE_EXISTING);
            System.out.println("............ok .............");

        }catch(Exception e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(offre, off);
        off.setOffreId(util.generateStringId(30));
        off.setImage(newFileName);

        for(int i=0; i < off.getSkills().size(); i++) {

            SkillsEntity address = off.getSkills().get(i);
           // address.setOffre(off);
            address.setSkillsId(util.generateStringId(30));
            off.getSkills().set(i, address);
        }
        for(int i=0; i < off.getSkills().size(); i++) {

            SkillsEntity spec = off.getSkills().get(i);
            spec.setOffre(off);
           
            off.getSkills().set(i, spec);
        }
     /*   List<CondidatEntity> c = condidatRepository.findAllaCondidats();
        for (int i = 0; i < c.size(); i++) {
            mail.sendSimpleMessage(c.get(i).getEmail(), "Nous avons publie un offre consulte notre platform sur http://localhost:4200/offre/cat/" + off.getType(), "Nouveau offre");
        }
        OffreEntity of = repository.save(off);
            return (of.getSupervisor());


    }

    @GetMapping("/{id}/{type}")
    public List getOffreById(@PathVariable Integer id,@PathVariable String type)
             {
        List offre = repository.findByid(id, type);
        return offre;
    }
    @GetMapping("/spe")
    public List getOffId()
    {
        List offre = repository.findAllByNom();
        return offre;
    }
    @GetMapping("/id/{id}/{type}")
    public List getByid(@PathVariable Integer id,@PathVariable String type)
    {
        List offre = repository.findByid(id, type);
        return offre;
    }
    @GetMapping("/cat/{id}/{type}")
    public List getBysid(@PathVariable String id,@PathVariable String type)
    {
        List offre = repository.findBycategorie(id, type);
        return offre;
    }
    @GetMapping("/{spe}/{due}/{niveau}/{type}")
    public List getBysearch(@PathVariable String spe ,@PathVariable String due, @PathVariable String niveau, @PathVariable String type)
    {
        List offre = new ArrayList<>();
        if ((spe.contentEquals("null")) && (due.contentEquals("null")) && (niveau.contentEquals("null"))) {
            System.out.println("dfssssssssssssfddfdfdfdfffdfffdfdfdfdfdfdffdfddffddfdfdffdfdfdfdfdfdfdfdfd");
            repository.findAll(type).forEach(offre::add);
        }
        else if (niveau.contentEquals("null") && due.contentEquals("null")) {
             offre = repository.findBycat(spe, type);
        }
        else if (niveau.contentEquals("null") && spe.contentEquals("null")) {
             offre = repository.findBynsnull(due, type);
        }
        else if (spe.contentEquals("null") && due.contentEquals("null")) {
             offre = repository.findBysdnull(niveau, type);
        }
        else if (spe.contentEquals("null")) {
        offre = repository.findByspenull(due, niveau, type);
    }
        else if (due.contentEquals("null")) {
            offre = repository.findBydurnull(spe, niveau, type);
        }
        else if (niveau.contentEquals("null")) {
            offre = repository.findBynivnull(spe, due, type);
        }
        else {

            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + spe + due +niveau);
             offre = repository.findBysearch(spe, due, niveau, type);
        }
        return offre;
    }
    @GetMapping(path="/Imgarticles/{id}")
    public byte[] getPhoto(@PathVariable("id") String id) throws Exception{
        OffreEntity offre = repository.findByOffreId(id);
        System.out.println(offre.getImage());
        System.out.println(context.getRealPath("/fdfd"));
        boolean isExit = new File("C:/Users/ASUS/Desktop/Platform Stage_Code Source/inodev-back-main/src/web/Images/"+offre.getImage()).exists();
        System.out.println(isExit);
        return Files.readAllBytes(Paths.get("C:/Users/ASUS/Desktop/Platform Stage_Code Source/inodev-back-main/src/web/Images/"+offre.getImage()));
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") String Id)
            {
        OffreEntity off = repository.findByOffreId(Id);
        repository.delete(off);
        return ("ok");
    }
    @PutMapping("edit/{id}")
    public String update(@PathVariable("id") String id, @RequestBody String off) throws JsonProcessingException {
        System.out.println("Update Article with ID = " + id + "...");
        OffreEntity offre = new ObjectMapper().readValue(off, OffreEntity.class);
        OffreEntity article = repository.findByOffreId(id);
        article.setNom(offre.getNom());
        article.setDateDebut(offre.getDateDebut());
        article.setDescription(offre.getDescription());
        article.setOrganisation(offre.getOrganisation());
        article.setDateFin(offre.getDateFin());
        article.setType(offre.getType());
        article.setDuree(offre.getDuree());
        article.setNiveau(offre.getNiveau());
        article.setImage(article.getImage());
        article.setPrix(offre.getPrix());
        article.setProcessus(offre.getProcessus());

        repository.save(article);
        return ("ok");

    }*/

