package edu.ksu.swe6633.finalproj.config.jackson;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

public class Jackson2Feature implements Feature {

    @Override
    public boolean configure(FeatureContext featureContext) {
        featureContext.register(JacksonJaxbJsonProvider.class, MessageBodyReader.class, MessageBodyWriter.class);
        return true;
    }
}
