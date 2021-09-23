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
import com.brightcoding.app.ws.shared.dto.HobbiesDto;
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
		@PutMapping("")
		public OfferEntity updateHobbies(  @RequestBody OfferEntity HobbiesDto) {
			return offerRepo.save( HobbiesDto);
		}
		
		//update one Offer
		@PutMapping("/edit")
		 public void update (@RequestParam("file") MultipartFile file,
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
	
	
	
	
	
	