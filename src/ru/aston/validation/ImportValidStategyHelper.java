//package ru.aston.validation;
//
//import ru.aston.importFile.Constants;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class ImportValidStategyHelper {
//    private static ImportValidStategyHelper instance;
//    private final Map<String, ValidStrategy> validStrategyMap;
//
//    public static ImportValidStategyHelper getInstance() {
//        if (instance == null) {
//            instance = new ImportValidStategyHelper();
//        }
//        return instance;
//    }
//    public ImportValidStategyHelper() {
//        this.validStrategyMap = new HashMap<>();
//        this.validStrategyMap.put(Constants.VALID_PERSON, new ValidPerson());
//        //this.validStrategyMap
//    }
//
//       public ValidPerson resolveValidStrategy(String strategyID) {
//        return (ValidPerson) this.validStrategyMap.get(strategyID);
//    }
//}
