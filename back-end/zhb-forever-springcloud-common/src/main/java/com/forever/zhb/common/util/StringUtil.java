package com.forever.zhb.common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

public class StringUtil {
    
    private static final String FOLDER_SEPARATOR = "/";
    private static final String WINDOWS_FOLDER_SEPARATOR = "\\";
    private static final String TOP_PATH = "..";
    private static final String CURRENT_PATH = ".";
    private static final char EXTENSION_SEPARATOR = 46;

    public static String getPropertyPath(String propertyPath, String defaultPropertyFileName) {
        if ((StringUtils.isBlank(propertyPath)) || (StringUtils.isBlank(defaultPropertyFileName))) {
            return null;
        }

        String propertyFilePath = System.getProperties().getProperty(propertyPath);
        if (StringUtils.isBlank(propertyFilePath)) {
            propertyFilePath = System.getenv(propertyPath);
        }

        StringBuilder pathBuilder = new StringBuilder(propertyFilePath);
        if ((StringUtils.isNotBlank(defaultPropertyFileName))
                && (!(StringUtils.endsWithIgnoreCase(propertyFilePath, defaultPropertyFileName)))) {
            pathBuilder.append(File.separatorChar).append(defaultPropertyFileName);
        }
        return pathBuilder.toString();
    }
    
    /**
     * 获取指定字符串出现的次数
     * 
     * @param srcText 源字符串
     * @param findText 要查找的字符串
     * @return
     */
    public static  int countNumber(String srcText, String findText){
        int count = 0;
        Pattern p = Pattern.compile(findText);
        Matcher m = p.matcher(srcText);
        while (m.find()) {
            count++;
        }
        return count;
    }
    
    public static boolean equals(String str1,String str2) {
        if (isBlank(str1) || isBlank(str2)) {
            return false;
        }
        if (str1.equals(str2)) {
            return true;
        }
        return false;
    }
    
    public static boolean isEmpty(Object str) {
        return ((str == null) || ("".equals(str)));
    }
    
    public static boolean isNotEmpty(Object str) {
        return !(isEmpty(str));
    }
    
