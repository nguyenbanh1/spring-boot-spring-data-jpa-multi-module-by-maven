package Utils;

import sun.misc.BASE64Encoder;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StringUtil {
    /** STRING_SEARCH_LIKE_ALL. */
    public static final String STRING_SEARCH_LIKE_ALL = "%%";
    private static final String charset = "!0123456789abcdefghijklmnopqrstuvwxyz";
    public static final int LENGTH_HASH = 50;
    public static final String HASH_MD5 = "MD5";
    public static final String HASH_SHA1 = "SHA-1";
    private static final String[] oracleTextKeywords = new String[] { "ACCUM",
            "ABOUT", "NOT", "OR", "AND", "BT", "BTG", "BTP", "BTI", "NT",
            "NTG", "NTP", "NTI", "PT", "RT", "RT", "SQE", "SYN", "TR", "TRSYN",
            "TT", "FUZZY", "HASPATH", "INPATH", "MINUS", "NEAR", "WITHIN",
            "84%", "8%", "MDATA" };

    public static final String LOG_LOGIN_SUCCESS = "LOGIN_SUCCESS";
    public static final String LOG_LOGOUT_SUCCESS = "LOGOUT_SUCCESS";

    public static final String NAME_REGEX = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]+$";
    public static final String PHONE_REGEX = "^\\d{10,11}$";
    public static final String EMAIL_REGEX = "^([\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4})?$";
    public static final String ROLE_NAME_REGEX = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ 1-9]+$";



    public static final String LOG_SUCCESS = "1";
    public static final String LOG_FAIL = "0";

    public static final String DOUBLE_SEP = "||";
    public static final String SEPARATE_CHAR = "#";
    public static final String SINGLE_SEP = "|";

    public static String Empty() {
        return "";
    }

    /**
     * Gets the m d5 hash.
     *
     * @param string
     *            the string
     *
     * @return the m d5 hash
     */
    public static String getMD5Hash(String string, String salt) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update((salt + string).getBytes());
            final byte[] hash = digest.digest();
            final StringBuilder result = new StringBuilder(hash.length);
            for (int i = 0; i < hash.length; i++) {
                result.append(Integer.toString((hash[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            return result.toString();
        } catch (final NoSuchAlgorithmException e) {
            //LogUtil.logError(e, e.getMessage());
            return "error";
        }
    }

    public static String generateHash(String input, String salt, String typeHash) {
        // SHA or MD5
        try {
            if (salt == null) {
                salt = "";
            }

            MessageDigest md = null;
            if (StringUtil.isNullOrEmpty(typeHash)) {
                md = MessageDigest.getInstance(StringUtil.HASH_MD5);
            } else {
                md = MessageDigest.getInstance(typeHash);
            }

            String hash = "";
            input += salt;
            byte[] data = input.getBytes("US-ASCII");

            md.update(data);
            byte[] digest = md.digest();
            for (int i = 0; i < digest.length; i++) {
                String hex = Integer.toHexString(digest[i]);
                if (hex.length() == 1)
                    hex = "0" + hex;
                hex = hex.substring(hex.length() - 2);
                hash += hex;
            }
            return hash;
        } catch (Exception e) {
        }
        return "";
    }

    public static boolean isNullOrEmpty(final String s) {
        return (s == null || s.trim().length() == 0);
    }

    public static String removeSpecialChars(String text, String byString) {
        final String[] chars = new String[] { ",", ".", "/", "!", "@", "#",
                "$", "%", "^", "&", "*", "'", "\"", ";", "-", "_", "(", ")",
                ":", "|", "[", "]", "~", "+", "{", "}", "?", "\\", "<", ">" };
        if (StringUtil.isNullOrEmpty(text))
            return text;

        for (int i = 0; i < chars.length; i++) {
            if (text.indexOf(chars[i]) >= 0) {
                text = text.replace(chars[i], byString);
            }
        }
        return text;
    }

    public static String toOracleSearchText(String searchText, boolean isAutocomplete) {
        String[] splitString;
        StringBuilder text = new StringBuilder();
        String OpPat = ",;&"; // search operator pattern
        String SpPat = "<>./!@#$%^*'\"-_():|[]~+{}?\\\n"; // special char
        // pattern
        char[] searchTextArr;
        boolean preCheck = true;

        if (!StringUtil.isNullOrEmpty(searchText)) {
            searchTextArr = searchText.toCharArray();
            // remove special char, keep operator char
            for (int i = 0; i < searchTextArr.length; i++) {
                if (SpPat.indexOf(searchTextArr[i]) >= 0) {
                    searchTextArr[i] = ' ';
                } else if (OpPat.indexOf(searchTextArr[i]) >= 0) {
                    if (preCheck) {
                        searchTextArr[i] = ' ';
                    }
                    preCheck = true;
                } else
                    preCheck = false;
            }

            searchText = String.valueOf(searchTextArr).trim();
            if (StringUtil.isNullOrEmpty(searchText)) {
                return STRING_SEARCH_LIKE_ALL;
            }

            if (isAutocomplete)
                searchText = searchText.trim() + "%";
            else
                searchText = searchText.trim();

            splitString = searchText.split(" ");
            for (int i = 0; i < splitString.length; i++) {
                if (!"".equals(splitString[i])) {
                    // if (!isAutocomplete) {
                    for (int j = 0; j < oracleTextKeywords.length; j++) {
                        if (oracleTextKeywords[j].equals(splitString[i].toUpperCase())) {
                            splitString[i] = "{" + splitString[i] + "}";
                            break;
                        }
                    }

                    text.append(splitString[i] + " ");
                }
            }

            searchText = text.toString();

            // remove last operator if exist
            if (OpPat.indexOf(searchText.charAt(searchText.length() - 1)) >= 0) {
                searchText = searchText.substring(0, searchText.length() - 1);
            }
        } else {
            return STRING_SEARCH_LIKE_ALL;
        }

        return searchText;
    }

    public static Date getDateFromLot(String lot) {
        Date date = null;
        if (lot.length() > 5) {
            String dateLot = lot.substring(0, 2) + "/" + lot.substring(2, 4)
                    + "/20" + lot.substring(4);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                date = formatter.parse(dateLot);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    public static String toOracleSearchLikeSuffix(String searchText) {
        return toOracleSearchLike(searchText);
    }

    public static String toOracleSearchLike(String searchText) {
        String escapeChar = "/";
        String[] arrSpPat = {"/", "%", "_"};//, "\\\\"};

        for (String str: arrSpPat) {
            if (!StringUtil.isNullOrEmpty(searchText)) {
                searchText = searchText.replaceAll(str, escapeChar + str);
            }
        }
        searchText = "%" + searchText + "%";
        return searchText;
    }

    public static String toOracleSearchLikeNameText(String searchText) {
        String escapeChar = "/";
        String[] arrSpPat = {"/", "%", "_"};//, "\\\\"};

        for (String str: arrSpPat) {
            if (!StringUtil.isNullOrEmpty(searchText)) {
                searchText = searchText.replaceAll(str, escapeChar + str);
            }
        }
        searchText = UnicodeToEnglish.codau2khongdau(searchText);
        searchText = "%" + searchText + "%";
        return searchText;
    }

    public static boolean isNumber(final String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNumberWithDecimal(final String s) {
        try {
            new BigDecimal(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static float roundFloat(float unrounded, int precision, int roundingMode)
    {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(precision, roundingMode);
        return rounded.floatValue();
    }
    public static float roundFloatBottom(float unrounded, int precision){
        Double prec = Math.pow(10, precision);
        Integer tmp = Double.valueOf(unrounded*prec).intValue();
        BigDecimal rounded = new BigDecimal(tmp).divide(new BigDecimal(prec));
        return rounded.floatValue();
    }

    public static String dropUnderlined(String input){
        input = input.replace("_", "");
        return input;
    }

    /**
     * @author nhanlt6
     * @param code
     * @param name
     * @return
     */
    public static String CodeAddNameEx(String code,String name){
        if(StringUtil.isNullOrEmpty(code) && !StringUtil.isNullOrEmpty(name)){
            return name;
        }
        if(!StringUtil.isNullOrEmpty(code) && StringUtil.isNullOrEmpty(name)){
            return code;
        }
        if(!StringUtil.isNullOrEmpty(code) && !StringUtil.isNullOrEmpty(name)){
            return code + " / " + name;
        }
        return  "";
    }

    /**
     *
     * @param plaintext
     * @return
     * @throws Exception
     * @description : encrypt password VSA
     */
    public static String encryptPassWordVSA(String plaintext) throws Exception{
        MessageDigest md = null;
        String hash = null;

        md = MessageDigest.getInstance("SHA-1"); //step 2
        md.update(plaintext.getBytes("UTF-8")); //step 3
        byte raw[] = md.digest(); //step 4
        hash = (new BASE64Encoder()).encode(raw); //step 5

        return hash; //step 6
    }

    public static String getNameText(String code, String name, String... params){
        String result = "";
        if (!StringUtil.isNullOrEmpty(code)){
            result += UnicodeToEnglish.codau2khongdau(code) + ";";
        }
        if (!StringUtil.isNullOrEmpty(name)){
            result += UnicodeToEnglish.codau2khongdau(name) + ";";
        }
        if (params != null && params.length > 0){
            for (int i=0, size = params.length; i< size; i++){
                if (!StringUtil.isNullOrEmpty(params[i])){
                    result += UnicodeToEnglish.codau2khongdau(params[i]) + ";";
                }
            }
        }
        return result.toUpperCase();
    }

    public static String getNameTextWithoutCode(String name, String... params){
        String result = "";
        if (!StringUtil.isNullOrEmpty(name)){
            result += UnicodeToEnglish.codau2khongdauVakitudacbiet(name) + ";";
        }

        if (params != null && params.length > 0){
            for (int i=0, size = params.length; i< size; i++){
                if (!StringUtil.isNullOrEmpty(params[i])){
                    result += UnicodeToEnglish.codau2khongdau(params[i]) + ";";
                }
            }
        }
        return result.toUpperCase();
    }

    public static String getNameTextWithoutCodeName(String... params){
        String result = "";
        if (params != null && params.length > 0){
            for (int i=0, size = params.length; i< size; i++){
                if (!StringUtil.isNullOrEmpty(params[i])){
                    //result += UnicodeToEnglish.codau2khongdau(params[i]) + ";";
                    result += (UnicodeToEnglish.codau2khongdauVakitudacbiet(params[i]));
                    result = removeSpecialChars(result,"");
                }
            }
        }
        return result.trim().toUpperCase();
    }

    /**
     * Convert money.
     *
     * @param money
     *            the money
     * @return the string
     * @author phut
     * @since Aug 27, 2012
     */
    public static String convertMoney(BigDecimal money) {
        String result = "";
        if (money == null) {
            return result;
        }
        /* String _money = money.longValue() + ""; */
        String _money = money.toBigInteger() + "";
        int isDot = 1;
        for (int i = _money.length(); i > 0; i--) {
            char ch = _money.charAt(i - 1);
            if (isDot == 3 && i != 1) {
                if (_money.charAt(i - 2) == '-') {
                    result = ch + result;
                    isDot = 0;
                } else {
                    result = "," + ch + result;
                    isDot = 0;
                }
            } else {
                result = ch + result;
            }
            isDot++;
        }
        return result;
    }

    public static String getRandomString(int length) {
        Random rand = new Random(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int pos = rand.nextInt(charset.length());
            sb.append(charset.charAt(pos));
        }
        return sb.toString();
    }
    public static String getIpAndPort(String ip,String port){
        if(isNullOrEmpty(ip) && !isNullOrEmpty(port)){
            return "Port:" + port;
        }
        if(!isNullOrEmpty(ip) && isNullOrEmpty(port)){
            return "IP:"+ ip;
        }
        if(!isNullOrEmpty(ip) && !isNullOrEmpty(port)){
            return ip + ":" + port +"";
        }
        return "IP/Port:";
    }


    public static void main(String[] args) {
    }
}
