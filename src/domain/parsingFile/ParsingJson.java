package domain.parsingFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.model.Constants;
import domain.model.Root;

import java.io.FileReader;


public class ParsingJson implements Constants {

    public Root parsingJson() {

        ObjectMapper objectMapper = new ObjectMapper();

        try (FileReader reader = new FileReader("it_news.json")) {

            Root root = objectMapper.readValue(reader, Root.class);
            return root;
        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }

        return null;
    }
}