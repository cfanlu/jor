package jatools.dom.sort;

import java.util.Comparator;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision: 1.1 $
  */
public interface NodeComparatorFactory {
    /**
     * DOCUMENT ME!
     *
     * @param command DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Comparator create(String command);
}
