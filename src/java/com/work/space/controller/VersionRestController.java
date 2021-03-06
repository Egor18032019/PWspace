package com.work.space.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@RestController
@Tag(name = "Version controller")
@RequestMapping("/version")
 public class VersionRestController {

    @GetMapping
    public String getVersion() throws NoSuchFileException {
        System.out.println("getVersion");
        StringBuilder stringBuilder = new StringBuilder();
        try (Stream<String> textStream = Files.lines(Paths.get("pom.xml"))) {
            textStream.forEach(stringBuilder::append);
        } catch (IOException e) {
            throw new NoSuchFileException("File pom.xml not found");
        }
        final Pattern pattern = Pattern.compile("<version>(.+?)</version>",
                Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(stringBuilder.toString());
        matcher.find();
        matcher.find();
        return matcher.group(1);
    }
}