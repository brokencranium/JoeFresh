package com.vv.buildstuff.joefresh.util;

import com.google.gson.Gson;

import org.w3c.dom.Document;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by vvennava on 10/11/14.
 */
public class UtilityMethods {

    public static String fromStream(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append(newLine);
        }
        return out.toString();
    }

    public static void readXMLInputStream(InputStream inputStream) {

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = documentBuilder.parse(inputStream);
            DOMImplementationLS domImplementation = (DOMImplementationLS) doc.getImplementation();
            LSSerializer lsSerializer = domImplementation.createLSSerializer();
            System.out.println(lsSerializer.writeToString(doc));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String replaceSpaceWithCommas(String inp) {
        final Pattern replace = Pattern.compile("\\s+");
        final Matcher matcher = replace.matcher(inp);
        return matcher.replaceAll(",");
    }

    public static void readJSONInputStream(InputStream inputStream) {
        try {
            System.out.println(fromStream(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T readInputStream(Reader reader, Class<T> cls) {
//    public ResponsePlacesNearbySearch readInputStream(Reader reader, Class<T> cls) {
        Gson gson = new Gson();
//        return gson.fromJson(reader, ResponsePlacesNearbySearch.class);
         return gson.fromJson(reader, cls);

    }


}
