package net.buttology.avt.main;

public class VideoToolOptions {

	private String filePrefix;
	private EProgressionType fileProgression;
	private String fileExtension;
	private int frameCount; 
	private boolean exportMaterial; 
	private boolean exportEntity;
	private boolean exportScript;
	private boolean scriptMini;
	private boolean videoFiles;
	
	public VideoToolOptions(
			String filePrefix, 
			EProgressionType fileProgression, 
			String fileExtension,
			int frameCount, 
			boolean exportMaterial, 
			boolean exportEntity, 
			boolean exportScript,
			boolean scriptMini,
			boolean videoFiles) {
		this.filePrefix = filePrefix;
		this.fileProgression = fileProgression;
		this.fileExtension = fileExtension;
		this.frameCount = frameCount;
		this.exportMaterial = exportMaterial;
		this.exportEntity = exportEntity;
		this.exportScript = exportScript;
		this.scriptMini = scriptMini;
		this.videoFiles = videoFiles;
		
	}

	public String getFilePrefix() {
		return filePrefix;
	}

	public EProgressionType getFileProgression() {
		return fileProgression;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public int getFrameCount() {
		return frameCount;
	}

	public boolean isExportMaterial() {
		return exportMaterial;
	}

	public boolean isExportEntity() {
		return exportEntity;
	}

	public boolean isExportScript() {
		return exportScript;
	}

	public boolean isScriptMini() {
		return scriptMini;
	}

	public boolean isVideoFiles() {
		return videoFiles;
	}

	@Override
	public String toString() {
		return "VideoToolOptions [filePrefix=" + filePrefix
				+ ", fileProgression=" + fileProgression + ", fileExtension="
				+ fileExtension + ", frameCount=" + frameCount
				+ ", exportMaterial=" + exportMaterial + ", exportEntity="
				+ exportEntity + ", exportScript=" + exportScript
				+ ", scriptMini=" + scriptMini + ", videoFiles=" + videoFiles
				+ "]";
	}
	
}
