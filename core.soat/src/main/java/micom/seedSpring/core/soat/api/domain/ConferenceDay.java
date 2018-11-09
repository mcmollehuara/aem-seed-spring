package micom.seedSpring.core.soat.api.domain;

import java.util.Collections;
import java.util.List;

import org.joda.time.LocalDate;

/**
 * Domain class representing a conference day.
 * 
 
 */
public class ConferenceDay {

  private final LocalDate date;
  private final List<Slot> slots;
  private final SortingInfo sortingInfo;
  private final PagingInfo pagingInfo;

  /**
   * Constructor.
   * 
   * @param date of the conference day.
   * @param slots {@link List} of {@link Slot} for presentation.
   * @param sortingInfo {@link SortingInfo}.
   * @param pagingInfo {@link PagingInfo}.
   */
  public ConferenceDay(LocalDate date, List<Slot> slots, SortingInfo sortingInfo, PagingInfo pagingInfo) {
    this.date = date;
    this.slots = slots;
    this.sortingInfo = sortingInfo;
    this.pagingInfo = pagingInfo;
  }

  public LocalDate getDate() {
    return date;
  }

  public List<Slot> getSlots() {
    return Collections.unmodifiableList(slots);
  }

  public PagingInfo getPagingInfo() {
    return pagingInfo;
  }

  public SortingInfo getSortingInfo() {
    return sortingInfo;
  }

}
