package repository;

import org.junit.jupiter.api.Test;

class AuthorRepositoryTest {
    @Test
    public void authorRepositoryCreationTest() {

    }
}
//        try {
//            FileInputStream fis = new FileInputStream(new File("/Users/michael/IdeaProjects/Libraru/Book3.xls"));
//            Workbook workbook = new HSSFWorkbook(fis);
//            Sheet sheet = workbook.getSheetAt(0);
//            Row row = sheet.createRow(sheet.getLastRowNum() + 1);
//            row.createCell(0).setCellValue("aaaaaa");
//            fis.close();
//            FileOutputStream out = new FileOutputStream(new File("/Users/michael/IdeaProjects/Libraru/Book3.xls"), true);
//            workbook.write(out);
//            workbook.close();
//            out.flush();
//            out.close();
//        } catch (
//                IOException e) {
//            e.printStackTrace();
//        }
//
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        // создание листа с названием "Просто лист"
//        HSSFSheet sheet = workbook.createSheet("Просто лист");
//
//        // заполняем список какими-то данными
//        //List<DataModel> dataList = fillData();
//
//        // счетчик для строк
//        int rowNum = 0;
//
//        // создаем подписи к столбцам (это будет первая строчка в листе Excel файла)
//        Row row = sheet.createRow(rowNum);
//        row.createCell(0).setCellValue("Имя");
//        row.createCell(1).setCellValue("Фамилия");
//        row.createCell(2).setCellValue("Город");
//        row.createCell(3).setCellValue("Зарплата");
//
//        // заполняем лист данными
////        for (DataModel dataModel : dataList) {
////            createSheetHeader(sheet, ++rowNum, dataModel);
////        }
//
//        // записываем созданный в памяти Excel документ в файл
//        try (FileOutputStream out = new FileOutputStream(new File("F:\\Apache POI Excel File.xls"))) {
//            workbook.write(out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Excel файл успешно создан!");
////    }
//
//    // заполнение строки (rowNum) определенного листа (sheet)
//    // данными  из dataModel созданного в памяти Excel файла
////    private static void createSheetHeader(HSSFSheet sheet, int rowNum, DataModel dataModel) {
////        Row row = sheet.createRow(rowNum);
////
////        row.createCell(0).setCellValue(dataModel.getName());
////        row.createCell(1).setCellValue(dataModel.getSurname());
////        row.createCell(2).setCellValue(dataModel.getCity());
////        row.createCell(3).setCellValue(dataModel.getSalary());
////    }
////
////    // заполняем список рандомными данными
////    // в реальных приложениях данные будут из БД или интернета
////    private static List<DataModel> fillData() {
////        List<DataModel> dataModels = new ArrayList<>();
////        dataModels.add(new DataModel("Howard", "Wolowitz", "Massachusetts", 90000.0));
////        dataModels.add(new DataModel("Leonard", "Hofstadter", "Massachusetts", 95000.0));
////        dataModels.add(new DataModel("Sheldon", "Cooper", "Massachusetts", 120000.0));
////
////        return dataModels;
////    }
////}
////    }
////}