package micom.seedSpring.core.soat.api.domain;

/**
 * Domain class that holds the paging info.
 * 
 
 */
public class PagingInfo {

  private final int[] numbres;
  private final int currentPageNumber;
  private final boolean hasNext;
  private final boolean hasPrev;

  /**
   * Constructs the paging info object.
   * 
   * @param numbres an integer array with all values that will be shown on the front-end.
   * @param currentPageNumber the current page shown.
   * @param hasNext answers whether there is a next page.
   * @param hasPrev answers whether there is a previous page.
   */
  public PagingInfo(int[] numbres, int currentPageNumber, boolean hasNext, boolean hasPrev) {
    this.numbres = numbres;
    this.currentPageNumber = currentPageNumber;
    this.hasNext = hasNext;
    this.hasPrev = hasPrev;
  }

  public int[] getNumbres() {
    return numbres;
  }

  /**
   * @return <code>true</code> if there is a next page after the current.
   */
  public boolean hasNext() {
    return hasNext;
  }

  /**
   * @return <code>true</code> if there is previous page after the current.
   */
  public boolean hasPrev() {
    return hasPrev;
  }

  public int getCurrentPageNumber() {
    return currentPageNumber;
  }

}
