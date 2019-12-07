package com.whistle.needhi.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class FileToBase64StringConversion {

    private String inputFilePath = "/resource/leaf.png";
    private String outputFilePath = "copy.jpg";

    public static void main(String[] args) throws IOException {
        FileToBase64StringConversion fileToBase64StringConversion = new FileToBase64StringConversion();
        String encodeToString = fileToBase64StringConversion.encodeToString();
        System.out.println(encodeToString);
        fileToBase64StringConversion.decodeToImage(encodeToString);

    }

    public String encodeToString() throws IOException {
        File file = new ClassPathResource("leaf.png").getFile();
        byte[] fileContent = FileUtils.readFileToByteArray(file);
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }

    public void decodeToImage(String encodedString) throws IOException {

        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        FileUtils.writeByteArrayToFile(new File(outputFilePath), decodedBytes);
    }
}