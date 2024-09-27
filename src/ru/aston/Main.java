package ru.aston;
import org.apache.log4j.BasicConfigurator;

import ru.aston.view.View;

public class Main {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        View.getInstance().run();
    }
}
