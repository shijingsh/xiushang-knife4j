package springfox.documentation.swagger2.mappers;

import io.swagger.models.properties.Property;
import springfox.documentation.schema.PropertySpecification;
import springfox.documentation.service.ModelNamesRegistry;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author： guanglai.zhou
 * @date： 2021/9/10 16:32
 */
public class XamsModelSpecificationMapper extends ModelSpecificationMapperImpl {

    @Override
    protected Map<String, Property> mapProperties(Map<String, PropertySpecification> properties, ModelNamesRegistry modelNamesRegistry) {
        Map<String, Property> treeMap = super.mapProperties(properties, modelNamesRegistry);
        List<String> keyList = properties.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(
                        Comparator.comparing(PropertySpecification::getPosition)
                                .thenComparing(PropertySpecification::getName)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        for (String key : keyList) {
            Property property = treeMap.get(key);
            PropertySpecification propertySpecification = properties.get(key);
            property.setPosition(propertySpecification.getPosition());
        }
        return treeMap;
    }
}
