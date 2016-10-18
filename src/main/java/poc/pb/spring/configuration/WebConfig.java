package poc.pb.spring.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport{
	
	@Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }
	

	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
		converters.add(protobufHttpMessageConverter());
		super.addDefaultHttpMessageConverters(converters);
		
	}

}
