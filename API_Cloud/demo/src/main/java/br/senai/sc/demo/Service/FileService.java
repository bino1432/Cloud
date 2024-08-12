package br.senai.sc.demo.Service;

import br.senai.sc.demo.Service.Interface.FileInterface;
import br.senai.sc.demo.model.File;
import br.senai.sc.demo.model.Task;
import br.senai.sc.demo.repository.FileRepository;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class FileService implements FileInterface {


    @Autowired
    private FileRepository fileRepository;

    @Value("${aws.access.key}")
    private String awsKeyID;

    @Value("${aws.access.secret.key}")
    private String awsKeySecret;

    @Value("${aws.bucket.name}")
    private String bucketName;

    @Override
    public boolean create(Long id, MultipartFile file) {
        try {

            File file1 = new File();

            String refImage = UUID.randomUUID().toString();

            file1.setImgReference(refImage);
            file1.setTask(new Task(id));

            fileRepository.save(file1);

            AWSCredentials awsCredentials = new BasicAWSCredentials(awsKeyID, awsKeySecret);

            AmazonS3 client = AmazonS3ClientBuilder.standard().withCredentials(
                    new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.US_EAST_2).build();

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getSize());
            client.putObject(bucketName, refImage, file.getInputStream(), objectMetadata);

            return true;

        } catch (AmazonS3Exception e){
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<String> buscarImagem(Long id){

        List<String> url = new ArrayList<>();
        AWSCredentials awsCredentials = new BasicAWSCredentials(awsKeyID, awsKeySecret);

        AmazonS3 client = AmazonS3ClientBuilder.standard().withCredentials(
                new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.US_EAST_2).build();

        List<File> files = fileRepository.findAllByTask_Id(id);

        for(File file : files){
            GeneratePresignedUrlRequest presigned =
                    new GeneratePresignedUrlRequest(bucketName, file.getFileReference());
            presigned.setExpiration(new Date(System.currentTimeMillis() + 600000));

            url.add(client.generatePresignedUrl(presigned).toString());
        }
        return url;

    }

}
