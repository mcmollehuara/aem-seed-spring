package micom.seedSpring.core.soat.api.domain;

import java.util.Comparator;

import micom.seedSpring.core.soat.api.util.SlotSpeakersComparator;
import micom.seedSpring.core.soat.api.util.SlotStartTimeComparator;
import micom.seedSpring.core.soat.api.util.SlotTopicComparator;

/**
 * Sort possibilities.
 * 
 
 */
public enum Sort {
  /**
   * Sort by presentation start time.
   */
  START_TIME,

  /**
   * Sort by presentation topic.
   */
  TOPIC,

  /**
   * Sort by presentation speakers.
   */
  SPEAKERS;

  /**
   * Get proper comparator for this sort for a given direction.
   * 
   * @param direction {@link SortDirection}.
   * @return {@link Comparator} for {@link Slot} for the given
   *         {@link SortDirection}.
   */
  public Comparator<Slot> getComparator(SortDirection direction) {
    switch (this) {
      case START_TIME:
        return new SlotStartTimeComparator(direction);
      case TOPIC:
        return new SlotTopicComparator(direction);
      case SPEAKERS:
        return new SlotSpeakersComparator(direction);
      default:
        throw new IllegalStateException("No comparator for " + this);
    }
  }
}
