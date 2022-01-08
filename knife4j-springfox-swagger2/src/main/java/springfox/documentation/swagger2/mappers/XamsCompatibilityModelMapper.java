package springfox.documentation.swagger2.mappers;

import io.swagger.models.Model;
import springfox.documentation.service.ApiListing;

import java.util.List;
import java.util.Map;


/**
 * @author： guanglai.zhou
 * @date： 2021/9/10 20:56
 */
class XamsCompatibilityModelMapper {

    public static Map<String, Model> modelsFromApiListings(Map<String, List<ApiListing>> apiListings) {
        return new XamsModelSpecificationMapper().modelsFromApiListings(apiListings);
    }
}

