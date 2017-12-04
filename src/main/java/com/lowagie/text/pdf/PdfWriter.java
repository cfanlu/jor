//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.lowagie.text.pdf;

import com.lowagie.text.DocListener;
import com.lowagie.text.DocWriter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Image;
import com.lowagie.text.ImgWMF;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.ColorDetails;
import com.lowagie.text.pdf.ExtendedColor;
import com.lowagie.text.pdf.FontDetails;
import com.lowagie.text.pdf.OutputStreamCounter;
import com.lowagie.text.pdf.PRIndirectReference;
import com.lowagie.text.pdf.PdfAcroForm;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfAnnotation;
import com.lowagie.text.pdf.PdfArray;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfContents;
import com.lowagie.text.pdf.PdfDestination;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfDocument;
import com.lowagie.text.pdf.PdfEncryption;
import com.lowagie.text.pdf.PdfException;
import com.lowagie.text.pdf.PdfFormField;
import com.lowagie.text.pdf.PdfICCBased;
import com.lowagie.text.pdf.PdfImage;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfIndirectObject;
import com.lowagie.text.pdf.PdfIndirectReference;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfObject;
import com.lowagie.text.pdf.PdfOutline;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPage;
import com.lowagie.text.pdf.PdfPageEvent;
import com.lowagie.text.pdf.PdfPageLabels;
import com.lowagie.text.pdf.PdfPages;
import com.lowagie.text.pdf.PdfPatternPainter;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfReaderInstance;
import com.lowagie.text.pdf.PdfShading;
import com.lowagie.text.pdf.PdfShadingPattern;
import com.lowagie.text.pdf.PdfSpotColor;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfTransition;
import com.lowagie.text.pdf.RandomAccessFileOrArray;
import com.lowagie.text.pdf.SpotColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class PdfWriter extends DocWriter {
    public static final int PageLayoutSinglePage = 1;
    public static final int PageLayoutOneColumn = 2;
    public static final int PageLayoutTwoColumnLeft = 4;
    public static final int PageLayoutTwoColumnRight = 8;
    public static final int PageModeUseNone = 16;
    public static final int PageModeUseOutlines = 32;
    public static final int PageModeUseThumbs = 64;
    public static final int PageModeFullScreen = 128;
    public static final int HideToolbar = 256;
    public static final int HideMenubar = 512;
    public static final int HideWindowUI = 1024;
    public static final int FitWindow = 2048;
    public static final int CenterWindow = 4096;
    public static final int NonFullScreenPageModeUseNone = 8192;
    public static final int NonFullScreenPageModeUseOutlines = 16384;
    public static final int NonFullScreenPageModeUseThumbs = 32768;
    public static final int DirectionL2R = 65536;
    public static final int DirectionR2L = 131072;
    static final int ViewerPreferencesMask = 261888;
    public static final int AllowPrinting = 2052;
    public static final int AllowModifyContents = 8;
    public static final int AllowCopy = 16;
    public static final int AllowModifyAnnotations = 32;
    public static final int AllowFillIn = 256;
    public static final int AllowScreenReaders = 512;
    public static final int AllowAssembly = 1024;
    public static final int AllowDegradedPrinting = 4;
    public static final boolean STRENGTH40BITS = false;
    public static final boolean STRENGTH128BITS = true;
    public static final PdfName DOCUMENT_CLOSE;
    public static final PdfName WILL_SAVE;
    public static final PdfName DID_SAVE;
    public static final PdfName WILL_PRINT;
    public static final PdfName DID_PRINT;
    public static final PdfName PAGE_OPEN;
    public static final PdfName PAGE_CLOSE;
    public static final int SIGNATURE_EXISTS = 1;
    public static final int SIGNATURE_APPEND_ONLY = 2;
    public static final char VERSION_1_2 = '2';
    public static final char VERSION_1_3 = '3';
    public static final char VERSION_1_4 = '4';
    public static final char VERSION_1_5 = '5';
    private static final int VPOINT = 7;
    protected byte[] HEADER = DocWriter.getISOBytes("%PDF-1.4\n%âãÏÓ\n");
    protected PdfPages root = new PdfPages(this);
    protected PdfDictionary imageDictionary = new PdfDictionary();
    private HashMap images = new HashMap();
    protected HashMap formXObjects = new HashMap();
    protected int formXObjectsCounter = 1;
    protected int fontNumber = 1;
    protected int colorNumber = 1;
    protected int patternNumber = 1;
    protected PdfContentByte directContent;
    protected PdfContentByte directContentUnder;
    protected HashMap documentFonts = new HashMap();
    protected HashMap documentColors = new HashMap();
    protected HashMap documentPatterns = new HashMap();
    protected HashMap documentShadings = new HashMap();
    protected HashMap documentShadingPatterns = new HashMap();
    protected ColorDetails patternColorspaceRGB;
    protected ColorDetails patternColorspaceGRAY;
    protected ColorDetails patternColorspaceCMYK;
    protected HashMap documentSpotPatterns = new HashMap();
    protected HashMap documentExtGState = new HashMap();
    protected PdfWriter.PdfBody body;
    protected PdfDocument pdf;
    private PdfPageEvent pageEvent;
    protected PdfEncryption crypto;
    protected HashMap importedPages = new HashMap();
    protected PdfReaderInstance currentPdfReaderInstance;
    protected ArrayList pageReferences = new ArrayList();
    protected int currentPageNumber = 1;
    protected PdfDictionary group;
    public static final float SPACE_CHAR_RATIO_DEFAULT = 2.5F;
    public static final float NO_SPACE_CHAR_RATIO = 1.0E7F;
    public static final int RUN_DIRECTION_DEFAULT = 0;
    public static final int RUN_DIRECTION_NO_BIDI = 1;
    public static final int RUN_DIRECTION_LTR = 2;
    public static final int RUN_DIRECTION_RTL = 3;
    protected int runDirection = 1;
    private float spaceCharRatio = 2.5F;
    private PdfDictionary extraCatalog;

    private static Logger log = LoggerFactory.getLogger(PdfWriter.class);

    static {
        DOCUMENT_CLOSE = PdfName.DC;
        WILL_SAVE = PdfName.WS;
        DID_SAVE = PdfName.DS;
        WILL_PRINT = PdfName.WP;
        DID_PRINT = PdfName.DP;
        PAGE_OPEN = PdfName.O;
        PAGE_CLOSE = PdfName.C;
    }

    protected PdfWriter(PdfDocument document, OutputStream os) {
        super(document, os);
        this.pdf = document;
        this.directContent = new PdfContentByte(this);
        this.directContentUnder = new PdfContentByte(this);
    }

    public static PdfWriter getInstance(Document document, OutputStream os) throws DocumentException {
        PdfDocument pdf = new PdfDocument();
        document.addDocListener(pdf);
        PdfWriter writer = new PdfWriter(pdf, os);
        pdf.addWriter(writer);
        return writer;
    }

    public static PdfWriter getInstance(Document document, OutputStream os, DocListener listener) throws DocumentException {
        PdfDocument pdf = new PdfDocument();
        pdf.addDocListener(listener);
        document.addDocListener(pdf);
        PdfWriter writer = new PdfWriter(pdf, os);
        pdf.addWriter(writer);
        return writer;
    }

    PdfIndirectReference add(PdfPage page, PdfContents contents) throws PdfException {
        log.info("Start to add pages:");
        if(!this.open) {
            log.error("Not open:");
            throw new PdfException("The document isn\'t open.");
        } else {
            PdfIndirectObject object;
            try {
                object = this.body.add(contents);
            } catch (IOException var5) {
                log.error("Body add exception");
                throw new ExceptionConverter(var5);
            }

            page.add(object.getIndirectReference());
            if(this.group != null) {
                page.put(PdfName.GROUP, this.group);
                this.group = null;
            }

            log.info("The page to add is :",page);
            this.root.addPage(page);
            ++this.currentPageNumber;
            return null;
        }
    }

    PdfName addDirectImageSimple(Image image) throws PdfException, DocumentException {
        PdfName name;
        if(this.images.containsKey(image.getMySerialId())) {
            name = (PdfName)this.images.get(image.getMySerialId());
        } else {
            if(image.isImgTemplate()) {
                name = new PdfName("img" + this.images.size());
                if(image.templateData() == null) {
                    try {
                        ImgWMF maskImage1 = (ImgWMF)image;
                        maskImage1.readWMF(this.getDirectContent().createTemplate(0.0F, 0.0F));
                    } catch (Exception var11) {
                        throw new DocumentException(var11);
                    }
                }
            } else {
                Image maskImage = image.getImageMask();
                PdfIndirectReference maskRef = null;
                if(maskImage != null) {
                    PdfName i = (PdfName)this.images.get(maskImage.getMySerialId());
                    maskRef = this.getImageReference(i);
                }

                PdfImage i1 = new PdfImage(image, "img" + this.images.size(), maskRef);
                if(image.hasICCProfile()) {
                    PdfICCBased icc = new PdfICCBased(image.getICCProfile());
                    PdfIndirectReference iccRef = this.add(icc);
                    PdfArray iccArray = new PdfArray();
                    iccArray.add(PdfName.ICCBASED);
                    iccArray.add(iccRef);
                    PdfObject colorspace = i1.get(PdfName.COLORSPACE);
                    if(colorspace != null && colorspace.type() == 5) {
                        ArrayList ar = ((PdfArray)colorspace).getArrayList();
                        if(ar.size() > 1 && PdfName.INDEXED.equals(ar.get(0))) {
                            ar.set(1, iccArray);
                        } else {
                            i1.put(PdfName.COLORSPACE, iccArray);
                        }
                    } else {
                        i1.put(PdfName.COLORSPACE, iccArray);
                    }
                }

                this.add(i1);
                name = i1.name();
            }

            this.images.put(image.getMySerialId(), name);
        }

        return name;
    }

    PdfIndirectReference add(PdfImage pdfImage) throws PdfException {
        if(!this.imageDictionary.contains(pdfImage.name())) {
            PdfIndirectObject object;
            try {
                object = this.body.add(pdfImage);
            } catch (IOException var4) {
                throw new ExceptionConverter(var4);
            }

            this.imageDictionary.put(pdfImage.name(), object.getIndirectReference());
            return object.getIndirectReference();
        } else {
            return (PdfIndirectReference)this.imageDictionary.get(pdfImage.name());
        }
    }

    protected PdfIndirectReference add(PdfICCBased icc) throws PdfException {
        PdfIndirectObject object;
        try {
            object = this.body.add(icc);
        } catch (IOException var4) {
            throw new ExceptionConverter(var4);
        }

        return object.getIndirectReference();
    }

    PdfIndirectReference getImageReference(PdfName name) {
        return (PdfIndirectReference)this.imageDictionary.get(name);
    }

    public void open() {
        super.open();

        try {
            this.os.write(this.HEADER);
            this.body = new PdfWriter.PdfBody(this);
        } catch (IOException var2) {
            throw new ExceptionConverter(var2);
        }
    }

    protected PdfDictionary getCatalog(PdfIndirectReference rootObj) {
        return ((PdfDocument)this.document).getCatalog(rootObj);
    }

    protected void addSharedObjectsToBody() throws IOException {
        Iterator it = this.documentFonts.values().iterator();

        while(it.hasNext()) {
            FontDetails gstate = (FontDetails)it.next();
            gstate.writeFont(this);
        }

        it = this.formXObjects.values().iterator();

        while(true) {
            PdfTemplate obj;
            do {
                if(!it.hasNext()) {
                    it = this.importedPages.values().iterator();

                    while(it.hasNext()) {
                        this.currentPdfReaderInstance = (PdfReaderInstance)it.next();
                        this.currentPdfReaderInstance.writeAllPages();
                    }

                    this.currentPdfReaderInstance = null;

                    ColorDetails gstate2;
                    PdfIndirectObject obj1;
                    for(it = this.documentColors.values().iterator(); it.hasNext(); obj1 = this.body.add(gstate2.getSpotColor(this), gstate2.getIndirectReference())) {
                        gstate2 = (ColorDetails)it.next();
                    }

                    PdfPatternPainter gstate3;
                    for(it = this.documentPatterns.keySet().iterator(); it.hasNext(); obj1 = this.body.add(gstate3.getPattern(), gstate3.getIndirectReference())) {
                        gstate3 = (PdfPatternPainter)it.next();
                    }

                    it = this.documentShadingPatterns.keySet().iterator();

                    while(it.hasNext()) {
                        PdfShadingPattern gstate4 = (PdfShadingPattern)it.next();
                        gstate4.addToBody();
                    }

                    it = this.documentShadings.keySet().iterator();

                    while(it.hasNext()) {
                        PdfShading gstate5 = (PdfShading)it.next();
                        gstate5.addToBody();
                    }

                    it = this.documentExtGState.keySet().iterator();

                    while(it.hasNext()) {
                        PdfDictionary gstate6 = (PdfDictionary)it.next();
                        PdfObject[] obj2 = (PdfObject[])this.documentExtGState.get(gstate6);
                        this.addToBody(gstate6, (PdfIndirectReference)obj2[1]);
                    }

                    return;
                }

                Object[] gstate1 = (Object[])it.next();
                obj = (PdfTemplate)gstate1[1];
            } while(obj != null && obj.getIndirectReference() instanceof PRIndirectReference);

            if(obj != null && obj.getType() == 1) {
                PdfIndirectObject var4 = this.body.add(obj.getFormXObject(), obj.getIndirectReference());
            }
        }
    }

    public synchronized void close() {
        log.info("Pdf document start to close:");
        if(this.open) {
            if(this.currentPageNumber - 1 != this.pageReferences.size()) {
                throw new RuntimeException("The page " + this.pageReferences.size() + " was requested but the document has only " + (this.currentPageNumber - 1) + " pages.");
            }

            this.pdf.close();

            try {
                this.addSharedObjectsToBody();
                PdfIndirectReference ioe = this.root.writePageTree();
                PdfDictionary catalog = this.getCatalog(ioe);
                if(this.extraCatalog != null) {
                    catalog.mergeDifferent(this.extraCatalog);
                }

                PdfIndirectObject indirectCatalog = this.body.add(catalog);
                PdfIndirectObject info = this.body.add(((PdfDocument)this.document).getInfo());
                PdfIndirectReference encryption = null;
                PdfObject fileID = null;
                if(this.crypto != null) {
                    PdfIndirectObject trailer = this.body.add(this.crypto.getEncryptionDictionary());
                    encryption = trailer.getIndirectReference();
                    fileID = this.crypto.getFileID();
                } else {
                    fileID = PdfEncryption.createInfoId(PdfEncryption.createDocumentId());
                }

                this.body.writeCrossReferenceTable(this.os);
                PdfWriter.PdfTrailer trailer1 = new PdfWriter.PdfTrailer(this.body.size(), this.body.offset(), indirectCatalog.getIndirectReference(), info.getIndirectReference(), encryption, fileID);
                trailer1.toPdf(this, this.os);
                super.close();
            } catch (IOException var8) {
                throw new ExceptionConverter(var8);
            }
        }

    }

    int size() {
        return this.body.size();
    }

    public float getTableBottom(Table table) {
        return this.pdf.bottom(table) - this.pdf.indentBottom();
    }

    public boolean fitsPage(Table table, float margin) {
        return this.pdf.bottom(table) > this.pdf.indentBottom() + margin;
    }

    public boolean fitsPage(Table table) {
        return this.fitsPage(table, 0.0F);
    }

    public boolean fitsPage(PdfPTable table, float margin) {
        return this.pdf.fitsPage(table, margin);
    }

    public boolean fitsPage(PdfPTable table) {
        return this.pdf.fitsPage(table, 0.0F);
    }

    boolean isPaused() {
        return this.pause;
    }

    public PdfContentByte getDirectContent() {
        if(!this.open) {
            throw new RuntimeException("The document is not open.");
        } else {
            return this.directContent;
        }
    }

    public PdfContentByte getDirectContentUnder() {
        if(!this.open) {
            throw new RuntimeException("The document is not open.");
        } else {
            return this.directContentUnder;
        }
    }

    void resetContent() {
        this.directContent.reset();
        this.directContentUnder.reset();
    }

    public PdfAcroForm getAcroForm() {
        return this.pdf.getAcroForm();
    }

    public PdfOutline getRootOutline() {
        return this.directContent.getRootOutline();
    }

    OutputStreamCounter getOs() {
        return this.os;
    }

    FontDetails addSimple(BaseFont bf) {
        if(bf.getFontType() == 4) {
            return new FontDetails(new PdfName("F" + this.fontNumber++), this.body.getPdfIndirectReference(), bf);
        } else {
            FontDetails ret = (FontDetails)this.documentFonts.get(bf);
            if(ret == null) {
                ret = new FontDetails(new PdfName("F" + this.fontNumber++), this.body.getPdfIndirectReference(), bf);
                this.documentFonts.put(bf, ret);
            }

            return ret;
        }
    }

    void eliminateFontSubset(PdfDictionary fonts) {
        Iterator it = this.documentFonts.values().iterator();

        while(it.hasNext()) {
            FontDetails ft = (FontDetails)it.next();
            if(fonts.get(ft.getFontName()) != null) {
                ft.setSubset(false);
            }
        }

    }

    ColorDetails addSimple(PdfSpotColor spc) {
        ColorDetails ret = (ColorDetails)this.documentColors.get(spc);
        if(ret == null) {
            ret = new ColorDetails(new PdfName("CS" + this.colorNumber++), this.body.getPdfIndirectReference(), spc);
            this.documentColors.put(spc, ret);
        }

        return ret;
    }

    ColorDetails addSimplePatternColorspace(Color color) {
        int type = ExtendedColor.getType(color);
        if(type != 4 && type != 5) {
            try {
                PdfArray e1;
                switch(type) {
                    case 0:
                        if(this.patternColorspaceRGB == null) {
                            this.patternColorspaceRGB = new ColorDetails(new PdfName("CS" + this.colorNumber++), this.body.getPdfIndirectReference(), (PdfSpotColor)null);
                            e1 = new PdfArray(PdfName.PATTERN);
                            e1.add(PdfName.DEVICERGB);
                            this.body.add(e1, this.patternColorspaceRGB.getIndirectReference());
                        }

                        return this.patternColorspaceRGB;
                    case 1:
                        if(this.patternColorspaceGRAY == null) {
                            this.patternColorspaceGRAY = new ColorDetails(new PdfName("CS" + this.colorNumber++), this.body.getPdfIndirectReference(), (PdfSpotColor)null);
                            e1 = new PdfArray(PdfName.PATTERN);
                            e1.add(PdfName.DEVICEGRAY);
                            this.body.add(e1, this.patternColorspaceGRAY.getIndirectReference());
                        }

                        return this.patternColorspaceGRAY;
                    case 2:
                        if(this.patternColorspaceCMYK == null) {
                            this.patternColorspaceCMYK = new ColorDetails(new PdfName("CS" + this.colorNumber++), this.body.getPdfIndirectReference(), (PdfSpotColor)null);
                            e1 = new PdfArray(PdfName.PATTERN);
                            e1.add(PdfName.DEVICECMYK);
                            this.body.add(e1, this.patternColorspaceCMYK.getIndirectReference());
                        }

                        return this.patternColorspaceCMYK;
                    case 3:
                        ColorDetails e = this.addSimple(((SpotColor)color).getPdfSpotColor());
                        ColorDetails patternDetails = (ColorDetails)this.documentSpotPatterns.get(e);
                        if(patternDetails == null) {
                            patternDetails = new ColorDetails(new PdfName("CS" + this.colorNumber++), this.body.getPdfIndirectReference(), (PdfSpotColor)null);
                            PdfArray array = new PdfArray(PdfName.PATTERN);
                            array.add(e.getIndirectReference());
                            this.body.add(array, patternDetails.getIndirectReference());
                            this.documentSpotPatterns.put(e, patternDetails);
                        }

                        return patternDetails;
                    default:
                        throw new RuntimeException("Invalid color type in PdfWriter.addSimplePatternColorspace().");
                }
            } catch (Exception var7) {
                throw new RuntimeException(var7.getMessage());
            }
        } else {
            throw new RuntimeException("An uncolored tile pattern can not have another pattern or shading as color.");
        }
    }

    void addSimpleShadingPattern(PdfShadingPattern shading) {
        if(!this.documentShadingPatterns.containsKey(shading)) {
            shading.setName(this.patternNumber);
            ++this.patternNumber;
            this.documentShadingPatterns.put(shading, (Object)null);
            this.addSimpleShading(shading.getShading());
        }

    }

    void addSimpleShading(PdfShading shading) {
        if(!this.documentShadings.containsKey(shading)) {
            this.documentShadings.put(shading, (Object)null);
            shading.setName(this.documentShadings.size());
        }

    }

    PdfObject[] addSimpleExtGState(PdfDictionary gstate) {
        if(!this.documentExtGState.containsKey(gstate)) {
            this.documentExtGState.put(gstate, new PdfObject[]{new PdfName("GS" + (this.documentExtGState.size() + 1)), this.getPdfIndirectReference()});
        }

        return (PdfObject[])this.documentExtGState.get(gstate);
    }

    PdfDocument getPdfDocument() {
        return this.pdf;
    }

    public PdfIndirectReference getPdfIndirectReference() {
        return this.body.getPdfIndirectReference();
    }

    int getIndirectReferenceNumber() {
        return this.body.getIndirectReferenceNumber();
    }

    PdfName addSimplePattern(PdfPatternPainter painter) {
        PdfName name = (PdfName)this.documentPatterns.get(painter);

        try {
            if(name == null) {
                name = new PdfName("P" + this.patternNumber);
                ++this.patternNumber;
                this.documentPatterns.put(painter, name);
            }

            return name;
        } catch (Exception var4) {
            throw new ExceptionConverter(var4);
        }
    }

    PdfName addDirectTemplateSimple(PdfTemplate template) {
        PdfIndirectReference ref = template.getIndirectReference();
        Object[] obj = (Object[])this.formXObjects.get(ref);
        PdfName name = null;

        try {
            if(obj == null) {
                name = new PdfName("Xf" + this.formXObjectsCounter);
                ++this.formXObjectsCounter;
                if(template.getType() == 2) {
                    template = null;
                }

                this.formXObjects.put(ref, new Object[]{name, template});
            } else {
                name = (PdfName)obj[0];
            }

            return name;
        } catch (Exception var6) {
            throw new ExceptionConverter(var6);
        }
    }

    public void setPageEvent(PdfPageEvent pageEvent) {
        this.pageEvent = pageEvent;
    }

    public PdfPageEvent getPageEvent() {
        return this.pageEvent;
    }

    void addLocalDestinations(TreeMap dest) throws IOException {
        Object[] obj;
        PdfDestination destination;
        for(Iterator i = dest.keySet().iterator(); i.hasNext(); this.body.add(destination, (PdfIndirectReference)obj[1])) {
            String name = (String)i.next();
            obj = (Object[])dest.get(name);
            destination = (PdfDestination)obj[2];
            if(destination == null) {
                throw new RuntimeException("The name \'" + name + "\' has no local destination.");
            }

            if(obj[1] == null) {
                obj[1] = this.getPdfIndirectReference();
            }
        }

    }

    public int getPageNumber() {
        return this.pdf.getPageNumber();
    }

    public void setViewerPreferences(int preferences) {
        this.pdf.setViewerPreferences(preferences);
    }

    public void setEncryption(byte[] userPassword, byte[] ownerPassword, int permissions, boolean strength128Bits) throws DocumentException {
        if(this.pdf.isOpen()) {
            throw new DocumentException("Encryption can only be added before opening the document.");
        } else {
            this.crypto = new PdfEncryption();
            this.crypto.setupAllKeys(userPassword, ownerPassword, permissions, strength128Bits);
        }
    }

    public void setEncryption(boolean strength, String userPassword, String ownerPassword, int permissions) throws DocumentException {
        this.setEncryption(DocWriter.getISOBytes(userPassword), DocWriter.getISOBytes(ownerPassword), permissions, strength);
    }

    public PdfIndirectObject addToBody(PdfObject object) throws IOException {
        PdfIndirectObject iobj = this.body.add(object);
        return iobj;
    }

    public PdfIndirectObject addToBody(PdfObject object, PdfIndirectReference ref) throws IOException {
        PdfIndirectObject iobj = this.body.add(object, ref);
        return iobj;
    }

    public PdfIndirectObject addToBody(PdfObject object, int refNumber) throws IOException {
        PdfIndirectObject iobj = this.body.add(object, refNumber);
        return iobj;
    }

    public void setOpenAction(String name) {
        this.pdf.setOpenAction(name);
    }

    public void setAdditionalAction(PdfName actionType, PdfAction action) throws PdfException {
        if(!actionType.equals(DOCUMENT_CLOSE) && !actionType.equals(WILL_SAVE) && !actionType.equals(DID_SAVE) && !actionType.equals(WILL_PRINT) && !actionType.equals(DID_PRINT)) {
            throw new PdfException("Invalid additional action type: " + actionType.toString());
        } else {
            this.pdf.addAdditionalAction(actionType, action);
        }
    }

    public void setOpenAction(PdfAction action) {
        this.pdf.setOpenAction(action);
    }

    public void setPageLabels(PdfPageLabels pageLabels) {
        this.pdf.setPageLabels(pageLabels);
    }

    PdfEncryption getEncryption() {
        return this.crypto;
    }

    RandomAccessFileOrArray getReaderFile(PdfReader reader) {
        return this.currentPdfReaderInstance.getReaderFile();
    }

    int getNewObjectNumber(PdfReader reader, int number, int generation) {
        return this.currentPdfReaderInstance.getNewObjectNumber(number, generation);
    }

    public PdfImportedPage getImportedPage(PdfReader reader, int pageNumber) {
        PdfReaderInstance inst = (PdfReaderInstance)this.importedPages.get(reader);
        if(inst == null) {
            inst = reader.getPdfReaderInstance(this);
            this.importedPages.put(reader, inst);
        }

        return inst.getImportedPage(pageNumber);
    }

    public void addJavaScript(PdfAction js) {
        this.pdf.addJavaScript(js);
    }

    public void addJavaScript(String code, boolean unicode) {
        this.addJavaScript(PdfAction.javaScript(code, this, unicode));
    }

    public void addJavaScript(String code) {
        this.addJavaScript(code, false);
    }

    public void setCropBoxSize(Rectangle crop) {
        this.pdf.setCropBoxSize(crop);
    }

    public PdfIndirectReference getPageReference(int page) {
        --page;
        if(page < 0) {
            throw new IndexOutOfBoundsException("The page numbers start at 1.");
        } else {
            PdfIndirectReference ref;
            if(page < this.pageReferences.size()) {
                ref = (PdfIndirectReference)this.pageReferences.get(page);
                if(ref == null) {
                    ref = this.body.getPdfIndirectReference();
                    this.pageReferences.set(page, ref);
                }
            } else {
                int empty = page - this.pageReferences.size();

                for(int k = 0; k < empty; ++k) {
                    this.pageReferences.add((Object)null);
                }

                ref = this.body.getPdfIndirectReference();
                this.pageReferences.add(ref);
            }

            return ref;
        }
    }

    PdfIndirectReference getCurrentPage() {
        return this.getPageReference(this.currentPageNumber);
    }

    int getCurrentPageNumber() {
        return this.currentPageNumber;
    }

    public void addCalculationOrder(PdfFormField annot) {
        this.pdf.addCalculationOrder(annot);
    }

    public void setSigFlags(int f) {
        this.pdf.setSigFlags(f);
    }

    public void addAnnotation(PdfAnnotation annot) {
        this.pdf.addAnnotation(annot);
    }

    void addAnnotation(PdfAnnotation annot, int page) {
        this.addAnnotation(annot);
    }

    public void setPdfVersion(char version) {
        this.HEADER[7] = (byte)version;
    }

    public int reorderPages(int[] order) throws DocumentException {
        return this.root.reorderPages(order);
    }

    public float getSpaceCharRatio() {
        return this.spaceCharRatio;
    }

    public void setSpaceCharRatio(float spaceCharRatio) {
        if(spaceCharRatio < 0.001F) {
            this.spaceCharRatio = 0.001F;
        } else {
            this.spaceCharRatio = spaceCharRatio;
        }

    }

    public void setRunDirection(int runDirection) {
        if(runDirection >= 1 && runDirection <= 3) {
            this.runDirection = runDirection;
        } else {
            throw new RuntimeException("Invalid run direction: " + runDirection);
        }
    }

    public int getRunDirection() {
        return this.runDirection;
    }

    public void setDuration(int seconds) {
        this.pdf.setDuration(seconds);
    }

    public void setTransition(PdfTransition transition) {
        this.pdf.setTransition(transition);
    }

    public void freeReader(PdfReader reader) throws IOException {
        this.currentPdfReaderInstance = (PdfReaderInstance)this.importedPages.get(reader);
        if(this.currentPdfReaderInstance != null) {
            this.currentPdfReaderInstance.writeAllPages();
            this.currentPdfReaderInstance = null;
            this.importedPages.remove(reader);
        }
    }

    public void setPageAction(PdfName actionType, PdfAction action) throws PdfException {
        if(!actionType.equals(PAGE_OPEN) && !actionType.equals(PAGE_CLOSE)) {
            throw new PdfException("Invalid page additional action type: " + actionType.toString());
        } else {
            this.pdf.setPageAction(actionType, action);
        }
    }

    public int getCurrentDocumentSize() {
        return this.body.offset() + this.body.size() * 20 + 72;
    }

    public boolean isStrictImageSequence() {
        return this.pdf.isStrictImageSequence();
    }

    public void setStrictImageSequence(boolean strictImageSequence) {
        this.pdf.setStrictImageSequence(strictImageSequence);
    }

    public void setPageEmpty(boolean pageEmpty) {
        this.pdf.setPageEmpty(pageEmpty);
    }

    public PdfDictionary getInfo() {
        return ((PdfDocument)this.document).getInfo();
    }

    public PdfDictionary getExtraCatalog() {
        return this.extraCatalog;
    }

    public void setExtraCatalog(PdfDictionary extraCatalog) {
        this.extraCatalog = extraCatalog;
    }

    public void setLinearPageMode() {
        this.root.setLinearMode((PdfIndirectReference)null);
    }

    public PdfDictionary getGroup() {
        return this.group;
    }

    public void setGroup(PdfDictionary group) {
        this.group = group;
    }

    public static class PdfBody {
        private ArrayList xrefs = new ArrayList();
        private int position;
        private PdfWriter writer;

        PdfBody(PdfWriter writer) {
            this.xrefs.add(new PdfWriter.PdfBody.PdfCrossReference(0, '\uffff'));
            this.position = writer.getOs().getCounter();
            this.writer = writer;
        }

        PdfIndirectObject add(PdfObject object) throws IOException {
            PdfIndirectObject indirect = new PdfIndirectObject(this.size(), object, this.writer);
            this.xrefs.add(new PdfWriter.PdfBody.PdfCrossReference(this.position));
            indirect.writeTo(this.writer.getOs());
            this.position = this.writer.getOs().getCounter();
            return indirect;
        }

        PdfIndirectReference getPdfIndirectReference() {
            this.xrefs.add(new PdfWriter.PdfBody.PdfCrossReference(0));
            return new PdfIndirectReference(0, this.size() - 1);
        }

        int getIndirectReferenceNumber() {
            this.xrefs.add(new PdfWriter.PdfBody.PdfCrossReference(0));
            return this.size() - 1;
        }

        PdfIndirectObject add(PdfObject object, PdfIndirectReference ref) throws IOException {
            PdfIndirectObject indirect = new PdfIndirectObject(ref.getNumber(), object, this.writer);
            this.xrefs.set(ref.getNumber(), new PdfWriter.PdfBody.PdfCrossReference(this.position));
            indirect.writeTo(this.writer.getOs());
            this.position = this.writer.getOs().getCounter();
            return indirect;
        }

        PdfIndirectObject add(PdfObject object, int refNumber) throws IOException {
            PdfIndirectObject indirect = new PdfIndirectObject(refNumber, object, this.writer);
            this.xrefs.set(refNumber, new PdfWriter.PdfBody.PdfCrossReference(this.position));
            indirect.writeTo(this.writer.getOs());
            this.position = this.writer.getOs().getCounter();
            return indirect;
        }

        int offset() {
            return this.position;
        }

        int size() {
            return this.xrefs.size();
        }

        void writeCrossReferenceTable(OutputStream os) throws IOException {
            os.write(DocWriter.getISOBytes("xref\n0 "));
            os.write(DocWriter.getISOBytes(String.valueOf(this.size())));
            os.write(10);
            Iterator i = this.xrefs.iterator();

            while(i.hasNext()) {
                PdfWriter.PdfBody.PdfCrossReference entry = (PdfWriter.PdfBody.PdfCrossReference)i.next();
                entry.toPdf((PdfWriter)null, os);
            }

        }

        static class PdfCrossReference {
            private int offset;
            private int generation;

            PdfCrossReference(int offset, int generation) {
                this.offset = offset;
                this.generation = generation;
            }

            PdfCrossReference(int offset) {
                this(offset, 0);
            }

            public void toPdf(PdfWriter writer, OutputStream os) throws IOException {
                String s = "0000000000" + this.offset;
                StringBuffer off = new StringBuffer(s.substring(s.length() - 10));
                s = "00000" + this.generation;
                String gen = s.substring(s.length() - 5);
                if(this.generation == '\uffff') {
                    os.write(DocWriter.getISOBytes(off.append(' ').append(gen).append(" f \n").toString()));
                } else {
                    os.write(DocWriter.getISOBytes(off.append(' ').append(gen).append(" n \n").toString()));
                }

            }
        }
    }

    static class PdfTrailer extends PdfDictionary {
        int offset;

        PdfTrailer(int size, int offset, PdfIndirectReference root, PdfIndirectReference info, PdfIndirectReference encryption, PdfObject fileID) {
            this.offset = offset;
            this.put(PdfName.SIZE, new PdfNumber(size));
            this.put(PdfName.ROOT, root);
            if(info != null) {
                this.put(PdfName.INFO, info);
            }

            if(encryption != null) {
                this.put(PdfName.ENCRYPT, encryption);
            }

            if(fileID != null) {
                this.put(PdfName.ID, fileID);
            }

        }

        public void toPdf(PdfWriter writer, OutputStream os) throws IOException {
            os.write(DocWriter.getISOBytes("trailer\n"));
            super.toPdf((PdfWriter)null, os);
            os.write(DocWriter.getISOBytes("\nstartxref\n"));
            os.write(DocWriter.getISOBytes(String.valueOf(this.offset)));
            os.write(DocWriter.getISOBytes("\n%%EOF\n"));
        }
    }
}
