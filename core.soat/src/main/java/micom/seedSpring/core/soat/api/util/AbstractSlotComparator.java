package micom.seedSpring.core.soat.api.util;

import java.util.Comparator;

import micom.seedSpring.core.soat.api.domain.Slot;
import micom.seedSpring.core.soat.api.domain.SortDirection;

/**
 * Abstract slot comparator.
 * 
 
 */
public abstract class AbstractSlotComparator implements Comparator<Slot> {

  private SortDirection sortDirection;

  /**
   * Constructor.
   * 
   * @param sortDirection {@link SortDirection}.
   */
  public AbstractSlotComparator(SortDirection sortDirection) {
    this.sortDirection = sortDirection;
  }

  public SortDirection getSortDirection() {
    return sortDirection;
  }

  /**
   * Compare two {@link Slot}s.
   * 
   * @param first {@link Slot}.
   * @param second {@link Slot}.
   * @return comparison result.
   */
  public abstract int compare(Slot first, Slot second);

}
