package micom.seedSpring.core.soat.api.controllers;

import static micom.seedSpring.core.soat.api.domain.Sort.START_TIME;
import static micom.seedSpring.core.soat.api.domain.SortDirection.ASC;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import micom.seedSpring.core.soat.api.domain.ConferenceDay;
import micom.seedSpring.core.soat.api.domain.PagingInfo;
import micom.seedSpring.core.soat.api.domain.Slot;
import micom.seedSpring.core.soat.api.domain.Sort;
import micom.seedSpring.core.soat.api.domain.SortDirection;
import micom.seedSpring.core.soat.api.domain.SortingInfo;
import micom.seedSpring.core.soat.api.serializers.ConferenceDayGsonSerializer;
import micom.seedSpring.core.soat.api.serializers.PagingInfoGsonSerializer;
import micom.seedSpring.core.soat.api.serializers.SlotSerializer;
import micom.seedSpring.core.soat.api.serializers.SortingInfoSerializer;
import micom.seedSpring.core.soat.api.services.ScheduleService;

/**
 * Controller for the schedule table component.
 * 
 
 */
@Controller
public class ScheduleTableController {

  @Resource
  private ScheduleService scheduleService;

  /**
   * Gets the dynamic data needed for a single conference day needed for
   * rendering the schedule table.
   * 
   * @param pageNumber the day of the conference.
   * @return The resulting JSON.
   */
  @RequestMapping(value = "/scheduletable/getresult", produces = {"application/json; charset=UTF-8" }, method = POST)
  @ResponseBody
  public String getTableResult(@RequestParam int pageNumber) {
    ConferenceDay conferenceDay = scheduleService.getConferenceDayFor(pageNumber, new SortingInfo(START_TIME, ASC));
    return serializeData(conferenceDay);
  }

  /**
   * Gets the dynamic data needed for a single conference day, in specific sort
   * type and direction. The data is needed to render the schedule table.
   * 
   * @param sort {@link Sort}.
   * @param sortDirection {@link SortDirection}.
   * @return The resulting JSON
   */
  @RequestMapping(value = "/scheduletable/sortresult", produces = {"application/json; charset=UTF-8" }, method = POST)
  @ResponseBody
  public String sortResults(@RequestParam int pageNumber, @RequestParam Sort sort, @RequestParam SortDirection sortDirection) {
    ConferenceDay conferenceDay = scheduleService.getConferenceDayFor(pageNumber, new SortingInfo(sort, sortDirection));
    return serializeData(conferenceDay);
  }

    /**
   * Gets the dynamic data needed for a single conference day, in specific sort
   * type and direction. The data is needed to render the schedule table.
   * 
   * @param sort {@link Sort}.
   * @param sortDirection {@link SortDirection}.
   * @return The resulting JSON
   */
  @RequestMapping(value = "/scheduletable/pakta", produces = {"application/json; charset=UTF-8" }, method = POST)
  @ResponseBody
  public String getCotizacion(@RequestParam String placa, @RequestParam String numeroDoc, @RequestParam String tipodocumento, @RequestParam String idptipodocumento) {
    String result = scheduleService.getCotizacion(placa, numeroDoc,tipodocumento, idptipodocumento );
    return result;
  }
  
  private String serializeData(ConferenceDay conferenceDay) {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(ConferenceDay.class, new ConferenceDayGsonSerializer());
    gsonBuilder.registerTypeAdapter(Slot.class, new SlotSerializer());
    gsonBuilder.registerTypeAdapter(SortingInfo.class, new SortingInfoSerializer());
    gsonBuilder.registerTypeAdapter(PagingInfo.class, new PagingInfoGsonSerializer());
    Gson gson = gsonBuilder.create();
    return gson.toJson(conferenceDay);
  }
}
