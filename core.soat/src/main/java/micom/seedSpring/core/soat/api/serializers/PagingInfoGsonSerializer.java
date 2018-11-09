package micom.seedSpring.core.soat.api.serializers;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import micom.seedSpring.core.soat.api.domain.PagingInfo;

/**
 * {@link JsonSerializer} for a {@link PagingInfo}.
 * 
 
 */
public class PagingInfoGsonSerializer implements JsonSerializer<PagingInfo> {

  @Override
  public JsonElement serialize(PagingInfo pagingInfo, Type typeOfSrc, JsonSerializationContext context) {

    JsonObject pagingInfoJson = new JsonObject();
    pagingInfoJson.addProperty("currentPage", pagingInfo.getCurrentPageNumber());
    pagingInfoJson.addProperty("hasNext", pagingInfo.hasNext());
    pagingInfoJson.addProperty("hasPrev", pagingInfo.hasPrev());

    JsonArray pageNumbers = new JsonArray();
    for (int pageNumber : pagingInfo.getNumbres()) {
      pageNumbers.add(new JsonPrimitive(pageNumber));
    }
    
    pagingInfoJson.add("pageNumbers", pageNumbers);

    return pagingInfoJson;
  }

}
