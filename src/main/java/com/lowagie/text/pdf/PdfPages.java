//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.lowagie.text.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.pdf.PdfArray;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfIndirectReference;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

public class PdfPages {
    private ArrayList pages = new ArrayList();
    private ArrayList parents = new ArrayList();
    private int leafSize = 10;
    private PdfWriter writer;
    private PdfIndirectReference topParent;
    private static Logger log = LoggerFactory.getLogger(PdfWriter.class);

    PdfPages(PdfWriter writer) {
        this.writer = writer;
    }

    void addPage(PdfDictionary page) {
        try {
            if (this.pages.size() % this.leafSize == 0) {
                this.parents.add(this.writer.getPdfIndirectReference());
            }

            PdfIndirectReference e = (PdfIndirectReference) this.parents.get(this.parents.size() - 1);
            page.put(PdfName.PARENT, e);
            PdfIndirectReference current = this.writer.getCurrentPage();
            this.writer.addToBody(page, current);
            this.pages.add(current);
            log.info("PdfPages: current is null? ");
            log.info(current == null ? "True" : "False");
            log.info("PdfPages: add pages success");
            log.info("PadPages: current pages size is:" + pages.size());
        } catch (Exception var4) {
            log.error("PdfPages: add pages error");
            throw new ExceptionConverter(var4);
        }
    }

    PdfIndirectReference writePageTree() throws IOException {
        if (this.pages.size() == 0) {
            throw new IOException("The document has no pages.");
        } else {
            int leaf = 1;
            ArrayList tParents = this.parents;
            ArrayList tPages = this.pages;
            ArrayList nextParents = new ArrayList();

            while (true) {
                leaf *= this.leafSize;
                int stdCount = this.leafSize;
                int rightCount = tPages.size() % this.leafSize;
                if (rightCount == 0) {
                    rightCount = this.leafSize;
                }

                for (int p = 0; p < tParents.size(); ++p) {
                    int thisLeaf = leaf;
                    int count;
                    if (p == tParents.size() - 1) {
                        count = rightCount;
                        thisLeaf = this.pages.size() % leaf;
                        if (thisLeaf == 0) {
                            thisLeaf = leaf;
                        }
                    } else {
                        count = stdCount;
                    }

                    PdfDictionary top = new PdfDictionary(PdfName.PAGES);
                    top.put(PdfName.COUNT, new PdfNumber(thisLeaf));
                    PdfArray kids = new PdfArray();
                    ArrayList internal = kids.getArrayList();
                    internal.addAll(tPages.subList(p * stdCount, p * stdCount + count));
                    top.put(PdfName.KIDS, kids);
                    if (tParents.size() > 1) {
                        if (p % this.leafSize == 0) {
                            nextParents.add(this.writer.getPdfIndirectReference());
                        }

                        top.put(PdfName.PARENT, (PdfIndirectReference) nextParents.get(p / this.leafSize));
                    }

                    this.writer.addToBody(top, (PdfIndirectReference) tParents.get(p));
                }

                if (tParents.size() == 1) {
                    this.topParent = (PdfIndirectReference) tParents.get(0);
                    return this.topParent;
                }

                tPages = tParents;
                tParents = nextParents;
                nextParents = new ArrayList();
            }
        }
    }

    PdfIndirectReference getTopParent() {
        return this.topParent;
    }

    void setLinearMode(PdfIndirectReference topParent) {
        if (this.parents.size() > 1) {
            throw new RuntimeException("Linear page mode can only be called with a single parent.");
        } else {
            if (topParent != null) {
                this.topParent = topParent;
                this.parents.clear();
                this.parents.add(topParent);
            }

            this.leafSize = 10000000;
        }
    }

    void addPage(PdfIndirectReference page) {
        this.pages.add(page);
    }

    int reorderPages(int[] order) throws DocumentException {
        if (order == null) {
            return this.pages.size();
        } else if (this.parents.size() > 1) {
            throw new DocumentException("Page reordering requires a single parent in the page tree. Call PdfWriter.setLinearMode() after open.");
        } else if (order.length != this.pages.size()) {
            throw new DocumentException("Page reordering requires an array with the same size as the number of pages.");
        } else {
            int max = this.pages.size();
            boolean[] temp = new boolean[max];

            int k;
            for (int copy = 0; copy < max; ++copy) {
                k = order[copy];
                if (k < 1 || k > max) {
                    throw new DocumentException("Page reordering requires pages between 1 and " + max + ". Found " + k + ".");
                }

                if (temp[k - 1]) {
                    throw new DocumentException("Page reordering requires no page repetition. Page " + k + " is repeated.");
                }

                temp[k - 1] = true;
            }

            Object[] var6 = this.pages.toArray();

            for (k = 0; k < max; ++k) {
                this.pages.set(k, var6[order[k] - 1]);
            }

            return max;
        }
    }
}
