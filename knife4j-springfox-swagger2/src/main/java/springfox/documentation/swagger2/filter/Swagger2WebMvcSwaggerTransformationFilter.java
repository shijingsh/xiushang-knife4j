package springfox.documentation.swagger2.filter;

import io.swagger.models.Model;
import io.swagger.models.Swagger;
import io.swagger.models.properties.Property;
import org.springframework.stereotype.Component;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.web.SwaggerTransformationContext;
import springfox.documentation.swagger2.web.WebMvcSwaggerTransformationFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author： guanglai.zhou
 * @date： 2021/9/10 13:45
 */
public class Swagger2WebMvcSwaggerTransformationFilter implements WebMvcSwaggerTransformationFilter {

    @Override
    public boolean supports(DocumentationType delimiter) {
        return DocumentationType.SWAGGER_2.equals(delimiter);
    }

    @Override
    public Swagger transform(SwaggerTransformationContext<HttpServletRequest> context) {
        Swagger swagger = context.getSpecification();
        Map<String, Model> definitions = swagger.getDefinitions();
        for (String key : definitions.keySet()) {
            Model model = definitions.get(key);
            if(model!=null){
                Map<String, Property> properties = model.getProperties();

                if(properties==null){
                    properties = new HashMap<>();
                }
                Map<String, Property> sortedProperties = new LinkedHashMap<>(properties.size());
                List<String> fieldNameList = properties.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(
                                Comparator.comparing(Property::getPosition)
                                        .thenComparing(Property::getName)))
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
                for (String fieldName : fieldNameList) {
                    sortedProperties.put(fieldName, properties.get(fieldName));
                }
                if(model.getProperties()!=null){
                    model.getProperties().clear();
                }

                model.setProperties(sortedProperties);
            }
        }
        return swagger;
    }
}
