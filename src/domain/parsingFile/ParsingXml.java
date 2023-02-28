package domain.parsingFile;

import domain.model.Constants;
import domain.model.News;
import domain.model.Root;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ParsingXml implements Constants {

    public Root parsingXml() {
        Root root = null;

        Document doc;
        try {
            doc = buildDocument();
        } catch (Exception e) {
            System.out.println("Open parsing error" + e.toString());
            return null;
        }

        Node rootNode = doc.getFirstChild();
        NodeList rootChilds = rootNode.getChildNodes();

        String location = null;
        String name = null;
        Node newsNode = null;

        for (int i = 0; i < rootChilds.getLength(); i++) {
            if (rootChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            switch (rootChilds.item(i).getNodeName()) {
                case TAG_LOCATION: {
                    location = rootChilds.item(i).getTextContent();
                    break;
                }
                case TAG_NAME: {
                    name = rootChilds.item(i).getTextContent();
                    break;
                }
                case TAG_NEWS: {
                    newsNode = rootChilds.item(i);
                    break;
                }
            }
        }

        if (newsNode == null) {
            return null;
        }

        List<News> newsList = parsNews(newsNode);

        root.setLocation(location);
        root.setName(name);
        root.setNews(newsList);

        if (location == null) {
            return null;
        }
        System.out.println("Root " + root.toString());

        return root;
    }

    private List<News> parsNews(Node newsNode) {

        List<News> newsList = new ArrayList<>();
        NodeList newsChilds = newsNode.getChildNodes();
        for (int i = 0; i < newsChilds.getLength(); i++) {
            if (newsChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (!newsChilds.item(i).getNodeName().equals(TAG_ELEMENT)) {
                continue;
            }

            NodeList elementChilds = newsChilds.item(i).getChildNodes();

            News news = parsElement(newsChilds.item(i));
            newsList.add(news);
        }
        return newsList;
    }

    private News parsElement(Node elementNode) {

        String date = "";
        String description = "";
        int id = 0;
        String title = "";
        Boolean visible = true;
        List<String> keywords = null;

        NodeList elementChilds = elementNode.getChildNodes();
        for (int j = 0; j < elementChilds.getLength(); j++) {
            if (elementChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            switch (elementChilds.item(j).getNodeName()) {
                case TAG_DATE: {
                    date = elementChilds.item(j).getTextContent();
                    break;
                }
                case TAG_DESCRIPTION: {
                    description = elementChilds.item(j).getTextContent();
                    break;
                }
                case TAG_ID: {
                    id = Integer.valueOf(elementChilds.item(j).getTextContent());
                    break;
                }
                case TAG_TITLE: {
                    title = elementChilds.item(j).getTextContent();
                    break;
                }
                case TAG_VISIBLE: {
                    visible = Boolean.valueOf(elementChilds.item(j).getTextContent());
                    break;
                }
                case TAG_KEYWORDS: {
                    keywords = (List<String>) elementChilds.item(j);
                    break;
                }
            }
            if (keywords == null) {
                return null;
            }
        }
        News news = new News(date, description, keywords, id, title, visible);
        return news;
    }

    private Document buildDocument() throws Exception {
        File file = new File("it_news.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder().parse(file);
    }
}

