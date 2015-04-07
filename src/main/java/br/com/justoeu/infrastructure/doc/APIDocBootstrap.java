package br.com.justoeu.infrastructure.doc;
import java.io.InputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.yaml.snakeyaml.Yaml;

import br.com.justoeu.domain.APIDocConfig;
import br.com.justoeu.resource.ATMResource;

import com.wordnik.swagger.jaxrs.config.BeanConfig;

public class APIDocBootstrap extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        Yaml yaml = new Yaml();
        APIDocConfig apiConfig = null;
        try{
        	
        	InputStream targetStream = this.getClass().getResourceAsStream("/swagger.yml");
        	apiConfig = yaml.loadAs(targetStream, APIDocConfig.class);
        	
        	BeanConfig beanConfig = new BeanConfig();
        	beanConfig.setVersion(apiConfig.getVersion());
        	beanConfig.setBasePath(apiConfig.getBasePath());
        	beanConfig.setResourcePackage(ATMResource.class.getPackage().getName().toString() + "," + apiConfig.getResourcePackage());
        	
        	beanConfig.setTitle(apiConfig.getTitleUi());
        	beanConfig.setPrettyPrint(apiConfig.isPrettyPrint());
        	beanConfig.setScan(apiConfig.isApiScan());
        	
        } catch (Exception e){
        	e.printStackTrace();
        }
    }
}