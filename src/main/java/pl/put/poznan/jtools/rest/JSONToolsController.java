package pl.put.poznan.jtools.rest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.jtools.logic.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.databind.JsonNode;


@RestController
@RequestMapping("/{decorator}")
public class JSONToolsController {

    private static final Logger logger = LoggerFactory.getLogger(JSONToolsController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String decorator) {

        if (Objects.equals(decorator, "minify") || Objects.equals(decorator, "beautify") || Objects.equals(decorator, "whitelist") || Objects.equals(decorator, "blacklist")) {
            logger.debug(decorator);
            return "This is an endpoint for the " + decorator + " decorator, use the POST request.";
        }
        return "This endpoint doesn't exist";
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String decorator,
                       @RequestBody String jsonData) {

        // log the parameters
        logger.debug(decorator);
        logger.debug(jsonData);
        try {
            JsonNode jsonNode = JsonParser.parse(jsonData);
            String jsonText = jsonNode.get("jsonText").toString();
            logger.debug(jsonNode.get("jsonText").toString());

            if (Objects.equals(decorator, "minify")) {
                JsonObjectInterface json = new JsonMinifier(new JsonObject(jsonText));
                return json.decorate();
            } else if (Objects.equals(decorator, "beautify")) {
                JsonObjectInterface json = new JsonBeautifier(new JsonObject(jsonText));
                return json.decorate();
            } else if (Objects.equals(decorator, "whitelist")) {
                List<String> whitelist = new ArrayList<>();
                JsonNode whitelistNode = jsonNode.get("whitelist");
                if (!(whitelistNode instanceof ArrayNode)) {
                    throw new BadRequestException();
                }
                for(JsonNode item:  whitelistNode){
                    if (!(item instanceof TextNode)){
                        throw new BadRequestException();
                    }
                    whitelist.add(item.textValue());
                }
                logger.debug(whitelist.toString());
                JsonObjectInterface json = new JsonWhitelist(new JsonObject(jsonText), whitelist);
                return json.decorate();
            } else if (Objects.equals(decorator, "blacklist")) {
                List<String> blacklist = new ArrayList<>();
                JsonNode blacklistNode = jsonNode.get("blacklist");
                if (!(blacklistNode instanceof ArrayNode)) {
                    throw new BadRequestException();
                }
                for(JsonNode item:  blacklistNode){
                    if (!(item instanceof TextNode)){
                        throw new BadRequestException();
                    }
                    blacklist.add(item.textValue());
                }
                logger.debug(blacklist.toString());
                JsonObjectInterface json = new JsonBlacklist(new JsonObject(jsonText), blacklist);
                return json.decorate();

            } else {
                throw new NotFoundException();
            }
        } catch (NullPointerException err) {
            throw new BadRequestException();
        }
    }
}