    public static boolean isEmpty(CharSequence cs) {
        return ((cs == null) || (cs.length() == 0));
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return (!(isEmpty(cs)));
    }
    
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if ((cs == null) || ((strLen = cs.length()) == 0))
            return true;
        for (int i = 0; i < strLen; ++i) {
            if (!(Character.isWhitespace(cs.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(CharSequence cs) {
        return (!(isBlank(cs)));
    }

    public static boolean hasLength(CharSequence str) {
        return ((str != null) && (str.length() > 0));
    }

    public static boolean hasText(CharSequence str) {
        if (!(hasLength(str))) {
            return false;
        }
        int strLen = str.length();
        for (int i = 0; i < strLen; ++i) {
            if (!(Character.isWhitespace(str.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasText(String str) {
        return hasText(str);
    }

    public static boolean containsWhitespace(CharSequence str) {
        if (!(hasLength(str))) {
            return false;
        }
        int strLen = str.length();
        for (int i = 0; i < strLen; ++i) {
            if (Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsWhitespace(String str) {
        return containsWhitespace(str);
    }

    public static String trimWhitespace(String str) {
        if (!(hasLength(str))) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while ((sb.length() > 0) && (Character.isWhitespace(sb.charAt(0)))) {
            sb.deleteCharAt(0);
        }
        while ((sb.length() > 0) && (Character.isWhitespace(sb.charAt(sb.length() - 1)))) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String trimAllWhitespace(String str) {
        if (!(hasLength(str))) {
            return str;
        }
        int len = str.length();
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < len; ++i) {
            char c = str.charAt(i);
            if (!(Character.isWhitespace(c))) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String trimLeadingWhitespace(String str) {
        if (!(hasLength(str))) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while ((sb.length() > 0) && (Character.isWhitespace(sb.charAt(0)))) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static String trimTrailingWhitespace(String str) {
        if (!(hasLength(str))) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while ((sb.length() > 0) && (Character.isWhitespace(sb.charAt(sb.length() - 1)))) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        if (!(hasLength(str))) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while ((sb.length() > 0) && (sb.charAt(0) == leadingCharacter)) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static String trimTrailingCharacter(String str, char trailingCharacter) {
        if (!(hasLength(str))) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while ((sb.length() > 0) && (sb.charAt(sb.length() - 1) == trailingCharacter)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static boolean startsWithIgnoreCase(String str, String prefix) {
        if ((str == null) || (prefix == null)) {
            return false;
        }
        if (str.startsWith(prefix)) {
            return true;
        }
        if (str.length() < prefix.length()) {
            return false;
        }
        String lcStr = str.substring(0, prefix.length()).toLowerCase();
        String lcPrefix = prefix.toLowerCase();
        return lcStr.equals(lcPrefix);
    }

    public static boolean endsWithIgnoreCase(String str, String suffix) {
        if ((str == null) || (suffix == null)) {
            return false;
        }
        if (str.endsWith(suffix)) {
            return true;
        }
        if (str.length() < suffix.length()) {
            return false;
        }

        String lcStr = str.substring(str.length() - suffix.length()).toLowerCase();
        String lcSuffix = suffix.toLowerCase();
        return lcStr.equals(lcSuffix);
    }

    public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
        for (int j = 0; j < substring.length(); ++j) {
            int i = index + j;
            if ((i >= str.length()) || (str.charAt(i) != substring.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    public static int countOccurrencesOf(String str, String sub) {
        if ((str == null) || (sub == null) || (str.length() == 0) || (sub.length() == 0)) {
            return 0;
        }
        int count = 0;
        int pos = 0;
        int idx;
        while ((idx = str.indexOf(sub, pos)) != -1) {
            ++count;
            pos = idx + sub.length();
        }
        return count;
    }

    public static String replace(String inString, String oldPattern, String newPattern) {
        if ((!(isEmpty(inString))) || (!(isEmpty(oldPattern))) || (newPattern == null)) {
            return inString;
        }
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        int index = inString.indexOf(oldPattern);

        int patLen = oldPattern.length();
        while (index >= 0) {
            sb.append(inString.substring(pos, index));
            sb.append(newPattern);
            pos = index + patLen;
            index = inString.indexOf(oldPattern, pos);
        }
        sb.append(inString.substring(pos));

        return sb.toString();
    }

    public static String delete(String inString, String pattern) {
        return replace(inString, pattern, "");
    }

    public static String deleteAny(String inString, String charsToDelete) {
        if ((!(hasLength(inString))) || (!(hasLength(charsToDelete)))) {
            return inString;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inString.length(); ++i) {
            char c = inString.charAt(i);
            if (charsToDelete.indexOf(c) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String quote(String str) {
        return ((str != null) ? new StringBuilder().append("'").append(str).append("'").toString() : null);
    }

    public static Object quoteIfString(Object obj) {
        return ((obj instanceof String) ? quote((String) obj) : obj);
    }

    public static String unqualify(String qualifiedName) {
        return unqualify(qualifiedName, '.');
    }

    public static String unqualify(String qualifiedName, char separator) {
        return qualifiedName.substring(qualifiedName.lastIndexOf(separator) + 1);
    }

    public static String capitalize(String str) {
        return changeFirstCharacterCase(str, true);
    }

    public static String uncapitalize(String str) {
        return changeFirstCharacterCase(str, false);
    }

    private static String changeFirstCharacterCase(String str, boolean capitalize) {
        if ((str == null) || (str.length() == 0)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        if (capitalize) {
            sb.append(Character.toUpperCase(str.charAt(0)));
        } else {
            sb.append(Character.toLowerCase(str.charAt(0)));
        }
        sb.append(str.substring(1));
        return sb.toString();
    }

    public static String getFilename(String path) {
        if (path == null) {
            return null;
        }
        int separatorIndex = path.lastIndexOf("/");
        return ((separatorIndex != -1) ? path.substring(separatorIndex + 1) : path);
    }

    public static String getFilenameExtension(String path) {
        if (path == null) {
            return null;
        }
        int extIndex = path.lastIndexOf(46);
        if (extIndex == -1) {
            return null;
        }
        int folderIndex = path.lastIndexOf("/");
        if (folderIndex > extIndex) {
            return null;
        }
        return path.substring(extIndex + 1);
    }

    public static String stripFilenameExtension(String path) {
        if (path == null) {
            return null;
        }
        int extIndex = path.lastIndexOf(46);
        if (extIndex == -1) {
            return path;
        }
        int folderIndex = path.lastIndexOf("/");
        if (folderIndex > extIndex) {
            return path;
        }
        return path.substring(0, extIndex);
    }

    public static String applyRelativePath(String path, String relativePath) {
        int separatorIndex = path.lastIndexOf("/");
        if (separatorIndex != -1) {
            String newPath = path.substring(0, separatorIndex);
            if (!(relativePath.startsWith("/"))) {
                newPath = new StringBuilder().append(newPath).append("/").toString();
            }
            return new StringBuilder().append(newPath).append(relativePath).toString();
        }

        return relativePath;
    }

    public static String cleanPath(String path) {
        if (path == null) {
            return null;
        }
        String pathToUse = replace(path, "\\", "/");

        int prefixIndex = pathToUse.indexOf(":");
        String prefix = "";
        if (prefixIndex != -1) {
            prefix = pathToUse.substring(0, prefixIndex + 1);
            if (prefix.contains("/")) {
                prefix = "";
            } else {
                pathToUse = pathToUse.substring(prefixIndex + 1);
            }
        }
        if (pathToUse.startsWith("/")) {
            prefix = new StringBuilder().append(prefix).append("/").toString();
            pathToUse = pathToUse.substring(1);
        }

        String[] pathArray = delimitedListToStringArray(pathToUse, "/");
        List pathElements = new LinkedList();
        int tops = 0;

        for (int i = pathArray.length - 1; i >= 0; --i) {
            String element = pathArray[i];
            if (".".equals(element)) {
                continue;
            }
            if ("..".equals(element)) {
                ++tops;
            } else if (tops > 0) {
                --tops;
            } else {
                pathElements.add(0, element);
            }

        }

        for (int i = 0; i < tops; ++i) {
            pathElements.add(0, "..");
        }

        return new StringBuilder().append(prefix).append(collectionToDelimitedString(pathElements, "/")).toString();
    }

    public static boolean pathEquals(String path1, String path2) {
        return cleanPath(path1).equals(cleanPath(path2));
    }

    public static Locale parseLocaleString(String localeString) {
        String[] parts = tokenizeToStringArray(localeString, "_ ", false, false);
        String language = (parts.length > 0) ? parts[0] : "";
        String country = (parts.length > 1) ? parts[1] : "";
        validateLocalePart(language);
        validateLocalePart(country);
        String variant = "";
        if (parts.length > 2) {
            int endIndexOfCountryCode = localeString.indexOf(country, language.length()) + country.length();

            variant = trimLeadingWhitespace(localeString.substring(endIndexOfCountryCode));
            if (variant.startsWith("_")) {
                variant = trimLeadingCharacter(variant, '_');
            }
        }
        return ((language.length() > 0) ? new Locale(language, country, variant) : null);
    }

    private static void validateLocalePart(String localePart) {
        for (int i = 0; i < localePart.length(); ++i) {
            char ch = localePart.charAt(i);
            if ((ch != '_') && (ch != ' ') && (!(Character.isLetterOrDigit(ch))))
                throw new IllegalArgumentException(new StringBuilder().append("Locale part \"").append(localePart)
                        .append("\" contains invalid characters").toString());
        }
    }

    public static String toLanguageTag(Locale locale) {
        return new StringBuilder().append(locale.getLanguage()).append((hasText(locale.getCountry()))
                ? new StringBuilder().append("-").append(locale.getCountry()).toString() : "").toString();
    }

    public static TimeZone parseTimeZoneString(String timeZoneString) {
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneString);
        if (("GMT".equals(timeZone.getID())) && (!(timeZoneString.startsWith("GMT")))) {
            throw new IllegalArgumentException(new StringBuilder().append("Invalid time zone specification '")
                    .append(timeZoneString).append("'").toString());
        }
        return timeZone;
    }

    public static String[] addStringToArray(String[] array, String str) {
        if (ObjectUtils.isEmpty(array)) {
            return new String[] { str };
        }
        String[] newArr = new String[array.length + 1];
        System.arraycopy(array, 0, newArr, 0, array.length);
        newArr[array.length] = str;
        return newArr;
    }

    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        if (ObjectUtils.isEmpty(array1)) {
            return array2;
        }
        if (ObjectUtils.isEmpty(array2)) {
            return array1;
        }
        String[] newArr = new String[array1.length + array2.length];
        System.arraycopy(array1, 0, newArr, 0, array1.length);
        System.arraycopy(array2, 0, newArr, array1.length, array2.length);
        return newArr;
    }

    public static String[] mergeStringArrays(String[] array1, String[] array2) {
        if (ObjectUtils.isEmpty(array1)) {
            return array2;
        }
        if (ObjectUtils.isEmpty(array2)) {
            return array1;
        }
        List result = new ArrayList();
        result.addAll(Arrays.asList(array1));
        for (String str : array2) {
            if (!(result.contains(str))) {
                result.add(str);
            }
        }
        return toStringArray(result);
    }

    public static String[] sortStringArray(String[] array) {
        if (ObjectUtils.isEmpty(array)) {
            return new String[0];
        }
        Arrays.sort(array);
        return array;
    }

    public static String[] toStringArray(Collection<String> collection) {
        if (collection == null) {
            return null;
        }
        return ((String[]) collection.toArray(new String[collection.size()]));
    }

    public static String[] toStringArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return null;
        }
        List list = Collections.list(enumeration);
        return ((String[]) list.toArray(new String[list.size()]));
    }

    public static String[] trimArrayElements(String[] array) {
        if (ObjectUtils.isEmpty(array)) {
            return new String[0];
        }
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; ++i) {
            String element = array[i];
            result[i] = ((element != null) ? element.trim() : null);
        }
        return result;
    }

    public static String[] removeDuplicateStrings(String[] array) {
        if (ObjectUtils.isEmpty(array)) {
            return array;
        }
        Set set = new TreeSet();
        for (String element : array) {
            set.add(element);
        }
        return toStringArray(set);
    }

    public static String[] split(String toSplit, String delimiter) {
        if ((!(hasLength(toSplit))) || (!(hasLength(delimiter)))) {
            return null;
        }
        int offset = toSplit.indexOf(delimiter);
        if (offset < 0) {
            return null;
        }
        String beforeDelimiter = toSplit.substring(0, offset);
        String afterDelimiter = toSplit.substring(offset + delimiter.length());
        return new String[] { beforeDelimiter, afterDelimiter };
    }

    public static Properties splitArrayElementsIntoProperties(String[] array, String delimiter) {
        return splitArrayElementsIntoProperties(array, delimiter, null);
    }

    public static Properties splitArrayElementsIntoProperties(String[] array, String delimiter, String charsToDelete) {
        if (ObjectUtils.isEmpty(array)) {
            return null;
        }
        Properties result = new Properties();
        for (String element : array) {
            if (charsToDelete != null) {
                element = deleteAny(element, charsToDelete);
            }
            String[] splittedElement = split(element, delimiter);
            if (splittedElement == null) {
                continue;
            }
            result.setProperty(splittedElement[0].trim(), splittedElement[1].trim());
        }
        return result;
    }

    public static String[] tokenizeToStringArray(String str, String delimiters) {
        return tokenizeToStringArray(str, delimiters, true, true);
    }

    public static String[] tokenizeToStringArray(String str, String delimiters, boolean trimTokens,
            boolean ignoreEmptyTokens) {
        if (str == null) {
            return null;
        }
        StringTokenizer st = new StringTokenizer(str, delimiters);
        List tokens = new ArrayList();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (trimTokens) {
                token = token.trim();
            }
            if ((!(ignoreEmptyTokens)) || (token.length() > 0)) {
                tokens.add(token);
            }
        }
        return toStringArray(tokens);
    }

    public static String[] delimitedListToStringArray(String str, String delimiter) {
        return delimitedListToStringArray(str, delimiter, null);
    }

    public static String[] delimitedListToStringArray(String str, String delimiter, String charsToDelete) {
        if (str == null) {
            return new String[0];
        }
        if (delimiter == null) {
            return new String[] { str };
        }
        List result = new ArrayList();
        if ("".equals(delimiter)) {
            for (int i = 0; i < str.length(); ++i)
                result.add(deleteAny(str.substring(i, i + 1), charsToDelete));
        } else {
            int pos = 0;
            int delPos;
            while ((delPos = str.indexOf(delimiter, pos)) != -1) {
                result.add(deleteAny(str.substring(pos, delPos), charsToDelete));
                pos = delPos + delimiter.length();
            }
            if ((str.length() > 0) && (pos <= str.length())) {
                result.add(deleteAny(str.substring(pos), charsToDelete));
            }
        }
        return toStringArray(result);
    }

    public static String[] commaDelimitedListToStringArray(String str) {
        return delimitedListToStringArray(str, ",");
    }

    public static Set<String> commaDelimitedListToSet(String str) {
        Set set = new TreeSet();
        String[] tokens = commaDelimitedListToStringArray(str);
        for (String token : tokens) {
            set.add(token);
        }
        return set;
    }

    public static String collectionToDelimitedString(Collection<?> coll, String delim, String prefix, String suffix) {
        if (CollectionUtils.isEmpty(coll)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = coll.iterator();
        while (it.hasNext()) {
            sb.append(prefix).append(it.next()).append(suffix);
            if (it.hasNext())
                ;
            sb.append(delim);
        }

        return sb.toString();
    }

    public static String collectionToDelimitedString(Collection<?> coll, String delim) {
        return collectionToDelimitedString(coll, delim, "", "");
    }

    public static String collectionToCommaDelimitedString(Collection<?> coll) {
        return collectionToDelimitedString(coll, ",");
    }

    public static String arrayToDelimitedString(Object[] arr, String delim) {
        if (ObjectUtils.isEmpty(arr)) {
            return "";
        }
        if (arr.length == 1) {
            return ObjectUtils.nullSafeToString(arr[0]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            if (i > 0) {
                sb.append(delim);
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static String arrayToCommaDelimitedString(Object[] arr) {
        return arrayToDelimitedString(arr, ",");
    }
    
    public static void println(String result) {
        System.out.println(result);
    }
    
    public static void print(String result) {
        System.out.print(result);
    }
    
    // 替换字符串里最后出现的元素
    public static String replaceLast( String text, String oldChar, String newChar ) {
        return text.replaceFirst( "(?s)" + oldChar + "(?!.*?" + oldChar + ")", newChar );
    }
    
    /**
     * solr 查询参数拼接
     * @param field
     * @param list
     * @return BatchUploadExcelVO
     */
    public static String generateFilterOrQuery(String field, List<String> list) {
        return generateFilterOrQuery(field, list.toArray());
    }
    
    public static String generateFilterOrQuery(String field, Object[] strs) {
        String format = "%s:(%s)";
        //return String.format(format, new Object[] { field, StringUtils.join(strs, " OR ") });
        return String.format(format, new Object[] { field, join(strs, " OR ") });
    }

    public static String join(Object[] array, String separator) {
        if (array == null) {
            return null;
        }
        return join(array, separator, 0, array.length);
    }

    public static String join(Object[] array, String separator, int startIndex, int endIndex) {
        if (array == null) {
            return null;
        }
        if (separator == null) {
            separator = "";
        }

        int bufSize = endIndex - startIndex;
        if (bufSize <= 0) {
            return "";
        }

        bufSize *= (((array[startIndex] == null) ? 16 : array[startIndex].toString().length()) + separator.length());

        StringBuffer buf = new StringBuffer(bufSize);

        for (int i = startIndex; i < endIndex; ++i) {
            if (i > startIndex) {
                buf.append(separator);
            }
            if (array[i] != null) {
                buf.append("\"");
                buf.append(array[i]);
                buf.append("\"");
            }
        }
        return buf.toString();
    }

}
