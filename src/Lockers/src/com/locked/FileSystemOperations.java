package com.locked;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileSystemOperations {
	
	
	/**
	 * This Method will give list of all the files and directory from the given path
	 * NOTE:-It will not display sub directories  
	 * @param dirPath
	 * @return ArrayList
	 */
	public static ArrayList<String> getFilesFromDir(String dirPath)
	{
		//Variable initialization 
		List<String> fileCollection=new ArrayList<String>();
	    
		try 
		{
			//Variable initialization 
			File file = new File(dirPath);
			
		    // returns an array of all files
		    String[] fileList = file.list();
		    
		    //pushing file name in array list
		    for(String str : fileList)   fileCollection.add(str);
		      
		    //sorting array list 
		    Collections.sort(fileCollection);
		   
		}
		
		catch(Exception e)
		{
			System.out.println("ERROR CAUGHT ::: " + e.getMessage());
			
		}
		
		
		
		return (ArrayList<String>) fileCollection;
	}
	
	
	/**
	 * This Method will insert file into the given directory 
	 * NOTE:-It will not display sub directories  
	 * @param dirPath,fileContent,fileName
	 * @return void
	 */
	public static void insertFile(String dirPath, ArrayList<String> fileContent, String fileName)
	{
		try
		{	
			//Create a new file 
			String filePath=dirPath+"/"+fileName;
			File file = new File(filePath);
			
			//Insert Data into file 
			FileOutputStream fos = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		 
			for (var content:fileContent) 
			{
				bw.write(content);
				bw.newLine();
			}
			bw.close();	
		}
		catch(Exception e)
		{
			
			System.out.println("ERROR CAUGHT ::: " + e.getMessage());	
		}
		return ;
	}
	
	
	/**
	 * This Method will delete given file  
	 * @param dirName,fileName
	 * @return boolean
	 */
	public static boolean deleteFile(String dirPath,String fileName)
	{
		//Check if file exist
		if(!searchFile(dirPath,fileName)) return false;
		
		boolean isFileDeleted=false;
		
		try
		{	
			// Access given file
			String filePath=dirPath+"/"+fileName;
			File file = new File(filePath);
			
			//Delete file
			if(file.delete())
	        {
	            isFileDeleted=true;
	        }
		}
		catch(Exception e)
		{
			
			System.out.println("ERROR CAUGHT ::: " + e.getMessage());	
		}
		return isFileDeleted;
	}
	
	
	/**
	 * This Method will give list of all the files and directory from the given path
	 * NOTE:-It will not display sub directories  
	 * @param dirName,fileName
	 * @return boolean
	 */
	public static boolean searchFile(String dirPath,String fileName)
	{ 
			boolean isFileFound=false;
				try 
				{
					//Variable initialization 
					File file = new File(dirPath);
					
				    // returns an array of all files
				    String[] fileList = file.list();
				    
				    //pushing file name in array list
				    for(String str : fileList) 
				    {
				    	if(str.equals(fileName))
				    	{	
				    		isFileFound=true;
				    		break;
				    	}
				    }
				}
				
				catch(Exception e)
				{
					System.out.println("ERROR CAUGHT ::: " + e.getMessage());
					
				}
				
				return isFileFound;
		
	}
	
	

}
