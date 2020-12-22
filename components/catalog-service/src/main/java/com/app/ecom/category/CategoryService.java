package com.app.ecom.category;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryMongoRepository categoryRepository;



	
	public CategoryVO getBaseCategory(String baseId){

		Category basecategory = new Category("base_","x",0,null);
		basecategory.setChildren(getChild(baseId, "")); // 0 is the base category ... this should come from url
		CategoryVO cvo = new CategoryVO(basecategory);
		return cvo;

	}

	public  List<Category> getChild( String value,String tab){
		
		List<Category> findCategory = categoryRepository.findByParent(value);

		if(findCategory != null){

			for (Category category : findCategory) {
				
				if(category.getSomeadditionalattr()!=null && category.getSomeadditionalattr().isFlag()){
					
				}else{
					category.setChildren(getChild(category.getId(), tab+"\t"));
				}

			}
		}
		return findCategory;
	}
	
	
	private  String getBreadCrumb(String path,String value){
		path = value+path;
		
		Category findCategory = categoryRepository.findById(value).orElse(null);
		if(!"0".equals(findCategory.getParent())){
			value = findCategory.getParent();
			path = getBreadCrumb(">"+path, value);
		}
		
		return path;
	}
	
	public  String getBreadCrumb(String path,String value,String name){
			
	
			//path = value+path;
			 path = "<a href=\"/protected/view/"+value+"\"  >"+name+"</a>"+path;;
			Category findCategory = categoryRepository.findById(value).orElse(null);
			if(findCategory!=null){ //!"0".equals(findCategory.getParent())
				value = findCategory.getParent();
				path = getBreadCrumb(">"+path, findCategory.getParent() , findCategory.getName());
			}
			
			return path;
		
			
		}
	
	public   String getBreadCrumb(String path,String value,String name,String baseid){
		

		//path = value+path;
		 path = "<div class=\"_1HEvv0\"><a class=\"_1KHd47\"  href=\"/protected/products/"+value+"?a="+baseid+"\"  >"+name+"</a></div>"+path;
		 

		 //Query searchUserQuery = new Query(Criteria.where("id").is(value));
		 Category findCategory = categoryRepository.findById(value).orElse(null);
		if(findCategory!=null){ //!"0".equals(findCategory.getParent())
			value = findCategory.getParent();
			path = getBreadCrumb("<svg width=\"16\" height=\"27\" viewBox=\"0 0 16 27\" xmlns=\"http://www.w3.org/2000/svg\" class=\"_2XP0B_\"><path d=\"M16 23.207L6.11 13.161 16 3.093 12.955 0 0 13.161l12.955 13.161z\" fill=\"#fff\" class=\"_24NaUy\"></path></svg>"+path, findCategory.getParent() , findCategory.getName(),baseid);
		}
		
		return path;

		
	}

	
	public  String getBreadCrumbold(String path,String value,String name){
		

		//path = value+path;
		 path = "<a href=\"/protected/view/"+value+"\"  >"+name+"</a>"+path;;
		Category findCategory = categoryRepository.findById(value).orElse(null);
		if(findCategory!=null){ //!"0".equals(findCategory.getParent())
			value = findCategory.getParent();
			path = getBreadCrumb(">"+path, findCategory.getParent() , findCategory.getName());
		}
		
		return path;
	
		
	}
	public  List<Category> search( String wildcard){
				
		List<Category> findCategory = categoryRepository.findByBreadcrumbRegex(wildcard);

		if(findCategory != null){

			for (Category category : findCategory) {
				System.out.println("search result    > "+category.getId());	
			}

		}
		return findCategory;
	}
	
	
	public  Category save(Category category){
		
		return categoryRepository.save(category);

	}

	public Category findOne(String id) {
		
		return categoryRepository.findById(id).orElse(null);
	}

	public void delete(Category entity) {
		
		categoryRepository.delete(entity);
		
	}
	
	public List<Category> findByParent(String parent) {

		return categoryRepository.findByParent(parent);

	}
	/**
     * Resizes an image to a absolute width and height (the image may not be
     * proportional)
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param scaledWidth absolute width in pixels
     * @param scaledHeight absolute height in pixels
     * @throws IOException
     */
    public static void resize(String inputImagePath,
            String outputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
 
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());

        //Graphics2D g2d = thumbImage.createGraphics();
        //g2d.drawImage(masterImage.getScaledInstance(THUMB_SIDE, THUMB_SIDE, Image.SCALE_SMOOTH), 0, 0, THUMB_SIDE, THUMB_SIDE, null);
        
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH), 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
 
        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);
 
        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }
 
    /**
     * Resizes an image by a percentage of original size (proportional).
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param percent a double number specifies percentage of the output image
     * over the input image.
     * @throws IOException
     */
    public static void resize(String inputImagePath,
            String outputImagePath, double percent) throws IOException {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
    }
 
    /**
     * Test resizing images
     */
    public static void main(String[] args) {
        String inputImagePath = "/home/atul/Software/projects/IncentiveProject/springBootMigration_1.0/springBootMigration/src/main/webapp/resources/img/United-States-Capitol.jpg";
        String outputImagePath1 = "/home/atul/Software/projects/IncentiveProject/springBootMigration_1.0/springBootMigration/src/main/webapp/resources/img/LUnited-States-Capitol.jpeg";
        String outputImagePath2 = "/home/atul/Software/projects/IncentiveProject/springBootMigration_1.0/springBootMigration/src/main/webapp/resources/img/SUnited-States-Capitol.jpeg";
        
     
        try {
            // resize to a fixed width (not proportional)
            int scaledWidth = 900/2;
            int scaledHeight = 900/2;
            resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);
            
             scaledWidth = 900/5;
             scaledHeight = 900/5;
            resize(inputImagePath, outputImagePath2, scaledWidth, scaledHeight);
 
            /*// resize smaller by 50%
            double percent = 0.5;
            resize(inputImagePath, outputImagePath2, percent);
 
            // resize bigger by 50%
            percent = 1.5;
            resize(inputImagePath, outputImagePath3, percent);*/
 
        } catch (IOException ex) {
            System.out.println("Error resizing the image.");
            ex.printStackTrace();
        }
    }

}
