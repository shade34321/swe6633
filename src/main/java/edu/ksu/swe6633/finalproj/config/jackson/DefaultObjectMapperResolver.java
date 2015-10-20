package edu.ksu.swe6633.finalproj.config.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class DefaultObjectMapperResolver implements ContextResolver<ObjectMapper>{
    private final ObjectMapper objectMapper;

    public DefaultObjectMapperResolver() {
        objectMapper = new ObjectMapper();

        objectMapper.registerModule(new GuavaModule());

    }

    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        return objectMapper;
    }
}
