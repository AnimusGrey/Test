package domain;

import domain.fileDownloader.FileDownloaderJson;
import domain.fileDownloader.FileDownloaderXml;
import domain.parsingFile.ParsingJson;
import domain.parsingFile.ParsingXml;
import domain.model.Root;

public class Menu {

    FileDownloaderJson fileDownloaderJson = new FileDownloaderJson();
    FileDownloaderXml fileDownloaderXml = new FileDownloaderXml();
    ParsingXml parsingXml = new ParsingXml();
    ParsingJson parsingJson = new ParsingJson();

    Root root = null;

    public void menu() throws java.io.IOException {
        char choice, ignore;

        for (; ; ) {
            do {
                System.out.println("Выберите действие: ");
                System.out.println(" 1. Скачать Json");
                System.out.println(" 2. Скачать Xml");
                System.out.println(" 3. Parsing Json");
                System.out.println(" 4. Parsing Xml");
//                System.out.println(" 5. Вывести все новости по дате");
//                System.out.println(" 6. Поиск по keyword");
                System.out.print("Выберите (q-выход): ");
                choice = (char) System.in.read();
                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');
            } while (choice < '1' | choice > '6' & choice != 'q');
            if (choice == 'q') break;
            System.out.println("\n");

            switch (choice) {
                case '1':
                    fileDownloaderJson.fileDownloaderJson();
                    System.out.println("Файл Json выгружен!");
                case '2':
                    fileDownloaderXml.fileDownloaderXml();
                    System.out.println("Файл Xml выгружен!");
                    break;
                case '3':
                    root = parsingJson.parsingJson();
                    System.out.println(root);
                    break;
                case '4':
                    root = parsingXml.parsingXml();
                    break;
//                case '5':
//                    System.out.println("Цикл do-while:\n");
//                    System.out.println("do {");
//                    System.out.println("  инструкция;");
//                    System.out.println("} while (условие);");
//                    break;
//                case '6':
//                    System.out.println("Инструкция break:\n");
//                    System.out.println("break; или break метка;");
//                    break;
            }
            System.out.println();
        }
    }
}

