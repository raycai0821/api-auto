package common.utils;

import entity.request.ReqHeader;
import entity.request.ReqQuery;
import io.swagger.models.*;
import io.swagger.models.parameters.*;
import io.swagger.models.properties.Property;
import io.swagger.parser.SwaggerParser;

import javax.jws.WebParam;
import java.util.*;

/**
 * @author leifeng.cai
 * @description 使用swagger解析器获取path对应的参数
 * @time: 2021/6/8 15:32
 **/
public class SwaggerJsonParser {

    /**
     * 解析path
     *
     * @param swaggerDocString
     * @return
     */
    public static Map<String, String> parsePath(String swaggerDocString) {
        Swagger swagger = new SwaggerParser().parse(swaggerDocString);
        Map<String, Model> defMap = swagger.getDefinitions();
        Map<String, Path> pathsmap = swagger.getPaths();
        List<ReqHeader> headerList = new ArrayList<>();
        List<ReqQuery> queryList = new ArrayList<>();

        for (Map.Entry<String, Path> entry : pathsmap.entrySet()) {
            String url = entry.getKey();
            Path path = entry.getValue();
            Map<HttpMethod, Operation> operationMap = path.getOperationMap();
            for (Map.Entry<HttpMethod, Operation> entry1 : operationMap.entrySet()) {
                HttpMethod httpMethod = entry1.getKey();
                Operation operation = entry1.getValue();
                List<Parameter> params = operation.getParameters();
                for (Parameter p : params) {
                    if (p instanceof QueryParameter) {
                        QueryParameter qp = (QueryParameter) p;
                        ReqQuery reqQuery = new ReqQuery();
                        reqQuery.setName(qp.getName());
                        reqQuery.setFormat(qp.getFormat());
                        reqQuery.setRequired(qp.getRequired());
                        reqQuery.setType(qp.getType());
                        queryList.add(reqQuery);
                    } else if (p instanceof HeaderParameter) {
                        HeaderParameter hp = (HeaderParameter) p;
                        ReqHeader reqHeader = new ReqHeader();
                        reqHeader.setHeaderName(hp.getName());
                        reqHeader.setRequired(hp.getRequired());
                        reqHeader.setTyPe(hp.getType());
                        reqHeader.setUrl(url);
                        reqHeader.setHttpMethod(httpMethod.toString());
                        headerList.add(reqHeader);
                    } else if (p instanceof PathParameter) {
                        PathParameter pp = (PathParameter) p;
                    } else if (p instanceof BodyParameter) {
                        BodyParameter bp = (BodyParameter) p;
                        Model def = defMap.get("BeneficiaryInsertRequest");
                        Map<String, Property> pt = def.getProperties();
                        Property pt1 = pt.get("11");

                        System.out.println("1");
                    }
                }
            }
        }
        return null;
    }

}
