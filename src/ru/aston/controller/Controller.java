package ru.aston.controller;

import ru.aston.importFile.ImportStrategyDownloads;
import ru.aston.importFile.ImportStrategyHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static Controller instance;
    private List<Object> listObject;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    private Controller() {
        this.listObject = new ArrayList<>();
    }


    public void addList(Integer typeObject, Integer typeImport, Integer sizeList)  {
        ImportStrategyDownloads importStrategyDownloads = ImportStrategyHelper.getInstance().resolveDownloadsStrategy(typeImport);
        try {
            listObject = importStrategyDownloads.store(typeObject, sizeList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}