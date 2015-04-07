package br.com.justoeu.domain;

public class APIDocConfig {

	private String version;
	private String basePath;
	private String resourcePackage;
	private String titleUi;
	private boolean prettyPrint;
	private boolean apiScan;
	
	public String getVersion() { return version; }
	public String getBasePath() { return basePath; }
	public String getResourcePackage() { return resourcePackage; }
	public String getTitleUi() { return titleUi; }
	public boolean isPrettyPrint() { return prettyPrint; }
	public boolean isApiScan() { return apiScan; }
	
	public void setVersion(String version) { this.version = version; }
	public void setBasePath(String basePath) { this.basePath = basePath; }
	public void setResourcePackage(String resourcePackage) { this.resourcePackage = resourcePackage; }
	public void setTitleUi(String titleUi) { this.titleUi = titleUi; }
	public void setPrettyPrint(boolean prettyPrint) { this.prettyPrint = prettyPrint; }
	public void setApiScan(boolean apiScan) { this.apiScan = apiScan; }
	
}