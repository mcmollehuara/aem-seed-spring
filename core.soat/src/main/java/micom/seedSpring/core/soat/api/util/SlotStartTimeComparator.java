package micom.seedSpring.core.soat.api.util;

import micom.seedSpring.core.soat.api.domain.Slot;
import micom.seedSpring.core.soat.api.domain.SortDirection;

/**
 * Slot comparator by the starting slot time field.
 * 
 
 */
public class SlotStartTimeComparator extends AbstractSlotComparator {

  /**
   * Constructor.
   * 
   * @param sortDirection {@link SortDirection}.
   */
  public SlotStartTimeComparator(SortDirection sortDirection) {
    super(sortDirection);
  }

  /**
   * Compare by the speakers field.
   * 
   * @param first {@link Slot}.
   * @param second {@link Slot}.
   * @return comparison result.
   */
  @Override
  public int compare(Slot first, Slot second) {
    switch (getSortDirection()) {
      case ASC:
        return first.getStartTime().compareTo(second.getStartTime());
      case DESC:
        return second.getStartTime().compareTo(first.getStartTime());
      default:
        throw new IllegalStateException("Unknown sorting direction");
    }
  }

}
