package teksystems.casestudy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {

    private String uploadDir;
    public String getUploadDir(){
        return uploadDir;
    }
    public void setUploadDir(String uploadDir){
        this.uploadDir = uploadDir;
    }
}
