//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.lowagie.text.pdf;

import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.FontMapper;
import org.apache.log4j.Logger;

import java.awt.Font;
import java.io.File;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;

public class DefaultFontMapper implements FontMapper {

    static Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass());

    //modify by henry change default font
    private static final String DEFALUT_FONT = "STSong";
    public static BaseFont defaultFont;
    private HashMap aliases = new HashMap();
    private HashMap mapper = new HashMap();

    public DefaultFontMapper() {
    }

    public BaseFont awtToPdf(Font font) {
        try {
            boolean e = false;
            DefaultFontMapper.BaseFontParameters p = this.getBaseFontParameters(font.getFontName());
            if(p == null) {
                int base = font.getStyle();
                if(base != 0) {
                    String styledName = font.getFontName();
                    if((base & 1) != 0) {
                        styledName = styledName + " Bold";
                    }

                    if((base & 2) != 0) {
                        styledName = styledName + " Italic";
                    }

                    p = this.getBaseFontParameters(styledName);
                    e = true;
                }
            }

            if(p == null) {
                if(defaultFont != null) {
                    return defaultFont;
                } else {
                    throw new ExceptionConverter(new Exception("既找不到字体 [" + font.getFontName() + " ],也找不到默认字体STSong."));
                }
            } else {
                BaseFont base1 = BaseFont.createFont(p.fontName, p.encoding, p.embedded, p.cached, p.ttfAfm, p.pfb);
                base1.setStyled(e);
                return BaseFont.createFont(p.fontName, p.encoding, p.embedded, p.cached, p.ttfAfm, p.pfb);
            }
        } catch (Exception var6) {
            throw new ExceptionConverter(var6);
        }
    }

    public Font pdfToAwt(BaseFont font, int size) {
        String[][] names = font.getFullFontName();
        if(names.length == 1) {
            return new Font(names[0][3], 0, size);
        } else {
            String name10 = null;
            String name3x = null;

            for(int finalName = 0; finalName < names.length; ++finalName) {
                String[] name = names[finalName];
                if(name[0].equals("1") && name[1].equals("0")) {
                    name10 = name[3];
                } else if(name[2].equals("1033")) {
                    name3x = name[3];
                    break;
                }
            }

            String var8 = name3x;
            if(name3x == null) {
                var8 = name10;
            }

            if(var8 == null) {
                var8 = names[0][3];
            }

            return new Font(var8, 0, size);
        }
    }

    public void putName(String awtName, DefaultFontMapper.BaseFontParameters parameters) {
        this.mapper.put(awtName, parameters);
    }

    public void putAlias(String alias, String awtName) {
        this.aliases.put(alias, awtName);
    }

    public DefaultFontMapper.BaseFontParameters getBaseFontParameters(String name) {
        String alias = (String)this.aliases.get(name);
        if(alias == null) {
            return (DefaultFontMapper.BaseFontParameters)this.mapper.get(name);
        } else {
            DefaultFontMapper.BaseFontParameters p = (DefaultFontMapper.BaseFontParameters)this.mapper.get(alias);
            return p == null?(DefaultFontMapper.BaseFontParameters)this.mapper.get(name):p;
        }
    }

    protected void insertNames(String[][] names, String path) {
        String main = null;

        for(int p = 0; p < names.length; ++p) {
            String[] k = names[p];
            if(k[2].equals("1033")) {
                main = k[3];
                break;
            }
        }

        if(main == null) {
            main = names[0][3];
        }

        DefaultFontMapper.BaseFontParameters var6 = new DefaultFontMapper.BaseFontParameters(path);
        this.mapper.put(main, var6);

        for(int var7 = 0; var7 < names.length; ++var7) {
            this.aliases.put(names[var7][3], main);
        }

    }

    public int insertDirectory(String dir) {
        File file = new File(dir);
        if(file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            int count = 0;

            for(int k = 0; k < files.length; ++k) {
                file = files[k];
                String name = file.getPath().toLowerCase();

                try {
                    if(!name.endsWith(".ttf") && !name.endsWith(".otf") && !name.endsWith(".afm")) {
                        if(name.endsWith(".ttc")) {
                            String[] var12 = BaseFont.enumerateTTCNames(file.getPath());

                            for(int j = 0; j < var12.length; ++j) {
                                String nt = file.getPath() + "," + j;
                                String[][] names = BaseFont.getFullFontName(nt, "Cp1252", (byte[])null);
                                this.insertNames(names, nt);
                            }

                            ++count;
                        }
                    } else {
                        String[][] p = BaseFont.getFullFontName(file.getPath(), "Cp1252", (byte[])null);
                        this.insertNames(p, file.getPath());
                        ++count;
                    }
                } catch (Exception var11) {
                    logger.error(var11);
                }
            }

            try {
                DefaultFontMapper.BaseFontParameters var13 = this.getBaseFontParameters(DEFALUT_FONT);
                defaultFont = BaseFont.createFont(var13.fontName, var13.encoding, var13.embedded, var13.cached, var13.ttfAfm, var13.pfb);
            }catch (Exception ex) {
                ex.printStackTrace();
                logger.error(ex);
            }

            return count;
        } else {
            return 0;
        }
    }

    public HashMap getMapper() {
        return this.mapper;
    }

    public HashMap getAliases() {
        return this.aliases;
    }

    public static class BaseFontParameters {
        public String fontName;
        public String encoding;
        public boolean embedded;
        public boolean cached;
        public byte[] ttfAfm;
        public byte[] pfb;

        public BaseFontParameters(String fontName) {
            this.fontName = fontName;
            this.encoding = "Identity-H";
            this.embedded = true;
            this.cached = true;
        }
    }
}
