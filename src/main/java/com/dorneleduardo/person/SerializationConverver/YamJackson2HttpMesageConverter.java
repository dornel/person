package com.dorneleduardo.person.SerializationConverver;


import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class YamJackson2HttpMesageConverter extends AbstractJackson2HttpMessageConverter {

       public YamJackson2HttpMesageConverter() {
        super(new YAMLMapper()
                .setSerializationInclusion(
                        JsonInclude.Include.NON_NULL),
                MediaType.parseMediaType("application/x-yaml"));

       }
}