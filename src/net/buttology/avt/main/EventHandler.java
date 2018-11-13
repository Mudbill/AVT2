package net.buttology.avt.main;

import java.io.File;

import net.buttology.avt.util.FileHandler;
import net.buttology.avt.util.XMLParser;
import net.buttology.avt.util.XMLParser.Element;

public class EventHandler {

	public static void generate(String path, VideoToolOptions options) {
		System.out.println(options);
		
		// Export mat files
		if(options.isExportMaterial()) {
			XMLParser material = FileHandler.readInternalXmlFile("/resources/template.mat");
			Element matFile = material.getElementByPath("Material/TextureUnits/Diffuse");
			
			System.out.println("Writing material files...");
			for(int i = 0; i < options.getFrameCount(); i++) {
				String formattedNumber;
				
				// Set number of digits based on selection.
				if(options.getFileProgression().getCount() == 0) {
					formattedNumber = ""+i;
				} else {
					formattedNumber = String.format("%0"+options.getFileProgression().getCount()+"d", i);
				}
				
				// Re-set attribute.
				matFile.removeAttribute("File");
				matFile.addAttribute("File", options.getFilePrefix()+formattedNumber+"."+options.getFileExtension());
				
				System.out.println(matFile);
				
				material.write(new File(path+"/"+options.getFilePrefix()+i+".mat"));
			}
			System.out.println("Finished writing "+options.getFrameCount()+" material files.");
		}
		
		// Export ent files
		if(options.isExportEntity()) {
			XMLParser entity = FileHandler.readInternalXmlFile("/resources/template.ent");
			Element entFile = entity.getElementByPath("Entity/ModelData/Entities/Billboard");
			
			System.out.println("Writing entity files...");
			for(int i = 0; i < options.getFrameCount(); i++) {
				
				entFile.removeAttribute("MaterialFile");
				entFile.addAttribute("MaterialFile", options.getFilePrefix()+i+".mat");
				
				System.out.println(entFile);
				
				entity.write(new File(path+"/"+options.getFilePrefix()+i+".ent"));
			}
			System.out.println("Finished writing "+options.getFrameCount()+" entity files.");
		}
		
		// Export script file
		if(options.isExportScript()) {
			String scriptPath = "/resources/";
			File newFile = new File(path+"/script_"+options.getFilePrefix()+".hps");
			if(newFile.isFile()) {
				System.err.println("File is being overwritten.");
			}
			
			if(options.isScriptMini()) {
				scriptPath += "script_minimal.hps";
			} else {
				scriptPath += "script_documented.hps";
			}
			
			try {
				FileHandler.extractInternalFile(scriptPath, newFile);
			} catch (Exception e) {
				System.err.println("Failed to write script file.");
				e.printStackTrace();
			}
		}
		
		// Export video files
		if(options.isVideoFiles()) {
			String[] videoFiles = new String[]{
					"video_placeholder.dae",
					"video_placeholder.dds",
					"video_placeholder.mat",
					"video_placeholder.msh"
			};
			
			for(String s : videoFiles) {
				File target = new File(path+"/"+s);
				try {
					FileHandler.extractInternalFile("/resources/"+s, target);
				} catch (Exception e) {
					System.err.println("Failed to write video placeholder files.");
					e.printStackTrace();
				}
			}
		}
	}
}
