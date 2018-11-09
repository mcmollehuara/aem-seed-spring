package micom.seedSpring.core.soat.components;

import  micom.seedSpring.core.soat.components.TouchMultiBeanS;
 
import java.util.ArrayList;
import java.util.List;
  
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
  
import com.adobe.cq.sightly.WCMUsePojo;
  
public class TouchMultiComponentS extends WCMUsePojo {
  
private static final Logger LOGGER = LoggerFactory.getLogger(TouchMultiComponentS.class);
private List<TouchMultiBeanS> submenuItems = new ArrayList<TouchMultiBeanS>();
  
@Override
public void activate() throws Exception {
setMultiFieldItems();
}
  
/**
* Method to get Multi field data
* @return submenuItems
*/
private List<TouchMultiBeanS> setMultiFieldItems() {
  
@SuppressWarnings("deprecation")
JSONObject jObj;
try{
String[] itemsProps = getProperties().get("carouselItems", String[].class);
 
if (itemsProps == null) {
     
    LOGGER.info("PROPS IS NULL") ; 
}
 
 
if (itemsProps != null) {
for (int i = 0; i < itemsProps.length; i++) {
  
jObj = new JSONObject(itemsProps[i]);
TouchMultiBeanS menuItem = new TouchMultiBeanS();
  
String title = jObj.getString("title");
String description = jObj.getString("description");
String link = jObj.getString("link");
  
menuItem.setTitle(title);
menuItem.setLink(description);
menuItem.setFlag(link);
submenuItems.add(menuItem);
}
}
}catch(Exception e){
LOGGER.error("Exception while Multifield data {}", e.getMessage(), e);
}
return submenuItems;
}
  
public List<TouchMultiBeanS> getMultiFieldItems() {
return submenuItems;
}
}