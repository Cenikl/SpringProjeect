package com.spring.projectspring.controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.File;
import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

@RestController
public class ProjectSpringHello {

    @GetMapping("/hello/{name}")
    public String HelloWorld (@PathVariable(required = false) String name) {
        return "Hello " + name;
    }

    @PostMapping(value = "/image",
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public byte[] image (@RequestBody(required = true) byte[] photo) {

       try {
           ByteArrayInputStream inStreambj = new ByteArrayInputStream(photo);
           BufferedImage image = ImageIO.read(inStreambj);
           BufferedImage result = new BufferedImage(
                   image.getWidth(),
                   image.getHeight(),
                   BufferedImage.TYPE_BYTE_BINARY);

           Graphics2D graphic = result.createGraphics();
           graphic.drawImage(image,0,0,Color.WHITE,null);
           graphic.dispose();

           //ImageIO.write(result,"png", new File("C://Users/Acer/Desktop/test.png"));
           ByteArrayOutputStream baos = new ByteArrayOutputStream();
           //
           ImageIO.write(result,"png",baos);
           byte[] bytes = baos.toByteArray();

           return bytes;

       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}

