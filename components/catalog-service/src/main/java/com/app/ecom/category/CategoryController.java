package com.app.ecom.category;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("category")
public class CategoryController extends BaseController{
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/application/add/{id}/{parent}", method = RequestMethod.GET)
	public String addApplication(@PathVariable(name = "id") String id,@PathVariable(name = "parent") String parent) {
		
		Category category = new Category(id ,parent, 1, null);
		categoryService.save(category);
		
		return "success";
	}
	
	@Cacheable(value = "basecategory", key = "#basecategory")
	@RequestMapping(value = "/list/{basecategory}", method = RequestMethod.GET)
	public CategoryVO list(@PathVariable(name = "basecategory") String basecategory) {
		return categoryService.getBaseCategory(basecategory);
	}
	
	//@CacheEvict(value = "basecategory", allEntries = true)
	@Caching(evict = {
		    @CacheEvict(value ="basecategory", allEntries = true),
		    @CacheEvict(value = "product", key = "#category.id")
		})
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Category addCategory( Category category) {
		
		if(categoryService.findOne(category.getId())!=null)
			return null;
		 Category newcategory = categoryService.findOne(category.getParent());
		 newcategory.setBreadcrumb(null);
		 categoryService.save(newcategory); 
		
		return categoryService.save(category);
	}
	
	@Cacheable(value = "product", key = "#id")
	@RequestMapping(value = "product/{id}", method = RequestMethod.GET)
	public Category getCategory(@PathVariable(name = "id") String id) {
	
		 Category category = categoryService.findOne(id);
		 System.out.println(category.getBreadcrumb());
		return category;
	}
	
	
	@CacheEvict(value = "basecategory", allEntries = true)
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public Category editCategory(@RequestBody Category category) {
	
		 Category newcategory = categoryService.findOne(category.getId());
		
		 
		 if(newcategory==null)
				return null;
		 else
			 newcategory.setChildren(categoryService.findByParent(category.getId()));
		 
		 newcategory.setName(category.getName());
		 newcategory.setDescription(category.getDescription());
		 
		 if(newcategory.getChildren()==null || newcategory.getChildren().size()==0){
			 newcategory.setBreadcrumb(categoryService.getBreadCrumb("", newcategory.getId(),newcategory.getName(),getApplication()));
			 if(category.getSomeadditionalattr()!=null)
				 newcategory.setSomeadditionalattr(category.getSomeadditionalattr());
		 }else
			 newcategory.setBreadcrumb(null);
		 
		//new addition for specification
		newcategory.setProductSpecification(category.getProductSpecification());
		
		return categoryService.save(newcategory);
		
	}
	
	@PostMapping("/upload") // //new annotation since 4.3
    public void singleFileUpload(@RequestParam("uploadfile") MultipartFile file ) {

        if (file.isEmpty()) {
            
        }
        
        String UPLOADED_FOLDER = "/home/atul/atulcd01/img/"+file.getOriginalFilename().substring(0,file.getOriginalFilename().indexOf("."))+"/";
        
        //String UPLOADED_FOLDER = "/home/atul/Software/projects/IncentiveProject/testproject/SpringBootMigration/src/main/webapp/resources/img/";
        //UPLOADED_FOLDER =  "D:\\tool\\twoProject\\SpringBootMigration\\src\\main\\webapp\\resources\\img\\";
        try {



        	// Get the file and save it somewhere
        	byte[] bytes = file.getBytes();
        	
        	File directory = new File(UPLOADED_FOLDER);
            if (! directory.exists()){
                directory.mkdirs();
                
            }
        	Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
        	
        	Files.write(path, bytes);
        	String inputImagePath = path.toFile().getAbsolutePath();
        	String  outputImagePath1 = inputImagePath.replace(file.getOriginalFilename(), "L"+file.getOriginalFilename());
        	String  outputImagePath2 = inputImagePath.replace(file.getOriginalFilename(), "S"+file.getOriginalFilename());
        	String  outputImagePath3 = inputImagePath.replace(file.getOriginalFilename(), "I"+file.getOriginalFilename());

        	// resize to a fixed width (not proportional)
        	int scaledWidth = 900/2;
        	int scaledHeight = 900/2;
        	categoryService.resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);

        	scaledWidth = 900/5;
        	scaledHeight = 900/5;
        	categoryService.resize(inputImagePath, outputImagePath2, scaledWidth, scaledHeight);

        	scaledWidth = 900/9;
        	scaledHeight = 900/9;
        	categoryService.resize(inputImagePath, outputImagePath3, scaledWidth, scaledHeight);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	@CacheEvict(value = "basecategory", allEntries = true)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void deleteCategory(@PathVariable(name = "id") String id) {
		
		System.out.println(id);
		if(categoryService.findOne(id)!=null)
			categoryService.delete(categoryService.findOne(id));
		
	}
	
	@RequestMapping(value = "/search" , method = RequestMethod.GET)
	public Collection<Category> search( @RequestParam String search) {
		return categoryService.search(search);
	}
	

	@RequestMapping(value = "/{catID}" , method = RequestMethod.GET)
	 public String search(@PathVariable(value="catID") String catID, 
	                                  String someAttr) {
		
		 categoryService.search(catID);
		  return "itemsList";
	 }

	
	}
