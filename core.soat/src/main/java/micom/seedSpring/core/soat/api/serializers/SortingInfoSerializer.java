package micom.seedSpring.core.soat.api.serializers;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import micom.seedSpring.core.soat.api.domain.SortingInfo;

/**
 * {@link JsonSerializer} for a {@link SortingInfo}.
 * 
 
 */
public class SortingInfoSerializer implements JsonSerializer<SortingInfo> {

  @Override
  public JsonElement serialize(SortingInfo sortingInfo, Type typeOfSrc, JsonSerializationContext context) {

    JsonObject sortingJson = new JsonObject();
    sortingJson.addProperty("criteria", sortingInfo.getSort().toString());
    sortingJson.addProperty("order", sortingInfo.getSortDirection().toString());

    return sortingJson;
  }

}
