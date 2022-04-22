package teksystems.casestudy.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import teksystems.casestudy.config.FileStorageProperties;

import javax.annotation.processing.FilerException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
public class FileStorageService {
    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath();

        try {
            Files.createDirectories(this.fileStorageLocation); // create directory

        }catch(Exception ex) {
            log.info(String.valueOf(ex));
        }
    }

    public Resource loadFileAsResource(String filename){
        try {
            Path filepath =this.fileStorageLocation.resolve(filename).normalize(); // subdir could be posts/{user_id} or users/{user_id}
            Resource resource = new UrlResource(filepath.toUri()); // get uri for image host
            if(resource != null){
                return resource;
            } else {
                throw new Exception("File not found " + filename);
            }
        } catch(Exception e){
            log.info(String.valueOf(e));
            return null;
        }
    }
}
