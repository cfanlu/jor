package jatools.designer.data;


/**
 * DOCUMENT ME!
 *
 * @version $Revision: 1.1 $
 * @author $author$
 */
interface SQLParserConstants {
    int EOF = 0;
    int COMMENT_LINE = 5;
    int COMMENT_BLOCK = 6;
    int ALL = 7;
    int AND = 8;
    int ASC = 9;
    int BEGIN = 10;
    int BETWEEN = 11;
    int BOOLEAN = 12;
    int BY = 13;
    int CHAR = 14;
    int CHARACTER = 15;
    int CONSTANT = 16;
    int CURSOR = 17;
    int DESC = 18;
    int DISTINCT = 19;
    int ELSE = 20;
    int ELSIF = 21;
    int END = 22;
    int FROM = 23;
    int GROUP = 24;
    int HAVING = 25;
    int IF = 26;
    int INTEGER = 27;
    int IN = 28;
    int IS = 29;
    int LIKE = 30;
    int MAX = 31;
    int MIN = 32;
    int NOT = 33;
    int NULL = 34;
    int NUMBER = 35;
    int OR = 36;
    int ORDER = 37;
    int PROCEDURE = 38;
    int RECORD = 39;
    int SELECT = 40;
    int SMALLINT = 41;
    int SPACES = 42;
    int SUBSTR = 43;
    int SUM = 44;
    int THEN = 45;
    int TYPE = 46;
    int USER = 47;
    int UPPER = 48;
    int VARCHAR2 = 49;
    int WHERE = 50;
    int ZERO = 51;
    int ZEROS = 52;
    int COUNT = 53;
    int CLOSE = 54;
    int CONVERT_TIMESTAMP_TO_DATE = 55;
    int DELETE = 56;
    int EXISTS = 57;
    int EXIT = 58;
    int EXCEPTION = 59;
    int FETCH = 60;
    int FOR = 61;
    int FORMAT_AUDIT_HEADER = 62;
    int FORMAT_ATTRIBUTE_SUBSTRING = 63;
    int GET_CURRENT_TIMESTAMP = 64;
    int INSERT = 65;
    int INTO = 66;
    int INDEX_BY = 67;
    int IS_TABLE_OF = 68;
    int LENGTH = 69;
    int LOOP = 70;
    int LPAD = 71;
    int LTRIM = 72;
    int REPLACE = 73;
    int RTRIM = 74;
    int NODULE = 75;
    int NOTFOUND = 76;
    int OPEN = 77;
    int OTHERS = 78;
    int ORIGINPLUS = 79;
    int REPLY = 80;
    int REPLY_REPEATING_GROUP = 81;
    int REQUEST = 82;
    int ROW_NOT_FOUND = 83;
    int SET = 84;
    int SQL_I_O_CORRECT = 85;
    int TO_CHAR = 86;
    int TO_NUMBER = 87;
    int UPDATE = 88;
    int VALUES = 89;
    int WHEN = 90;
    int WHILE = 91;
    int NO_DATA_FOUND = 92;
    int TABLE_STATUS = 93;
    int SQLCODE = 94;
    int SET_ROW_NOT_FOUND = 95;
    int FILE_NAME_OF_ERROR_AREA = 96;
    int KEY_IN_ERROR = 97;
    int ERROR_DETAIL_DESCRIPTION = 98;
    int SETUPFATALERROR = 99;
    int OPENDESCRIPTION = 100;
    int CLOSEDESCRIPTION = 101;
    int DESCRIPTION = 102;
    int INTEGER_LITERAL = 103;
    int FLOATING_POINT_LITERAL = 104;
    int EXPONENT = 105;
    int STRING_LITERAL = 106;
    int ID = 107;
    int LETTER = 108;
    int DIGIT = 109;
    int ASSIGN = 110;
    int CONCAT = 111;
    int SEMICOLON = 112;
    int DOT = 113;
    int ROWTYPE = 114;
    int TILDE = 115;
    int LESS = 116;
    int LESSEQUAL = 117;
    int GREATER = 118;
    int GREATEREQUAL = 119;
    int EQUAL = 120;
    int NOTEQUAL = 121;
    int NOTEQUAL2 = 122;
    int JOINPLUS = 123;
    int OPENPAREN = 124;
    int CLOSEPAREN = 125;
    int ASTERISK = 126;
    int SLASH = 127;
    int PLUS = 128;
    int MINUS = 129;
    int QUESTIONMARK = 130;
    int COMPARISON = 131;
    int FUNCTION = 133;
    int DEFAULT = 0;
    int DESCRIPTION_START_STATE = 1;
    int DESCRIPTION_STATE = 2;
    String[] tokenImage4 = {
            "<EOF>",
            "\" \"",
            "\"\\n\"",
            "\"\\r\"",
            "\"\\t\"",
            "<COMMENT_LINE>",
            
            "<COMMENT_BLOCK>",
            "\"all\"",
            "\"and\"",
            "\"asc\"",
            "\"begin\"",
            "\"between\"",
            
            "\"boolean\"",
            "\"by\"",
            "\"char\"",
            "\"character\"",
            "\"constant\"",
            
            "\"cursor\"",
            "\"desc\"",
            "\"distinct\"",
            "\"else\"",
            "\"elsif\"",
            "\"end\"",
            
            "\"from\"",
            "\"group\"",
            "\"having\"",
            "\"if\"",
            "\"integer\"",
            "\"in\"",
            
            "\"is\"",
            "\"like\"",
            "\"max\"",
            "\"min\"",
            "\"not\"",
            "\"null\"",
            "\"number\"",
            
            "\"or\"",
            "\"order\"",
            "\"procedure\"",
            "\"record\"",
            "\"select\"",
            
            "\"smallint\"",
            "\"spaces\"",
            "\"substr\"",
            "\"sum\"",
            "\"then\"",
            "\"type\"",
            
            "\"user\"",
            "\"upper\"",
            "\"varchar2\"",
            "\"where\"",
            "\"zero\"",
            "\"zeros\"",
            
            "\"count\"",
            "\"close\"",
            "\"ConvertTimeStampToDate\"",
            "\"delete\"",
            
            "\"exists\"",
            "\"exit\"",
            "\"exception\"",
            "\"fetch\"",
            "\"for\"",
            
            "\"FormatAuditHeader\"",
            "\"FormatAttributeSubString\"",
            
            "\"GetCurrentTimeStamp\"",
            "\"insert\"",
            "\"into\"",
            
            "\"index by binary_integer\"",
            "\"is table of\"",
            "\"length\"",
            "\"loop\"",
            "\"FILE_NAME_OF_ERROR_AREA\"",
            "\"KEY_IN_ERROR\"",
            
            "\"ERROR_DETAIL_DESCRIPTION\"",
            "\"SetupFatalError\"",
            "\"\\r\\n\"",
            "\"~\"",
            
            "<DESCRIPTION>",
            "<INTEGER_LITERAL>",
            "<FLOATING_POINT_LITERAL>",
            "<EXPONENT>",
            
            "<STRING_LITERAL>",
            "<ID>",
            "<LETTER>",
            "<DIGIT>",
            "\":=\"",
            "\"||\"",
            "\";\"",
            
            "\".\"",
            "\"%ROWTYPE\"",
            "\"~\"",
            "\"<\"",
            "\"<=\"",
            "\">\"",
            "\">=\"",
            "\"=\"",
            
            "\"!=\"",
            "\"<>\"",
            "\"(+)\"",
            "\"(\"",
            "\")\"",
            "\"*\"",
            "\"/\"",
            "\"+\"",
            
            "\"-\"",
            "\"?\"",
            "<COMPARISON>",
            "\",\"","function",
        };
    String[] tokenImage1 = {
            "<EOF>",
            "all",
            "and",
            "asc",
            "begin",
            "between",
            "boolean",
            "by",
            "char",
            
            "character",
            "constant",
            "cursor",
            "desc",
            "distinct",
            "else",
            "elsif",
            "end",
            
            "from",
            "group",
            "having",
            "if",
            "integer",
            "in",
            "is",
            "like",
            "max",
            "min",
            
            "not",
            "null",
            "number",
            "or",
            "order",
            "procedure",
            "record",
            "select",
            
            "smallint",
            "spaces",
            "substr",
            "sum",
            "then",
            "user",
            "upper",
            "varchar2",
            
            "where",
            "zero",
            "zeros",
            "count",
            "close",
            "ConvertTimeStampToDate",
            "delete",
            
            "exists",
            "exit",
            "exception",
            "fetch",
            "for",
            "FormatAuditHeader",
            
            "FormatAttributeSubString",
            "GetCurrentTimeStamp",
            "insert",
            "into",
            
            "index by binary_integer",
            "is table of",
            "length",
            "loop",
            "lpad",
            "ltrim",
            
            "replace",
            "rtrim",
            "nodule",
            "notFound",
            "open",
            "others",
            "originplus",
            "reply",
            
            "replyRepeatingGroup",
            "request",
            "row_not_found",
            "set",
            "sql_I_O_Correct",
            
            "to_char",
            "to_number",
            "update",
            "values",
            "when",
            "while",
            "NO_DATA_FOUND",
            
            "TABLE_STATUS",
            "SQLCode",
            "Set_Row_Not_Found",
            "FILE_NAME_OF_ERROR_AREA",
            
            "KEY_IN_ERROR",
            "ERROR_DETAIL_DESCRIPTION",
            "SetupFatalError",
            "function",
            "var",
        };
}
